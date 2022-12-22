package com.didi.safety.god.event;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.taxis99.R;

public class TaskType {

    /* renamed from: a */
    private static String f34568a;

    /* renamed from: b */
    private static SparseArray<String> f34569b = new SparseArray<>();

    public static void clear() {
        f34568a = "";
        f34569b.clear();
    }

    public static String getTaskDesc(int i) {
        return f34569b.get(i);
    }

    public static void setTaskArray(String str) {
        f34568a = str;
    }

    public static String getTaskArray() {
        return f34568a;
    }

    public static void putTaskType(int i, String str) {
        f34569b.put(i, str);
    }

    public static void initCardsInfo(String str, Activity activity) {
        setTaskArray(str);
        putTaskType(0, activity.getString(R.string.safety_god_driving_lis) + activity.getString(R.string.safety_god_detection_card_pre1));
    }

    public static String getSimpleName(Context context, String str) {
        return context.getString(R.string.safety_god_driving_lis);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int convertToLocalType(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 2
            r2 = 0
            r3 = 1
            switch(r0) {
                case 63489165: goto L_0x001f;
                case 63489166: goto L_0x0015;
                case 64233661: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0029
        L_0x000b:
            java.lang.String r0 = "CL_J1"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0029
            r4 = 0
            goto L_0x002a
        L_0x0015:
            java.lang.String r0 = "BR_S2"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0029
            r4 = 2
            goto L_0x002a
        L_0x001f:
            java.lang.String r0 = "BR_S1"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0029
            r4 = 1
            goto L_0x002a
        L_0x0029:
            r4 = -1
        L_0x002a:
            if (r4 == 0) goto L_0x0037
            if (r4 == r3) goto L_0x0034
            if (r4 == r1) goto L_0x0031
            goto L_0x0038
        L_0x0031:
            r2 = 102(0x66, float:1.43E-43)
            goto L_0x0038
        L_0x0034:
            r2 = 101(0x65, float:1.42E-43)
            goto L_0x0038
        L_0x0037:
            r2 = 1
        L_0x0038:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.event.TaskType.convertToLocalType(java.lang.String):int");
    }
}
