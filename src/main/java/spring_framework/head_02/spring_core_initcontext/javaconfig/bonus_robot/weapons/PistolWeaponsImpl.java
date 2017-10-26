package spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.weapons;

public class PistolWeaponsImpl implements Weapons {
    private String nameWeapons;

    public PistolWeaponsImpl() {
    }

    public PistolWeaponsImpl(String nameWeapons) {
        this.nameWeapons = nameWeapons;
    }

    @Override
    public void weapon() {
        System.out.println("PistolWeapons: "+getNameWeapons());
    }

    public String getNameWeapons() {
        return nameWeapons;
    }

    public void setNameWeapons(String nameWeapons) {
        this.nameWeapons = nameWeapons;
    }
}
