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
            String menu = " === Menu de Reservas === \n 1. Listar salas disponíveis \n 2. Reservar uma sala \n 3. Cancelar uma reserva \n 4. Ver histórico de reservas \n 5. Sair \n Escolha uma opção:";

            String input = JOptionPane.showInputDialog(null, menu, "Menu de Reservas", JOptionPane.QUESTION_MESSAGE);

            if (input == null || input.trim().isEmpty()) { // Verifica clicou em "Cancelar" ou fechou a janela
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
                        mensagem.append("- ").append(sala.getIdentificacao()).append(" (Capacidade: ")
                                .append(sala.getCapacidade()).append(")\n");
                    }

                    JOptionPane.showMessageDialog(null, mensagem.toString(), "Salas Disponíveis",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2:
                    String sala = "Digite a sala desejada entre as disponíveis (Ex: Sala A)";
                    String inputSala = JOptionPane.showInputDialog(null, sala, "Reserva de Salas",
                            JOptionPane.QUESTION_MESSAGE);

                    if (inputSala == null || inputSala.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, tente novamente.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Sala salaEscolhida = null;
                    for (Sala procuraSala : sistema.listarSalasDisponiveis()) {
                        if (procuraSala.getIdentificacao().equalsIgnoreCase(inputSala)
                                && procuraSala.isDisponibilidade()) {
                            salaEscolhida = procuraSala;
                            break; // Sala encontrada e disponível
                        }
                    }

                    if (salaEscolhida == null) {
                        JOptionPane.showMessageDialog(null, "Sala não encontrada ou não está disponível.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String dataReserva = JOptionPane.showInputDialog(null,
                            "Digite a data para reserva (formato: dd/MM/yyyy):", "Data da Reserva",
                            JOptionPane.QUESTION_MESSAGE);
                    String periodoReserva = JOptionPane.showInputDialog(null,
                            "Digite o período (matutino ou vespertino):", "Período da Reserva",
                            JOptionPane.QUESTION_MESSAGE);

                    // Adicionar a reserva ao histórico de reservas
                    Reserva resultado = sistema.reservarSala(salaEscolhida, dataReserva, periodoReserva);
                    StringBuilder mensagemConcluidaReserva = new StringBuilder("=== Reserva Concluida ===\n");
                    mensagemConcluidaReserva.append(resultado.getSala().getIdentificacao()).append("\n")
                            .append(resultado.getData()).append("\n " + resultado.getHorario());

                    JOptionPane.showMessageDialog(null, mensagemConcluidaReserva.toString(), "Reserva concluida",
                            JOptionPane.INFORMATION_MESSAGE);
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
