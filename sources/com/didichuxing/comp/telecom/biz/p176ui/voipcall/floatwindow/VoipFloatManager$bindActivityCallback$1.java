package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipBusinessActivity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/VoipFloatManager$bindActivityCallback$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.VoipFloatManager$bindActivityCallback$1 */
/* compiled from: VoipFloatManager.kt */
public final class VoipFloatManager$bindActivityCallback$1 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ VoipFloatManager this$0;

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
    }

    VoipFloatManager$bindActivityCallback$1(VoipFloatManager voipFloatManager) {
        this.this$0 = voipFloatManager;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (activity instanceof VoipBusinessActivity) {
            this.this$0.m33262a(true);
            this.this$0.f46330d = new WeakReference(activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (activity instanceof VoipBusinessActivity) {
            this.this$0.m33262a(false);
            this.this$0.f46330d = null;
        }
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (this.this$0.f46331e == 0) {
            this.this$0.m33263b(true);
        }
        VoipFloatManager voipFloatManager = this.this$0;
        voipFloatManager.f46331e = voipFloatManager.f46331e + 1;
        int unused = voipFloatManager.f46331e;
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.this$0.f46332f = new WeakReference(activity);
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        VoipFloatManager voipFloatManager = this.this$0;
        voipFloatManager.f46331e = voipFloatManager.f46331e - 1;
        int unused = voipFloatManager.f46331e;
        if (this.this$0.f46331e == 0) {
            this.this$0.m33263b(false);
        }
    }
}
