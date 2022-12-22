package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;

public class TextComponentView extends ComponentView {

    /* renamed from: a */
    private TextView f37510a;

    /* renamed from: b */
    private TextView f37511b;

    /* renamed from: c */
    private ImageView f37512c;

    /* renamed from: d */
    private TextView f37513d;

    /* renamed from: e */
    private ImageView f37514e;

    /* renamed from: f */
    private View f37515f;

    /* renamed from: g */
    private TextView f37516g;

    /* renamed from: h */
    private View f37517h;

    public TextComponentView(Context context) {
        super(context);
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.v_sidebar_nav_iteml, (ViewGroup) null);
        this.f37517h = inflate;
        this.f37510a = (TextView) inflate.findViewById(R.id.sidebar_nav_item_name);
        this.f37511b = (TextView) inflate.findViewById(R.id.sidebar_nav_item_right_des);
        this.f37512c = (ImageView) inflate.findViewById(R.id.setting_list_item_arrow);
        this.f37514e = (ImageView) inflate.findViewById(R.id.item_icon);
        this.f37513d = (TextView) inflate.findViewById(R.id.item_tip);
        this.f37515f = inflate.findViewById(R.id.divider);
        this.f37516g = (TextView) inflate.findViewById(R.id.item_right_des_tip);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, this.context.getResources().getDimensionPixelOffset(R.dimen.setting_item_height));
        }
        inflate.setLayoutParams(layoutParams);
        inflate.setOnClickListener(this);
        return inflate;
    }

    public void hideDivider() {
        this.f37515f.setVisibility(8);
    }

    public void setName(String str) {
        super.setName(str);
        this.f37510a.setText(str);
    }

    public void setRightDes(String str) {
        this.f37511b.setVisibility(0);
        this.f37511b.setText(str);
    }

    public void setRightDes(String str, boolean z) {
        this.f37511b.setVisibility(0);
        this.f37511b.setText(str);
        if (DRtlToolkit.rtl() && z) {
            this.f37511b.setTextDirection(3);
        }
    }

    public void setRightDesTipVisible() {
        this.f37516g.setVisibility(0);
    }

    public void setRightDesTipVisibility(boolean z) {
        this.f37516g.setVisibility(z ? 0 : 8);
    }

    public void setTip(String str) {
        this.f37513d.setVisibility(0);
        this.f37513d.setText(str);
    }

    public void setIcon(Bitmap bitmap) {
        this.f37514e.setVisibility(0);
        this.f37514e.setImageBitmap(bitmap);
    }

    public void setRightArrowVisible(int i) {
        this.f37512c.setVisibility(i);
    }

    public void setRightIconRes(int i) {
        this.f37514e.setVisibility(0);
        this.f37512c.setImageResource(i);
    }

    public void setVisible(int i) {
        View view = this.f37517h;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
