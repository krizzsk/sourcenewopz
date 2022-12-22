package com.didichuxing.xpanel.util;

import org.osgi.framework.ServicePermission;

public class RegisterUtil {
    public static void registeChannelCardView(Channel channel) {
        try {
            Class.forName(channel.getClasspath()).getDeclaredMethod(ServicePermission.REGISTER, new Class[0]).invoke(Class.forName(channel.getClasspath()).newInstance(), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum Channel {
        DOMESTIC("com.didichuxing.xpanel.XPanelModels"),
        GLOBAL("com.didichuxing.xpanel.global.models.XPanelModels"),
        GLOBAL_DRIVER("");
        
        private String classpath;

        public String getClasspath() {
            return this.classpath;
        }

        private Channel(String str) {
            this.classpath = str;
        }
    }
}
