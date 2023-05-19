class Tabuleiro {
    private int[][] posicoes;
    private int tamanho;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.posicoes = new int[tamanho][tamanho];
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setPosicao(int x, int y, int valor) {
        posicoes[x][y] = valor;
    }

    public int getPosicao(int x, int y) {
        return posicoes[x][y];
    }

    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(posicoes[i][j] + " ");
            }
            System.out.println();
        }
    }
}