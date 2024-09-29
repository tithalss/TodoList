import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Service {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        tarefas.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    public void listarTarefasPorCategoria(String categoria) {
        tarefas.stream().filter(t -> t.getCategoria().equalsIgnoreCase(categoria)).forEach(System.out::println);
    }

    public void listarTarefasPorPrioridade(int prioridade) {
        tarefas.stream().filter(t -> t.getPrioridade() == prioridade).forEach(System.out::println);
    }

    public void listarTarefasPorStatus(Tarefa.Status status) {
        tarefas.stream().filter(t -> t.getStatus() == status).forEach(System.out::println);
    }

    public void excluirTarefa(String nome) {
        boolean removido = tarefas.removeIf(t -> t.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Tarefa \"" + nome + "\" excluída com sucesso.");
        } else {
            System.out.println("Tarefa com o nome \"" + nome + "\" não encontrada.");
        }
    }
}