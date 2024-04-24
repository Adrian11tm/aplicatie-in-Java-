import java.awt.*;
import javax.swing.*;

class Target extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculăm centrul panoului
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Numărul de cercuri și spațierea între ele
        int numCircles = 5;
        int circleSpacing = 30;

        // Desenăm cercurile concentrice
        for (int i = 0; i < numCircles; i++) {
            int radius = (i + 1) * circleSpacing;

            // Calculăm poziția și dimensiunea cercului
            int x = centerX - radius;
            int y = centerY - radius;
            int diameter = radius * 2;

            // Setăm culoarea de umplere a cercului în funcție de paritatea iterației
            if (i % 2 == 0) {
                g.setColor(Color.RED); // Pentru iterațiile pare, setează culoarea la roșu
                System.out.println("Cercul " + (i + 1) + " este rosu.");
            } else {
                g.setColor(Color.WHITE); // Pentru iterațiile impare, setează culoarea la alb
                System.out.println("Cercul " + (i + 1) + " este alb.");
            }

            // Desenăm cercul plin
            g.fillOval(x, y, diameter, diameter);

            // Desenăm conturul cercului separat
            g.setColor(Color.BLACK);
            g.drawOval(x, y, diameter, diameter);
        }

        // Desenăm segmentele de linie orizontale și verticale
        g.setColor(Color.BLACK);
        g.drawLine(0, centerY, getWidth(), centerY); // Linie orizontală
        g.drawLine(centerX, 0, centerX, getHeight()); // Linie verticală
    }

    public static void main(String[] args) {
        // Creăm fereastra și adăugăm panoul cu ținta
        JFrame frame = new JFrame();
        frame.setSize(500, 500); // Mărimea ferestrei a fost mărită pentru a da mai mult spațiu pentru cercuri și segmentele de linie
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setăm culoarea de fundal a panoului la alb
        Target target = new Target();
        target.setBackground(Color.WHITE);

        frame.add(target);
        frame.setVisible(true);
    }
}
