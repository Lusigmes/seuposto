package br.posto.seuposto.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.posto.seuposto.model.entity.enums.EstadosBrasil;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "posto")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Posto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonManagedReference
    private Proprietario proprietario;

    @NotBlank(message = "O nome do posto é obrigatório")
    @Size(min = 10, max = 100, message = "O nome deve ter entre 10 e 100 caracteres")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    private String rua;

    private int numero;

    private String bairro;
    
    @NotNull(message = "O estado é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name= "estado", nullable = false)
    private EstadosBrasil estado;

    @JsonManagedReference //se aqui for back reference e do outro lado managed reference, o json nao exibe essa propriedade
    @OneToMany(mappedBy = "posto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Franquia> franquias_associadas;
/* 

    public enum EstadoBrasil {
        ACRE("Acre"),
        ALAGOAS("Alagoas"),
        AMAPA("Amapá"),
        AMAZONAS("Amazonas"),
        BAHIA("Bahia"),
        CEARA("Ceará"),
        DISTRITO_FEDERAL("Distrito Federal"),
        ESPIRITO_SANTO("Espírito Santo"),
        GOIAS("Goiás"),
        MARANHAO("Maranhão"),
        MATO_GROSSO("Mato Grosso"),
        MATO_GROSSO_DO_SUL("Mato Grosso do Sul"),
        MINAS_GERAIS("Minas Gerais"),
        PARA("Pará"),
        PARAIBA("Paraíba"),
        PARANA("Paraná"),
        PERNAMBUCO("Pernambuco"),
        PIAUI("Piauí"),
        RIO_DE_JANEIRO("Rio de Janeiro"),
        RIO_GRANDE_DO_NORTE("Rio Grande do Norte"),
        RIO_GRANDE_DO_SUL("Rio Grande do Sul"),
        RONDONIA("Rondônia"),
        RORAIMA("Roraima"),
        SANTA_CATARINA("Santa Catarina"),
        SAO_PAULO("São Paulo"),
        SERGIPE("Sergipe"),
        TOCANTINS("Tocantins");

        private final String nome;

        EstadoBrasil(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    } */


}
