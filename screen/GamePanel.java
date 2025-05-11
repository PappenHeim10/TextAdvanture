package screen;

import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point; // Wichtig: Point-Klasse für Koordinaten importieren
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import charakter.*;

public class GamePanel extends JPanel {
    private Player player = new Player();
    private int currentScreen = 0;
    private ArrayList<String> eingabeListe = new ArrayList<>();
    private JTextField inputField;

    // Zufallsgenerator und Stern-bezogene Variablen
    private Random rand = new Random(); // Einmal pro Panel-Instanz initialisiert
    // Die Variable 'sterne' aus deinem Code speichert bereits die *Anzahl* der Sterne.
    // Wir nennen sie hier 'anzahlSterne' zur Verdeutlichung und initialisieren sie im Konstruktor.
    private int anzahlSterne; 
    private ArrayList<Point> sternKoordinaten; // Liste zum Speichern der Sternpositionen

    // Panel-Dimensionen (könnten auch als finale Konstanten deklariert werden)
    private final int PANEL_BREITE = 800;
    private final int PANEL_HOEHE = 600;


    @Override // Gute Praxis, @Override hinzuzufügen
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Rufe die Methode der Superklasse auf

        // Hintergrund zeichnen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, PANEL_BREITE, PANEL_HOEHE);

        // Sterne zeichnen (jetzt von den gespeicherten Koordinaten)
        g.setColor(Color.WHITE);
        if (sternKoordinaten != null) { // Sicherstellen, dass die Liste initialisiert ist
            for (Point sternPos : sternKoordinaten) {
                // sternPos.x und sternPos.y enthalten die im Konstruktor generierten Koordinaten
                g.fillOval(sternPos.x, sternPos.y, 3, 3); // Zeichne einen Stern
            }
        }

        // Dein restlicher Zeichencode...
        g.setColor(Color.WHITE);
        g.fillRect((PANEL_BREITE - 200) / 2, 100, 200, 50);

        g.setColor(Color.RED);
        // Stelle sicher, dass Text.ANFANGSTEXT.getText() verfügbar und korrekt ist
        // Für dieses Beispiel gehe ich davon aus, dass es funktioniert.
        if (Text.ANFANGSTEXT != null) { // Kleine Sicherheitsüberprüfung
             g.drawString(Text.ANFANGSTEXT.getText(), (PANEL_BREITE - 200) / 2 + 35, 130);
        }else{
            g.drawString("Es gib ein Problem mit dem Textaufruf.", (PANEL_BREITE - 200) / 2 + 35, 130);
        }

        // Hier ist das ergebnis der Eingabe "Change"
        if (currentScreen == 1) {
            g.setColor(Color.GREEN);
            g.fillOval(100, 100, 200, 200);
            g.setColor(Color.BLACK);
            g.drawString("Bild geändert!", 200, 200);
        }

        // Eingabefeld zeichnen
        g.setColor(Color.WHITE);
        int yPos = 450;
        for (String eingabe : eingabeListe) {
            g.drawString(eingabe, (PANEL_BREITE - 400) / 2, yPos);
            yPos += 20;
        }

        // Spieler-Statistiken zeichnen
        g.setColor(Color.WHITE); //OPTIM: Einen Hintergrund Zeichen
        int statPosition = 0;
        ArrayList<String> stats = initialisierePlayerStats();
        for(String stat : stats){
            g.drawString(stat, 10, 20 + statPosition);
            statPosition += 20;
        }
    }

    public GamePanel() {
        setLayout(null);
        
        // Sterne initialisieren (Anzahl und Positionen festlegen)
        initialisiereSterne(); // Diese Methode rufen wir jetzt hier auf

        inputField = new JTextField();
        // Verwende die Konstanten für die Breite
        inputField.setBounds((PANEL_BREITE - 400) / 2, 400, 400, 30);
        add(inputField);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                processInput(input);
                inputField.setText("");
            }
        });
        setFocusable(true);
        requestFocusInWindow();
    }

    /**
     * Initialisiert die Sterne, indem ihre Anzahl und zufälligen Positionen
     * einmalig festgelegt und gespeichert werden.
     */
    private void initialisiereSterne() {
        // Die Anzahl der Sterne bestimmen (deine Logik: zwischen 75 und 374)
        this.anzahlSterne = rand.nextInt(300) + 75; 
        this.sternKoordinaten = new ArrayList<>(); // Initialisiere die Liste für die Koordinaten

        for (int i = 0; i < this.anzahlSterne; i++) {
            // Korrekte Koordinatengenerierung für die Panel-Größe
            // x-Koordinate innerhalb der Panel-Breite (0 bis PANEL_BREITE-1)
            int x = rand.nextInt(PANEL_BREITE); 
            // y-Koordinate innerhalb der Panel-Höhe (0 bis PANEL_HOEHE-1)
            int y = rand.nextInt(PANEL_HOEHE); 
            
            // Füge den neuen Punkt (Sternposition) zur Liste hinzu
            this.sternKoordinaten.add(new Point(x, y)); 
        }
    }

    private ArrayList<String> initialisierePlayerStats(){
        ArrayList<String> playerStats = player.showStats();
        return playerStats;
    }

    private void processInput(String input) {
        System.out.println("Eingabe: " + input);
        eingabeListe.add(0, input);

        if (input.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else if (input.equalsIgnoreCase("change")) {
            currentScreen = 1;
            repaint();
        }else if(input.equalsIgnoreCase("Feuerball")){
            currentScreen = 2;
            boolean success = player.useMana(5);
            if(success){
                eingabeListe.add(0, "Feuerball geworfen!");
            }else{
                eingabeListe.add(0, "Nicht genügend Mana!");
            }
            repaint();
        }else {
            repaint();
        }
    }
    
}