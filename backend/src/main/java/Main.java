import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Tarefa t1 = new Tarefa("Casar", "Botar aliança no dedo da mulher", LocalDate.of(2026,12,11), 1, "Pessoal", Tarefa.Status.TODO);

        Service tarefaService = new Service();
        tarefaService.adicionarTarefa(t1);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Listar por Categoria");
            System.out.println("4. Listar por Prioridade");
            System.out.println("5. Listar por Status");
            System.out.println("6. Excluir tarefa");
            System.out.println("0. Sair");

            int input = validaNumero();

            switch (input) {
                case 1:
                    Tarefa tarefa = leitorTarefa();
                    tarefaService.adicionarTarefa(tarefa);
                    break;

                case 2:
                    System.out.println("Tarefas:");
                    tarefaService.listarTarefas();
                    break;

                case 3:
                    System.out.println("Categoria:");
                    String categoria = scanner.nextLine();
                    tarefaService.listarTarefasPorCategoria(categoria);
                    break;

                case 4:
                    int prioridade = validaPrioridade();
                    tarefaService.listarTarefasPorPrioridade(prioridade);
                    break;

                case 5:
                    Tarefa.Status status = validaStatus();
                    tarefaService.listarTarefasPorStatus(status);
                    break;

                case 6:
                    System.out.println("Nome da Tarefa a ser Excluída:");
                    String nomeExcluir = scanner.nextLine();
                    tarefaService.excluirTarefa(nomeExcluir);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static int validaNumero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }
    }

    private static LocalDate validaData() {
        while (true) {
            System.out.println("Data de Término (YYYY-MM-DD):");
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Por favor, tente novamente.");
            }
        }
    }

    private static int validaPrioridade() {
        while (true) {
            System.out.println("Prioridade (1-5):");
            int prioridade = validaNumero();
            if (prioridade >= 1 && prioridade <= 5) {
                return prioridade;
            } else {
                System.out.println("Prioridade inválida. Deve estar entre 1 e 5.");
            }
        }
    }

    private static Tarefa.Status validaStatus() {
        while (true) {
            System.out.println("Status (TODO, DOING, DONE):");
            try {
                return Tarefa.Status.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Status inválido. Utilize TODO, DOING ou DONE.");
            }
        }
    }

    private static Tarefa leitorTarefa() {
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Descrição:");
        String descricao = scanner.nextLine();
        LocalDate dataTermino = validaData();
        int prioridade = validaPrioridade();
        System.out.println("Categoria:");
        String categoria = scanner.nextLine();
        Tarefa.Status status = validaStatus();

        return new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status);
    }
}