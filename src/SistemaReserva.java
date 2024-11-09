import java.util.ArrayList;

public class SistemaReserva {
    private ArrayList<Sala> salas;
    private ArrayList<Reserva> reservas;

    SistemaReserva() {
        this.salas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void addSala(Sala sala) {
        salas.add(sala);
    }

    public ArrayList<Sala> listarSalasDisponiveis() {
        ArrayList<Sala> disponiveis = new ArrayList<>();
        for (Sala sala : salas) {
            if (sala.isDisponibilidade()) {
                disponiveis.add(sala);
            }
        }
        return disponiveis;
    }

    public ArrayList<Reserva> historicoReservas() {
        return reservas;
    }

}
