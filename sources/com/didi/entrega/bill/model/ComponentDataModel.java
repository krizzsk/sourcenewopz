package com.didi.entrega.bill.model;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.bill.model.CouponModel;
import com.didi.entrega.customer.foundation.rpc.entity.BillExtraData;
import com.didi.entrega.customer.foundation.rpc.entity.CouponInfo;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00061"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/ComponentDataModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "couponModel", "Lcom/didi/entrega/bill/model/CouponModel;", "getCouponModel", "()Lcom/didi/entrega/bill/model/CouponModel;", "setCouponModel", "(Lcom/didi/entrega/bill/model/CouponModel;)V", "payChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "getPayChannel", "()Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "setPayChannel", "(Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;)V", "pkgInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "getPkgInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "setPkgInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;)V", "priceInfoModel", "Lcom/didi/entrega/bill/model/PriceInfoModel;", "getPriceInfoModel", "()Lcom/didi/entrega/bill/model/PriceInfoModel;", "setPriceInfoModel", "(Lcom/didi/entrega/bill/model/PriceInfoModel;)V", "receiverModel", "Lcom/didi/entrega/bill/model/AddressModel;", "getReceiverModel", "()Lcom/didi/entrega/bill/model/AddressModel;", "setReceiverModel", "(Lcom/didi/entrega/bill/model/AddressModel;)V", "senderModel", "getSenderModel", "setSenderModel", "tipModel", "Lcom/didi/entrega/bill/model/BillTipModel;", "getTipModel", "()Lcom/didi/entrega/bill/model/BillTipModel;", "setTipModel", "(Lcom/didi/entrega/bill/model/BillTipModel;)V", "topTips", "", "getTopTips", "()Ljava/lang/CharSequence;", "setTopTips", "(Ljava/lang/CharSequence;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentModel.kt */
public final class ComponentDataModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CharSequence f19530a = "";

    /* renamed from: b */
    private AddressModel f19531b;

    /* renamed from: c */
    private AddressModel f19532c;

    /* renamed from: d */
    private PayChannel f19533d;

    /* renamed from: e */
    private ContactStufEntity f19534e;

    /* renamed from: f */
    private PriceInfoModel f19535f;

    /* renamed from: g */
    private CouponModel f19536g;

    /* renamed from: h */
    private BillTipModel f19537h;

    public final CharSequence getTopTips() {
        return this.f19530a;
    }

    public final void setTopTips(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.f19530a = charSequence;
    }

    public final AddressModel getReceiverModel() {
        return this.f19531b;
    }

    public final void setReceiverModel(AddressModel addressModel) {
        this.f19531b = addressModel;
    }

    public final AddressModel getSenderModel() {
        return this.f19532c;
    }

    public final void setSenderModel(AddressModel addressModel) {
        this.f19532c = addressModel;
    }

    public final PayChannel getPayChannel() {
        return this.f19533d;
    }

    public final void setPayChannel(PayChannel payChannel) {
        this.f19533d = payChannel;
    }

    public final ContactStufEntity getPkgInfo() {
        return this.f19534e;
    }

    public final void setPkgInfo(ContactStufEntity contactStufEntity) {
        this.f19534e = contactStufEntity;
    }

    public final PriceInfoModel getPriceInfoModel() {
        return this.f19535f;
    }

    public final void setPriceInfoModel(PriceInfoModel priceInfoModel) {
        this.f19535f = priceInfoModel;
    }

    public final CouponModel getCouponModel() {
        return this.f19536g;
    }

    public final void setCouponModel(CouponModel couponModel) {
        this.f19536g = couponModel;
    }

    public final BillTipModel getTipModel() {
        return this.f19537h;
    }

    public final void setTipModel(BillTipModel billTipModel) {
        this.f19537h = billTipModel;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/ComponentDataModel$Companion;", "", "()V", "convert", "Lcom/didi/entrega/bill/model/ComponentDataModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "data", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillExtraData;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComponentModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ComponentDataModel convert(ScopeContext scopeContext, BillExtraData billExtraData) {
            String str;
            PayChannel payChannel;
            ContactStufEntity contactStufEntity;
            String str2;
            String str3;
            ComponentDataModel componentDataModel = new ComponentDataModel();
            CouponInfo couponInfo = null;
            if (billExtraData == null) {
                str = null;
            } else {
                str = billExtraData.getTopTips();
            }
            String str4 = "";
            if (str == null) {
                str = str4;
            }
            componentDataModel.setTopTips(str);
            if (billExtraData == null) {
                payChannel = null;
            } else {
                payChannel = billExtraData.getPayChannel();
            }
            componentDataModel.setPayChannel(payChannel);
            if (billExtraData == null) {
                contactStufEntity = null;
            } else {
                contactStufEntity = billExtraData.getPackageInfo();
            }
            componentDataModel.setPkgInfo(contactStufEntity);
            AddressModel convert = AddressModel.Companion.convert(scopeContext, AddressType.RECEIVER, billExtraData == null ? null : billExtraData.getReceiverAddress());
            if (convert != null) {
                if (billExtraData == null) {
                    str3 = null;
                } else {
                    str3 = billExtraData.getReceiverTitle();
                }
                if (str3 == null) {
                    str3 = str4;
                }
                convert.setMarkerLabel(str3);
            }
            Unit unit = Unit.INSTANCE;
            componentDataModel.setReceiverModel(convert);
            AddressModel convert2 = AddressModel.Companion.convert(scopeContext, AddressType.SENDER, billExtraData == null ? null : billExtraData.getSenderAddress());
            if (convert2 != null) {
                if (billExtraData == null) {
                    str2 = null;
                } else {
                    str2 = billExtraData.getSenderTitle();
                }
                if (str2 != null) {
                    str4 = str2;
                }
                convert2.setMarkerLabel(str4);
            }
            Unit unit2 = Unit.INSTANCE;
            componentDataModel.setSenderModel(convert2);
            componentDataModel.setPriceInfoModel(PriceInfoModel.Companion.convertModel(billExtraData == null ? null : billExtraData.getPriceInfo()));
            componentDataModel.setTipModel(new BillTipModel().convertModel(billExtraData == null ? null : billExtraData.getTipFeeInfo()));
            CouponModel.Companion companion = CouponModel.Companion;
            if (billExtraData != null) {
                couponInfo = billExtraData.getCouponInfo();
            }
            componentDataModel.setCouponModel(companion.convertModel(couponInfo));
            return componentDataModel;
        }
    }
}
