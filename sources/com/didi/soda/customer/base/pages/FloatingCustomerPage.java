package com.didi.soda.customer.base.pages;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.rfusion.widget.floating.RFFloating;
import com.didi.soda.customer.annotation.SupportInnerDialog;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.listener.PageClickableListener;
import com.didi.soda.router.HubTable;
import com.didi.soda.router.IHubHandler;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;
import com.taxis99.R;

public abstract class FloatingCustomerPage extends RFFloating implements PageClickableListener, IHubHandler {

    /* renamed from: a */
    private static final String f40368a = "FloatingCustomerPage";

    /* renamed from: b */
    private CustomerPageDelegate f40369b = new CustomerPageDelegate(this, false);

    /* renamed from: c */
    private DialogInstrument f40370c;

    public boolean getTouchIntercept() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void initContentView();

    /* access modifiers changed from: protected */
    public boolean isStatusBarLightning() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void updateFloatingConfig() {
    }

    public String alias() {
        return HubTable.getPageId(getClass());
    }

    public View getPageView() {
        return getView();
    }

    public void onInitialize() {
        super.onInitialize();
        this.f40369b.onInitialize(this);
    }

    public void onCreate(View view) {
        initContentView();
        CustomerSystemUtil.setStatusBarBgLightning(isStatusBarLightning());
        this.f40369b.onCreate();
        getScopeContext().attach("PageName", alias());
        super.onCreate(view);
        updateFloatingConfig();
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", alias()).build().track();
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f40369b.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f40369b.onStart(getView(), getStatusBarHeight());
    }

    public void onStop() {
        super.onStop();
        this.f40369b.onStop();
    }

    public void finish() {
        if (!PageBackHelper.Companion.popBackStack(this, false)) {
            super.finish();
        }
    }

    public void finish(Bundle bundle) {
        if (!PageBackHelper.Companion.popBackStack(this, false)) {
            super.finish(bundle);
        }
    }

    public void openRoute(Request request, Response response) {
        this.f40369b.mo101870a(request);
    }

    public void setupComponents(View view) {
        ButterKnife.bind((Object) this, view);
        super.setupComponents(view);
        m28627b();
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }

    /* renamed from: b */
    private void m28627b() {
        if (((SupportInnerDialog) getClass().getAnnotation(SupportInnerDialog.class)) != null) {
            ViewGroup viewGroup = (ViewGroup) getView().findViewWithTag(getResources().getString(R.string.customer_dialog_container_tag));
            if (viewGroup == null) {
                viewGroup = new FrameLayout(getBaseContext());
                viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ((ViewGroup) getView()).addView(viewGroup);
            }
            DialogFrameLayout dialogFrameLayout = new DialogFrameLayout(getBaseContext());
            dialogFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(dialogFrameLayout);
            this.f40370c = new DialogInstrument(dialogFrameLayout);
            if (getScopeContext() != null) {
                getScopeContext().attach("dialog_instrument", this.f40370c);
                getScopeContext().attach("dialog_instrument_frame", dialogFrameLayout);
            }
        }
    }
}
