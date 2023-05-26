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

        FakeNews f1 = new FakeNews(1);
        FakeNews f2 = new FakeNews(2);
        FakeNews f3 = new FakeNews(3);
        List<FakeNews> fakenews = new ArrayList<FakeNews>();
        fakenews.add(f1);
        fakenews.add(f2);
        fakenews.add(f3);

        Item i1 = new Item();
        Item i2 = new Item();
        List<Item> itens = new ArrayList<Item>();
        itens.add(i1);
        itens.add(i2);

        Tabuleiro tabuleiro = new Tabuleiro(9, 9, jogadores, fakenews, itens);
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
            for (FakeNews fake : fakenews){
                fake.mover();
            }
            tabuleiro.desenharTabuleiro();
        }
        input.close();
    }
}
