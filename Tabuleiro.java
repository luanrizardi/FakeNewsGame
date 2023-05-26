
public class Tabuleiro {
    private int largura;
    private int altura;
    private Jogador jogador;
    private FakeNews fakeNews;

    // Construtores
    public Tabuleiro(int largura, int altura, Jogador jogador, FakeNews fakeNews) {
        // Tem que ser 5x5
        
        setLargura(largura);
        setAltura(altura);
        setJogador(jogador);
        setFakeNews(fakeNews);

    }

    // Métodos get
    public int getLargura() {
        return this.largura;
    }
    
    public int getAltura() {
        return this.altura;
    }
    
    public Jogador getJogador() {
        return this.jogador;
    }

    public Jogador getFakeNews() {
        return this.jogador;
    }
    
    // Métodos set
    public void setLargura(int largura){
        this.largura = largura;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setFakeNews(FakeNews fakeNews) {
        this.fakeNews = fakeNews;
    }

    public void desenharTabuleiro() {
        System.out.println("Desenhando tabuleiro:");
        for (int i = 0; i < altura * 2 + 1; i++) {
            for (int j = 0; j < 46; j++) {
                // Obtenha o caractere a ser desenhado para a posição (i, j)
                String caractere = obterCaractereParaPosicao(i, j);
                if(caractere == "J1" || caractere == "J2" || caractere == "J3" || caractere == "F1" || caractere == "F2" || caractere == "F3" || caractere == "J4")
                    j++;
                System.out.print(caractere);
        }
        System.out.println(); 
        }
    }
   
    private String obterCaractereParaPosicao(int linha, int coluna) {
        // Verifique se há algum jogador na posição (linha, coluna)
        if ((jogador.getX()*2 - 1) == linha && (jogador.getY()*5 - 3) == coluna) {
            return "J1";//jogador.getSimbolo();
        }
        // Verifique se há fakenews na posição (linha, coluna)
        if ((fakeNews.getX()*2 - 1) == linha && (fakeNews.getY()*5 - 3) == coluna) {
            switch(fakeNews.getTipo()){
                case 1:
                    return "F1";
                case 2:
                    return "F2";
                case 3:
                    return "F3";
            }
        }
        //}

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
