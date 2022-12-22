package com.didi.sdk.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class BaseDialog extends Dialog {
    public void resizeView(View view) {
    }

    public BaseDialog(Context context, int i) {
        super(context, i);
    }

    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    public void setContentView(View view) {
        resizeView(view);
        super.setContentView(view);
    }

    public String getLogTag() {
        return getClass().getSimpleName();
    }
}
