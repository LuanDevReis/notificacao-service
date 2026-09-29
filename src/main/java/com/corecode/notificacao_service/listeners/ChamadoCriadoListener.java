package com.corecode.notificacao_service.listeners;

import com.corecode.notificacao_service.dto.ChamadoCriadoEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ChamadoCriadoListener {

    private static final Logger logger = LoggerFactory.getLogger(ChamadoCriadoListener.class);

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void consumirChamadoCriado(ChamadoCriadoEventDTO event) {
        logger.info("Evento CHAMADO_CRIADO recebido no notificacao-service");
        logger.info("Chamado ID: {}", event.getChamadoId());
        logger.info("Título: {}", event.getTitulo());
        logger.info("Cliente: {}", event.getClienteEmail());
        logger.info("Mensagem: {}", event.getMensagem());
    }
}
