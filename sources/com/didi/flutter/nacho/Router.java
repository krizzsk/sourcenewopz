package com.didi.flutter.nacho;

import android.content.Context;
import java.util.HashMap;

public interface Router {
    boolean open(Context context, String str);

    boolean open(Context context, String str, HashMap<String, Object> hashMap);

    Router register(Page page);
}
