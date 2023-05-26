import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Jogo {
    public static void main(String args[]) {    
        Jogador j1 = new Jogador(1, 1, 5);
        Jogador j2 = new Jogador(2, 5, 9);
        List<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(j1);
        jogadores.add(j2);

        FakeNews f1 = new FakeNews(3);
        Item i1 = new Item();
        Tabuleiro tabuleiro = new Tabuleiro(9, 9, jogadores, f1, i1);
        tabuleiro.desenharTabuleiro();
        Scanner input = new Scanner(System.in);

        String entrada = "NULL";
        //entrada = input.next();

        while(!entrada.toUpperCase().equals("X")) {
            for (Jogador jogador : jogadores){
                entrada = input.next();
                jogador.mover(entrada.toUpperCase());
                tabuleiro.desenharTabuleiro();
            }
            f1.mover();
        }
        input.close();
    }
}
