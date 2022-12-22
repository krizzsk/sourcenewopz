package com.didi.soda.order.component.contact;

import android.text.TextUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.p164im.ImMessageHelper;
import com.didi.soda.customer.foundation.rpc.entity.DeliveryInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/order/component/contact/RiderRole;", "Lcom/didi/soda/order/component/contact/AbstractRole;", "orderInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "(Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;)V", "getOrderInfoEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "setOrderInfoEntity", "roleType", "", "getRoleType", "()I", "setRoleType", "(I)V", "virtualCallRoleType", "getVirtualCallRoleType", "setVirtualCallRoleType", "doCall", "", "doIM", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiderRole.kt */
public final class RiderRole extends AbstractRole {

    /* renamed from: a */
    private OrderInfoEntity f43369a;

    /* renamed from: b */
    private int f43370b = 2;

    /* renamed from: c */
    private int f43371c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderRole(OrderInfoEntity orderInfoEntity) {
        super(orderInfoEntity);
        Intrinsics.checkNotNullParameter(orderInfoEntity, "orderInfoEntity");
        this.f43369a = orderInfoEntity;
    }

    public OrderInfoEntity getOrderInfoEntity() {
        return this.f43369a;
    }

    public void setOrderInfoEntity(OrderInfoEntity orderInfoEntity) {
        Intrinsics.checkNotNullParameter(orderInfoEntity, "<set-?>");
        this.f43369a = orderInfoEntity;
    }

    public int getRoleType() {
        return this.f43370b;
    }

    public void setRoleType(int i) {
        this.f43370b = i;
    }

    public int getVirtualCallRoleType() {
        return this.f43371c;
    }

    public void setVirtualCallRoleType(int i) {
        this.f43371c = i;
    }

    public void doIM() {
        int i;
        DeliveryInfoEntity deliveryInfoEntity = getOrderInfoEntity().deliveryInfo;
        if (deliveryInfoEntity == null) {
            return;
        }
        if (!ImMessageHelper.getInstance().shouldUseImMessage(getOrderInfoEntity().imSecret) || TextUtils.isEmpty(deliveryInfoEntity.riderUid)) {
            String str = deliveryInfoEntity.riderPhone;
            Intrinsics.checkNotNullExpressionValue(str, "deliveryInfo.riderPhone");
            getLogTracker("sendRiderMessage ", str, String.valueOf(getOrderInfoEntity().orderIndex)).build().info();
            if (deliveryInfoEntity.riderPhoneProtected == 0) {
                CustomerSystemUtil.sendMessage(GlobalContext.getContext(), deliveryInfoEntity.riderPhone, ResourceHelper.getString(R.string.customer_send_message, String.valueOf(getOrderInfoEntity().orderIndex)));
            } else {
                LogUtil.m29102e("OrderContactUtil", Intrinsics.stringPlus("sendRiderMessage data error， Rider Phone  Is Protected:", getOrderInfoEntity().orderId));
            }
        } else {
            if (getOrderInfoEntity().status <= 400) {
                i = 400;
            } else {
                i = getOrderInfoEntity().status >= 600 ? 600 : 500;
            }
            ImMessageHelper.getInstance().startChatDetailActivity(GlobalContext.getContext(), deliveryInfoEntity.riderUid, getOrderInfoEntity().imSecret, deliveryInfoEntity.riderName, deliveryInfoEntity.riderImg, i, getOrderInfoEntity().orderId, "rider");
        }
    }

    public void doCall() {
        getLogTracker("contactRider").build().info();
        DeliveryInfoEntity deliveryInfoEntity = getOrderInfoEntity().deliveryInfo;
        if (deliveryInfoEntity == null || deliveryInfoEntity.isShowPhoneEntrance != 1) {
            LogUtil.m29102e("OrderContactUtil", Intrinsics.stringPlus("contactRider data error:", getOrderInfoEntity().orderId));
        } else if (deliveryInfoEntity.riderPhoneProtected == 0) {
            CustomerSystemUtil.doCall(GlobalContext.getContext(), deliveryInfoEntity.riderPhone);
        } else {
            virtualTelCall();
        }
    }
}
