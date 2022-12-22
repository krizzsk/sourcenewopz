package com.didi.flutter.nacho.p114ui.blur;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.didi.flutter.nacho.p114ui.SnapshotFetcher;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.flutter.nacho.ui.blur.BlurDialogEngine */
public class BlurDialogEngine {

    /* renamed from: a */
    static final float f21115a = 4.0f;

    /* renamed from: b */
    static final int f21116b = 8;

    /* renamed from: c */
    static final boolean f21117c = false;

    /* renamed from: d */
    static final boolean f21118d = false;

    /* renamed from: e */
    static final boolean f21119e = false;

    /* renamed from: f */
    static final boolean f21120f = false;

    /* renamed from: g */
    private static final String f21121g = BlurDialogEngine.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f21122h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout.LayoutParams f21123i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BlurAsyncTask f21124j;

    /* renamed from: k */
    private boolean f21125k = false;

    /* renamed from: l */
    private float f21126l = 4.0f;

    /* renamed from: m */
    private int f21127m = 8;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Activity f21128n;

    /* renamed from: o */
    private Toolbar f21129o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f21130p;

    /* renamed from: q */
    private boolean f21131q;

    /* renamed from: r */
    private boolean f21132r;

    public BlurDialogEngine(Activity activity) {
        this.f21128n = activity;
        this.f21130p = activity.getResources().getInteger(R.integer.blur_dialog_animation_duration);
    }

    public void onAttach(Activity activity) {
        this.f21128n = activity;
    }

