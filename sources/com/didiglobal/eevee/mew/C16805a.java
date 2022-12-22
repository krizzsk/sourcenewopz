package com.didiglobal.eevee.mew;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.never.core.ComponentParams;
import com.didi.xengine.register.XERegister;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.mew.model.EMewUIConfig;
import com.didiglobal.common.common.model.EeveeRichText;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.eevee.mew.widget.VpTemplateModel;
import com.didiglobal.eevee.mew.widget.VpTemplateView;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.nat.NativeComponent;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.didiglobal.mew.framework.widget.p201ff.MFFCardProperty;
import com.didiglobal.mew.framework.widget.p202vp.MVPCardProperty;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didiglobal.eevee.mew.a */
/* compiled from: EMewPresenter */
class C16805a extends EeveeCompPresenterImpl<EeveeIView> {

    /* renamed from: a */
    private XEResponseCallback f50077a = new EMewPresenter$1(this);

    /* renamed from: b */
    private XEResponseCallback f50078b = new EMewPresenter$2(this);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36079a(EMewUIConfig eMewUIConfig) {
        if (eMewUIConfig != null) {
            ((EMewView) this.mView).setAlignOrientation(eMewUIConfig.reversed);
        }
        if (eMewUIConfig.balcony != null) {
            int i = eMewUIConfig.balcony.index;
            ((EMewView) this.mView).setListViewElevation(eMewUIConfig.balcony.elevation, i >= 1 ? i - 1 : 0);
        }
        if (eMewUIConfig.background != null) {
            ((EMewView) this.mView).setOverlapSpace(eMewUIConfig.background.translation_y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36084a(List<XEComponent> list, EeveeRichText eeveeRichText, int i) {
        ArrayList arrayList = new ArrayList();
        for (XEComponent next : list) {
            MVPCardProperty mVPCardProperty = new MVPCardProperty();
            mVPCardProperty.viewId = next.getId();
            if (!TextUtils.isEmpty(mVPCardProperty.viewId)) {
                if (next instanceof NativeComponent) {
                    try {
                        mVPCardProperty.view = findComponent(next.getId()).getView().getView();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    mVPCardProperty.view = next.getView();
                }
                if (mVPCardProperty.view != null) {
                    arrayList.add(mVPCardProperty);
                }
            } else {
                return;
            }
        }
        ((EMewView) this.mView).setViewPagerTitle(eeveeRichText, i);
        ((EMewView) this.mView).pagerSetData(arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36083a(List<XEComponent> list) {
        ArrayList arrayList = new ArrayList();
        for (XEComponent next : list) {
            MFFCardProperty mFFCardProperty = new MFFCardProperty();
            mFFCardProperty.viewId = next.getId();
            if (!TextUtils.isEmpty(mFFCardProperty.viewId)) {
                if (next instanceof NativeComponent) {
                    try {
                        mFFCardProperty.view = findComponent(next.getId()).getView().getView();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    mFFCardProperty.view = next.getView();
                }
                if (mFFCardProperty.view != null) {
                    arrayList.add(mFFCardProperty);
                }
            } else {
                return;
            }
        }
        ((EMewView) this.mView).flowSetData(arrayList);
    }

    public C16805a(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m36078a();
        if (bundle != null && bundle.getBoolean("is_sa")) {
            ((EMewView) this.mView).setMarginBottom(0);
        }
    }

    /* renamed from: a */
    private void m36078a() {
        m36086c();
        XERegister.registerTemplate(new XERegisterModel(ComponentType.COMP_MEW, getNodeEeveeID(), this.f50077a));
    }

    public void onRemove() {
        super.onRemove();
        m36085b();
    }

    /* renamed from: b */
    private void m36085b() {
        XERegister.unregisterTemplate("eevee_top_banner");
        XERegister.unregisterTemplate(ComponentType.COMP_MEW);
    }

    /* renamed from: c */
    private void m36086c() {
        XERegisterModel xERegisterModel = new XERegisterModel("eevee_top_banner", getNodeEeveeID(), this.f50078b);
        xERegisterModel.components = new ArrayList();
        xERegisterModel.components.add(new XETemplateComponent("eevee_template_top_banner_item", VpTemplateView.class, VpTemplateModel.class));
        XERegister.registerTemplate(xERegisterModel);
    }
}
