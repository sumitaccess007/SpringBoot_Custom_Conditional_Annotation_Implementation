package com.sumitaccess007.custom.conditional;

import com.sumitaccess007.condition.SMSProviderCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Conditional(SMSProviderCondition.class)
public @interface SMSProviderConditional {
    String providerType();
}
