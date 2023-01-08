abstract class Monster {
    private final String name;
    private int hp;
    private int force;
    private boolean destroyed;

    public Monster(String name, int hp, int force) {
        this.name = name;
        this.hp = hp;
        this.force = force;
        this.destroyed = false;
        System.out.printf("Monster %s was created!\n", name);
    }

    public void growl() {
        System.out.printf("%s growled!\n", this.name);
    }

    abstract void attack(Monster monster);

    protected boolean damage(int hp) {
        this.hp -= hp;
        System.out.println("Monster " + this.name + " current HP = " + this.hp);
        if (this.hp <= 0) {
            destroyed = true;
            System.out.println("Monster " + this.name + " was destroyed!");
        }
        return isDestroyed();
    }

    public int getForce() {
        return force;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                '}';
    }
}
