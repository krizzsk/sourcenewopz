package com.didi.safetoolkit.business.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.controller.SfBaseController;
import com.didi.safetoolkit.business.share.controller.SfGetController;
import com.didi.safetoolkit.business.share.controller.SfShareController;
import com.didi.safetoolkit.business.share.model.SfContactsParam;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SfContactsActivity extends BaseSafeToolkitActivity implements SfIContactsView {
    public static final String PARAM_ORDER_ID = "order_id";
    public static final String PARAM_TARGET = "target";
    public static final String PARAM_THRESHOLD = "threshold";
    public static final int TARGET_GET_CONTACTS = 2;
    public static final int TARGET_GET_CONTACTS_BACK_2_SHARE = 3;
    public static final int TARGET_SHARE = 1;

    /* renamed from: a */
    private static final String f34428a = "SfContactsActivity";

    /* renamed from: b */
    private int f34429b = -1;

    /* renamed from: c */
    private String f34430c;

    /* renamed from: d */
    private SfBaseController f34431d;

    /* renamed from: e */
    private int f34432e;

    /* renamed from: f */
    private SfCommonTitleBar f34433f;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Target {
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_share_activity;
    }

    /* access modifiers changed from: protected */
    public void setListener() {
    }

    public static void startActivityForResult(Activity activity, int i, SfContactsParam sfContactsParam) {
        Intent intent = new Intent(activity, SfContactsActivity.class);
        intent.putExtra("target", sfContactsParam.getTarget());
        intent.putExtra("order_id", sfContactsParam.getOrderId());
        intent.putExtra("threshold", sfContactsParam.getThreshold());
        activity.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f34429b = bundle.getInt("target", 2);
            this.f34430c = bundle.getString("order_id", (String) null);
            this.f34432e = bundle.getInt("threshold", Integer.MAX_VALUE);
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        int i = this.f34429b;
        if (i == 1) {
            this.f34431d = new SfShareController(this);
        } else if (i == 2) {
            this.f34431d = new SfGetController(this);
        } else if (i == 3) {
            this.f34431d = new SfGetController(this, 2);
        }
        SfOmegaUtil.addEventId("gp_selectContacts_view_sw").report();
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressedCall() {
        return super.onBackPressedCall();
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34433f = (SfCommonTitleBar) findViewById(R.id.share_title_bar);
    }

    public View findViewByIdImpl(int i) {
        return findViewById(i);
    }

    public void showLoading() {
        showPDialog();
    }

    public void stopLoading() {
        closePDialog();
    }

    public String getOrderId() {
        return this.f34430c;
    }

    public int getThreshold() {
        return this.f34432e;
    }

    public void startAddAreaCodeActivity(int i, SfContactsManageModel sfContactsManageModel) {
        SafeToolKit.getIns().startAreaCodeAddPage(this, i, sfContactsManageModel);
    }

    public View getFallbackView() {
        return this.f34433f.getLoadingFallback();
    }
}
