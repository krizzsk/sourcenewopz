package com.didi.component.operationpanel.model;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.sharetrip.CommonTripShareInfo;
import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineRegisterKt;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Result;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.sidebar.history.manager.JPInvoiceManager;
import com.didi.sdk.sidebar.history.model.InvoiceOrder;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.travel.infra.rxjava2.DisposableKt;
import com.didiglobal.travel.infra.rxjava2.SingleKt;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.reactivex.Completable;
import p242io.reactivex.Single;
import p242io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo175977d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u000bH\u0002J*\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020!0 0\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J(\u0010#\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100%H\u0002J\u001c\u0010'\u001a\u00020!*\u00020(2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, mo175978d2 = {"Lcom/didi/component/operationpanel/model/OperationPanelModel;", "", "()V", "_shareActionUrl", "", "_shareChannels", "", "Lcom/didi/onekeyshare/entity/SharePlatform;", "_shareLogic", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "_shareManager", "Lcom/didi/component/business/sharetrip/CommonTripShareManager;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "attach", "", "detach", "dismissShare", "doSendReceipt", "operator", "Lcom/didi/sdk/sidebar/history/manager/JPInvoiceManager;", "fm", "Landroidx/fragment/app/FragmentManager;", "doShare", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "ensureShareManager", "prepareShare", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Lcom/didi/onekeyshare/entity/ShareInfo;", "unregisterXEngine", "routeWith", "callback", "Lkotlin/Function1;", "Lcom/didi/drouter/router/Result;", "toShareInfo", "Lcom/didi/component/business/sharetrip/CommonTripShareInfo;", "platforms", "Companion", "comp-operationpanel_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OperationPanelModel.kt */
public final class OperationPanelModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "OperationPanelModel";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f14835a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private XEResponseCallback f14836b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f14837c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<? extends SharePlatform> f14838d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CommonTripShareManager f14839e;

    public final void attach() {
        m10623b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(XERequestKey.SCENE_TRIP);
        this.f14836b = XEngineRegisterKt.registerXEngineLogic(XERequestKey.REQUEST_KEY_SHARE, arrayList, new OperationPanelModel$attach$1(this));
    }

    public final void detach() {
        dismissShare();
        m10623b();
    }

    public final void doShare(Context context, Fragment fragment) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Single andThen = Completable.fromAction(new OperationPanelModel$doShare$1(this)).subscribeOn(AndroidSchedulers.mainThread()).andThen(m10621a(context, fragment));
        Intrinsics.checkNotNullExpressionValue(andThen, "fun doShare(context: Con…osable to lifecycle\n    }");
        DisposableKt.bindLifecycle(SingleKt.subscribeBy(SingleKt.observeOnMain(andThen), new OperationPanelModel$doShare$2(fragment)), fragment);
    }

    public final void dismissShare() {
        CommonTripShareManager commonTripShareManager = this.f14839e;
        if (commonTripShareManager != null) {
            commonTripShareManager.disMissOneKeyShareDialog();
        }
    }

    public final void doSendReceipt(JPInvoiceManager jPInvoiceManager, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(jPInvoiceManager, ErrorConst.ErrorParam.OPERATOR);
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            InvoiceOrder invoiceOrder = new InvoiceOrder();
            invoiceOrder.orderEncode = order.getOid();
            invoiceOrder.productid = order.productid;
            invoiceOrder.countryCode = order.countryCode;
            List listOf = CollectionsKt.listOf(invoiceOrder);
            if (listOf != null) {
                jPInvoiceManager.sendJPInvoice(fragmentManager, listOf);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final CommonTripShareManager m10619a() {
        CommonTripShareManager commonTripShareManager = this.f14839e;
        if (commonTripShareManager == null) {
            synchronized (this) {
                commonTripShareManager = new CommonTripShareManager();
                this.f14839e = commonTripShareManager;
            }
        }
        return commonTripShareManager;
    }

    /* renamed from: a */
    private final Single<Pair<CommonTripShareManager, ShareInfo>> m10621a(Context context, Fragment fragment) {
        CommonTripShareManager commonTripShareManager = this.f14839e;
        if (commonTripShareManager == null) {
            OperationPanelModel operationPanelModel = this;
            Single<Pair<CommonTripShareManager, ShareInfo>> error = Single.error((Throwable) new IllegalStateException("ShareManager not prepared yet."));
            Intrinsics.checkNotNullExpressionValue(error, "error(IllegalStateExcept…ager not prepared yet.\"))");
            return error;
        }
        Single create = Single.create(new OperationPanelModel$prepareShare$1(this, context, fragment, commonTripShareManager));
        Intrinsics.checkNotNullExpressionValue(create, "private fun prepareShare…   .subscribeOnIo()\n    }");
        return SingleKt.subscribeOnIo(create);
    }

    /* renamed from: b */
    private final void m10623b() {
        if (this.f14836b != null) {
            XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_SHARE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m10622a(String str, Context context, Function1<? super Result, Unit> function1) {
        DRouter.build(URLDecoder.decode(str, "UTF-8")).start(context, new OperationPanelModel$sam$com_didi_drouter_router_RouterCallback$0(function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ShareInfo m10620a(CommonTripShareInfo commonTripShareInfo, List<? extends SharePlatform> list) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.title = commonTripShareInfo.shareTitle;
        shareInfo.content = commonTripShareInfo.shareCotent;
        shareInfo.url = commonTripShareInfo.shareUrl;
        shareInfo.imageUrl = commonTripShareInfo.sharePicture;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        shareInfo.platforms = list;
        shareInfo.smsMessage = commonTripShareInfo.shareTitle + ',' + commonTripShareInfo.shareCotent + ' ' + commonTripShareInfo.shareUrl;
        return shareInfo;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/component/operationpanel/model/OperationPanelModel$Companion;", "", "()V", "TAG", "", "comp-operationpanel_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OperationPanelModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
