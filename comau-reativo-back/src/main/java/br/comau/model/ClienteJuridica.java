package br.comau.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Getter
@Setter
@Document(collection = "clientejuridica")
public class ClienteJuridica {

    @Id
    String id;
    String razaoSocial;
    String nomeFantasia;
    String cnpj;
    TipoCliente tipo;
    String endereco;
    String telefone;
    String email;
    String obs;
    String status;
    String logo;

}
