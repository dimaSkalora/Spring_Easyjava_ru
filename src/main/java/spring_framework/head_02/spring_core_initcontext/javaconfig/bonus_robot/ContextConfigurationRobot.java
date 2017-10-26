package spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot;

import org.springframework.context.annotation.Bean;
import spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.robot.ModelT800;
import spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.robot.Robot;
import spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.weapons.PistolWeaponsImpl;
import spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.weapons.Weapons;

/**
 * Spring context configuration descriptor.
 */
public class ContextConfigurationRobot {
    /**
     * "Random" service bean.
     * @return Java's built-in random generator.
     */

    @Bean
    public Weapons weapons(){
      /*  PistolWeaponsImpl pistolWeapons = new PistolWeaponsImpl();
        pistolWeapons.setNameWeapons("ijihhuuh");
        return pistolWeapons;*/
      return new PistolWeaponsImpl("Revoler");
    }

    @Bean
    public Robot robot(){
        return new ModelT800("ModelT800",weapons());
    }


}
