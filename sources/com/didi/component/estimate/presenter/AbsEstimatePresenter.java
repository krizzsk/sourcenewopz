package com.didi.component.estimate.presenter;

import android.view.ViewGroup;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.estimate.newui.view.IV2EstimateView;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;

public abstract class AbsEstimatePresenter<V extends IV2EstimateView> extends AbsLoadingPresenter<IV2EstimateView> implements IViewContainer {
    protected IViewContainer.IComponentCreator mComponentCreator;

    public void bubbleSelectUpload(EstimateItemModel estimateItemModel) {
    }

    public void hideGuidePopUp() {
    }

    public void reEstimate() {
    }

    public AbsEstimatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public IComponent inflateComponent(String str, ViewGroup viewGroup) {
        IComponent newComponent = this.mComponentCreator.newComponent(str, viewGroup);
        if (newComponent != null && newComponent.getView() != null && newComponent.getView().getView() != null) {
            return newComponent;
        }
        this.mComponentCreator.removeComponent(newComponent);
        return null;
    }

    public void removeComponent(IComponent iComponent) {
        this.mComponentCreator.removeComponent(iComponent);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mComponentCreator = iComponentCreator;
    }
}
