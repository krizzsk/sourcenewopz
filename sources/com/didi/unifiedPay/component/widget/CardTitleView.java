package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CardTitleView extends RelativeLayout {

    /* renamed from: a */
    private View f44448a;

    /* renamed from: b */
    private TextView f44449b;

    /* renamed from: c */
    private ImageView f44450c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardTitleCloseBtnListener f44451d;

    public interface CardTitleCloseBtnListener {
        void onCloseBtnClick();
    }

    public CardTitleView(Context context) {
        super(context);
        m31566a();
    }

    public CardTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31566a();
    }

    /* renamed from: a */
    private void m31566a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.oc_unified_pay_include_card_title, this, true);
        this.f44448a = inflate.findViewById(R.id.oc_iv_close_icon_container);
        this.f44449b = (TextView) inflate.findViewById(R.id.oc_tv_title);
        this.f44450c = (ImageView) inflate.findViewById(R.id.oc_iv_line);
        this.f44448a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardTitleView.this.f44451d != null) {
                    CardTitleView.this.f44451d.onCloseBtnClick();
                }
            }
        });
    }

    public void setTitle(String str) {
        this.f44449b.setText(str);
    }

    public void setTitle(int i) {
        this.f44449b.setText(i);
    }

    public void setCloseIconListener(CardTitleCloseBtnListener cardTitleCloseBtnListener) {
        this.f44451d = cardTitleCloseBtnListener;
    }

    public void setClosable(boolean z) {
        this.f44448a.setEnabled(z);
    }

    public void showLine(boolean z) {
        if (z) {
            this.f44450c.setVisibility(0);
        } else {
            this.f44450c.setVisibility(8);
        }
    }

    public boolean isCloseAble() {
        return this.f44448a.isEnabled();
    }
}
