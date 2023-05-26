import java.util.Scanner;

public class Jogo {
    public static void main(String args[]) {    
        Jogador j1 = new Jogador("luan", 5, 4);
        FakeNews f1 = new FakeNews(1);
        Tabuleiro tabuleiro = new Tabuleiro(9, 9, j1, f1);
        tabuleiro.desenharTabuleiro();
        Scanner input = new Scanner(System.in);

        String entrada;
        entrada = input.next();

        while(!entrada.toUpperCase().equals("X")) {
            j1.mover(entrada.toUpperCase());
            tabuleiro.desenharTabuleiro();
            entrada = input.next();
        }
        input.close();
    }
}
