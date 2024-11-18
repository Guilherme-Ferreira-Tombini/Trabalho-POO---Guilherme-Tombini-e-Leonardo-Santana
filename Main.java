public class Main {
    public static void main(String[] args) {
  
        SistemaReserva sistema = new SistemaReserva();

        Sala sala1 = new Sala("Sala A", 20, true);
        Sala sala2 = new Sala("Sala B", 15, true);
        Sala sala3 = new Sala("Sala C", 10, true);

        sistema.addSala(sala1);
        sistema.addSala(sala2);
        sistema.addSala(sala3);

        System.out.println("Salas disponíveis:");
        for (Sala sala : sistema.listarSalasDisponiveis()) {
            System.out.println("- " + sala.getIdentificacao() + " (Capacidade: " + sala.getCapacidade() + ")");
        }


        System.out.println("\nTentando reservar a Sala A...");
        String resultadoReserva = sistema.reservarSala(sala1, "2024-11-20", "matutino");
        System.out.println(resultadoReserva);

        System.out.println("\nSalas disponíveis após a reserva:");
        for (Sala sala : sistema.listarSalasDisponiveis()) {
            System.out.println("- " + sala.getIdentificacao() + " (Capacidade: " + sala.getCapacidade() + ")");
        }

        System.out.println("\nTentando reservar novamente a Sala A no mesmo período...");
        String resultadoReserva2 = sistema.reservarSala(sala1, "2024-11-20", "matutino");
        System.out.println(resultadoReserva2);

        System.out.println("\nCancelando a reserva da Sala A...");
        var reservaCancelada = sistema.historicoReservas().get(0); // Pegando a reserva criada
        String resultadoCancelamento = sistema.cancelarReserva(reservaCancelada);
        System.out.println(resultadoCancelamento);

        System.out.println("\nSalas disponíveis após o cancelamento:");
        for (Sala sala : sistema.listarSalasDisponiveis()) {
            System.out.println("- " + sala.getIdentificacao() + " (Capacidade: " + sala.getCapacidade() + ")");
        }
    }
}
