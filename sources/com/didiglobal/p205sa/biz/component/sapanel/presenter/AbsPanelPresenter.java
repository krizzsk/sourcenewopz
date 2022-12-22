package com.didiglobal.p205sa.biz.component.sapanel.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.IViewContainer;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.guide.IGuide;
import com.didiglobal.p205sa.biz.component.sapanel.SAPanelProxy;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.IRideView;
import com.didiglobal.p205sa.biz.component.sapanel.model.SABizCardProperty;
import com.didiglobal.p205sa.biz.component.sapanel.view.SAPanelView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.presenter.AbsPanelPresenter */
public abstract class AbsPanelPresenter extends ComponentPresenterImpl<SAPanelView> {
    protected IGuide IDranageGuider;
    protected IGuide IGuider;
    protected ComponentParams componentParams;
    public Map<String, View> mBizCardMap = new HashMap();
    public List<SABizCardProperty> mBizCardProperties = new LinkedList();
    protected IViewContainer.IComponentCreator mComponentCreator;
    protected SAPanelProxy panelProxy;

    /* access modifiers changed from: protected */
    public abstract String getComponentIdByType(String str);

    /* access modifiers changed from: protected */
    public abstract String[] getNativeCards();

    public AbsPanelPresenter(ComponentParams componentParams2) {
        super(componentParams2);
        this.componentParams = componentParams2;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.panelProxy = ((SAPanelView) this.mView).getPanelProxy();
        loadNativeCards(bundle);
    }

    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public final void loadNativeCards(Bundle bundle) {
        String[] nativeCards = getNativeCards();
        if (nativeCards != null && nativeCards.length != 0) {
            for (String str : nativeCards) {
                if (!TextUtils.isEmpty(str)) {
                    inflateComponent(str, bundle);
                }
            }
        }
    }

    public final void inflateComponent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        IComponent newComponent = this.mComponentCreator.newComponent(this, str, (ViewGroup) ((SAPanelView) this.mView).getView(), bundle);
        if (newComponent != null && newComponent.getView() != null) {
            View view = newComponent.getView().getView();
            SABizCardProperty sABizCardProperty = new SABizCardProperty();
            sABizCardProperty.mView = view;
            sABizCardProperty.mType = str;
            sABizCardProperty.mId = getComponentIdByType(str);
            if (newComponent.getView() instanceof IRideView) {
                sABizCardProperty.rideView = (IRideView) newComponent.getView();
            }
            if (newComponent.getView() instanceof ICardVisibleListener) {
                sABizCardProperty.mVisibleListener = (ICardVisibleListener) newComponent.getView();
            }
            if (newComponent.getView() instanceof ICardPosition) {
                sABizCardProperty.cardPosition = (ICardPosition) newComponent.getView();
            }
            if (str.equals(ComponentType.COMPONENT_SA_GUIDE) && (newComponent.getPresenter() instanceof IGuide)) {
                this.IGuider = (IGuide) newComponent.getPresenter();
            } else if (!str.equals(ComponentType.COMPONENT_DRAINAGE_GUIDE) || !(newComponent.getPresenter() instanceof IGuide)) {
                this.mBizCardProperties.add(sABizCardProperty);
                this.mBizCardMap.put(sABizCardProperty.mId, sABizCardProperty.mView);
            } else {
                this.IDranageGuider = (IGuide) newComponent.getPresenter();
            }
        }
    }
}
