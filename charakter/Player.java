package charakter;
import java.util.ArrayList;

public class Player {
    int baseHP = 100;
    int baseDef = 0;
    int baseMana = 10;
    int baseAttack = 5;
    int baseSpeed = 5;
    int baseLuck = 5;
    int baseIntelligence = 5;
    int baseStrength = 5;
    int baseWisdom = 5;
    int baseCharisma = 5;
    int baseDexterity = 5;
    int baseConstitution = 5;
    int baseAgility = 5;

    int baseLevel = 1;
    int baseExperience = 0;

    int baseGold = 0;
    int baseSkillPoints = 0;
    int baseSkillPointsUsed = 0;

    public Player() {
        // Hier könntest du Logik zur Initialisierung des Spielers einfügen, falls nötig.

    }

    public void levelUp() {
        // Methode zum Leveln des Spielers
        baseLevel++;
        baseSkillPoints += 5; // Beispiel: 5 Skillpunkte pro Level
    }
    public void addExperience(int experience) {
        // Methode zum Hinzufügen von Erfahrung
        baseExperience += experience;
        if (baseExperience >= 100) { // Beispiel: 100 Erfahrung für ein Level-Up
            levelUp();
        }
    }
    public void addGold(int gold) {
        // Methode zum Hinzufügen von Gold
        baseGold += gold;
    }
    public void spendSkillPoint() {
        // Methode zum Ausgeben eines Skillpunkts
        if (baseSkillPoints > 0) {
            baseSkillPoints--;
            baseSkillPointsUsed++;
        }
    }
    public void resetSkillPoints() {
        // Methode zum Zurücksetzen der Skillpunkte
        baseSkillPoints += baseSkillPointsUsed;
        baseSkillPointsUsed = 0;
    }
    public void gainHP(int hp) {
        // Methode zum Hinzufügen von HP
        baseHP += hp;
    }
    public void gainMana(int mana) {
        // Methode zum Hinzufügen von Mana
        baseMana += mana;
    }
    public void gainAttack(int attack) {
        // Methode zum Hinzufügen von Attack
        baseAttack += attack;
    }
    public void gainDef(int def) {
        // Methode zum Hinzufügen von Def
        baseDef += def;
    }
    public void gainSpeed(int speed) {
        // Methode zum Hinzufügen von Speed
        baseSpeed += speed;
    }
    public void gainLuck(int luck) {
        // Methode zum Hinzufügen von Luck
        baseLuck += luck;
    }
    public void gainIntelligence(int intelligence) {
        // Methode zum Hinzufügen von Intelligence
        baseIntelligence += intelligence;
    }
    public void gainStrength(int strength) {
        // Methode zum Hinzufügen von Strength
        baseStrength += strength;
    }
    public void gainWisdom(int wisdom) {
        // Methode zum Hinzufügen von Wisdom
        baseWisdom += wisdom;
    }
    public void gainCharisma(int charisma) {
        // Methode zum Hinzufügen von Charisma
        baseCharisma += charisma;
    }
    public void gainDexterity(int dexterity) {
        // Methode zum Hinzufügen von Dexterity
        baseDexterity += dexterity;
    }
    public void gainConstitution(int constitution) {
        // Methode zum Hinzufügen von Constitution
        baseConstitution += constitution;
    }
    public void gainAgility(int agility) {
        // Methode zum Hinzufügen von Agility
        baseAgility += agility;
    }

    public boolean useMana(int mana) {
        // Methode zum Verwenden von Mana
        if (baseMana >= mana) {
            baseMana -= mana;
            return true; // Mana erfolgreich verwendet
        } else {
            return false; // Nicht genug Mana
        }
    }


    public ArrayList<String> showStats() {
        // Methode zum Anzeigen der Spielerstatistiken
        System.out.println("Level: " + baseLevel);
        System.out.println("HP: " + baseHP);
        System.out.println("Def: " + baseDef);        System.out.println("Mana: " + baseMana);
        System.out.println("Attack: " + baseAttack);        System.out.println("Speed: " + baseSpeed);
        System.out.println("Luck: " + baseLuck);        System.out.println("Intelligence: " + baseIntelligence);
        System.out.println("Strength: " + baseStrength);        System.out.println("Wisdom: " + baseWisdom);
        System.out.println("Charisma: " + baseCharisma);        System.out.println("Dexterity: " + baseDexterity);
        System.out.println("Constitution: " + baseConstitution);        System.out.println("Agility: " + baseAgility);

        ArrayList<String> stats = new ArrayList<>();
        stats.add("Level: " + baseLevel);
        stats.add("HP: " + baseHP);
        stats.add("Def: " + baseDef);
        stats.add("Mana: " + baseMana);
        stats.add("Attack: " + baseAttack);
        stats.add("Speed: " + baseSpeed);
        stats.add("Luck: " + baseLuck);
        stats.add("Intelligence: " + baseIntelligence);
        stats.add("Strength: " + baseStrength);
        stats.add("Wisdom: " + baseWisdom);
        stats.add("Charisma: " + baseCharisma);
        stats.add("Dexterity: " + baseDexterity);
        stats.add("Constitution: " + baseConstitution);
        stats.add("Agility: " + baseAgility);

        return stats;
    }
}
