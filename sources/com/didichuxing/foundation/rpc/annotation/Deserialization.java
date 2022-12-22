package com.didichuxing.foundation.rpc.annotation;

import com.didichuxing.foundation.p188io.Deserializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Deserialization {
    Class<? extends Deserializer> value();
}
