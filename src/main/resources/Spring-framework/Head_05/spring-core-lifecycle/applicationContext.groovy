import spring_framework.head_05.spring_core_lifecycle.dependency.init.DependencyWithConfig

beans {
    xmlns([ctx:'http://www.springframework.org/schema/context'])
    ctx.'component-scan'('base-package':"spring_framework.head_05.spring_core_lifecycle.dependency")

    dependencyWithConfig(DependencyWithConfig) { bean ->
        bean.initMethod = 'init'
    }
}