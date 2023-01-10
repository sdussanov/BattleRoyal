abstract class Entity {
    protected String name;
    protected int hp;
    protected boolean destroyed;

    Entity(String name, int hp){
        this.name = name;
        this.hp = hp;
        this.destroyed = false;
    }

    protected void damage(int hp) {
        this.hp -= hp;
        System.out.printf("%s %s current Health = %d HP\n", this.getClass().getName(), name, this.hp);
        if (this.hp <= 0) {
            destroyed = true;
            System.out.printf("%s %s was destroyed!\n",this.getClass().getName(), name);
        }
    }

    protected boolean isDestroyed() {
        return destroyed;
    }

    protected String getName(){
        return name;
    }
}
