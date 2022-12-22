package com.didi.dimina.container.util;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.dimina.container.Dimina;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/dimina/container/util/PerformanceCanaryUtil;", "", "()V", "CPU_TEMP_FILE_PATHS", "", "", "TAG", "getAppUsageMemory", "", "pid", "getBattery", "", "()Ljava/lang/Float;", "getBatteryTemperature", "()Ljava/lang/Integer;", "getCpuTemperature", "getCpuUsageRate", "getIndexByMatch", "line", "match", "getMatchValueFromTop", "isTemperatureValid", "", "temp", "", "readOneLine", "file", "Ljava/io/File;", "(Ljava/io/File;)Ljava/lang/Double;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PerformanceCanaryUtil.kt */
public final class PerformanceCanaryUtil {
    public static final PerformanceCanaryUtil INSTANCE = new PerformanceCanaryUtil();

    /* renamed from: a */
    private static final String f17958a = "PerformanceCanaryUtil";

    /* renamed from: b */
    private static final List<String> f17959b = CollectionsKt.listOf("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp");

    /* renamed from: a */
    private final boolean m13424a(double d) {
        return d >= -30.0d && d <= 250.0d;
    }

    private PerformanceCanaryUtil() {
    }

    @JvmStatic
    public static final Float getBattery() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        try {
            intent = config.getApp().registerReceiver((BroadcastReceiver) null, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        return Float.valueOf(((float) (intent.getIntExtra("level", -1) * 100)) / ((float) intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1)));
    }

    @JvmStatic
    public static final Integer getBatteryTemperature() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        try {
            intent = config.getApp().registerReceiver((BroadcastReceiver) null, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            intent = null;
        }
        if (intent != null) {
            return Integer.valueOf(intent.getIntExtra("temperature", 0));
        }
        return null;
    }

