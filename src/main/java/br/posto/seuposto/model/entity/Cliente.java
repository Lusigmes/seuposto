package br.posto.seuposto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    
    @NotBlank(message = "O cartão é obrigatório")
    @Size(min = 16, max = 16, message = "O nome deve conter 16 caracteres")
    @Column(nullable = false)
    private long numero_cartao;
    
}
