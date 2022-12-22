package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.app.Activity;
import com.didi.dimina.container.DMMina;

public class ChooseImageReq {
    public static final int CAPTURE_TYPE_DEFAULT = 0;
    private static final int COUNT_DEFAULT = 1;
    public static final int MAX_ALLOWED_COUNT = 9;
    public static final int MAX_SIZE_DEFAULT = 500;
    public static final String SOURCE_TYPE_ALBUM = "album";
    public static final String SOURCE_TYPE_ALL = "all";
    public static final String SOURCE_TYPE_CAMERA = "camera";
    public final Activity activity;
    public int captureType = 0;
    public int count = 1;
    public int maxSize = 500;
    public DMMina mina;
    public String sourceType = "all";

    public ChooseImageReq(DMMina dMMina, Activity activity2) {
        this.mina = dMMina;
        this.activity = activity2;
    }
}
