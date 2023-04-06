package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    @PostMapping
    ResponseEntity cadastro(@RequestBody DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(dados);
        pacienteRepository.save(new Paciente(dados));
        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhementoPaciente(paciente));
    }

    @GetMapping
    ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(sort = {"nome"}) Pageable pageable) {
        var page = pacienteRepository.findByAtivoTrue(pageable).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    ResponseEntity<DadosDetalhementoPaciente> listar(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        var dadosDetalhementoPaciente = new DadosDetalhementoPaciente(paciente);
        return ResponseEntity.ok(dadosDetalhementoPaciente);
    }

    @Transactional
    @PutMapping
    ResponseEntity<DadosDetalhementoPaciente> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformocoes(dados);
        return ResponseEntity.ok(new DadosDetalhementoPaciente(paciente));
    }

    @Transactional
    @DeleteMapping("/{id}")
    ResponseEntity deixarPacienteInativo(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.tornarInativo();
        return ResponseEntity.noContent().build();
    }
}
