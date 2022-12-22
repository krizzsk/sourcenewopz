package com.didi.dimina.starbox;

import android.app.Application;
import android.content.Context;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.ToastUtil;
import com.didi.dimina.starbox.module.DMStarBoxBridgeModule;
import com.didi.dimina.starbox.p107ui.floaticon.FloatIconPage;
import com.didi.dimina.starbox.p107ui.floaticon.FloatPageManager;
import com.didi.dimina.starbox.util.PermissionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0007J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108F¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, mo175978d2 = {"Lcom/didi/dimina/starbox/StarBox;", "", "()V", "floatIcon", "Lcom/didi/dimina/starbox/ui/floaticon/FloatIconPage;", "value", "", "floatIconNeedShow", "getFloatIconNeedShow", "()Z", "setFloatIconNeedShow", "(Z)V", "starBoxAppId", "", "starBoxInit", "starBoxRegisterDMMinaList", "", "Lcom/didi/dimina/starbox/StarBox$StarBoxDMMinaConfig;", "getStarBoxRegisterDMMinaList", "()Ljava/util/List;", "closeStarBox", "", "init", "app", "Landroid/app/Application;", "initFloatIcon", "launchStarBoxPage", "context", "Landroid/content/Context;", "openMonitor", "openStarBox", "registerStarBoxDMMinaConfig", "config", "StarBoxDMMinaConfig", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: StarBox.kt */
public final class StarBox {
    public static final StarBox INSTANCE = new StarBox();

    /* renamed from: a */
    private static final List<StarBoxDMMinaConfig> f17991a = new ArrayList();

    /* renamed from: b */
    private static boolean f17992b = false;

    /* renamed from: c */
    private static FloatIconPage f17993c = null;
    public static final String starBoxAppId = "dd139efc39ef5e0272";

    private StarBox() {
    }

    public final synchronized List<StarBoxDMMinaConfig> getStarBoxRegisterDMMinaList() {
        return f17991a;
    }

    @JvmStatic
    public static final void init(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "app");
        if (DebugKitStoreUtil.getStarBoxOpen() && !f17992b) {
            LogUtil.m13408d("StarBox", "open");
            Dimina.registerJSModule(DMStarBoxBridgeModule.class);
            INSTANCE.m13455a(application);
            INSTANCE.m13454a();
            f17992b = true;
        } else if (!DebugKitStoreUtil.getStarBoxOpen()) {
            LogUtil.m13408d("StarBox", "StarBox has closed");
        } else {
            LogUtil.m13408d("StarBox", "StarBox has already init ");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        return;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void registerStarBoxDMMinaConfig(com.didi.dimina.starbox.StarBox.StarBoxDMMinaConfig r4) {
        /*
            java.lang.Class<com.didi.dimina.starbox.StarBox> r0 = com.didi.dimina.starbox.StarBox.class
            monitor-enter(r0)
            java.lang.String r1 = "config"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r1)     // Catch:{ all -> 0x0047 }
            boolean r1 = com.didi.dimina.container.util.DebugKitStoreUtil.getStarBoxOpen()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = "StarBox"
            java.lang.String r2 = "registerStarBoxDMMinaConfig"
            com.didi.dimina.container.util.LogUtil.m13408d(r1, r2)     // Catch:{ all -> 0x0047 }
            java.util.List<com.didi.dimina.starbox.StarBox$StarBoxDMMinaConfig> r1 = f17991a     // Catch:{ all -> 0x0047 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0047 }
        L_0x001c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0047 }
            com.didi.dimina.starbox.StarBox$StarBoxDMMinaConfig r2 = (com.didi.dimina.starbox.StarBox.StarBoxDMMinaConfig) r2     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r2.getAppId()     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = r4.getAppId()     // Catch:{ all -> 0x0047 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x001c
            monitor-exit(r0)
            return
        L_0x0038:
            java.util.List<com.didi.dimina.starbox.StarBox$StarBoxDMMinaConfig> r1 = f17991a     // Catch:{ all -> 0x0047 }
            r1.add(r4)     // Catch:{ all -> 0x0047 }
            goto L_0x0045
        L_0x003e:
            java.lang.String r4 = "StarBox"
            java.lang.String r1 = "StarBox has closed"
            com.didi.dimina.container.util.LogUtil.m13408d(r4, r1)     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r0)
            return
        L_0x0047:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.starbox.StarBox.registerStarBoxDMMinaConfig(com.didi.dimina.starbox.StarBox$StarBoxDMMinaConfig):void");
    }

    @JvmStatic
    public static final void openStarBox() {
        DebugKitStoreUtil.setStarBoxOpen(true);
        LogUtil.m13408d("StarBox", "open StarBox");
    }

    @JvmStatic
    public static final void closeStarBox() {
        DebugKitStoreUtil.setStarBoxOpen(false);
        LogUtil.m13408d("StarBox", "close StarBox");
    }

    /* renamed from: a */
    private final void m13454a() {
        Dimina.registerLaunchLifecycleCallback(new StarBox$openMonitor$1());
    }

    @JvmStatic
    public static final void launchStarBoxPage(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        StarBoxActivity.Companion.start(context);
    }

    public final boolean getFloatIconNeedShow() {
        return DebugKitStoreUtil.getStarBoxOpen();
    }

    public final void setFloatIconNeedShow(boolean z) {
        DebugKitStoreUtil.setStarBoxOpen(z);
    }

    /* renamed from: a */
    private final void m13455a(Application application) {
        if (getFloatIconNeedShow()) {
            Context context = application;
            if (!PermissionUtil.INSTANCE.canDrawOverlays(context)) {
                ToastUtil.show(context, application.getText(R.string.dm_kit_float_permission_toast));
                PermissionUtil.INSTANCE.requestDrawOverlays(context);
                return;
            }
            FloatPageManager.getInstance().init(context);
            FloatIconPage floatIconPage = new FloatIconPage(context);
            f17993c = floatIconPage;
            if (floatIconPage == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatIcon");
            }
            floatIconPage.pop();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/dimina/starbox/StarBox$StarBoxDMMinaConfig;", "", "appId", "", "name", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getIcon", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: StarBox.kt */
    public static final class StarBoxDMMinaConfig {
        private final String appId;
        private final String icon;
        private final String name;

        public static /* synthetic */ StarBoxDMMinaConfig copy$default(StarBoxDMMinaConfig starBoxDMMinaConfig, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = starBoxDMMinaConfig.appId;
            }
            if ((i & 2) != 0) {
                str2 = starBoxDMMinaConfig.name;
            }
            if ((i & 4) != 0) {
                str3 = starBoxDMMinaConfig.icon;
            }
            return starBoxDMMinaConfig.copy(str, str2, str3);
        }

        public final String component1() {
            return this.appId;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.icon;
        }

        public final StarBoxDMMinaConfig copy(String str, String str2, String str3) {
            Intrinsics.checkParameterIsNotNull(str, "appId");
            Intrinsics.checkParameterIsNotNull(str2, "name");
            return new StarBoxDMMinaConfig(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StarBoxDMMinaConfig)) {
                return false;
            }
            StarBoxDMMinaConfig starBoxDMMinaConfig = (StarBoxDMMinaConfig) obj;
            return Intrinsics.areEqual((Object) this.appId, (Object) starBoxDMMinaConfig.appId) && Intrinsics.areEqual((Object) this.name, (Object) starBoxDMMinaConfig.name) && Intrinsics.areEqual((Object) this.icon, (Object) starBoxDMMinaConfig.icon);
        }

        public int hashCode() {
            String str = this.appId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.icon;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "StarBoxDMMinaConfig(appId=" + this.appId + ", name=" + this.name + ", icon=" + this.icon + ")";
        }

        public StarBoxDMMinaConfig(String str, String str2, String str3) {
            Intrinsics.checkParameterIsNotNull(str, "appId");
            Intrinsics.checkParameterIsNotNull(str2, "name");
            this.appId = str;
            this.name = str2;
            this.icon = str3;
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getName() {
            return this.name;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ StarBoxDMMinaConfig(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? "" : str3);
        }

        public final String getIcon() {
            return this.icon;
        }
    }
}
