package com.didi.soda.cart.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.soda.cart.binder.CustomerCartPresentMenuBinder;
import com.didi.soda.cart.binder.CustomerTyingCartBinder;
import com.didi.soda.cart.component.Contract;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.CustomerCartDiscountParentView;
import com.didi.soda.customer.widget.MaxHeightNovaRecyclerView;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 U2\u00020\u0001:\u0002TUB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u00105\u001a\u000206H\u0014J\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014H\u0002J\b\u0010<\u001a\u00020\u0014H\u0002J\b\u0010=\u001a\u000203H\u0016J\b\u0010>\u001a\u000203H\u0016J\b\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u000203H\u0016J\u0018\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u000203H\u0014J\u0006\u0010G\u001a\u00020\u0014J\b\u0010H\u001a\u000203H\u0016J\u000e\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\u0014J\u0010\u0010K\u001a\u0002032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010L\u001a\u000203H\u0016J\u0010\u0010M\u001a\u0002032\u0006\u0010;\u001a\u00020\u0014H\u0016J\b\u0010N\u001a\u000203H\u0016J\b\u0010O\u001a\u000203H\u0016J\u0018\u0010P\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u0014H\u0016J\u0010\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006V"}, mo175978d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartView;", "Lcom/didi/soda/cart/component/Contract$AbsFloatingCartView;", "()V", "actionBarCloseView", "Landroid/view/View;", "actionBarView", "animationHelper", "Lcom/didi/soda/cart/component/FloatingCartAnimationHelper;", "businessStatus", "", "cartInfoModel", "Lcom/didi/soda/cart/model/CartInfoModel;", "cartParentClickView", "cartParentView", "cartSplitLine", "cartTotalAmountView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "cartViewShadow", "checkoutView", "deleteSkuFlag", "", "discountCloseView", "discountContentView", "Lcom/didi/soda/customer/widget/text/RichTextView;", "discountParentView", "Lcom/didi/soda/customer/widget/CustomerCartDiscountParentView;", "discountRootView", "discountShadow", "hideCartMenuClickListener", "Landroid/view/View$OnClickListener;", "lastFavorTip", "", "loadingView", "Lcom/didi/soda/customer/widget/loading/LottieLoadingView;", "mCartMenuBgView", "mCartRootBgView", "originPriceView", "parentBackGroundView", "priceParentView", "recyclerView", "Lcom/didi/soda/customer/widget/MaxHeightNovaRecyclerView;", "rootView", "rvChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "rvParentView", "rvScrollShadow", "shoppingCartImage", "Landroid/widget/ImageView;", "topBarParentView", "totalPriceView", "discountReplaceActionBar", "", "model", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getShoppingCartPosition", "", "handleCartRootBg", "isMenuOpen", "isForce", "hasDiscount", "hideAllCartView", "hideCartMenu", "hideDiscountAndCartBgView", "hidePriceLoading", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "isFloatingCartExpand", "onCreate", "playAddToCartAnimation", "isOpen", "setBusinessStatus", "setSkuDeleteFlag", "showBottomCartCard", "showCartMenu", "showPriceLoading", "updateCartInfo", "firstLoadPage", "updateCartTotalAmount", "amount", "AnimationEndListener", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartView.kt */
public final class CustomerFloatingCartView extends Contract.AbsFloatingCartView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CustomerFloatingCartView";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public CartInfoModel f39919A;

    /* renamed from: B */
    private String f39920B;

    /* renamed from: C */
    private boolean f39921C;

    /* renamed from: D */
    private int f39922D = 1;

    /* renamed from: E */
    private FloatingCartAnimationHelper f39923E;

    /* renamed from: F */
    private final View.OnClickListener f39924F = new View.OnClickListener() {
        public final void onClick(View view) {
            CustomerFloatingCartView.m28470a(CustomerFloatingCartView.this, view);
        }
    };

    /* renamed from: G */
    private final View.OnLayoutChangeListener f39925G = new View.OnLayoutChangeListener() {
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            CustomerFloatingCartView.m28471a(CustomerFloatingCartView.this, view, i, i2, i3, i4, i5, i6, i7, i8);
        }
    };

    /* renamed from: a */
    private View f39926a;

    /* renamed from: b */
    private View f39927b;

    /* renamed from: c */
    private View f39928c;

    /* renamed from: d */
    private CustomerCartDiscountParentView f39929d;

    /* renamed from: e */
    private View f39930e;

    /* renamed from: f */
    private View f39931f;

    /* renamed from: g */
    private View f39932g;

    /* renamed from: h */
    private View f39933h;

    /* renamed from: i */
    private View f39934i;

    /* renamed from: j */
    private View f39935j;

    /* renamed from: k */
    private RichTextView f39936k;

    /* renamed from: l */
    private ImageView f39937l;

    /* renamed from: m */
    private MaxHeightNovaRecyclerView f39938m;

    /* renamed from: n */
    private CustomerAppCompatTextView f39939n;

    /* renamed from: o */
    private RichTextView f39940o;

    /* renamed from: p */
    private CustomerAppCompatTextView f39941p;

    /* renamed from: q */
    private View f39942q;

    /* renamed from: r */
    private View f39943r;

    /* renamed from: s */
    private CustomerAppCompatTextView f39944s;

    /* renamed from: t */
    private LottieLoadingView f39945t;

    /* renamed from: u */
    private View f39946u;

    /* renamed from: v */
    private View f39947v;

    /* renamed from: w */
    private View f39948w;

    /* renamed from: x */
    private View f39949x;

    /* renamed from: y */
    private View f39950y;

    /* renamed from: z */
    private View f39951z;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartView$AnimationEndListener;", "", "onClearData", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerFloatingCartView.kt */
    public interface AnimationEndListener {
        void onClearData();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28468a(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m28474b(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m28477c(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28470a(CustomerFloatingCartView customerFloatingCartView, View view) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        if (!ClickUtils.isFastClick()) {
            customerFloatingCartView.hideCartMenu();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28471a(CustomerFloatingCartView customerFloatingCartView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        if (!(i6 == 0 || i6 == i2 || !customerFloatingCartView.f39921C)) {
            View view2 = customerFloatingCartView.f39943r;
            View view3 = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
                view2 = null;
            }
            float translationY = view2.getTranslationY();
            View view4 = customerFloatingCartView.f39943r;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
            } else {
                view3 = view4;
            }
            view3.setTranslationY((translationY + ((float) i2)) - ((float) i6));
        }
        customerFloatingCartView.f39921C = false;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartView$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerFloatingCartView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_floating_cart_view, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_rl_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewRoot.findViewById(R.id.customer_rl_root_view)");
        this.f39927b = findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_view_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "viewRoot.findViewById(R.id.customer_view_bg)");
        this.f39926a = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_custom_discount_close_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "viewRoot.findViewById(R.…stom_discount_close_cart)");
        this.f39930e = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_custom_actionbar_close_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "viewRoot.findViewById(R.…tom_actionbar_close_cart)");
        this.f39931f = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_rl_actionbar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "viewRoot.findViewById(R.id.customer_rl_actionbar)");
        this.f39932g = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_fl_offer_pass_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "viewRoot.findViewById(R.…mer_fl_offer_pass_parent)");
        this.f39928c = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_ll_discount_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "viewRoot.findViewById(R.…tomer_ll_discount_parent)");
        this.f39929d = (CustomerCartDiscountParentView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_custom_offer_pass);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "viewRoot.findViewById(R.…stomer_custom_offer_pass)");
        this.f39936k = (RichTextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_custom_cart_menu);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "viewRoot.findViewById(R.…ustomer_custom_cart_menu)");
        this.f39938m = (MaxHeightNovaRecyclerView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_iv_shopping_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "viewRoot.findViewById(R.…ustomer_iv_shopping_cart)");
        this.f39937l = (ImageView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.customer_fl_cart_root);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "viewRoot.findViewById(R.id.customer_fl_cart_root)");
        this.f39933h = findViewById11;
        View findViewById12 = inflate.findViewById(R.id.customer_fl_cart_root_click_area);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "viewRoot.findViewById(R.…_fl_cart_root_click_area)");
        this.f39934i = findViewById12;
        View findViewById13 = inflate.findViewById(R.id.customer_view_split_line);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "viewRoot.findViewById(R.…customer_view_split_line)");
        this.f39935j = findViewById13;
        View findViewById14 = inflate.findViewById(R.id.customer_custom_loading_view);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "viewRoot.findViewById(R.…omer_custom_loading_view)");
        this.f39945t = (LottieLoadingView) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.customer_custom_cart_total_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "viewRoot.findViewById(R.…custom_cart_total_amount)");
        this.f39941p = (CustomerAppCompatTextView) findViewById15;
        View findViewById16 = inflate.findViewById(R.id.customer_fl_top_bar_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "viewRoot.findViewById(R.…stomer_fl_top_bar_parent)");
        this.f39943r = findViewById16;
        View findViewById17 = inflate.findViewById(R.id.customer_cart_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "viewRoot.findViewById(R.id.customer_cart_shadow)");
        this.f39946u = findViewById17;
        View findViewById18 = inflate.findViewById(R.id.customer_discount_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "viewRoot.findViewById(R.…customer_discount_shadow)");
        this.f39947v = findViewById18;
        View findViewById19 = inflate.findViewById(R.id.customer_iv_rv_scroll_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "viewRoot.findViewById(R.…omer_iv_rv_scroll_shadow)");
        this.f39948w = findViewById19;
        View findViewById20 = inflate.findViewById(R.id.customer_fl_rv_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "viewRoot.findViewById(R.id.customer_fl_rv_parent)");
        this.f39949x = findViewById20;
        View findViewById21 = inflate.findViewById(R.id.customer_ll_price_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "viewRoot.findViewById(R.…customer_ll_price_parent)");
        this.f39942q = findViewById21;
        View findViewById22 = inflate.findViewById(R.id.customer_custom_total_price);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "viewRoot.findViewById(R.…tomer_custom_total_price)");
        this.f39939n = (CustomerAppCompatTextView) findViewById22;
        View findViewById23 = inflate.findViewById(R.id.customer_custom_origin_price);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "viewRoot.findViewById(R.…omer_custom_origin_price)");
        this.f39940o = (RichTextView) findViewById23;
        View findViewById24 = inflate.findViewById(R.id.customer_custom_bt_check_out);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "viewRoot.findViewById(R.…omer_custom_bt_check_out)");
        this.f39944s = (CustomerAppCompatTextView) findViewById24;
        View findViewById25 = inflate.findViewById(R.id.customer_cart_root_bg_view);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "viewRoot.findViewById(R.…stomer_cart_root_bg_view)");
        this.f39950y = findViewById25;
        View findViewById26 = inflate.findViewById(R.id.customer_cart_menu_bg_view);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "viewRoot.findViewById(R.…stomer_cart_menu_bg_view)");
        this.f39951z = findViewById26;
        Intrinsics.checkNotNullExpressionValue(inflate, "viewRoot");
        return inflate;
    }

    public void onCreate() {
        View view;
        View view2;
        View view3;
        View view4;
        CustomerCartDiscountParentView customerCartDiscountParentView;
        RichTextView richTextView;
        View view5;
        View view6;
        View view7;
        View view8;
        ImageView imageView;
        View view9;
        View view10;
        View view11;
        super.onCreate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View view12 = this.f39927b;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view = null;
        } else {
            view = view12;
        }
        View view13 = this.f39926a;
        if (view13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentBackGroundView");
            view2 = null;
        } else {
            view2 = view13;
        }
        View view14 = this.f39943r;
        if (view14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
            view3 = null;
        } else {
            view3 = view14;
        }
        View view15 = this.f39928c;
        if (view15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            view4 = null;
        } else {
            view4 = view15;
        }
        CustomerCartDiscountParentView customerCartDiscountParentView2 = this.f39929d;
        if (customerCartDiscountParentView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
            customerCartDiscountParentView = null;
        } else {
            customerCartDiscountParentView = customerCartDiscountParentView2;
        }
        RichTextView richTextView2 = this.f39936k;
        if (richTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountContentView");
            richTextView = null;
        } else {
            richTextView = richTextView2;
        }
        View view16 = this.f39932g;
        if (view16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
            view5 = null;
        } else {
            view5 = view16;
        }
        View view17 = this.f39930e;
        if (view17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountCloseView");
            view6 = null;
        } else {
            view6 = view17;
        }
        View view18 = this.f39933h;
        if (view18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view7 = null;
        } else {
            view7 = view18;
        }
        View view19 = this.f39935j;
        if (view19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartSplitLine");
            view8 = null;
        } else {
            view8 = view19;
        }
        ImageView imageView2 = this.f39937l;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shoppingCartImage");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        View view20 = this.f39949x;
        if (view20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvParentView");
            view9 = null;
        } else {
            view9 = view20;
        }
        View view21 = this.f39946u;
        if (view21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            view10 = null;
        } else {
            view10 = view21;
        }
        View view22 = this.f39947v;
        if (view22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
            view11 = null;
        } else {
            view11 = view22;
        }
        FloatingCartAnimationHelper floatingCartAnimationHelper = r1;
        FloatingCartAnimationHelper floatingCartAnimationHelper2 = new FloatingCartAnimationHelper(context, view, view2, view3, view4, customerCartDiscountParentView, richTextView, view5, view6, view7, view8, imageView, view9, view10, view11);
        this.f39923E = floatingCartAnimationHelper;
        CustomerAppCompatTextView customerAppCompatTextView = this.f39944s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setText(ResourceHelper.getString(R.string.customer_global_cart_item_check_out));
        View view23 = this.f39934i;
        if (view23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentClickView");
            view23 = null;
        }
        view23.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerFloatingCartView.m28475b(CustomerFloatingCartView.this, view);
            }
        });
        CustomerCartDiscountParentView customerCartDiscountParentView3 = this.f39929d;
        if (customerCartDiscountParentView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
            customerCartDiscountParentView3 = null;
        }
        customerCartDiscountParentView3.setOnClickListener($$Lambda$CustomerFloatingCartView$h_Zjz9GkdSrb_LTCWoMX8yFwx5A.INSTANCE);
        View view24 = this.f39933h;
        if (view24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view24 = null;
        }
        view24.setOnClickListener($$Lambda$CustomerFloatingCartView$zw6oF21YzZHwibxyepWkL5qEmzM.INSTANCE);
        View view25 = this.f39932g;
        if (view25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
            view25 = null;
        }
        view25.setOnClickListener($$Lambda$CustomerFloatingCartView$ApIcVGnpkvrwWTGD12kyAIzy3to.INSTANCE);
        View view26 = this.f39930e;
        if (view26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountCloseView");
            view26 = null;
        }
        view26.setOnClickListener(this.f39924F);
        View view27 = this.f39926a;
        if (view27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentBackGroundView");
            view27 = null;
        }
        view27.setOnClickListener(this.f39924F);
        View view28 = this.f39931f;
        if (view28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarCloseView");
            view28 = null;
        }
        view28.setOnClickListener(this.f39924F);
        View view29 = this.f39949x;
        if (view29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvParentView");
            view29 = null;
        }
        view29.addOnLayoutChangeListener(this.f39925G);
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f39944s;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView2 = null;
        }
        customerAppCompatTextView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerFloatingCartView.m28478c(CustomerFloatingCartView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m28475b(CustomerFloatingCartView customerFloatingCartView, View view) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        CartInfoModel cartInfoModel = customerFloatingCartView.f39919A;
        if (cartInfoModel != null) {
            Intrinsics.checkNotNull(cartInfoModel);
            Collection cartItems = cartInfoModel.getCartItems();
            if (!(cartItems == null || cartItems.isEmpty())) {
                if (ClickUtils.isFastClick()) {
                    LogUtil.m29104i(TAG, "shopping cart quick click blocked");
                } else if (customerFloatingCartView.f39919A != null) {
                    if (customerFloatingCartView.isFloatingCartExpand()) {
                        customerFloatingCartView.hideCartMenu();
                        return;
                    }
                    LottieLoadingView lottieLoadingView = customerFloatingCartView.f39945t;
                    if (lottieLoadingView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                        lottieLoadingView = null;
                    }
                    if (!lottieLoadingView.isRunning()) {
                        customerFloatingCartView.showCartMenu();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m28478c(CustomerFloatingCartView customerFloatingCartView, View view) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        if (!ClickUtils.isFastClick()) {
            if (!LoginUtil.isLogin()) {
                LoginUtil.loginActivityAndTrack(customerFloatingCartView.getContext(), 9);
                return;
            }
            ((Contract.AbsFloatingCartPresenter) customerFloatingCartView.getPresenter()).toBillPage();
            if (customerFloatingCartView.isFloatingCartExpand()) {
                customerFloatingCartView.hideCartMenu();
            }
        }
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        MaxHeightNovaRecyclerView maxHeightNovaRecyclerView = this.f39938m;
        if (maxHeightNovaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            maxHeightNovaRecyclerView = null;
        }
        return maxHeightNovaRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new CustomerCartPresentMenuBinder());
        registerBinder(new CustomerFloatingCartView$initItemBinders$1(this, getScopeContext()));
        CustomerTyingCartBinder customerTyingCartBinder = new CustomerTyingCartBinder();
        customerTyingCartBinder.setOnItemClickListener(new CustomerFloatingCartView$initItemBinders$2$1(this));
        Unit unit = Unit.INSTANCE;
        registerBinder(customerTyingCartBinder);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateCartInfo(com.didi.soda.cart.model.CartInfoModel r11, boolean r12) {
        /*
            r10 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            if (r12 != 0) goto L_0x006b
            com.didi.soda.cart.model.CartInfoModel r3 = r10.f39919A
            if (r3 != 0) goto L_0x0010
            r3 = r0
            goto L_0x0014
        L_0x0010:
            java.util.ArrayList r3 = r3.getCartItems()
        L_0x0014:
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0021
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r3 = 0
            goto L_0x0022
        L_0x0021:
            r3 = 1
        L_0x0022:
            if (r3 == 0) goto L_0x003a
            java.util.ArrayList r3 = r11.getCartItems()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0035
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = 0
            goto L_0x0036
        L_0x0035:
            r3 = 1
        L_0x0036:
            if (r3 != 0) goto L_0x003a
            r3 = 1
            goto L_0x003b
        L_0x003a:
            r3 = 0
        L_0x003b:
            com.didi.soda.cart.model.CartInfoModel r4 = r10.f39919A
            if (r4 != 0) goto L_0x0041
            r4 = r0
            goto L_0x0045
        L_0x0041:
            java.util.ArrayList r4 = r4.getCartItems()
        L_0x0045:
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0052
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r4 = 0
            goto L_0x0053
        L_0x0052:
            r4 = 1
        L_0x0053:
            if (r4 != 0) goto L_0x006c
            java.util.ArrayList r4 = r11.getCartItems()
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0066
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r4 = 0
            goto L_0x0067
        L_0x0066:
            r4 = 1
        L_0x0067:
            if (r4 == 0) goto L_0x006c
            r4 = 1
            goto L_0x006d
        L_0x006b:
            r3 = 0
        L_0x006c:
            r4 = 0
        L_0x006d:
            r10.f39919A = r11
            com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoPriceEntity r5 = r11.getPrices()
            r6 = 8
            if (r5 != 0) goto L_0x0079
            goto L_0x00f7
        L_0x0079:
            java.lang.String r7 = r5.getCartPriceDesc()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x008a
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            r7 = 0
            goto L_0x008b
        L_0x008a:
            r7 = 1
        L_0x008b:
            java.lang.String r8 = "originPriceView"
            if (r7 == 0) goto L_0x009c
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f39940o
            if (r7 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x0098:
            r7.setVisibility(r6)
            goto L_0x00b8
        L_0x009c:
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f39940o
            if (r7 != 0) goto L_0x00a4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00a4:
            r7.setVisibility(r2)
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f39940o
            if (r7 != 0) goto L_0x00af
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00af:
            java.lang.String r8 = r5.getCartPriceDesc()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
        L_0x00b8:
            java.lang.String r7 = r5.getCartFavorPriceDisplay()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x00c9
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r7 = 0
            goto L_0x00ca
        L_0x00c9:
            r7 = 1
        L_0x00ca:
            java.lang.String r8 = "totalPriceView"
            if (r7 == 0) goto L_0x00db
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r5 = r10.f39939n
            if (r5 != 0) goto L_0x00d7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r5 = r0
        L_0x00d7:
            r5.setVisibility(r6)
            goto L_0x00f7
        L_0x00db:
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r7 = r10.f39939n
            if (r7 != 0) goto L_0x00e3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00e3:
            r7.setVisibility(r2)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r7 = r10.f39939n
            if (r7 != 0) goto L_0x00ee
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00ee:
            java.lang.String r5 = r5.getCartFavorPriceDisplay()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7.setText(r5)
        L_0x00f7:
            java.lang.String r5 = r11.getFavorTip()
            java.lang.String r7 = r10.f39920B
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x010b
            java.lang.String r5 = r11.getFavorTip()
            r10.f39920B = r5
            r5 = 1
            goto L_0x010c
        L_0x010b:
            r5 = 0
        L_0x010c:
            java.lang.String r7 = r11.getFavorTip()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x011d
            int r7 = r7.length()
            if (r7 != 0) goto L_0x011b
            goto L_0x011d
        L_0x011b:
            r7 = 0
            goto L_0x011e
        L_0x011d:
            r7 = 1
        L_0x011e:
            java.lang.String r8 = "rvScrollShadow"
            if (r7 != 0) goto L_0x0142
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f39936k
            if (r7 != 0) goto L_0x012d
            java.lang.String r7 = "discountContentView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = r0
        L_0x012d:
            java.lang.String r9 = r11.getFavorTip()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            android.view.View r7 = r10.f39948w
            if (r7 != 0) goto L_0x013e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x013e:
            r7.setVisibility(r2)
            goto L_0x014d
        L_0x0142:
            android.view.View r7 = r10.f39948w
            if (r7 != 0) goto L_0x014a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x014a:
            r7.setVisibility(r6)
        L_0x014d:
            boolean r7 = r10.isFloatingCartExpand()
            r10.m28473a((boolean) r7, (boolean) r2)
            if (r12 == 0) goto L_0x01f5
            java.lang.String r12 = r11.getFavorTip()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x0167
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0165
            goto L_0x0167
        L_0x0165:
            r12 = 0
            goto L_0x0168
        L_0x0167:
            r12 = 1
        L_0x0168:
            java.lang.String r3 = "animationHelper"
            if (r12 != 0) goto L_0x018d
            java.util.ArrayList r12 = r11.getCartItems()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x017d
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x017b
            goto L_0x017d
        L_0x017b:
            r12 = 0
            goto L_0x017e
        L_0x017d:
            r12 = 1
        L_0x017e:
            if (r12 == 0) goto L_0x018d
            com.didi.soda.cart.component.FloatingCartAnimationHelper r12 = r10.f39923E
            if (r12 != 0) goto L_0x0188
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r12 = r0
        L_0x0188:
            r12.showDiscountTip()
            goto L_0x0205
        L_0x018d:
            java.lang.String r12 = r11.getFavorTip()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x019e
            int r12 = r12.length()
            if (r12 != 0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r12 = 0
            goto L_0x019f
        L_0x019e:
            r12 = 1
        L_0x019f:
            if (r12 == 0) goto L_0x01c1
            java.util.ArrayList r12 = r11.getCartItems()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x01b2
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x01b0
            goto L_0x01b2
        L_0x01b0:
            r12 = 0
            goto L_0x01b3
        L_0x01b2:
            r12 = 1
        L_0x01b3:
            if (r12 != 0) goto L_0x01c1
            com.didi.soda.cart.component.FloatingCartAnimationHelper r12 = r10.f39923E
            if (r12 != 0) goto L_0x01bd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r12 = r0
        L_0x01bd:
            r12.showCartNoDiscountTip()
            goto L_0x0205
        L_0x01c1:
            java.lang.String r12 = r11.getFavorTip()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x01d2
            int r12 = r12.length()
            if (r12 != 0) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r12 = 0
            goto L_0x01d3
        L_0x01d2:
            r12 = 1
        L_0x01d3:
            if (r12 != 0) goto L_0x0205
            java.util.ArrayList r12 = r11.getCartItems()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x01e6
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x01e4
            goto L_0x01e6
        L_0x01e4:
            r12 = 0
            goto L_0x01e7
        L_0x01e6:
            r12 = 1
        L_0x01e7:
            if (r12 != 0) goto L_0x0205
            com.didi.soda.cart.component.FloatingCartAnimationHelper r12 = r10.f39923E
            if (r12 != 0) goto L_0x01f1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r12 = r0
        L_0x01f1:
            r12.showDiscountTipAndCart()
            goto L_0x0205
        L_0x01f5:
            if (r3 == 0) goto L_0x01fa
            r10.showBottomCartCard(r1)
        L_0x01fa:
            if (r4 == 0) goto L_0x01ff
            r10.hideAllCartView()
        L_0x01ff:
            if (r5 != 0) goto L_0x0202
            return
        L_0x0202:
            r10.m28472a((com.didi.soda.cart.model.CartInfoModel) r11)
        L_0x0205:
            com.didi.soda.cart.model.CartTyingModel r11 = r11.getCartTyingModel()
            if (r11 != 0) goto L_0x020d
        L_0x020b:
            r1 = 0
            goto L_0x021c
        L_0x020d:
            java.util.ArrayList r11 = r11.getCartItems()
            if (r11 != 0) goto L_0x0214
            goto L_0x020b
        L_0x0214:
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != r1) goto L_0x020b
        L_0x021c:
            java.lang.String r11 = "cartSplitLine"
            if (r1 == 0) goto L_0x022d
            android.view.View r12 = r10.f39935j
            if (r12 != 0) goto L_0x0228
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0229
        L_0x0228:
            r0 = r12
        L_0x0229:
            r0.setVisibility(r2)
            goto L_0x0239
        L_0x022d:
            android.view.View r12 = r10.f39935j
            if (r12 != 0) goto L_0x0235
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0236
        L_0x0235:
            r0 = r12
        L_0x0236:
            r0.setVisibility(r6)
        L_0x0239:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.component.CustomerFloatingCartView.updateCartInfo(com.didi.soda.cart.model.CartInfoModel, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m28473a(boolean z, boolean z2) {
        int i = R.drawable.customer_skin_shape_cart_discount_fill_bg;
        boolean z3 = true;
        int i2 = 8;
        View view = null;
        if (z2) {
            View view2 = this.f39951z;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                view2 = null;
            }
            view2.setVisibility(8);
            CartInfoModel cartInfoModel = this.f39919A;
            CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
            if (!(favorTip == null || favorTip.length() == 0)) {
                z3 = false;
            }
            if (!z3) {
                View view3 = this.f39950y;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view3 = null;
                }
                view3.setBackgroundResource(R.drawable.customer_skin_shape_cart_discount_fill_bg);
                View view4 = this.f39950y;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                } else {
                    view = view4;
                }
                view.setVisibility(0);
                return;
            }
            View view5 = this.f39950y;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
            } else {
                view = view5;
            }
            view.setVisibility(8);
            return;
        }
        CartInfoModel cartInfoModel2 = this.f39919A;
        CharSequence favorTip2 = cartInfoModel2 == null ? null : cartInfoModel2.getFavorTip();
        if (!(favorTip2 == null || favorTip2.length() == 0)) {
            CartInfoModel cartInfoModel3 = this.f39919A;
            Collection cartItems = cartInfoModel3 == null ? null : cartInfoModel3.getCartItems();
            if (cartItems == null || cartItems.isEmpty()) {
                View view6 = this.f39950y;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view6 = null;
                }
                view6.setVisibility(8);
                View view7 = this.f39951z;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                } else {
                    view = view7;
                }
                view.setVisibility(8);
                return;
            }
        }
        CartInfoModel cartInfoModel4 = this.f39919A;
        CharSequence favorTip3 = cartInfoModel4 == null ? null : cartInfoModel4.getFavorTip();
        if (favorTip3 == null || favorTip3.length() == 0) {
            CartInfoModel cartInfoModel5 = this.f39919A;
            Collection cartItems2 = cartInfoModel5 == null ? null : cartInfoModel5.getCartItems();
            if (!(cartItems2 == null || cartItems2.isEmpty())) {
                View view8 = this.f39951z;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view8 = null;
                }
                view8.setBackgroundResource(R.color.rf_color_white_100_FFFFFF);
                View view9 = this.f39951z;
                if (view9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view9 = null;
                }
                view9.setVisibility(z ? 0 : 8);
                View view10 = this.f39950y;
                if (view10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view10 = null;
                }
                view10.setBackgroundResource(R.color.rf_color_white_100_FFFFFF);
                View view11 = this.f39950y;
                if (view11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                } else {
                    view = view11;
                }
                if (z) {
                    i2 = 0;
                }
                view.setVisibility(i2);
                return;
            }
        }
        CartInfoModel cartInfoModel6 = this.f39919A;
        CharSequence favorTip4 = cartInfoModel6 == null ? null : cartInfoModel6.getFavorTip();
        if (!(favorTip4 == null || favorTip4.length() == 0)) {
            CartInfoModel cartInfoModel7 = this.f39919A;
            Collection cartItems3 = cartInfoModel7 == null ? null : cartInfoModel7.getCartItems();
            if (cartItems3 != null && !cartItems3.isEmpty()) {
                z3 = false;
            }
            if (!z3) {
                View view12 = this.f39951z;
                if (view12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view12 = null;
                }
                view12.setBackgroundResource(R.drawable.customer_skin_shape_cart_discount_fill_bg);
                View view13 = this.f39951z;
                if (view13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view13 = null;
                }
                if (z) {
                    i2 = 0;
                }
                view13.setVisibility(i2);
                View view14 = this.f39950y;
                if (view14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view14 = null;
                }
                if (z) {
                    i = R.color.rf_color_white_100_FFFFFF;
                }
                view14.setBackgroundResource(i);
                View view15 = this.f39950y;
                if (view15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                } else {
                    view = view15;
                }
                view.setVisibility(0);
                return;
            }
        }
        m28467a();
    }

    /* renamed from: a */
    private final void m28467a() {
        View view = this.f39951z;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.f39950y;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
        } else {
            view2 = view3;
        }
        view2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m28472a(CartInfoModel cartInfoModel) {
        View view = null;
        CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
        if (!(favorTip == null || favorTip.length() == 0)) {
            View view2 = this.f39928c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            } else {
                view = view2;
            }
            view.post(new Runnable() {
                public final void run() {
                    CustomerFloatingCartView.m28469a(CustomerFloatingCartView.this);
                }
            });
            return;
        }
        View view3 = this.f39948w;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvScrollShadow");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.f39928c;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            view4 = null;
        }
        view4.setVisibility(8);
        if (isFloatingCartExpand()) {
            View view5 = this.f39932g;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
                view5 = null;
            }
            view5.setVisibility(0);
            View view6 = this.f39946u;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            } else {
                view = view6;
            }
            view.setVisibility(8);
            return;
        }
        View view7 = this.f39933h;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view7 = null;
        }
        if (view7.getVisibility() == 0) {
            View view8 = this.f39932g;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
                view8 = null;
            }
            view8.setVisibility(8);
            View view9 = this.f39946u;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            } else {
                view = view9;
            }
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28469a(CustomerFloatingCartView customerFloatingCartView) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        View view = customerFloatingCartView.f39943r;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
            view = null;
        }
        view.setVisibility(0);
        View view3 = customerFloatingCartView.f39928c;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            view3 = null;
        }
        view3.setVisibility(0);
        View view4 = customerFloatingCartView.f39932g;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = customerFloatingCartView.f39946u;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            view5 = null;
        }
        view5.setVisibility(8);
        if (customerFloatingCartView.isFloatingCartExpand()) {
            View view6 = customerFloatingCartView.f39947v;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
                view6 = null;
            }
            view6.setAlpha(0.0f);
        } else {
            View view7 = customerFloatingCartView.f39947v;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
                view7 = null;
            }
            view7.setVisibility(0);
            View view8 = customerFloatingCartView.f39947v;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
                view8 = null;
            }
            view8.setAlpha(1.0f);
        }
        View view9 = customerFloatingCartView.f39933h;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view9 = null;
        }
        if (view9.getVisibility() != 0 || customerFloatingCartView.isFloatingCartExpand()) {
            View view10 = customerFloatingCartView.f39933h;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
                view10 = null;
            }
            if (view10.getVisibility() == 8) {
                CustomerCartDiscountParentView customerCartDiscountParentView = customerFloatingCartView.f39929d;
                if (customerCartDiscountParentView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                    customerCartDiscountParentView = null;
                }
                CustomerCartDiscountParentView customerCartDiscountParentView2 = customerFloatingCartView.f39929d;
                if (customerCartDiscountParentView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                    customerCartDiscountParentView2 = null;
                }
                int paddingLeft = customerCartDiscountParentView2.getPaddingLeft();
                int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
                CustomerCartDiscountParentView customerCartDiscountParentView3 = customerFloatingCartView.f39929d;
                if (customerCartDiscountParentView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                    customerCartDiscountParentView3 = null;
                }
                customerCartDiscountParentView.setPadding(paddingLeft, dimensionPixelSize, customerCartDiscountParentView3.getPaddingRight(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24));
            }
        } else {
            View view11 = customerFloatingCartView.f39943r;
            if (view11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
                view11 = null;
            }
            view11.setTranslationY(0.0f);
            CustomerCartDiscountParentView customerCartDiscountParentView4 = customerFloatingCartView.f39929d;
            if (customerCartDiscountParentView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                customerCartDiscountParentView4 = null;
            }
            CustomerCartDiscountParentView customerCartDiscountParentView5 = customerFloatingCartView.f39929d;
            if (customerCartDiscountParentView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                customerCartDiscountParentView5 = null;
            }
            int paddingLeft2 = customerCartDiscountParentView5.getPaddingLeft();
            int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
            CustomerCartDiscountParentView customerCartDiscountParentView6 = customerFloatingCartView.f39929d;
            if (customerCartDiscountParentView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                customerCartDiscountParentView6 = null;
            }
            customerCartDiscountParentView4.setPadding(paddingLeft2, dimensionPixelSize2, customerCartDiscountParentView6.getPaddingRight(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24));
        }
        View view12 = customerFloatingCartView.f39948w;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvScrollShadow");
        } else {
            view2 = view12;
        }
        view2.setVisibility(0);
    }

    public void showCartMenu() {
        LogUtil.m29104i(TAG, "shopping cart click: showCartMenu");
        ((Contract.AbsFloatingCartPresenter) getPresenter()).openCartTracker();
        FloatingCartAnimationHelper floatingCartAnimationHelper = this.f39923E;
        if (floatingCartAnimationHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            floatingCartAnimationHelper = null;
        }
        floatingCartAnimationHelper.showCartMenu(m28476b());
        m28473a(true, false);
    }

    public void hideCartMenu() {
        LogUtil.m29104i(TAG, "shopping cart click: hideCartMenu");
        FloatingCartAnimationHelper floatingCartAnimationHelper = this.f39923E;
        if (floatingCartAnimationHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            floatingCartAnimationHelper = null;
        }
        floatingCartAnimationHelper.hideCartMenu(m28476b(), new CustomerFloatingCartView$hideCartMenu$1(this));
    }

    public final void playAddToCartAnimation(boolean z) {
        FloatingCartAnimationHelper floatingCartAnimationHelper = this.f39923E;
        if (floatingCartAnimationHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            floatingCartAnimationHelper = null;
        }
        floatingCartAnimationHelper.playAddToCartAnimation(z);
    }

    /* renamed from: b */
    private final boolean m28476b() {
        CartInfoModel cartInfoModel = this.f39919A;
        CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
        return !(favorTip == null || favorTip.length() == 0);
    }

    public void showPriceLoading() {
        LottieLoadingView lottieLoadingView = this.f39945t;
        View view = null;
        if (lottieLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            lottieLoadingView = null;
        }
        if (!lottieLoadingView.isRunning()) {
            LottieLoadingView lottieLoadingView2 = this.f39945t;
            if (lottieLoadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                lottieLoadingView2 = null;
            }
            lottieLoadingView2.show();
        }
        CustomerAppCompatTextView customerAppCompatTextView = this.f39944s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setEnabled(false);
        View view2 = this.f39942q;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceParentView");
        } else {
            view = view2;
        }
        view.setVisibility(8);
    }

    public void hidePriceLoading() {
        LottieLoadingView lottieLoadingView = this.f39945t;
        View view = null;
        if (lottieLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            lottieLoadingView = null;
        }
        lottieLoadingView.hide();
        CustomerAppCompatTextView customerAppCompatTextView = this.f39944s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        boolean z = true;
        if (this.f39922D != 1) {
            z = false;
        }
        customerAppCompatTextView.setEnabled(z);
        View view2 = this.f39942q;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceParentView");
        } else {
            view = view2;
        }
        view.setVisibility(0);
    }

    public void updateCartTotalAmount(int i) {
        CustomerAppCompatTextView customerAppCompatTextView = this.f39941p;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartTotalAmountView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setText(String.valueOf(i));
    }

    public void setBusinessStatus(int i) {
        this.f39922D = i;
        CustomerAppCompatTextView customerAppCompatTextView = this.f39944s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        customerAppCompatTextView.setEnabled(z);
    }

    public void showBottomCartCard(boolean z) {
        FloatingCartAnimationHelper floatingCartAnimationHelper = null;
        if (z) {
            View view = this.f39933h;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
                view = null;
            }
            if (view.getVisibility() == 0) {
                return;
            }
        }
        boolean z2 = true;
        if (!z) {
            m28473a(isFloatingCartExpand(), true);
        }
        CartInfoModel cartInfoModel = this.f39919A;
        CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
        if (!(favorTip == null || favorTip.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            View view2 = this.f39928c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
                view2 = null;
            }
            if (view2.getVisibility() == 8) {
                FloatingCartAnimationHelper floatingCartAnimationHelper2 = this.f39923E;
                if (floatingCartAnimationHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
                } else {
                    floatingCartAnimationHelper = floatingCartAnimationHelper2;
                }
                floatingCartAnimationHelper.showDiscountTipAndCart();
                return;
            }
            FloatingCartAnimationHelper floatingCartAnimationHelper3 = this.f39923E;
            if (floatingCartAnimationHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            } else {
                floatingCartAnimationHelper = floatingCartAnimationHelper3;
            }
            floatingCartAnimationHelper.showBottomCart();
            return;
        }
        FloatingCartAnimationHelper floatingCartAnimationHelper4 = this.f39923E;
        if (floatingCartAnimationHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
        } else {
            floatingCartAnimationHelper = floatingCartAnimationHelper4;
        }
        floatingCartAnimationHelper.showCartNoDiscountTip();
    }

    public void setSkuDeleteFlag() {
        this.f39921C = true;
    }

    public void hideAllCartView() {
        LogUtil.m29104i(TAG, "hide all cart view");
        View view = this.f39933h;
        FloatingCartAnimationHelper floatingCartAnimationHelper = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view = null;
        }
        if (view.getVisibility() == 0) {
            m28467a();
            FloatingCartAnimationHelper floatingCartAnimationHelper2 = this.f39923E;
            if (floatingCartAnimationHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            } else {
                floatingCartAnimationHelper = floatingCartAnimationHelper2;
            }
            floatingCartAnimationHelper.hideAllView(m28476b(), new CustomerFloatingCartView$hideAllCartView$1(this));
        }
    }

    public final int[] getShoppingCartPosition() {
        return new int[]{ResourceHelper.getDimensionPixelSize(R.dimen.customer_44px), CustomerSystemUtil.getScreenHeight(getContext()) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_94px)};
    }

    public final boolean isFloatingCartExpand() {
        View view = this.f39949x;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvParentView");
            view = null;
        }
        return view.getVisibility() == 0;
    }
}
