import java.util.ArrayList;

public class SistemaReserva {
    private ArrayList<Sala> salas;
    private ArrayList<Reserva> reservas;

    public SistemaReserva() {
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

    public Reserva reservarSala(Sala sala, String data, String periodo) {
        // Validar o período
        if (!periodo.equalsIgnoreCase("matutino") && !periodo.equalsIgnoreCase("vespertino")) {
            throw new IllegalArgumentException("Erro: O horário deve ser 'matutino' ou 'vespertino'.");
        }

        // Verificar conflitos de reserva
        for (Reserva reserva : reservas) {
            if (reserva.getSala().equals(sala) && reserva.getData().equals(data)
                    && reserva.getHorario().equalsIgnoreCase(periodo)) {
                throw new IllegalStateException("Erro: A sala já está reservada para este período e data.");
            }
        }

        Reserva novaReserva = new Reserva(sala, data, periodo);
        reservas.add(novaReserva);
        return novaReserva;
    }

    public String cancelarReserva(Reserva reserva) {
        if (reservas.remove(reserva)) {
            reserva.getSala().setDisponibilidade(true);
            return "Reserva cancelada com sucesso.";
        }
        return "Erro: Reserva não encontrada.";
    }
}