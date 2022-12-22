package com.didi.payment.wallet_ui.loading;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.blocks.constant.Const;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0001<B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J2\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u00020\u00162\n\b\u0002\u00105\u001a\u0004\u0018\u00010,2\b\b\u0002\u00106\u001a\u00020\u00162\n\b\u0002\u00107\u001a\u0004\u0018\u00010,J2\u00108\u001a\u0002012\b\b\u0002\u00104\u001a\u00020\u00162\n\b\u0002\u00109\u001a\u0004\u0018\u00010,2\b\b\u0002\u00106\u001a\u00020\u00162\n\b\u0002\u00107\u001a\u0004\u0018\u00010,J\u0006\u0010:\u001a\u000201J\u0012\u0010;\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000bR\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/loading/LoadingController;", "", "originalView", "Landroid/view/View;", "loadingConfig", "Lcom/didi/payment/wallet_ui/loading/ILoadingConfig;", "(Landroid/view/View;Lcom/didi/payment/wallet_ui/loading/ILoadingConfig;)V", "currentViewIndex", "", "customView", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "emptyView", "getEmptyView", "emptyView$delegate", "Lkotlin/Lazy;", "errorView", "getErrorView", "errorView$delegate", "<set-?>", "", "isCustom", "()Z", "isEmpty", "isError", "isLoading", "isOriginal", "loadingView", "getLoadingView", "loadingView$delegate", "onEmptyBtnClickListener", "Landroid/view/View$OnClickListener;", "getOnEmptyBtnClickListener", "()Landroid/view/View$OnClickListener;", "setOnEmptyBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "onErrorBtnClickListener", "getOnErrorBtnClickListener", "setOnErrorBtnClickListener", "parentView", "Landroid/view/ViewGroup;", "preEmptyButtonText", "", "preEmptyMsg", "preErrorButtonText", "preErrorMsg", "revert", "", "showCustom", "showEmpty", "showMsg", "emptyMsg", "showButton", "buttonText", "showError", "errorMsg", "showLoading", "showView", "Companion", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoadingController.kt */
public final class LoadingController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final View f33010a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ILoadingConfig f33011b;

    /* renamed from: c */
    private View.OnClickListener f33012c;

    /* renamed from: d */
    private View.OnClickListener f33013d;

    /* renamed from: e */
    private final ViewGroup f33014e;

    /* renamed from: f */
    private final int f33015f;

    /* renamed from: g */
    private final Lazy f33016g;

    /* renamed from: h */
    private final Lazy f33017h;

    /* renamed from: i */
    private final Lazy f33018i;

    /* renamed from: j */
    private boolean f33019j;

    /* renamed from: k */
    private boolean f33020k;

    /* renamed from: l */
    private boolean f33021l;

    /* renamed from: m */
    private boolean f33022m;

    /* renamed from: n */
    private boolean f33023n;

    /* renamed from: o */
    private View f33024o;

    /* renamed from: p */
    private String f33025p;

    /* renamed from: q */
    private String f33026q;

    /* renamed from: r */
    private String f33027r;

    /* renamed from: s */
    private String f33028s;

    public /* synthetic */ LoadingController(View view, ILoadingConfig iLoadingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, iLoadingConfig);
    }

    private LoadingController(View view, ILoadingConfig iLoadingConfig) {
        this.f33010a = view;
        this.f33011b = iLoadingConfig;
        this.f33016g = LazyKt.lazy(new LoadingController$loadingView$2(this));
        this.f33017h = LazyKt.lazy(new LoadingController$errorView$2(this));
        this.f33018i = LazyKt.lazy(new LoadingController$emptyView$2(this));
        boolean z = true;
        if (this.f33010a != null) {
            if (!(this.f33011b != null)) {
                throw new IllegalArgumentException("loadingConfig is null".toString());
            } else if (this.f33010a.getParent() instanceof ViewGroup) {
                ViewParent parent = this.f33010a.getParent();
                if (parent != null) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    this.f33014e = viewGroup;
                    int indexOfChild = viewGroup.indexOfChild(this.f33010a);
                    this.f33015f = indexOfChild;
                    if (!(indexOfChild == -1 ? false : z)) {
                        throw new IllegalArgumentException("cannot find originalView index from it's parent!".toString());
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            } else {
                throw new IllegalArgumentException("originalView's parentView is not ViewGroup".toString());
            }
        } else {
            throw new IllegalArgumentException("originalView is null".toString());
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/loading/LoadingController$Companion;", "", "()V", "create", "Lcom/didi/payment/wallet_ui/loading/LoadingController;", "originalView", "Landroid/view/View;", "loadingConfig", "Lcom/didi/payment/wallet_ui/loading/ILoadingConfig;", "replaceView", "", "src", "target", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LoadingController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoadingController create(View view, ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(view, "originalView");
            Intrinsics.checkNotNullParameter(iLoadingConfig, "loadingConfig");
            return new LoadingController(view, iLoadingConfig, (DefaultConstructorMarker) null);
        }

        public final void replaceView(View view, View view2) {
            int indexOfChild;
            Intrinsics.checkNotNullParameter(view, Const.BlockParamConst.SRC);
            Intrinsics.checkNotNullParameter(view2, "target");
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null && (indexOfChild = viewGroup.indexOfChild(view)) != -1) {
                viewGroup.removeViewAt(indexOfChild);
                viewGroup.addView(view2, indexOfChild, view.getLayoutParams());
            }
        }
    }

    public final View.OnClickListener getOnErrorBtnClickListener() {
        return this.f33012c;
    }

    public final void setOnErrorBtnClickListener(View.OnClickListener onClickListener) {
        this.f33012c = onClickListener;
    }

    public final View.OnClickListener getOnEmptyBtnClickListener() {
        return this.f33013d;
    }

    public final void setOnEmptyBtnClickListener(View.OnClickListener onClickListener) {
        this.f33013d = onClickListener;
    }

    /* renamed from: a */
    private final View m23208a() {
        return (View) this.f33016g.getValue();
    }

    /* renamed from: b */
    private final View m23210b() {
        return (View) this.f33017h.getValue();
    }

    /* renamed from: c */
    private final View m23211c() {
        return (View) this.f33018i.getValue();
    }

    public final boolean isLoading() {
        return this.f33019j;
    }

    public final boolean isError() {
        return this.f33020k;
    }

    public final boolean isEmpty() {
        return this.f33021l;
    }

    public final boolean isOriginal() {
        return this.f33022m;
    }

    public final boolean isCustom() {
        return this.f33023n;
    }

    public final View getCustomView() {
        return this.f33024o;
    }

    public final void setCustomView(View view) {
        this.f33024o = view;
    }

    public final void showLoading() {
        View a = m23208a();
        if (a != null) {
            View findViewById = a.findViewById(this.f33011b.getLoadingViewId());
            if ((findViewById instanceof ImageView) && (findViewById.getBackground() instanceof AnimationDrawable)) {
                Drawable background = findViewById.getBackground();
                if (background != null) {
                    ((AnimationDrawable) background).start();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                }
            }
            m23209a(m23208a());
        }
    }

    public final void revert() {
        View a;
        if (this.f33019j && (a = m23208a()) != null) {
            View findViewById = a.findViewById(this.f33011b.getLoadingViewId());
            if ((findViewById instanceof ImageView) && (findViewById.getBackground() instanceof AnimationDrawable)) {
                Drawable background = findViewById.getBackground();
                if (background != null) {
                    ((AnimationDrawable) background).stop();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                }
            }
        }
        m23209a(this.f33010a);
    }

    public static /* synthetic */ void showError$default(LoadingController loadingController, boolean z, String str, boolean z2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        loadingController.showError(z, str, z2, str2);
    }

    public final void showError(boolean z, String str, boolean z2, String str2) {
        View b = m23210b();
        View view = null;
        View findViewById = b == null ? null : b.findViewById(this.f33011b.getErrorTextId());
        if (findViewById != null) {
            if (z) {
                if (findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f33025p, (Object) str) && (findViewById instanceof TextView)) {
                    ((TextView) findViewById).setText(str);
                    this.f33025p = str;
                }
            } else if (findViewById.getVisibility() != 8) {
                findViewById.setVisibility(8);
            }
        }
        View b2 = m23210b();
        if (b2 != null) {
            view = b2.findViewById(this.f33011b.getErrorButtonId());
        }
        if (view != null) {
            if (z2) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f33026q, (Object) str2) && (view instanceof TextView)) {
                    ((TextView) view).setText(str2);
                    this.f33026q = str2;
                }
                view.setOnClickListener(getOnErrorBtnClickListener());
            } else if (view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
        m23209a(m23210b());
    }

    public static /* synthetic */ void showEmpty$default(LoadingController loadingController, boolean z, String str, boolean z2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        loadingController.showEmpty(z, str, z2, str2);
    }

    public final void showEmpty(boolean z, String str, boolean z2, String str2) {
        View c = m23211c();
        View view = null;
        View findViewById = c == null ? null : c.findViewById(this.f33011b.getEmptyTextId());
        if (findViewById != null) {
            if (z) {
                if (findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f33027r, (Object) str) && (findViewById instanceof TextView)) {
                    ((TextView) findViewById).setText(str);
                    this.f33027r = str;
                }
            } else if (findViewById.getVisibility() != 8) {
                findViewById.setVisibility(8);
            }
        }
        View c2 = m23211c();
        if (c2 != null) {
            view = c2.findViewById(this.f33011b.getEmptyButtonId());
        }
        if (view != null) {
            if (z2) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f33028s, (Object) str2) && (view instanceof TextView)) {
                    ((TextView) view).setText(str2);
                    this.f33028s = str2;
                }
                view.setOnClickListener(getOnEmptyBtnClickListener());
            } else if (view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
        m23209a(m23211c());
    }

    public final void showCustom() {
        m23209a(this.f33024o);
    }

    /* renamed from: a */
    private final void m23209a(View view) {
        if (view != null && this.f33014e.getChildAt(this.f33015f) != view) {
            this.f33014e.removeViewAt(this.f33015f);
            this.f33014e.addView(view, this.f33015f, this.f33010a.getLayoutParams());
            boolean z = true;
            this.f33019j = view == m23208a();
            this.f33020k = view == m23210b();
            this.f33021l = view == m23211c();
            this.f33022m = view == this.f33010a;
            if (view != getCustomView()) {
                z = false;
            }
            this.f33023n = z;
        }
    }
}
