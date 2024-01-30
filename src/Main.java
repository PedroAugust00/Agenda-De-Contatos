import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    static List<Contato> contatos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("""
                    ##################
                    ##### AGENDA #####
                    ##################""");
            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Editar Contato");
            System.out.println("4 - Contar Contatos");
            System.out.println("5 - Listar Contatos");
            System.out.println("6 - Salvar Contatos");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    AdicionarContato();
                    break;
                case 2:
                    RemoverContato();
                    break;
                case 3:
                    EditarContato();
                    break;
                case 4:
                    ContarContatos();
                    break;
                case 5:
                    ListarContatos();
                    break;
                case 6:
                    SalvarContatos();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void AdicionarContato() {
        System.out.println("Digite o nome do contato:");
        String nome = scanner.next();
        System.out.println("Digite o sobrenome do contato:");
        String sobreNome = scanner.next();
        System.out.println("Digite o ID do contato:");
        long id = scanner.nextLong();
        System.out.println("Digite o DDD do contato:");
        String ddd = scanner.next();
        System.out.println("Digite o numero do contato:");
        long numeroContato = scanner.nextLong();
        Contato novoContato = new Contato(id, nome, sobreNome, ddd, numeroContato);
        contatos.add(novoContato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public static void RemoverContato() {
        System.out.println("Digite o ID do contato a ser removido:");
        long id = scanner.nextLong();
        contatos.removeIf(contato -> contato.getId() == id);
        System.out.println("Contato removido com sucesso!");
    }

    public static void EditarContato() {
        System.out.println("Digite o ID do contato a ser editado:");
        long id = scanner.nextLong();
        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                System.out.println("Digite o novo nome:");
                String novoNome = scanner.next();
                System.out.println("Digite o novo sobrenome:");
                String novoSobrenome = scanner.next();
                contato.setNome(novoNome);
                contato.setSobrenome(novoSobrenome);
                System.out.println("Contato editado com sucesso!");
                break;
            }
        }
    }

    public static void ContarContatos() {
        int totalContatos = contatos.size();
        System.out.println(STR."Você tem \{totalContatos} contatos salvos.");
    }

    public static void ListarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Não há contatos salvos.");
        } else {
            System.out.println("Aqui estão todos os seus contatos:");
            for (Contato contato : contatos) {
                System.out.println(STR."ID: \{contato.getId()}, Nome: \{contato.getNome()}, Sobrenome: \{contato.getSobrenome()} ,DDD: \{contato.getDdd()} ,numero: \{contato.getNumeroContato()}");
            }
        }
    }
    public static void SalvarContatos() {
        try {
            PrintWriter writer = new PrintWriter("contatos.txt", StandardCharsets.UTF_8);
            for (Contato contato : contatos) {
                writer.println(STR."ID: \{contato.getId()}, Nome: \{contato.getNome()}, Sobrenome: \{contato.getSobrenome()}, ddd: \{contato.getDdd()}, numero: \{contato.getNumeroContato()}");
            }
            writer.close();
            System.out.println("Contatos salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os contatos.");
        }
    }
}


class Contato {
    long id;
    String nome;
    String sobrenome;
    String ddd;
    long numeroContato;

    public Contato(long id, String nome, String sobrenome, String ddd, long numeroContato) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ddd = ddd;
        this.numeroContato = numeroContato;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDdd(){
        return ddd;
    }
    public void setDdd (String ddd){
        this.ddd = ddd;
    }
    public long getNumeroContato(){
        return numeroContato;
    }
    public void setNumeroContato( long numeroContato){
        this.numeroContato = numeroContato;
    }


}






