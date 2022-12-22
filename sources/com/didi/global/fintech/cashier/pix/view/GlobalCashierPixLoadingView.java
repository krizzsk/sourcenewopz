package com.didi.global.fintech.cashier.pix.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixLoadingView;
import com.taxis99.R;

public class GlobalCashierPixLoadingView extends FrameLayout implements IGlobalCashierPixLoadingView {

    /* renamed from: a */
    private TextView f21661a;

    /* renamed from: b */
    private LottieAnimationView f21662b;

    /* renamed from: c */
    private LottieAnimationView f21663c;

    public View getView() {
        return this;
    }

    public GlobalCashierPixLoadingView(Context context) {
        super(context);
        m15804a();
    }

    public GlobalCashierPixLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15804a();
    }

    public GlobalCashierPixLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15804a();
    }

    /* renamed from: a */
    private void m15804a() {
        LayoutInflater.from(getContext()).inflate(R.layout.gloabl_cashier_payment_pix_loading, this);
        this.f21661a = (TextView) findViewById(R.id.g_payment_title_top);
        this.f21662b = (LottieAnimationView) findViewById(R.id.g_payment_process_icon);
        this.f21663c = (LottieAnimationView) findViewById(R.id.g_payment_success_icon);
    }

    /* renamed from: com.didi.global.fintech.cashier.pix.view.GlobalCashierPixLoadingView$1 */
    static /* synthetic */ class C84901 {

        /* renamed from: $SwitchMap$com$didi$global$fintech$cashier$pix$contract$IGlobalCashierPixController$State */
        static final /* synthetic */ int[] f21664x6b7c7572;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State[] r0 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21664x6b7c7572 = r0
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r1 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.Loading     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21664x6b7c7572     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r1 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.Success     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.pix.view.GlobalCashierPixLoadingView.C84901.<clinit>():void");
        }
    }

    public void updateState(IGlobalCashierPixController.State state) {
        int i = C84901.f21664x6b7c7572[state.ordinal()];
        if (i == 1) {
            this.f21662b.setVisibility(0);
            this.f21663c.setVisibility(8);
            visibility(true);
        } else if (i != 2) {
            visibility(false);
        } else {
            this.f21661a.setText(R.string.cahiser_pay_success_state_string);
            this.f21662b.setVisibility(8);
            this.f21663c.setVisibility(0);
            visibility(true);
        }
    }

    public void visibility(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
