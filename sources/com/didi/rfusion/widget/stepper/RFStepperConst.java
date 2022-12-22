package com.didi.rfusion.widget.stepper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface RFStepperConst {
    public static final int CODE = 0;
    public static final int LARGE = 0;
    public static final int MINUS_ACTION = 1;
    public static final int PLUS_ACTION = 2;
    public static final int SMALL = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StepperSourceType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StepperSpec {
    }
}
