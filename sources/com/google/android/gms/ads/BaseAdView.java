package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzn;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
class BaseAdView extends ViewGroup {
    protected final zzzn zzadm;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzadm = new zzzn(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzadm = new zzzn(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzadm = new zzzn(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzadm.destroy();
    }

    public AdListener getAdListener() {
        return this.zzadm.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzadm.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzadm.getAdUnitId();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzadm.zza(adRequest.zzdt());
    }

    public void pause() {
        this.zzadm.pause();
    }

    public void resume() {
        this.zzadm.resume();
    }

    public boolean isLoading() {
        return this.zzadm.isLoading();
    }

    public void setAdListener(AdListener adListener) {
        this.zzadm.setAdListener(adListener);
        if (adListener == null) {
            this.zzadm.zza((zzve) null);
            this.zzadm.zza((AppEventListener) null);
            return;
        }
        if (adListener instanceof zzve) {
            this.zzadm.zza((zzve) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzadm.zza((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzadm.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzadm.setAdUnitId(str);
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        return this.zzadm.getMediationAdapterClassName();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    public void onMeasure(int i, int i2) {
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

    public ResponseInfo getResponseInfo() {
        return this.zzadm.getResponseInfo();
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzadm.setOnPaidEventListener(onPaidEventListener);
    }
}
