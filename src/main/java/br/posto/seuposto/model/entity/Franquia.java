package br.posto.seuposto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "franquia")
public class Franquia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(nullable = false)
    @ManyToOne
    private Socio socio;

    @ManyToOne
    private Posto posto;

    @NotBlank(message = "O nome da franquia é obrigatória")
    @Size(min = 10, max = 100, message = "O nome deve ter entre 10 e 100 caracteres")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

}