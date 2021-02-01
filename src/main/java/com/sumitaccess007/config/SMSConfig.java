package com.sumitaccess007.config;

import com.sumitaccess007.condition.SMSProviderCondition;
import com.sumitaccess007.custom.conditional.SMSProviderConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SMSConfig {

    @Bean
    @SMSProviderConditional(providerType = "airtel")
    public void activateAirtelProvider(){
        System.out.println("In Airtel Provider method");
    }

    @Bean
    @SMSProviderConditional(providerType = "idea")
    public void activateIdeaProvider(){
        System.out.println("In Idea Provider method");
    }
}
