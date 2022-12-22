package com.didiglobal.p205sa.biz.fragment;

import android.os.Bundle;
import android.view.View;
import com.didi.component.never.base.ForwardOptions;
import com.didi.component.never.base.PageFragment;
import com.didi.component.never.core.node.NodeLaunchMode;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.p205sa.biz.node.NodeIds;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SuperAppActivityFragment;", "Lcom/didi/component/never/base/PageFragment;", "()V", "getComponentExtraParams", "", "", "", "getForwardOptions", "Lcom/didi/component/never/base/ForwardOptions;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onHiddenChanged", "hidden", "", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.fragment.SuperAppActivityFragment */
/* compiled from: SuperAppActivityFragment.kt */
public final class SuperAppActivityFragment extends PageFragment {
    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.fragment_super_app_activity;
    }

    /* access modifiers changed from: protected */
    public ForwardOptions getForwardOptions() {
        return new ForwardOptions(NodeIds.NODE_SUPPER_ACTIVITY, NodeLaunchMode.PUSH, new Bundle());
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getComponentExtraParams() {
        return new HashMap<>();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OmegaSDK.putGlobalKV("g_PageId", "sa_activity");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        forward();
    }

    public void onResume() {
        super.onResume();
        SystemUtils.log(3, "mahui", Intrinsics.stringPlus(getClass().getName(), "onResume"), (Throwable) null, "com.didiglobal.sa.biz.fragment.SuperAppActivityFragment", 40);
    }

    public void onPause() {
        super.onPause();
        SystemUtils.log(3, "mahui", Intrinsics.stringPlus(getClass().getName(), "onPause"), (Throwable) null, "com.didiglobal.sa.biz.fragment.SuperAppActivityFragment", 45);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            OmegaSDK.putGlobalKV("g_PageId", "sa_activity");
        }
    }
}
