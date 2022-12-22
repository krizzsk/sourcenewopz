package com.didichuxing.omega.sdk.feedback.leaked;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class ActivityLeakMaker extends LeakMaker<Activity> {
    public void startLeak(Context context) {
        LeakedActivity.setUselessObjectList(new ArrayList());
        context.startActivity(new Intent(context, LeakedActivity.class));
    }

    public static class LeakedActivity extends Activity {
        static List<Activity> uselessObjectList;

        public static void setUselessObjectList(List<Activity> list) {
            uselessObjectList = list;
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            SystemUtils.hookOnlyFullscreenOpaque(this);
            super.onCreate(bundle);
            if (uselessObjectList == null) {
                uselessObjectList = new ArrayList();
            }
            uselessObjectList.add(this);
            finish();
        }
    }
}
