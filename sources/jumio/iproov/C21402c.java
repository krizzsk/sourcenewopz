package jumio.iproov;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.taxis99.R;
import javax.security.auth.Destroyable;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.iproov.c */
/* compiled from: IproovHelpAnimation.kt */
public final class C21402c implements MotionLayout.TransitionListener, Destroyable {

    /* renamed from: a */
    public Context f59718a;

    /* renamed from: b */
    public boolean f59719b;

    /* renamed from: c */
    public boolean f59720c;

    /* renamed from: d */
    public boolean f59721d;

    /* renamed from: e */
    public MotionLayout f59722e;

    /* renamed from: f */
    public C21403a f59723f = C21403a.START;

    /* renamed from: g */
    public ImageView f59724g;

    /* renamed from: h */
    public ImageView f59725h;

    /* renamed from: i */
    public ImageView f59726i;

    /* renamed from: j */
    public ImageView f59727j;

    /* renamed from: k */
    public ImageView f59728k;

    /* renamed from: l */
    public ImageView f59729l;

    /* renamed from: m */
    public ImageView f59730m;

    /* renamed from: n */
    public ImageView f59731n;

    /* renamed from: o */
    public ImageView f59732o;

    /* renamed from: p */
    public ImageView f59733p;

    /* renamed from: jumio.iproov.c$a */
    /* compiled from: IproovHelpAnimation.kt */
    public enum C21403a {
        START,
        APPEAR,
        ALIGN,
        FOCUS,
        FLASH,
        SUCCESS
    }

    /* renamed from: jumio.iproov.c$b */
    /* compiled from: IproovHelpAnimation.kt */
    public /* synthetic */ class C21404b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f59741a;

