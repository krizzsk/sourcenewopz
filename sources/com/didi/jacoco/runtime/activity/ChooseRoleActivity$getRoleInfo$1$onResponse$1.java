package com.didi.jacoco.runtime.activity;

import com.didi.jacoco.runtime.adapter.NameAdapter;
import kotlin.Metadata;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
final class ChooseRoleActivity$getRoleInfo$1$onResponse$1 implements Runnable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ ChooseRoleActivity$getRoleInfo$1 this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7948458350920119463L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$getRoleInfo$1$onResponse$1", 6);
        $jacocoData = probes;
        return probes;
    }

    ChooseRoleActivity$getRoleInfo$1$onResponse$1(ChooseRoleActivity$getRoleInfo$1 chooseRoleActivity$getRoleInfo$1) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = chooseRoleActivity$getRoleInfo$1;
        $jacocoInit[5] = true;
    }

    public final void run() {
        boolean[] $jacocoInit = $jacocoInit();
        NameAdapter access$getNameAdapter$p = ChooseRoleActivity.access$getNameAdapter$p(this.this$0.this$0);
        if (access$getNameAdapter$p != null) {
            access$getNameAdapter$p.setData(ChooseRoleActivity.access$getNames$p(this.this$0.this$0));
            $jacocoInit[0] = true;
        } else {
            $jacocoInit[1] = true;
        }
        NameAdapter access$getNameAdapter$p2 = ChooseRoleActivity.access$getNameAdapter$p(this.this$0.this$0);
        if (access$getNameAdapter$p2 != null) {
            access$getNameAdapter$p2.notifyDataSetChanged();
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
        }
        this.this$0.this$0.getSpName().setSelection(0);
        $jacocoInit[4] = true;
    }
}
