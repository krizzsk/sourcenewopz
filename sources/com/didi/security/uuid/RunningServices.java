package com.didi.security.uuid;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

public class RunningServices {
    public String services(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(20);
            for (int i = 0; i < runningServices.size(); i++) {
                ActivityManager.RunningServiceInfo runningServiceInfo = runningServices.get(i);
                int i2 = runningServiceInfo.uid;
                sb.append(i2);
                sb.append(",");
                sb.append(runningServiceInfo.service.getPackageName() + "/" + runningServiceInfo.service.getShortClassName());
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
