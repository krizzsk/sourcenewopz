package com.didiglobal.ddmirror;

import android.app.Application;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didiglobal.ddmirror.monitor.core.GlobalWindowManager;
import com.didiglobal.ddmirror.network.NetWorkChecker;
import com.didiglobal.ddmirror.playback.PrismPlayback;
import com.didiglobal.ddmirror.uichecker.UiChecker;
import com.didiglobal.ddmirror.utils.DDMirrorDebugger;
import com.didiglobal.ddmirror.utils.DDMirrorThreadPool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/DDMirror;", "", "()V", "Companion", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DDMirror.kt */
public final class DDMirror {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/DDMirror$Companion;", "", "()V", "doCheck", "", "eventId", "", "doCheckFull", "doCheckMsg", "doCheckTrack", "initNetChecker", "application", "Landroid/app/Application;", "config", "initUiChecker", "initCallback", "Lcom/didiglobal/ddmirror/IDDMirrorInitCallback;", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DDMirror.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void initUiChecker(Application application, String str, IDDMirrorInitCallback iDDMirrorInitCallback) {
            Intrinsics.checkParameterIsNotNull(application, "application");
            Intrinsics.checkParameterIsNotNull(iDDMirrorInitCallback, "initCallback");
            GlobalWindowManager.getInstance().init(application);
            PrismPlayback.getInstance().init(application);
            DDMirrorDebugger.setIsDebuggable(application.getApplicationInfo());
            DDMirrorThreadPool.execute((Runnable) new DDMirror$Companion$initUiChecker$1(str, iDDMirrorInitCallback));
            Tracker.addTrackListener(DDMirror$Companion$initUiChecker$2.INSTANCE);
        }

        public final void initNetChecker(Application application, String str) {
            Intrinsics.checkParameterIsNotNull(application, "application");
            NetWorkChecker.Companion.initFromString(str);
            NetWorkChecker.Companion.addStatisticalCallback();
            DDMirrorDebugger.setIsDebuggable(application.getApplicationInfo());
        }

        public final void doCheckMsg(String str) {
            Intrinsics.checkParameterIsNotNull(str, "eventId");
            if (UiChecker.Companion.isNeedCheckUiWithMsg(str)) {
                doCheck(str);
            }
        }

        /* access modifiers changed from: private */
        public final void doCheckTrack(String str) {
            if (UiChecker.Companion.isNeedCheckUiWithTrack(str)) {
                doCheck(str);
            }
        }

        private final void doCheckFull(String str) {
            if (UiChecker.Companion.isNeedCheckUi(str)) {
                doCheck(str);
            }
        }

        private final void doCheck(String str) {
            DDMirrorThreadPool.execute((Runnable) new DDMirror$Companion$doCheck$1(str));
        }
    }
}
