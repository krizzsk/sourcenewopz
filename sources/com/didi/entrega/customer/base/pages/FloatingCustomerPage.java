package com.didi.entrega.customer.base.pages;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
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
import com.didi.rfusion.widget.floating.RFFloating;
import com.taxis99.R;

public abstract class FloatingCustomerPage extends RFFloating implements PageClickableListener, IHubHandler {

    /* renamed from: a */
    private static final String f19815a = "FloatingCustomerPage";

    /* renamed from: b */
    private CustomerPageDelegate f19816b = new CustomerPageDelegate(this, false);

    /* renamed from: c */
    private DialogInstrument f19817c;

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
        this.f19816b.onInitialize(this);
    }

    public void onCreate(View view) {
        initContentView();
        CustomerSystemUtil.setStatusBarBgLightning(isStatusBarLightning());
        this.f19816b.onCreate();
        getScopeContext().attach("PageName", alias());
        super.onCreate(view);
        updateFloatingConfig();
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f19816b.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f19816b.onStart(getView(), getStatusBarHeight());
    }

    public void onStop() {
        super.onStop();
        this.f19816b.onStop();
    }

    public void openRoute(Request request, Response response) {
        this.f19816b.openRoute(request);
    }

    public void setupComponents(View view) {
        ButterKnife.bind((Object) this, view);
        super.setupComponents(view);
        m14691b();
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }

    /* renamed from: b */
    private void m14691b() {
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
            this.f19817c = new DialogInstrument(dialogFrameLayout);
            if (getScopeContext() != null) {
                getScopeContext().attach("dialog_instrument", this.f19817c);
                getScopeContext().attach("dialog_instrument_frame", dialogFrameLayout);
            }
        }
    }
}
