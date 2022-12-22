package com.didi.rfusion.widget.push;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.app.nova.skeleton.Page;
import com.didi.rfusion.utils.RFSystemBarUtils;
import com.didi.rfusion.utils.ext.RFActivityExtKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rui.config.RConfigConstants;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\n*\u0001\u0011\u0018\u0000 32\u00020\u0001:\u0003234B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010$\u001a\u00020\u00192\b\b\u0001\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010)\u001a\u00020\u00192\b\b\u0001\u0010'\u001a\u00020(J\u0010\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\nJ\u0010\u0010.\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\fJ\u0010\u0010/\u001a\u00020\u00192\b\b\u0001\u00100\u001a\u00020(J\u0006\u00101\u001a\u00020\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lcom/didi/rfusion/widget/push/RFPush;", "", "builder", "Lcom/didi/rfusion/widget/push/RFPush$Builder;", "(Lcom/didi/rfusion/widget/push/RFPush$Builder;)V", "countDownCallback", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "onClickListener", "Landroid/view/View$OnClickListener;", "onDismissListener", "Lcom/didi/rfusion/widget/push/RFPush$OnDismissListener;", "pushShowCallback", "pushView", "Lcom/didi/rfusion/widget/push/RFPushView;", "pushViewDismissListener", "com/didi/rfusion/widget/push/RFPush$pushViewDismissListener$1", "Lcom/didi/rfusion/widget/push/RFPush$pushViewDismissListener$1;", "pushViewOnClickListener", "rootView", "Landroid/view/ViewGroup;", "wm", "Landroid/view/WindowManager;", "addPushView", "", "dismiss", "initView", "initViewByActivity", "activity", "Landroid/app/Activity;", "initViewByContext", "context", "Landroid/content/Context;", "initViewByWindow", "removePushView", "setIcon", "icon", "Landroid/graphics/drawable/Drawable;", "resId", "", "setMessage", "text", "", "setOnClickListener", "listener", "setOnDismissListener", "setType", "type", "show", "Builder", "Companion", "OnDismissListener", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFPush.kt */
public final class RFPush {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: k */
    private static final long f33661k = 3000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RFPushView f33662a;

    /* renamed from: b */
    private final Handler f33663b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ViewGroup f33664c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WindowManager f33665d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnDismissListener f33666e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f33667f;

    /* renamed from: g */
    private final View.OnClickListener f33668g;

    /* renamed from: h */
    private final RFPush$pushViewDismissListener$1 f33669h;

    /* renamed from: i */
    private final Runnable f33670i;

    /* renamed from: j */
    private final Runnable f33671j;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/rfusion/widget/push/RFPush$OnDismissListener;", "", "onDismiss", "", "push", "Lcom/didi/rfusion/widget/push/RFPush;", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFPush.kt */
    public interface OnDismissListener {
        void onDismiss(RFPush rFPush);
    }

    private RFPush(Builder builder) {
        this.f33663b = new Handler(Looper.getMainLooper());
        this.f33668g = new RFPush$pushViewOnClickListener$1(this, builder);
        this.f33669h = new RFPush$pushViewDismissListener$1(this);
        this.f33670i = new RFPush$pushShowCallback$1(this);
        this.f33671j = new RFPush$countDownCallback$1(this);
        m23714a(builder);
        if (builder.getIcon$r_fusion_ninePhoneRelease() != null) {
            setIcon(builder.getIcon$r_fusion_ninePhoneRelease());
        }
        if (builder.getIconId$r_fusion_ninePhoneRelease() != null) {
            Integer iconId$r_fusion_ninePhoneRelease = builder.getIconId$r_fusion_ninePhoneRelease();
            if (iconId$r_fusion_ninePhoneRelease == null) {
                Intrinsics.throwNpe();
            }
            setIcon(iconId$r_fusion_ninePhoneRelease.intValue());
        }
        if (builder.getType$r_fusion_ninePhoneRelease() != null) {
            Integer type$r_fusion_ninePhoneRelease = builder.getType$r_fusion_ninePhoneRelease();
            if (type$r_fusion_ninePhoneRelease == null) {
                Intrinsics.throwNpe();
            }
            setType(type$r_fusion_ninePhoneRelease.intValue());
        }
        if (builder.getMessage$r_fusion_ninePhoneRelease() != null) {
            setMessage(builder.getMessage$r_fusion_ninePhoneRelease());
        }
        if (builder.getMessageId$r_fusion_ninePhoneRelease() != null) {
            Integer messageId$r_fusion_ninePhoneRelease = builder.getMessageId$r_fusion_ninePhoneRelease();
            if (messageId$r_fusion_ninePhoneRelease == null) {
                Intrinsics.throwNpe();
            }
            setMessage(messageId$r_fusion_ninePhoneRelease.intValue());
        }
        setOnClickListener(builder.getClickListener$r_fusion_ninePhoneRelease());
        setOnDismissListener(builder.getDismissListener$r_fusion_ninePhoneRelease());
    }

