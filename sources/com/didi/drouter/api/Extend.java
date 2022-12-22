package com.didi.drouter.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Extend {
    public static final String REQUEST_BUILD_URI = "DRouter_request_build_uri";
    public static final String START_ACTIVITY_ANIMATION = "DRouter_start_activity_animation";
    public static final String START_ACTIVITY_FLAGS = "DRouter_start_activity_flags";
    public static final String START_ACTIVITY_OPTIONS = "DRouter_start_activity_options";
    public static final String START_ACTIVITY_REQUEST_CODE = "DRouter_start_activity_request_code";
    public static final String START_ACTIVITY_VIA_INTENT = "DRouter_start_activity_via_intent";
    public static final String START_ACTIVITY_WITH_DEFAULT_SCHEME_HOST = "DRouter_start_activity_with_default_scheme_host";
    public static final String START_FRAGMENT_NEW_INSTANCE = "DRouter_start_fragment_new_instance";
    public static final String START_VIEW_NEW_INSTANCE = "DRouter_start_view_new_instance";

    @Retention(RetentionPolicy.SOURCE)
    public @interface Cache {

        /* renamed from: NO */
        public static final int f19116NO = 0;
        public static final int SINGLETON = 2;
        public static final int WEAK = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Resend {
        public static final int NO_RESEND = 0;
        public static final int WAIT_ALIVE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Thread {
        public static final int MAIN = 1;
        public static final int POSTING = 0;
        public static final int WORKER = 2;
    }
}
