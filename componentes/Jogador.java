import java.awt.Color;
import java.awt.Graphics;

public class Jogador {
    private int posicaoX;
    private int posicaoY;
    private int largura;
    private int altura;

    //função para criar o jogador
    public Jogador(int x, int y, int largura, int altura){
        this.posicaoX = x;
        this.posicaoY = y;
        this.largura = largura;
        this.altura = altura;
    }
    //função para desenhar
    public void load(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(posicaoX, posicaoY, largura, altura);
    }

    public void moveUp(){
        posicaoY-=20;
    }
    public void moveDown(){
        posicaoY+=20;
    }
    // como não fazemos o jogado se mover para direita e para a esquerda, não precisamos mudar o x
    
    public int getPosicaoX() {
        return posicaoX;
    }
    public int getPosicaoY() {
        return posicaoY;
    }
    public int getLargura() {
        return largura;
    }
    public int getAltura() {
        return altura;
    }
    

    
}
