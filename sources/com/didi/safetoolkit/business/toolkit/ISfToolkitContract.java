package com.didi.safetoolkit.business.toolkit;

import com.android.didi.safetoolkit.presenter.IBaseView;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;

public interface ISfToolkitContract {

    public interface ToolkitPresenter {
        void onAlertClick();

        void onAudioRecordClick(String str, SfViewRecordMenuModel sfViewRecordMenuModel);

        void onAudioRecordClick(String str, boolean z);

        void onMonitorClick(SfViewMonitorMenuModel sfViewMonitorMenuModel);

        void onSafeCenterClick();

        void onShareClick(boolean z);
    }

    public interface ToolkitView extends IBaseView {
        void setShareEnable(boolean z);
    }
}
