import java.util.ArrayList;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contato> contatos;   
    private String emailER = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    public Agenda(){
        this.contatos = new ArrayList();
    }

    public void inserirContato(){  
        Pessoa p1 = new Pessoa();
        Email p1e = new Email();
        Telefone p1t = new Telefone();
        Scanner input = new Scanner(System.in);  
           
        System.out.println("Digite o nome:");  
        p1.setNome(input.nextLine());  
           
        System.out.println("Digite o sobrenome:");  
        p1.setSobrenome(input.nextLine());     
        
        System.out.println("Digite a data de nascimento (dd/mm/yyyy)");
        p1.setDataNascimento(input.nextLine());

        System.out.println("Digite o email");
        p1e.setEmail(input.nextLine());

        System.out.println("Digite o rótulo do email");
        p1e.setRotuloEmail(input.nextLine());

        System.out.println("Digite o telefone (## #####-####)");
        p1t.setNumeroTel(input.nextLine());

        System.out.println("Digite o rótulo do telefone");
        p1t.setRotuloTel(input.nextLine());

        Contato ctt1 = new Contato(p1,p1t,p1e);
        this.contatos.add(ctt1);        
     }

    public void removerContato(String c){        
        for(int i=0;i<this.contatos.size();i++){

            Contato contato=this.contatos.get(i);

            if(contato.pessoa.getNome().equals(c)){
                contatos.remove(i);
            }
        }
    }

    public void validaEmail(String e){
        System.out.println("Email válido: " + e.matches(emailER));
    }

    public String formataTelefone(String mascara, String valor){
        MaskFormatter mask = null;
        String resultado = "";
        try {
            mask = new MaskFormatter(mascara);
            mask.setValueContainsLiteralCharacters(false);
            mask.setPlaceholderCharacter('_');
            resultado = mask.valueToString(valor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void mostraTelefone(String t){
        Agenda p = new Agenda();
        System.out.println(p.formataTelefone("(##) #####-####", t));
    }

    public void formataData(String data){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataJ = LocalDate.parse(data, formato); 
        System.out.println(formato.format(dataJ)); 
    }

    public void listarTudo(){
        for(Contato guardapessoa: contatos){
            String nomePessoa = guardapessoa.getPessoa().getNome();
            String sobrenomePessoa = guardapessoa.getPessoa().getSobrenome();
            String nascimentoPessoa = guardapessoa.getPessoa().getDataNascimento();
            String telefonePessoa = guardapessoa.getTelefone().getNumeroTel();
            String rotuloTelelefone = guardapessoa.getTelefone().getRotuloTel();
            String emailPessoa = guardapessoa.getEmail().getEmail();
            String rotuloEmail = guardapessoa.getEmail().getRotuloEmail();
            
            System.out.println("Nome: " + nomePessoa);
            System.out.println("Sobrenome: " + sobrenomePessoa);
            System.out.print("Data nasc.: ");
            formataData(nascimentoPessoa);
            System.out.print("Nº Telefone: "); 
            mostraTelefone(telefonePessoa);
            System.out.println("Rótulo tel.: " + rotuloTelelefone);
            System.out.println("Email: " + emailPessoa);
            validaEmail(emailPessoa);
            System.out.println("Rótulo Email: " + rotuloEmail);
        }
    }

    public Contato procurarContato(ArrayList<Contato> contatos, String nome) {
        for(Contato contato : contatos) {
            if(contato.pessoa.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscaPessoa(String nome){
        Contato pessoa = procurarContato(contatos, nome);
        if(pessoa != null) {
            System.out.println("\nResultado da busca\nNome: " + pessoa.pessoa.getNome() + "\nSobrenome: " + pessoa.pessoa.getSobrenome());
            System.out.print("Data de Nasc.: ");
            formataData(pessoa.pessoa.getDataNascimento());
            System.out.print("Telefone: "); 
            mostraTelefone(pessoa.telefone.getNumeroTel());
            System.out.print("Rótulo Tel: " + pessoa.telefone.getRotuloTel() + "\nEmail: " + pessoa.email.getEmail() + "\n");
            validaEmail(pessoa.email.getEmail());
            System.out.println("Rótulo email: " + pessoa.email.getRotuloEmail());
        } else{
            System.out.println("Nome inválido");
        }
        return pessoa;
    }

    public Contato editar(String nome) {
        Contato pessoa = procurarContato(contatos, nome);
        Scanner tec = new Scanner(System.in); 
        for (Contato c : contatos) {
            if(pessoa.pessoa.getNome().equals(nome)){
                System.out.println("Digite o novo nome:");
                String editarnome = tec.nextLine();
                c.pessoa.setNome(editarnome);

                System.out.println("Digite o novo sobrenome: ");
                String editarsobrenome = tec.nextLine();
                c.pessoa.setSobrenome(editarsobrenome);

                System.out.println("Digite a nova data de nasc.: (dd/mm/yyyy)");
                String editardata = tec.nextLine();
                c.pessoa.setDataNascimento(editardata);

                System.out.println("Digite o novo tel.: (## #####-####)");
                String editartel = tec.nextLine();
                c.telefone.setNumeroTel(editartel);

                System.out.println("Digite o novo rotulo tel.:");
                String editarotulotel = tec.nextLine();
                c.telefone.setRotuloTel(editarotulotel);

                System.out.println("Digite o novo email:");
                String editaremail = tec.nextLine();
                c.email.setEmail(editaremail);

                System.out.println("Digite o novo rotulo de email");
                String editarrotuloemail = tec.nextLine();
                c.email.setRotuloEmail(editarrotuloemail);
                break;
             } else{
                 System.out.println("Nome inválido.");
             }
        }

        return pessoa;
    }
}
    


