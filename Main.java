import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro(10);
        Jogador jogador = new Jogador("Luan", tabuleiro);
        FakeNews fakeNewsManager = new FakeNews("a");
        
        System.out.println("Bem-vindo ao Corra das Fake News!");
        System.out.println("Pressione ENTER para começar...");
        scanner.nextLine();
        
        int turno = 1;
        boolean jogoTerminado = false;
        
        while (!jogoTerminado) {
            System.out.println("Turno " + turno);
            
            // Movimento do jogador
            System.out.print("Digite a direção (n, s, l, o) para onde deseja mover: ");
            String direcao = scanner.nextLine().toLowerCase();
            jogador.mover(direcao);
            
            // Atualização das fake news
            fakeNewsManager.atualizarFakeNews();
            
            // Exibição do tabuleiro
            tabuleiro.exibirTabuleiro();
            
            // Verificação das condições de término do jogo
            jogoTerminado = tabuleiro.todasFakeNewsEliminadas() || !jogador.estaVivo();
            
            turno++;
        }
        
        if (tabuleiro.todasFakeNewsEliminadas()) {
            System.out.println("Parabéns! Você eliminou todas as fake news. Você venceu o jogo!");
        } else {
            System.out.println("Você foi eliminado pelas fake news. Fim de jogo!");
        }
        
        scanner.close();
    }
}