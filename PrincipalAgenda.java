import java.util.Scanner;

public class PrincipalAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner tec = new Scanner(System.in);  
        
        int z = 1;
        while(z!= 0){
            System.out.println("\nMenu");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar todos contatos");
            System.out.println("3 - Procurar contato");
            System.out.println("4 - Editar contato");
            System.out.println("5 - Remover contato");
            System.out.println("Insira 0 para parar.");
            System.out.print("\nDigite sua opção: ");
            int x = tec.nextInt();
            switch(x){
                case 1:
                    agenda.inserirContato();
                break;

                case 2:
                    agenda.listarTudo();
                break;

                case 3:
                    System.out.print("Insira o nome: ");
                    String nome = tec.next();
                    agenda.buscaPessoa(nome);
                break;

                case 4:
                    System.out.println("Digite o nome da pessoa");
                    String editarnome = tec.next();
                    agenda.editar(editarnome);
                break;

                case 5:
                    System.out.println("Para remover digite o nome");
                    String removernome = tec.next();
                    agenda.removerContato(removernome);
                break;
            }      
            z = x;
        }
    }
}