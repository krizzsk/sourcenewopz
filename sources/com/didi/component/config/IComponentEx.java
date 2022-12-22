package com.didi.component.config;

import android.os.Bundle;
import com.didi.component.core.IComponent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface IComponentEx extends IComponent {
    public static final String BUNDLE_KEY_BID = "BUNDLE_KEY_BID";
    public static final String BUNDLE_KEY_COMBO_TYPE = "BUNDLE_KEY_COMBO_TYPE";
    public static final String BUNDLE_KEY_PARAMS = "BUNDLE_KEY_PARAMS";
    public static final String BUNDLE_KEY_PARENT_SID = "BUNDLE_KEY_PARENT_SID";
    public static final String BUNDLE_KEY_SID = "BUNDLE_KEY_SID";
    public static final String BUNDLE_KEY_TYPE = "BUNDLE_KEY_TYPE";

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Config {
        Class<? extends BaseComponentConfig> value();
    }

    <T> T getExtra(String str);

    void setExtras(Bundle bundle);
}
