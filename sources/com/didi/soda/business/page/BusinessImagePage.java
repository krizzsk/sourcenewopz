package com.didi.soda.business.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.BusinessImageComponent;
import com.didi.soda.business.component.image.OnPreviewImageListener;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"businessPreviewImage"})
public class BusinessImagePage extends CustomerPage implements OnPreviewImageListener {

    /* renamed from: a */
    private boolean f39733a = true;

    /* renamed from: b */
    private PreviewImageChangeHandler f39734b;

    /* renamed from: c */
    private boolean f39735c;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean isStatusBarLightning() {
        return true;
    }

    public BusinessImagePage() {
        DiRouter.registerHub(RoutePath.BUSINESS_PREVIEW_IMAGE, this);
    }

    public ControllerChangeHandler getPopHandler() {
        PreviewImageChangeHandler previewImageChangeHandler = new PreviewImageChangeHandler(getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        this.f39734b = previewImageChangeHandler;
        return previewImageChangeHandler;
    }

    public ControllerChangeHandler getPushHandler() {
        return new PreviewImageChangeHandler(getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
    }

    public void onCreate(View view) {
        this.f39735c = CustomerSystemUtil.getCurrentBarStatus();
        super.onCreate(view);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_business_image, viewGroup, false);
    }

    public boolean onHandleBack() {
        if (this.f39733a) {
            return true;
        }
        return super.onHandleBack();
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        this.f39733a = false;
    }

    public void onResume() {
        super.onResume();
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new BusinessImageComponent((ViewGroup) getPageView(), this));
    }

    public void onClickAddEvent(PreviewImageModel previewImageModel) {
        PreviewImageChangeHandler previewImageChangeHandler = this.f39734b;
        if (previewImageChangeHandler != null) {
            previewImageChangeHandler.setPopFadeChange();
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        CustomerSystemUtil.setStatusBarBgLightning(this.f39735c);
    }
}
