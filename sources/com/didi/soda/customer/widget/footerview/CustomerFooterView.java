package com.didi.soda.customer.widget.footerview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.mvp.loadmore.LoadMoreModel;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 D2\u00020\u0001:\u0001DB'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020!H\u0002JV\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0007J\u0010\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.J&\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u000e\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u0014J\u0010\u00106\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u000108J\u0010\u00109\u001a\u00020!2\b\b\u0001\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020!J\u0006\u0010<\u001a\u00020!J\u0010\u0010=\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u000108J\u0006\u0010>\u001a\u00020!J\u0010\u0010?\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u000108J\u0010\u0010@\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0010\u0010C\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010BR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/footerview/CustomerFooterView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cartStubView", "Landroid/view/View;", "getCartStubView", "()Landroid/view/View;", "setCartStubView", "(Landroid/view/View;)V", "mButtonTextView", "Landroid/widget/TextView;", "mFootViewState", "mFooterDescTv", "mFooterMode", "Lcom/didi/soda/customer/component/feed/base/FooterViewIView$Mode;", "mFooterRooter", "mLoadingStubView", "mLoadingView", "Lcom/didi/soda/customer/widget/loading/LottieLoadingView;", "mLoginV2Btn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "mLoginV2Img", "Landroid/widget/ImageView;", "mLoginV2Layout", "mLoginV2Space", "mLoginV2Tv", "initView", "", "refreshView", "loadingStubVisible", "loadingViewVisible", "footerDescVisible", "buttonTextVisible", "footerMiniHeight", "isStartLoadingView", "", "isEnable", "loginV2LayoutVisible", "setFooterClickListener", "listener", "Landroid/view/View$OnClickListener;", "setFooterPadding", "left", "top", "right", "bottom", "setFooterType", "mode", "setText", "txt", "", "setTextColor", "textColor", "showEmptyView", "showErrorLoadingView", "showErrorView", "showLoadingView", "showNoMoreView", "showSignInView", "item", "Lcom/didi/soda/customer/mvp/loadmore/LoadMoreModel;", "updateView", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
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
    public static final int SIGNIN = 5;

    /* renamed from: a */
    private int f41801a;

    /* renamed from: b */
    private LinearLayout f41802b;

    /* renamed from: c */
    private TextView f41803c;

    /* renamed from: d */
    private LottieLoadingView f41804d;

    /* renamed from: e */
    private View f41805e;

    /* renamed from: f */
    private TextView f41806f;

    /* renamed from: g */
    private View f41807g;

    /* renamed from: h */
    private FooterViewIView.Mode f41808h;

    /* renamed from: i */
    private TextView f41809i;

    /* renamed from: j */
    private View f41810j;

    /* renamed from: k */
    private ImageView f41811k;

    /* renamed from: l */
    private RFMainButton f41812l;

    /* renamed from: m */
    private View f41813m;

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
        this.f41808h = FooterViewIView.Mode.SIMPLE;
        m29500a();
    }

    public final View getCartStubView() {
        return this.f41807g;
    }

    public final void setCartStubView(View view) {
        this.f41807g = view;
    }

    public final void setFooterClickListener(View.OnClickListener onClickListener) {
        int i = this.f41801a;
        if (i == 5 || i == 4) {
            TextView textView = this.f41806f;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
            $$Lambda$CustomerFooterView$YOQ8na_ftbgakADEuRZiZEOSSug r0 = new View.OnClickListener() {
                public final void onClick(View view) {
                    CustomerFooterView.m29501a(View.OnClickListener.this, view);
                }
            };
            View view = this.f41810j;
            if (view != null) {
                view.setOnClickListener(r0);
            }
            RFMainButton rFMainButton = this.f41812l;
            if (rFMainButton != null) {
                rFMainButton.setOnClickListener(r0);
                return;
            }
            return;
        }
        setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29501a(View.OnClickListener onClickListener, View view) {
        HomeOmegaHelper.getInstance().traceHomeBottomLoginCK();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void setFooterPadding(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout = this.f41802b;
        if (linearLayout != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }

    public final void setFooterType(FooterViewIView.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, ParamKeys.PARAM_MODE);
        this.f41808h = mode;
    }

    public final void setText(String str) {
        TextView textView = this.f41803c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setTextColor(int i) {
        TextView textView = this.f41803c;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public final void showEmptyView() {
        refreshView$default(this, 0, 0, 0, 0, 0, false, false, 0, 251, (Object) null);
        TextView textView = this.f41803c;
        if (textView != null) {
            textView.setText("");
        }
    }

    public final void showErrorView(String str) {
        refreshView$default(this, 0, 0, 0, 0, DisplayUtils.dip2px(getContext(), 104.0f), false, false, 0, 227, (Object) null);
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.footer_load_error);
        }
        TextView textView = this.f41803c;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f41806f;
        if (textView2 != null) {
            textView2.setText(getResources().getText(R.string.customer_try_again));
        }
    }

    public final void showLoadingView() {
        refreshView$default(this, 0, 0, 0, 0, 0, true, false, 0, 221, (Object) null);
    }

    public final void showNoMoreView(String str) {
        refreshView$default(this, 0, 0, 0, 0, 0, false, true, 0, 187, (Object) null);
        TextView textView = this.f41803c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void showSignInView(LoadMoreModel loadMoreModel) {
        if (loadMoreModel != null) {
            if (loadMoreModel.loginEntity == null || TextUtils.isEmpty(loadMoreModel.loginEntity.getTitle())) {
                refreshView$default(this, 0, 0, 0, 0, 0, false, false, 0, 243, (Object) null);
                TextView textView = this.f41803c;
                if (textView != null) {
                    textView.setText(loadMoreModel.mDescription);
                }
                TextView textView2 = this.f41806f;
                if (textView2 != null) {
                    textView2.setText(getResources().getText(R.string.customer_footer_load_to_login));
                    return;
                }
                return;
            }
            refreshView$default(this, 0, 0, 0, 0, 0, false, false, 0, 127, (Object) null);
            TextView textView3 = this.f41809i;
            if (textView3 != null) {
                textView3.setText(loadMoreModel.loginEntity.getTitle());
            }
            RFMainButton rFMainButton = this.f41812l;
            if (rFMainButton != null) {
                rFMainButton.setText(loadMoreModel.loginEntity.getBtnDesc());
            }
            FlyImageLoader.loadImage1x1(getContext(), loadMoreModel.loginEntity.getUrl()).placeholder((int) R.drawable.customer_skin_img_placeholder_footer).error((int) R.drawable.customer_skin_img_placeholder_footer).centerCrop().into(this.f41811k);
            HomeOmegaHelper.getInstance().traceHomeBottomLoginSW();
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
        View view = this.f41805e;
        if (view != null) {
            view.setVisibility(i);
        }
        LottieLoadingView lottieLoadingView = this.f41804d;
        if (lottieLoadingView != null) {
            lottieLoadingView.setVisibility(i2);
        }
        LottieLoadingView lottieLoadingView2 = this.f41804d;
        if (lottieLoadingView2 != null) {
            if (z) {
                lottieLoadingView2.start();
            } else {
                lottieLoadingView2.stop();
            }
        }
        View view2 = this.f41810j;
        if (view2 != null) {
            view2.setVisibility(i6);
        }
        View view3 = this.f41813m;
        if (view3 != null) {
            view3.setVisibility(i6);
        }
        TextView textView = this.f41803c;
        if (textView != null) {
            textView.setVisibility(i3);
        }
        TextView textView2 = this.f41806f;
        if (textView2 != null) {
            textView2.setVisibility(i4);
        }
        LinearLayout linearLayout = this.f41802b;
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
            this.f41801a = i;
            if (i == 0) {
                showEmptyView();
            } else if (i == 1) {
                showLoadingView();
            } else if (i == 2) {
                showNoMoreView(str);
            } else if (i == 4) {
                showErrorView(str);
            } else if (i == 5) {
                showSignInView(loadMoreModel);
            } else if (i == 6) {
                showErrorLoadingView();
            }
        }
    }

    /* renamed from: a */
    private final void m29500a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.widget_footer_view, this, true);
        this.f41802b = (LinearLayout) inflate.findViewById(R.id.ll_footer);
        this.f41804d = (LottieLoadingView) inflate.findViewById(R.id.loading_dot_view);
        this.f41805e = inflate.findViewById(R.id.customer_footer_view_loading_stub);
        this.f41803c = (TextView) inflate.findViewById(R.id.tv_footer_desc);
        this.f41806f = (TextView) inflate.findViewById(R.id.tv_footer_button_text);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41803c, IToolsService.FontType.NORMAL);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41806f, IToolsService.FontType.MEDIUM);
        this.f41807g = inflate.findViewById(R.id.customer_footer_view_cart_stub);
        this.f41809i = (TextView) inflate.findViewById(R.id.customer_footer_loginV2_title);
        this.f41810j = inflate.findViewById(R.id.customer_footer_loginV2_layout);
        this.f41811k = (ImageView) inflate.findViewById(R.id.customer_footer_loginV2_img);
        this.f41812l = (RFMainButton) inflate.findViewById(R.id.customer_footer_loginV2_btn);
        this.f41813m = inflate.findViewById(R.id.customer_footer_view_cart_stubV2);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/footerview/CustomerFooterView$Companion;", "", "()V", "ERROR", "", "ERROR_LOADING", "LOADING", "NORMAL", "NO_MORE", "PADDING_124_DP", "PADDING_16_DP", "PADDING_200_DP", "PADDING_28_DP", "PADDING_30_DP", "PADDING_400_DP", "PADDING_46_DP", "SIGNIN", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerFooterView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
