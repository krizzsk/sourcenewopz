package com.didi.map.global.flow.scene.order.confirm;

import android.text.SpannableString;
import android.view.View;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.InfoWindow;

public class BubbleContentParam {

    /* renamed from: a */
    private boolean f26571a;

    /* renamed from: b */
    private String f26572b;

    /* renamed from: c */
    private SpannableString f26573c;

    /* renamed from: d */
    private View f26574d;

    /* renamed from: e */
    private InfoWindow.Position f26575e;

    /* renamed from: f */
    private OnInfoWindowClickListener f26576f;

    public boolean isLoadingToggle() {
        return this.f26571a;
    }

    public void setLoadingToggle(boolean z) {
        this.f26571a = z;
    }

    public String getContent() {
        return this.f26572b;
    }

    public void setContent(String str) {
        this.f26572b = str;
    }

    public SpannableString getFullTextContent() {
        return this.f26573c;
    }

    public void setFullTextContent(SpannableString spannableString) {
        this.f26573c = spannableString;
    }

    public View getContentView() {
        return this.f26574d;
    }

    public void setContentView(View view) {
        this.f26574d = view;
    }

    public InfoWindow.Position getPosition() {
        return this.f26575e;
    }

    public void setPosition(InfoWindow.Position position) {
        this.f26575e = position;
    }

    public OnInfoWindowClickListener getClickListener() {
        return this.f26576f;
    }

    public void setClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f26576f = onInfoWindowClickListener;
    }
}
