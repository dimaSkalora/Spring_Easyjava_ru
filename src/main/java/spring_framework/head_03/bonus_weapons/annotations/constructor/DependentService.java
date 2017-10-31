package spring_framework.head_03.bonus_weapons.annotations.constructor;

import org.springframework.stereotype.Service;

@Service
public class DependentService {
    private KnifeService knifeService;
    private DaggerService daggerService;

    public DependentService(KnifeService knifeService, DaggerService daggerService) {
        this.knifeService = knifeService;
        this.daggerService = daggerService;
    }

    public void areLocated(){
        System.out.println("В правой руке "+knifeService.nameKnife());
        System.out.println("В левой руке "+daggerService.nameDagger());
    }
}
