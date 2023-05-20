package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.stereotype.Component;

@Component("ValidadorMotivoDoCancelamento")
public class ValidadorMotivoDoCancelamento implements ValidadorCancelamentoDeConsultas {
    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        if (!dados.motivo().equals("paciente desistiu") && !dados.motivo().equals("médico cancelou") && !dados.motivo().equals("outros")) {
            throw new ValidacaoException("É obrigatório informar o motivo do cancelamento da consulta, dentre as opções: paciente desistiu, médico cancelou ou outros;");
        }
    }
}
