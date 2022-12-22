package com.didi.soda.customer.widget.loading;

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
    private Logger f42088a;

    /* renamed from: b */
    private LottieLoadingView f42089b;

    public SodaLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SodaLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SodaLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f42088a = LogService.getLogger("SodaLoadingView");
        m29689a(context, attributeSet, i);
    }

    public void show() {
        this.f42089b.show();
    }

    public void hide() {
        this.f42089b.hide();
    }

    public boolean isRunning() {
        return getVisibility() == 0 && this.f42089b.isRunning();
    }

    public void start() {
        this.f42089b.start();
    }

    public void stop() {
        this.f42089b.stop();
    }

    /* renamed from: a */
    private void m29689a(Context context, AttributeSet attributeSet, int i) {
        String string;
        inflate(getContext(), R.layout.customer_layout_loading, this);
        this.f42089b = (LottieLoadingView) findViewById(R.id.customer_custom_lottie_loading_view);
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.LottieAnimationView);
            boolean hasValue = obtainStyledAttributes.hasValue(9);
            boolean hasValue2 = obtainStyledAttributes.hasValue(5);
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                if (resourceId != 0) {
                    this.f42089b.setAnimation(resourceId);
                }
            } else if (hasValue2 && (string = obtainStyledAttributes.getString(5)) != null) {
                this.f42089b.setAnimation(string);
            }
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            Logger logger = this.f42088a;
            logger.info(LogUtils.getLineText("⚠️ init() called with error : " + e.getMessage()), new Object[0]);
        }
    }
}
