package com.didiglobal.p205sa.biz.component.activity.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.IViewContainer;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.didiglobal.p205sa.biz.component.activity.view.ActivityPanelView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.IRideView;
import com.didiglobal.p205sa.biz.component.sapanel.model.SABizCardProperty;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.activity.presenter.AbsActivityPanelPresenter */
public abstract class AbsActivityPanelPresenter extends ComponentPresenterImpl<ActivityPanelView> implements IViewContainer {
    protected ComponentParams componentParams;
    public Map<String, View> mBizCardMap = new HashMap();
    public List<SABizCardProperty> mBizCardProperties = new LinkedList();
    protected IViewContainer.IComponentCreator mComponentCreator;

    /* access modifiers changed from: protected */
    public abstract String getComponentIdByType(String str);

    public ComponentPresenter getHostPresenter() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String[] getNativeCards();

    public AbsActivityPanelPresenter(ComponentParams componentParams2) {
        super(componentParams2);
        this.componentParams = componentParams2;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
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
        IComponent newComponent = this.mComponentCreator.newComponent(this, str, (ViewGroup) ((ActivityPanelView) this.mView).getView(), bundle);
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
            this.mBizCardProperties.add(sABizCardProperty);
            this.mBizCardMap.put(sABizCardProperty.mId, sABizCardProperty.mView);
        }
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mComponentCreator = iComponentCreator;
    }
}
