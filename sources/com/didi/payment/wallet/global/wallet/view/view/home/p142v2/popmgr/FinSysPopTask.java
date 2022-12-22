package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import android.content.Context;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.CommonResourceState;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.ResourceStateData;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/FinSysPopTask;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask;", "taskId", "", "(I)V", "bizData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/CommonResourceState;", "onFinish", "Lkotlin/Function0;", "", "getOnFinish", "()Lkotlin/jvm/functions/Function0;", "setOnFinish", "(Lkotlin/jvm/functions/Function0;)V", "canShow", "", "context", "Landroid/content/Context;", "dismiss", "reqData", "setData", "data", "show", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.FinSysPopTask */
/* compiled from: FinSysPopTask.kt */
public final class FinSysPopTask extends PopTask {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final String f32760c = "DDF-FinSysPopTask";

    /* renamed from: a */
    private CommonResourceState f32761a;

    /* renamed from: b */
    private Function0<Unit> f32762b = FinSysPopTask$onFinish$1.INSTANCE;

    public void dismiss(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/FinSysPopTask$Companion;", "", "()V", "TAG", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.FinSysPopTask$Companion */
    /* compiled from: FinSysPopTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FinSysPopTask(int i) {
        super(i, 1);
    }

    public final Function0<Unit> getOnFinish() {
        return this.f32762b;
    }

    public final void setOnFinish(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f32762b = function0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.ResourceStateData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canShow(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.CommonResourceState r9 = r8.f32761a
            r0 = 0
            if (r9 != 0) goto L_0x000b
            goto L_0x0019
        L_0x000b:
            java.util.List r9 = r9.getPopUpState()
            if (r9 != 0) goto L_0x0012
            goto L_0x0019
        L_0x0012:
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
            r0 = r9
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.ResourceStateData r0 = (com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.ResourceStateData) r0
        L_0x0019:
            if (r0 == 0) goto L_0x001d
            r9 = 1
            goto L_0x001e
        L_0x001d:
            r9 = 0
        L_0x001e:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)
            java.lang.String r1 = "canShow = "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            r2 = 6
            r5 = 0
            r7 = 22
            java.lang.String r3 = "DDF-FinSysPopTask"
            java.lang.String r6 = "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.FinSysPopTask"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr.FinSysPopTask.canShow(android.content.Context):boolean");
    }

    public void show(Context context) {
        List<ResourceStateData> popUpState;
        ResourceStateData resourceStateData;
        Intrinsics.checkNotNullParameter(context, "context");
        SystemUtils.log(6, f32760c, "show", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.FinSysPopTask", 27);
        CommonResourceState commonResourceState = this.f32761a;
        if (commonResourceState != null && (popUpState = commonResourceState.getPopUpState()) != null && (resourceStateData = (ResourceStateData) CollectionsKt.firstOrNull(popUpState)) != null) {
            ((Request) ((Request) ((Request) ((Request) ((Request) ((Request) ((Request) DRouter.build("99OneTravel://one/fintech_resources_page").putExtra(InvitationPageActivity.RESOURCE_ID, resourceStateData.getResourceId())).putExtra("planId", resourceStateData.getPlanId())).putExtra("resourceType", resourceStateData.getResourceType())).putExtra("activityId", resourceStateData.getActivityId())).putExtra("title", resourceStateData.getTitle())).putExtra("link", resourceStateData.getLink())).putExtra("image", resourceStateData.getImage())).start(context);
        }
    }

    public void reqData(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onFinish");
        SystemUtils.log(6, f32760c, "reqData start", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.FinSysPopTask", 49);
        setStatus(1);
        this.f32762b = function0;
    }

    public final void setData(CommonResourceState commonResourceState) {
        setStatus(2);
        this.f32761a = commonResourceState;
        SystemUtils.log(6, f32760c, "reqData end", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.FinSysPopTask", 57);
        this.f32762b.invoke();
    }
}
