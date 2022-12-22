package com.didi.global.globalresource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class GRResourceLoaderFactory {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResourceType {
        public static final int XML = 1;
    }

    public static GRBaseResourceLoader getResourceLoader(int i) {
        if (i != 1) {
            return null;
        }
        return new GRXMLResourceLoader();
    }
}
