public class Contato {
    
    Pessoa pessoa;
    Telefone telefone;
    Email email;

    public Contato(Pessoa p, Telefone t, Email e){
        this.pessoa = p;
        this.telefone = t;
        this.email = e;
    }

    public Pessoa getPessoa(){
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public Telefone getTelefone(){
        return telefone;
    }

    public void setTelefone(Telefone telefone){
        this.telefone = telefone;
    }

    public Email getEmail(){
        return email;
    }

    public void setEmail(Email email){
        this.email = email;
    }
    
}
