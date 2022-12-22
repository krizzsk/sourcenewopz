package com.didi.entrega.order.contact;

import android.content.Context;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.p112im.ImMessageHelper;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderRiderInfo;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/RiderRole;", "Lcom/didi/entrega/order/contact/AbstractRole;", "orderInfoEntity", "Lcom/didi/entrega/order/contact/IMContactModel;", "(Lcom/didi/entrega/order/contact/IMContactModel;)V", "getOrderInfoEntity", "()Lcom/didi/entrega/order/contact/IMContactModel;", "setOrderInfoEntity", "roleType", "", "getRoleType", "()I", "setRoleType", "(I)V", "virtualCallRoleType", "getVirtualCallRoleType", "setVirtualCallRoleType", "doCall", "", "doIM", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiderRole.kt */
public final class RiderRole extends AbstractRole {

    /* renamed from: a */
    private IMContactModel f20868a;

    /* renamed from: b */
    private int f20869b = 2;

    /* renamed from: c */
    private int f20870c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderRole(IMContactModel iMContactModel) {
        super(iMContactModel);
        Intrinsics.checkNotNullParameter(iMContactModel, "orderInfoEntity");
        this.f20868a = iMContactModel;
    }

    public IMContactModel getOrderInfoEntity() {
        return this.f20868a;
    }

    public void setOrderInfoEntity(IMContactModel iMContactModel) {
        Intrinsics.checkNotNullParameter(iMContactModel, "<set-?>");
        this.f20868a = iMContactModel;
    }

    public int getRoleType() {
        return this.f20869b;
    }

    public void setRoleType(int i) {
        this.f20869b = i;
    }

    public int getVirtualCallRoleType() {
        return this.f20870c;
    }

    public void setVirtualCallRoleType(int i) {
        this.f20870c = i;
    }

    public void doIM() {
        OrderRiderInfo rideInfo = getOrderInfoEntity().getRideInfo();
        if (rideInfo != null) {
            ImMessageHelper instance = ImMessageHelper.getInstance();
            OrderRiderInfo rideInfo2 = getOrderInfoEntity().getRideInfo();
            String str = null;
            if (instance.shouldUseImMessage(rideInfo2 == null ? null : rideInfo2.getImSecret()) && !TextUtils.isEmpty(rideInfo.getRiderUid())) {
                ImMessageHelper instance2 = ImMessageHelper.getInstance();
                Context context = GlobalContext.getContext();
                String riderUid = rideInfo.getRiderUid();
                OrderRiderInfo rideInfo3 = getOrderInfoEntity().getRideInfo();
                if (rideInfo3 != null) {
                    str = rideInfo3.getImSecret();
                }
                instance2.startChatDetailActivity(context, riderUid, str, rideInfo.getName(), rideInfo.getHeadPic(), 0, getOrderInfoEntity().getOrderId(), "rider");
            } else if (rideInfo.getPhoneProtected() == 0) {
                CustomerSystemUtil.sendMessage(GlobalContext.getContext(), rideInfo.getPhone(), ResourceHelper.getString(R.string.FoodC_IM2_Online_chat_Vwid));
            } else {
                LogUtil.m14763e("OrderContactUtil", Intrinsics.stringPlus("sendRiderMessage data error， Rider Phone  Is Protected:", getOrderInfoEntity().getOrderId()));
            }
        }
    }

    public void doCall() {
        OrderRiderInfo rideInfo = getOrderInfoEntity().getRideInfo();
        boolean z = false;
        if (rideInfo != null && rideInfo.getPhoneProtected() == 0) {
            z = true;
        }
        if (z) {
            CustomerSystemUtil.doCall(GlobalContext.getContext(), rideInfo.getPhone());
        } else {
            virtualTelCall();
        }
    }
}
