package com.didi.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;

public class CommonCheckBox extends ImageView {
    public CommonCheckBox(Context context) {
        super(context);
        init();
    }

    public CommonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CommonCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void init() {
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonSwitchSelector() == 0) {
            setBackgroundResource(R.drawable.checkbox_check_status);
        } else {
            setBackgroundResource(ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonCheckboxSelector());
        }
    }
}
