abstract class Character implements Fighter {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int mana;
    private int strength;
    private int agility;
    private int intelligence;
    private int exp;
    private int gold;

    public Character(String name, int health, int attack, int defence, int mana, int strength, int agility, int intelligence, int exp, int gold) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defence;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.exp = exp;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defence) {
        this.defense = defence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public int attack(Character enemy) {
        int damage = Math.max(0, this.attack - enemy.getDefense());
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        return damage;
    }

    public void gainExpPoints(int exp) {
        this.exp += exp;
    }

    public void gainGold(int gold) {
        this.gold += gold;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
