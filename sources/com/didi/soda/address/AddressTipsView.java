package com.didi.soda.address;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class AddressTipsView extends RelativeLayout {

    /* renamed from: a */
    private Context f38629a;

    /* renamed from: b */
    private View f38630b;

    /* renamed from: c */
    private ImageView f38631c;

    /* renamed from: d */
    private TextView f38632d;

    public AddressTipsView(Context context) {
        super(context);
        this.f38629a = context;
        m27356a();
    }

    public AddressTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38629a = context;
        m27356a();
    }

    public void setContent(String str) {
        this.f38632d.setText(str);
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m27356a() {
        View inflate = LayoutInflater.from(this.f38629a).inflate(R.layout.customer_component_address_tips, this);
        this.f38630b = inflate;
        this.f38631c = (ImageView) inflate.findViewById(R.id.customer_iv_tips_close);
        this.f38632d = (TextView) this.f38630b.findViewById(R.id.customer_tv_address_tips_content);
        this.f38631c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AddressTipsView.this.setVisibility(8);
            }
        });
    }
}
