package com.didiglobal.comp.carmodellist.optionarea.carpool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.didiglobal.comp.carmodellist.button.AnyCarRadioButtonView;
import com.taxis99.R;

public class CarpoolRadioBtnViewImpl extends AnyCarRadioButtonView {
    public int getLayoutResId() {
        return R.layout.any_car_pool_radio_btn_item;
    }

    public CarpoolRadioBtnViewImpl(Context context) {
        super(context);
    }

    public CarpoolRadioBtnViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CarpoolRadioBtnViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ImageView getIcon() {
        return (ImageView) findViewById(R.id.lego_radia_button_icon);
    }

    public TextView getTitle() {
        return (TextView) findViewById(R.id.lego_radia_button_title);
    }
}
