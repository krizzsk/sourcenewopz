package global.didi.pay.p236ui.theme;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rui.config.RConfigConstants;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lglobal/didi/pay/ui/theme/UnifiedPayThemeManager;", "", "()V", "theme", "Lglobal/didi/pay/ui/theme/UnifiedPayTheme;", "force", "getPackageName", "", "context", "Landroid/content/Context;", "getPayTheme", "Companion", "ui_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: global.didi.pay.ui.theme.UnifiedPayThemeManager */
/* compiled from: UnifiedPayThemeManager.kt */
public final class UnifiedPayThemeManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UnifiedPayThemeManager INS = new UnifiedPayThemeManager();
    private UnifiedPayTheme theme;

    public static final UnifiedPayThemeManager getINS() {
        return INS;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lglobal/didi/pay/ui/theme/UnifiedPayThemeManager$Companion;", "", "()V", "INS", "Lglobal/didi/pay/ui/theme/UnifiedPayThemeManager;", "INS$annotations", "getINS", "()Lglobal/didi/pay/ui/theme/UnifiedPayThemeManager;", "ui_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* renamed from: global.didi.pay.ui.theme.UnifiedPayThemeManager$Companion */
    /* compiled from: UnifiedPayThemeManager.kt */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void INS$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UnifiedPayThemeManager getINS() {
            return UnifiedPayThemeManager.INS;
        }
    }

    public final UnifiedPayThemeManager force(UnifiedPayTheme unifiedPayTheme) {
        Intrinsics.checkParameterIsNotNull(unifiedPayTheme, RConfigConstants.SEGMENT_THEME);
        UnifiedPayThemeManager unifiedPayThemeManager = this;
        unifiedPayThemeManager.theme = unifiedPayTheme;
        return unifiedPayThemeManager;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final global.didi.pay.p236ui.theme.UnifiedPayTheme getPayTheme(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            global.didi.pay.ui.theme.UnifiedPayTheme r0 = r1.theme
            if (r0 != 0) goto L_0x008d
            java.lang.String r2 = r1.getPackageName(r2)
            if (r2 != 0) goto L_0x0011
            goto L_0x0089
        L_0x0011:
            int r0 = r2.hashCode()
            switch(r0) {
                case -302703060: goto L_0x007e;
                case -259529592: goto L_0x0073;
                case 247899930: goto L_0x0068;
                case 359347526: goto L_0x005d;
                case 359347603: goto L_0x0052;
                case 359348053: goto L_0x0047;
                case 780876326: goto L_0x003c;
                case 809125059: goto L_0x0031;
                case 1934196252: goto L_0x0026;
                case 2111844610: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0089
        L_0x001a:
            java.lang.String r0 = "com.app99.driver"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.Theme99
            goto L_0x008b
        L_0x0026:
            java.lang.String r0 = "com.didiglobal.driver"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.ThemeGlobal
            goto L_0x008b
        L_0x0031:
            java.lang.String r0 = "com.xiaojukeji.didi.global.customer"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.ThemeGlobal
            goto L_0x008b
        L_0x003c:
            java.lang.String r0 = "com.didiglobal.passenger"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.ThemeGlobal
            goto L_0x008b
        L_0x0047:
            java.lang.String r0 = "com.didiglobal.driver.ru"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.ThemeGlobal
            goto L_0x008b
        L_0x0052:
            java.lang.String r0 = "com.didiglobal.driver.de"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.ThemeGlobal
            goto L_0x008b
        L_0x005d:
            java.lang.String r0 = "com.didiglobal.driver.au"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.ThemeGlobal
            goto L_0x008b
        L_0x0068:
            java.lang.String r0 = "com.xiaojukeji.didi.brazil.customer"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.Theme99
            goto L_0x008b
        L_0x0073:
            java.lang.String r0 = "com.taxis99"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.Theme99
            goto L_0x008b
        L_0x007e:
            java.lang.String r0 = "com.pay99.wallet"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0089
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.ThemeWallet
            goto L_0x008b
        L_0x0089:
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = global.didi.pay.p236ui.theme.UnifiedPayTheme.Theme99
        L_0x008b:
            r1.theme = r2
        L_0x008d:
            global.didi.pay.ui.theme.UnifiedPayTheme r2 = r1.theme
            if (r2 == 0) goto L_0x0092
            return r2
        L_0x0092:
            kotlin.TypeCastException r2 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type global.didi.pay.ui.theme.UnifiedPayTheme"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.p236ui.theme.UnifiedPayThemeManager.getPayTheme(android.content.Context):global.didi.pay.ui.theme.UnifiedPayTheme");
    }

    private final String getPackageName(Context context) {
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
            return "";
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
