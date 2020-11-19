package br.com.zup.fatura.transacao;

import br.com.zup.fatura.cartao.Cartao;
import br.com.zup.fatura.cartao.CartaoListenerResponse;
import br.com.zup.fatura.estabelecimento.Estabelecimento;
import br.com.zup.fatura.estabelecimento.EstabelecimentoListenerResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private @NotBlank String idTransacao;
    private @NotNull @Positive BigDecimal valor;
    private @NotNull @Embedded Estabelecimento estabelecimento;
    private @NotNull @Embedded Cartao cartao;
    private @NotNull LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(@NotBlank String idTransacao, @NotNull @Positive BigDecimal valor,
                     @NotNull Estabelecimento estabelecimento, @NotNull Cartao cartao,
                     @NotNull LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }
}
