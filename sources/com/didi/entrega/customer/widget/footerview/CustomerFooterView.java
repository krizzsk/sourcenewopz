package com.didi.entrega.customer.widget.footerview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.component.feed.base.FooterViewIView;
import com.didi.entrega.customer.mvp.loadmore.LoadMoreModel;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002JV\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'J&\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0014J\u0010\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u000101J\u0010\u00102\u001a\u00020\u001a2\b\b\u0001\u00103\u001a\u00020\u0007J\u0006\u00104\u001a\u00020\u001aJ\u0006\u00105\u001a\u00020\u001aJ\u0010\u00106\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u000101J\u0006\u00107\u001a\u00020\u001aJ\u0010\u00108\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u000101J\u0010\u00109\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010;R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, mo175978d2 = {"Lcom/didi/entrega/customer/widget/footerview/CustomerFooterView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cartStubView", "Landroid/view/View;", "getCartStubView", "()Landroid/view/View;", "setCartStubView", "(Landroid/view/View;)V", "mButtonTextView", "Landroid/widget/TextView;", "mFootViewState", "mFooterDescTv", "mFooterMode", "Lcom/didi/entrega/customer/component/feed/base/FooterViewIView$Mode;", "mFooterRooter", "mLoadingStubView", "mLoadingView", "Lcom/didi/entrega/customer/widget/loading/LottieLoadingView;", "initView", "", "refreshView", "loadingStubVisible", "loadingViewVisible", "footerDescVisible", "buttonTextVisible", "footerMiniHeight", "isStartLoadingView", "", "isEnable", "loginV2LayoutVisible", "setFooterClickListener", "listener", "Landroid/view/View$OnClickListener;", "setFooterPadding", "left", "top", "right", "bottom", "setFooterType", "mode", "setText", "txt", "", "setTextColor", "textColor", "showEmptyView", "showErrorLoadingView", "showErrorView", "showLoadingView", "showNoMoreView", "updateView", "item", "Lcom/didi/entrega/customer/mvp/loadmore/LoadMoreModel;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFooterView.kt */
public final class CustomerFooterView extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ERROR = 4;
    public static final int ERROR_LOADING = 6;
    public static final int LOADING = 1;
    public static final int NORMAL = 0;
    public static final int NO_MORE = 2;
    public static final int PADDING_124_DP = 124;
    public static final int PADDING_16_DP = 16;
    public static final int PADDING_200_DP = 200;
    public static final int PADDING_28_DP = 28;
    public static final int PADDING_30_DP = 30;
    public static final int PADDING_400_DP = 400;
    public static final int PADDING_46_DP = 46;

    /* renamed from: a */
    private int f20452a;

    /* renamed from: b */
    private LinearLayout f20453b;

    /* renamed from: c */
    private TextView f20454c;

    /* renamed from: d */
    private LottieLoadingView f20455d;

    /* renamed from: e */
    private View f20456e;

    /* renamed from: f */
    private TextView f20457f;

    /* renamed from: g */
    private View f20458g;

    /* renamed from: h */
    private FooterViewIView.Mode f20459h;

    public CustomerFooterView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public CustomerFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerFooterView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public CustomerFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20459h = FooterViewIView.Mode.SIMPLE;
        m14969a();
    }

    public final View getCartStubView() {
        return this.f20458g;
    }

    public final void setCartStubView(View view) {
        this.f20458g = view;
    }

    public final void setFooterClickListener(View.OnClickListener onClickListener) {
        if (this.f20452a == 4) {
            TextView textView = this.f20457f;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
                return;
            }
            return;
        }
        setOnClickListener(onClickListener);
    }

    public final void setFooterPadding(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout = this.f20453b;
        if (linearLayout != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }

    public final void setFooterType(FooterViewIView.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, ParamKeys.PARAM_MODE);
        this.f20459h = mode;
    }

    public final void setText(String str) {
        TextView textView = this.f20454c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setTextColor(int i) {
        TextView textView = this.f20454c;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public final void showEmptyView() {
        refreshView$default(this, 0, 0, 0, 0, 0, false, false, 0, 251, (Object) null);
        TextView textView = this.f20454c;
        if (textView != null) {
            textView.setText("");
        }
    }

    public final void showErrorView(String str) {
        refreshView$default(this, 0, 0, 0, 0, DisplayUtils.dip2px(getContext(), 104.0f), false, false, 0, 227, (Object) null);
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.FoodC_orderlist4_Unable_to_TINP);
        }
        TextView textView = this.f20454c;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f20457f;
        if (textView2 != null) {
            textView2.setText(getResources().getText(R.string.FoodC_orderlist3_Try_again_HqaK));
        }
    }

    public final void showLoadingView() {
        refreshView$default(this, 0, 0, 0, 0, 0, true, false, 0, 221, (Object) null);
    }

    public final void showNoMoreView(String str) {
        refreshView$default(this, 0, 0, 0, 0, 0, false, true, 0, 187, (Object) null);
        TextView textView = this.f20454c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void showErrorLoadingView() {
        refreshView$default(this, 0, 0, 0, 0, DisplayUtils.dip2px(getContext(), 104.0f), true, false, 0, 204, (Object) null);
    }

    public static /* synthetic */ void refreshView$default(CustomerFooterView customerFooterView, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = 8;
        }
        if ((i7 & 2) != 0) {
            i2 = 8;
        }
        if ((i7 & 4) != 0) {
            i3 = 8;
        }
        if ((i7 & 8) != 0) {
            i4 = 8;
        }
        if ((i7 & 16) != 0) {
            i5 = 0;
        }
        if ((i7 & 32) != 0) {
            z = false;
        }
        if ((i7 & 64) != 0) {
            z2 = false;
        }
        if ((i7 & 128) != 0) {
            i6 = 8;
        }
        customerFooterView.refreshView(i, i2, i3, i4, i5, z, z2, i6);
    }

    public final void refreshView(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6) {
        View view = this.f20456e;
        if (view != null) {
            view.setVisibility(i);
        }
        LottieLoadingView lottieLoadingView = this.f20455d;
        if (lottieLoadingView != null) {
            lottieLoadingView.setVisibility(i2);
        }
        LottieLoadingView lottieLoadingView2 = this.f20455d;
        if (lottieLoadingView2 != null) {
            if (z) {
                lottieLoadingView2.start();
            } else {
                lottieLoadingView2.stop();
            }
        }
        TextView textView = this.f20454c;
        if (textView != null) {
            textView.setVisibility(i3);
        }
        TextView textView2 = this.f20457f;
        if (textView2 != null) {
            textView2.setVisibility(i4);
        }
        LinearLayout linearLayout = this.f20453b;
        if (linearLayout != null) {
            linearLayout.setMinimumHeight(i5);
        }
        setEnabled(z2);
    }

    public final void updateView(LoadMoreModel loadMoreModel) {
        if (loadMoreModel != null) {
            int i = loadMoreModel.mState;
            String str = loadMoreModel.mDescription;
            if (str == null) {
                str = "";
            }
            this.f20452a = i;
            if (i == 0) {
                showEmptyView();
            } else if (i == 1) {
                showLoadingView();
            } else if (i == 2) {
                showNoMoreView(str);
            } else if (i == 4) {
                showErrorView(str);
            } else if (i == 6) {
                showErrorLoadingView();
            }
        }
    }

    /* renamed from: a */
    private final void m14969a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.entrega_widget_footer_view, this, true);
        this.f20453b = (LinearLayout) inflate.findViewById(R.id.ll_footer);
        this.f20455d = (LottieLoadingView) inflate.findViewById(R.id.loading_dot_view);
        this.f20456e = inflate.findViewById(R.id.customer_footer_view_loading_stub);
        this.f20454c = (TextView) inflate.findViewById(R.id.tv_footer_desc);
        this.f20457f = (TextView) inflate.findViewById(R.id.tv_footer_button_text);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f20454c, IToolsService.FontType.LIGHT);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f20457f, IToolsService.FontType.MEDIUM);
        this.f20458g = inflate.findViewById(R.id.customer_footer_view_cart_stub);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/customer/widget/footerview/CustomerFooterView$Companion;", "", "()V", "ERROR", "", "ERROR_LOADING", "LOADING", "NORMAL", "NO_MORE", "PADDING_124_DP", "PADDING_16_DP", "PADDING_200_DP", "PADDING_28_DP", "PADDING_30_DP", "PADDING_400_DP", "PADDING_46_DP", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerFooterView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
