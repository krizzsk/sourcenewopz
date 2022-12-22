package com.didi.soda.cart.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.cart.binder.CustomerTyingItemAdapter;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.cart.model.CartTyingModel;
import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.foundation.util.CollectionUtilsKt;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtilOnlyNew;
import com.didi.soda.customer.widget.cart.CartTyingView;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0003\u0018\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerTyingCartBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/cart/binder/CustomerTyingCartBinder$CustomerTyingBinderLogic;", "Lcom/didi/soda/cart/model/CartTyingModel;", "Lcom/didi/soda/cart/binder/CustomerTyingCartBinder$ViewHolder;", "()V", "onItemClickListener", "Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter$OnItemClickListener;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "CustomerTyingBinderLogic", "CustomerTyingBinderLogicImpl", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerTyingCartBinder.kt */
public final class CustomerTyingCartBinder extends CustomerLogicItemBinder<CustomerTyingBinderLogic, CartTyingModel, ViewHolder> {

    /* renamed from: a */
    private CustomerTyingItemAdapter.OnItemClickListener f39893a;

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerTyingCartBinder$CustomerTyingBinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/BinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "()V", "onItemViewVisible", "", "model", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "position", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerTyingCartBinder.kt */
    public static abstract class CustomerTyingBinderLogic extends BinderLogic<EmptyLogicRepo> {
        public abstract void onItemViewVisible(CartTyingItemModel cartTyingItemModel, int i);
    }

    public Class<CartTyingModel> bindDataType() {
        return CartTyingModel.class;
    }

    public final CustomerTyingItemAdapter.OnItemClickListener getOnItemClickListener() {
        return this.f39893a;
    }

    public final void setOnItemClickListener(CustomerTyingItemAdapter.OnItemClickListener onItemClickListener) {
        this.f39893a = onItemClickListener;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_binder_tying, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…der_tying, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, CartTyingModel cartTyingModel) {
        CartTyingView cartTyingView;
        ArrayList<CartTyingItemModel> arrayList = null;
        if ((cartTyingModel == null ? null : cartTyingModel.getCartItems()) != null && viewHolder != null && (cartTyingView = viewHolder.getCartTyingView()) != null) {
            CartTyingView.updateView$default(cartTyingView, cartTyingModel, (RoundedCornersTransformation.CornerType) null, 2, (Object) null);
            cartTyingView.setOnItemClickListener(getOnItemClickListener());
            if (cartTyingModel != null) {
                arrayList = cartTyingModel.getCartItems();
            }
            FloatingCartOmegaHelper.Companion.trackTyingShow("1", cartTyingModel.getCartId(), cartTyingModel.getShopId(), CollectionUtilsKt.dividerBy(arrayList, ",", CustomerTyingCartBinder$bind$1$itemList$1.INSTANCE));
            new CustomeRvExposeUtilOnlyNew().setRecyclerItemExposeListener(cartTyingView.getMRv(), new CustomeRvExposeUtil.OnItemExposeListener(cartTyingModel) {
                public final /* synthetic */ CartTyingModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onItemViewVisible(int i) {
                    CustomerTyingCartBinder.m28452a(CustomerTyingCartBinder.this, this.f$1, i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28452a(CustomerTyingCartBinder customerTyingCartBinder, CartTyingModel cartTyingModel, int i) {
        Intrinsics.checkNotNullParameter(customerTyingCartBinder, "this$0");
        ((CustomerTyingBinderLogic) customerTyingCartBinder.getBinderLogic()).onItemViewVisible(cartTyingModel.getCartItems().get(i), i);
    }

    public CustomerTyingBinderLogic onCreateBinderLogic() {
        return new CustomerTyingBinderLogicImpl();
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerTyingCartBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/cart/model/CartTyingModel;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "cartTyingView", "Lcom/didi/soda/customer/widget/cart/CartTyingView;", "getCartTyingView", "()Lcom/didi/soda/customer/widget/cart/CartTyingView;", "setCartTyingView", "(Lcom/didi/soda/customer/widget/cart/CartTyingView;)V", "getView", "()Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerTyingCartBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<CartTyingModel> {
        private CartTyingView cartTyingView;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.cartTyingView = (CartTyingView) view2.findViewById(R.id.cartTying);
        }

        public final View getView() {
            return this.view;
        }

        public final CartTyingView getCartTyingView() {
            return this.cartTyingView;
        }

        public final void setCartTyingView(CartTyingView cartTyingView2) {
            this.cartTyingView = cartTyingView2;
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerTyingCartBinder$CustomerTyingBinderLogicImpl;", "Lcom/didi/soda/cart/binder/CustomerTyingCartBinder$CustomerTyingBinderLogic;", "()V", "bindLogicRepoType", "Ljava/lang/Class;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "onItemViewVisible", "", "model", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "position", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerTyingCartBinder.kt */
    public static final class CustomerTyingBinderLogicImpl extends CustomerTyingBinderLogic {
        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }

        public void onItemViewVisible(CartTyingItemModel cartTyingItemModel, int i) {
            if (cartTyingItemModel != null) {
                FloatingCartOmegaHelper.Companion.trackTyingItemRealShow("1", cartTyingItemModel);
            }
        }
    }
}
