package com.didi.component.service.activity.rgltaxiguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.core.PresenterGroup;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class RegularTaxiGuideFragment extends AbsNormalFragment implements IRegularTaxiGuideView {

    /* renamed from: a */
    private RegularTaxiGuidePresenter f15662a;

    /* renamed from: b */
    private CommonTitleBar f15663b;

    /* renamed from: c */
    private View f15664c;

    /* renamed from: d */
    private ViewGroup f15665d;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1030;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        RegularTaxiGuidePresenter regularTaxiGuidePresenter = new RegularTaxiGuidePresenter(getContext(), getArguments());
        this.f15662a = regularTaxiGuidePresenter;
        return regularTaxiGuidePresenter;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.global_regular_taxi_guide_fragment, viewGroup, false);
        this.f15665d = viewGroup2;
        m11433a(viewGroup2);
        FormStore.getInstance().setSkipEstimateGet(true);
        return this.f15665d;
    }

    /* renamed from: a */
    private void m11433a(ViewGroup viewGroup) {
        m11434b(viewGroup);
        View findViewById = viewGroup.findViewById(R.id.oc_confirm_btn);
        this.f15664c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RegularTaxiGuideFragment.this.finishWithResultOk();
            }
        });
    }

    /* renamed from: b */
    private void m11434b(ViewGroup viewGroup) {
        CommonTitleBar commonTitleBar = (CommonTitleBar) viewGroup.findViewById(R.id.oc_title_bar);
        this.f15663b = commonTitleBar;
        commonTitleBar.setTitleBarLineVisible(8);
        this.f15663b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RegularTaxiGuideFragment.this.finishWithResultCancel();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f15662a = null;
        this.f15665d = null;
        this.f15664c = null;
        this.f15663b = null;
    }

    public void setTitle(String str) {
        this.f15663b.setTitle(str);
    }

    public void finishWithResultOk() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public void finishWithResultCancel() {
        getActivity().setResult(0);
        getActivity().finish();
    }
}
