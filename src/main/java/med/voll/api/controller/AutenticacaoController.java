package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.DadoAutenticacao;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.DadosTokenJWT;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadoAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.user(), dados.password());
        var authenticate = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((User) authenticate.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
