package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzzn;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class AdManagerAdView extends ViewGroup {
    private final zzzn zzaeh;

    public AdManagerAdView(Context context) {
        super(context);
        this.zzaeh = new zzzn(this);
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaeh = new zzzn(this, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaeh = new zzzn(this, attributeSet, true);
    }

    public final VideoController getVideoController() {
        return this.zzaeh.getVideoController();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzaeh.setVideoOptions(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.zzaeh.getVideoOptions();
    }

    public final void destroy() {
        this.zzaeh.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzaeh.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzaeh.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.zzaeh.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.zzaeh.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzaeh.getAppEventListener();
    }

    public final void loadAd(AdManagerAdRequest adManagerAdRequest) {
        this.zzaeh.zza(adManagerAdRequest.zzdt());
    }

    public final void pause() {
        this.zzaeh.pause();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzaeh.setManualImpressionsEnabled(z);
    }

    public final void recordManualImpression() {
        this.zzaeh.recordManualImpression();
    }

    public final void resume() {
        this.zzaeh.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzaeh.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzaeh.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzaeh.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzaeh.setAppEventListener(appEventListener);
    }

    public final boolean isLoading() {
        return this.zzaeh.isLoading();
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzaeh.getResponseInfo();
    }

    public final boolean zza(zzxq zzxq) {
        return this.zzaeh.zza(zzxq);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbao.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
