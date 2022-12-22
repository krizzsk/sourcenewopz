package com.didi.jacoco.runtime.activity;

import com.didi.jacoco.runtime.JacocoRuntime;
import kotlin.Metadata;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/jacoco/runtime/activity/ChooseRoleActivity$initData$1", "Lcom/didi/jacoco/runtime/JacocoRuntime$UploadCallback;", "onFailure", "", "msg", "", "onSuccess", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
public final class ChooseRoleActivity$initData$1 implements JacocoRuntime.UploadCallback {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ ChooseRoleActivity this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6758474681140970840L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$initData$1", 3);
        $jacocoData = probes;
        return probes;
    }

    ChooseRoleActivity$initData$1(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = chooseRoleActivity;
        $jacocoInit[2] = true;
    }

    public void onSuccess() {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0.runOnUiThread(new ChooseRoleActivity$initData$1$onSuccess$1(this));
        $jacocoInit[0] = true;
    }

    public void onFailure(String str) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0.runOnUiThread(new ChooseRoleActivity$initData$1$onFailure$1(this, str));
        $jacocoInit[1] = true;
    }
}
