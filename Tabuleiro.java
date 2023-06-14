import java.util.List;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;


public class Tabuleiro {
    private int largura;
    private int altura;
    private List<Jogador> jogadores;
    private List<FakeNews> fakeNews;
    private List<Item> itens;

    // Construtores
    public Tabuleiro(int largura, int altura, List<Jogador> jogadores, List<FakeNews> fakeNews, List<Item> itens) {
        
        setLargura(largura);
        setAltura(altura);
        setJogadores(jogadores);
        setFakeNews(fakeNews);
        setItens(itens);
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
    
    // Métodos set
    public void setLargura(int largura){
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

    public void destruirFakeNewsForaDoTabuleiro(List<FakeNews> fakeNewsList) {
        Iterator<FakeNews> iterator = fakeNewsList.iterator();
        while (iterator.hasNext()) {
            FakeNews fakeNews = iterator.next();
            
            int x = fakeNews.getX();
            int y = fakeNews.getY();
            
            if (x <= 0 || x > 9 || y <= 0 || y > 9) {
                iterator.remove();
                System.out.println(Cores.ANSI_RED + "Fake News do tipo " + fakeNews.getTipo() + " foi destruída!" + Cores.ANSI_RESET);
            }
        }
    }

    public void duplicarFakeNews(List<FakeNews> fakeNews) {
          for (Item item : itens) {
            for (FakeNews fakenews : fakeNews)
                if (fakenews.getX() == item.getX() && fakenews.getY() == item.getY()) {
                     // Verificar as oito posições adjacentes
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int novaX = fakenews.getX() + i;
                int novaY = fakenews.getY() + j;

                // Verificar se a posição adjacente está livre
                    boolean posicaoLivre = true;
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
                        System.out.println(Cores.ANSI_RED + "A Fake News " + tipoFakeNews + " foi duplicada na posição (" + novaX + ", " + novaY + ")." + Cores.ANSI_RESET);
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
                if(caractere == "J1" || caractere == "J2" || caractere == "F1" || caractere == "F2" || caractere == "F3" || caractere == "??")
                    j++;
                if(caractere == "J1" || caractere == "J2")
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
            if ((jogador.getX()*2 - 1) == linha && (jogador.getY()*5 - 3) == coluna) {
                switch(jogador.getNum()){
                    case 1:
                        return "J1";
                    case 2:
                        return "J2";
                }
                //return "J1";//jogador.getSimbolo();
            }
        }
        // Verifique se há fakenews na posição (linha, coluna)
        for (FakeNews fake : fakeNews){
            if ((fake.getX()*2 - 1) == linha && (fake.getY()*5 - 3) == coluna) {
                switch(fake.getTipo()){
                    case 1:
                        return "F1";
                    case 2:
                        return "F2";
                    case 3:
                        return "F3";
                }
            }
        }
        for (Item item : itens){
            if ((item.getX()*2 - 1) == linha && (item.getY()*5 - 3) == coluna) {
                return "??";
            }
        }
        // Se não houver nenhum jogador ou inimigo na posição (linha, coluna), retorne o caractere padrão
        if(coluna % 5 == 0 && linha % 2 == 0){
                    return "+";
                }
                else if (coluna % 5 == 0){
                    return "|";
                }
                else if(linha % 2 == 0){
                    return "-";
                }
                else if(linha % 2 != 0){
                    return " ";
                }
        else
                return "x";
        }

    public void eliminarJogador(List<Jogador> jogadores) {
        Iterator<Jogador> iterator = jogadores.iterator();
        while (iterator.hasNext()){
            Jogador jogador = iterator.next();
            for (FakeNews fakenews : fakeNews)
                if (fakenews.getX() == jogador.getX() && fakenews.getY() == jogador.getY()) {
                    // eliminar jogador
                        System.out.println(Cores.ANSI_GREEN + "O Jogador " + jogador.getNum() + " foi eliminado." + Cores.ANSI_RESET);
                        iterator.remove();
                    }
        }
    }

    public void verificacoes(List<Jogador> jogadores, List<FakeNews> fakeNews, List<Item> itens){
        eliminarJogador(jogadores);
        duplicarFakeNews(fakeNews);
        Iterator<FakeNews> iterator = fakeNews.iterator();
        while (iterator.hasNext()) {
            FakeNews fakenews = iterator.next();
            
            int x = fakenews.getX();
            int y = fakenews.getY();
            
            if (x <= 0 || x > 9 || y <= 0 || y > 9) {
                iterator.remove();
                System.out.println(Cores.ANSI_RED + "Fake News do tipo " + fakenews.getTipo() + " foi destruída!" + Cores.ANSI_RESET);
            }
        }
        }


}
        
    



