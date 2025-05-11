package screen;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Window extends JFrame {
    
    public Window() {

    }
    public void init() {
        setTitle("Only Others Left Alive"); // Fenstertitel
        setSize(800, 600); // Fenstergröße
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beenden, wenn das Fenster geschlossen wird
        setLocationRelativeTo(null); // Fenster in der Mitte des Bildschirms platzieren
        setLayout(new BorderLayout()); // Layout-Manager setzen
        
        GamePanel gamePanel = new GamePanel(); // Erstelle eine Instanz von GamePanel
        add(gamePanel, BorderLayout.CENTER); // Füge das GamePanel zum Fenster hinzu
        
        setVisible(true); // Fenster sichtbar machen
    }
}
