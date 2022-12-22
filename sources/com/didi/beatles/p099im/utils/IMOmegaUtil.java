package com.didi.beatles.p099im.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.utils.IMOmegaUtil */
public class IMOmegaUtil {
    public static final int SOURCE_ACTIVITY_AUTO_GO = 6;
    public static final int SOURCE_ACTIVITY_INVITE = 5;
    public static final int SOURCE_ACTIVITY_ORDER_DETAIL = 4;
    public static final int SOURCE_ACTIVITY_PERSON = 7;
    public static final int SOURCE_IM_HELPER_FEED = 9;
    public static final int SOURCE_IM_HELPER_LIST = 10;
    public static final int SOURCE_IM_INNER_PUSH = 2;
    public static final int SOURCE_IM_LIST = 1;
    public static final int SOURCE_IM_NOTIFICATION = 3;
    public static final int SOURCE_OTHER = 8;
    public static final int SOURCE_TRAVEL_ASSISTANT_TO_ROBOT_PRAISE = 11;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.utils.IMOmegaUtil$IMMessageActivityResource */
    public @interface IMMessageActivityResource {
    }
}
