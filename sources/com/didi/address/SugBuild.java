package com.didi.address;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SugBuild {

    /* renamed from: a */
    private int f4302a;

    @Retention(RetentionPolicy.CLASS)
    public @interface Version {
        public static final int EXPERIMENT_A = 1;
        public static final int EXPERIMENT_B = 2;
        public static final int EXPERIMENT_C = 3;
    }

    public int getVersion() {
        return this.f4302a;
    }

    public void setVersion(int i) {
        this.f4302a = i;
    }
}
