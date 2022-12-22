package com.didi.payment.creditcard.global.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CardTypeSelectView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private View f30599a;

    /* renamed from: b */
    private View f30600b;

    /* renamed from: c */
    private ImageView f30601c;

    /* renamed from: d */
    private TextView f30602d;

    /* renamed from: e */
    private ImageView f30603e;

    /* renamed from: f */
    private TextView f30604f;

    /* renamed from: g */
    private int f30605g;

    /* renamed from: h */
    private int f30606h = 0;

    /* renamed from: i */
    private OnCardTypeSelectChangeListener f30607i;

    public interface OnCardTypeSelectChangeListener {
        void onCardTypeSelect(int i);
    }

    public CardTypeSelectView(Context context) {
        super(context);
    }

    public CardTypeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardTypeSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.one_payment_creditcard_global_v_card_type_select, this, true);
        this.f30599a = findViewById(R.id.layout_card_select_left);
        this.f30600b = findViewById(R.id.layout_card_select_right);
        this.f30601c = (ImageView) findViewById(R.id.iv_card_select_left);
        this.f30602d = (TextView) findViewById(R.id.tv_card_select_left);
        this.f30603e = (ImageView) findViewById(R.id.iv_card_select_right);
        this.f30599a.setOnClickListener(this);
        this.f30600b.setOnClickListener(this);
        this.f30604f = (TextView) findViewById(R.id.tv_card_select_right);
        this.f30605g = this.f30602d.getCurrentTextColor();
        this.f30606h = 0;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        getVisibility();
    }

    public boolean isTypeSelected() {
        return this.f30606h != 0;
    }

    public int getSelectState() {
        return this.f30606h;
    }

    public int getCardType() {
        int i = this.f30606h;
        if (i == 1) {
            return 3;
        }
        return i == 2 ? 2 : 0;
    }

    public void resetError() {
        TextView textView = this.f30602d;
        if (!(textView == null || this.f30604f == null)) {
            textView.setTextColor(this.f30605g);
            this.f30604f.setTextColor(this.f30605g);
        }
        this.f30606h = 0;
        this.f30601c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
        this.f30603e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
    }

    public void showError() {
        TextView textView = this.f30602d;
        if (!(textView == null || this.f30604f == null)) {
            textView.setTextColor(-65536);
            this.f30604f.setTextColor(-65536);
        }
        this.f30606h = 0;
        this.f30601c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
        this.f30603e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.layout_card_select_left) {
            this.f30602d.setTextColor(this.f30605g);
            this.f30604f.setTextColor(this.f30605g);
            if (this.f30606h != 1) {
                this.f30606h = 1;
                this.f30601c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected);
                this.f30603e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener = this.f30607i;
                if (onCardTypeSelectChangeListener != null) {
                    onCardTypeSelectChangeListener.onCardTypeSelect(0);
                }
            }
        } else if (id == R.id.layout_card_select_right) {
            this.f30602d.setTextColor(this.f30605g);
            this.f30604f.setTextColor(this.f30605g);
            if (this.f30606h != 2) {
                this.f30606h = 2;
                this.f30603e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected);
                this.f30601c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener2 = this.f30607i;
                if (onCardTypeSelectChangeListener2 != null) {
                    onCardTypeSelectChangeListener2.onCardTypeSelect(1);
                }
            }
        }
    }

    public void setOnCardTypeSelectChangeListener(OnCardTypeSelectChangeListener onCardTypeSelectChangeListener) {
        this.f30607i = onCardTypeSelectChangeListener;
    }
}
