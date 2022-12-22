package com.didi.jacoco.runtime.activity;

import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
final class ChooseRoleActivity$initData$1$onSuccess$1 implements Runnable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ ChooseRoleActivity$initData$1 this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8695314964163067693L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$initData$1$onSuccess$1", 2);
        $jacocoData = probes;
        return probes;
    }

    ChooseRoleActivity$initData$1$onSuccess$1(ChooseRoleActivity$initData$1 chooseRoleActivity$initData$1) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = chooseRoleActivity$initData$1;
        $jacocoInit[1] = true;
    }

    public final void run() {
        boolean[] $jacocoInit = $jacocoInit();
        SystemUtils.showToast(Toast.makeText(this.this$0.this$0.getBaseContext(), "覆盖度报告提交成功", 0));
        $jacocoInit[0] = true;
    }
}
