package com.didi.global.loading.render;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import java.util.ArrayList;
import java.util.Iterator;

public class LottieLoadingRender extends BaseLoadingRender {
    public static final String kAnimatorAssetFileName = "Loading::Animation::Lottie::Asset::File::Name";
    public static final String kAnimatorAssetImagesPath = "Loading::Animation::Lottie::Asset::Images::Path";
    public static final String kAnimatorLoopRanges = "Loading::Animation::Lottie::LoopRanges";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LottieAnimationView f22676b;

    /* renamed from: c */
    private int f22677c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f22678d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f22679e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<LoopRange> f22680f;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16331a(ArrayList<LoopRange> arrayList) {
        LoopRange loopRange = null;
        if (arrayList != null) {
            Iterator<LoopRange> it = arrayList.iterator();
            while (it.hasNext()) {
                LoopRange next = it.next();
                if (next.loopIndex != null && next.loopIndex[0] <= this.f22677c && next.loopIndex[1] >= this.f22677c) {
                    loopRange = next;
                }
            }
        }
        if (loopRange != null) {
            this.f22676b.setMinAndMaxFrame(Math.max(loopRange.minFrame, this.f22679e), Math.min(loopRange.maxFrame, this.f22678d));
        } else if (!(this.f22676b.getMinFrame() == ((float) this.f22679e) && this.f22676b.getMaxFrame() == ((float) this.f22678d))) {
            this.f22676b.setMinAndMaxFrame(this.f22679e, this.f22678d);
        }
        this.f22677c++;
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.f22676b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder(bundle.getString("Loading::Animation::Lottie::Asset::Images::Path", ""));
        this.f22676b.setRepeatCount(-1);
        this.f22676b.setRepeatMode(1);
        this.f22676b.setBackgroundColor(bundle.getInt("Loading::Background::Color", -1));
        String string = bundle.getString("Loading::Animation::Lottie::Asset::File::Name", (String) null);
        if (string != null) {
            this.f22676b.setAnimation(string);
            this.f22676b.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
                public void onCompositionLoaded(LottieComposition lottieComposition) {
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    int unused = lottieLoadingRender.f22679e = (int) lottieLoadingRender.f22676b.getMinFrame();
                    LottieLoadingRender lottieLoadingRender2 = LottieLoadingRender.this;
                    int unused2 = lottieLoadingRender2.f22678d = (int) lottieLoadingRender2.f22676b.getMaxFrame();
                }
            });
        }
        this.f22680f = bundle.getParcelableArrayList("Loading::Animation::Lottie::LoopRanges");
        return this.f22676b;
    }

    public Rect getBorder() {
        if (this.f22676b.getComposition() != null) {
            return this.f22676b.getComposition().getBounds();
        }
        return super.getBorder();
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        ArrayList<LoopRange> arrayList = this.f22680f;
        if (arrayList != null) {
            this.f22677c = 0;
            m16331a(arrayList);
            this.f22676b.addAnimatorListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    lottieLoadingRender.m16331a((ArrayList<LoopRange>) lottieLoadingRender.f22680f);
                }
            });
        }
        this.f22676b.playAnimation();
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f22676b.setMinAndMaxFrame(this.f22679e, this.f22678d);
        this.f22676b.removeAllAnimatorListeners();
        this.f22676b.cancelAnimation();
    }

    public boolean isRunning() {
        return this.f22676b.isAnimating();
    }

    public static class LoopRange implements Parcelable {
        public final Parcelable.Creator<LoopRange> CREATOR = new Parcelable.Creator<LoopRange>() {
            public LoopRange createFromParcel(Parcel parcel) {
                return new LoopRange(parcel);
            }

            public LoopRange[] newArray(int i) {
                return new LoopRange[i];
            }
        };
        int[] loopIndex;
        int maxFrame = 0;
        int minFrame = 0;

        public int describeContents() {
            return 0;
        }

        public LoopRange(int i, int i2, int[] iArr) {
            this.minFrame = i;
            this.maxFrame = i2;
            this.loopIndex = iArr;
        }

        public LoopRange(Parcel parcel) {
            this.minFrame = parcel.readInt();
            this.maxFrame = parcel.readInt();
            this.loopIndex = parcel.createIntArray();
        }

        /* access modifiers changed from: package-private */
        public LoopRange setLoopRange(int[] iArr, int i, int i2) {
            this.loopIndex = iArr;
            this.minFrame = i;
            this.maxFrame = i2;
            return this;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.minFrame);
            parcel.writeInt(this.maxFrame);
            parcel.writeIntArray(this.loopIndex);
        }
    }
}
