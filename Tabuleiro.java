import java.util.List;

public class Tabuleiro {
    private int largura;
    private int altura;
    private List<Jogador> jogadores;
    private List<FakeNews> fakeNews;
    private List<Item> itens;

    // Construtores
    public Tabuleiro(int largura, int altura, List<Jogador> jogadores, List<FakeNews> fakeNews, List<Item> itens) {
        // Tem que ser 5x5
        
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

    public void desenharTabuleiro() {
        System.out.println("Desenhando tabuleiro:");
        for (int i = 0; i < altura * 2 + 1; i++) {
            for (int j = 0; j < 46; j++) {
                // Obtenha o caractere a ser desenhado para a posição (i, j)
                String caractere = obterCaractereParaPosicao(i, j);
                if(caractere == "J1" || caractere == "J2" || caractere == "J3" || caractere == "F1" || caractere == "F2" || caractere == "F3" || caractere == "J4" || caractere == "??")
                    j++;
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
                    case 3:
                        return "J3";
                    case 4:
                        return "J4";
                }
                return "J1";//jogador.getSimbolo();
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
}
