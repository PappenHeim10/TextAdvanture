package screen;

public enum Text {
    // Text-Enum für die verschiedenen Textarten
    
    ANFANGSTEXT("Was möchtest du tun?"),
    ANTWORTTEXT("Bitte gib deine Antwort ein:");
    

    private final String text;

    Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
