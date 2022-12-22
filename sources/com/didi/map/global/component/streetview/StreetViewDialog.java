package com.didi.map.global.component.streetview;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.didi.map.global.component.streetview.utils.DisplayUtil;

public class StreetViewDialog extends Dialog {
    public StreetViewDialog(Context context) {
        super(context, 2132017612);
    }

    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Context context = getContext();
            attributes.width = DisplayUtil.getScreenWidth(context) - (DisplayUtil.dp2px(context, 20.0f) * 2);
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }
}
