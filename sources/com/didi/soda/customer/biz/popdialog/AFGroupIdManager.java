package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.soda.customer.biz.popdialog.AFGroupIdManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.AFGroupEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/AFGroupIdManager;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AFGroupIdManager.kt */
public final class AFGroupIdManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f40450a = "AFGroupIdManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f40451b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static AFGroupMeta f40452c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static AFGroupEntity f40453d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Map<String, ? extends Object> f40454e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static Function2<? super String, ? super String, Unit> f40455f;

    @Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0002JH\u0010(\u001a\u00020\u001e\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010*2\b\u0010+\u001a\u0004\u0018\u0001H)2\b\u0010,\u001a\u0004\u0018\u0001H*2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u001e0\u001dH\b¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u001eJ\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0004H\u0002JJ\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u001dj\u0002`\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/AFGroupIdManager$Companion;", "", "()V", "TAG", "", "afGroupEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/AFGroupEntity;", "getAfGroupEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/AFGroupEntity;", "setAfGroupEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/AFGroupEntity;)V", "conversion", "", "getConversion", "()Ljava/util/Map;", "setConversion", "(Ljava/util/Map;)V", "isFirstLauncher", "", "()Z", "setFirstLauncher", "(Z)V", "meta", "Lcom/didi/soda/customer/biz/popdialog/AFGroupMeta;", "getMeta", "()Lcom/didi/soda/customer/biz/popdialog/AFGroupMeta;", "setMeta", "(Lcom/didi/soda/customer/biz/popdialog/AFGroupMeta;)V", "track", "Lkotlin/Function2;", "", "Lcom/didi/soda/customer/biz/popdialog/TrackCallback;", "clearData", "doDispatch", "uri", "Landroid/net/Uri;", "doFindUriByAFGroup", "errorTrack", "errno", "", "optionalAll", "T", "R", "p1", "p2", "block", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "requestGroupIdMap", "successTrack", "url", "tryParseAdGroup", "groupId", "source", "data", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AFGroupIdManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isFirstLauncher() {
            return AFGroupIdManager.f40451b;
        }

        public final void setFirstLauncher(boolean z) {
            AFGroupIdManager.f40451b = z;
        }

        public final AFGroupMeta getMeta() {
            return AFGroupIdManager.f40452c;
        }

        public final void setMeta(AFGroupMeta aFGroupMeta) {
            AFGroupIdManager.f40452c = aFGroupMeta;
        }

        public final AFGroupEntity getAfGroupEntity() {
            return AFGroupIdManager.f40453d;
        }

        public final void setAfGroupEntity(AFGroupEntity aFGroupEntity) {
            AFGroupIdManager.f40453d = aFGroupEntity;
        }

        public final Map<String, Object> getConversion() {
            return AFGroupIdManager.f40454e;
        }

        public final void setConversion(Map<String, ? extends Object> map) {
            AFGroupIdManager.f40454e = map;
        }

        public final void tryParseAdGroup(String str, String str2, Map<String, ? extends Object> map, Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(str, "groupId");
            Intrinsics.checkNotNullParameter(str2, "source");
            Intrinsics.checkNotNullParameter(map, "data");
            Intrinsics.checkNotNullParameter(function2, InvitationPageActivity.TRACK);
            UIHandler.post(new Runnable(str, str2, map, this, function2) {
                public final /* synthetic */ String f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ Map f$2;
                public final /* synthetic */ AFGroupIdManager.Companion f$3;
                public final /* synthetic */ Function2 f$4;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    AFGroupIdManager.Companion.m46867tryParseAdGroup$lambda0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: tryParseAdGroup$lambda-0  reason: not valid java name */
        public static final void m46867tryParseAdGroup$lambda0(String str, String str2, Map map, Companion companion, Function2 function2) {
            Intrinsics.checkNotNullParameter(str, "$groupId");
            Intrinsics.checkNotNullParameter(str2, "$source");
            Intrinsics.checkNotNullParameter(map, "$data");
            Intrinsics.checkNotNullParameter(companion, "this$0");
            Intrinsics.checkNotNullParameter(function2, "$track");
            LogUtil.m29100d(AFGroupIdManager.f40450a, Intrinsics.stringPlus("group id = ", str));
            AFGroupIdManager.Companion.setMeta(new AFGroupMeta(str, str2));
            AFGroupIdManager.Companion.setConversion(map);
            AFGroupIdManager.f40455f = function2;
            AFGroupIdManager.Companion.doFindUriByAFGroup();
        }

        public final void requestGroupIdMap() {
            if (isFirstLauncher()) {
                setFirstLauncher(false);
                LocationUtil.getCurrentLocationOnce(new AFGroupIdManager$Companion$requestGroupIdMap$1(AFGroupIdManager$Companion$requestGroupIdMap$closure$1.INSTANCE));
            }
        }

        /* access modifiers changed from: private */
        public final void doFindUriByAFGroup() {
            LogUtil.m29104i(AFGroupIdManager.f40450a, "meta = " + getMeta() + " entity = " + getAfGroupEntity());
            AFGroupMeta meta = getMeta();
            AFGroupEntity afGroupEntity = getAfGroupEntity();
            if (meta != null && afGroupEntity != null) {
                String findAimGroupInfo = afGroupEntity.findAimGroupInfo(meta.getSource(), meta.getGroupId());
                if (findAimGroupInfo != null) {
                    String decode = Uri.decode(findAimGroupInfo);
                    if (decode == null) {
                        decode = "";
                    }
                    Companion companion = AFGroupIdManager.Companion;
                    Uri parse = Uri.parse(decode);
                    Intrinsics.checkNotNullExpressionValue(parse, "parse(temp)");
                    companion.doDispatch(parse);
                    AFGroupIdManager.Companion.successTrack(decode);
                } else {
                    LogUtil.m29104i(AFGroupIdManager.f40450a, "没有找到对应的uri source = " + meta.getSource() + " group id = " + meta.getGroupId());
                    AFGroupIdManager.Companion.errorTrack(0);
                }
                AFGroupIdManager.Companion.clearData();
            }
        }

        private final void doDispatch(Uri uri) {
            Function0 aFGroupIdManager$Companion$doDispatch$dispatchAction$1 = new AFGroupIdManager$Companion$doDispatch$dispatchAction$1(uri);
            if (LocationUtil.hasValidPoi()) {
                aFGroupIdManager$Companion$doDispatch$dispatchAction$1.invoke();
            } else {
                ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressOnce(new Action2() {
                    public final void call(Object obj, Subscription subscription) {
                        AFGroupIdManager.Companion.m46865doDispatch$lambda2(Function0.this, (AddressEntity) obj, subscription);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: doDispatch$lambda-2  reason: not valid java name */
        public static final void m46865doDispatch$lambda2(Function0 function0, AddressEntity addressEntity, Subscription subscription) {
            Intrinsics.checkNotNullParameter(function0, "$dispatchAction");
            function0.invoke();
        }

        private final void clearData() {
            setMeta((AFGroupMeta) null);
            setAfGroupEntity((AFGroupEntity) null);
            setConversion((Map<String, ? extends Object>) null);
        }

        /* access modifiers changed from: private */
        public final void errorTrack(int i) {
            String str;
            String traceId;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.AppFlyers.DEFERRED_URL_ERROR);
            AFGroupMeta meta = getMeta();
            String str2 = "";
            OmegaTracker.Builder addEventParam = create.addEventParam("adgroupid", meta == null ? str2 : meta.getGroupId());
            Map<String, Object> conversion = getConversion();
            if (conversion == null || (str = GsonUtil.toJson(conversion)) == null) {
                str = str2;
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("conversion", str);
            AFGroupEntity afGroupEntity = getAfGroupEntity();
            if (!(afGroupEntity == null || (traceId = afGroupEntity.getTraceId()) == null)) {
                str2 = traceId;
            }
            addEventParam2.addEventParam("traceid", str2).addEventParam("errno", Integer.valueOf(i)).build().track();
        }

        private final void successTrack(String str) {
            String json;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.AppFlyers.DEFERRED_URL_SUCCESS);
            AFGroupMeta meta = getMeta();
            String str2 = "";
            OmegaTracker.Builder addEventParam = create.addEventParam("adgroupid", meta == null ? str2 : meta.getGroupId());
            Map<String, Object> conversion = getConversion();
            if (!(conversion == null || (json = GsonUtil.toJson(conversion)) == null)) {
                str2 = json;
            }
            addEventParam.addEventParam("conversion", str2).addEventParam("url", str).build().track();
        }

        private final <T, R> void optionalAll(T t, R r, Function2<? super T, ? super R, Unit> function2) {
            if (t != null && r != null) {
                function2.invoke(t, r);
            }
        }
    }
}
