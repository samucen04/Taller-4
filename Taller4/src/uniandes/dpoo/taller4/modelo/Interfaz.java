package uniandes.dpoo.taller4.modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Interfaz extends JPanel implements MouseListener {
    private Tablero tablero;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lights Out juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Interfaz panel = new Interfaz();
        panel.addMouseListener(panel);
        panel.setPreferredSize(new Dimension(601, 501));
        panel.setMinimumSize(new Dimension(601, 501));

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public Interfaz() {
        tablero = new Tablero(5); 
        tablero.desordenar(10); 
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void paint(Graphics g) {
        int anchoCelda = getWidth() / 5;  
        int altoCelda = getHeight() / 5;  

        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 5; col++) {
                if (tablero.darTablero()[fila][col]) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(col * anchoCelda, fila * altoCelda, anchoCelda, altoCelda);

                g.setColor(Color.BLUE);
                g.drawRect(col * anchoCelda, fila * altoCelda, anchoCelda, altoCelda);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        int anchoCelda = getWidth() / 5; 
        int altoCelda = getHeight() / 5; 

        int col = mouseX / anchoCelda;
        int fila = mouseY / altoCelda;

        if (fila >= 0 && col >= 0 && fila < 5 && col < 5) {
            tablero.jugar(fila, col);
            repaint();
        }
    }
}
