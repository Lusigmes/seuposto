package br.posto.seuposto.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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


@Entity
@Table(name = "franquia")
@Data @NoArgsConstructor @AllArgsConstructor
public class Franquia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference 
    private Socio socio;

    @ManyToOne
    @JsonBackReference 
    private Posto posto;

    @NotBlank(message = "O nome da franquia é obrigatória")
    @Size(min = 10, max = 100, message = "O nome deve ter entre 10 e 100 caracteres")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

}
