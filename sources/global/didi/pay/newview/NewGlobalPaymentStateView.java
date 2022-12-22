package global.didi.pay.newview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.taxis99.R;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;

public class NewGlobalPaymentStateView extends LinearLayout {
    public static final String TYPE_EMPTY = "empty";
    public static final String TYPE_PROCESS = "process";
    public static final String TYPE_SUBMIT = "submit";
    public static final String TYPE_SUCCESS = "success";
    private LottieAnimationView g_payment_process_icon;
    private View g_payment_submit;
    private LottieAnimationView g_payment_success_icon;

    public NewGlobalPaymentStateView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPaymentStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_state, this);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.g_payment_process_icon);
        this.g_payment_process_icon = lottieAnimationView;
        lottieAnimationView.setAnimation(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getLoadingLottie());
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.g_payment_success_icon);
        this.g_payment_success_icon = lottieAnimationView2;
        lottieAnimationView2.setAnimation(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getSuccessLottie());
        this.g_payment_submit = findViewById(R.id.g_payment_submit);
    }

    public void switchStatus(String str) {
        int i = 0;
        this.g_payment_success_icon.setVisibility(str.equals("success") ? 0 : 8);
        this.g_payment_process_icon.setVisibility(str.equals("process") ? 0 : 8);
        this.g_payment_submit.setVisibility(str.equals(TYPE_SUBMIT) ? 0 : 8);
        if (str.equals("empty")) {
            i = 8;
        }
        setVisibility(i);
    }

    public NewGlobalPaymentSubmitView getSubmitView() {
        return (NewGlobalPaymentSubmitView) this.g_payment_submit;
    }
}