    public /* synthetic */ RFPush(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public static final /* synthetic */ RFPushView access$getPushView$p(RFPush rFPush) {
        RFPushView rFPushView = rFPush.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        return rFPushView;
    }

    /* renamed from: a */
    private final void m23714a(Builder builder) {
        if (builder.getActivity$r_fusion_ninePhoneRelease() != null) {
            Activity activity$r_fusion_ninePhoneRelease = builder.getActivity$r_fusion_ninePhoneRelease();
            if (activity$r_fusion_ninePhoneRelease == null) {
                Intrinsics.throwNpe();
            }
            m23712a(activity$r_fusion_ninePhoneRelease);
        } else if (builder.getContext$r_fusion_ninePhoneRelease() != null) {
            Context context$r_fusion_ninePhoneRelease = builder.getContext$r_fusion_ninePhoneRelease();
            if (context$r_fusion_ninePhoneRelease == null) {
                Intrinsics.throwNpe();
            }
            m23713a(context$r_fusion_ninePhoneRelease);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        marginLayoutParams.topMargin = RFSystemBarUtils.getStatusBarHeight(rFPushView.getContext());
        RFPushView rFPushView2 = this.f33662a;
        if (rFPushView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView2.setLayoutParams(marginLayoutParams);
        RFPushView rFPushView3 = this.f33662a;
        if (rFPushView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView3.setVisibility(4);
        RFPushView rFPushView4 = this.f33662a;
        if (rFPushView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView4.setOnClickListener(this.f33668g);
        RFPushView rFPushView5 = this.f33662a;
        if (rFPushView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView5.setOnDismissListener(this.f33669h);
    }

    /* renamed from: a */
    private final void m23713a(Context context) {
        if (context instanceof Activity) {
            m23712a((Activity) context);
        } else {
            m23716b(context);
        }
    }

    /* renamed from: a */
    private final void m23712a(Activity activity) {
        this.f33662a = new RFPushView(activity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.f33664c = RFActivityExtKt.getRootView(activity);
    }

    /* renamed from: b */
    private final void m23716b(Context context) {
        this.f33662a = new RFPushView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            this.f33665d = (WindowManager) systemService;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    /* renamed from: a */
    private final void m23711a() {
        ViewGroup viewGroup = this.f33664c;
        if (viewGroup != null) {
            RFPushView rFPushView = this.f33662a;
            if (rFPushView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pushView");
            }
            viewGroup.addView(rFPushView);
            return;
        }
        WindowManager windowManager = this.f33665d;
        if (windowManager != null) {
            RFPushView rFPushView2 = this.f33662a;
            if (rFPushView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pushView");
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2, 128, -3);
            layoutParams.gravity = 51;
            windowManager.addView(rFPushView2, layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m23715b() {
        ViewGroup viewGroup = this.f33664c;
        if (viewGroup != null) {
            RFPushView rFPushView = this.f33662a;
            if (rFPushView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pushView");
            }
            viewGroup.removeView(rFPushView);
            return;
        }
        WindowManager windowManager = this.f33665d;
        if (windowManager != null) {
            RFPushView rFPushView2 = this.f33662a;
            if (rFPushView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pushView");
            }
            windowManager.removeView(rFPushView2);
        }
    }

    public final void setIcon(Drawable drawable) {
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView.setIcon(drawable);
    }

    public final void setIcon(int i) {
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView.setIcon(i);
    }

    public final void setType(int i) {
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView.setType(i);
    }

    public final void setMessage(int i) {
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView.setText(i);
    }

    public final void setMessage(CharSequence charSequence) {
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        rFPushView.setText(charSequence);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f33667f = onClickListener;
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f33666e = onDismissListener;
    }

    public final void show() {
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        if (rFPushView.getParent() == null) {
            m23711a();
            this.f33663b.removeCallbacks(this.f33670i);
            this.f33663b.post(this.f33670i);
            this.f33663b.removeCallbacks(this.f33671j);
            this.f33663b.postDelayed(this.f33671j, 3000);
        }
    }

    public final void dismiss() {
        this.f33663b.removeCallbacks(this.f33670i);
        this.f33663b.removeCallbacks(this.f33671j);
        RFPushView rFPushView = this.f33662a;
        if (rFPushView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushView");
        }
        if (rFPushView.getParent() != null) {
            RFPushView rFPushView2 = this.f33662a;
            if (rFPushView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pushView");
            }
            rFPushView2.dismiss();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020(J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u001bJ\u0010\u0010C\u001a\u00020\u00002\b\b\u0001\u0010E\u001a\u00020!J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020.J\u0010\u0010F\u001a\u00020\u00002\b\b\u0001\u0010E\u001a\u00020!J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\fJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u0015J\u0010\u0010K\u001a\u00020\u00002\b\b\u0001\u0010<\u001a\u00020!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u0004\u0018\u00010!8\u0000@\u0000X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%¨\u0006L"}, mo175978d2 = {"Lcom/didi/rfusion/widget/push/RFPush$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity$r_fusion_ninePhoneRelease", "()Landroid/app/Activity;", "setActivity$r_fusion_ninePhoneRelease", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener$r_fusion_ninePhoneRelease", "()Landroid/view/View$OnClickListener;", "setClickListener$r_fusion_ninePhoneRelease", "(Landroid/view/View$OnClickListener;)V", "getContext$r_fusion_ninePhoneRelease", "()Landroid/content/Context;", "setContext$r_fusion_ninePhoneRelease", "dismissListener", "Lcom/didi/rfusion/widget/push/RFPush$OnDismissListener;", "getDismissListener$r_fusion_ninePhoneRelease", "()Lcom/didi/rfusion/widget/push/RFPush$OnDismissListener;", "setDismissListener$r_fusion_ninePhoneRelease", "(Lcom/didi/rfusion/widget/push/RFPush$OnDismissListener;)V", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon$r_fusion_ninePhoneRelease", "()Landroid/graphics/drawable/Drawable;", "setIcon$r_fusion_ninePhoneRelease", "(Landroid/graphics/drawable/Drawable;)V", "iconId", "", "getIconId$r_fusion_ninePhoneRelease", "()Ljava/lang/Integer;", "setIconId$r_fusion_ninePhoneRelease", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isDismissible", "", "isDismissible$r_fusion_ninePhoneRelease", "()Z", "setDismissible$r_fusion_ninePhoneRelease", "(Z)V", "message", "", "getMessage$r_fusion_ninePhoneRelease", "()Ljava/lang/CharSequence;", "setMessage$r_fusion_ninePhoneRelease", "(Ljava/lang/CharSequence;)V", "messageId", "getMessageId$r_fusion_ninePhoneRelease", "setMessageId$r_fusion_ninePhoneRelease", "page", "Lcom/didi/app/nova/skeleton/Page;", "getPage$r_fusion_ninePhoneRelease", "()Lcom/didi/app/nova/skeleton/Page;", "setPage$r_fusion_ninePhoneRelease", "(Lcom/didi/app/nova/skeleton/Page;)V", "type", "getType$r_fusion_ninePhoneRelease", "setType$r_fusion_ninePhoneRelease", "build", "Lcom/didi/rfusion/widget/push/RFPush;", "setDismissible", "dismissible", "setIcon", "drawable", "resId", "setMessage", "text", "setOnClickListener", "listener", "setOnDismissListener", "setType", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFPush.kt */
    public static final class Builder {
        private Activity activity;
        private View.OnClickListener clickListener;
        private Context context;
        private OnDismissListener dismissListener;
        private Drawable icon;
        private Integer iconId;
        private boolean isDismissible;
        private CharSequence message;
        private Integer messageId;
        private Page page;
        private Integer type;

        public final Context getContext$r_fusion_ninePhoneRelease() {
            return this.context;
        }

        public final void setContext$r_fusion_ninePhoneRelease(Context context2) {
            this.context = context2;
        }

        public final Activity getActivity$r_fusion_ninePhoneRelease() {
            return this.activity;
        }

        public final void setActivity$r_fusion_ninePhoneRelease(Activity activity2) {
            this.activity = activity2;
        }

        public final Page getPage$r_fusion_ninePhoneRelease() {
            return this.page;
        }

        public final void setPage$r_fusion_ninePhoneRelease(Page page2) {
            this.page = page2;
        }

        public Builder(Context context2) {
            Intrinsics.checkParameterIsNotNull(context2, "context");
            this.context = context2;
        }

        public Builder(Activity activity2) {
            Intrinsics.checkParameterIsNotNull(activity2, "activity");
            this.activity = activity2;
        }

        public final Integer getIconId$r_fusion_ninePhoneRelease() {
            return this.iconId;
        }

        public final void setIconId$r_fusion_ninePhoneRelease(Integer num) {
            this.iconId = num;
        }

        public final Drawable getIcon$r_fusion_ninePhoneRelease() {
            return this.icon;
        }

        public final void setIcon$r_fusion_ninePhoneRelease(Drawable drawable) {
            this.icon = drawable;
        }

        public final Integer getMessageId$r_fusion_ninePhoneRelease() {
            return this.messageId;
        }

        public final void setMessageId$r_fusion_ninePhoneRelease(Integer num) {
            this.messageId = num;
        }

        public final CharSequence getMessage$r_fusion_ninePhoneRelease() {
            return this.message;
        }

        public final void setMessage$r_fusion_ninePhoneRelease(CharSequence charSequence) {
            this.message = charSequence;
        }

        public final Integer getType$r_fusion_ninePhoneRelease() {
            return this.type;
        }

        public final void setType$r_fusion_ninePhoneRelease(Integer num) {
            this.type = num;
        }

        public final View.OnClickListener getClickListener$r_fusion_ninePhoneRelease() {
            return this.clickListener;
        }

        public final void setClickListener$r_fusion_ninePhoneRelease(View.OnClickListener onClickListener) {
            this.clickListener = onClickListener;
        }

        public final OnDismissListener getDismissListener$r_fusion_ninePhoneRelease() {
            return this.dismissListener;
        }

        public final void setDismissListener$r_fusion_ninePhoneRelease(OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
        }

        public final boolean isDismissible$r_fusion_ninePhoneRelease() {
            return this.isDismissible;
        }

        public final void setDismissible$r_fusion_ninePhoneRelease(boolean z) {
            this.isDismissible = z;
        }

        public final Builder setIcon(Drawable drawable) {
            Intrinsics.checkParameterIsNotNull(drawable, RConfigConstants.TYPE_DRAWABLE);
            this.icon = drawable;
            this.iconId = null;
            return this;
        }

        public final Builder setIcon(int i) {
            this.iconId = Integer.valueOf(i);
            this.icon = null;
            return this;
        }

        public final Builder setType(int i) {
            this.type = Integer.valueOf(i);
            return this;
        }

        public final Builder setMessage(int i) {
            this.messageId = Integer.valueOf(i);
            this.message = null;
            return this;
        }

        public final Builder setMessage(CharSequence charSequence) {
            Intrinsics.checkParameterIsNotNull(charSequence, "text");
            this.message = charSequence;
            this.messageId = null;
            return this;
        }

        public final Builder setOnClickListener(View.OnClickListener onClickListener) {
            Intrinsics.checkParameterIsNotNull(onClickListener, "listener");
            this.clickListener = onClickListener;
            return this;
        }

        public final Builder setOnDismissListener(OnDismissListener onDismissListener) {
            Intrinsics.checkParameterIsNotNull(onDismissListener, "listener");
            this.dismissListener = onDismissListener;
            return this;
        }

        public final Builder setDismissible(boolean z) {
            this.isDismissible = z;
            return this;
        }

        public final RFPush build() {
            return new RFPush(this, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/rfusion/widget/push/RFPush$Companion;", "", "()V", "DISMISS_DURATION", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFPush.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
