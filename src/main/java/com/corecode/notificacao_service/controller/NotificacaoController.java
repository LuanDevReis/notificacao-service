package com.corecode.notificacao_service.controller;

import com.corecode.notificacao_service.dto.NotificacaoRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @PostMapping
    public ResponseEntity<Void> receberNotificacao(@Valid @RequestBody NotificacaoRequestDTO dto) {

        System.out.println("Nova notificação recebida:");
        System.out.println("Tipo: " + dto.getTipo());
        System.out.println("Destinatário: " + dto.getDestinatario());
        System.out.println("Mensagem: " + dto.getMensagem());

        return ResponseEntity.accepted().build();
    }
}
