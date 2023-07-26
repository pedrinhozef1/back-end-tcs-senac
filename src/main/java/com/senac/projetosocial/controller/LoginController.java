package com.senac.projetosocial.controller;

import com.senac.projetosocial.representation.LoginRepresentation;
import com.senac.projetosocial.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/")
    public ResponseEntity<LoginRepresentation.LoginResponse> login(@RequestBody LoginRepresentation.Login login){
        LoginRepresentation.LoginResponse response = this.loginService.login(login);

        log.info("Usuario {} autenticado", response.getUsuario());
        log.info("Token: {}", response.getToken());

        return ResponseEntity.ok(response);
    }
}
