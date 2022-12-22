package com.didi.drouter.router;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface RouterType {
    public static final int ACTIVITY = 1;
    public static final int FRAGMENT = 2;
    public static final int HANDLER = 4;
    public static final int MULTIPLE = -1;
    public static final int UNDEFINED = 0;
    public static final int VIEW = 3;
}
