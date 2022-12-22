package com.didi.entrega.customer.widget.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.foundation.sdk.log.LogService;
import com.didi.passenger.C10448R;
import com.didi.sdk.logging.Logger;
import com.didi.soda.andy.tools.LogUtils;
import com.taxis99.R;

public class SodaLoadingView extends RelativeLayout {

    /* renamed from: a */
    private Logger f20552a;

    /* renamed from: b */
    private LottieLoadingView f20553b;

    public SodaLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SodaLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SodaLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20552a = LogService.getLogger("SodaLoadingView");
        m15043a(context, attributeSet, i);
    }

    public void show() {
        this.f20553b.show();
    }

    public void hide() {
        this.f20553b.hide();
    }

    public boolean isRunning() {
        return getVisibility() == 0 && this.f20553b.isRunning();
    }

    public void start() {
        this.f20553b.start();
    }

    public void stop() {
        this.f20553b.stop();
    }

    /* renamed from: a */
    private void m15043a(Context context, AttributeSet attributeSet, int i) {
        String string;
        inflate(getContext(), R.layout.entrega_customer_layout_loading, this);
        this.f20553b = (LottieLoadingView) findViewById(R.id.customer_custom_lottie_loading_view);
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.LottieAnimationView);
            boolean hasValue = obtainStyledAttributes.hasValue(9);
            boolean hasValue2 = obtainStyledAttributes.hasValue(5);
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                if (resourceId != 0) {
                    this.f20553b.setAnimation(resourceId);
                }
            } else if (hasValue2 && (string = obtainStyledAttributes.getString(5)) != null) {
                this.f20553b.setAnimation(string);
            }
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            Logger logger = this.f20552a;
            logger.info(LogUtils.getLineText("⚠️ init() called with error : " + e.getMessage()), new Object[0]);
        }
    }
}
