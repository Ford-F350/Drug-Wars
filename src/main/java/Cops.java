public class Cops {

    protected Guns Gun;
    protected int health;
    protected String Name;

    //Cops have one gun with unlimited ammo and default of 3 health

    public Cops() {
        this.Gun = new Guns();
        this.health = 3;
        this.Name = "null";
    }

    public Cops(int health, String CopName) {
        this.Gun = new Guns();
        this.health = health;
        this.Name = CopName;

    }

    public Guns getGun() {
        return Gun;
    }

    public void setGun(Guns gun) {
        Gun = gun;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
