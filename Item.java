import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Item extends Objeto {
    private int tipo;

    public Item(List<Objeto> objetos) {
        super(objetos);
        this.tipo = gerarTipoAleatorio();
    }

    public void usarItemTipo1(Jogador jogador, List<FakeNews> fakeNews) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Iterator<FakeNews> iterator = fakeNews.iterator();
                while (iterator.hasNext()) {
                    FakeNews fk = iterator.next();
                    if (fk.getX() == (jogador.getX() + i) && fk.getY() == (jogador.getY() + j)) {
                        iterator.remove();
                        System.out.println(Cores.ANSI_RED + "Fake News do tipo " + fk.getTipo() + " foi destruída!"
                                + Cores.ANSI_RESET);
                    }
                }
            }
        }
    }

    public void usarItemTipo2(Jogador jogador) {
        Scanner input = new Scanner(System.in);
        int x = 0, y = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Digite a coordenada X: ");
            String stringX = input.next();
            System.out.print("Digite a coordenada Y: ");
            String stringY = input.next();

            try {
                x = Integer.parseInt(stringX);
                y = Integer.parseInt(stringY);
                isValid = true; // seta isValid para verdadeiro se conversao funcionar
            } catch (NumberFormatException e) {
                System.out.println("Digite valores numéricos válidos.");
            }

            if (isValid && (x < 1 || x > 9 || y < 1 || y > 9)) {
                isValid = false; // seta isValid pra falso valor nao for entre 1 e 9
                System.out.println("Digite números válidos, entre 1 e 9.");
            }
        }

        jogador.setY(x);
        jogador.setX(y);

    }

    public void usarItemTipo3(List<FakeNews> fakeNews) {
        Scanner input = new Scanner(System.in);
        int x = 0, y = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Digite a coordenada X da FakeNews a ser removida: ");
            String stringX = input.next();
            System.out.print("Digite a coordenada Y da FakeNews a ser removida: ");
            String stringY = input.next();

            try {
                x = Integer.parseInt(stringX);
                y = Integer.parseInt(stringY);
                isValid = true; // seta isValid para verdadeiro se conversao funcionar
            } catch (NumberFormatException e) {
                System.out.println("Digite valores numéricos válidos.");
            }

            if (isValid && (x < 1 || x > 9 || y < 1 || y > 9)) {
                isValid = false; /// seta isValid pra falso valor nao for entre 1 e 9
                System.out.println("Digite números válidos, entre 1 e 9.");
            }

            if (isValid) {
                Iterator<FakeNews> iterator = fakeNews.iterator();
                while (iterator.hasNext()) {
                    FakeNews fk = iterator.next();
                    if (fk.getX() == y && fk.getY() == x) {
                        iterator.remove();
                        return;
                    }
                }
                isValid = false; // seta isValid pra falso se nao achar fakeNews com coordenadas iguais
                System.out.println("Digite uma coordenada valida de alguma fakeNews");
            }
        }
    }

    public void usarItem(Jogador jogador, Item item, List<FakeNews> fakeNews, List<Jogador> jogadores) {
        switch (getTipo()) {
            case 1:
                usarItemTipo1(jogador, fakeNews);
                break;
            case 2:
                usarItemTipo2(jogador);
                break;
            case 3:
                usarItemTipo3(fakeNews);
                break;
        }
        System.out.println("O jogador " + jogador.getNum() + " usou o item do tipo " + getTipo());
        jogador.removerItensDoJogador(item);
    }

    private static int gerarTipoAleatorio() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(4) + 1;
    }

    public int getTipo() {
        return tipo;
    }
}