    public final int getAppUsageMemory(int i) {
        String str;
        boolean z;
        int i2;
        String a = m13423a(i, "RES |RSS ");
        Integer num = null;
        if (a != null) {
            if (StringsKt.endsWith$default(a, "M", false, 2, (Object) null)) {
                int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) a, "M", 0, false, 6, (Object) null);
                if (a != null) {
                    str = a.substring(0, lastIndexOf$default);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                str = a;
            }
            if (StringsKt.endsWith$default(a, "K", false, 2, (Object) null)) {
                int lastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) a, "K", 0, false, 6, (Object) null);
                if (a != null) {
                    str = a.substring(0, lastIndexOf$default2);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    z = true;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                z = false;
            }
            if (z) {
                i2 = Integer.parseInt(str) / 1024;
            } else {
                i2 = Integer.parseInt(str);
            }
            num = Integer.valueOf(i2);
        }
        LogUtil.m13408d(f17958a, "memory usage " + num);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @JvmStatic
    public static final float getCpuUsageRate(int i) {
        String a = INSTANCE.m13423a(i, "CPU");
        Float f = null;
        if (a != null) {
            if (StringsKt.endsWith$default(a, "%", false, 2, (Object) null)) {
                int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) a, "%", 0, false, 6, (Object) null);
                if (a != null) {
                    a = a.substring(0, lastIndexOf$default);
                    Intrinsics.checkExpressionValueIsNotNull(a, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            f = Float.valueOf(Float.parseFloat(a) / ((float) Runtime.getRuntime().availableProcessors()));
        }
        LogUtil.m13408d(f17958a, "cpu rate " + f);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0186, code lost:
        if (r4 != null) goto L_0x0160;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x018d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m13423a(int r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "PerformanceCanaryUtil"
            r3 = 0
            r4 = r3
            java.lang.Process r4 = (java.lang.Process) r4
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r5.<init>()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r6 = "top"
            r5.add(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r6 = "-n"
            r5.add(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r6 = "1"
            r5.add(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r7 = 26
            java.lang.String r8 = ""
            if (r6 < r7) goto L_0x0048
            java.lang.String r6 = "-p"
            r5.add(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r6.<init>()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            int r7 = android.os.Process.myPid()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r6.append(r7)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r6.append(r8)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r5.add(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
        L_0x0048:
            java.lang.ProcessBuilder r6 = new java.lang.ProcessBuilder     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.Process r4 = r6.start()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r7 = "process"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r7)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.io.InputStream r7 = r4.getInputStream()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.io.Reader r6 = (java.io.Reader) r6     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r6 = -1
            r7 = -1
        L_0x0069:
            java.lang.String r9 = r5.readLine()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            if (r9 == 0) goto L_0x0071
            r8 = r9
            goto L_0x0072
        L_0x0071:
            r9 = r3
        L_0x0072:
            if (r9 == 0) goto L_0x015e
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            int r9 = r8.length()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r10 = 1
            int r9 = r9 - r10
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x007f:
            r14 = 32
            if (r12 > r9) goto L_0x00a0
            if (r13 != 0) goto L_0x0087
            r15 = r12
            goto L_0x0088
        L_0x0087:
            r15 = r9
        L_0x0088:
            char r15 = r8.charAt(r15)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            if (r15 > r14) goto L_0x0090
            r15 = 1
            goto L_0x0091
        L_0x0090:
            r15 = 0
        L_0x0091:
            if (r13 != 0) goto L_0x009a
            if (r15 != 0) goto L_0x0097
            r13 = 1
            goto L_0x007f
        L_0x0097:
            int r12 = r12 + 1
            goto L_0x007f
        L_0x009a:
            if (r15 != 0) goto L_0x009d
            goto L_0x00a0
        L_0x009d:
            int r9 = r9 + -1
            goto L_0x007f
        L_0x00a0:
            int r9 = r9 + 1
            java.lang.CharSequence r8 = r8.subSequence(r12, r9)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            if (r9 == 0) goto L_0x00b6
            r9 = r16
            goto L_0x0069
        L_0x00b6:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r9.<init>()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r10 = "read line "
            r9.append(r10)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r9.append(r8)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            com.didi.dimina.container.util.LogUtil.m13408d(r2, r9)     // Catch:{ Exception -> 0x0168, all -> 0x0164 }
            r9 = r16
            int r10 = r9.m13421a((java.lang.String) r8, (java.lang.String) r1)     // Catch:{ Exception -> 0x015c }
            if (r10 == r6) goto L_0x00fb
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r7.<init>()     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = "read tempIndex "
            r7.append(r11)     // Catch:{ Exception -> 0x015c }
            r7.append(r10)     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = " pid: "
            r7.append(r11)     // Catch:{ Exception -> 0x015c }
            r7.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = " match: "
            r7.append(r11)     // Catch:{ Exception -> 0x015c }
            r7.append(r1)     // Catch:{ Exception -> 0x015c }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x015c }
            com.didi.dimina.container.util.LogUtil.m13408d(r2, r7)     // Catch:{ Exception -> 0x015c }
            r7 = r10
            goto L_0x0069
        L_0x00fb:
            if (r7 == r6) goto L_0x0069
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r12.<init>()     // Catch:{ Exception -> 0x015c }
            r12.append(r0)     // Catch:{ Exception -> 0x015c }
            r12.append(r14)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x015c }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x015c }
            r13 = 2
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r10, (java.lang.CharSequence) r12, (boolean) r11, (int) r13, (java.lang.Object) r3)     // Catch:{ Exception -> 0x015c }
            if (r10 == 0) goto L_0x0069
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r10.<init>()     // Catch:{ Exception -> 0x015c }
            r10.append(r0)     // Catch:{ Exception -> 0x015c }
            r10.append(r14)     // Catch:{ Exception -> 0x015c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x015c }
            boolean r10 = kotlin.text.StringsKt.startsWith$default(r8, r10, r11, r13, r3)     // Catch:{ Exception -> 0x015c }
            if (r10 != 0) goto L_0x012f
            int r7 = r7 + 1
        L_0x012f:
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = "\\s+"
            kotlin.text.Regex r13 = new kotlin.text.Regex     // Catch:{ Exception -> 0x015c }
            r13.<init>((java.lang.String) r12)     // Catch:{ Exception -> 0x015c }
            java.util.List r10 = r13.split(r10, r11)     // Catch:{ Exception -> 0x015c }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ Exception -> 0x015c }
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ Exception -> 0x015c }
            java.lang.Object[] r10 = r10.toArray(r11)     // Catch:{ Exception -> 0x015c }
            if (r10 == 0) goto L_0x0154
            java.lang.String[] r10 = (java.lang.String[]) r10     // Catch:{ Exception -> 0x015c }
            int r11 = r10.length     // Catch:{ Exception -> 0x015c }
            if (r11 > r7) goto L_0x014e
            goto L_0x0069
        L_0x014e:
            r0 = r10[r7]     // Catch:{ Exception -> 0x015c }
            r4.destroy()
            return r0
        L_0x0154:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x015c }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)     // Catch:{ Exception -> 0x015c }
            throw r0     // Catch:{ Exception -> 0x015c }
        L_0x015c:
            r0 = move-exception
            goto L_0x016b
        L_0x015e:
            r9 = r16
        L_0x0160:
            r4.destroy()
            goto L_0x0189
        L_0x0164:
            r0 = move-exception
            r9 = r16
            goto L_0x018b
        L_0x0168:
            r0 = move-exception
            r9 = r16
        L_0x016b:
            r0.printStackTrace()     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r1.<init>()     // Catch:{ all -> 0x018a }
            java.lang.String r5 = "getMatchValue error "
            r1.append(r5)     // Catch:{ all -> 0x018a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x018a }
            r1.append(r0)     // Catch:{ all -> 0x018a }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x018a }
            com.didi.dimina.container.util.LogUtil.m13408d(r2, r0)     // Catch:{ all -> 0x018a }
            if (r4 == 0) goto L_0x0189
            goto L_0x0160
        L_0x0189:
            return r3
        L_0x018a:
            r0 = move-exception
        L_0x018b:
            if (r4 == 0) goto L_0x0190
            r4.destroy()
        L_0x0190:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.PerformanceCanaryUtil.m13423a(int, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private final int m13421a(String str, String str2) {
        CharSequence charSequence = str;
        if (!new Regex(str2).containsMatchIn(charSequence)) {
            return -1;
        }
        Object[] array = new Regex("\\s+").split(charSequence, 0).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (new Regex(StringsKt.replace$default(str2, " ", "", false, 4, (Object) null)).containsMatchIn(strArr[i])) {
                    return i;
                }
            }
            return -1;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final int getCpuTemperature() {
        Iterable<String> iterable = f17959b;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String str : iterable) {
            Double a = INSTANCE.m13422a(new File(str));
            double d = 0.0d;
            if (a != null) {
                if (INSTANCE.m13424a(a.doubleValue())) {
                    d = a.doubleValue();
                } else {
                    double d2 = (double) 1000;
                    if (INSTANCE.m13424a(a.doubleValue() / d2)) {
                        d = a.doubleValue() / d2;
                    }
                }
                arrayList.add(new C7707a(str, (int) d));
            }
            str = "";
            arrayList.add(new C7707a(str, (int) d));
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            if (((C7707a) next).mo56956c().length() > 0) {
                arrayList2.add(next);
            }
        }
        return ((C7707a) CollectionsKt.first((List) arrayList2)).mo56955b();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Double m13422a(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0032 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0032 }
            r2 = r1
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ Exception -> 0x0032 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0032 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0032 }
            r3 = r5
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ Exception -> 0x0032 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0032 }
            r2.close()     // Catch:{ Exception -> 0x0032 }
            r5.close()     // Catch:{ Exception -> 0x0032 }
            r1.close()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r5 = "text"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r5)     // Catch:{  }
            double r1 = java.lang.Double.parseDouble(r3)     // Catch:{  }
            java.lang.Double r5 = java.lang.Double.valueOf(r1)     // Catch:{  }
            return r5
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.PerformanceCanaryUtil.m13422a(java.io.File):java.lang.Double");
    }
}
