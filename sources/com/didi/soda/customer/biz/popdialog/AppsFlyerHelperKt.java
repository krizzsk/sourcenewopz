package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a&\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\u000e\u001a\u00020\r\u001a&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"TAG", "", "appLinkAppName", "doDispatchAppLink", "", "map", "", "isCold", "", "doInstantUri", "", "", "handleAppLinkListener", "Lcom/didi/soda/customer/biz/popdialog/SimpleAFConversionListener;", "instantAction", "parseLinkQueryParams", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyerHelper.kt */
public final class AppsFlyerHelperKt {

    /* renamed from: a */
    private static final String f40460a = "AppsFlyerListener";
    public static final String appLinkAppName = "appName";

    public static final Map<String, String> parseLinkQueryParams(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Object obj = map.get("link");
        String obj2 = obj == null ? null : obj.toString();
        if (obj2 != null) {
            Uri parse = Uri.parse(Uri.decode(obj2));
            for (String next : parse.getQueryParameterNames()) {
                String queryParameter = parse.getQueryParameter(next);
                if (queryParameter != null) {
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    linkedHashMap.put(next, queryParameter);
                }
            }
        }
        return linkedHashMap;
    }

    public static final SimpleAFConversionListener handleAppLinkListener(boolean z) {
        return new AppsFlyerHelperKt$handleAppLinkListener$1(new AppsFlyerHelperKt$handleAppLinkListener$handAppLink$1(z));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28676a(Map<String, String> map, boolean z) {
        T t = (String) map.get(Const.CampaignKey.KEY_CAMPAIGN_URL);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CharSequence charSequence = (CharSequence) t;
        if (charSequence == null || charSequence.length() == 0) {
            LogUtil.m29102e(f40460a, Intrinsics.stringPlus("没有配置 rlinkurl link = ", map.get(Const.CampaignKey.KEY_CAMPAIGN_URL)));
            t = (String) map.get("af_dp");
        }
        objectRef.element = t;
        Function0 appsFlyerHelperKt$doDispatchAppLink$dispatch$1 = new AppsFlyerHelperKt$doDispatchAppLink$dispatch$1(objectRef, parseLinkQueryParams(map), z);
        if (LocationUtil.hasValidPoi()) {
            appsFlyerHelperKt$doDispatchAppLink$dispatch$1.invoke();
        } else {
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressOnce(new Action2() {
                public final void call(Object obj, Subscription subscription) {
                    AppsFlyerHelperKt.m28677a(Function0.this, (AddressEntity) obj, subscription);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28677a(Function0 function0, AddressEntity addressEntity, Subscription subscription) {
        Intrinsics.checkNotNullParameter(function0, "$dispatch");
        function0.invoke();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (com.didi.soda.customer.biz.scheme.SchemeHelper.isSodaSchemeUri(android.net.Uri.parse(android.net.Uri.decode(r4))) != false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean doInstantUri(java.util.Map<java.lang.String, ? extends java.lang.Object> r12, boolean r13) {
        /*
            java.lang.Class<com.didi.soda.customer.service.IInstantService> r0 = com.didi.soda.customer.service.IInstantService.class
            com.didi.soda.customer.service.IService r0 = com.didi.soda.customer.service.CustomerServiceManager.getService(r0)
            com.didi.soda.customer.service.IInstantService r0 = (com.didi.soda.customer.service.IInstantService) r0
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            com.didi.soda.customer.foundation.storage.model.InstantConfig r0 = r0.getInstantConfig()
            java.lang.String r2 = r0.instant_app
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            if (r2 == 0) goto L_0x0020
            int r2 = r2.length()
            if (r2 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r2 = 0
            goto L_0x0021
        L_0x0020:
            r2 = 1
        L_0x0021:
            if (r2 != 0) goto L_0x00b8
            boolean r2 = r0.mIsDispatch
            if (r2 == 0) goto L_0x0029
            goto L_0x00b8
        L_0x0029:
            java.lang.String r2 = "Instant"
            java.lang.String r4 = "start do"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29100d(r2, r4)
            java.lang.String r4 = r0.urlString
            boolean r4 = com.didi.soda.customer.foundation.util.NetWorkUtils.isHttpUrl(r4)
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x004e
            java.lang.String r4 = r0.urlString
            if (r4 != 0) goto L_0x0040
            r4 = r5
        L_0x0040:
            java.lang.String r4 = android.net.Uri.decode(r4)
            android.net.Uri r4 = android.net.Uri.parse(r4)
            boolean r4 = com.didi.soda.customer.biz.scheme.SchemeHelper.isSodaSchemeUri(r4)
            if (r4 == 0) goto L_0x00b8
        L_0x004e:
            if (r12 != 0) goto L_0x0052
        L_0x0050:
            r12 = r5
            goto L_0x0062
        L_0x0052:
            java.lang.String r4 = "click_time"
            java.lang.Object r12 = r12.get(r4)
            if (r12 != 0) goto L_0x005b
            goto L_0x0050
        L_0x005b:
            java.lang.String r12 = r12.toString()
            if (r12 != 0) goto L_0x0062
            goto L_0x0050
        L_0x0062:
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss.SSS"
            r4.<init>(r6)
            long r6 = com.didi.soda.customer.foundation.util.date.DateUtil.getTimeFromStr(r12, r4)
            long r8 = r0.time
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b8
            long r8 = r0.time
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b8
            r0.mIsDispatch = r3
            java.lang.String r12 = r0.urlString
            java.lang.String r1 = "doing "
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r12)
            com.didi.soda.customer.foundation.log.util.LogUtil.m29100d(r2, r12)
            java.lang.String r12 = r0.urlString
            if (r12 != 0) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r5 = r12
        L_0x008f:
            java.lang.String r12 = android.net.Uri.decode(r5)
            android.net.Uri r12 = android.net.Uri.parse(r12)
            boolean r0 = com.didi.soda.customer.foundation.util.LocationUtil.hasValidLocation()
            if (r0 == 0) goto L_0x00a7
            boolean r0 = com.didi.soda.customer.foundation.util.LocationUtil.hasValidPoi()
            if (r0 == 0) goto L_0x00a7
            com.didi.soda.customer.biz.scheme.SchemeHelper.dispatchMsg(r12, r13)
            goto L_0x00b7
        L_0x00a7:
            java.lang.Class<com.didi.soda.manager.base.ICustomerAddressManager> r0 = com.didi.soda.manager.base.ICustomerAddressManager.class
            com.didi.soda.manager.base.ICustomerManager r0 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r0)
            com.didi.soda.manager.base.ICustomerAddressManager r0 = (com.didi.soda.manager.base.ICustomerAddressManager) r0
            com.didi.soda.customer.biz.popdialog.-$$Lambda$AppsFlyerHelperKt$KQiMQJzUw4_LUbJRN59qQreHq8I r1 = new com.didi.soda.customer.biz.popdialog.-$$Lambda$AppsFlyerHelperKt$KQiMQJzUw4_LUbJRN59qQreHq8I
            r1.<init>(r12, r13)
            r0.subscribeAddressOnce(r1)
        L_0x00b7:
            return r3
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.popdialog.AppsFlyerHelperKt.doInstantUri(java.util.Map, boolean):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28675a(Uri uri, boolean z, AddressEntity addressEntity, Subscription subscription) {
        SchemeHelper.dispatchMsg(uri, z);
    }

    public static final SimpleAFConversionListener instantAction() {
        return new AppsFlyerHelperKt$instantAction$1();
    }
}
