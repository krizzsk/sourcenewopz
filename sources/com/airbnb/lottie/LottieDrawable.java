package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieDrawable extends Drawable implements Animatable, Drawable.Callback {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    /* renamed from: c */
    private static final String f1137c = LottieDrawable.class.getSimpleName();

    /* renamed from: a */
    FontAssetDelegate f1138a;

    /* renamed from: b */
    TextDelegate f1139b;

    /* renamed from: d */
    private final Matrix f1140d = new Matrix();

    /* renamed from: e */
    private LottieComposition f1141e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final LottieValueAnimator f1142f = new LottieValueAnimator();

    /* renamed from: g */
    private float f1143g = 1.0f;

    /* renamed from: h */
    private boolean f1144h = true;

    /* renamed from: i */
    private boolean f1145i = false;

    /* renamed from: j */
    private final Set<ColorFilterData> f1146j = new HashSet();

    /* renamed from: k */
    private final ArrayList<LazyCompositionTask> f1147k = new ArrayList<>();

    /* renamed from: l */
    private final ValueAnimator.AnimatorUpdateListener f1148l;

    /* renamed from: m */
    private ImageView.ScaleType f1149m;

    /* renamed from: n */
    private ImageAssetManager f1150n;

    /* renamed from: o */
    private String f1151o;

    /* renamed from: p */
    private ImageAssetDelegate f1152p;

    /* renamed from: q */
    private FontAssetManager f1153q;

    /* renamed from: r */
    private boolean f1154r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public CompositionLayer f1155s;

    /* renamed from: t */
    private int f1156t;

    /* renamed from: u */
    private boolean f1157u;

    /* renamed from: v */
    private boolean f1158v;

    /* renamed from: w */
    private boolean f1159w;

    /* renamed from: x */
    private boolean f1160x;

    private interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public int getOpacity() {
        return -3;
    }

    public LottieDrawable() {
        C14481 r2 = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.f1155s != null) {
                    LottieDrawable.this.f1155s.setProgress(LottieDrawable.this.f1142f.getAnimatedValueAbsolute());
                }
            }
        };
        this.f1148l = r2;
        this.f1156t = 255;
        this.f1159w = true;
        this.f1160x = false;
        this.f1142f.addUpdateListener(r2);
    }

    public boolean hasMasks() {
        CompositionLayer compositionLayer = this.f1155s;
        return compositionLayer != null && compositionLayer.hasMasks();
    }

    public boolean hasMatte() {
        CompositionLayer compositionLayer = this.f1155s;
        return compositionLayer != null && compositionLayer.hasMatte();
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.f1154r;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.f1154r != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Logger.warning("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.f1154r = z;
            if (this.f1141e != null) {
                m1236a();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.f1154r;
    }

    public void setImagesAssetsFolder(String str) {
        this.f1151o = str;
    }

    public String getImageAssetsFolder() {
        return this.f1151o;
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.f1141e == lottieComposition) {
            return false;
        }
        this.f1160x = false;
        clearComposition();
        this.f1141e = lottieComposition;
        m1236a();
        this.f1142f.setComposition(lottieComposition);
        setProgress(this.f1142f.getAnimatedFraction());
        setScale(this.f1143g);
        m1240b();
        Iterator it = new ArrayList(this.f1147k).iterator();
        while (it.hasNext()) {
            ((LazyCompositionTask) it.next()).run(lottieComposition);
            it.remove();
        }
        this.f1147k.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.f1157u);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable((Drawable) null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f1157u = z;
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z);
        }
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f1158v = z;
    }

    public void disableExtraScaleModeInFitXY() {
        this.f1159w = false;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.f1158v;
    }

    /* renamed from: a */
    private void m1236a() {
        this.f1155s = new CompositionLayer(this, LayerParser.parse(this.f1141e), this.f1141e.getLayers(), this.f1141e);
    }

    public void clearComposition() {
        if (this.f1142f.isRunning()) {
            this.f1142f.cancel();
        }
        this.f1141e = null;
        this.f1155s = null;
        this.f1150n = null;
        this.f1142f.clearComposition();
        invalidateSelf();
    }

    public void setSafeMode(boolean z) {
        this.f1145i = z;
    }

    public void invalidateSelf() {
        if (!this.f1160x) {
            this.f1160x = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public void setAlpha(int i) {
        this.f1156t = i;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f1156t;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public void draw(Canvas canvas) {
        this.f1160x = false;
        C1429L.beginSection("Drawable#draw");
        if (this.f1145i) {
            try {
                m1237a(canvas);
            } catch (Throwable th) {
                Logger.error("Lottie crashed in draw!", th);
            }
        } else {
            m1237a(canvas);
        }
        C1429L.endSection("Drawable#draw");
    }

    /* renamed from: a */
    private void m1237a(Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f1149m) {
            m1242c(canvas);
        } else {
            m1244d(canvas);
        }
    }

    public void start() {
        playAnimation();
    }

    public void stop() {
        endAnimation();
    }

    public boolean isRunning() {
        return isAnimating();
    }

    public void playAnimation() {
        if (this.f1155s == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.playAnimation();
                }
            });
            return;
        }
        if (this.f1144h || getRepeatCount() == 0) {
            this.f1142f.playAnimation();
        }
        if (!this.f1144h) {
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.f1142f.endAnimation();
        }
    }

    public void endAnimation() {
        this.f1147k.clear();
        this.f1142f.endAnimation();
    }

    public void resumeAnimation() {
        if (this.f1155s == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.resumeAnimation();
                }
            });
            return;
        }
        if (this.f1144h || getRepeatCount() == 0) {
            this.f1142f.resumeAnimation();
        }
        if (!this.f1144h) {
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.f1142f.endAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.f1141e == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinFrame(i);
                }
            });
        } else {
            this.f1142f.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.f1142f.getMinFrame();
    }

    public void setMinProgress(final float f) {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.f1141e.getEndFrame(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.f1141e == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxFrame(i);
                }
            });
        } else {
            this.f1142f.setMaxFrame(((float) i) + 0.99f);
        }
    }

    public float getMaxFrame() {
        return this.f1142f.getMaxFrame();
    }

    public void setMaxProgress(final float f) {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.f1141e.getEndFrame(), f));
        }
    }

    public void setMinFrame(final String str) {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.startFrame);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMaxFrame(final String str) {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.startFrame + marker.durationFrames));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxFrame(final String str) {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i = (int) marker.startFrame;
            setMinAndMaxFrame(i, ((int) marker.durationFrames) + i);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxFrame(final String str, final String str2, final boolean z) {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxFrame(str, str2, z);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i = (int) marker.startFrame;
            Marker marker2 = this.f1141e.getMarker(str2);
            if (str2 != null) {
                setMinAndMaxFrame(i, (int) (marker2.startFrame + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.f1141e == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.f1142f.setMinAndMaxFrames((float) i, ((float) i2) + 0.99f);
        }
    }

    public void setMinAndMaxProgress(final float f, final float f2) {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.f1141e.getEndFrame(), f), (int) MiscUtils.lerp(this.f1141e.getStartFrame(), this.f1141e.getEndFrame(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.f1142f.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.f1142f.setSpeed(f);
    }

    public float getSpeed() {
        return this.f1142f.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1142f.addUpdateListener(animatorUpdateListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1142f.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.f1142f.removeAllUpdateListeners();
        this.f1142f.addUpdateListener(this.f1148l);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1142f.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1142f.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.f1142f.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.f1141e == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setFrame(i);
                }
            });
        } else {
            this.f1142f.setFrame((float) i);
        }
    }

    public int getFrame() {
        return (int) this.f1142f.getFrame();
    }

    public void setProgress(final float f) {
        if (this.f1141e == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setProgress(f);
                }
            });
            return;
        }
        C1429L.beginSection("Drawable#setProgress");
        this.f1142f.setFrame(MiscUtils.lerp(this.f1141e.getStartFrame(), this.f1141e.getEndFrame(), f));
        C1429L.endSection("Drawable#setProgress");
    }

    @Deprecated
    public void loop(boolean z) {
        this.f1142f.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.f1142f.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.f1142f.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.f1142f.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.f1142f.getRepeatCount();
    }

    public boolean isLooping() {
        return this.f1142f.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.f1142f;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15080a(Boolean bool) {
        this.f1144h = bool.booleanValue();
    }

    public void setScale(float f) {
        this.f1143g = f;
        m1240b();
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f1152p = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.f1150n;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f1138a = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.f1153q;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.f1139b = textDelegate;
    }

    public TextDelegate getTextDelegate() {
        return this.f1139b;
    }

    public boolean useTextGlyphs() {
        return this.f1139b == null && this.f1141e.getCharacters().size() > 0;
    }

    public float getScale() {
        return this.f1143g;
    }

    public LottieComposition getComposition() {
        return this.f1141e;
    }

    /* renamed from: b */
    private void m1240b() {
        if (this.f1141e != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (((float) this.f1141e.getBounds().width()) * scale), (int) (((float) this.f1141e.getBounds().height()) * scale));
        }
    }

    public void cancelAnimation() {
        this.f1147k.clear();
        this.f1142f.cancel();
    }

    public void pauseAnimation() {
        this.f1147k.clear();
        this.f1142f.pauseAnimation();
    }

    public float getProgress() {
        return this.f1142f.getAnimatedValueAbsolute();
    }

    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (((float) lottieComposition.getBounds().width()) * getScale());
    }

    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.f1141e;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (((float) lottieComposition.getBounds().height()) * getScale());
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.f1155s == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f1155s.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final KeyPath keyPath, final T t, final LottieValueCallback<T> lottieValueCallback) {
        if (this.f1155s == null) {
            this.f1147k.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.addValueCallback(keyPath, t, lottieValueCallback);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath == KeyPath.COMPOSITION) {
            this.f1155s.addValueCallback(t, lottieValueCallback);
        } else if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t, lottieValueCallback);
        } else {
            List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).getResolvedElement().addValueCallback(t, lottieValueCallback);
            }
            z = true ^ resolveKeyPath.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(keyPath, t, new LottieValueCallback<T>() {
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        ImageAssetManager c = m1241c();
        if (c == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = c.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    public Bitmap getImageAsset(String str) {
        ImageAssetManager c = m1241c();
        if (c != null) {
            return c.bitmapForId(str);
        }
        return null;
    }

    /* renamed from: c */
    private ImageAssetManager m1241c() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.f1150n;
        if (imageAssetManager != null && !imageAssetManager.hasSameContext(m1245e())) {
            this.f1150n = null;
        }
        if (this.f1150n == null) {
            this.f1150n = new ImageAssetManager(getCallback(), this.f1151o, this.f1152p, this.f1141e.getImages());
        }
        return this.f1150n;
    }

    public Typeface getTypeface(String str, String str2) {
        FontAssetManager d = m1243d();
        if (d != null) {
            return d.getTypeface(str, str2);
        }
        return null;
    }

    /* renamed from: d */
    private FontAssetManager m1243d() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f1153q == null) {
            this.f1153q = new FontAssetManager(getCallback(), this.f1138a);
        }
        return this.f1153q;
    }

    /* renamed from: e */
    private Context m1245e() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15079a(ImageView.ScaleType scaleType) {
        this.f1149m = scaleType;
    }

    /* renamed from: b */
    private float m1238b(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f1141e.getBounds().width()), ((float) canvas.getHeight()) / ((float) this.f1141e.getBounds().height()));
    }

    /* renamed from: c */
    private void m1242c(Canvas canvas) {
        float f;
        if (this.f1155s != null) {
            int i = -1;
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) this.f1141e.getBounds().width());
            float height = ((float) bounds.height()) / ((float) this.f1141e.getBounds().height());
            if (this.f1159w) {
                float min = Math.min(width, height);
                if (min < 1.0f) {
                    f = 1.0f / min;
                    width /= f;
                    height /= f;
                } else {
                    f = 1.0f;
                }
                if (f > 1.0f) {
                    i = canvas.save();
                    float width2 = ((float) bounds.width()) / 2.0f;
                    float height2 = ((float) bounds.height()) / 2.0f;
                    float f2 = width2 * min;
                    float f3 = min * height2;
                    canvas.translate(width2 - f2, height2 - f3);
                    canvas.scale(f, f, f2, f3);
                }
            }
            this.f1140d.reset();
            this.f1140d.preScale(width, height);
            this.f1155s.draw(canvas, this.f1140d, this.f1156t);
            if (i > 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    /* renamed from: d */
    private void m1244d(Canvas canvas) {
        float f;
        if (this.f1155s != null) {
            float f2 = this.f1143g;
            float b = m1238b(canvas);
            if (f2 > b) {
                f = this.f1143g / b;
            } else {
                b = f2;
                f = 1.0f;
            }
            int i = -1;
            if (f > 1.0f) {
                i = canvas.save();
                float width = ((float) this.f1141e.getBounds().width()) / 2.0f;
                float height = ((float) this.f1141e.getBounds().height()) / 2.0f;
                float f3 = width * b;
                float f4 = height * b;
                canvas.translate((getScale() * width) - f3, (getScale() * height) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.f1140d.reset();
            this.f1140d.preScale(b, b);
            this.f1155s.draw(canvas, this.f1140d, this.f1156t);
            if (i > 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private static class ColorFilterData {
        final ColorFilter colorFilter;
        final String contentName;
        final String layerName;

        ColorFilterData(String str, String str2, ColorFilter colorFilter2) {
            this.layerName = str;
            this.contentName = str2;
            this.colorFilter = colorFilter2;
        }

        public int hashCode() {
            String str = this.layerName;
            int hashCode = str != null ? 527 * str.hashCode() : 17;
            String str2 = this.contentName;
            return str2 != null ? hashCode * 31 * str2.hashCode() : hashCode;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ColorFilterData)) {
                return false;
            }
            ColorFilterData colorFilterData = (ColorFilterData) obj;
            if (hashCode() == colorFilterData.hashCode() && this.colorFilter == colorFilterData.colorFilter) {
                return true;
            }
            return false;
        }
    }
}
