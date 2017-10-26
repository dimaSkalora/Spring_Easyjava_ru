package spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.robot;

import spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.weapons.PistolWeaponsImpl;
import spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.weapons.Weapons;

public class ModelT800 implements Robot {
    private String nameRobot;
    private Weapons weapons;


    public ModelT800() {
    }

    public ModelT800(Weapons weapons) {
        this.weapons = weapons;
    }

    public ModelT800(String nameRobot, Weapons weapons) {
        this.nameRobot = nameRobot;
        this.weapons = weapons;
    }

    @Override
    public void action() {
        System.out.print("Имя робота: ");
        System.out.println(getNameRobot());
        System.out.println("Уничтожыть машину с помощу оружыя");
        weapons.weapon();
    }

    public String getNameRobot() {
        return nameRobot;
    }

    public void setNameRobot(String nameRobot) {
        this.nameRobot = nameRobot;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(PistolWeaponsImpl weapons) {
        this.weapons = weapons;
    }
}
