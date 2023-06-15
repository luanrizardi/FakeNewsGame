public class Jogador extends Objeto {
    private int num;

    public Jogador(int num, int x, int y) {
        super(x, y);
        this.num = num;
    }

    public int getNum() {
        return num;
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

    public void printarInstrucoes(Jogador jogador, int turnos){
        System.out.print("\n -------------------------------------------------------------------------");
        System.out.print("\n| TURNO " + turnos + "                                                                |");
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
