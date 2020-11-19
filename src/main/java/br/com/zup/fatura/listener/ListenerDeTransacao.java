package br.com.zup.fatura.listener;

import br.com.zup.fatura.transacao.Transacao;
import br.com.zup.fatura.transacao.TransacaoListenerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
public class ListenerDeTransacao {

    private EntityManager manager;
    private Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    public ListenerDeTransacao(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoListenerResponse transacaoListenerResponse) {
        Transacao transacao = transacaoListenerResponse.toModel();
        manager.persist(transacao);
        logger.info("Transação salva. ID: " + transacao.getId());
    }
}
