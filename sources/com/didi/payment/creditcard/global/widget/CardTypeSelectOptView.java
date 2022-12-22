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
import com.didi.payment.creditcard.global.p130v2.utils.BindCardApolloUtils;
import com.taxis99.R;

public class CardTypeSelectOptView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private View f30590a;

    /* renamed from: b */
    private View f30591b;

    /* renamed from: c */
    private ImageView f30592c;

    /* renamed from: d */
    private TextView f30593d;

    /* renamed from: e */
    private ImageView f30594e;

    /* renamed from: f */
    private TextView f30595f;

    /* renamed from: g */
    private int f30596g;

    /* renamed from: h */
    private int f30597h = 0;

    /* renamed from: i */
    private OnCardTypeSelectChangeListener f30598i;

    public interface OnCardTypeSelectChangeListener {
        void onCardTypeSelect(int i);
    }

    public CardTypeSelectOptView(Context context) {
        super(context);
    }

    public CardTypeSelectOptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardTypeSelectOptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.one_payment_creditcard_global_v_card_type_select_opt, this, true);
        this.f30590a = findViewById(R.id.layout_card_select_left);
        this.f30591b = findViewById(R.id.layout_card_select_right);
        this.f30592c = (ImageView) findViewById(R.id.iv_card_select_left);
        this.f30593d = (TextView) findViewById(R.id.tv_card_select_left);
        this.f30594e = (ImageView) findViewById(R.id.iv_card_select_right);
        this.f30590a.setOnClickListener(this);
        this.f30591b.setOnClickListener(this);
        this.f30595f = (TextView) findViewById(R.id.tv_card_select_right);
        this.f30596g = this.f30593d.getCurrentTextColor();
        this.f30597h = 0;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        getVisibility();
    }

    public boolean isTypeSelected() {
        return this.f30597h != 0;
    }

    public int getSelectState() {
        return this.f30597h;
    }

    public int getCardType() {
        int i = this.f30597h;
        if (i == 1) {
            return 3;
        }
        return i == 2 ? 2 : 0;
    }

    public void resetError() {
        TextView textView = this.f30593d;
        if (!(textView == null || this.f30595f == null)) {
            textView.setTextColor(this.f30596g);
            this.f30595f.setTextColor(this.f30596g);
        }
        this.f30597h = 0;
        this.f30592c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
        this.f30594e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
    }

    public void showError() {
        TextView textView = this.f30593d;
        if (!(textView == null || this.f30595f == null)) {
            textView.setTextColor(-65536);
            this.f30595f.setTextColor(-65536);
        }
        this.f30597h = 0;
        this.f30592c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
        this.f30594e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.layout_card_select_left) {
            this.f30593d.setTextColor(this.f30596g);
            this.f30595f.setTextColor(this.f30596g);
            if (this.f30597h != 1) {
                this.f30597h = 1;
                if (BindCardApolloUtils.useNewVersion()) {
                    this.f30592c.setImageResource(getSelectedResId());
                } else {
                    this.f30592c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected_opt);
                }
                this.f30594e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener = this.f30598i;
                if (onCardTypeSelectChangeListener != null) {
                    onCardTypeSelectChangeListener.onCardTypeSelect(0);
                }
            }
        } else if (id == R.id.layout_card_select_right) {
            this.f30593d.setTextColor(this.f30596g);
            this.f30595f.setTextColor(this.f30596g);
            if (this.f30597h != 2) {
                this.f30597h = 2;
                if (BindCardApolloUtils.useNewVersion()) {
                    this.f30594e.setImageResource(getSelectedResId());
                } else {
                    this.f30594e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected_opt);
                }
                this.f30592c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener2 = this.f30598i;
                if (onCardTypeSelectChangeListener2 != null) {
                    onCardTypeSelectChangeListener2.onCardTypeSelect(1);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getTerminalId(getContext());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSelectedResId() {
        /*
            r2 = this;
            com.didi.payment.base.proxy.CommonProxyHolder$ICommonProxy r0 = com.didi.payment.base.proxy.CommonProxyHolder.getProxy()
            if (r0 == 0) goto L_0x0020
            android.content.Context r1 = r2.getContext()
            java.lang.Object r0 = r0.getTerminalId(r1)
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "5"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0020
            r0 = 2131234762(0x7f080fca, float:1.8085699E38)
            return r0
        L_0x0020:
            r0 = 2131234791(0x7f080fe7, float:1.8085758E38)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.global.widget.CardTypeSelectOptView.getSelectedResId():int");
    }

    public void setOnCardTypeSelectChangeListener(OnCardTypeSelectChangeListener onCardTypeSelectChangeListener) {
        this.f30598i = onCardTypeSelectChangeListener;
    }
}
