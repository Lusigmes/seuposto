# seuposto

## Aplicação desenvolvida em Java + Spring Framework + JPA

## Aplicação voltada para ambiente de posto de gasolina, relacionando clientes, proprietários, sócios e franquias.

### Montei o esqueleto do código mas é necessário finalizar e otimizar queries e consultas jpql.
### Back-end sem implementação de testes ( Necessário estudo aprofundado )

	

```mermaid
classDiagram

  class Pessoa{
    -Id: Integer
    -Nome: String
    -DataNascimento: Date
    -Cpf: String
    -Sexo: Sexo
  }
  class Cliente {
    -Id: Integer
    -Numero_Cartap: Long
  }

  class Proprietario{
    -Id: Integer
    -Cnpj: String
  }
  class Socio{
    -Id: Integer
    -Quota_participaçao: Float
  }
  class Posto{
    -Id: Integer
    -Nome: String
    -Telefone: String
    -Rua: String
    -Numero: Integer
    -Bairro: String
    -Estado: EstadosBrasil
  }

  class Franquia{
    -Id: Integer
    -Nome: String
    -Telefone: String
  }




  Pessoa "1" -- "1..*" Cliente
  Pessoa "1" -- "1" Proprietario
  Pessoa "1" -- "1..*" Socio
  Proprietario "1..*" -- "1" Posto
  Proprietario "1..*" -- "1" Posto
  Posto "1*" -- "1..*" Franquia
  
  
```
