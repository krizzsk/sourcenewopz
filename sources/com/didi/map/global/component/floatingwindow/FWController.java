package com.didi.map.global.component.floatingwindow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.map.global.component.floatingwindow.IFWController;
import com.didi.map.global.component.floatingwindow.OrientationStateChangeCallback;
import com.didi.map.global.component.floatingwindow.util.C9502Util;
import com.didi.map.global.component.floatingwindow.util.ViewExtKt;
import com.didi.map.global.component.floatingwindow.view.FWView;
import com.didi.map.global.component.floatingwindow.view.IFWView;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0002ijB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020;H\u0002J\b\u0010=\u001a\u00020;H\u0002J\b\u0010>\u001a\u00020;H\u0002J\b\u0010?\u001a\u00020;H\u0016J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\u0010H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0005H\u0002J\b\u0010E\u001a\u00020;H\u0016J\u0018\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 H\u0002J\b\u0010I\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010J\u001a\u00020;H\u0002J\b\u0010K\u001a\u00020;H\u0002J\u001c\u0010L\u001a\u00020\u001a2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0017J\b\u0010Q\u001a\u00020;H\u0016J\u0012\u0010R\u001a\u00020;2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010U\u001a\u00020;2\b\u0010V\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010W\u001a\u00020;2\b\u0010X\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020\u000eH\u0016J\u0012\u0010[\u001a\u00020;2\b\u0010\\\u001a\u0004\u0018\u00010%H\u0016J\b\u0010]\u001a\u00020;H\u0016J\b\u0010^\u001a\u00020;H\u0002J\b\u0010_\u001a\u00020;H\u0002J\b\u0010`\u001a\u00020;H\u0002J\u0010\u0010a\u001a\u00020;2\u0006\u00101\u001a\u000202H\u0002J\u0018\u0010b\u001a\u00020;2\u0006\u0010c\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u0010H\u0002J\u0018\u0010e\u001a\u00020;2\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u0010H\u0002J\b\u0010h\u001a\u00020;H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/FWController;", "Lcom/didi/map/global/component/floatingwindow/IFWController;", "Landroid/view/View$OnTouchListener;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/ref/WeakReference;)V", "animator", "Landroid/animation/ValueAnimator;", "animeState", "Lcom/didi/map/global/component/floatingwindow/FWController$FWAnimeState;", "clickListener", "Landroid/view/View$OnClickListener;", "colorState", "Lcom/didi/map/global/component/floatingwindow/IFWController$Style;", "deltaX", "", "deltaY", "floatView", "Lcom/didi/map/global/component/floatingwindow/view/FWView;", "fwHeight", "fwWidth", "interpolator", "Landroid/view/animation/Interpolator;", "kotlin.jvm.PlatformType", "isDown", "", "isRegister", "isShow", "layoutParam", "Landroid/view/WindowManager$LayoutParams;", "mLastMoveRawX", "", "mLastMoveRawY", "mainGestureDetector", "Landroid/view/GestureDetector;", "mainTextString", "", "maskThreshold", "pressedTime", "", "receiver", "Lcom/didi/map/global/component/floatingwindow/OrientationStateReceiver;", "rollThreshold", "rollWidth", "shadowBottomPadding", "shadowLeftPadding", "shadowRightPadding", "shadowTopPadding", "shapeState", "Lcom/didi/map/global/component/floatingwindow/view/IFWView$FWShapeState;", "subTextString", "topGag", "touchPadding", "windowHeight", "windowManager", "Landroid/view/WindowManager;", "windowWidth", "animeForExpand", "", "animeForExpandRight", "animeForRoll", "animeForRollRight", "close", "getAnimateY", "startY", "getOrientationState", "Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback$OrientationState;", "context", "hidden", "isInTouchField", "x", "y", "isOpen", "myHidden", "myShow", "onTouch", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "open", "setCarBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setMainTitle", "title", "setOnClickListener", "listener", "setStyle", "style", "setSubTitle", "subtitle", "show", "stopAnimate", "updateDelayText", "updateMaskState", "updateViewBackground", "updateViewPositionByMove", "movedX", "movedY", "updateViewPositionByPosition", "pX", "pY", "updateViewSize", "Companion", "FWAnimeState", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FWController.kt */
public final class FWController implements View.OnTouchListener, IFWController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float MASK_THRESHOLD = 50.0f;
    public static final float ROLL_THRESHOLD = 40.0f;
    public static final float ROLL_WIDTH = 25.0f;
    public static final float SHADOW_BOTTOM = 24.5f;
    public static final float SHADOW_LEFT = 19.5f;
    public static final float SHADOW_RIGHT = 20.0f;
    public static final float SHADOW_TOP = 14.5f;
    public static final float TOP_GAG = 12.0f;
    public static final float TOUCH_EXPAND = 10.0f;

    /* renamed from: A */
    private float f25577A;

    /* renamed from: B */
    private float f25578B;

    /* renamed from: C */
    private float f25579C;

    /* renamed from: D */
    private float f25580D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f25581E;

    /* renamed from: F */
    private long f25582F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public volatile boolean f25583G;

    /* renamed from: H */
    private boolean f25584H;

    /* renamed from: I */
    private final OrientationStateReceiver f25585I;

    /* renamed from: a */
    private final WeakReference<Context> f25586a;

    /* renamed from: b */
    private WindowManager f25587b;

    /* renamed from: c */
    private int f25588c;

    /* renamed from: d */
    private int f25589d;

    /* renamed from: e */
    private int f25590e;

    /* renamed from: f */
    private int f25591f;

    /* renamed from: g */
    private int f25592g;

    /* renamed from: h */
    private int f25593h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FWView f25594i;

    /* renamed from: j */
    private String f25595j;

    /* renamed from: k */
    private String f25596k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final WindowManager.LayoutParams f25597l;

    /* renamed from: m */
    private float f25598m;

    /* renamed from: n */
    private float f25599n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ValueAnimator f25600o;

    /* renamed from: p */
    private final Interpolator f25601p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public IFWView.FWShapeState f25602q;

    /* renamed from: r */
    private IFWController.Style f25603r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public FWAnimeState f25604s;

    /* renamed from: t */
    private GestureDetector f25605t;

    /* renamed from: u */
    private View.OnClickListener f25606u;

    /* renamed from: v */
    private float f25607v;

    /* renamed from: w */
    private float f25608w;

    /* renamed from: x */
    private float f25609x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public float f25610y;

    /* renamed from: z */
    private float f25611z;

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/FWController$FWAnimeState;", "", "(Ljava/lang/String;I)V", "NONE", "RIGHT_EXPAND", "EXPAND", "ROLL", "RIGHT_ROLL", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FWController.kt */
    private enum FWAnimeState {
        NONE,
        RIGHT_EXPAND,
        EXPAND,
        ROLL,
        RIGHT_ROLL
    }

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FWController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IFWController.Style.values().length];
            iArr[IFWController.Style.Grey.ordinal()] = 1;
            iArr[IFWController.Style.Gradient.ordinal()] = 2;
            iArr[IFWController.Style.Orange.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IFWView.FWShapeState.values().length];
            iArr2[IFWView.FWShapeState.EXPAND.ordinal()] = 1;
            iArr2[IFWView.FWShapeState.EXPAND_NORMAL_DRAG.ordinal()] = 2;
            iArr2[IFWView.FWShapeState.EXPAND_HANDLE_DRAG.ordinal()] = 3;
            iArr2[IFWView.FWShapeState.ROLL.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public FWController(WeakReference<Context> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "contextRef");
        this.f25586a = weakReference;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
        layoutParams.format = 1;
        layoutParams.flags = 552;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.x = 0;
        layoutParams.y = 0;
        Unit unit = Unit.INSTANCE;
        this.f25597l = layoutParams;
        this.f25598m = -1.0f;
        this.f25599n = -1.0f;
        this.f25601p = PathInterpolatorCompat.create(0.0f, 1.0f, 0.0f, 1.0f);
        this.f25602q = IFWView.FWShapeState.EXPAND;
        this.f25603r = IFWController.Style.Grey;
        this.f25604s = FWAnimeState.NONE;
        this.f25582F = -1;
        this.f25585I = new OrientationStateReceiver(new FWController$receiver$1(this));
        Context context = (Context) this.f25586a.get();
        if (context != null) {
            this.f25607v = ViewExtKt.dp2px(context, 14.5f);
            this.f25608w = ViewExtKt.dp2px(context, 24.5f);
            this.f25609x = ViewExtKt.dp2px(context, 19.5f);
            this.f25610y = ViewExtKt.dp2px(context, 20.0f);
            this.f25611z = ViewExtKt.dp2px(context, 12.0f);
            this.f25577A = ViewExtKt.dp2px(context, 50.0f) + this.f25610y;
            this.f25578B = ViewExtKt.dp2px(context, 40.0f) + this.f25610y;
            this.f25579C = ViewExtKt.dp2px(context, 25.0f) + this.f25609x;
            this.f25580D = ViewExtKt.dp2px(context, 10.0f);
            WindowManager.LayoutParams layoutParams2 = this.f25597l;
            layoutParams2.x = -((int) this.f25610y);
            layoutParams2.y = (int) ((-this.f25607v) + this.f25611z);
            FWView fWView = new FWView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            this.f25594i = fWView;
            if (fWView != null) {
                fWView.setTouchListener(this);
            }
            Object systemService = context.getSystemService("window");
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            this.f25587b = windowManager;
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Display defaultDisplay = windowManager.getDefaultDisplay();
                if (defaultDisplay != null) {
                    defaultDisplay.getMetrics(displayMetrics);
                }
                this.f25589d = displayMetrics.heightPixels;
                this.f25588c = displayMetrics.widthPixels;
            }
            this.f25605t = new GestureDetector(context, new FWController$1$3(this));
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/FWController$Companion;", "", "()V", "MASK_THRESHOLD", "", "ROLL_THRESHOLD", "ROLL_WIDTH", "SHADOW_BOTTOM", "SHADOW_LEFT", "SHADOW_RIGHT", "SHADOW_TOP", "TOP_GAG", "TOUCH_EXPAND", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FWController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18291a(IFWView.FWShapeState fWShapeState) {
        SystemUtils.log(3, C9502Util.TAG, "updateViewBackground: shapeState=" + fWShapeState + ", colorState=" + this.f25603r, (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 218);
        FWView fWView = this.f25594i;
        if (fWView != null) {
            fWView.updateViewBackground(this.f25603r, fWShapeState);
        }
        this.f25602q = fWShapeState;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Integer num;
        if (view == null) {
            return false;
        }
        GestureDetector gestureDetector = this.f25605t;
        boolean onTouchEvent = gestureDetector == null ? false : gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent == null) {
            num = null;
        } else {
            num = Integer.valueOf(motionEvent.getAction());
        }
        if (num != null && num.intValue() == 0) {
            if (!m18292a(motionEvent.getRawX(), motionEvent.getRawY())) {
                return false;
            }
            this.f25581E = true;
            SystemUtils.log(3, C9502Util.TAG, "onTouch: ACTION_DOWN", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 237);
            this.f25582F = System.currentTimeMillis();
            m18293b();
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (this.f25602q != IFWView.FWShapeState.ROLL) {
                if (!Intrinsics.areEqual((Object) view, (Object) this.f25594i)) {
                    m18291a(IFWView.FWShapeState.EXPAND_HANDLE_DRAG);
                } else {
                    m18291a(IFWView.FWShapeState.EXPAND_NORMAL_DRAG);
                }
            }
            this.f25598m = rawX;
            this.f25599n = rawY;
            return true;
        } else if (num != null && num.intValue() == 2) {
            if (!this.f25581E) {
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            int i = (int) (rawX2 - this.f25598m);
            int i2 = (int) (rawY2 - this.f25599n);
            this.f25598m = rawX2;
            this.f25599n = rawY2;
            if (this.f25602q == IFWView.FWShapeState.ROLL) {
                m18286a(0, i2);
            } else {
                if (!Intrinsics.areEqual((Object) view, (Object) this.f25594i)) {
                    if (((float) (this.f25597l.x - i)) > (-this.f25610y)) {
                        i = this.f25597l.x + ((int) this.f25610y);
                    }
                    m18286a(i, 0);
                } else {
                    m18286a(i, i2);
                }
                m18285a();
            }
            return true;
        } else if (num == null || num.intValue() != 1 || !this.f25581E) {
            return false;
        } else {
            SystemUtils.log(3, C9502Util.TAG, "onTouch: ACTION_UP", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 302);
            long currentTimeMillis = System.currentTimeMillis() - this.f25582F;
            if (!(0 <= currentTimeMillis && currentTimeMillis <= 300) || onTouchEvent) {
                if (this.f25604s == FWAnimeState.NONE) {
                    if (this.f25602q != IFWView.FWShapeState.ROLL) {
                        if (((float) this.f25597l.x) < (-this.f25578B)) {
                            m18296c();
                        } else {
                            m18299e();
                        }
                    } else if (((int) m18283a(this.f25597l.y)) != 0) {
                        m18300f();
                    }
                }
            } else if (this.f25602q != IFWView.FWShapeState.ROLL) {
                m18291a(IFWView.FWShapeState.EXPAND);
                SystemUtils.log(3, C9502Util.TAG, "onTouch: ACTION_UP onClick", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 309);
                View.OnClickListener onClickListener = this.f25606u;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                m18294b(-((int) this.f25610y), this.f25597l.y - ((int) m18283a(this.f25597l.y)));
            } else {
                m18298d();
            }
            this.f25581E = false;
            this.f25582F = -1;
            return true;
        }
    }

    /* renamed from: a */
    private final boolean m18292a(float f, float f2) {
        SystemUtils.log(3, C9502Util.TAG, "isInTouchField", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 347);
        boolean z = false;
        if (!(this.f25604s == FWAnimeState.EXPAND || this.f25604s == FWAnimeState.ROLL)) {
            float f3 = (((float) ((this.f25597l.x + this.f25592g) - this.f25590e)) + this.f25609x) - this.f25580D;
            float f4 = (((float) (this.f25597l.y + this.f25593h)) + this.f25607v) - this.f25580D;
            float f5 = (((float) (this.f25597l.x + this.f25592g)) - this.f25610y) + this.f25580D;
            float f6 = (((float) ((this.f25597l.y + this.f25593h) + this.f25591f)) - this.f25608w) + this.f25580D;
            if (f3 <= f && f <= f5) {
                if (f4 <= f2 && f2 <= f6) {
                    z = true;
                }
            }
            SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("isInTouchField: result=", Boolean.valueOf(z)), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 357);
        }
        return z;
    }

    /* renamed from: a */
    private final void m18286a(int i, int i2) {
        WindowManager windowManager;
        WindowManager.LayoutParams layoutParams = this.f25597l;
        layoutParams.x -= i;
        layoutParams.y += i2;
        FWView fWView = this.f25594i;
        if ((fWView == null ? null : fWView.getParent()) != null && (windowManager = this.f25587b) != null) {
            windowManager.updateViewLayout(this.f25594i, this.f25597l);
        }
    }

    /* renamed from: b */
    private final void m18294b(int i, int i2) {
        WindowManager windowManager;
        WindowManager.LayoutParams layoutParams = this.f25597l;
        layoutParams.x = i;
        layoutParams.y = i2;
        FWView fWView = this.f25594i;
        if ((fWView == null ? null : fWView.getParent()) != null && (windowManager = this.f25587b) != null) {
            windowManager.updateViewLayout(this.f25594i, this.f25597l);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m18285a() {
        /*
            r8 = this;
            android.view.WindowManager$LayoutParams r0 = r8.f25597l
            int r0 = r0.x
            float r0 = (float) r0
            float r1 = r8.f25577A
            float r2 = -r1
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r5 = 1
            r6 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x003d
            float r0 = (float) r5
            int r2 = r8.f25590e
            float r2 = (float) r2
            float r2 = r2 - r1
            float r1 = r8.f25579C
            float r2 = r2 - r1
            android.view.WindowManager$LayoutParams r1 = r8.f25597l
            int r1 = r1.x
            float r1 = (float) r1
            float r7 = r8.f25577A
            float r1 = r1 + r7
            float r2 = r2 + r1
            int r1 = r8.f25590e
            float r1 = (float) r1
            float r1 = r1 - r7
            float r7 = r8.f25579C
            float r1 = r1 - r7
            float r2 = r2 / r1
            float r0 = r0 - r2
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0031
        L_0x002f:
            r4 = 1
            goto L_0x003e
        L_0x0031:
            int r1 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x0036
            goto L_0x003d
        L_0x0036:
            android.view.animation.Interpolator r1 = r8.f25601p
            float r3 = r1.getInterpolation(r0)
            goto L_0x002f
        L_0x003d:
            r3 = 0
        L_0x003e:
            com.didi.map.global.component.floatingwindow.view.FWView r0 = r8.f25594i
            if (r0 != 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            r0.updateMaskState(r4, r3)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.floatingwindow.FWController.m18285a():void");
    }

    /* renamed from: b */
    private final void m18293b() {
        SystemUtils.log(3, C9502Util.TAG, "stopAnimate", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 432);
        ValueAnimator valueAnimator = this.f25600o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f25600o = null;
        this.f25604s = FWAnimeState.NONE;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m18296c() {
        SystemUtils.log(3, C9502Util.TAG, "animeForRoll", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 440);
        if (this.f25602q != IFWView.FWShapeState.ROLL && this.f25604s != FWAnimeState.ROLL) {
            FWView fWView = this.f25594i;
            if ((fWView == null ? null : fWView.getParent()) != null) {
                m18293b();
                int i = this.f25597l.x;
                int i2 = this.f25597l.y;
                float f = (((float) this.f25590e) + ((float) this.f25597l.x)) - this.f25579C;
                float a = m18283a(i2);
                FWController$animeForRoll$listeners$1 fWController$animeForRoll$listeners$1 = new FWController$animeForRoll$listeners$1(this);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.f25600o = ofFloat;
                if (ofFloat != null) {
                    ofFloat.setDuration(300);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, f, i2, a) {
                        public final /* synthetic */ int f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ int f$3;
                        public final /* synthetic */ float f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            FWController.m18288a(FWController.this, this.f$1, this.f$2, this.f$3, this.f$4, valueAnimator);
                        }
                    });
                    ofFloat.addListener(fWController$animeForRoll$listeners$1);
                    ofFloat.start();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18288a(FWController fWController, int i, float f, int i2, float f2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(fWController, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            fWController.m18294b((int) (((float) i) - (f * floatValue)), (int) (((float) i2) - (f2 * floatValue)));
            fWController.m18285a();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m18298d() {
        SystemUtils.log(3, C9502Util.TAG, "animeForExpand", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 490);
        if (this.f25602q != IFWView.FWShapeState.EXPAND && this.f25602q != IFWView.FWShapeState.EXPAND_HANDLE_DRAG && this.f25602q != IFWView.FWShapeState.EXPAND_NORMAL_DRAG && this.f25604s != FWAnimeState.EXPAND) {
            FWView fWView = this.f25594i;
            if ((fWView == null ? null : fWView.getParent()) != null) {
                m18293b();
                int i = this.f25597l.x;
                int i2 = this.f25597l.y;
                float f = ((float) i) + this.f25610y;
                float a = m18283a(i2);
                FWController$animeForExpand$listeners$1 fWController$animeForExpand$listeners$1 = new FWController$animeForExpand$listeners$1(this);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.f25600o = ofFloat;
                if (ofFloat != null) {
                    ofFloat.setDuration(300);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, f, i2, a) {
                        public final /* synthetic */ int f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ int f$3;
                        public final /* synthetic */ float f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            FWController.m18295b(FWController.this, this.f$1, this.f$2, this.f$3, this.f$4, valueAnimator);
                        }
                    });
                    ofFloat.addListener(fWController$animeForExpand$listeners$1);
                    ofFloat.start();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m18295b(FWController fWController, int i, float f, int i2, float f2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(fWController, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            fWController.m18294b((int) (((float) i) - (f * floatValue)), (int) (((float) i2) - (f2 * floatValue)));
            fWController.m18285a();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* renamed from: e */
    private final void m18299e() {
        SystemUtils.log(3, C9502Util.TAG, "animeForExpandRight", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 541);
        if (this.f25604s != FWAnimeState.RIGHT_EXPAND) {
            FWView fWView = this.f25594i;
            if ((fWView == null ? null : fWView.getParent()) != null) {
                m18293b();
                int i = this.f25597l.x;
                int i2 = this.f25597l.y;
                float f = ((float) i) + this.f25610y;
                float a = m18283a(i2);
                long j = 300;
                if (((int) f) == 0 && ((int) a) == 0) {
                    j = 0;
                }
                FWController$animeForExpandRight$listeners$1 fWController$animeForExpandRight$listeners$1 = new FWController$animeForExpandRight$listeners$1(this);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.f25600o = ofFloat;
                if (ofFloat != null) {
                    ofFloat.setDuration(j);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, f, i2, a) {
                        public final /* synthetic */ int f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ int f$3;
                        public final /* synthetic */ float f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            FWController.m18297c(FWController.this, this.f$1, this.f$2, this.f$3, this.f$4, valueAnimator);
                        }
                    });
                    ofFloat.addListener(fWController$animeForExpandRight$listeners$1);
                    ofFloat.start();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m18297c(FWController fWController, int i, float f, int i2, float f2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(fWController, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            fWController.m18294b((int) (((float) i) - (f * floatValue)), (int) (((float) i2) - (f2 * floatValue)));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* renamed from: f */
    private final void m18300f() {
        SystemUtils.log(3, C9502Util.TAG, "animeForRollRight", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 591);
        if (this.f25604s != FWAnimeState.RIGHT_ROLL) {
            FWView fWView = this.f25594i;
            if ((fWView == null ? null : fWView.getParent()) != null) {
                m18293b();
                int i = this.f25597l.x;
                int i2 = this.f25597l.y;
                float a = m18283a(i2);
                long j = 300;
                if (((int) a) == 0) {
                    j = 0;
                }
                FWController$animeForRollRight$listeners$1 fWController$animeForRollRight$listeners$1 = new FWController$animeForRollRight$listeners$1(this);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.f25600o = ofFloat;
                if (ofFloat != null) {
                    ofFloat.setDuration(j);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, i2, a) {
                        public final /* synthetic */ int f$1;
                        public final /* synthetic */ int f$2;
                        public final /* synthetic */ float f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            FWController.m18289a(FWController.this, this.f$1, this.f$2, this.f$3, valueAnimator);
                        }
                    });
                    ofFloat.addListener(fWController$animeForRollRight$listeners$1);
                    ofFloat.start();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18289a(FWController fWController, int i, int i2, float f, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(fWController, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            fWController.m18294b(i, (int) (((float) i2) - (f * ((Float) animatedValue).floatValue())));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m18301g() {
        String str = this.f25595j;
        if (str != null) {
            FWView fWView = this.f25594i;
            if (fWView != null) {
                fWView.setMainTitle(str);
            }
            SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("updateDelayText: mainTextString=", str), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 639);
        }
        this.f25595j = null;
        String str2 = this.f25596k;
        if (str2 != null) {
            FWView fWView2 = this.f25594i;
            if (fWView2 != null) {
                fWView2.setSubTitle(str2);
            }
            SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("updateDelayText: subTextString=", str2), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 644);
        }
        this.f25596k = null;
    }

    /* renamed from: a */
    private final float m18283a(int i) {
        int i2 = this.f25591f;
        float f = this.f25608w;
        int i3 = this.f25589d;
        if (((float) (i + i2)) - f > ((float) i3)) {
            return (((float) (i + i2)) - f) - ((float) i3);
        }
        float f2 = (float) i;
        float f3 = this.f25607v;
        float f4 = this.f25611z;
        if (f2 < (-f3) + f4) {
            return (f2 + f3) - f4;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final void m18302h() {
        SystemUtils.log(3, C9502Util.TAG, "updateViewSize", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 682);
        FWView fWView = this.f25594i;
        if (fWView != null) {
            fWView.post(new Runnable() {
                public final void run() {
                    FWController.m18287a(FWController.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18287a(FWController fWController) {
        Intrinsics.checkNotNullParameter(fWController, "this$0");
        FWView fWView = fWController.f25594i;
        Integer num = null;
        Integer valueOf = fWView == null ? null : Integer.valueOf(fWView.getHeight());
        fWController.f25591f = valueOf == null ? fWController.f25591f : valueOf.intValue();
        FWView fWView2 = fWController.f25594i;
        if (fWView2 != null) {
            num = Integer.valueOf(fWView2.getWidth());
        }
        fWController.f25590e = num == null ? fWController.f25590e : num.intValue();
        if (fWController.f25604s == FWAnimeState.NONE) {
            int[] iArr = new int[2];
            FWView fWView3 = fWController.f25594i;
            if (fWView3 != null) {
                fWView3.getLocationOnScreen(iArr);
            }
            fWController.f25592g = (iArr[0] + fWController.f25590e) - fWController.f25597l.x;
            fWController.f25593h = iArr[1] - fWController.f25597l.y;
            SystemUtils.log(3, C9502Util.TAG, "updateViewSize: 无动画状态更新", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 695);
            if (fWController.f25602q == IFWView.FWShapeState.ROLL) {
                SystemUtils.log(3, C9502Util.TAG, "updateViewSize: 收起状态更新", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 698);
                int i = fWController.f25597l.x;
                float f = fWController.f25579C;
                int i2 = fWController.f25590e;
                if (i == ((int) (f - ((float) i2)))) {
                    fWController.f25592g = (iArr[0] + i2) - fWController.f25597l.x;
                    fWController.f25593h = iArr[1] - fWController.f25597l.y;
                    return;
                }
                fWController.m18294b((int) (f - ((float) i2)), fWController.f25597l.y);
                FWView fWView4 = fWController.f25594i;
                if (fWView4 != null) {
                    fWView4.post(new Runnable(iArr) {
                        public final /* synthetic */ int[] f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            FWController.m18290a(FWController.this, this.f$1);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18290a(FWController fWController, int[] iArr) {
        Intrinsics.checkNotNullParameter(fWController, "this$0");
        Intrinsics.checkNotNullParameter(iArr, "$location");
        FWView fWView = fWController.f25594i;
        if (fWView != null) {
            fWView.getLocationOnScreen(iArr);
        }
        fWController.f25592g = (iArr[0] + fWController.f25590e) - fWController.f25597l.x;
        fWController.f25593h = iArr[1] - fWController.f25597l.y;
        SystemUtils.log(3, C9502Util.TAG, "updateViewSize: 收起位置不正确更新", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 711);
    }

    public void setMainTitle(String str) {
        if (str != null) {
            SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("setMainTitle: title=", str), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 727);
            if (this.f25604s != FWAnimeState.NONE || this.f25602q == IFWView.FWShapeState.ROLL) {
                this.f25595j = str;
                return;
            }
            FWView fWView = this.f25594i;
            if (fWView != null) {
                fWView.setMainTitle(str);
            }
            m18302h();
        }
    }

    public void setSubTitle(String str) {
        if (str != null) {
            SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("setSubTitle: subtitle=", str), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 741);
            if (this.f25604s != FWAnimeState.NONE || this.f25602q == IFWView.FWShapeState.ROLL) {
                this.f25596k = str;
                return;
            }
            FWView fWView = this.f25594i;
            if (fWView != null) {
                fWView.setSubTitle(str);
            }
            m18302h();
        }
    }

    public void open() {
        SystemUtils.log(3, C9502Util.TAG, "open", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 753);
        m18298d();
    }

    public void close() {
        SystemUtils.log(3, C9502Util.TAG, "close", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 758);
        m18296c();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("setOnClickListener: listener=", onClickListener), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 763);
        this.f25606u = onClickListener;
    }

    public void setStyle(IFWController.Style style) {
        Intrinsics.checkNotNullParameter(style, "style");
        SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("setStyle: style=", style), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 768);
        int i = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        if (i == 1) {
            this.f25603r = IFWController.Style.Grey;
            m18291a(this.f25602q);
        } else if (i == 2) {
            this.f25603r = IFWController.Style.Gradient;
            m18291a(this.f25602q);
        } else if (i == 3) {
            this.f25603r = IFWController.Style.Orange;
            m18291a(this.f25602q);
        }
    }

    public void show() {
        SystemUtils.log(3, C9502Util.TAG, "show", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 786);
        Context context = (Context) this.f25586a.get();
        if (context != null) {
            if (!C9502Util.INSTANCE.commonROMPermissionCheck(context)) {
                SystemUtils.log(3, C9502Util.TAG, "无权限, 无法展示", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 790);
                return;
            }
            this.f25583G = true;
            m18303i();
            if (!this.f25584H) {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
                    try {
                        context.registerReceiver(this.f25585I, intentFilter);
                    } catch (Exception e) {
                        Log.d("Context", "registerReceiver", e);
                    }
                    this.f25584H = true;
                } catch (Exception e2) {
                    SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("注册横竖屏监听失败, Exception=", e2), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 803);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m18303i() {
        SystemUtils.log(3, C9502Util.TAG, "myShow", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 809);
        FWView fWView = this.f25594i;
        if ((fWView == null ? null : fWView.getParent()) == null) {
            Context context = (Context) this.f25586a.get();
            if (context != null) {
                if (m18284a(context) == OrientationStateChangeCallback.OrientationState.VERTICAL) {
                    try {
                        WindowManager windowManager = this.f25587b;
                        if (windowManager != null) {
                            windowManager.addView(this.f25594i, this.f25597l);
                        }
                        SystemUtils.log(3, C9502Util.TAG, "show: 展示", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 817);
                        m18302h();
                    } catch (Exception e) {
                        SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("展示失败, Exception=", e), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 821);
                    }
                } else {
                    SystemUtils.log(3, C9502Util.TAG, "show: 横屏状态，无法展示", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 824);
                }
            }
        } else {
            SystemUtils.log(3, C9502Util.TAG, "show: 已经展示, 再展示无效", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 827);
        }
    }

    /* renamed from: a */
    private final OrientationStateChangeCallback.OrientationState m18284a(Context context) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return OrientationStateChangeCallback.OrientationState.HORIZONTAL;
        }
        return OrientationStateChangeCallback.OrientationState.VERTICAL;
    }

    public void hidden() {
        SystemUtils.log(3, C9502Util.TAG, "hidden", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 842);
        this.f25583G = false;
        m18304j();
        if (this.f25584H) {
            try {
                Context context = (Context) this.f25586a.get();
                if (context != null) {
                    try {
                        context.unregisterReceiver(this.f25585I);
                    } catch (Exception e) {
                        Log.d("Context", "unregisterReceiver", e);
                    }
                    this.f25584H = false;
                }
            } catch (Exception e2) {
                SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("注销横竖屏监听失败, Exception=", e2), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 852);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m18304j() {
        SystemUtils.log(3, C9502Util.TAG, "myHidden", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 858);
        FWView fWView = this.f25594i;
        if ((fWView == null ? null : fWView.getParent()) != null) {
            try {
                SystemUtils.log(3, C9502Util.TAG, "hidden: 隐藏", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 861);
                WindowManager windowManager = this.f25587b;
                if (windowManager != null) {
                    windowManager.removeView(this.f25594i);
                }
            } catch (Exception e) {
                SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("隐藏失败, Exception=", e), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 864);
            }
        } else {
            SystemUtils.log(3, C9502Util.TAG, "hidden: 已经隐藏, 再隐藏无效", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 867);
        }
    }

    public boolean isOpen() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.f25602q.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean isShow() {
        return this.f25583G;
    }

    public void setCarBitmap(Bitmap bitmap) {
        SystemUtils.log(3, C9502Util.TAG, "setCarBitmap", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController", 885);
        FWView fWView = this.f25594i;
        if (fWView != null) {
            fWView.setCarBitmap(bitmap);
        }
    }
}
