package com.didi.beatles.p099im.access.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.access.card.IMDetailsBtn */
public class IMDetailsBtn extends LinearLayout {

    /* renamed from: a */
    private TextView f8718a;

    /* renamed from: b */
    private ImageView f8719b;

    public IMDetailsBtn(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMDetailsBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMDetailsBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5824a();
    }

    /* renamed from: a */
    private void m5824a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.im_msg_card_btn, this, true);
        this.f8718a = (TextView) inflate.findViewById(R.id.detail_tv);
        this.f8719b = (ImageView) inflate.findViewById(R.id.detail_iv);
        this.f8718a.setText(IMResource.getString(R.string.im_nomix_see_details));
        this.f8718a.setTextColor(IMResource.getColor(R.color.im_nomix_detail_btn_color));
        this.f8719b.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_follow_bts_arrow));
    }
}
