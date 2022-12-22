package com.didi.entrega.customer.widget.loading.render;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.taxis99.R;

public class ProgressBarLoadingRender extends BaseLoadingRender {
    public static String sIndeterminateDrawableId = "Loading::ProgressBar::Indeterminate::Drawable::Id";

    /* renamed from: b */
    private ProgressBar f20582b;

    public boolean isRunning() {
        return this.f20582b.isIndeterminate() && this.f20582b.getWindowVisibility() == 0 && this.f20582b.isShown();
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        this.f20582b = (ProgressBar) LayoutInflater.from(context).inflate(R.layout.loading_progressbar, (ViewGroup) null);
        int i = bundle.getInt(sIndeterminateDrawableId);
        if (i != 0) {
            this.f20582b.setIndeterminateDrawable(context.getResources().getDrawable(i));
        }
        if (bundle.getInt("Loading::Interpolator::Id") != 0) {
            this.f20582b.setInterpolator(context, bundle.getInt("Loading::Interpolator::Id"));
        }
        this.f20582b.setBackgroundColor(bundle.getInt("Loading::Background::Color", 0));
        return this.f20582b;
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        this.f20582b.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f20582b.setVisibility(8);
    }
}
