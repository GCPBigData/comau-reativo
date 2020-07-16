package br.comau.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Getter
@Setter
@Document(collection = "clientefisica")
public class ClienteFisica {
    private static final long serialVersionUID = 1L;

    @Id
    String id;
    String nome;
    String cpf;
    String endereco;
    String telefone;
    String email;
    String status;
    String empresa;
    Perfil perfil;
    TipoCliente tipoCliente;
    String dataCadastro;
    String vistoDataVencimento;

    //LocalDateTime dataCadastro = LocalDateTime.now();
    //LocalDateTime vistoDataVencimento = LocalDateTime.now().plusMonths(3); //adiciona mais 3 meses


}