        static {
            int[] iArr = new int[C21403a.values().length];
            iArr[C21403a.START.ordinal()] = 1;
            iArr[C21403a.APPEAR.ordinal()] = 2;
            iArr[C21403a.ALIGN.ordinal()] = 3;
            iArr[C21403a.FOCUS.ordinal()] = 4;
            iArr[C21403a.FLASH.ordinal()] = 5;
            iArr[C21403a.SUCCESS.ordinal()] = 6;
            f59741a = iArr;
        }
    }

    public C21402c(Context context) {
        this.f59718a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo175915a() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f59721d     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            boolean r0 = r1.f59720c     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0011
            r0 = 1
            r1.f59720c = r0     // Catch:{ all -> 0x0013 }
            r1.mo175918b()     // Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C21402c.mo175915a():void");
    }

    /* renamed from: b */
    public final synchronized void mo175918b() {
        if (this.f59723f == C21403a.START) {
            MotionLayout motionLayout = this.f59722e;
            if (motionLayout != null) {
                motionLayout.setTransitionListener(this);
            }
            MotionLayout motionLayout2 = this.f59722e;
            if (motionLayout2 != null) {
                motionLayout2.setTransition(R.id.start, R.id.appear);
            }
            this.f59723f = C21403a.APPEAR;
            this.f59720c = true;
            MotionLayout motionLayout3 = this.f59722e;
            if (motionLayout3 != null) {
                motionLayout3.transitionToEnd();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo175919c() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f59721d     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            boolean r0 = r3.f59720c     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            jumio.iproov.c$a r0 = jumio.iproov.C21402c.C21403a.START     // Catch:{ all -> 0x002f }
            r3.f59723f = r0     // Catch:{ all -> 0x002f }
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r3.f59722e     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            r1 = 2131434257(0x7f0b1b11, float:1.8490323E38)
            if (r0 != 0) goto L_0x001b
            r2 = 0
            goto L_0x001f
        L_0x001b:
            androidx.constraintlayout.widget.ConstraintSet r2 = r0.getConstraintSet(r1)     // Catch:{ all -> 0x002f }
        L_0x001f:
            r0.updateState(r1, r2)     // Catch:{ all -> 0x002f }
        L_0x0022:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r3.f59722e     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            r0.transitionToStart()     // Catch:{ all -> 0x002f }
        L_0x002a:
            r0 = 0
            r3.f59720c = r0     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C21402c.mo175919c():void");
    }

    public void destroy() {
        mo175919c();
        this.f59718a = null;
        this.f59722e = null;
        this.f59724g = null;
        this.f59725h = null;
        this.f59726i = null;
        this.f59727j = null;
        this.f59728k = null;
        this.f59729l = null;
        this.f59730m = null;
        this.f59731n = null;
        this.f59732o = null;
        this.f59733p = null;
    }

    public boolean isDestroyed() {
        return !this.f59720c;
    }

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        if (this.f59720c) {
            if (this.f59719b) {
                switch (C21404b.f59741a[this.f59723f.ordinal()]) {
                    case 1:
                        this.f59723f = C21403a.APPEAR;
                        MotionLayout motionLayout2 = this.f59722e;
                        if (motionLayout2 != null) {
                            motionLayout2.setTransition(R.id.start, R.id.appear);
                            break;
                        }
                        break;
                    case 2:
                        this.f59723f = C21403a.ALIGN;
                        MotionLayout motionLayout3 = this.f59722e;
                        if (motionLayout3 != null) {
                            motionLayout3.setTransition(R.id.appear, R.id.align);
                            break;
                        }
                        break;
                    case 3:
                        this.f59723f = C21403a.FOCUS;
                        MotionLayout motionLayout4 = this.f59722e;
                        if (motionLayout4 != null) {
                            motionLayout4.setTransition(R.id.align, R.id.focus);
                            break;
                        }
                        break;
                    case 4:
                        this.f59723f = C21403a.FLASH;
                        MotionLayout motionLayout5 = this.f59722e;
                        if (motionLayout5 != null) {
                            motionLayout5.setTransition(R.id.focus, R.id.flash);
                            break;
                        }
                        break;
                    case 5:
                        this.f59723f = C21403a.SUCCESS;
                        MotionLayout motionLayout6 = this.f59722e;
                        if (motionLayout6 != null) {
                            motionLayout6.setTransition(R.id.flash, R.id.success);
                            break;
                        }
                        break;
                    case 6:
                        this.f59723f = C21403a.START;
                        MotionLayout motionLayout7 = this.f59722e;
                        if (motionLayout7 != null) {
                            motionLayout7.setTransition(R.id.success, R.id.start);
                            break;
                        }
                        break;
                }
            } else {
                int i2 = C21404b.f59741a[this.f59723f.ordinal()];
                if (i2 == 1) {
                    this.f59723f = C21403a.APPEAR;
                    MotionLayout motionLayout8 = this.f59722e;
                    if (motionLayout8 != null) {
                        motionLayout8.setTransition(R.id.start, R.id.appear);
                    }
                } else if (i2 == 2) {
                    this.f59723f = C21403a.ALIGN;
                    MotionLayout motionLayout9 = this.f59722e;
                    if (motionLayout9 != null) {
                        motionLayout9.setTransition(R.id.appear, R.id.align);
                    }
                } else if (i2 == 3) {
                    this.f59723f = C21403a.FOCUS;
                    MotionLayout motionLayout10 = this.f59722e;
                    if (motionLayout10 != null) {
                        motionLayout10.setTransition(R.id.align, R.id.focus);
                    }
                } else if (i2 == 4) {
                    this.f59723f = C21403a.SUCCESS;
                    MotionLayout motionLayout11 = this.f59722e;
                    if (motionLayout11 != null) {
                        motionLayout11.setTransition(R.id.focus, R.id.success);
                    }
                } else if (i2 == 6) {
                    this.f59723f = C21403a.START;
                    MotionLayout motionLayout12 = this.f59722e;
                    if (motionLayout12 != null) {
                        motionLayout12.setTransition(R.id.success, R.id.start);
                    }
                }
            }
            MotionLayout motionLayout13 = this.f59722e;
            if (motionLayout13 != null) {
                motionLayout13.transitionToEnd();
            }
        }
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
    }

    /* renamed from: a */
    public final synchronized void mo175917a(MotionLayout motionLayout, boolean z) {
        Intrinsics.checkNotNullParameter(motionLayout, "animationContainer");
        if (this.f59720c) {
            mo175919c();
        }
        this.f59722e = motionLayout;
        this.f59724g = (ImageView) motionLayout.findViewById(R.id.iv_face);
        this.f59725h = (ImageView) motionLayout.findViewById(R.id.iv_face_oval_mask);
        this.f59730m = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_bl);
        this.f59731n = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_br);
        this.f59728k = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_tl);
        this.f59729l = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_tr);
        this.f59726i = (ImageView) motionLayout.findViewById(R.id.iv_checkmark);
        this.f59727j = (ImageView) motionLayout.findViewById(R.id.iv_checkmark_circle);
        this.f59732o = (ImageView) motionLayout.findViewById(R.id.iv_progress_lane);
        this.f59733p = (ImageView) motionLayout.findViewById(R.id.iv_progress_bar);
        this.f59719b = z;
        this.f59721d = true;
    }

    /* renamed from: a */
    public final void mo175916a(Resources resources, int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Intrinsics.checkNotNullParameter(resources, "resources");
        MotionLayout motionLayout = this.f59722e;
        if (motionLayout != null) {
            motionLayout.setBackgroundColor(i2);
        }
        Drawable drawable8 = null;
        if (Build.VERSION.SDK_INT >= 21) {
            Context context = this.f59718a;
            Resources.Theme theme = context == null ? null : context.getTheme();
            TypedValue typedValue = new TypedValue();
            int i3 = 2132017567;
            boolean z = true;
            if (theme == null || !theme.resolveAttribute(R.attr.iproov_customization, typedValue, true)) {
                z = false;
            }
            if (z) {
                i3 = typedValue.data;
            }
            Drawable drawable9 = ResourcesCompat.getDrawable(resources, R.drawable.ic_face_oval_mask, new ContextThemeWrapper(this.f59718a, i3).getTheme());
            ImageView imageView = this.f59725h;
            if (imageView != null) {
                imageView.setImageDrawable(drawable9);
            }
        } else {
            Context context2 = this.f59718a;
            Drawable drawable10 = ResourcesCompat.getDrawable(resources, R.drawable.ic_face_oval, context2 == null ? null : context2.getTheme());
            ImageView imageView2 = this.f59725h;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable10);
            }
            ImageView imageView3 = this.f59725h;
            if (!(imageView3 == null || (drawable7 = imageView3.getDrawable()) == null)) {
                DrawableCompat.setTint(drawable7, i);
            }
        }
        ImageView imageView4 = this.f59728k;
        if (!(imageView4 == null || (drawable6 = imageView4.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable6, i);
        }
        ImageView imageView5 = this.f59730m;
        if (imageView5 != null) {
            ImageView imageView6 = this.f59728k;
            imageView5.setImageDrawable(imageView6 == null ? null : imageView6.getDrawable());
        }
        ImageView imageView7 = this.f59731n;
        if (imageView7 != null) {
            ImageView imageView8 = this.f59728k;
            imageView7.setImageDrawable(imageView8 == null ? null : imageView8.getDrawable());
        }
        ImageView imageView9 = this.f59729l;
        if (imageView9 != null) {
            ImageView imageView10 = this.f59728k;
            if (imageView10 != null) {
                drawable8 = imageView10.getDrawable();
            }
            imageView9.setImageDrawable(drawable8);
        }
        ImageView imageView11 = this.f59724g;
        if (!(imageView11 == null || (drawable5 = imageView11.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable5, i);
        }
        ImageView imageView12 = this.f59726i;
        if (!(imageView12 == null || (drawable4 = imageView12.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable4, i);
        }
        ImageView imageView13 = this.f59727j;
        if (!(imageView13 == null || (drawable3 = imageView13.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable3, i);
        }
        ImageView imageView14 = this.f59732o;
        if (!(imageView14 == null || (drawable2 = imageView14.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable2, i);
        }
        ImageView imageView15 = this.f59733p;
        if (imageView15 != null && (drawable = imageView15.getDrawable()) != null) {
            DrawableCompat.setTint(drawable, i);
        }
    }
}
