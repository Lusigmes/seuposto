package br.posto.seuposto.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.posto.seuposto.model.entity.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoa")
@Data @NoArgsConstructor @AllArgsConstructor
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 200, message = "O nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date dataNascimento;

    @NotBlank(message = "Digite um e-mail válido")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 digitos")
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotNull(message = "O sexo é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name= "sexo", nullable = false)
    private Sexo sexo;

    @JsonBackReference("proprietario")
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Proprietario proprietario;

    @JsonBackReference("cliente")
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cliente cliente;

    @JsonBackReference("socio")
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Socio socio;
}
