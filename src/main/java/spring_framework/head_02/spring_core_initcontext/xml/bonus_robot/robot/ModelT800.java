package spring_framework.head_02.spring_core_initcontext.xml.bonus_robot.robot;

import spring_framework.head_02.spring_core_initcontext.xml.bonus_robot.weapons.Weapons;

public class ModelT800 implements Robot{
    private String nameRobot;
    private Weapons weapons;

    @Override
    public void action() {
        System.out.print("Имя робота: ");
        System.out.println(getNameRobot());
        System.out.println("Уничтожыть машину с помощу оружыя");
        getWeapons().weapon();
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

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }
}
