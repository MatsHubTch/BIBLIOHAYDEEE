```java
package br.escola.bibliohaydee.model;

public class Usuario {

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public Usuario(String nomeInformado, String matriculaInformada,
                   String tipoInformado, Integer limiteInformado) {

        if (nomeInformado == null || nomeInformado.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (tipoInformado == null ||
                (!tipoInformado.equalsIgnoreCase("ALUNO")
                && !tipoInformado.equalsIgnoreCase("PROFESSOR"))) {
            throw new IllegalArgumentException(
                    "O tipo deve ser ALUNO ou PROFESSOR.");
        }

        if (limiteInformado == null || limiteInformado < 0) {
            throw new IllegalArgumentException(
                    "O limite de empréstimos não pode ser negativo.");
        }

        nome = nomeInformado.trim();
        matricula = matriculaInformada;
        tipo = tipoInformado.toUpperCase();
        limiteEmprestimos = limiteInformado;
        emprestimosAtivos = 0;
    }


    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }


    public void setNome(String novoNome) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            nome = novoNome.trim();
        } else {
            System.out.println("Erro: o nome não pode ser vazio.");
        }
    }

    public void setTipo(String novoTipo) {
        if (novoTipo != null &&
                (novoTipo.equalsIgnoreCase("ALUNO")
                || novoTipo.equalsIgnoreCase("PROFESSOR"))) {
            tipo = novoTipo.toUpperCase();
        } else {
            System.out.println("Erro: tipo inválido.");
        }
    }

    public void setLimiteEmprestimos(Integer novoLimite) {
        if (novoLimite != null && novoLimite >= 0) {
            limiteEmprestimos = novoLimite;
        } else {
            System.out.println("Erro: limite inválido.");
        }
    }
}
```
