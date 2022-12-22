package com.didi.soda.customer.component.businessgoods;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.helper.MoveAnimationHelper;
import com.didi.soda.customer.widget.CircleImageView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/customer/component/businessgoods/AddToCartAnimationComponent;", "Lcom/didi/app/nova/skeleton/Component;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "addToCartAnimationHelper", "Lcom/didi/soda/customer/helper/MoveAnimationHelper;", "border", "", "circleEndValue", "context", "Landroid/content/Context;", "createVirtualGoodsView", "Landroid/view/View;", "imgUrl", "", "onCreate", "", "playAddToCartAnimation", "startPosition", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddToCartAnimationComponent.kt */
public final class AddToCartAnimationComponent extends Component {

    /* renamed from: a */
    private ViewGroup f40770a;

    /* renamed from: b */
    private final int f40771b = ResourceHelper.getDimensionPixelSize(R.dimen.customer_72px);

    /* renamed from: c */
    private final int f40772c = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_5);

    /* renamed from: d */
    private MoveAnimationHelper f40773d;

    /* renamed from: e */
    private Context f40774e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddToCartAnimationComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.f40770a = viewGroup;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Context context = GlobalContext.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.f40774e = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        this.f40773d = new MoveAnimationHelper(context, scopeContext, this.f40770a);
    }

    public final void playAddToCartAnimation(int[] iArr, String str) {
        Intrinsics.checkNotNullParameter(iArr, "startPosition");
        View a = m28954a(str);
        Object object = getScopeContext().getObject("service_floating_cart_key");
        if (object != null) {
            int[] shoppingCartPosition = ((IFloatingCartProvider) object).getShoppingCartPosition();
            MoveAnimationHelper moveAnimationHelper = this.f40773d;
            if (moveAnimationHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addToCartAnimationHelper");
                moveAnimationHelper = null;
            }
            moveAnimationHelper.createGoodViewMoveAnimation(iArr, shoppingCartPosition, a);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider");
    }

    /* renamed from: a */
    private final View m28954a(String str) {
        Context context = this.f40774e;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        int i = this.f40771b;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i, i));
        Context context3 = this.f40774e;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context3 = null;
        }
        frameLayout.setBackground(context3.getDrawable(R.drawable.customer_shape_white_circle));
        Context context4 = this.f40774e;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context4;
        }
        CircleImageView circleImageView = new CircleImageView(context2);
        int i2 = this.f40771b;
        int i3 = this.f40772c;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2 - i3, i2 - i3);
        layoutParams.gravity = 17;
        circleImageView.setLayoutParams(layoutParams);
        circleImageView.setBackgroundResource(R.drawable.customer_skin_shape_virtual_food);
        FlyImageLoader.loadImage1x1(getScopeContext(), str).placeholder((int) R.drawable.customer_skin_shape_virtual_food).error((int) R.drawable.customer_skin_shape_virtual_food).into((ImageView) circleImageView);
        frameLayout.addView(circleImageView);
        return frameLayout;
    }
}
