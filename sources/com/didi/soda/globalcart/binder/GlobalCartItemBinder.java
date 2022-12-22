package com.didi.soda.globalcart.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.SectionModel;
import com.didi.soda.bill.model.datamodel.ShopInfoModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.BillItemViewFactory;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.cart.listener.OnCartItemOperateListener;
import com.didi.soda.globalcart.model.BillInfoRvModel;
import com.didi.soda.globalcart.view.BillItemsInfoItemView;
import com.didi.soda.globalcart.view.BillTotalPriceItemView;
import com.didi.soda.globalcart.view.DividerItemView;
import com.didi.soda.globalcart.view.GlobalCartHeaderInfoLayout;
import com.taxis99.R;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u00012\u00020\u0004:\u0001\u0017B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J\u001e\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/globalcart/binder/GlobalCartItemBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/globalcart/model/BillInfoRvModel;", "Lcom/didi/soda/globalcart/binder/GlobalCartItemBinder$ViewHolder;", "Lcom/didi/soda/cart/listener/OnCartItemOperateListener;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "itemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;)V", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "bind", "", "holder", "list", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartItemBinder.kt */
public abstract class GlobalCartItemBinder extends ItemBinder<BillInfoRvModel, ViewHolder> implements OnCartItemOperateListener {
    private final ScopeContext scopeContext;

    public Class<BillInfoRvModel> bindDataType() {
        return BillInfoRvModel.class;
    }

    public final ScopeContext getScopeContext() {
        return this.scopeContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCartItemBinder(ScopeContext scopeContext2, ItemDecorator itemDecorator) {
        super(itemDecorator);
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
        this.scopeContext = scopeContext2;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_widget_cart_item_view, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…item_view, parent, false)");
        return new ViewHolder(this, inflate, this.scopeContext);
    }

    public void bind(ViewHolder viewHolder, BillInfoRvModel billInfoRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(billInfoRvModel, "list");
        viewHolder.bindData(billInfoRvModel);
    }

