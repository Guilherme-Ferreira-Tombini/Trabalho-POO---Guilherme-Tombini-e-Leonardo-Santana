import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public ArrayList<Sala> listarSalasIndisponiveis() {
        ArrayList<Sala> indisponiveis = new ArrayList<>();
        for (Sala sala : salas) {
            if (sala.isDisponibilidade() == false) {
                indisponiveis.add(sala);
            }
        }
        return indisponiveis;
    }

    public String historicoReservas() {
        StringBuilder mensage = new StringBuilder("=== Historico de reservas === \n");
        for (Reserva reserva : reservas) {
            mensage.append(" - ").append(reserva.getSala().getIdentificacao()).append("\n");
        }
        return mensage.toString();
    }

    public Reserva reservarSala(Sala sala, String data, String periodo) {
        for (Reserva reserva : reservas) {
            if (reserva.getSala().equals(sala) && reserva.getData().equals(data)
                    && reserva.getHorario().equalsIgnoreCase(periodo)) {
                JOptionPane.showMessageDialog(null, "Erro: A sala já está reservada para este período e data.", "Erro",
                        JOptionPane.ERROR_MESSAGE);

            }
        }

        Reserva novaReserva = new Reserva(sala, data, periodo);
        reservas.add(novaReserva);
        return novaReserva;
    }

    public String cancelarReserva(Sala sala) {
        for (Reserva reserva : reservas) {
            if (reserva.getSala().getIdentificacao()
                    .equalsIgnoreCase(sala.getIdentificacao())) {
                if (reservas.remove(reserva)) {
                    reserva.getSala().setDisponibilidade(true);
                    return "Reserva cancelada com sucesso.";
                }
            }
        }
        return "Erro: Reserva não encontrada para cancelamento.";
    }
}