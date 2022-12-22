package com.didi.safetoolkit.business.areaCode;

import android.text.SpannableString;
import com.android.didi.safetoolkit.presenter.IBaseView;

public interface SfManuallyIView extends IBaseView {
    void onAreaCodeAdded();

    void resetView();

    void setNumberAddNameText(String str, SpannableString spannableString);

    void setPhoneNumber(String str);

    void skipOut();
}
