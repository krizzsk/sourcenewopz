package com.didi.dimina.container.mina;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u0017H\u0007R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/dimina/container/mina/DMMinaPool;", "", "()V", "all", "", "Lcom/didi/dimina/container/DMMina;", "all$annotations", "getAll", "()Ljava/util/List;", "sDMMinaPool", "Landroid/util/SparseArray;", "sMarkIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "findDMMinaByAppId", "appId", "", "generate", "activity", "Landroidx/fragment/app/FragmentActivity;", "config", "Lcom/didi/dimina/container/DMConfig;", "get", "index", "", "remove", "", "minaIndex", "force", "", "size", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DMMinaPool.kt */
public final class DMMinaPool {
    public static final DMMinaPool INSTANCE = new DMMinaPool();

    /* renamed from: a */
    private static final SparseArray<DMMina> f16934a = new SparseArray<>();

    /* renamed from: b */
    private static final AtomicInteger f16935b = new AtomicInteger(0);

    @JvmStatic
    public static /* synthetic */ void all$annotations() {
    }

    private DMMinaPool() {
    }

    @JvmStatic
    public static final synchronized DMMina generate(FragmentActivity fragmentActivity, DMConfig dMConfig) {
        DMMina dMMina;
        synchronized (DMMinaPool.class) {
            Intrinsics.checkParameterIsNotNull(dMConfig, "config");
            int incrementAndGet = f16935b.incrementAndGet();
            dMMina = new DMMina(fragmentActivity, incrementAndGet, dMConfig);
            f16934a.put(incrementAndGet, dMMina);
            TraceUtil.trackEventCoreDotting(incrementAndGet, Constant.CORE_DOTTING.LAUNCH_DMMINA_CONSTRUCTION, "DMConfig: " + dMConfig);
        }
        return dMMina;
    }

    @JvmStatic
    public static final synchronized DMMina get(int i) {
        DMMina dMMina;
        synchronized (DMMinaPool.class) {
            dMMina = f16934a.get(i);
        }
        return dMMina;
    }

    @JvmStatic
    public static final int size() {
        return f16934a.size();
    }

    public static final List<DMMina> getAll() {
        List<DMMina> arrayList = new ArrayList<>();
        int size = f16934a.size();
        for (int i = 0; i < size; i++) {
            DMMina valueAt = f16934a.valueAt(i);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final void remove(int i, boolean z) {
        DMMina dMMina = f16934a.get(i);
        if (dMMina != null) {
            if (z) {
                dMMina.release(true);
            } else {
                DMConfig config = dMMina.getConfig();
                Intrinsics.checkExpressionValueIsNotNull(config, "mina.config");
                DMConfig.LaunchConfig launchConfig = config.getLaunchConfig();
                Intrinsics.checkExpressionValueIsNotNull(launchConfig, "mina.config.launchConfig");
                dMMina.release(launchConfig.isForceRelease());
            }
        }
        LogUtil.iRelease("Dimina", "remove dmMina minaIndex:" + i + " force:" + z);
        f16934a.remove(i);
    }

    @JvmStatic
    public static final synchronized DMMina findDMMinaByAppId(String str) {
        DMMina dMMina;
        synchronized (DMMinaPool.class) {
            dMMina = null;
            for (DMMina next : getAll()) {
                if (next.getPreloadStatus() == 3) {
                    DMConfig config = next.getConfig();
                    Intrinsics.checkExpressionValueIsNotNull(config, "mina.config");
                    DMConfig.LaunchConfig launchConfig = config.getLaunchConfig();
                    Intrinsics.checkExpressionValueIsNotNull(launchConfig, "mina.config.launchConfig");
                    if (TextUtils.equals(launchConfig.getAppId(), str)) {
                        if (dMMina != null) {
                            if (next.getMinaIndex() <= dMMina.getMinaIndex()) {
                            }
                        }
                        dMMina = next;
                    }
                }
            }
        }
        return dMMina;
    }
}
