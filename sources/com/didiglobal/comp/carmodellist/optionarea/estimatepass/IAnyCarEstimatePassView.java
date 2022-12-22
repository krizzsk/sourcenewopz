package com.didiglobal.comp.carmodellist.optionarea.estimatepass;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;

public interface IAnyCarEstimatePassView {

    public interface OnCheckChangeListener {
        void onCheckChange(boolean z);
    }

    void setArrowVisibility(int i);

    void setCheck(boolean z);

    void setCheckBoxVisibility(int i);

    void setOnCheckChangeListener(OnCheckChangeListener onCheckChangeListener);

    void setPassRichInfo(LEGORichInfo lEGORichInfo);

    void setVisibility(int i);

    void showPassToast(String str);
}
