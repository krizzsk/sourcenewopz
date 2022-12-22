package com.didi.soda.bill.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.cart.model.CartTyingModel;
import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.util.CollectionUtilsKt;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtilOnlyNew;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.widget.cart.CartTyingView;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/TyingItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogicV2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tyingView", "Lcom/didi/soda/customer/widget/cart/CartTyingView;", "getTyingView", "()Lcom/didi/soda/customer/widget/cart/CartTyingView;", "setTyingView", "(Lcom/didi/soda/customer/widget/cart/CartTyingView;)V", "getImageCornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "handleOmegaEvent", "", "tyingItem", "Lcom/didi/soda/cart/model/CartTyingModel;", "initView", "needExtraPadding", "", "openSKU", "model", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "source", "", "setData", "setMarginDetail", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TyingItemView.kt */
public final class TyingItemView extends BillItemView<ItemViewCommonLogicV2> {
    public CartTyingView tyingView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TyingItemView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean needExtraPadding() {
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TyingItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TyingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final CartTyingView getTyingView() {
        CartTyingView cartTyingView = this.tyingView;
        if (cartTyingView != null) {
            return cartTyingView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tyingView");
        return null;
    }

    public final void setTyingView(CartTyingView cartTyingView) {
        Intrinsics.checkNotNullParameter(cartTyingView, "<set-?>");
        this.tyingView = cartTyingView;
    }

    public void initView() {
        super.initView();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setTyingView(new CartTyingView(context));
        addView(getTyingView(), new FrameLayout.LayoutParams(-1, -2));
    }

    /* renamed from: a */
    private final void m27794a(ComponentModel componentModel, CartTyingModel cartTyingModel) {
        FloatingCartOmegaHelper.Companion.trackTyingShow("2", componentModel.getCartId(), componentModel.getShopId(), CollectionUtilsKt.dividerBy(cartTyingModel.getCartItems(), ",", TyingItemView$handleOmegaEvent$itemList$1.INSTANCE));
        new CustomeRvExposeUtilOnlyNew().setRecyclerItemExposeListener(getTyingView().getMRv(), new CustomeRvExposeUtil.OnItemExposeListener() {
            public final void onItemViewVisible(int i) {
                TyingItemView.m27796a(CartTyingModel.this, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27796a(CartTyingModel cartTyingModel, int i) {
        Intrinsics.checkNotNullParameter(cartTyingModel, "$tyingItem");
        CartTyingItemModel cartTyingItemModel = (CartTyingItemModel) CollectionUtilsKt.safeGet(cartTyingModel.getCartItems(), i);
        if (cartTyingItemModel != null) {
            FloatingCartOmegaHelper.Companion.trackTyingItemRealShow("2", cartTyingItemModel);
        }
    }

    /* renamed from: a */
    private final RoundedCornersTransformation.CornerType m27793a(ComponentModel componentModel) {
        if (componentModel.getCardBgType() == 2) {
            return RoundedCornersTransformation.CornerType.BOTTOM;
        }
        if (componentModel.getCardBgType() == 1) {
            return RoundedCornersTransformation.CornerType.TOP;
        }
        if (componentModel.getCardBgType() == 0) {
            return RoundedCornersTransformation.CornerType.ALL;
        }
        return null;
    }

    private final void setMarginDetail(ComponentModel componentModel) {
        if (componentModel.getCardBgType() != 1) {
            ViewGroup.LayoutParams layoutParams = getTyingView().getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = CustomerExtentionKt.getPx(R.dimen.rf_dimen_40);
            }
            getTyingView().requestLayout();
        }
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        ComponentDataModel data = componentModel.getData();
        CartTyingModel tyingItem = data == null ? null : data.getTyingItem();
        if (tyingItem != null) {
            m27794a(componentModel, tyingItem);
            setMarginDetail(componentModel);
            getTyingView().updateView(tyingItem, m27793a(componentModel));
            getTyingView().setOnItemClickListener(new TyingItemView$setData$1(this, componentModel));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27795a(CartTyingItemModel cartTyingItemModel, int i) {
        DiRouter.request().path(((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsPurchaseNewStyle ? RoutePath.GOODS_PURCHASE_V2 : RoutePath.GOODS_PURCHASE).putString(Const.PageParams.SHOP_ID, cartTyingItemModel.getShopId()).putString("cart_id", cartTyingItemModel.getCartId()).putString(Const.PageParams.ITEM_ID, cartTyingItemModel.getItemId()).putString(Const.PageParams.ITEM_UNIQ_KEY, cartTyingItemModel.getItemUniqKey()).putInt("from", 9).putSerializable(Const.PageParams.CART_ITEM_ENTITY, cartTyingItemModel.convertModel()).putInt("source", i).open();
    }
}
