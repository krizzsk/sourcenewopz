package com.didi.jacoco.runtime.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.jacoco.runtime.module.role.Data;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/jacoco/runtime/activity/ChooseRoleActivity$initView$2", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "pos", "", "id", "", "onNothingSelected", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
public final class ChooseRoleActivity$initView$2 implements AdapterView.OnItemSelectedListener {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ ChooseRoleActivity this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2721290467627373396L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$initView$2", 8);
        $jacocoData = probes;
        return probes;
    }

    ChooseRoleActivity$initView$2(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = chooseRoleActivity;
        $jacocoInit[7] = true;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(view, "view");
        $jacocoInit[0] = true;
        ChooseRoleActivity chooseRoleActivity = this.this$0;
        Object obj = ChooseRoleActivity.access$getNames$p(chooseRoleActivity).get(i);
        Intrinsics.checkExpressionValueIsNotNull(obj, "names[pos]");
        ChooseRoleActivity.access$setRoleData$p(chooseRoleActivity, (Data) obj);
        $jacocoInit[1] = true;
        if (!Intrinsics.areEqual((Object) ChooseRoleActivity.access$getRoleData$p(this.this$0).getName(), (Object) this.this$0.getResources().getString(R.string.name))) {
            $jacocoInit[2] = true;
            TextView txtOldData = this.this$0.getTxtOldData();
            txtOldData.setText("\n 当前选择人员：" + ChooseRoleActivity.access$getRoleData$p(this.this$0).getName() + "\n");
            $jacocoInit[3] = true;
        } else {
            this.this$0.getTxtOldData().setText("\n 请选择提交人员角色及姓名 + \n");
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        $jacocoInit()[6] = true;
    }
}
