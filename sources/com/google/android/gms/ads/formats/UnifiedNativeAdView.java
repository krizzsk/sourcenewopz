package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaab;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaej;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzaew;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzww;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzboi;
    private final zzaew zzboj = zzjy();

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzboi = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzboi = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzboi = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzboi = zzd(context);
    }

    private final void zza(String str, View view) {
        try {
            this.zzboj.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbao.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zza("3001", view);
    }

    public final void setCallToActionView(View view) {
        zza("3002", view);
    }

    public final void setIconView(View view) {
        zza("3003", view);
    }

    public final void setBodyView(View view) {
        zza("3004", view);
    }

    public final void setAdvertiserView(View view) {
        zza("3005", view);
    }

    public final void setStoreView(View view) {
        zza("3006", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzboj.zzf(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbao.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zza("3007", view);
    }

    public final void setImageView(View view) {
        zza("3008", view);
    }

    public final void setStarRatingView(View view) {
        zza("3009", view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza("3010", mediaView);
        if (mediaView != null) {
            mediaView.zza((zzaeh) new zzf(this));
            mediaView.zza((zzaej) new zzg(this));
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza("3011", adChoicesView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzboj.zza((IObjectWrapper) unifiedNativeAd.zzjw());
        } catch (RemoteException e) {
            zzbao.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    private final View zzbj(String str) {
        try {
            IObjectWrapper zzco = this.zzboj.zzco(str);
            if (zzco != null) {
                return (View) ObjectWrapper.unwrap(zzco);
            }
            return null;
        } catch (RemoteException e) {
            zzbao.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public final View getHeadlineView() {
        return zzbj("3001");
    }

    public final View getCallToActionView() {
        return zzbj("3002");
    }

    public final View getIconView() {
        return zzbj("3003");
    }

    public final View getBodyView() {
        return zzbj("3004");
    }

    public final View getStoreView() {
        return zzbj("3006");
    }

    public final View getPriceView() {
        return zzbj("3007");
    }

    public final View getAdvertiserView() {
        return zzbj("3005");
    }

    public final View getImageView() {
        return zzbj("3008");
    }

    public final View getStarRatingView() {
        return zzbj("3009");
    }

    public final MediaView getMediaView() {
        View zzbj = zzbj("3010");
        if (zzbj instanceof MediaView) {
            return (MediaView) zzbj;
        }
        if (zzbj == null) {
            return null;
        }
        zzbao.zzdz("View is not an instance of MediaView");
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbj = zzbj("3011");
        if (zzbj instanceof AdChoicesView) {
            return (AdChoicesView) zzbj;
        }
        return null;
    }

    public final void destroy() {
        try {
            this.zzboj.destroy();
        } catch (RemoteException e) {
            zzbao.zzc("Unable to destroy native ad view", e);
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaew zzjy() {
        Preconditions.checkNotNull(this.zzboi, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzww.zzqx().zza(this.zzboi.getContext(), (FrameLayout) this, this.zzboi);
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzboi);
    }

    public final void removeView(View view) {
        if (this.zzboi != view) {
            super.removeView(view);
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzboi);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzboi;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaew zzaew = this.zzboj;
        if (zzaew != null) {
            try {
                zzaew.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzaew zzaew;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcth)).booleanValue() && (zzaew = this.zzboj) != null) {
            try {
                zzaew.zzg(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.zzboj.zzh(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call setMediaViewImageScaleType on delegate", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzaab) {
                this.zzboj.zza(((zzaab) mediaContent).zzrz());
            } else if (mediaContent == null) {
                this.zzboj.zza((zzaer) null);
            } else {
                zzbao.zzdz("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzbao.zzc("Unable to call setMediaContent on delegate", e);
        }
    }
}
