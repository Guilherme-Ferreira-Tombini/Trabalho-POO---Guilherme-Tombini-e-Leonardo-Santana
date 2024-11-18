import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        SistemaReserva sistema = new SistemaReserva();

        // Adicionando salas ao sistema
        Sala sala1 = new Sala("Sala A", 20, true);
        Sala sala2 = new Sala("Sala B", 15, true);
        Sala sala3 = new Sala("Sala C", 10, true);

        sistema.addSala(sala1);
        sistema.addSala(sala2);
        sistema.addSala(sala3);

        int opcao = 0;

        do {
            // Exibe o menu usando JOptionPane
            String menu = " === Menu de Reservas === \n 1. Listar salas disponíveis \n 2. Reservar uma sala \n 3. Cancelar uma reserva \n 4. Ver histórico de reservas \n 5. Sair \n Escolha uma opção:";

            String input = JOptionPane.showInputDialog(null, menu, "Menu de Reservas", JOptionPane.QUESTION_MESSAGE);

            if (input == null || input.trim().isEmpty()) { // Verifica se o usuário clicou em "Cancelar" ou fechou a
                                                           // janela
                opcao = 5; // Sai do loop
            } else {
                try {
                    opcao = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite um número.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }

            switch (opcao) {
                case 1:
                    StringBuilder mensagem = new StringBuilder("=== Salas Disponíveis ===\n");
                    for (Sala sala : sistema.listarSalasDisponiveis()) {
                        mensagem.append("- ").append(sala.getIdentificacao())
                                .append(" (Capacidade: ").append(sala.getCapacidade()).append(")\n");
                    }

                    JOptionPane.showMessageDialog(null, mensagem.toString(), "Salas Disponíveis",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema. Até mais!", "Encerrando",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
            }
        } while (opcao != 5);
    }

}
