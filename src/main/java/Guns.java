public class Guns {

    protected int power;
    protected int ammo;
    protected int accuracy;
    protected String name;

    // power scale 1 - 10
    // accuracy scale 1 - 10
    // 1 = 10% hit chance
    //10 = 100% hit chance


    public Guns() {
        this.accuracy = 1;
        this.ammo = 0;
        this.power = 1;
        this.name = "Null";
    }

    public Guns(int power, int accuracy, int ammo, String name) {
        this.power = between(power);
        this.accuracy = between(accuracy);
        this.ammo = Math.max(0, ammo);
        this.name = name;
    }

    private static int between(int i) {
        if (i > 10) {
            i = 10;
        } else if (i < 1) {
            i = 1;
        }
        return i;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
