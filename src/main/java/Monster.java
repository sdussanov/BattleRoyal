abstract class Monster extends Entity implements Fightable{
    private final int force;


    public Monster(String name, int hp, int force) {
        super.name = name;
        super.hp = hp;
        this.force = force;
        this.destroyed = false;
        System.out.printf("Monster %s was created!\n", name);
    }

    public void growl() {
        System.out.printf("%s growled!\n", this.name);
    }


    public int getForce() {
        return force;
    }


    @Override
    public String toString() {
        return "Monster " + name;
    }
}
