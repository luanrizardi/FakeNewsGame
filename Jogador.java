public class Jogador {
    private int num;
    private int x;
    private int y;

    public Jogador(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    public int getNum() {
        return num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void mover(String direcao){
        int novaLinha = getX();
        int novaColuna = getY();
        switch (direcao) {
            case "W":
                novaLinha--;
                setX(novaLinha);
                break;
            case "S":
                novaLinha++;
                setX(novaLinha);
                break;
            case "A":
                novaColuna--;
                setY(novaColuna);
                break;
            case "D":
                novaColuna++;
                setY(novaColuna);
                break;
        }
    }

    public void printarInstrucoes(Jogador jogador){
        System.out.print("\n -------------------------------------------------------------------------");
        System.out.print("\n| ASSIM ESTÁ O TABULEIRO. PARA ONDE DESEJA MOVER O JOGADOR " + jogador.getNum() + " ?           |");
        System.out.print("\n| W = CIMA                                                               |");
        System.out.print("\n| A = ESQUERDA                                                           |");
        System.out.print("\n| S = BAIXO                                                              |");
        System.out.print("\n| D = DIREITA                                                            |");
        System.out.print("\n|                                                                        |");
        System.out.print("\n| X = SAIR DO PROGRAMA                                                   |");
        System.out.println("\n -------------------------------------------------------------------------");
    }

    //item
}
