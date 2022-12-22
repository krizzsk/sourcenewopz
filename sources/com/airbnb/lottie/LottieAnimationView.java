package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: a */
    private static final String f1101a = LottieAnimationView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LottieListener<Throwable> f1102b = new LottieListener<Throwable>() {
        public void onResult(Throwable th) {
            if (Utils.isNetworkException(th)) {
                Logger.warning("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };

    /* renamed from: c */
    private final LottieListener<LottieComposition> f1103c = new LottieListener<LottieComposition>() {
        public void onResult(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    };

    /* renamed from: d */
    private final LottieListener<Throwable> f1104d = new LottieListener<Throwable>() {
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f1106f != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f1106f);
            }
            (LottieAnimationView.this.f1105e == null ? LottieAnimationView.f1102b : LottieAnimationView.this.f1105e).onResult(th);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LottieListener<Throwable> f1105e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f1106f = 0;

    /* renamed from: g */
    private final LottieDrawable f1107g = new LottieDrawable();

    /* renamed from: h */
    private boolean f1108h;

    /* renamed from: i */
    private String f1109i;

    /* renamed from: j */
    private int f1110j;

    /* renamed from: k */
    private boolean f1111k = false;

    /* renamed from: l */
    private boolean f1112l = false;

    /* renamed from: m */
    private boolean f1113m = false;

    /* renamed from: n */
    private boolean f1114n = false;

    /* renamed from: o */
    private boolean f1115o = true;

    /* renamed from: p */
    private RenderMode f1116p = RenderMode.AUTOMATIC;

    /* renamed from: q */
    private Set<LottieOnCompositionLoadedListener> f1117q = new HashSet();

    /* renamed from: r */
    private int f1118r = 0;

    /* renamed from: s */
    private LottieTask<LottieComposition> f1119s;

    /* renamed from: t */
    private LottieComposition f1120t;

    public LottieAnimationView(Context context) {
        super(context);
        m1222a((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1222a(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1222a(attributeSet, i);
    }

    /* renamed from: a */
    private void m1222a(AttributeSet attributeSet, int i) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.LottieAnimationView, i, 0);
        if (!isInEditMode()) {
            this.f1115o = obtainStyledAttributes.getBoolean(1, true);
            boolean hasValue = obtainStyledAttributes.hasValue(9);
            boolean hasValue2 = obtainStyledAttributes.hasValue(5);
            boolean hasValue3 = obtainStyledAttributes.hasValue(15);
            if (!hasValue || !hasValue2) {
                if (hasValue) {
                    int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                    if (resourceId != 0) {
                        setAnimation(resourceId);
                    }
                } else if (hasValue2) {
                    String string2 = obtainStyledAttributes.getString(5);
                    if (string2 != null) {
                        setAnimation(string2);
                    }
                } else if (hasValue3 && (string = obtainStyledAttributes.getString(15)) != null) {
                    setAnimationFromUrl(string);
                }
                setFallbackResource(obtainStyledAttributes.getResourceId(4, 0));
            } else {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
        }
        if (obtainStyledAttributes.getBoolean(0, false)) {
            this.f1113m = true;
            this.f1114n = true;
        }
        if (obtainStyledAttributes.getBoolean(7, false)) {
            this.f1107g.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(12)) {
            setRepeatMode(obtainStyledAttributes.getInt(12, 1));
        }
        if (obtainStyledAttributes.hasValue(11)) {
            setRepeatCount(obtainStyledAttributes.getInt(11, -1));
        }
        if (obtainStyledAttributes.hasValue(14)) {
            setSpeed(obtainStyledAttributes.getFloat(14, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(6));
        setProgress(obtainStyledAttributes.getFloat(8, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(3, false));
        if (obtainStyledAttributes.hasValue(2)) {
            SimpleColorFilter simpleColorFilter = new SimpleColorFilter(obtainStyledAttributes.getColor(2, 0));
            addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback(simpleColorFilter));
        }
        if (obtainStyledAttributes.hasValue(13)) {
            this.f1107g.setScale(obtainStyledAttributes.getFloat(13, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(10)) {
            int i2 = obtainStyledAttributes.getInt(10, RenderMode.AUTOMATIC.ordinal());
            if (i2 >= RenderMode.values().length) {
                i2 = RenderMode.AUTOMATIC.ordinal();
            }
            setRenderMode(RenderMode.values()[i2]);
        }
        if (getScaleType() != null) {
            this.f1107g.mo15079a(getScaleType());
        }
        obtainStyledAttributes.recycle();
        LottieDrawable lottieDrawable = this.f1107g;
        if (Utils.getAnimationScale(getContext()) != 0.0f) {
            z = true;
        }
        lottieDrawable.mo15080a(Boolean.valueOf(z));
        m1226d();
        this.f1108h = true;
    }

    public void setImageResource(int i) {
        m1224b();
        super.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        m1224b();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        m1224b();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f1107g;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.f1109i;
        savedState.animationResId = this.f1110j;
        savedState.progress = this.f1107g.getProgress();
        savedState.isAnimating = this.f1107g.isAnimating() || (!ViewCompat.isAttachedToWindow(this) && this.f1113m);
        savedState.imageAssetsFolder = this.f1107g.getImageAssetsFolder();
        savedState.repeatMode = this.f1107g.getRepeatMode();
        savedState.repeatCount = this.f1107g.getRepeatCount();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.animationName;
        this.f1109i = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f1109i);
        }
        int i = savedState.animationResId;
        this.f1110j = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.f1107g.setImagesAssetsFolder(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        if (this.f1108h) {
            if (isShown()) {
                if (this.f1112l) {
                    resumeAnimation();
                } else if (this.f1111k) {
                    playAnimation();
                }
                this.f1112l = false;
                this.f1111k = false;
            } else if (isAnimating()) {
                pauseAnimation();
                this.f1112l = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1114n || this.f1113m) {
            playAnimation();
            this.f1114n = false;
            this.f1113m = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.f1113m = true;
        }
        super.onDetachedFromWindow();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.f1107g.enableMergePathsForKitKatAndAbove(z);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.f1107g.isMergePathsEnabledForKitKatAndAbove();
    }

    public void setCacheComposition(boolean z) {
        this.f1115o = z;
    }

    public void setAnimation(int i) {
        this.f1110j = i;
        this.f1109i = null;
        setCompositionTask(this.f1115o ? LottieCompositionFactory.fromRawRes(getContext(), i) : LottieCompositionFactory.fromRawRes(getContext(), i, (String) null));
    }

    public void setAnimation(String str) {
        this.f1109i = str;
        this.f1110j = 0;
        setCompositionTask(this.f1115o ? LottieCompositionFactory.fromAsset(getContext(), str) : LottieCompositionFactory.fromAsset(getContext(), str, (String) null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, (String) null);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f1115o ? LottieCompositionFactory.fromUrl(getContext(), str) : LottieCompositionFactory.fromUrl(getContext(), str, (String) null));
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str, str2));
    }

    public void setFailureListener(LottieListener<Throwable> lottieListener) {
        this.f1105e = lottieListener;
    }

    public void setFallbackResource(int i) {
        this.f1106f = i;
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        m1225c();
        m1224b();
        this.f1119s = lottieTask.addListener(this.f1103c).addFailureListener(this.f1104d);
    }

    /* renamed from: b */
    private void m1224b() {
        LottieTask<LottieComposition> lottieTask = this.f1119s;
        if (lottieTask != null) {
            lottieTask.removeListener(this.f1103c);
            this.f1119s.removeFailureListener(this.f1104d);
        }
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (C1429L.DBG) {
            String str = f1101a;
            SystemUtils.log(2, str, "Set Composition \n" + lottieComposition, (Throwable) null, "com.airbnb.lottie.LottieAnimationView", 499);
        }
        this.f1107g.setCallback(this);
        this.f1120t = lottieComposition;
        boolean composition = this.f1107g.setComposition(lottieComposition);
        m1226d();
        if (getDrawable() != this.f1107g || composition) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (LottieOnCompositionLoadedListener onCompositionLoaded : this.f1117q) {
                onCompositionLoaded.onCompositionLoaded(lottieComposition);
            }
        }
    }

    public LottieComposition getComposition() {
        return this.f1120t;
    }

    public boolean hasMasks() {
        return this.f1107g.hasMasks();
    }

    public boolean hasMatte() {
        return this.f1107g.hasMatte();
    }

    public void playAnimation() {
        if (isShown()) {
            this.f1107g.playAnimation();
            m1226d();
            return;
        }
        this.f1111k = true;
    }

    public void resumeAnimation() {
        if (isShown()) {
            this.f1107g.resumeAnimation();
            m1226d();
            return;
        }
        this.f1111k = false;
        this.f1112l = true;
    }

    public void setMinFrame(int i) {
        this.f1107g.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.f1107g.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.f1107g.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.f1107g.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.f1107g.getMaxFrame();
    }

    public void setMaxProgress(float f) {
        this.f1107g.setMaxProgress(f);
    }

    public void setMinFrame(String str) {
        this.f1107g.setMinFrame(str);
    }

    public void setMaxFrame(String str) {
        this.f1107g.setMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.f1107g.setMinAndMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.f1107g.setMinAndMaxFrame(str, str2, z);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.f1107g.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.f1107g.setMinAndMaxProgress(f, f2);
    }

    public void reverseAnimationSpeed() {
        this.f1107g.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.f1107g.setSpeed(f);
    }

    public float getSpeed() {
        return this.f1107g.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1107g.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1107g.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.f1107g.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1107g.addAnimatorListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1107g.removeAnimatorListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.f1107g.removeAllAnimatorListeners();
    }

    @Deprecated
    public void loop(boolean z) {
        this.f1107g.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.f1107g.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.f1107g.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.f1107g.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.f1107g.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.f1107g.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.f1107g.setImagesAssetsFolder(str);
    }

    public String getImageAssetsFolder() {
        return this.f1107g.getImageAssetsFolder();
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        return this.f1107g.updateBitmap(str, bitmap);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f1107g.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f1107g.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.f1107g.setTextDelegate(textDelegate);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.f1107g.resolveKeyPath(keyPath);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.f1107g.addValueCallback(keyPath, t, lottieValueCallback);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.f1107g.addValueCallback(keyPath, t, new LottieValueCallback<T>() {
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setScale(float f) {
        this.f1107g.setScale(f);
        if (getDrawable() == this.f1107g) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.f1107g);
        }
    }

    public float getScale() {
        return this.f1107g.getScale();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        LottieDrawable lottieDrawable = this.f1107g;
        if (lottieDrawable != null) {
            lottieDrawable.mo15079a(scaleType);
        }
    }

    public void cancelAnimation() {
        this.f1113m = false;
        this.f1112l = false;
        this.f1111k = false;
        this.f1107g.cancelAnimation();
        m1226d();
    }

    public void pauseAnimation() {
        this.f1114n = false;
        this.f1113m = false;
        this.f1112l = false;
        this.f1111k = false;
        this.f1107g.pauseAnimation();
        m1226d();
    }

    public void setFrame(int i) {
        this.f1107g.setFrame(i);
    }

    public int getFrame() {
        return this.f1107g.getFrame();
    }

    public void setProgress(float f) {
        this.f1107g.setProgress(f);
    }

    public float getProgress() {
        return this.f1107g.getProgress();
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.f1120t;
        if (lottieComposition != null) {
            return (long) lottieComposition.getDuration();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f1107g.setPerformanceTrackingEnabled(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.f1107g.getPerformanceTracker();
    }

    /* renamed from: c */
    private void m1225c() {
        this.f1120t = null;
        this.f1107g.clearComposition();
    }

    public void setSafeMode(boolean z) {
        this.f1107g.setSafeMode(z);
    }

    public void buildDrawingCache(boolean z) {
        C1429L.beginSection("buildDrawingCache");
        this.f1118r++;
        super.buildDrawingCache(z);
        if (this.f1118r == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.f1118r--;
        C1429L.endSection("buildDrawingCache");
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f1116p = renderMode;
        m1226d();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f1107g.setApplyingOpacityToLayersEnabled(z);
    }

    public void disableExtraScaleModeInFitXY() {
        this.f1107g.disableExtraScaleModeInFitXY();
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$5 */
    static /* synthetic */ class C14345 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.RenderMode[] r0 = com.airbnb.lottie.RenderMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$RenderMode = r0
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.HARDWARE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$airbnb$lottie$RenderMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.SOFTWARE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$airbnb$lottie$RenderMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.C14345.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        if (r3 != false) goto L_0x003d;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1226d() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.C14345.$SwitchMap$com$airbnb$lottie$RenderMode
            com.airbnb.lottie.RenderMode r1 = r5.f1116p
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x003d
            if (r0 == r1) goto L_0x0013
            r3 = 3
            if (r0 == r3) goto L_0x0015
        L_0x0013:
            r1 = 1
            goto L_0x003d
        L_0x0015:
            com.airbnb.lottie.LottieComposition r0 = r5.f1120t
            r3 = 0
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.hasDashPattern()
            if (r0 == 0) goto L_0x0027
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L_0x0027
            goto L_0x003b
        L_0x0027:
            com.airbnb.lottie.LottieComposition r0 = r5.f1120t
            if (r0 == 0) goto L_0x0033
            int r0 = r0.getMaskAndMatteCount()
            r4 = 4
            if (r0 <= r4) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r3 = 1
        L_0x003b:
            if (r3 == 0) goto L_0x0013
        L_0x003d:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L_0x0047
            r0 = 0
            r5.setLayerType(r1, r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.m1226d():void");
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.f1120t;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.f1117q.add(lottieOnCompositionLoadedListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.f1117q.remove(lottieOnCompositionLoadedListener);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.f1117q.clear();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() != 1 ? false : true;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }
}
