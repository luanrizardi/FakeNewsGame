import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Jogador extends Objeto {
    private int num;
    private List<Item> itensDoJogador;

    public Jogador(int num, int x, int y) {
        super(x, y);
        this.num = num;
        itensDoJogador = new ArrayList<Item>();
    }

    public int getNum() {
        return num;
    }

    public List<Item> getItensDoJogador() {
        return itensDoJogador;
    }

    public void addItensDoJogador(Item item) {
        itensDoJogador.add(item);
    }

    public void removerItensDoJogador(Item item) {
        itensDoJogador.remove(item);
    }

    public void moverAleatorio() {
        switch (gerarMovimentoAleatorio()) {
            case 1:
                setX(getX() + 1);
                break;
            case 2:
                setX(getX() - 1);
                break;
            case 3:
                setX(getY() + 1);
                break;
            case 4:
                setX(getY() - 1);
                break;
        }
    }

    private static int gerarMovimentoAleatorio() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(4) + 1;
    }

    public boolean temItem4() {
        Iterator<Item> iterator = itensDoJogador.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getTipo() == 4) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void mover(String direcao) {
        int novaLinha = getX();
        int novaColuna = getY();

        switch (direcao) {
            case "W":
                novaLinha--;
                break;
            case "S":
                novaLinha++;
                break;
            case "A":
                novaColuna--;
                break;
            case "D":
                novaColuna++;
                break;
            default:
                System.out.println("Direcao invalida. Nenhuma acao sera realizada.");
                return;
        }

        setX(novaLinha);
        setY(novaColuna);
    }

    public void printarInstrucoes(int turnos) {
        System.out.print("\n -------------------------------------------------------------------------");
        System.out.print("\n| TURNO " + turnos + "                                                                |");
        System.out.print(
                "\n| ASSIM ESTÁ O TABULEIRO. PARA ONDE DESEJA MOVER O JOGADOR " + getNum() + " ?           |");
        System.out.print("\n| W = CIMA                                                               |");
        System.out.print("\n| A = ESQUERDA                                                           |");
        System.out.print("\n| S = BAIXO                                                              |");
        System.out.print("\n| D = DIREITA                                                            |");
        System.out.print("\n|                                                                        |");
        System.out.print("\n| X = SAIR DO PROGRAMA                                                   |");
        System.out.println("\n -------------------------------------------------------------------------");
    }

    public void printarItens() {
        if (itensDoJogador.size() > 0 || (itensDoJogador.size() > 1)) {
            System.out.println("\n ------- O jogador " + +getNum() + " tem os seguintes itens do tipo: ");
            for (Item item : itensDoJogador) {
                System.out.print(" ------- " + item.getTipo());
                switch (item.getTipo()) {
                    case 1:
                        System.out.println(
                                " - Denunciar fake news: esse item oferece a ação de denunciar qualquer fake news em volta do jogador, eliminando-as (se houver) nas 8 (oito) posições adjacentes à posição do jogador.");
                        break;
                    case 2:
                        System.out.println(
                                " - Fugir: esse item permite que o jogador mude para qualquer outra posição do tabuleiro.");
                        break;
                    case 3:
                        System.out.println(
                                " - Ler uma notícia real: esse item permite que o jogador elimine uma fake news qualquer presente no tabuleiro");
                        break;
                    case 4:
                        System.out.println(
                                " - Ouvir um boato: Esse item nao pode ser usado, caso um jogador o armazene, no próximo turno o movimento desse jogador é realizado de forma aleatória");
                        break;
                }
            }
        } else {
            System.out.println("\n ---------O jogador " + +getNum() + " nao tem itens.");
        }
    }
}
