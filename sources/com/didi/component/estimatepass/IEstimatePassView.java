package com.didi.component.estimatepass;

import com.didi.component.core.IView;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;

public interface IEstimatePassView extends IView<EstimatePassPresenter> {

    public interface OnCheckChangeListener {
        void onCheckChange(boolean z);
    }

    void setArrowVisibility(int i);

    void setCheck(boolean z);

    void setCheckBoxVisibility(int i);

    void setOnCheckChangeListener(OnCheckChangeListener onCheckChangeListener);

    void setPassInfo(String str);

    void setPassRichInfo(LEGORichInfo lEGORichInfo);

    void setVisibility(int i);

    void showPassToast(String str);
}
