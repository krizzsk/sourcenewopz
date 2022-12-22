package com.didi.component.common.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.didi.component.core.dialog.DialogInfo;

public abstract class BaseCustomViewDialog implements IDialog {
    protected LayoutInflater mInflate;

    public boolean cancelable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract View customView();

    public void dismiss() {
    }

    public int getId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void initView(View view);

    public boolean isShowing() {
        return false;
    }

    public void show() {
    }

    public void update(DialogInfo dialogInfo) {
    }

    public BaseCustomViewDialog(Context context) {
        this.mInflate = LayoutInflater.from(context);
        initView(customView());
    }
}
