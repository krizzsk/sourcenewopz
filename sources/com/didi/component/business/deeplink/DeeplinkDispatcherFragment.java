package com.didi.component.business.deeplink;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.AbsNormalFragment;
import com.taxis99.R;

public class DeeplinkDispatcherFragment extends AbsNormalFragment<DeeplinkDispatcherFragmentPresenter> implements View.OnClickListener, IDeeplinkDispatcherFragmentView {

    /* renamed from: a */
    private View f11290a;

    /* renamed from: b */
    private RelativeLayout f11291b;

    /* renamed from: c */
    private RelativeLayout f11292c;

    /* renamed from: a */
    private void m7617a() {
    }

    /* renamed from: a */
    private void m7618a(View view) {
    }

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public Animator offerExitAnimation() {
        return null;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public void onFirstLayoutDone() {
    }

    public void setBackVisible(boolean z) {
    }

    /* access modifiers changed from: protected */
    public DeeplinkDispatcherFragmentPresenter onCreateTopPresenter() {
        return new DeeplinkDispatcherFragmentPresenter(getBusinessContext(), getArguments());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_fragment_deeplink_dispatcher, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.oc_root_view);
        this.f11290a = findViewById;
        m7618a(findViewById);
        m7617a();
        return inflate;
    }

    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f11290a = null;
    }
}
