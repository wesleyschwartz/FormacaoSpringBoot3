package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    @PostMapping
    void cadastro(@RequestBody DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    Page<DadosListagemPaciente> listar(@PageableDefault(sort = {"nome"}) Pageable pageable) {
        return pacienteRepository.findByAtivoTrue(pageable).map(DadosListagemPaciente::new);
    }

    @Transactional
    @PutMapping
    void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformocoes(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    void deixarPacienteInativo(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.tornarInativo();
    }
}
