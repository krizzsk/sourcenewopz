package com.didi.soda.home.topgun.component.topicact;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ%\u0010\u0015\u001a\u00020\u000e2\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004J$\u0010!\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004J$\u0010\"\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004J$\u0010$\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004J8\u0010%\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004J8\u0010'\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010)\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\tJ\u001a\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u0006\u0010/\u001a\u00020\u000eJ(\u00100\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u001cH\u0016J\u0006\u00105\u001a\u00020\u000eJ\u000e\u00106\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u00107\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\tJ\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u0004JD\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@J\u0006\u0010A\u001a\u00020\u000eJ\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010C\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u001e\u0010D\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/TopicActOmegaHelper;", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinder$HomeBusinessOmegaInterface;", "()V", "activityId", "", "componentId", "mActionPool", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$ActionPool;", "mScene", "", "mScopeContextWr", "Ljava/lang/ref/WeakReference;", "Lcom/didi/app/nova/skeleton/ScopeContext;", "attach", "", "scopeContext", "scene", "create", "Lcom/didi/soda/customer/foundation/tracker/OmegaTracker$Builder;", "eventConst", "detach", "doActionSafe", "actions", "", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "([Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;)V", "getBusinessBiData", "businessItem", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "headerFilterTopicCategoriesCK", "location", "from", "time", "headerFilterTopicCategoriesSw", "headerFilterTopicCatesItemCK", "filter_param", "headerFilterTopicCatesItemSW", "headerFilterTopicSortSw", "index", "headerFilterTopicSportCK", "itemExposure", "landingitemExposure", "onOmegaBusinessCk", "rvModel", "isCompose", "", "onOmegaBusinessSw", "reset", "setHomeMainGuideParam", "recId", "body", "filter", "setOmegaGuideParam", "trackAddressClick", "trackItemClick", "trackLandingItemClick", "trackLandingPageFailShow", "errorContent", "trackLandingPageShow", "homePageSource", "fromChannel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "trackNoServiceSw", "trackPageShow", "trackRulesCK", "trackTabClick", "sessionId", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActOmegaHelper.kt */
public final class TopicActOmegaHelper implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f */
    private static final String f42903f = "TopicActOmegaHelper";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final TopicActOmegaHelper f42904g = new TopicActOmegaHelper();

    /* renamed from: a */
    private WeakReference<ScopeContext> f42905a;

    /* renamed from: b */
    private OnceActionUtil.ActionPool f42906b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f42907c = "";

    /* renamed from: d */
    private int f42908d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f42909e = "";

    public final void attach(ScopeContext scopeContext, String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(str, "activityId");
        Intrinsics.checkNotNullParameter(str2, BlocksConst.BLOCK_PARAM_COMPONENT_ID);
        this.f42905a = new WeakReference<>(scopeContext);
        this.f42906b = new OnceActionUtil.ActionPool();
        this.f42907c = str;
        this.f42908d = i;
        this.f42909e = str2;
    }

    public final void detach(ScopeContext scopeContext) {
        ScopeContext scopeContext2;
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        WeakReference<ScopeContext> weakReference = this.f42905a;
        if (weakReference != null) {
            if (weakReference == null) {
                scopeContext2 = null;
            } else {
                scopeContext2 = (ScopeContext) weakReference.get();
            }
            if (scopeContext == scopeContext2) {
                this.f42905a = null;
                this.f42906b = null;
            }
        }
    }

    public final void reset() {
        OnceActionUtil.ActionPool actionPool = this.f42906b;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    public final void trackAddressClick() {
        m30358a(EventConst.TopicActivity.LANDING_ADDRESS_CLICK).build().track();
    }

    public final void trackNoServiceSw() {
        m30358a(EventConst.TopicActivity.LANDING_NO_SHOP_SW).build().track();
    }

    public final void trackRulesCK(String str) {
        OmegaTracker.Builder a = m30358a(EventConst.TopicActivity.LANDING_RULES_CK);
        if (str == null) {
            str = "";
        }
        a.addEventParam("activity_id", str).build().track();
    }

    public final void trackPageShow(String str) {
        Intrinsics.checkNotNullParameter(str, "activityId");
        m30358a(EventConst.TopicActivity.PAGE_SHOW).addEventParam("activity_id", str).build().track();
    }

    public final void trackTabClick(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "activityId");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        m30358a(EventConst.TopicActivity.LANDING_PAGE_TAB_CLICK).addEventParam("activity_id", str).addEventParam("session_id", str2).addEventParam("index", Integer.valueOf(i)).build().track();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r2 = r10.exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackLandingPageShow(int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity r10, com.didi.soda.customer.foundation.rpc.net.SFRpcException r11) {
        /*
            r4 = this;
            java.lang.String r0 = "fromChannel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "activityId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            r1 = 0
            if (r10 != 0) goto L_0x0010
        L_0x000e:
            r2 = 0
            goto L_0x001c
        L_0x0010:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$ExceptionBean r2 = r10.exception
            if (r2 != 0) goto L_0x0015
            goto L_0x000e
        L_0x0015:
            int r2 = r2.actStatus
            r3 = 100
            if (r2 != r3) goto L_0x000e
            r2 = 1
        L_0x001c:
            if (r2 == 0) goto L_0x0020
            r0 = 2
            goto L_0x0038
        L_0x0020:
            if (r10 != 0) goto L_0x0024
        L_0x0022:
            r2 = 0
            goto L_0x0030
        L_0x0024:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$ExceptionBean r2 = r10.exception
            if (r2 != 0) goto L_0x0029
            goto L_0x0022
        L_0x0029:
            int r2 = r2.actStatus
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L_0x0022
            r2 = 1
        L_0x0030:
            if (r2 == 0) goto L_0x0033
            goto L_0x0038
        L_0x0033:
            if (r11 == 0) goto L_0x0037
            r0 = 3
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            java.lang.String r2 = "sailing_c_x_top_second_common_sw"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r2 = r4.m30358a((java.lang.String) r2)
            java.lang.String r3 = "activity_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r2.addEventParam(r3, r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "page_type"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r2, r0)
            if (r10 != 0) goto L_0x0054
        L_0x0052:
            r0 = 0
            goto L_0x005b
        L_0x0054:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$ExceptionBean r0 = r10.exception
            if (r0 != 0) goto L_0x0059
            goto L_0x0052
        L_0x0059:
            int r0 = r0.actStatus
        L_0x005b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "act_status"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r2, r0)
            if (r11 != 0) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            int r1 = r11.getCode()
        L_0x006c:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = "error_code"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r1, r0)
            r0 = 0
            if (r11 != 0) goto L_0x007b
            r11 = r0
            goto L_0x007f
        L_0x007b:
            java.lang.String r11 = r11.getMessage()
        L_0x007f:
            java.lang.String r1 = ""
            if (r11 == 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r11 = r1
        L_0x0085:
            java.lang.String r2 = "error_msg"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r2, r11)
            if (r10 != 0) goto L_0x008f
            r11 = r0
            goto L_0x0091
        L_0x008f:
            java.lang.String r11 = r10.recId
        L_0x0091:
            if (r11 == 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r11 = r1
        L_0x0095:
            java.lang.String r2 = "rec_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r2, r11)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "scene"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r11, r9)
            if (r10 != 0) goto L_0x00ab
            r9 = r0
            goto L_0x00ad
        L_0x00ab:
            java.lang.String r9 = r10.tabId
        L_0x00ad:
            if (r9 == 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r9 = r1
        L_0x00b1:
            java.lang.String r11 = "session_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r11, r9)
            if (r10 != 0) goto L_0x00bb
            goto L_0x00c4
        L_0x00bb:
            java.util.ArrayList<java.lang.String> r9 = r10.sessionIdList
            if (r9 != 0) goto L_0x00c0
            goto L_0x00c4
        L_0x00c0:
            java.lang.String r0 = r9.toString()
        L_0x00c4:
            if (r0 == 0) goto L_0x00c7
            goto L_0x00c8
        L_0x00c7:
            r0 = r1
        L_0x00c8:
            java.lang.String r9 = "session_list"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r9, r0)
            if (r8 == 0) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r8 = r1
        L_0x00d3:
            java.lang.String r9 = "topic_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r9, r8)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r8 = "homepage_source"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r5 = r7.addEventParam(r8, r5)
            java.lang.String r7 = "from_channel"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r5 = r5.addEventParam(r7, r6)
            com.didi.soda.customer.foundation.tracker.OmegaTracker r5 = r5.build()
            r5.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.trackLandingPageShow(int, java.lang.String, java.lang.String, java.lang.String, int, com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity, com.didi.soda.customer.foundation.rpc.net.SFRpcException):void");
    }

    public final void trackLandingPageFailShow(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "activityId");
        OmegaTracker.Builder addEventParam = m30358a(EventConst.TopicActivity.LANDING_PAGE_FAIL_SHOW).addEventParam("activity_id", str);
        if (str2 == null) {
            str2 = "";
        }
        addEventParam.addEventParam("error_msg", str2).build().track();
    }

    public final void itemExposure(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "businessItem");
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            TopicActOmegaHelper$itemExposure$moduleShowTrack$1 topicActOmegaHelper$itemExposure$moduleShowTrack$1 = new TopicActOmegaHelper$itemExposure$moduleShowTrack$1(this, homeBusinessInfoRvModel, new Object[]{homeBusinessInfoRvModel.mShopId, Integer.valueOf(homeBusinessInfoRvModel.mRowInModule)});
            OnceActionUtil.ActionPool actionPool = this.f42906b;
            if (actionPool != null && actionPool != null) {
                actionPool.doAction(topicActOmegaHelper$itemExposure$moduleShowTrack$1);
            }
        }
    }

    public final void landingitemExposure(HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "businessItem");
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            TopicActOmegaHelper$landingitemExposure$moduleShowTrack$1 topicActOmegaHelper$landingitemExposure$moduleShowTrack$1 = new TopicActOmegaHelper$landingitemExposure$moduleShowTrack$1(this, homeBusinessInfoRvModel, i, new Object[]{homeBusinessInfoRvModel.mShopId, Integer.valueOf(homeBusinessInfoRvModel.mRowInModule)});
            OnceActionUtil.ActionPool actionPool = this.f42906b;
            if (actionPool != null && actionPool != null) {
                actionPool.doAction(topicActOmegaHelper$landingitemExposure$moduleShowTrack$1);
            }
        }
    }

    public final void trackItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "businessItem");
        OmegaTracker.Builder addEventParam = m30358a(EventConst.TopicActivity.SHOP_ITEM_CLICK).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId).addEventParam(ParamConst.PARAM_SHOP_NAME, homeBusinessInfoRvModel.mShopName).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus));
        addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + '_' + homeBusinessInfoRvModel.mDeliveryPriceOri + '_' + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).addEventParam("activity_id", this.f42907c).addEventParam("index", Integer.valueOf(homeBusinessInfoRvModel.mRowInModule)).build().track();
    }

    public final void trackLandingItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "businessItem");
        OmegaTracker.Builder addEventParam = m30358a(EventConst.TopicActivity.LANDING_SHOP_ITEM_CLICK).addEventParam(ParamConst.PARAM_SHOP_NAME, homeBusinessInfoRvModel.mShopName).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus)).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId);
        addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + '_' + homeBusinessInfoRvModel.mDeliveryPriceOri + '_' + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryType)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).addEventParam("activity_id", this.f42907c).addEventParam("from", 2).addEventParam("scene", Integer.valueOf(i)).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel.mTraceId).addEventParam(ParamConst.PARAM_IS_SHOP_LOGO, Integer.valueOf(TextUtils.isEmpty(homeBusinessInfoRvModel.mLogo) ^ true ? 1 : 0)).addEventParam("topic_id", this.f42909e).enableGuideParam().build().track();
    }

    public final void headerFilterTopicCategoriesSw(String str, String str2, String str3) {
        m30360a(new C14034xe85d15de(this, str2, str3, str));
    }

    public final void headerFilterTopicCategoriesCK(String str, String str2, String str3) {
        OmegaTracker.Builder a = m30358a(EventConst.Home.SAILING_C_X_OPERATION_CATEGORY_FILTER_CK);
        if (str2 == null) {
            str2 = "";
        }
        OmegaTracker.Builder addEventParam = a.addEventParam("from", str2);
        if (str3 == null) {
            str3 = "";
        }
        addEventParam.addEventParam("time_period", str3).build().track();
    }

    public final void headerFilterTopicSortSw(String str, String str2, String str3, String str4, String str5) {
        m30360a(new C14035x271a6ce0(this, str2, str3, str4, str5, str));
    }

    public final void headerFilterTopicSportCK(String str, String str2, String str3, String str4, String str5) {
        OmegaTracker.Builder a = m30358a(EventConst.Home.SAILING_C_X_OPERATION_SORT_FILTER_CK);
        if (str2 == null) {
            str2 = "";
        }
        OmegaTracker.Builder addEventParam = a.addEventParam("from", str2);
        if (str3 == null) {
            str3 = "";
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("time_period", str3);
        if (str4 == null) {
            str4 = "";
        }
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.FILTER_PARAM, str4);
        if (str5 == null) {
            str5 = "";
        }
        addEventParam3.addEventParam("index", str5).build().track();
    }

    public final void headerFilterTopicCatesItemSW(String str, String str2, String str3) {
        OmegaTracker.Builder a = m30358a(EventConst.Home.SAILING_C_X_OPERATION_CATEGORY_FILTER_POP_SW);
        if (str == null) {
            str = "";
        }
        OmegaTracker.Builder addEventParam = a.addEventParam("from", str);
        if (str2 == null) {
            str2 = "";
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("time_period", str2);
        if (str3 == null) {
            str3 = "";
        }
        addEventParam2.addEventParam(ParamConst.PARAM_CATEGORY_ID, str3).build().track();
    }

    public final void headerFilterTopicCatesItemCK(String str, String str2, String str3) {
        OmegaTracker.Builder a = m30358a(EventConst.Home.SAILING_C_X_OPERATION_CATEGORY_FILTER_POP_CK);
        if (str == null) {
            str = "";
        }
        OmegaTracker.Builder addEventParam = a.addEventParam("from", str);
        if (str2 == null) {
            str2 = "";
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("time_period", str2);
        if (str3 == null) {
            str3 = "";
        }
        addEventParam2.addEventParam(ParamConst.PARAM_CATEGORY_ID, str3).build().track();
    }

    /* renamed from: a */
    private final void m30360a(OnceActionUtil.OnceAction... onceActionArr) {
        OnceActionUtil.ActionPool actionPool = this.f42906b;
        if (actionPool != null) {
            actionPool.doAction((OnceActionUtil.OnceAction[]) Arrays.copyOf(onceActionArr, onceActionArr.length));
        }
    }

    public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
        String moduleString = homeBusinessInfoRvModel.toModuleString();
        String str = homeBusinessInfoRvModel.mRecId;
        String stringPlus = Intrinsics.stringPlus("shop_", homeBusinessInfoRvModel.mShopId);
        String str2 = homeBusinessInfoRvModel.mPageFilter;
        Intrinsics.checkNotNullExpressionValue(moduleString, "location");
        Intrinsics.checkNotNullExpressionValue(str, "recId");
        Intrinsics.checkNotNullExpressionValue(str2, "filter");
        m30359a(moduleString, str, stringPlus, str2);
    }

    /* renamed from: a */
    private final void m30359a(String str, String str2, String str3, String str4) {
        OmegaCommonParamHelper.setLv1Location(str);
        OmegaCommonParamHelper.setLv1RecId(str2);
        OmegaCommonParamHelper.setLv1Body(str3);
        OmegaCommonParamHelper.setLv1Filter(str4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final OmegaTracker.Builder m30358a(String str) {
        WeakReference<ScopeContext> weakReference = this.f42905a;
        ScopeContext scopeContext = weakReference == null ? null : (ScopeContext) weakReference.get();
        if (scopeContext == null) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(str);
            Intrinsics.checkNotNullExpressionValue(create, "{\n            OmegaTrack…ate(eventConst)\n        }");
            return create;
        }
        OmegaTracker.Builder create2 = OmegaTracker.Builder.create(str, scopeContext);
        Intrinsics.checkNotNullExpressionValue(create2, "{\n            OmegaTrack…eventConst, sp)\n        }");
        return create2;
    }

    public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        if (homeBusinessInfoRvModel != null) {
            landingitemExposure(homeBusinessInfoRvModel, this.f42908d);
        }
    }

    public void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        if (homeBusinessInfoRvModel != null) {
            trackLandingItemClick(homeBusinessInfoRvModel, this.f42908d);
        }
    }

    public String getBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        if (homeBusinessInfoRvModel == null) {
            return "";
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("user_id", LoginUtil.getUid());
        jsonObject.addProperty("shop_id", homeBusinessInfoRvModel.mShopId);
        jsonObject.addProperty("from_page", homeBusinessInfoRvModel.mPageId);
        JsonElement jsonElement = FilterEntity.toJsonElement(homeBusinessInfoRvModel.mPageFilter);
        if (jsonElement != null) {
            jsonObject.add("lv1_filter", jsonElement);
        }
        jsonObject.addProperty("lv1_location", homeBusinessInfoRvModel.toModuleString());
        jsonObject.addProperty("lv1_recid", homeBusinessInfoRvModel.mRecId);
        String jsonObject2 = jsonObject.toString();
        if (jsonObject2 == null) {
            return "";
        }
        return jsonObject2;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/TopicActOmegaHelper$Companion;", "", "()V", "TAG", "", "instance", "Lcom/didi/soda/home/topgun/component/topicact/TopicActOmegaHelper;", "getInstance", "()Lcom/didi/soda/home/topgun/component/topicact/TopicActOmegaHelper;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TopicActOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TopicActOmegaHelper getInstance() {
            return TopicActOmegaHelper.f42904g;
        }
    }
}
