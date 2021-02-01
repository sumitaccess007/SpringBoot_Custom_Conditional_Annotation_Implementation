package com.sumitaccess007.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class SMSProviderCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes("com.sumitaccess007.custom.conditional.SMSProviderConditional");
        String givenProviderType = (String) map.get("providerType");
        String activatedProviderType = System.getProperty("sms.provider");
        if(activatedProviderType == null){
            Environment environment = conditionContext.getEnvironment();
            activatedProviderType = environment.getProperty("sms.provider");
            if (activatedProviderType == null){
                return false;
            } else {
                return givenProviderType.equalsIgnoreCase(activatedProviderType);
            }
        } else {
            return givenProviderType.equalsIgnoreCase(activatedProviderType);
        }
    }
}
