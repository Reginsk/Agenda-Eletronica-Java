import java.time.LocalDate;

public class Pessoa {
    
    private String nome;
    private String sobrenome;
    private String datanascimento;

    public Pessoa(){
        this.nome = "";
        this.sobrenome = "";
        this.datanascimento = "";
    }

    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento(){
        return datanascimento;
    }

    public void setDataNascimento(String datanascimento){
        this.datanascimento = datanascimento;
    }

}
