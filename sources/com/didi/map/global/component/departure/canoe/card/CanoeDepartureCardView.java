package com.didi.map.global.component.departure.canoe.card;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.map.global.component.departure.view.RichTextInfo;
import com.taxis99.R;

public class CanoeDepartureCardView extends FrameLayout {

    /* renamed from: a */
    private TextView f24954a;

    /* renamed from: b */
    private TextView f24955b;

    /* renamed from: c */
    private ImageView f24956c;

    /* renamed from: d */
    private TextView f24957d;

    /* renamed from: e */
    private TextView f24958e;

    /* renamed from: f */
    private TextView f24959f;

    /* renamed from: g */
    private int f24960g;

    public CanoeDepartureCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CanoeDepartureCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CanoeDepartureCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24960g = 0;
        m17832a(context);
    }

    /* renamed from: a */
    private void m17832a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.canoe_card_view_layout, this, true);
        this.f24954a = (TextView) inflate.findViewById(R.id.canoe_card_title);
        this.f24955b = (TextView) inflate.findViewById(R.id.canoe_card_subtitle);
        this.f24956c = (ImageView) inflate.findViewById(R.id.canoe_card_address_icon);
        this.f24957d = (TextView) inflate.findViewById(R.id.canoe_card_address_name);
        this.f24958e = (TextView) inflate.findViewById(R.id.canoe_card_search);
        this.f24959f = (TextView) inflate.findViewById(R.id.canoe_card_confirm);
    }

    public void setCardStyle(int i) {
        int i2;
        int i3;
        int i4;
        if (i != 1) {
            i2 = R.drawable.canoe_card_start_icon;
            i4 = R.string.GRider_Sug_2020_map_button_pickup;
            i3 = R.string.GRider_Sug_2020_map_title_pickup;
        } else {
            i2 = R.drawable.canoe_card_end_icon;
            i4 = R.string.GRider_Sug_2020_map_button_whereTo;
            i3 = R.string.GRider_Sug_2020_map_title_whereTo;
        }
        ImageView imageView = this.f24956c;
        if (imageView != null) {
            imageView.setImageDrawable(getContext().getResources().getDrawable(i2));
        }
        TextView textView = this.f24959f;
        if (textView != null) {
            textView.setText(getContext().getResources().getString(i4));
        }
        TextView textView2 = this.f24954a;
        if (textView2 != null) {
            textView2.setText(getContext().getResources().getString(i3));
        }
    }

    public void setSearchClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f24957d;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        TextView textView2 = this.f24958e;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f24959f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setLoading(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f24957d.setText(str);
        }
        this.f24959f.setEnabled(false);
    }

    public void showLoadding() {
        setLoading(getResources().getString(R.string.GRider_Sug_2020_map_searchingAddress));
        this.f24957d.setTextColor(getResources().getColor(R.color.light_gray));
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f24954a);
            return;
        }
        this.f24954a.setText("");
    }

    public void setSubTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f24955b);
            return;
        }
        this.f24955b.setText("");
    }

    public void setAddress(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f24957d.setText(charSequence);
            this.f24957d.setTextColor(getResources().getColor(R.color.confirm_departure_point_color));
            this.f24959f.setEnabled(true);
        }
    }
}
