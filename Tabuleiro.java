import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Tabuleiro {
    private int largura;
    private int altura;
    private List<Jogador> jogadores;
    private List<FakeNews> fakeNews;
    private List<Item> itens;
    private List<SetorRestrito> setores;

    // Construtores
    public Tabuleiro(List<Jogador> jogadores, List<FakeNews> fakeNews, List<Item> itens,
            List<SetorRestrito> setores) {
        setLargura(9);
        setAltura(9);
        setJogadores(jogadores);
        setFakeNews(fakeNews);
        setItens(itens);
        setSetores(setores);
    }

    // Métodos get
    public int getLargura() {
        return this.largura;
    }

    public int getAltura() {
        return this.altura;
    }

    public List<Jogador> getJogadores() {
        return this.jogadores;
    }

    public List<FakeNews> getFakeNews() {
        return this.fakeNews;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public List<SetorRestrito> getSetores() {
        return this.setores;
    }

    public List<Objeto> getObjetos() {
        List<Objeto> objetos = new ArrayList<>();

        objetos.addAll(getJogadores());
        objetos.addAll(getFakeNews());
        objetos.addAll(getSetores());
        objetos.addAll(getItens());

        return objetos;
    }

    // Métodos set
    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setFakeNews(List<FakeNews> fakeNews) {
        this.fakeNews = fakeNews;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setSetores(List<SetorRestrito> setores) {
        this.setores = setores;
    }

    // Metodos tabuleiro

    private String obterCaractereParaPosicao(int linha, int coluna) {
        // checa por jogador na posicao (linha, coluna)
        for (Jogador jogador : getJogadores()) {
            if ((jogador.getX() * 2 - 1) == linha && (jogador.getY() * 5 - 3) == coluna) {
                switch (jogador.getNum()) {
                    case 1:
                        return "J1";
                    case 2:
                        return "J2";
                }
            }
        }

        // checa por fakeNews na posicao (linha, coluna)
        for (FakeNews fake : getFakeNews()) {
            if ((fake.getX() * 2 - 1) == linha && (fake.getY() * 5 - 3) == coluna) {
                switch (fake.getTipo()) {
                    case 1:
                        return "F1";
                    case 2:
                        return "F2";
                    case 3:
                        return "F3";
                }
            }
        }

        // checa por item na posicao (linha, coluna)
        for (Item item : getItens()) {
            if ((item.getX() * 2 - 1) == linha && (item.getY() * 5 - 3) == coluna) {
                return "??";
            }
        }

        // checa por setor restrito na posicao (linha, coluna)
        for (SetorRestrito setor : getSetores()) {
            if ((setor.getX() * 2 - 1) == linha && (setor.getY() * 5 - 3) == coluna) {
                return "XX";
            }
        }

        // se nao tiver nenhum elemento na posicao retorna o valor padrao
        if (coluna % 5 == 0 && linha % 2 == 0) {
            return "+";
        } else if (coluna % 5 == 0) {
            return "|";
        } else if (linha % 2 == 0) {
            return "-";
        } else {
            return " ";
        }
    }

    public void desenharTabuleiro() {
        System.out.println("Desenhando tabuleiro:");
        for (int i = 0; i < altura * 2 + 1; i++) {
            for (int j = 0; j < 46; j++) {
                // Obtenha o caractere a ser desenhado para a posição (i, j)
                String caractere = obterCaractereParaPosicao(i, j);
                if (caractere == "J1" || caractere == "J2" || caractere == "F1" || caractere == "F2"
                        || caractere == "F3" || caractere == "??" || caractere == "XX")
                    j++;
                if (caractere == "F1" || caractere == "F2" || caractere == "F3")
                    System.out.print(Cores.ANSI_RED + caractere + Cores.ANSI_RESET);
                else if (caractere == "J1" || caractere == "J2")
                    System.out.print(Cores.ANSI_GREEN + caractere + Cores.ANSI_RESET);
                else if (caractere == "??")
                    System.out.print(Cores.ANSI_YELLOW + caractere + Cores.ANSI_RESET);
                else
                    System.out.print(caractere);
            }
            System.out.println();
        }
    }

    // Manipular fakeNews

    public void eliminarFakeNewsSetorRestrito() {
        Iterator<FakeNews> iterator = getFakeNews().iterator();
        while (iterator.hasNext()) {
            FakeNews fakenews = iterator.next();

            int x = fakenews.getX();
            int y = fakenews.getY();

            boolean foundMatchingSetor = false;

            for (SetorRestrito setor : getSetores()) {
                if (setor.getX() == x && setor.getY() == y) {
                    // eliminar fakenews
                    System.out.println(Cores.ANSI_RED + "Fake News do tipo " + fakenews.getTipo() + " foi destruída!"
                            + Cores.ANSI_RESET);
                    foundMatchingSetor = true;
                    break;
                }
            }
            if (foundMatchingSetor)
                iterator.remove(); // Remove the FakeNews object

        }
    }

    public void eliminarFakeNewsMesmaPosicao() {

        FakeNews firstDuplicate = null;

        for (FakeNews fk : getFakeNews()) {
            int x = fk.getX();
            int y = fk.getY();

            if (firstDuplicate == null) {
                firstDuplicate = fk;
            } else if (firstDuplicate.getX() == x && firstDuplicate.getY() == y) {
                getFakeNews().remove(firstDuplicate);
                System.out.println(Cores.ANSI_RED + "Fake News do tipo " + firstDuplicate.getTipo()
                        + " foi destruída! (Colisao de Fake News)"
                        + Cores.ANSI_RESET);
                getFakeNews().remove(fk);
                System.out.println(
                        Cores.ANSI_RED + "Fake News do tipo " + fk.getTipo() + " foi destruída! (Colisao de Fake News)"
                                + Cores.ANSI_RESET);
                break;
            }
        }
    }

    public void moverFakeNews() {
        for (FakeNews fake : getFakeNews()) {
            System.out
                    .print("Fake News " + fake.getTipo() + " se moveu de: " + fake.getY() + ", " + fake.getX());
            fake.mover();
            System.out
                    .println(" para: " + fake.getY() + ", " + fake.getX());

            desenharTabuleiro();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarFakeNewsForaDoTabuleiro() {
        Iterator<FakeNews> iterator = getFakeNews().iterator();
        while (iterator.hasNext()) {
            FakeNews fakenews = iterator.next();

            int x = fakenews.getX();
            int y = fakenews.getY();

            if (x <= 0 || x > 9 || y <= 0 || y > 9) {
                iterator.remove();
                System.out.println(Cores.ANSI_RED + "Fake News do tipo " + fakenews.getTipo() + " foi destruída!"
                        + Cores.ANSI_RESET);
            }
        }
    }

    public void duplicarFakeNews() {
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            for (FakeNews fakenews : getFakeNews()) {
                if (fakenews.getX() == item.getX() && fakenews.getY() == item.getY()) {
                    // Verificar as oito posições adjacentes
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int novaX = fakenews.getX() + i;
                            int novaY = fakenews.getY() + j;
                            boolean posicaoLivre = true;

                            // Verificar se a posição não está fora do tabuleiro
                            if ((novaX > 0 && novaX < 10) && (novaY > 0 && novaY < 10)) {
                                posicaoLivre = true;
                            }

                            // Verificar se a posição adjacente está livre
                            boolean posicaoOcupada = fakeNews.stream()
                                    .anyMatch(fn -> fn.getX() == novaX && fn.getY() == novaY);

                            if (posicaoOcupada) {
                                posicaoLivre = false;
                            }

                            // Se a posição estiver livre, criar uma nova Fake News duplicada
                            if (posicaoLivre) {
                                int tipoFakeNews = fakenews.getTipo();
                                fakeNews.add(new FakeNews(tipoFakeNews, novaX, novaY));
                                System.out.println(
                                        Cores.ANSI_RED + "A Fake News " + tipoFakeNews + " foi duplicada na posição ("
                                                + novaY + ", " + novaX + ")." + Cores.ANSI_RESET);
                                iterator.remove();
                                System.out.println(Cores.ANSI_RED + "Um item foi detruido pela fake news do tipo "
                                        + fakenews.getTipo() + Cores.ANSI_RESET);
                                getItens().add(new Item(getObjetos()));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    // Manipular jogadores

    public boolean eliminarJogadorPorFakeNews(Jogador jogador) {
        for (FakeNews fakenews : getFakeNews()) {
            if (fakenews.getX() == jogador.getX() && fakenews.getY() == jogador.getY()) {
                // eliminar jogador
                System.out.println(
                        Cores.ANSI_GREEN + "O Jogador " + jogador.getNum() + " foi eliminado." + Cores.ANSI_RESET);
                return true;
            }
        }

        return false;
    }

    public boolean eliminarJogadorPorSetorRestrito(Jogador jogador) {
        for (SetorRestrito setor : getSetores()) {
            if (setor.getX() == jogador.getX() && setor.getY() == jogador.getY()) {
                // eliminar jogador
                System.out.println(
                        Cores.ANSI_GREEN + "O Jogador " + jogador.getNum() + " foi eliminado." + Cores.ANSI_RESET);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarJogadorForaDoTabuleiro(Jogador jogador) {
        int x = jogador.getX();
        int y = jogador.getY();
        if (x <= 0 || x > 9 || y <= 0 || y > 9) {
            System.out.println(
                    Cores.ANSI_GREEN + "O Jogador " + jogador.getNum() + " foi eliminado." + Cores.ANSI_RESET);
            return true;
        }
        return false;
    }

    public boolean eliminarJogador(Jogador jogador) {
        if (eliminarJogadorPorSetorRestrito(jogador) || eliminarJogadorPorFakeNews(jogador)
                || eliminarJogadorForaDoTabuleiro(jogador))
            return true;
        else
            return false;
    }

    // Manipular itens

    public void checarItens(Jogador jogador) {
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getX() == jogador.getX() && item.getY() == jogador.getY()) {
                jogador.addItensDoJogador(item);
                System.out.println("Jogador " + jogador.getNum() + " recebeu o item do tipo: " + item.getTipo());
                iterator.remove();
                itens.add(new Item(getObjetos()));
                return;
            }
        }
    }

    public boolean usarItens(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);
        List<Item> itensDoJogador = jogador.getItensDoJogador();

        if (itensDoJogador.isEmpty()) {
            return false;
        }

        boolean isValid = false;
        while (!isValid) {
            System.out.println("Digite o tipo do item que deseja usar, ou 0 para nao usar nenhum item");
            String input = scanner.next();
            int tipoItem;

            try {
                tipoItem = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                continue;
            }

            if (tipoItem == 0) {
                return false;
            }

            for (Item item : itensDoJogador) {
                if (item.getTipo() == tipoItem && tipoItem != 4) {
                    item.usarItem(jogador, item, getFakeNews(), getJogadores());
                    return true;
                }
            }
            if (tipoItem == 4)
                System.out.println("Esse item nao pode ser usado");
            else
                System.out.println("O jogador nao tem nenhum item desse tipo, por favor digite outro");
        }

        return false;
    }

    // Verificacoes do tabuleiro

    public void verificacoes() {
        Iterator<Jogador> iterator = getJogadores().iterator();
        while (iterator.hasNext()) {
            Jogador jogador = iterator.next();
            if (eliminarJogador(jogador))
                iterator.remove();
        }

        duplicarFakeNews();
        eliminarFakeNewsForaDoTabuleiro();
        eliminarFakeNewsSetorRestrito();
        eliminarFakeNewsMesmaPosicao();
    }
}
