import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Janela extends JPanel implements ActionListener, KeyListener{
    private Jogador jogador1 = new  Jogador(15, 350, 15, 100);
    private Jogador jogador2 = new Jogador(960, 350, 15, 100);
    private Bola bola = new Bola(500, 400);
    private Timer time;// ms do jogo

    public Janela(){
        this.setBackground(Color.BLACK);
        time = new Timer(30, this);//define o ms como 30
        time.start();// o jogo começa e a cada 30 frames vai sendo atualizado
        setFocusable(true);// faz a janela ser o foco da tela, ou seja ela recebe os inputs.
        requestFocusInWindow();//reforça o foco.
        addKeyListener(this);// ela "escuta o teclado"
    }

    @Override
    //funçao reescrita do JPanel
    public void actionPerformed(ActionEvent e){
        bola.move(getWidth(), getHeight(), jogador1, jogador2);
        repaint();
    }
    @Override
    //checa as teclas pressionadas, provavelmente os ifs fazem o jogador parar por um frame antes de continuar a ação
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (jogador2.getPosicaoY() > 0) {
                jogador2.moveUp();
            }
            
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (jogador2.getPosicaoY() + jogador2.getAltura() + 20< getHeight() ) {
                jogador2.moveDown();
            }
            
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (jogador1.getPosicaoY() > 0) {
                jogador1.moveUp();
            }
            
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            if (jogador1.getPosicaoY() + jogador1.getAltura() + 20 < getHeight()) {
                jogador1.moveDown();
            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Aqui você pode implementar lógica para parar o movimento dos jogadores, se necessário.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não necessário para este jogo.
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        jogador1.load(g);
        jogador2.load(g);
        bola.load(g);
    }

}
