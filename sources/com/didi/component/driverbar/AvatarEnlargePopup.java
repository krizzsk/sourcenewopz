package com.didi.component.driverbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class AvatarEnlargePopup extends PopupWindow {

    /* renamed from: a */
    private Context f12918a;

    /* renamed from: b */
    private View f12919b;

    /* renamed from: c */
    private ImageView f12920c;

    /* renamed from: d */
    private ImageView f12921d;

    /* renamed from: e */
    private String f12922e;

    /* renamed from: f */
    private View f12923f;

    public AvatarEnlargePopup(Context context, View view, int i, int i2, String str) {
        super(view, i, i2);
        this.f12919b = view;
        this.f12922e = str;
        this.f12918a = context;
        m8781a();
    }

    public void show() {
        setClippingEnabled(false);
        setOutsideTouchable(true);
        showAtLocation(this.f12919b, 17, 0, 0);
    }

    /* renamed from: a */
    private void m8781a() {
        this.f12921d = (ImageView) this.f12919b.findViewById(R.id.enlarge_popup_img);
        this.f12920c = (ImageView) this.f12919b.findViewById(R.id.enlarge_popup_close);
        this.f12923f = this.f12919b.findViewById(R.id.bg);
        setBackgroundDrawable(new ColorDrawable(0));
        this.f12923f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AvatarEnlargePopup.this.dismiss();
            }
        });
        this.f12921d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f12920c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AvatarEnlargePopup.this.dismiss();
            }
        });
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.f12918a).asBitmap().load(this.f12922e).placeholder((int) R.drawable.driver_card_default_avatar_v2_big)).dontAnimate()).into(this.f12921d);
    }
}
