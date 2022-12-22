package com.didi.global.fintech.cashier.pix.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.global.fintech.cashier.core.contract.IPresenter;
import com.didi.global.fintech.cashier.core.contract.IView;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixPresenter;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixView;
import com.taxis99.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class GlobalCashierPixCodeView extends FrameLayout implements IGlobalCashierPixView {

    /* renamed from: a */
    private Button f21652a;

    /* renamed from: b */
    private Button f21653b;

    /* renamed from: c */
    private Button f21654c;

    /* renamed from: d */
    private TextView f21655d;

    /* renamed from: e */
    private TextView f21656e;

    /* renamed from: f */
    private TextView f21657f;

    /* renamed from: g */
    private String f21658g;

    /* renamed from: h */
    private IGlobalCashierPixPresenter f21659h;

    public ViewGroup getView() {
        return this;
    }

    public GlobalCashierPixCodeView(Context context) {
        super(context);
        m15800a();
    }

    public GlobalCashierPixCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15800a();
    }

    public GlobalCashierPixCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15800a();
    }

    /* renamed from: a */
    private void m15800a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_cashier_payment_pix_code, this);
        this.f21652a = (Button) findViewById(R.id.btn_pix_code_confirm);
        this.f21653b = (Button) findViewById(R.id.btn_pix_code_paid);
        this.f21654c = (Button) findViewById(R.id.btn_pix_code_cancel);
        this.f21655d = (TextView) findViewById(R.id.tv_pix_code_detail);
        this.f21656e = (TextView) findViewById(R.id.tv_pix_code_title);
        this.f21657f = (TextView) findViewById(R.id.tv_pix_code_info);
        this.f21652a.setText(getResources().getString(R.string.GRider_payment_Copy_PIX_ybbs));
        this.f21653b.setText(getResources().getString(R.string.GRider_payment_I_have_uyIU));
        this.f21654c.setText(getResources().getString(R.string.GRider_payment_Cancel_ntbd));
    }

    public void bindPresenter(IPresenter<? extends IView> iPresenter) {
        this.f21659h = (IGlobalCashierPixPresenter) iPresenter;
    }

    public void updatePixCode(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f21658g = str;
            this.f21655d.setText(str);
        }
    }

    public void setOnConfirmClickListener(Function0<Unit> function0) {
        this.f21652a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierPixCodeView.m15803c(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m15803c(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void setOnCancelClickListener(Function0<Unit> function0) {
        this.f21654c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierPixCodeView.m15802b(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15802b(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void setOnPaidClickListener(Function0<Unit> function0) {
        this.f21653b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Function0.this.invoke();
            }
        });
    }

    public void animExpand(int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21655d, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21656e, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f21657f, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration((long) ((int) (((double) i) * 1.5d)));
        animatorSet.start();
    }

    /* renamed from: com.didi.global.fintech.cashier.pix.view.GlobalCashierPixCodeView$1 */
    static /* synthetic */ class C84891 {

        /* renamed from: $SwitchMap$com$didi$global$fintech$cashier$pix$contract$IGlobalCashierPixController$State */
        static final /* synthetic */ int[] f21660x6b7c7572;

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
                f21660x6b7c7572 = r0
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r1 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.Normal     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21660x6b7c7572     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r1 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.Timeout     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.pix.view.GlobalCashierPixCodeView.C84891.<clinit>():void");
        }
    }

    public void updateState(IGlobalCashierPixController.State state) {
        int i = C84891.f21660x6b7c7572[state.ordinal()];
        int i2 = 0;
        if (i == 1 || i == 2) {
            this.f21652a.setVisibility(state.equals(IGlobalCashierPixController.State.Normal) ? 0 : 8);
            Button button = this.f21653b;
            if (!state.equals(IGlobalCashierPixController.State.Timeout)) {
                i2 = 8;
            }
            button.setVisibility(i2);
            visibility(true);
            return;
        }
        visibility(false);
    }

    public void visibility(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
