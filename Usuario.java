
public class Usuario {


    private String nome;
    private String matricula;
    private String tipo;                 // so pode ser aluno ou professor
    private Integer limiteEmprestimos;   // quanidadw de livros q pode pegar
    private Integer emprestimosAtivos;   // mostra quantos tem, começa em 0.

    public Usuario(String nomeDigitado, String matriculaDigitada, String tipoDigitado, Integer limiteDigitado) {

        // aq confere o nome, n pode ser NULL.
        if (nomeDigitado == null || nomeDigitado.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome nao pode ser vazio!");
        }

        // confere o tipo; só aluno ou professor
        if (tipoDigitado == null) {
            throw new IllegalArgumentException("O tipo nao pode ser nulo! Use ALUNO ou PROFESSOR.");
        }
        String tipoMaiusculo = tipoDigitado.trim().toUpperCase();
        if (!tipoMaiusculo.equals("ALUNO") && !tipoMaiusculo.equals("PROFESSOR")) {
            throw new IllegalArgumentException("Tipo invalido! Use somente ALUNO ou PROFESSOR.");
        }

        // se passou nos testes de cima, guarda os dados (teoricamente)
        nome = nomeDigitado.trim();
        matricula = matriculaDigitada;
        tipo = tipoMaiusculo;
        limiteEmprestimos = limiteDigitado;

        // todo usuario novo comeca com zero emprestimos
        emprestimosAtivos = 0;
    }

    // ---------- GETTERS (pra poder LER os dados) ---------- (ia que fez, sla que diabo é isso.)
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

    // ---------- SETTERS (so os que fazem sentido, e com validacao) ---------- (ia tbm)
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

    // de acordo com a ia ela n fez o setter de emprestimosAtivos de proposito. de acordo com ela vai ser controlado pelas regras de emprestimo nas proximas semanas

}
