import java.time.LocalDate;

public class Tarefa {
    private String nome;
    private String descricao;
    private LocalDate dataTermino;
    private int prioridade;
    private String categoria;
    private Status status;

    public enum Status {
        TODO, DOING, DONE
    }

    public Tarefa(String nome, String descricao, LocalDate dataTermino, int prioridade, String categoria, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return String.format("Nome: %s, Descrição: %s, Data de Término: %s, Prioridade: %d, Categoria: %s, Status: %s",
                nome, descricao, dataTermino, prioridade, categoria, status);
    }
}