package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didichuxing.publicservice.general.AppUtils;

public class PublicServiceModel extends BaseHybridModule {
    public PublicServiceModel(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
    }

    @JsInterface({"clickHomeActivityWebConfirm"})
    public void closeActivityWeb() {
        AppUtils.log("js closeDialog");
        if (AssetWebviewDialogFragment.getFragment() != null) {
            AssetWebviewDialogFragment.getFragment().close();
        }
    }
}
