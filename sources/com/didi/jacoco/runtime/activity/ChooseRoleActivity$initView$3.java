package com.didi.jacoco.runtime.activity;

import android.view.View;
import android.widget.AdapterView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.jacoco.runtime.JacocoRuntime;
import com.didi.jacoco.runtime.adapter.NameAdapter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/jacoco/runtime/activity/ChooseRoleActivity$initView$3", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "pos", "", "id", "", "onNothingSelected", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
public final class ChooseRoleActivity$initView$3 implements AdapterView.OnItemSelectedListener {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ ChooseRoleActivity this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6689783229714815293L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$initView$3", 13);
        $jacocoData = probes;
        return probes;
    }

    ChooseRoleActivity$initView$3(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = chooseRoleActivity;
        $jacocoInit[12] = true;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        boolean[] $jacocoInit = $jacocoInit();
        if (i != 0) {
            $jacocoInit[0] = true;
            ChooseRoleActivity chooseRoleActivity = this.this$0;
            String appId = JacocoRuntime.jacocoRuntime.coverageConfig.appId();
            Intrinsics.checkExpressionValueIsNotNull(appId, "JacocoRuntime.jacocoRuntime.coverageConfig.appId()");
            chooseRoleActivity.getRoleInfo(appId, String.valueOf(i - 1));
            $jacocoInit[1] = true;
        } else {
            ChooseRoleActivity.access$getNames$p(this.this$0).clear();
            $jacocoInit[2] = true;
            NameAdapter access$getNameAdapter$p = ChooseRoleActivity.access$getNameAdapter$p(this.this$0);
            if (access$getNameAdapter$p != null) {
                $jacocoInit[3] = true;
            } else {
                Intrinsics.throwNpe();
                $jacocoInit[4] = true;
            }
            access$getNameAdapter$p.notifyDataSetChanged();
            $jacocoInit[5] = true;
            if (ChooseRoleActivity.access$getRoleData$li(this.this$0) != null) {
                $jacocoInit[6] = true;
            } else if (!Intrinsics.areEqual((Object) this.this$0.getSpRole().getAdapter().getItem(0).toString(), (Object) this.this$0.getResources().getString(R.string.role))) {
                $jacocoInit[7] = true;
            } else {
                $jacocoInit[8] = true;
                this.this$0.getTxtOldData().setText("\n\n + 请选择提交人员角色及姓名 + \n\n");
                $jacocoInit[9] = true;
            }
        }
        $jacocoInit[10] = true;
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        $jacocoInit()[11] = true;
    }
}
