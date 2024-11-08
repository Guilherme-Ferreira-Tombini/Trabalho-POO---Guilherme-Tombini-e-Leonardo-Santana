public class Sala {
    private String identificacao;
    private int capacidade;
    private boolean disponibilidade;

    Sala(String identificacao, int capacidade, boolean disponibilidade) {
        this.identificacao = identificacao;
        this.capacidade = capacidade;
        this.disponibilidade = disponibilidade;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