    @Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/globalcart/binder/GlobalCartItemBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/globalcart/model/BillInfoRvModel;", "view", "Landroid/view/View;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/soda/globalcart/binder/GlobalCartItemBinder;Landroid/view/View;Lcom/didi/app/nova/skeleton/ScopeContext;)V", "contentLayout", "Landroid/widget/LinearLayout;", "headerContainer", "Lcom/didi/soda/globalcart/view/GlobalCartHeaderInfoLayout;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "getView", "()Landroid/view/View;", "bindData", "", "billInfo", "bindListener", "itemView", "Lcom/didi/soda/bill/view/BillItemView;", "renderCloseHeaderBackground", "model", "Lcom/didi/soda/bill/model/datamodel/ShopInfoModel;", "renderHeader", "shopInfoModel", "renderHeaderBackground", "renderOpenHeaderBackground", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCartItemBinder.kt */
    public final class ViewHolder extends ItemViewHolder<BillInfoRvModel> {
        private final LinearLayout contentLayout;
        private final GlobalCartHeaderInfoLayout headerContainer;
        private final ScopeContext scopeContext;
        final /* synthetic */ GlobalCartItemBinder this$0;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(GlobalCartItemBinder globalCartItemBinder, View view2, ScopeContext scopeContext2) {
            super(view2);
            Intrinsics.checkNotNullParameter(globalCartItemBinder, "this$0");
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
            this.this$0 = globalCartItemBinder;
            this.view = view2;
            this.scopeContext = scopeContext2;
            View findViewById = view2.findViewById(R.id.customer_cart_header_info);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.customer_cart_header_info)");
            this.headerContainer = (GlobalCartHeaderInfoLayout) findViewById;
            View findViewById2 = this.view.findViewById(R.id.customer_cart_ll_content);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.customer_cart_ll_content)");
            this.contentLayout = (LinearLayout) findViewById2;
        }

        public final ScopeContext getScopeContext() {
            return this.scopeContext;
        }

        public final View getView() {
            return this.view;
        }

        public final void bindData(BillInfoRvModel billInfoRvModel) {
            int size;
            Intrinsics.checkNotNullParameter(billInfoRvModel, "billInfo");
            this.contentLayout.removeAllViews();
            ShopInfoModel shopInfo = billInfoRvModel.getShopInfo();
            renderHeader(shopInfo);
            Collection sections = billInfoRvModel.getSections();
            if (!(sections == null || sections.isEmpty()) && billInfoRvModel.getSections().size() - 1 >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    SectionModel sectionModel = billInfoRvModel.getSections().get(i);
                    Intrinsics.checkNotNullExpressionValue(sectionModel, "billInfo.sections[i]");
                    SectionModel sectionModel2 = sectionModel;
                    int size2 = sectionModel2.getComponents().size() - 1;
                    if (size2 >= 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            ComponentModel componentModel = sectionModel2.getComponents().get(i3);
                            Intrinsics.checkNotNullExpressionValue(componentModel, "sectionModel.components[j]");
                            ComponentModel componentModel2 = componentModel;
                            if (shopInfo != null) {
                                componentModel2.setBusinessOpen(BusinessDataHelper.checkBusinessStatusNormal(shopInfo.getCShopStatus()));
                            }
                            BillItemViewFactory billItemViewFactory = new BillItemViewFactory();
                            Context context = this.view.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "view.context");
                            BillItemView<?> createItemView = billItemViewFactory.createItemView(componentModel2, context, this.scopeContext);
                            bindListener(createItemView);
                            if (createItemView != null) {
                                this.contentLayout.addView(createItemView);
                            }
                            if (i4 > size2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i < billInfoRvModel.getSections().size() - 1) {
                        LinearLayout linearLayout = this.contentLayout;
                        Context context2 = this.view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                        linearLayout.addView(new DividerItemView(context2));
                    }
                    if (i2 <= size) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }

        private final void bindListener(BillItemView<?> billItemView) {
            BillTotalPriceItemView billTotalPriceItemView = null;
            BillItemsInfoItemView billItemsInfoItemView = billItemView instanceof BillItemsInfoItemView ? (BillItemsInfoItemView) billItemView : null;
            if (billItemsInfoItemView != null) {
                billItemsInfoItemView.setOnCartItemOperateListener(this.this$0);
            }
            if (billItemView instanceof BillTotalPriceItemView) {
                billTotalPriceItemView = (BillTotalPriceItemView) billItemView;
            }
            if (billTotalPriceItemView != null) {
                billTotalPriceItemView.setOnCartItemOperateListener(this.this$0);
            }
        }

        private final void renderHeader(ShopInfoModel shopInfoModel) {
            if (shopInfoModel == null) {
                this.headerContainer.setVisibility(8);
                return;
            }
            renderHeaderBackground(shopInfoModel);
            this.headerContainer.bindData(shopInfoModel);
        }

        private final void renderHeaderBackground(ShopInfoModel shopInfoModel) {
            if (shopInfoModel.getCShopStatus() == 1) {
                renderOpenHeaderBackground(this.view, shopInfoModel);
            } else {
                renderCloseHeaderBackground(this.view, shopInfoModel);
            }
        }

        private final void renderOpenHeaderBackground(View view2, ShopInfoModel shopInfoModel) {
            CharSequence closeSoonDesc = shopInfoModel.getCloseSoonDesc();
            if (closeSoonDesc == null || closeSoonDesc.length() == 0) {
                this.headerContainer.setVisibility(8);
                view2.setBackground(view2.getResources().getDrawable(R.drawable.customer_shape_cart_business_container_card));
                return;
            }
            this.headerContainer.setVisibility(0);
            view2.setBackground(view2.getResources().getDrawable(R.drawable.customer_shape_cart_business_container_card_green));
        }

        private final void renderCloseHeaderBackground(View view2, ShopInfoModel shopInfoModel) {
            this.headerContainer.setVisibility(0);
            view2.setBackground(view2.getResources().getDrawable(R.drawable.customer_shape_cart_business_container_card));
        }
    }
}
