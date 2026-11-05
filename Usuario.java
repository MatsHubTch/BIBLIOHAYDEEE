public class Usuario {

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos = 3;
    private Integer emprestimosAtivos;

    public Usuario(String nomeDigitado, String matriculaDigitada, String tipoDigitado, Integer limiteDigitado) {


        if (nomeDigitado == null || nomeDigitado.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome nao pode ser vazio!");
        }


        if (tipoDigitado == null) {
            throw new IllegalArgumentException("O tipo nao pode ser nulo! Use ALUNO ou PROFESSOR.");
        }
        String tipoMaiusculo = tipoDigitado.trim().toUpperCase();
        if (!tipoMaiusculo.equals("ALUNO") && !tipoMaiusculo.equals("PROFESSOR")) {
            throw new IllegalArgumentException("Tipo invalido! Use somente ALUNO ou PROFESSOR.");
        }


        nome = nomeDigitado.trim();
        matricula = matriculaDigitada;
        tipo = tipoMaiusculo;
        limiteEmprestimos = limiteDigitado;


        emprestimosAtivos = 0;
    }



    public boolean podeEmprestar() {
        return emprestimosAtivos < limiteEmprestimos;
    }


    public void registrarEmprestimo() {
        if (!podeEmprestar()) {
            throw new IllegalStateException(
                    "Limite de " + limiteEmprestimos + " empréstimos atingido.");
        }
        emprestimosAtivos++;
    }


    public void registrarDevolucao() {
        if (emprestimosAtivos > 0) {
            emprestimosAtivos--;
        }
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
        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome nao pode ser vazio!");
        }
        nome = novoNome.trim();
    }

    public void setTipo(String novoTipo) {
        if (novoTipo == null) {
            throw new IllegalArgumentException("O tipo nao pode ser nulo! Use ALUNO ou PROFESSOR.");
        }
        String tipoMaiusculo = novoTipo.trim().toUpperCase();
        if (!tipoMaiusculo.equals("ALUNO") && !tipoMaiusculo.equals("PROFESSOR")) {
            throw new IllegalArgumentException("Tipo invalido! Use somente ALUNO ou PROFESSOR.");
        }
        tipo = tipoMaiusculo;
    }



}