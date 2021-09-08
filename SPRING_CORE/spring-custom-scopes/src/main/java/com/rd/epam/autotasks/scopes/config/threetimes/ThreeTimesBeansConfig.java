package com.rd.epam.autotasks.scopes.config.threetimes;

import com.rd.epam.autotasks.scopes.config.bean.ThreeTimeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ThreeTimesBeansConfig {

    @Scope(scopeName = "threeTimes")
    @Bean("threeTimesBean1")
    public Object threeTimesBean1() {
        ThreeTimeBean bean = new ThreeTimeBean(1, "first");
        return bean;
    }

    @Scope(scopeName = "threeTimes")
    @Bean("threeTimesBean2")
    public Object threeTimesBean2() {
        ThreeTimeBean bean = new ThreeTimeBean(2, "second");
        return bean;
    }

}
