package com.didi.entrega.customer.widget.loading.render;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
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
    public static final String K_ANIMATOR_ASSET_FILE_NAME = "Loading::Animation::Lottie::Asset::File::Name";
    public static final String K_ANIMATOR_ASSET_IMAGES_PATH = "Loading::Animation::Lottie::Asset::Images::Path";
    public static final String K_ANIMATOR_LOOP_RANGES = "Loading::Animation::Lottie::LoopRanges";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LottieAnimationView f20577b;

    /* renamed from: c */
    private int f20578c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f20579d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f20580e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<LoopRangeModel> f20581f;

    public boolean isRunning() {
        return this.f20577b.isAnimating();
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.f20577b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder(bundle.getString("Loading::Animation::Lottie::Asset::Images::Path", ""));
        this.f20577b.setRepeatCount(-1);
        this.f20577b.setRepeatMode(1);
        this.f20577b.setBackgroundColor(bundle.getInt("Loading::Background::Color", -1));
        String string = bundle.getString("Loading::Animation::Lottie::Asset::File::Name", (String) null);
        if (string != null) {
            this.f20577b.setAnimation(string);
            this.f20577b.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
                public void onCompositionLoaded(LottieComposition lottieComposition) {
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    int unused = lottieLoadingRender.f20580e = (int) lottieLoadingRender.f20577b.getMinFrame();
                    LottieLoadingRender lottieLoadingRender2 = LottieLoadingRender.this;
                    int unused2 = lottieLoadingRender2.f20579d = (int) lottieLoadingRender2.f20577b.getMaxFrame();
                }
            });
        }
        this.f20581f = bundle.getParcelableArrayList("Loading::Animation::Lottie::LoopRanges");
        return this.f20577b;
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        ArrayList<LoopRangeModel> arrayList = this.f20581f;
        if (arrayList != null) {
            this.f20578c = 0;
            m15054a(arrayList);
            this.f20577b.addAnimatorListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    lottieLoadingRender.m15054a((ArrayList<LoopRangeModel>) lottieLoadingRender.f20581f);
                }
            });
        }
        this.f20577b.playAnimation();
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f20577b.setMinAndMaxFrame(this.f20580e, this.f20579d);
        this.f20577b.removeAllAnimatorListeners();
        this.f20577b.cancelAnimation();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15054a(ArrayList<LoopRangeModel> arrayList) {
        LoopRangeModel loopRangeModel = null;
        if (arrayList != null) {
            Iterator<LoopRangeModel> it = arrayList.iterator();
            while (it.hasNext()) {
                LoopRangeModel next = it.next();
                if (next.mLoopIndex != null && next.mLoopIndex[0] <= this.f20578c && next.mLoopIndex[1] >= this.f20578c) {
                    loopRangeModel = next;
                }
            }
        }
        if (loopRangeModel != null) {
            this.f20577b.setMinAndMaxFrame(Math.max(loopRangeModel.mMinFrame, this.f20580e), Math.min(loopRangeModel.mMaxFrame, this.f20579d));
        } else if (!(this.f20577b.getMinFrame() == ((float) this.f20580e) && this.f20577b.getMaxFrame() == ((float) this.f20579d))) {
            this.f20577b.setMinAndMaxFrame(this.f20580e, this.f20579d);
        }
        this.f20578c++;
    }

    public static class LoopRangeModel implements Parcelable {
        public final Parcelable.Creator<LoopRangeModel> CREATOR = new Parcelable.Creator<LoopRangeModel>() {
            public LoopRangeModel createFromParcel(Parcel parcel) {
                return new LoopRangeModel(parcel);
            }

            public LoopRangeModel[] newArray(int i) {
                return new LoopRangeModel[i];
            }
        };
        int[] mLoopIndex;
        int mMaxFrame = 0;
        int mMinFrame = 0;

        public int describeContents() {
            return 0;
        }

        public LoopRangeModel(int i, int i2, int[] iArr) {
            this.mMinFrame = i;
            this.mMaxFrame = i2;
            this.mLoopIndex = iArr;
        }

        public LoopRangeModel(Parcel parcel) {
            this.mMinFrame = parcel.readInt();
            this.mMaxFrame = parcel.readInt();
            this.mLoopIndex = parcel.createIntArray();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mMinFrame);
            parcel.writeInt(this.mMaxFrame);
            parcel.writeIntArray(this.mLoopIndex);
        }

        /* access modifiers changed from: package-private */
        public LoopRangeModel setLoopRange(int[] iArr, int i, int i2) {
            this.mLoopIndex = iArr;
            this.mMinFrame = i;
            this.mMaxFrame = i2;
            return this;
        }
    }
}
