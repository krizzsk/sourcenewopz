package com.component.android.comp_location;

import android.view.ViewGroup;
import com.component.android.comp_location.view.GlobalConfirmLocationView;
import com.component.android.comp_location.view.GlobalHomeLocationView;
import com.component.android.comp_location.view.GlobalLocationViewV2;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "reset_location")
public class GlobalLocationComponent extends BaseComponent<IGlobalLocationView, AbsGlobalLocationPresenter> {
    private AbsGlobalLocationPresenter mCurrentPresenter;

    /* access modifiers changed from: protected */
    public IGlobalLocationView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new GlobalHomeLocationView(componentParams.bizCtx.getContext());
        }
        if (i == 1030) {
            return new GlobalConfirmLocationView(componentParams.bizCtx.getContext());
        }
        if (i != 1040) {
            return new GlobalLocationViewV2(componentParams.bizCtx.getContext());
        }
        if (componentParams.scene != 10403) {
            return new GlobalLocationViewV2(componentParams.bizCtx.getContext());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r2.mCurrentPresenter != null) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.component.android.comp_location.AbsGlobalLocationPresenter onCreatePresenter(com.didi.component.core.ComponentParams r3) {
        /*
            r2 = this;
            r0 = 0
            r2.mCurrentPresenter = r0
            int r0 = r3.pageID
            r1 = 1001(0x3e9, float:1.403E-42)
            if (r0 == r1) goto L_0x0047
            r1 = 1030(0x406, float:1.443E-42)
            if (r0 == r1) goto L_0x003f
            r1 = 1035(0x40b, float:1.45E-42)
            if (r0 == r1) goto L_0x0037
            r1 = 1040(0x410, float:1.457E-42)
            if (r0 == r1) goto L_0x0016
            goto L_0x002f
        L_0x0016:
            int r0 = r3.scene
            switch(r0) {
                case 10401: goto L_0x0023;
                case 10402: goto L_0x0023;
                case 10403: goto L_0x0023;
                default: goto L_0x001b;
            }
        L_0x001b:
            com.component.android.comp_location.presenter.GlobalCommonLocationPresenter r0 = new com.component.android.comp_location.presenter.GlobalCommonLocationPresenter
            r0.<init>(r3)
            r2.mCurrentPresenter = r0
            goto L_0x002a
        L_0x0023:
            com.component.android.comp_location.presenter.GlobalOnServiceLocationAddExtraHeightPresenter r0 = new com.component.android.comp_location.presenter.GlobalOnServiceLocationAddExtraHeightPresenter
            r0.<init>(r3)
            r2.mCurrentPresenter = r0
        L_0x002a:
            com.component.android.comp_location.AbsGlobalLocationPresenter r0 = r2.mCurrentPresenter
            if (r0 == 0) goto L_0x002f
            goto L_0x004e
        L_0x002f:
            com.component.android.comp_location.presenter.GlobalCommonLocationPresenter r0 = new com.component.android.comp_location.presenter.GlobalCommonLocationPresenter
            r0.<init>(r3)
            r2.mCurrentPresenter = r0
            goto L_0x004e
        L_0x0037:
            com.component.android.comp_location.presenter.GlobalUpdatePickUpLocationPresenter r0 = new com.component.android.comp_location.presenter.GlobalUpdatePickUpLocationPresenter
            r0.<init>(r3)
            r2.mCurrentPresenter = r0
            goto L_0x004e
        L_0x003f:
            com.component.android.comp_location.newpresenter.GlobalConfirmLocationNewPresenter r0 = new com.component.android.comp_location.newpresenter.GlobalConfirmLocationNewPresenter
            r0.<init>(r3)
            r2.mCurrentPresenter = r0
            goto L_0x004e
        L_0x0047:
            com.component.android.comp_location.presenter.GlobalHomeLocationPresenter r0 = new com.component.android.comp_location.presenter.GlobalHomeLocationPresenter
            r0.<init>(r3)
            r2.mCurrentPresenter = r0
        L_0x004e:
            com.component.android.comp_location.AbsGlobalLocationPresenter r3 = r2.mCurrentPresenter
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.android.comp_location.GlobalLocationComponent.onCreatePresenter(com.didi.component.core.ComponentParams):com.component.android.comp_location.AbsGlobalLocationPresenter");
    }
}
