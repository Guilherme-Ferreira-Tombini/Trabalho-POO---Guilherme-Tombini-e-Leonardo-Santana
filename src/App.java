import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        SistemaReserva sistema = new SistemaReserva();

        Sala sala1 = new Sala("Sala A", 20, true);
        Sala sala2 = new Sala("Sala B", 15, true);
        Sala sala3 = new Sala("Sala C", 10, true);
        Sala sala4 = new Sala("Sala D", 25, true);
        Sala sala5 = new Sala("Sala E", 12, true);

        sistema.addSala(sala1);
        sistema.addSala(sala2);
        sistema.addSala(sala3);
        sistema.addSala(sala4);
        sistema.addSala(sala5);

        int opcao = 0;

        do {
            String menu = " === Menu de Reservas === \n 1. Listar salas disponíveis \n 2. Reservar uma sala \n 3. Cancelar uma reserva \n 4. Ver histórico de reservas \n 5. Sair \n Escolha uma opção:";

            String input = JOptionPane.showInputDialog(null, menu, "Menu de Reservas", JOptionPane.QUESTION_MESSAGE);

            if (input == null || input.trim().isEmpty()) {
                opcao = 5;
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
                    Sala salaEscolhida = null;

                    while (salaEscolhida == null) {
                        String inputSala = JOptionPane.showInputDialog(null,
                                "Digite a sala desejada entre as disponíveis (Ex: Sala A)",
                                "Reserva de Salas", JOptionPane.QUESTION_MESSAGE);

                        if (inputSala == null)
                            break; // Retorna ao menu inicial

                        for (Sala procuraSala : sistema.listarSalasDisponiveis()) {
                            if (procuraSala.getIdentificacao().equalsIgnoreCase(inputSala)
                                    && procuraSala.isDisponibilidade()) {
                                salaEscolhida = procuraSala;
                                break;
                            }
                        }

                        if (salaEscolhida == null) {
                            JOptionPane.showMessageDialog(null,
                                    "Sala não encontrada ou não está disponível.", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (salaEscolhida == null)
                        break; // Retorna ao menu inicial

                    String periodoReserva = "";
                    while (!periodoReserva.equalsIgnoreCase("matutino")
                            && !periodoReserva.equalsIgnoreCase("vespertino")) {
                        periodoReserva = JOptionPane.showInputDialog(null,
                                "Digite o período (matutino ou vespertino):",
                                "Período da Reserva", JOptionPane.QUESTION_MESSAGE);

                        if (periodoReserva == null)
                            break; // Retorna ao menu inicial

                        if (!periodoReserva.equalsIgnoreCase("matutino")
                                && !periodoReserva.equalsIgnoreCase("vespertino")) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: O horário deve ser 'matutino' ou 'vespertino'.",
                                    "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (periodoReserva == null)
                        break; // Retorna ao menu inicial

                    String dataReserva = JOptionPane.showInputDialog(null,
                            "Digite a data para reserva (formato: dd/MM/yyyy):",
                            "Data da Reserva", JOptionPane.QUESTION_MESSAGE);

                    if (dataReserva == null)
                        break; // Retorna ao menu inicial

                    Reserva resultado = sistema.reservarSala(salaEscolhida, dataReserva, periodoReserva);

                    StringBuilder mensagemConcluidaReserva = new StringBuilder("=== Reserva Concluída ===\n");
                    mensagemConcluidaReserva.append(resultado.getSala().getIdentificacao()).append("\n")
                            .append(resultado.getData()).append("\n").append(resultado.getHorario());

                    JOptionPane.showMessageDialog(null, mensagemConcluidaReserva.toString(), "Reserva Concluída",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:
                    Sala salaEscolhidaCancelar = null;

                    while (salaEscolhidaCancelar == null) {
                        String inputSalaCancelar = JOptionPane.showInputDialog(null,
                                "Digite a sala desejada entre as indisponíveis (Ex: Sala A)",
                                "Cancelar Reserva", JOptionPane.QUESTION_MESSAGE);

                        if (inputSalaCancelar == null)
                            break; // Retorna ao menu inicial

                        for (Sala procuraSala : sistema.listarSalasIndisponiveis()) {
                            if (procuraSala.getIdentificacao().equalsIgnoreCase(inputSalaCancelar)
                                    && !procuraSala.isDisponibilidade()) {
                                salaEscolhidaCancelar = procuraSala;
                                break;
                            }
                        }

                        if (salaEscolhidaCancelar == null) {
                            JOptionPane.showMessageDialog(null,
                                    "Sala não encontrada.", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (salaEscolhidaCancelar == null)
                        break; // Retorna ao menu inicial

                    sistema.cancelarReserva(salaEscolhidaCancelar);
                    JOptionPane.showMessageDialog(null,
                            "Reserva cancelada com sucesso.", "Cancelamento",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, sistema.historicoReservas(), "Histórico de Reservas",
                            JOptionPane.INFORMATION_MESSAGE);
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
