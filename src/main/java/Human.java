public class Human extends Entity implements Fightable{
    private int force;

    public Human(String name) {
        super(name, 35);
        force = 20;
    }

    @Override
    public void attack(Entity entity) {
        entity.damage(this.force);
    }
}
