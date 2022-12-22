package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.taxis99.R;

public class AvatarComponentView extends ComponentView {

    /* renamed from: a */
    private ImageView f37468a;

    /* renamed from: b */
    private TextView f37469b;

    public AvatarComponentView(Context context) {
        super(context);
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.v_avatar_component_view, (ViewGroup) null);
        this.f37468a = (ImageView) inflate.findViewById(R.id.avatar_view);
        this.f37469b = (TextView) inflate.findViewById(R.id.right_arrow);
        return inflate;
    }

    public ImageView getAvatarView() {
        return this.f37468a;
    }

    public void setDes(String str) {
        this.f37469b.setText(str);
    }
}
