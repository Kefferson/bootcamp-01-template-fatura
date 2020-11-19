package br.com.zup.fatura.cartao;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Cartao {
    private @NotBlank String idCartao;
    private @NotBlank String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotBlank String idCartao, @NotBlank @Email String email) {
        this.idCartao = idCartao;
        this.email = email;
    }
}
