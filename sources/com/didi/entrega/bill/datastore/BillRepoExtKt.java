package com.didi.entrega.bill.datastore;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.rpc.entity.CouponInfo;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.rpc.entity.TipFeeInfo;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\n*\u00020\u000b\u001a\u0012\u0010\r\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u0010\u0010\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0012\u0010\u0013\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010\u0016\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u0019\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u001a\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"SWITCH_ADDRESS", "", "UPDATE_ALL_INFO", "UPDATE_COUPON", "UPDATE_PACKAGE_INFO", "UPDATE_PAY_CHANNEL", "UPDATE_RECEIVER_ADDRESS", "UPDATE_SENDER_ADDRESS", "UPDATE_TIP", "switchAddress", "", "Lcom/didi/entrega/bill/datastore/BillRepo;", "updateAllInfo", "updateCoupon", "coupon", "Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;", "updatePackageInfo", "packageInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "updatePayChannel", "payChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "updateReceiverAddress", "address", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "updateSenderAddress", "updateTip", "tip", "Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRepoExt.kt */
public final class BillRepoExtKt {
    public static final int UPDATE_COUPON = 8;
    public static final int UPDATE_TIP = 5;

    /* renamed from: a */
    private static final int f19499a = 2;

    /* renamed from: b */
    private static final int f19500b = 12;

    /* renamed from: c */
    private static final int f19501c = 13;

    /* renamed from: d */
    private static final int f19502d = 14;

    /* renamed from: e */
    private static final int f19503e = 15;

    /* renamed from: f */
    private static final int f19504f = 16;

    public static final void updateSenderAddress(BillRepo billRepo, AddressEntity addressEntity) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        Intrinsics.checkNotNullParameter(addressEntity, "address");
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(12);
        billUpdateRequest.setSenderAddress(addressEntity);
        billRepo.update(billUpdateRequest);
    }

    public static final void updateReceiverAddress(BillRepo billRepo, AddressEntity addressEntity) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        Intrinsics.checkNotNullParameter(addressEntity, "address");
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(13);
        billUpdateRequest.setReceiverAddress(addressEntity);
        billRepo.update(billUpdateRequest);
    }

    public static final void updatePackageInfo(BillRepo billRepo, ContactStufEntity contactStufEntity) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        Intrinsics.checkNotNullParameter(contactStufEntity, Const.BundleKey.INFO_PAGE_BILL_STUFF);
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(15);
        billUpdateRequest.setPackageInfo(contactStufEntity);
        billRepo.update(billUpdateRequest);
    }

    public static final void switchAddress(BillRepo billRepo) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(14);
        billRepo.update(billUpdateRequest);
    }

    public static final void updatePayChannel(BillRepo billRepo, PayChannel payChannel) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        Intrinsics.checkNotNullParameter(payChannel, "payChannel");
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(2);
        billUpdateRequest.setPayChannel(payChannel);
        billRepo.update(billUpdateRequest);
    }

    public static final void updateAllInfo(BillRepo billRepo) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(16);
        billUpdateRequest.setPackageInfo(((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getContStuf());
        billRepo.update(billUpdateRequest);
    }

    public static final void updateTip(BillRepo billRepo, TipFeeInfo tipFeeInfo) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        Intrinsics.checkNotNullParameter(tipFeeInfo, "tip");
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(5);
        billUpdateRequest.setTipFee(tipFeeInfo);
        billRepo.update(billUpdateRequest);
    }

    public static final void updateCoupon(BillRepo billRepo, CouponInfo couponInfo) {
        Intrinsics.checkNotNullParameter(billRepo, "<this>");
        Intrinsics.checkNotNullParameter(couponInfo, "coupon");
        BillUpdateRequest billUpdateRequest = new BillUpdateRequest();
        billUpdateRequest.setUpdateType(8);
        billUpdateRequest.setPlatCoupon(couponInfo);
        billRepo.update(billUpdateRequest);
    }
}
