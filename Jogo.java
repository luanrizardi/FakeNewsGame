import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void main(String args[]) {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador(1, 1, 5));
        jogadores.add(new Jogador(2, 5, 9));

        List<Objeto> objetos = new ArrayList<>(jogadores);

        List<FakeNews> fakenews = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            FakeNews f = new FakeNews(objetos);
            objetos.add(f);
            fakenews.add(f);
        }

        List<SetorRestrito> setoresRestritos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            SetorRestrito s = new SetorRestrito(objetos);
            objetos.add(s);
            setoresRestritos.add(s);
        }

        List<Item> itens = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Item item = new Item(objetos);
            objetos.add(item);
            itens.add(item);
        }

        Tabuleiro tabuleiro = new Tabuleiro(jogadores, fakenews, itens, setoresRestritos);
        tabuleiro.desenharTabuleiro();

        Scanner input = new Scanner(System.in);
        String entrada = "NULL";
        int turnos = 1;

        while (!entrada.equalsIgnoreCase("X")) {
            if (fakenews.isEmpty()) {
                System.out.println("VOCÊS GANHARAM!!!");
                break;
            }

            if (jogadores.isEmpty()) {
                System.out.println("VOCÊS PERDERAM!!!");
                break;
            }

            if (turnos > 21) {
                System.out.println("OS TURNOS ACABARAM, VOCÊS PERDERAM!!!");
                break;
            }

            Iterator<Jogador> iterator = jogadores.iterator();
            while (iterator.hasNext()) {
                Jogador jogador = iterator.next();

                jogador.printarItens();

                if (tabuleiro.usarItens(jogador)) {
                    tabuleiro.desenharTabuleiro();
                    tabuleiro.checarItens(jogador);
                }
                if (tabuleiro.eliminarJogador(jogador)) {
                    iterator.remove();
                    tabuleiro.desenharTabuleiro();
                } else {
                    if (jogador.temItem4()) {
                        System.out.println(
                                "O jogador tem um item do tipo 4, entao nesse turno ele ira de mover se forma aleatoria");
                        jogador.moverAleatorio();
                    } else {
                        jogador.printarInstrucoes(turnos);
                        tabuleiro.desenharTabuleiro();
                        entrada = input.next().toUpperCase();

                        if (entrada.equalsIgnoreCase("X")) {
                            break; // sai do loop
                        }
                        jogador.mover(entrada);
                    }
                    if (tabuleiro.eliminarJogador(jogador)) {
                        iterator.remove();
                    }
                    tabuleiro.desenharTabuleiro();
                    tabuleiro.checarItens(jogador);

                }
            }

            if (entrada.equalsIgnoreCase("X")) {
                break; // sai do loop
            }

            // objetos = tabuleiro.getObjetos();

            tabuleiro.verificacoes();
            tabuleiro.moverFakeNews();
            tabuleiro.verificacoes();
            tabuleiro.desenharTabuleiro();
            turnos++;
        }

        input.close();
    }
}
