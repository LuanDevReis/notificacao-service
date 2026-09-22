package com.corecode.notificacao_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class NotificacaoRequestDTO {

    @NotBlank(message = "O tipo da notificação é obrigatório")
    private String tipo;

    @NotBlank(message = "O destinatário é obrigatório")
    @Email(message = "E-mail inválido")
    private String destinatario;

    @NotBlank(message = "A mensagem é obrigatória")
    private String mensagem;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
