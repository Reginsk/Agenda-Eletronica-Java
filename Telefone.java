public class Telefone {
    
    private String numerotel;
    private String rotulotel;

    public Telefone(){
        this.numerotel = "";
        this.rotulotel = "";
    }

    public String getNumeroTel(){
        return numerotel;
    }

    public void setNumeroTel(String numerotel){
       this.numerotel = numerotel; 
    }

    public String getRotuloTel(){
        return rotulotel;
    }

    public void setRotuloTel(String rotulotel){
        this.rotulotel = rotulotel;
    }

}
