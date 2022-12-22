package com.didi.universal.pay.biz.p172ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.didi.universal.pay.biz.ui.UniversalTitleView */
public class UniversalTitleView extends RelativeLayout {

    /* renamed from: a */
    private View f45102a;

    /* renamed from: b */
    private TextView f45103b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardTitleCloseBtnListener f45104c;

    /* renamed from: com.didi.universal.pay.biz.ui.UniversalTitleView$CardTitleCloseBtnListener */
    public interface CardTitleCloseBtnListener {
        void onCloseBtnClick();
    }

    public UniversalTitleView(Context context) {
        super(context);
        m32381a();
    }

    public UniversalTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32381a();
    }

    /* renamed from: a */
    private void m32381a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.universal_title, this, true);
        this.f45102a = inflate.findViewById(R.id.universal_title_icon);
        this.f45103b = (TextView) inflate.findViewById(R.id.universal_title_name);
        this.f45102a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (UniversalTitleView.this.f45104c != null) {
                    UniversalTitleView.this.f45104c.onCloseBtnClick();
                }
            }
        });
    }

    public void setTitle(String str) {
        this.f45103b.setText(str);
    }

    public void setTitle(int i) {
        this.f45103b.setText(i);
    }

    public void setCloseIconListener(CardTitleCloseBtnListener cardTitleCloseBtnListener) {
        this.f45104c = cardTitleCloseBtnListener;
    }
}
