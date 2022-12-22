package com.didi.flutter.nacho;

import android.content.Context;
import java.util.Map;

public interface NativeInfoFetcher {
    Map<String, Object> getInfo(Context context);
}
