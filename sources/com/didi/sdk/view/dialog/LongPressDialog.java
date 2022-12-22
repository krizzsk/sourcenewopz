package com.didi.sdk.view.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.taxis99.R;

public class LongPressDialog extends AlertDialogBase {

    /* renamed from: a */
    private View f37979a;

    /* renamed from: b */
    private Button f37980b;

    /* renamed from: c */
    private String f37981c;

    /* renamed from: d */
    private View.OnClickListener f37982d;

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_long_press_dialog_btn, viewGroup);
        this.f37979a = inflate;
        Button button = (Button) inflate.findViewById(R.id.button);
        this.f37980b = button;
        button.setText(this.f37981c);
        this.f37980b.setOnClickListener(this.f37982d);
        return this.f37979a;
    }

    public void setupButton(String str, View.OnClickListener onClickListener) {
        this.f37981c = str;
        this.f37982d = onClickListener;
    }
}
