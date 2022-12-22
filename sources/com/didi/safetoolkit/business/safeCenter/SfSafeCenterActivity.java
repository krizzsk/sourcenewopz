package com.didi.safetoolkit.business.safeCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.ISfUriDispatcherServices;
import com.didi.safetoolkit.business.safeCenter.SfSafeCenterAdapter;
import com.didi.safetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.safetoolkit.business.safeCenter.response.SfSafetyCenterResponse;
import com.didi.safetoolkit.business.safeCenter.store.SfCenterStore;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.List;

public class SfSafeCenterActivity extends BaseActivityWithUIStuff {

    /* renamed from: a */
    private RecyclerView f34407a;

    /* renamed from: b */
    private SfCommonTitleBar f34408b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SfSafeCenterAdapter f34409c;

    /* renamed from: d */
    private SfCenterStore f34410d;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_safe_center_activity;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34407a = (RecyclerView) findViewById(R.id.center_rv);
        SfCommonTitleBar sfCommonTitleBar = (SfCommonTitleBar) findViewById(R.id.center_title_bar);
        this.f34408b = sfCommonTitleBar;
        sfCommonTitleBar.setTitleText(SfStringGetter.getString(R.string.sf_safety_center));
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        this.f34409c = new SfSafeCenterAdapter();
        this.f34407a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f34407a.setAdapter(this.f34409c);
        this.f34410d = new SfCenterStore();
        this.f34409c.setCardClickListener(new SfSafeCenterAdapter.CardClickListener() {
            public void onClick(SfCenterCardModel sfCenterCardModel) {
                SfSafeCenterActivity.this.m24331a(sfCenterCardModel);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24331a(SfCenterCardModel sfCenterCardModel) {
        if (sfCenterCardModel != null) {
            if (sfCenterCardModel.typeLocal == 1) {
                ISfUriDispatcherServices iSfUriDispatcherServices = (ISfUriDispatcherServices) ServiceLoader.load(ISfUriDispatcherServices.class, SafeToolKit.getIns().getBusinessType()).get();
                if (iSfUriDispatcherServices != null) {
                    iSfUriDispatcherServices.handleUri(this, sfCenterCardModel.url);
                }
            } else if (sfCenterCardModel.typeLocal == 2) {
                SafeToolKit.getIns().startContactsManagerPage(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        C117282 r0 = new SfCenterStore.Callback() {
            public void onSuccess(List<SfCenterCardModel> list) {
                SfSafeCenterActivity.this.closePDialog();
                SfSafeCenterActivity.this.f34409c.setData(list);
            }

            public void onFailed(SfSafetyCenterResponse sfSafetyCenterResponse) {
                SfSafeCenterActivity.this.closePDialog();
                if (sfSafetyCenterResponse != null) {
                    SfSafeCenterActivity.this.showToast(sfSafetyCenterResponse.errmsg);
                }
            }
        };
        showLoading();
        this.f34410d.getLocalData(r0);
        this.f34410d.request(r0);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f34408b.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfSafeCenterActivity.this.onBackPressed();
            }
        });
    }

    public View getFallbackView() {
        return this.f34408b.getLoadingFallback();
    }
}
