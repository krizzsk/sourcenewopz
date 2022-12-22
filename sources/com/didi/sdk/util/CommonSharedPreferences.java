package com.didi.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class CommonSharedPreferences {

    /* renamed from: a */
    private static final String f37576a = "common_sdk_sp";

    /* renamed from: b */
    private static volatile CommonSharedPreferences f37577b;

    /* renamed from: c */
    private SharedPreferences f37578c;

    /* renamed from: d */
    private SharedPreferences.Editor f37579d;

    private CommonSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, f37576a, 0);
        this.f37578c = sharedPreferences;
        this.f37579d = sharedPreferences.edit();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.didi.sdk.util.CommonSharedPreferences getInstance(android.content.Context r2) {
        /*
            java.lang.Class<com.didi.sdk.util.CommonSharedPreferences> r0 = com.didi.sdk.util.CommonSharedPreferences.class
            monitor-enter(r0)
            com.didi.sdk.util.CommonSharedPreferences r1 = f37577b     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x001c
            monitor-enter(r0)     // Catch:{ all -> 0x0020 }
            com.didi.sdk.util.CommonSharedPreferences r1 = f37577b     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            com.didi.sdk.util.CommonSharedPreferences r1 = new com.didi.sdk.util.CommonSharedPreferences     // Catch:{ all -> 0x0019 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0019 }
            r1.<init>(r2)     // Catch:{ all -> 0x0019 }
            f37577b = r1     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x0019:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x001c:
            com.didi.sdk.util.CommonSharedPreferences r2 = f37577b     // Catch:{ all -> 0x0020 }
            monitor-exit(r0)
            return r2
        L_0x0020:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.CommonSharedPreferences.getInstance(android.content.Context):com.didi.sdk.util.CommonSharedPreferences");
    }

    public void setIntValue(String str, int i) {
        this.f37579d.putInt(str, i);
        this.f37579d.apply();
    }

    public int getIntValue(String str) {
        return this.f37578c.getInt(str, -1);
    }

    public int getIntValue(String str, int i) {
        return this.f37578c.getInt(str, i);
    }

    public void setStringValue(String str, String str2) {
        this.f37579d.putString(str, str2);
        this.f37579d.apply();
    }

    public void putInt(String str, int i) {
        this.f37579d.putInt(str, i);
    }

    public void putString(String str, String str2) {
        this.f37579d.putString(str, str2);
    }

    public void putBoolean(String str, Boolean bool) {
        this.f37579d.putBoolean(str, bool.booleanValue());
    }

    public String getStrValue(String str) {
        return this.f37578c.getString(str, "");
    }

    public String getStrValue(String str, String str2) {
        return this.f37578c.getString(str, str2);
    }

    public void setGradeTipsShown() {
        this.f37579d.putBoolean("common_tips_status", true);
        this.f37579d.apply();
    }

    public boolean getGradeTipsStatus() {
        return this.f37578c.getBoolean("common_tips_status", false);
    }

    public void setLockScreenMapShow(boolean z) {
        this.f37579d.putBoolean("common_is_lock_screen_map_show", z);
        this.f37579d.apply();
    }

    public boolean isLockScreenMapShow() {
        return this.f37578c.getBoolean("common_is_lock_screen_map_show", true);
    }

    public void setLockScreenDialogRequestNum(int i) {
        this.f37579d.putInt("common_is_lock_screen_dialog_request", i);
        this.f37579d.apply();
    }

    public int getLockScreenDialogRequestNum() {
        return this.f37578c.getInt("common_is_lock_screen_dialog_request", 0);
    }

    public void setLockScreenNotShow(String str) {
        this.f37579d.putString("common_is_lock_screen_not_show", str);
        this.f37579d.apply();
    }

    public String getLockScreenNotShow() {
        return this.f37578c.getString("common_is_lock_screen_not_show", "");
    }
}
