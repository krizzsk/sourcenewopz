package com.didi.component.framework.base;

import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.base.ComponentType;
import com.didi.component.comp_xpanel.AbsGlobalXPanelView;
import com.didi.component.comp_xpanel.GlobalXPanelComponent;
import com.didi.component.core.IComponent;
import com.didi.component.core.PresenterGroup;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;

public abstract class XPanelLoadingNormalFragment<P extends PresenterGroup> extends AbsNormalFragment<P> implements ILoadingable {
    public void showMaskLayerLoading() {
        IComponent findComponentByName = findComponentByName(ComponentType.XPANEL);
        if (findComponentByName instanceof GlobalXPanelComponent) {
            GlobalXPanelComponent globalXPanelComponent = (GlobalXPanelComponent) findComponentByName;
            if (globalXPanelComponent.isXpanelEyeable()) {
                LoadingConfig loadingConfig = new LoadingConfig();
                loadingConfig.setWithMaskLayer(true);
                ((AbsGlobalXPanelView) globalXPanelComponent.getView()).showLoading(loadingConfig);
                return;
            }
            super.showMaskLayerLoading();
            return;
        }
        super.showMaskLayerLoading();
    }

    public void showLoadingOnTitleBar() {
        super.showMaskLayerLoading();
    }

    public void showLoading() {
        IComponent findComponentByName = findComponentByName(ComponentType.XPANEL);
        if (findComponentByName instanceof GlobalXPanelComponent) {
            GlobalXPanelComponent globalXPanelComponent = (GlobalXPanelComponent) findComponentByName;
            if (globalXPanelComponent.isXpanelEyeable()) {
                ((AbsGlobalXPanelView) globalXPanelComponent.getView()).showLoading();
            } else {
                super.showLoading();
            }
        } else {
            super.showLoading();
        }
    }

    public void showLoading(LoadingConfig loadingConfig) {
        IComponent findComponentByName = findComponentByName(ComponentType.XPANEL);
        if (findComponentByName instanceof GlobalXPanelComponent) {
            GlobalXPanelComponent globalXPanelComponent = (GlobalXPanelComponent) findComponentByName;
            if (globalXPanelComponent.isXpanelEyeable()) {
                ((AbsGlobalXPanelView) globalXPanelComponent.getView()).showLoading(loadingConfig);
            } else {
                super.showLoading(loadingConfig);
            }
        } else {
            super.showLoading(loadingConfig);
        }
    }

    public void hideLoading() {
        IComponent findComponentByName = findComponentByName(ComponentType.XPANEL);
        if (findComponentByName instanceof GlobalXPanelComponent) {
            GlobalXPanelComponent globalXPanelComponent = (GlobalXPanelComponent) findComponentByName;
            if (globalXPanelComponent.isXpanelEyeable()) {
                ((AbsGlobalXPanelView) globalXPanelComponent.getView()).hideLoading();
            } else {
                super.hideLoading();
            }
        } else {
            super.hideLoading();
        }
    }

    public void hidePageLoading() {
        super.hideLoading();
    }

    public boolean isLoading() {
        IComponent findComponentByName = findComponentByName(ComponentType.XPANEL);
        if (findComponentByName instanceof GlobalXPanelComponent) {
            GlobalXPanelComponent globalXPanelComponent = (GlobalXPanelComponent) findComponentByName;
            if (globalXPanelComponent.isXpanelEyeable()) {
                return ((AbsGlobalXPanelView) globalXPanelComponent.getView()).isLoading();
            }
        }
        return super.isLoading();
    }
}
