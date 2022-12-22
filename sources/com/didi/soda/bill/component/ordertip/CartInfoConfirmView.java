package com.didi.soda.bill.component.ordertip;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006-"}, mo175978d2 = {"Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmView;", "Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "mAddressHouseNumTv", "Landroid/widget/TextView;", "getMAddressHouseNumTv", "()Landroid/widget/TextView;", "setMAddressHouseNumTv", "(Landroid/widget/TextView;)V", "mAddressTv", "getMAddressTv", "setMAddressTv", "mConfirmBtn", "Landroid/view/View;", "getMConfirmBtn", "()Landroid/view/View;", "setMConfirmBtn", "(Landroid/view/View;)V", "mEditBtn", "getMEditBtn", "setMEditBtn", "mPaymentCardNumTv", "getMPaymentCardNumTv", "setMPaymentCardNumTv", "mPaymentIconTv", "Landroid/widget/ImageView;", "getMPaymentIconTv", "()Landroid/widget/ImageView;", "setMPaymentIconTv", "(Landroid/widget/ImageView;)V", "mPaymentTitleTv", "getMPaymentTitleTv", "setMPaymentTitleTv", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "init", "", "onCreate", "setData", "payChannelEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartInfoConfirmView.kt */
public final class CartInfoConfirmView extends Contract.AbsCartInfoConfirmView implements IRFFloatingExpand {
    public TextView mAddressHouseNumTv;
    public TextView mAddressTv;
    public View mConfirmBtn;
    public View mEditBtn;
    public TextView mPaymentCardNumTv;
    public ImageView mPaymentIconTv;
    public TextView mPaymentTitleTv;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public final TextView getMAddressTv() {
        TextView textView = this.mAddressTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAddressTv");
        return null;
    }

    public final void setMAddressTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mAddressTv = textView;
    }

    public final TextView getMAddressHouseNumTv() {
        TextView textView = this.mAddressHouseNumTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAddressHouseNumTv");
        return null;
    }

    public final void setMAddressHouseNumTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mAddressHouseNumTv = textView;
    }

    public final TextView getMPaymentTitleTv() {
        TextView textView = this.mPaymentTitleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPaymentTitleTv");
        return null;
    }

    public final void setMPaymentTitleTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mPaymentTitleTv = textView;
    }

    public final ImageView getMPaymentIconTv() {
        ImageView imageView = this.mPaymentIconTv;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPaymentIconTv");
        return null;
    }

    public final void setMPaymentIconTv(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mPaymentIconTv = imageView;
    }

    public final TextView getMPaymentCardNumTv() {
        TextView textView = this.mPaymentCardNumTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPaymentCardNumTv");
        return null;
    }

    public final void setMPaymentCardNumTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mPaymentCardNumTv = textView;
    }

    public final View getMConfirmBtn() {
        View view = this.mConfirmBtn;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
        return null;
    }

    public final void setMConfirmBtn(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mConfirmBtn = view;
    }

    public final View getMEditBtn() {
        View view = this.mEditBtn;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEditBtn");
        return null;
    }

    public final void setMEditBtn(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mEditBtn = view;
    }

    public void onCreate() {
        super.onCreate();
        m27663a();
    }

    /* renamed from: a */
    private final void m27663a() {
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    CartInfoConfirmView.m27664a(CartInfoConfirmView.this, view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.customer_place_order_dialog_title)).build());
            navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27664a(CartInfoConfirmView cartInfoConfirmView, View view) {
        Intrinsics.checkNotNullParameter(cartInfoConfirmView, "this$0");
        ((Contract.AbsCartInfoConfirmPresenter) cartInfoConfirmView.getPresenter()).onClickBack();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_item_place_order_tip_content, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_custom_address_address);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById…r_custom_address_address)");
        setMAddressTv((TextView) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_custom_address_hourse_number);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById…om_address_hourse_number)");
        setMAddressHouseNumTv((TextView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_custom_payment_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById…mer_custom_payment_title)");
        setMPaymentTitleTv((TextView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_iv_payment_card_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById…mer_iv_payment_card_icon)");
        setMPaymentIconTv((ImageView) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.customer_custom_payment_card_number);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById…stom_payment_card_number)");
        setMPaymentCardNumTv((TextView) findViewById5);
        View findViewById6 = viewGroup.findViewById(R.id.customer_custom_payment_submit);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "container.findViewById(R…er_custom_payment_submit)");
        setMConfirmBtn(findViewById6);
        View findViewById7 = viewGroup.findViewById(R.id.customer_custom_payment_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "container.findViewById(R…er_custom_payment_cancel)");
        setMEditBtn(findViewById7);
        getMConfirmBtn().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CartInfoConfirmView.m27665b(CartInfoConfirmView.this, view);
            }
        });
        getMEditBtn().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CartInfoConfirmView.m27666c(CartInfoConfirmView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ditInfo()\n        }\n    }");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27665b(CartInfoConfirmView cartInfoConfirmView, View view) {
        Intrinsics.checkNotNullParameter(cartInfoConfirmView, "this$0");
        ((Contract.AbsCartInfoConfirmPresenter) cartInfoConfirmView.getPresenter()).onConfirm();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m27666c(CartInfoConfirmView cartInfoConfirmView, View view) {
        Intrinsics.checkNotNullParameter(cartInfoConfirmView, "this$0");
        ((Contract.AbsCartInfoConfirmPresenter) cartInfoConfirmView.getPresenter()).onEditInfo();
    }

    public void setData(PayChannelEntity payChannelEntity) {
        Intrinsics.checkNotNullParameter(payChannelEntity, "payChannelEntity");
        AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
        if (delieveryAddress.poi == null || TextUtils.isEmpty(delieveryAddress.poi.displayName)) {
            getMAddressTv().setVisibility(8);
        } else {
            getMAddressTv().setText(delieveryAddress.poi.displayName);
        }
        CharSequence aptAndBuildingName = delieveryAddress.getAptAndBuildingName();
        if (!TextUtils.isEmpty(aptAndBuildingName)) {
            getMAddressHouseNumTv().setText(aptAndBuildingName);
        } else {
            getMAddressHouseNumTv().setVisibility(8);
        }
        getMPaymentTitleTv().setText(payChannelEntity.payTypeDesc);
        FlyImageLoader.loadImageUnspecified(getContext(), payChannelEntity.cardOrg).into(getMPaymentIconTv());
        CharSequence payMethodChannelName = PayMethodListInfoEntity.getPayMethodChannelName(payChannelEntity.channelId, payChannelEntity.channelName, payChannelEntity.cardSuffix, false);
        if (!TextUtils.isEmpty(payMethodChannelName)) {
            getMPaymentCardNumTv().setText(payMethodChannelName);
        } else {
            getMPaymentCardNumTv().setVisibility(8);
        }
    }
}
