package com.didi.entrega.order.contact;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.BillExtKt;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderRiderInfo;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.widget.dialog.NumProtectModel;
import com.didi.entrega.order.contact.dialog.INumProtect;
import com.didi.entrega.order.contact.dialog.NumProtectActivityDialog;
import com.didi.entrega.order.contact.dialog.NumProtectPageDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 )2\u00020\u0001:\u0002)*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u001eH&J$\u0010 \u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\u000fH\u0016J\u001f\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%\"\u00020&¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u001eH\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006+"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/AbstractRole;", "Lcom/didi/entrega/order/contact/IRole;", "orderInfoEntity", "Lcom/didi/entrega/order/contact/IMContactModel;", "(Lcom/didi/entrega/order/contact/IMContactModel;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getOrderInfoEntity", "()Lcom/didi/entrega/order/contact/IMContactModel;", "setOrderInfoEntity", "roleType", "", "getRoleType", "()I", "setRoleType", "(I)V", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "virtualCallRoleType", "getVirtualCallRoleType", "setVirtualCallRoleType", "doCall", "", "doIM", "doRealContact", "contactWay", "getLogTracker", "Lcom/didi/entrega/customer/foundation/log/RecordTracker$Builder;", "message", "", "", "([Ljava/lang/String;)Lcom/didi/entrega/customer/foundation/log/RecordTracker$Builder;", "virtualTelCall", "Companion", "DialogController", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbstractRole.kt */
public abstract class AbstractRole implements IRole {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "OrderContactUtil";
    public static final int VIRTUAL_CALL_ROLE_BUSINESS = 1;
    public static final int VIRTUAL_CALL_ROLE_RIDER = 0;

    /* renamed from: a */
    private IMContactModel f20859a;

    /* renamed from: b */
    private ScopeContext f20860b;
    public Context context;

    public abstract void doCall();

    public abstract void doIM();

    public abstract int getRoleType();

    public abstract int getVirtualCallRoleType();

    public abstract void setRoleType(int i);

    public abstract void setVirtualCallRoleType(int i);

    public AbstractRole(IMContactModel iMContactModel) {
        Intrinsics.checkNotNullParameter(iMContactModel, "orderInfoEntity");
        this.f20859a = iMContactModel;
    }

    public IMContactModel getOrderInfoEntity() {
        return this.f20859a;
    }

    public void setOrderInfoEntity(IMContactModel iMContactModel) {
        Intrinsics.checkNotNullParameter(iMContactModel, "<set-?>");
        this.f20859a = iMContactModel;
    }

    public final ScopeContext getScopeContext() {
        return this.f20860b;
    }

    public final void setScopeContext(ScopeContext scopeContext) {
        this.f20860b = scopeContext;
    }

    public final Context getContext() {
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public void doRealContact(Context context2, ScopeContext scopeContext, int i) {
        if (context2 == null) {
            context2 = GlobalContext.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        }
        setContext(context2);
        this.f20860b = scopeContext;
        if (i == 11) {
            doIM();
        } else if (i == 22) {
            doCall();
        }
    }

    /* access modifiers changed from: protected */
    public final void virtualTelCall() {
        LogUtil.m14761d("OrderContactUtil", "virtualTelCall + 0 rider/1 shop = 0");
        OrderRiderInfo rideInfo = getOrderInfoEntity().getRideInfo();
        Integer num = null;
        String senderPhone = rideInfo == null ? null : rideInfo.getSenderPhone();
        String str = "";
        if (senderPhone == null) {
            senderPhone = str;
        }
        OrderRiderInfo rideInfo2 = getOrderInfoEntity().getRideInfo();
        String senderCallingCode = rideInfo2 == null ? null : rideInfo2.getSenderCallingCode();
        if (senderCallingCode == null) {
            senderCallingCode = str;
        }
        if (TextUtils.isEmpty(senderCallingCode)) {
            senderCallingCode = LoginUtil.getCallingCode();
            Intrinsics.checkNotNullExpressionValue(senderCallingCode, "getCallingCode()");
        }
        OrderRiderInfo rideInfo3 = getOrderInfoEntity().getRideInfo();
        if (rideInfo3 != null) {
            num = Integer.valueOf(rideInfo3.getSenderPhoneCountryId());
        }
        int orZero = BillExtKt.orZero(num);
        if (orZero <= 0) {
            orZero = LoginUtil.getCountryId();
        }
        NumProtectModel numProtectModel = new NumProtectModel(senderPhone, senderCallingCode, orZero);
        INumProtect buildDialog = DialogController.INSTANCE.buildDialog(getContext(), this.f20860b);
        String orderId = getOrderInfoEntity().getOrderId();
        if (orderId != null) {
            str = orderId;
        }
        buildDialog.showNumProtectDialog(numProtectModel, str, getVirtualCallRoleType());
    }

    public final RecordTracker.Builder getLogTracker(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "message");
        StringBuilder sb = new StringBuilder();
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        RecordTracker.Builder otherParam = RecordTracker.Builder.create().setTag("OrderContactUtil").setLogModule("m-odr|").setMessage(sb.toString()).setLogCategory("c-state|").setOtherParam("orderId", getOrderInfoEntity().getOrderId());
        Intrinsics.checkNotNullExpressionValue(otherParam, "create()\n               … orderInfoEntity.orderId)");
        return otherParam;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/AbstractRole$Companion;", "", "()V", "TAG", "", "VIRTUAL_CALL_ROLE_BUSINESS", "", "VIRTUAL_CALL_ROLE_RIDER", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AbstractRole.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/AbstractRole$DialogController;", "", "()V", "buildDialog", "Lcom/didi/entrega/order/contact/dialog/INumProtect;", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AbstractRole.kt */
    public static final class DialogController {
        public static final DialogController INSTANCE = new DialogController();

        private DialogController() {
        }

        public final INumProtect buildDialog(Context context, ScopeContext scopeContext) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (scopeContext != null) {
                return new NumProtectPageDialog(context, scopeContext);
            }
            return new NumProtectActivityDialog(context);
        }
    }
}
