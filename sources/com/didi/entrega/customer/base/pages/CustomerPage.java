package com.didi.entrega.customer.base.pages;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.entrega.customer.annotation.SupportInnerDialog;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.listener.PageClickableListener;
import com.didi.entrega.router.HubTable;
import com.didi.entrega.router.IHubHandler;
import com.didi.entrega.router.Request;
import com.didi.entrega.router.Response;
import com.taxis99.R;

public abstract class CustomerPage extends Page implements PageClickableListener, IHubHandler {
    public static final String PAGE_NAME = "PageName";

    /* renamed from: a */
    private static final String f19809a = "CustomerPage";

    /* renamed from: b */
    private CustomerPageDelegate f19810b = new CustomerPageDelegate(this, false);

    /* renamed from: c */
    private DialogInstrument f19811c;

    public boolean getTouchIntercept() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isStatusBarLightning() {
        return false;
    }

    public void onInitialize() {
        super.onInitialize();
        this.f19810b.onInitialize(this);
    }

    public String alias() {
        return HubTable.getPageId(getClass());
    }

    public View getPageView() {
        return getView();
    }

    public ControllerChangeHandler getPopHandler() {
        return this.f19810b.mo59675b();
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f19810b.mo59673a();
    }

    public void onCreate(View view) {
        CustomerSystemUtil.setStatusBarBgLightning(isStatusBarLightning());
        this.f19810b.onCreate();
        getScopeContext().attach("PageName", alias());
        getScopeContext().attach("fromPage", alias());
        super.onCreate(view);
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f19810b.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f19810b.onStart(getView(), getStatusBarHeight());
    }

    public void onStop() {
        super.onStop();
        this.f19810b.onStop();
    }

    public void openRoute(Request request, Response response) {
        this.f19810b.openRoute(request);
    }

    public void setupComponents(View view) {
        ButterKnife.bind((Object) this, view);
        super.setupComponents(view);
        m14679a();
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }

    /* renamed from: a */
    private void m14679a() {
        if (((SupportInnerDialog) getClass().getAnnotation(SupportInnerDialog.class)) != null) {
            ViewGroup viewGroup = (ViewGroup) getView().findViewWithTag(getResources().getString(R.string.entrega_dialog_container_tag));
            if (viewGroup == null) {
                viewGroup = new FrameLayout(getBaseContext());
                viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ((ViewGroup) getView()).addView(viewGroup);
            }
            DialogFrameLayout dialogFrameLayout = new DialogFrameLayout(getBaseContext());
            dialogFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(dialogFrameLayout);
            this.f19811c = new DialogInstrument(dialogFrameLayout);
            if (getScopeContext() != null) {
                getScopeContext().attach("dialog_instrument", this.f19811c);
                getScopeContext().attach("dialog_instrument_frame", dialogFrameLayout);
            }
        }
    }
}
