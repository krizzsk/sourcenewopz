package com.didichuxing.omega.sdk.feedback.leaked;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class LeakMaker<T> {
    private static List<LeakMaker> leakMakerList = new ArrayList();
    List<T> uselessObjectList = new ArrayList();

    /* access modifiers changed from: package-private */
    public abstract void startLeak(Context context);

    public static void makeLeak(Context context) {
        leakMakerList.add(new ActivityLeakMaker());
        leakMakerList.add(new BitmapLeakMaker());
        leakMakerList.add(new ByteArrayLeakMaker());
        leakMakerList.add(new FragmentLeakMaker());
        leakMakerList.add(new StringLeakMaker());
        for (LeakMaker startLeak : leakMakerList) {
            startLeak.startLeak(context);
        }
    }
}
