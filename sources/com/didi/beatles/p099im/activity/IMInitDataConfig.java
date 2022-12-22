package com.didi.beatles.p099im.activity;

/* renamed from: com.didi.beatles.im.activity.IMInitDataConfig */
public class IMInitDataConfig {
    public static String new_str;
    public static long peer_uid;
    public static int productId;

    public static void create() {
    }

    public static void release() {
        peer_uid = -1;
        new_str = "";
    }
}
