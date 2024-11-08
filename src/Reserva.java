public class Reserva {
    private Sala sala;
    private String data;
    private String horario;

    public Reserva(Sala sala, String data, String horario) {
        this.sala = sala;
        this.data = data;
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
