import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private Sala sala;
    private LocalDate data;
    private LocalTime horario;

    public Reserva(Sala sala, String data, String horario) {
        this.sala = sala;
        this.sala.setDisponibilidade(false);  // Desabilita a sala para outras reservas
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.horario = LocalTime.parse(horario, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getData() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setData(String data) {
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getHorario() {
        return horario.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void setHorario(String horario) {
        this.horario = LocalTime.parse(horario, DateTimeFormatter.ofPattern("HH:mm"));
    }

}

