package com.didi.soda.business.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BusinessPageLifeState implements IEntity {
    private static final long serialVersionUID = -6178254098765017756L;
    public int state;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BusinessPageLifeScene {
        public static final int DEFAULT = 0;
        public static final int DESTROYED = 1;
    }

    public BusinessPageLifeState(int i) {
        this.state = i;
    }
}
