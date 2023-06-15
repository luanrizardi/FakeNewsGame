import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public List<Objeto> getObjetos() {
        List<Objeto> objetos = new ArrayList<Objeto>();
        for (Objeto jogador : jogadores) {
            objetos.add(jogador);
        }

        for (Objeto fk : fakeNews) {
            objetos.add(fk);
        }

        for (Objeto s : setores) {
            objetos.add(s);
        }

        for (Objeto i : itens) {
            objetos.add(i);
        }

        return objetos;
    }

    public void destruirFakeNewsForaDoTabuleiro(List<FakeNews> fakeNewsList) {
        Iterator<FakeNews> iterator = fakeNewsList.iterator();
        while (iterator.hasNext()) {
            FakeNews fakeNews = iterator.next();

            int x = fakeNews.getX();
            int y = fakeNews.getY();

            if (x <= 0 || x > 9 || y <= 0 || y > 9) {
                iterator.remove();
                System.out.println(Cores.ANSI_RED + "Fake News do tipo " + fakeNews.getTipo() + " foi destruída!"
                        + Cores.ANSI_RESET);
            }
        }
    }

    public void duplicarFakeNews() {
        for (Item item : itens) {
            for (FakeNews fakenews : fakeNews)
                if (fakenews.getX() == item.getX() && fakenews.getY() == item.getY()) {
                    // Verificar as oito posições adjacentes
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int novaX = fakenews.getX() + i;
                            int novaY = fakenews.getY() + j;
                            boolean posicaoLivre = true;
                            // Verificar se a posicao nao esta fora do tabuleiro
                            if ((novaX > 0 && novaX < 10) && (novaY > 0 && novaY < 10))
                                posicaoLivre = true;
                            // Verificar se a posição adjacente está livre
                            Iterator<FakeNews> iterator = fakeNews.iterator();
                            while (iterator.hasNext()) {
                                FakeNews outraFakeNews = iterator.next();
                                if (outraFakeNews.getX() == novaX && outraFakeNews.getY() == novaY) {
                                    posicaoLivre = false;
                                    break;
                                }
                            }
                            // Se a posição estiver livre, criar uma nova Fake News duplicada
                            if (posicaoLivre) {
                                int tipoFakeNews = fakenews.getTipo();
                                FakeNews novaFakeNews = new FakeNews(tipoFakeNews, novaX, novaY);
                                fakeNews.add(novaFakeNews);
                                System.out.println(
                                        Cores.ANSI_RED + "A Fake News " + tipoFakeNews + " foi duplicada na posição ("
                                                + novaY + ", " + novaX + ")." + Cores.ANSI_RESET);
                                return;
                            }
                        }
                    }
                }
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
                if (caractere == "J1" || caractere == "J2")
                    System.out.print(Cores.ANSI_GREEN + caractere + Cores.ANSI_RESET);
                else if (caractere == "F1" || caractere == "F2" || caractere == "F3")
                    System.out.print(Cores.ANSI_RED + caractere + Cores.ANSI_RESET);
                else if (caractere == "??")
                    System.out.print(Cores.ANSI_YELLOW + caractere + Cores.ANSI_RESET);
                else
                    System.out.print(caractere);
            }
            System.out.println();
        }
    }

    private String obterCaractereParaPosicao(int linha, int coluna) {
        // Verifique se há algum jogador na posição (linha, coluna)
        for (Jogador jogador : jogadores) {
            if ((jogador.getX() * 2 - 1) == linha && (jogador.getY() * 5 - 3) == coluna) {
                switch (jogador.getNum()) {
                    case 1:
                        return "J1";
                    case 2:
                        return "J2";
                }
                // return "J1";//jogador.getSimbolo();
            }
        }
        // Verifique se há fakenews na posição (linha, coluna)
        for (FakeNews fake : fakeNews) {
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
        for (Item item : itens) {
            if ((item.getX() * 2 - 1) == linha && (item.getY() * 5 - 3) == coluna) {
                return "??";
            }
        }

        for (SetorRestrito setor : setores) {
            if ((setor.getX() * 2 - 1) == linha && (setor.getY() * 5 - 3) == coluna) {
                return "XX";
            }
        }
        // Se não houver nenhum jogador ou inimigo na posição (linha, coluna), retorne o
        // caractere padrão
        if (coluna % 5 == 0 && linha % 2 == 0) {
            return "+";
        } else if (coluna % 5 == 0) {
            return "|";
        } else if (linha % 2 == 0) {
            return "-";
        } else if (linha % 2 != 0) {
            return " ";
        } else
            return "x";
    }

    public boolean eliminarJogadorPorFakeNews(Jogador jogador) {
        for (FakeNews fakenews : fakeNews) {
            if (fakenews.getX() == jogador.getX() && fakenews.getY() == jogador.getY()) {
                // eliminar jogador
                System.out.println(
                        Cores.ANSI_GREEN + "O Jogador " + jogador.getNum() + " foi eliminado." + Cores.ANSI_RESET);
                return true;
            }
        }

        return false;
    }

    public boolean eliminarJogadorPorSetorRestrito(Jogador jogador, List<SetorRestrito> setores) {
        for (SetorRestrito setor : setores) {
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

    public void eliminarFakeNewsForaDoTabuleiro() {
        Iterator<FakeNews> iterator = fakeNews.iterator();
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

    public void eliminarFakeNewsSetorRestrito() {
        Iterator<FakeNews> iterator = fakeNews.iterator();
        while (iterator.hasNext()) {
            FakeNews fakenews = iterator.next();

            int x = fakenews.getX();
            int y = fakenews.getY();

            boolean foundMatchingSetor = false; // Flag to track if a matching SetorRestrito is found

            for (SetorRestrito setor : setores) {
                if (setor.getX() == x && setor.getY() == y) {
                    // eliminar fakenews
                    System.out.println(Cores.ANSI_RED + "Fake News do tipo " + fakenews.getTipo() + " foi destruída!"
                            + Cores.ANSI_RESET);
                    foundMatchingSetor = true; // Set the flag to true
                    break; // No need to continue iterating over the remaining setores
                }
            }
            if (foundMatchingSetor)
                iterator.remove(); // Remove the FakeNews object

        }
    }

    public void eliminarFakeNewsMesmaPosicao() {

        FakeNews firstDuplicate = null;

        for (FakeNews fk : fakeNews) {
            int x = fk.getX();
            int y = fk.getY();

            if (firstDuplicate == null) {
                firstDuplicate = fk;
            } else if (firstDuplicate.getX() == x && firstDuplicate.getY() == y) {
                fakeNews.remove(firstDuplicate);
                System.out.println(Cores.ANSI_RED + "Fake News do tipo " + firstDuplicate.getTipo()
                        + " foi destruída! (Colisao de Fake News)"
                        + Cores.ANSI_RESET);
                fakeNews.remove(fk);
                System.out.println(
                        Cores.ANSI_RED + "Fake News do tipo " + fk.getTipo() + " foi destruída! (Colisao de Fake News)"
                                + Cores.ANSI_RESET);
                break;
            }
        }
    }

    public void moverFakeNews() {
        for (FakeNews fake : fakeNews) {
            System.out
                    .print("Fake News " + fake.getTipo() + " se moveu de: " + fake.getY() + ", " + fake.getX());
            fake.mover();
            System.out
                    .println(" para: " + fake.getY() + ", " + fake.getX());

            // Pausa a execução por 2 segundos
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void verificacoes(List<Jogador> jogadores, List<FakeNews> fakeNews, List<Item> itens,
            List<SetorRestrito> setores) {

        Iterator<Jogador> iterator = jogadores.iterator();
        while (iterator.hasNext()) {
            Jogador jogador = iterator.next();
            if (eliminarJogadorPorSetorRestrito(jogador, setores) || eliminarJogadorPorFakeNews(jogador)
                    || eliminarJogadorForaDoTabuleiro(jogador))
                iterator.remove();
        }

        duplicarFakeNews();
        eliminarFakeNewsForaDoTabuleiro();
        eliminarFakeNewsSetorRestrito();
        eliminarFakeNewsMesmaPosicao();
    }

}
