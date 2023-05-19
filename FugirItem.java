import java.util.Random;

class FugirItem extends Item {
    public FugirItem() {
        super("Fugir");
    }

    public void usarItem(Jogador jogador) {
        Random random = new Random();
        int novaPosicaoX = random.nextInt(jogador.getTabuleiro().getTamanho());
        int novaPosicaoY = random.nextInt(jogador.getTabuleiro().getTamanho());
        jogador.setPosicao(novaPosicaoX, novaPosicaoY);
        System.out.println("Jogador fugiu para a posição (" + novaPosicaoX + ", " + novaPosicaoY + ")");
    }
}