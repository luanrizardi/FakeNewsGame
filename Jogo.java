import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void main(String args[]) {
        Jogador j1 = new Jogador(1, 1, 5);
        Jogador j2 = new Jogador(2, 5, 9);
        List<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(j1);
        jogadores.add(j2);

        List<Objeto> objetos = new ArrayList<Objeto>();
        for (Objeto jogador : jogadores) {
            objetos.add(jogador);
        }

        List<FakeNews> fakenews = new ArrayList<FakeNews>();
        for (int i = 0; i < 6; i++) {
            FakeNews f = new FakeNews(objetos);
            objetos.add(f);
            fakenews.add(f);
        }

        List<SetorRestrito> setoresRestritos = new ArrayList<SetorRestrito>();
        for (int i = 0; i < 4; i++) {
            SetorRestrito s = new SetorRestrito(objetos);
            objetos.add(s);
            setoresRestritos.add(s);
        }

        List<Item> itens = new ArrayList<Item>();
        for (int i = 0; i < 2; i++) {
            Item item = new Item(objetos);
            objetos.add(item);
            itens.add(item);
        }

        Tabuleiro tabuleiro = new Tabuleiro(jogadores, fakenews, itens, setoresRestritos);
        tabuleiro.desenharTabuleiro();
        Scanner input = new Scanner(System.in);

        String entrada = "NULL";
        // entrada = input.next();
        int turnos = 1;
        while (!entrada.toUpperCase().equals("X")) {

            if (fakenews.size() == 0) {
                System.out.println("VOCÊS GANHARAM!!!");
                break;
            }

            if (jogadores.size() == 0) {
                System.out.println("VOCÊS PERDERAM!!!");
                break;
            }

            if (turnos > 21) {
                System.out.println("OS TURNOS ACABARAM VOCÊS PERDERAM!!!");
                break;
            }

            for (Jogador jogador : tabuleiro.getJogadores()) {
                jogador.printarInstrucoes(jogador, turnos);
                entrada = input.next();
                jogador.mover(entrada.toUpperCase());
                tabuleiro.desenharTabuleiro();
            }

            objetos = tabuleiro.getObjetos();

            tabuleiro.verificacoes(jogadores, fakenews, itens, setoresRestritos);
            tabuleiro.moverFakeNews();
            tabuleiro.verificacoes(jogadores, fakenews, itens, setoresRestritos);
            tabuleiro.desenharTabuleiro();
            turnos++;
        }
        input.close();
    }

}
