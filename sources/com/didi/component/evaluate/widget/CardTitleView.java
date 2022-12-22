package com.didi.component.evaluate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CardTitleView extends RelativeLayout {

    /* renamed from: a */
    private View f13430a;

    /* renamed from: b */
    private TextView f13431b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardTitleCloseBtnListener f13432c;

    public interface CardTitleCloseBtnListener {
        void onCloseBtnClick();
    }

    public CardTitleView(Context context) {
        super(context);
        m9202a();
    }

    public CardTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9202a();
    }

    /* renamed from: a */
    private void m9202a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_include_card_title, this, true);
        this.f13430a = inflate.findViewById(R.id.btn_card_close);
        this.f13431b = (TextView) inflate.findViewById(R.id.tv_card_title);
        this.f13430a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardTitleView.this.f13432c != null) {
                    CardTitleView.this.f13432c.onCloseBtnClick();
                }
            }
        });
    }

    public void setCloseIconListener(CardTitleCloseBtnListener cardTitleCloseBtnListener) {
        this.f13432c = cardTitleCloseBtnListener;
    }

    public void setTitleText(String str) {
        this.f13431b.setText(str);
    }

    public void setClosable(boolean z) {
        this.f13430a.setEnabled(z);
    }

    public boolean isCloseAble() {
        return this.f13430a.isEnabled();
    }
}
