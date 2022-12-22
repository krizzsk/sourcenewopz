package com.didichuxing.omega.sdk.feedback.util;

import java.util.Map;

public class OmegaHelper {
    private Class<?> omegaSDK;

    private OmegaHelper() {
        try {
            this.omegaSDK = Class.forName("com.didichuxing.omega.sdk.init.OmegaSDK");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class SingleHolder {
        public static final OmegaHelper instance = new OmegaHelper();

        private SingleHolder() {
        }
    }

    public static OmegaHelper getInstance() {
        return SingleHolder.instance;
    }

    public void trackEvent(String str) {
        Class<?> cls = this.omegaSDK;
        if (cls != null) {
            ReflectHelper.invokeStaticMethod(cls, "trackEvent", new Class[]{String.class}, new Object[]{str});
        }
    }

    public void trackEvent(String str, Map<String, Object> map) {
        Class<?> cls = this.omegaSDK;
        if (cls != null) {
            ReflectHelper.invokeStaticMethod(cls, "trackEvent", new Class[]{String.class, Map.class}, new Object[]{str, map});
        }
    }
}
