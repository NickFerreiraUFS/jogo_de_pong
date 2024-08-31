import java.awt.*;

import javax.swing.Timer;

public class Bola {
    // a bola precisa se mover para direita, esquerda, cima e baixo. E a cada choque ele muda de direção.
    private int posicaoX;
    private int posicaoY;
    private int acelerarX;
    private int acelerarY;
    private int raio;
    private Timer recarga = new Timer(5000, e-> volta());
    private boolean emPausa = false;

    //cria o bola
    public Bola(int posicaoX, int posicaoY){
        this.posicaoX =posicaoX;
        this.posicaoY = posicaoY;
        this.acelerarX = 10;
        this.acelerarY= 10;
        this.raio = 20;
        
    }

    // função para desenhar a bola
    public void load(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(posicaoX, posicaoY, raio, raio);
    }

    //funções de move para poder mover a bola
    public void move(int janelaAltura, int janelaLargura, Jogador jogador1, Jogador jogador2){
        if (emPausa) {
            return; // Não move a bola se estiver em pausa, consegui.
        }
        posicaoX +=acelerarX;
        posicaoY += acelerarY;

        //condicições para a bola trocar de sinal.
        if (posicaoY <= 0 || posicaoY >= 800 - raio) {
            choqueY();
        }

        if (posicaoX <= jogador1.getPosicaoX() + jogador1.getLargura() && posicaoY + raio >= jogador1.getPosicaoY() && posicaoY <= jogador1.getPosicaoY() + jogador1.getAltura()) {
            choqueX();            
        }

        if (posicaoX + raio >= jogador2.getPosicaoX() && posicaoY + raio >= jogador2.getPosicaoY() && posicaoY <= jogador2.getPosicaoY() + jogador2.getAltura()) {
            choqueX();
            
        }

        if (posicaoX <= 0 || posicaoX >= 1000 - raio) {
            pause();
            posicaoX = 1000/2;
            posicaoY = 800/2;
        }

    }
    //funções para poder mudar a direção da bola sempre que acontecer um choque
    public void choqueY(){
        acelerarY *=-1;
    }
    public void choqueX(){
        acelerarX *=-1;
    }
    public int getPosicaoX() {
        return posicaoX;
    }
    public int getPosicaoY() {
        return posicaoY;
    }
    public int getRaio() {
        return raio;
    }

    private void pause() {
        emPausa = true;
        recarga.start();
    }

    private void volta() {
        emPausa = false;
        recarga.stop();
    }

    
}
