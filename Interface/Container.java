import javax.swing.JFrame;

public class Container extends JFrame {
    public Container() {
        this.setTitle("Pong");
        this.setSize(1000, 800);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Janela janela = new Janela();
        this.add(janela);
        this.setVisible(true);
        janela.requestFocusInWindow(); // Garantir que a Janela receba o foco
    }

    public static void main(String[] args) {
        new Container();
    }
}