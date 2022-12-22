package com.didi.dimina.container.bridge.permission;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface DMPermissionDescConfig {
    public static final String NONE_PERMISSION_DESC_CONTENT_MARK = "dimina_none_permission_desc_content_mark";

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionCode {
        public static final int CAMERA = 1;
        public static final int LOCATION = 3;
        public static final int RECORD = 4;
        public static final int STORAGE = 2;
    }

    String requirePermissionDescription(int i);
}
