package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.XPCardView */
public class XPCardView {

    /* renamed from: a */
    private View f51181a;

    /* renamed from: b */
    private Callback f51182b;

    /* renamed from: com.didiglobal.sa.biz.component.sapanel.view.XPCardView$Callback */
    public interface Callback {
        void heightChange(int i);

        void remove(int i);

        void secondHeightChange(int i, int i2);

        void willAdd(int i);
    }

    public XPCardView(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.component_panel_card_view, (ViewGroup) null);
        this.f51181a = inflate;
        ((TextView) inflate.findViewById(R.id.title)).setText("AAAAAAAAAAAAAAAAAAAAAAAAA");
        ((TextView) this.f51181a.findViewById(R.id.content)).setText("BBBBBBBBBBBBBBBBB");
    }

    public View getView() {
        return this.f51181a;
    }

    public void setCallback(Callback callback) {
        this.f51182b = callback;
    }
}
