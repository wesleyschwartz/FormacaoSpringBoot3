package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder) {
        var medico = (new Medico(dados));
        medicoRepository.save(medico);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhementoMedico(medico));
    }

    @GetMapping
    ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    ResponseEntity<DadosDetalhementoMedico> listar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        var dadosDetalhementoMedico = new DadosDetalhementoMedico(medico);
        return ResponseEntity.ok(dadosDetalhementoMedico);
    }


    @Transactional
    @PutMapping
    ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhementoMedico(medico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    ResponseEntity deletar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.tornarInativo();
        return ResponseEntity.noContent().build();
    }
}
