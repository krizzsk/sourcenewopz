package com.didi.payment.base.utils;

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

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0001<B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J2\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u00020\u00162\n\b\u0002\u00105\u001a\u0004\u0018\u00010,2\b\b\u0002\u00106\u001a\u00020\u00162\n\b\u0002\u00107\u001a\u0004\u0018\u00010,J2\u00108\u001a\u0002012\b\b\u0002\u00104\u001a\u00020\u00162\n\b\u0002\u00109\u001a\u0004\u0018\u00010,2\b\b\u0002\u00106\u001a\u00020\u00162\n\b\u0002\u00107\u001a\u0004\u0018\u00010,J\u0006\u0010:\u001a\u000201J\u0012\u0010;\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000bR\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, mo175978d2 = {"Lcom/didi/payment/base/utils/LoadingController;", "", "originalView", "Landroid/view/View;", "loadingConfig", "Lcom/didi/payment/base/utils/ILoadingConfig;", "(Landroid/view/View;Lcom/didi/payment/base/utils/ILoadingConfig;)V", "currentViewIndex", "", "customView", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "emptyView", "getEmptyView", "emptyView$delegate", "Lkotlin/Lazy;", "errorView", "getErrorView", "errorView$delegate", "<set-?>", "", "isCustom", "()Z", "isEmpty", "isError", "isLoading", "isOriginal", "loadingView", "getLoadingView", "loadingView$delegate", "onEmptyBtnClickListener", "Landroid/view/View$OnClickListener;", "getOnEmptyBtnClickListener", "()Landroid/view/View$OnClickListener;", "setOnEmptyBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "onErrorBtnClickListener", "getOnErrorBtnClickListener", "setOnErrorBtnClickListener", "parentView", "Landroid/view/ViewGroup;", "preEmptyButtonText", "", "preEmptyMsg", "preErrorButtonText", "preErrorMsg", "revert", "", "showCustom", "showEmpty", "showMsg", "emptyMsg", "showButton", "buttonText", "showError", "errorMsg", "showLoading", "showView", "Companion", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoadingController.kt */
public final class LoadingController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final View f29990a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ILoadingConfig f29991b;

    /* renamed from: c */
    private View.OnClickListener f29992c;

    /* renamed from: d */
    private View.OnClickListener f29993d;

    /* renamed from: e */
    private final ViewGroup f29994e;

    /* renamed from: f */
    private final int f29995f;

    /* renamed from: g */
    private final Lazy f29996g;

    /* renamed from: h */
    private final Lazy f29997h;

    /* renamed from: i */
    private final Lazy f29998i;

    /* renamed from: j */
    private boolean f29999j;

    /* renamed from: k */
    private boolean f30000k;

    /* renamed from: l */
    private boolean f30001l;

    /* renamed from: m */
    private boolean f30002m;

    /* renamed from: n */
    private boolean f30003n;

    /* renamed from: o */
    private View f30004o;

    /* renamed from: p */
    private String f30005p;

    /* renamed from: q */
    private String f30006q;

    /* renamed from: r */
    private String f30007r;

    /* renamed from: s */
    private String f30008s;

    public /* synthetic */ LoadingController(View view, ILoadingConfig iLoadingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, iLoadingConfig);
    }

    private LoadingController(View view, ILoadingConfig iLoadingConfig) {
        this.f29990a = view;
        this.f29991b = iLoadingConfig;
        this.f29996g = LazyKt.lazy(new LoadingController$loadingView$2(this));
        this.f29997h = LazyKt.lazy(new LoadingController$errorView$2(this));
        this.f29998i = LazyKt.lazy(new LoadingController$emptyView$2(this));
        boolean z = true;
        if (this.f29990a != null) {
            if (!(this.f29991b != null)) {
                throw new IllegalArgumentException("loadingConfig is null".toString());
            } else if (this.f29990a.getParent() instanceof ViewGroup) {
                ViewParent parent = this.f29990a.getParent();
                if (parent != null) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    this.f29994e = viewGroup;
                    int indexOfChild = viewGroup.indexOfChild(this.f29990a);
                    this.f29995f = indexOfChild;
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

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/base/utils/LoadingController$Companion;", "", "()V", "create", "Lcom/didi/payment/base/utils/LoadingController;", "originalView", "Landroid/view/View;", "loadingConfig", "Lcom/didi/payment/base/utils/ILoadingConfig;", "replaceView", "", "src", "target", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
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
        return this.f29992c;
    }

    public final void setOnErrorBtnClickListener(View.OnClickListener onClickListener) {
        this.f29992c = onClickListener;
    }

    public final View.OnClickListener getOnEmptyBtnClickListener() {
        return this.f29993d;
    }

    public final void setOnEmptyBtnClickListener(View.OnClickListener onClickListener) {
        this.f29993d = onClickListener;
    }

    /* renamed from: a */
    private final View m21007a() {
        return (View) this.f29996g.getValue();
    }

    /* renamed from: b */
    private final View m21009b() {
        return (View) this.f29997h.getValue();
    }

    /* renamed from: c */
    private final View m21010c() {
        return (View) this.f29998i.getValue();
    }

    public final boolean isLoading() {
        return this.f29999j;
    }

    public final boolean isError() {
        return this.f30000k;
    }

    public final boolean isEmpty() {
        return this.f30001l;
    }

    public final boolean isOriginal() {
        return this.f30002m;
    }

    public final boolean isCustom() {
        return this.f30003n;
    }

    public final View getCustomView() {
        return this.f30004o;
    }

    public final void setCustomView(View view) {
        this.f30004o = view;
    }

    public final void showLoading() {
        View a = m21007a();
        if (a != null) {
            View findViewById = a.findViewById(this.f29991b.getLoadingViewId());
            if ((findViewById instanceof ImageView) && (findViewById.getBackground() instanceof AnimationDrawable)) {
                Drawable background = findViewById.getBackground();
                if (background != null) {
                    ((AnimationDrawable) background).start();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                }
            }
            m21008a(m21007a());
        }
    }

    public final void revert() {
        View a;
        if (this.f29999j && (a = m21007a()) != null) {
            View findViewById = a.findViewById(this.f29991b.getLoadingViewId());
            if ((findViewById instanceof ImageView) && (findViewById.getBackground() instanceof AnimationDrawable)) {
                Drawable background = findViewById.getBackground();
                if (background != null) {
                    ((AnimationDrawable) background).stop();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                }
            }
        }
        m21008a(this.f29990a);
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
        View b = m21009b();
        View view = null;
        View findViewById = b == null ? null : b.findViewById(this.f29991b.getErrorTextId());
        if (findViewById != null) {
            if (z) {
                if (findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f30005p, (Object) str) && (findViewById instanceof TextView)) {
                    ((TextView) findViewById).setText(str);
                    this.f30005p = str;
                }
            } else if (findViewById.getVisibility() != 8) {
                findViewById.setVisibility(8);
            }
        }
        View b2 = m21009b();
        if (b2 != null) {
            view = b2.findViewById(this.f29991b.getErrorButtonId());
        }
        if (view != null) {
            if (z2) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f30006q, (Object) str2) && (view instanceof TextView)) {
                    ((TextView) view).setText(str2);
                    this.f30006q = str2;
                }
                view.setOnClickListener(getOnErrorBtnClickListener());
            } else if (view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
        m21008a(m21009b());
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
        View c = m21010c();
        View view = null;
        View findViewById = c == null ? null : c.findViewById(this.f29991b.getEmptyTextId());
        if (findViewById != null) {
            if (z) {
                if (findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f30007r, (Object) str) && (findViewById instanceof TextView)) {
                    ((TextView) findViewById).setText(str);
                    this.f30007r = str;
                }
            } else if (findViewById.getVisibility() != 8) {
                findViewById.setVisibility(8);
            }
        }
        View c2 = m21010c();
        if (c2 != null) {
            view = c2.findViewById(this.f29991b.getEmptyButtonId());
        }
        if (view != null) {
            if (z2) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f30008s, (Object) str2) && (view instanceof TextView)) {
                    ((TextView) view).setText(str2);
                    this.f30008s = str2;
                }
                view.setOnClickListener(getOnEmptyBtnClickListener());
            } else if (view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
        m21008a(m21010c());
    }

    public final void showCustom() {
        m21008a(this.f30004o);
    }

    /* renamed from: a */
    private final void m21008a(View view) {
        if (view != null && this.f29994e.getChildAt(this.f29995f) != view) {
            this.f29994e.removeViewAt(this.f29995f);
            this.f29994e.addView(view, this.f29995f, this.f29990a.getLayoutParams());
            boolean z = true;
            this.f29999j = view == m21007a();
            this.f30000k = view == m21009b();
            this.f30001l = view == m21010c();
            this.f30002m = view == this.f29990a;
            if (view != getCustomView()) {
                z = false;
            }
            this.f30003n = z;
        }
    }
}
