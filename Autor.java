public class Autor {
    private String nome;
    private String nacionalidade;
    private int anoDeNascimento;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNacionalidade  (String nacionalidade){
        this.nacionalidade =  nacionalidade;
    }
    public void setAnoDeNascimento  (int anoDeNascimento){
        this.anoDeNascimento =  anoDeNascimento;
    }
    public String getNacionalidade(){
        return this.nacionalidade;
    }
    public int getAnoDeNascimento (){
        return this.anoDeNascimento;
    }

}
