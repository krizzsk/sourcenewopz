package com.didi.addressnew.framework.mapholder;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.File;
import java.io.FileFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\t¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/addressnew/framework/mapholder/HighEndMobile;", "", "()V", "G", "", "cpu", "getCpu", "()I", "setCpu", "(I)V", "filter", "Ljava/io/FileFilter;", "ram", "getRam", "setRam", "getNumberOfCPUCores", "getTotalMemory", "", "c", "Landroid/content/Context;", "isHighEndMobile", "", "context", "global_sug_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HighEndMobile.kt */
public final class HighEndMobile {

    /* renamed from: a */
    private final int f7386a = 1048576000;

    /* renamed from: b */
    private int f7387b = 8;

    /* renamed from: c */
    private int f7388c = 6;

    /* renamed from: d */
    private final FileFilter f7389d;

    public HighEndMobile() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("sug_map_memory_optimize");
        if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
            Object param = experiment.getParam("cpu", 8);
            Intrinsics.checkNotNullExpressionValue(param, "experiment.getParam(\"cpu\", 8)");
            this.f7387b = ((Number) param).intValue();
            Object param2 = experiment.getParam("ram", 6);
            Intrinsics.checkNotNullExpressionValue(param2, "experiment.getParam(\"ram\", 6)");
            this.f7388c = ((Number) param2).intValue();
        }
        this.f7389d = new HighEndMobile$filter$1();
    }

    public final int getCpu() {
        return this.f7387b;
    }

    public final void setCpu(int i) {
        this.f7387b = i;
    }

    public final int getRam() {
        return this.f7388c;
    }

    public final void setRam(int i) {
        this.f7388c = i;
    }

    public final boolean isHighEndMobile(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getTotalMemory(context) >= ((long) this.f7388c) && getNumberOfCPUCores() >= this.f7387b;
    }

    public final int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(this.f7389d).length;
        } catch (Exception e) {
            DLog.m7384d("ccc", Intrinsics.stringPlus("getNumberOfCPUCores ", e), new Object[0]);
            return 1;
        }
    }

    public final long getTotalMemory(Context context) {
        Intrinsics.checkNotNullParameter(context, "c");
        if (Build.VERSION.SDK_INT < 16) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem / ((long) this.f7386a);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