    public void onResume(boolean z) {
        if (this.f21122h != null && !z) {
            return;
        }
        if (this.f21128n.getWindow().getDecorView().isShown()) {
            BlurAsyncTask blurAsyncTask = new BlurAsyncTask();
            this.f21124j = blurAsyncTask;
            blurAsyncTask.execute(new Void[0]);
            return;
        }
        this.f21128n.getWindow().getDecorView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (BlurDialogEngine.this.f21128n == null) {
                    return true;
                }
                BlurDialogEngine.this.f21128n.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
                BlurAsyncTask unused = BlurDialogEngine.this.f21124j = new BlurAsyncTask();
                BlurDialogEngine.this.f21124j.execute(new Void[0]);
                return true;
            }
        });
    }

    public void onDismiss() {
        BlurAsyncTask blurAsyncTask = this.f21124j;
        if (blurAsyncTask != null) {
            blurAsyncTask.cancel(true);
        }
        if (this.f21122h == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            this.f21122h.animate().alpha(0.0f).setDuration((long) this.f21130p).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    BlurDialogEngine.this.m15554e();
                }

                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    BlurDialogEngine.this.m15554e();
                }
            }).start();
        } else {
            m15554e();
        }
    }

    public void onDetach() {
        BlurAsyncTask blurAsyncTask = this.f21124j;
        if (blurAsyncTask != null) {
            blurAsyncTask.cancel(true);
        }
        this.f21124j = null;
        this.f21128n = null;
    }

    public void debug(boolean z) {
        this.f21125k = z;
    }

    public void setDownScaleFactor(float f) {
        if (f >= 1.0f) {
            this.f21126l = f;
        } else {
            this.f21126l = 1.0f;
        }
    }

    public void setBlurRadius(int i) {
        if (i >= 0) {
            this.f21127m = i;
        } else {
            this.f21127m = 0;
        }
    }

    public void setUseRenderScript(boolean z) {
        this.f21132r = z;
    }

    public void setBlurActionBar(boolean z) {
        this.f21131q = z;
    }

    public void setToolbar(Toolbar toolbar) {
        this.f21129o = toolbar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15545a(Bitmap bitmap, View view) {
        int i;
        int i2;
        Bitmap bitmap2;
        Bitmap bitmap3;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        this.f21123i = new FrameLayout.LayoutParams(-1, -1);
        if (this.f21131q) {
            i = 0;
        } else {
            i = m15542a();
        }
        int b = (this.f21128n.getWindow().getAttributes().flags & 1024) == 0 ? m15547b() : 0;
        if (Build.VERSION.SDK_INT >= 19 && m15552d()) {
            b = 0;
        }
        int i3 = b + i;
        int c = m15549c();
        if (this.f21128n.getResources().getBoolean(R.bool.blur_dialog_has_bottom_navigation_bar)) {
            i2 = c;
            c = 0;
        } else {
            i2 = 0;
        }
        Rect rect = new Rect(0, i3, bitmap.getWidth() - c, bitmap.getHeight() - i2);
        double ceil = Math.ceil((double) (((float) ((view.getHeight() - i3) - i2)) / this.f21126l));
        double ceil2 = Math.ceil((((double) (view.getWidth() - c)) * ceil) / ((double) ((view.getHeight() - i3) - i2)));
        if (this.f21132r) {
            bitmap2 = Bitmap.createBitmap((int) ceil2, (int) ceil, Bitmap.Config.ARGB_8888);
        } else {
            bitmap2 = Bitmap.createBitmap((int) ceil2, (int) ceil, Bitmap.Config.RGB_565);
        }
        try {
            if (Build.VERSION.SDK_INT < 11 || (this.f21128n instanceof AppCompatActivity)) {
                this.f21123i.setMargins(0, i, 0, 0);
                this.f21123i.gravity = 48;
            }
        } catch (NoClassDefFoundError unused) {
            this.f21123i.setMargins(0, 0, 0, 0);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, rect, new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight()), paint);
        if (this.f21132r) {
            bitmap3 = C8290b.m15558a(bitmap2, this.f21127m, true, this.f21128n);
        } else {
            bitmap3 = C8289a.m15556a(bitmap2, this.f21127m, true);
        }
        if (this.f21125k) {
            String str2 = (System.currentTimeMillis() - currentTimeMillis) + " ms";
            String str3 = f21121g;
            StringBuilder sb = new StringBuilder();
            sb.append("Blur method : ");
            sb.append(this.f21132r ? "RenderScript" : "FastBlur");
            SystemUtils.log(3, str3, sb.toString(), (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 430);
            SystemUtils.log(3, f21121g, "Radius : " + this.f21127m, (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 431);
            SystemUtils.log(3, f21121g, "Down Scale Factor : " + this.f21126l, (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 432);
            SystemUtils.log(3, f21121g, "Blurred achieved in : " + str2, (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 433);
            String str4 = f21121g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Allocation : ");
            sb2.append(bitmap.getRowBytes());
            sb2.append("ko (screen capture) + ");
            sb2.append(bitmap3.getRowBytes());
            sb2.append("ko (blurred bitmap)");
            if (!this.f21132r) {
                str = " + temp buff " + bitmap3.getRowBytes() + "ko.";
            } else {
                str = ".";
            }
            sb2.append(str);
            SystemUtils.log(3, str4, sb2.toString(), (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 434);
            Rect rect2 = new Rect();
            Canvas canvas2 = new Canvas(bitmap3);
            paint.setColor(-16777216);
            paint.setAntiAlias(true);
            paint.setTextSize(20.0f);
            paint.getTextBounds(str2, 0, str2.length(), rect2);
            canvas2.drawText(str2, 2.0f, (float) rect2.height(), paint);
        }
        ImageView imageView = new ImageView(this.f21128n);
        this.f21122h = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f21122h.setImageDrawable(new BitmapDrawable(this.f21128n.getResources(), bitmap3));
    }

    /* renamed from: a */
    private int m15542a() {
        ActionBar actionBar;
        ActionBar actionBar2;
        int height;
        try {
            if (this.f21129o != null) {
                height = this.f21129o.getHeight();
            } else if (this.f21128n instanceof AppCompatActivity) {
                androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) this.f21128n).getSupportActionBar();
                if (supportActionBar != null) {
                    return supportActionBar.getHeight();
                }
                return 0;
            } else if (Build.VERSION.SDK_INT < 11 || (actionBar2 = this.f21128n.getActionBar()) == null) {
                return 0;
            } else {
                height = actionBar2.getHeight();
            }
            return height;
        } catch (NoClassDefFoundError unused) {
            if (Build.VERSION.SDK_INT < 11 || (actionBar = this.f21128n.getActionBar()) == null) {
                return 0;
            }
            return actionBar.getHeight();
        }
    }

    /* renamed from: b */
    private int m15547b() {
        int identifier = this.f21128n.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.f21128n.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: c */
    private int m15549c() {
        int identifier;
        Resources resources = this.f21128n.getResources();
        if (Build.VERSION.SDK_INT < 21 || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    /* renamed from: d */
    private boolean m15552d() {
        int[] iArr = {16843759};
        TypedArray obtainStyledAttributes = this.f21128n.obtainStyledAttributes(new TypedValue().resourceId, iArr);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15554e() {
        ImageView imageView = this.f21122h;
        if (imageView != null) {
            ViewGroup viewGroup = (ViewGroup) imageView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f21122h);
            }
            this.f21122h = null;
        }
    }

    /* renamed from: com.didi.flutter.nacho.ui.blur.BlurDialogEngine$BlurAsyncTask */
    private class BlurAsyncTask extends AsyncTask<Void, Void, Void> {
        private Bitmap mBackground;
        private View mBackgroundView;

        private BlurAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.mBackgroundView = BlurDialogEngine.this.f21128n.getWindow().getDecorView();
            Rect rect = new Rect();
            this.mBackgroundView.setDrawingCacheBackgroundColor(0);
            this.mBackgroundView.getWindowVisibleDisplayFrame(rect);
            this.mBackgroundView.destroyDrawingCache();
            this.mBackgroundView.setDrawingCacheEnabled(true);
            this.mBackgroundView.buildDrawingCache(true);
            Bitmap drawingCache = this.mBackgroundView.getDrawingCache(true);
            this.mBackground = drawingCache;
            if (drawingCache != null) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(drawingCache.getWidth(), this.mBackground.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas();
                    canvas.setBitmap(createBitmap);
                    this.mBackgroundView.draw(canvas);
                    canvas.setBitmap((Bitmap) null);
                    this.mBackground = createBitmap;
                } catch (Error e) {
                    e.printStackTrace();
                }
            }
            if (this.mBackground == null) {
                this.mBackgroundView.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(rect.height(), 1073741824));
                View view = this.mBackgroundView;
                view.layout(0, 0, view.getMeasuredWidth(), this.mBackgroundView.getMeasuredHeight());
                this.mBackgroundView.destroyDrawingCache();
                this.mBackgroundView.setDrawingCacheEnabled(true);
                this.mBackgroundView.buildDrawingCache(true);
                this.mBackground = this.mBackgroundView.getDrawingCache(true);
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            if (!isCancelled()) {
                Bitmap mapSnapshot = SnapshotFetcher.getInstance().getMapSnapshot(BlurDialogEngine.this.f21128n);
                if (mapSnapshot != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(this.mBackground.getWidth(), this.mBackground.getHeight(), this.mBackground.getConfig());
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(Bitmap.createScaledBitmap(mapSnapshot, mapSnapshot.getWidth(), mapSnapshot.getHeight(), false), 0.0f, 0.0f, (Paint) null);
                    canvas.drawBitmap(this.mBackground, 0.0f, 0.0f, (Paint) null);
                    canvas.save();
                    canvas.restore();
                    this.mBackground = createBitmap;
                }
                BlurDialogEngine.this.m15545a(this.mBackground, this.mBackgroundView);
                this.mBackground.recycle();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            this.mBackgroundView.destroyDrawingCache();
            this.mBackgroundView.setDrawingCacheEnabled(false);
            BlurDialogEngine.this.f21128n.getWindow().addContentView(BlurDialogEngine.this.f21122h, BlurDialogEngine.this.f21123i);
            if (Build.VERSION.SDK_INT >= 12) {
                BlurDialogEngine.this.f21122h.setAlpha(0.0f);
                BlurDialogEngine.this.f21122h.animate().alpha(1.0f).setDuration((long) BlurDialogEngine.this.f21130p).setInterpolator(new LinearInterpolator()).start();
            }
            this.mBackgroundView = null;
            this.mBackground = null;
        }
    }
}
