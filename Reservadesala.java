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

    public String reservarSala(Sala sala, String data, String periodo) {
        if (!periodo.equalsIgnoreCase("matutino") && !periodo.equalsIgnoreCase("vespertino")) {
            return "Erro: O horário deve ser 'matutino' ou 'vespertino'.";
        }

        for (Reserva reserva : reservas) {
            if (reserva.getSala().equals(sala) && reserva.getData().equals(data) && reserva.getHorario().equals(periodo)) {
                return "A sala já está reservada para esse período na data informada.";
            }
        }

      
        Reserva novaReserva = new Reserva(sala, data, periodo);
        reservas.add(novaReserva);
        sala.setDisponibilidade(false); 

        return "Reserva realizada com sucesso no dia " + data + " no período " + periodo + ".";
    }

    public String cancelarReserva(Reserva reserva) {
        if (reservas.remove(reserva)) {
            reserva.getSala().setDisponibilidade(true);
            return "Reserva cancelada com sucesso.";
        }
        return "Erro: Reserva não encontrada.";
    }
}

public class Reservadesala {
    private Sala sala;      
    private String data;    
    private String horario; 

    public Reservadesala(Sala sala, String data, String horario) {
        this.sala = sala;
        sala.setDisponibilidade(false);
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
