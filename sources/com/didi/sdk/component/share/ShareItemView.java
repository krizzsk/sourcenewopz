package com.didi.sdk.component.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class ShareItemView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f35671a;

    /* renamed from: b */
    private TextView f35672b;

    public ShareItemView(Context context) {
        super(context);
        m25258a();
    }

    public ShareItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25258a();
    }

    public ShareItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25258a();
    }

    /* renamed from: a */
    private void m25258a() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.v_share_item, this, true);
        this.f35671a = (ImageView) findViewById(R.id.share_item_icon);
        this.f35672b = (TextView) findViewById(R.id.share_item_name);
    }

    public void setInfo(int i, String str) {
        this.f35671a.setImageResource(i);
        this.f35672b.setText(str);
    }
}
