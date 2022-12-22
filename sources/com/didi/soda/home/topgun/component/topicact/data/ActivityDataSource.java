package com.didi.soda.home.topgun.component.topicact.data;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.storage.FeedBackStrategyStore;
import com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.listener.PageEventListener;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.PageController;
import com.didi.soda.datasource.page.PageStore;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001sB)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ\u0006\u0010Z\u001a\u00020@J\u001c\u0010[\u001a\u00020@2\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010J\u001a\u0004\u0018\u00010IH\u0002J \u0010\\\u001a\u00020@2\u0006\u0010]\u001a\u00020&2\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0016\u0010^\u001a\u00020&2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010`J\u0018\u0010a\u001a\u00020@2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010cH\u0002J\u0012\u0010e\u001a\u00020\u000f2\b\u0010f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010g\u001a\u00020\u000fJ\u0006\u0010h\u001a\u00020@J\u0010\u0010h\u001a\u00020@2\b\u0010i\u001a\u0004\u0018\u00010\u0002J\u0006\u0010j\u001a\u00020@J\u001a\u0010k\u001a\u00020@2\u0006\u0010l\u001a\u00020&2\b\u0010i\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010m\u001a\u00020@J\n\u0010n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010o\u001a\u00020@2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010`J&\u0010p\u001a\u00020@2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010`2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010!\"\u0004\b4\u0010#R\u000e\u00105\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#RT\u00109\u001a<\u0012\u0013\u0012\u00110&¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010>¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020@\u0018\u00010:j\u0004\u0018\u0001`AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0001\u0010F\u001a\u0012\u0013\u0012\u00110&¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(H\u0012\u0015\u0012\u0013\u0018\u00010>¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(?\u0012\u0015\u0012\u0013\u0018\u00010I¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020@\u0018\u00010Gj\u0004\u0018\u0001`LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0RX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0TX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010U\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/data/ActivityDataSource;", "Lcom/didi/soda/datasource/listener/PageEventListener;", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "listener", "Lcom/didi/soda/datasource/listener/DataSourceListener;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/blocks/scope/IBlockScope;Lcom/didi/soda/datasource/listener/DataSourceListener;)V", "<set-?>", "", "hasMore", "getHasMore", "()Z", "homeFeedParam", "getHomeFeedParam", "()Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "setHomeFeedParam", "(Lcom/didi/soda/home/topgun/manager/HomeFeedParam;)V", "mActInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "getMActInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "setMActInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;)V", "mActivityId", "", "getMActivityId", "()Ljava/lang/String;", "setMActivityId", "(Ljava/lang/String;)V", "mComponentId", "mPageIndex", "", "mRecId", "getMRecId", "setMRecId", "mReqType", "getMReqType", "()I", "setMReqType", "(I)V", "mRpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "mScene", "mTabId", "getMTabId", "setMTabId", "mTitle", "mTraceId", "getMTraceId", "setMTraceId", "onPagePlayBackListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;", "entity", "", "Lcom/didi/soda/home/topgun/component/topicact/data/OnPagePlayBackListener;", "getOnPagePlayBackListener", "()Lkotlin/jvm/functions/Function2;", "setOnPagePlayBackListener", "(Lkotlin/jvm/functions/Function2;)V", "onPageResultListener", "Lkotlin/Function5;", "componentId", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "ex", "checkOnly", "Lcom/didi/soda/home/topgun/component/topicact/data/OnPageResultListener;", "getOnPageResultListener", "()Lkotlin/jvm/functions/Function5;", "setOnPageResultListener", "(Lkotlin/jvm/functions/Function5;)V", "pageController", "Lcom/didi/soda/datasource/page/PageController;", "pageStore", "Lcom/didi/soda/datasource/page/PageStore;", "resultEntity", "getResultEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;", "setResultEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;)V", "checkActivityEffective", "dealPageResult", "fetchActivityInfo", "pageIndex", "find", "diffCallback", "Lcom/didi/soda/datasource/page/UpdateUtils$DiffCallback;", "initTemplate", "templates", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/entity/Template;", "isFrequentFeedBackCard", "item", "isNoResult", "loadInit", "params", "loadNextPage", "onPageLoad", "key", "playBackDataSource", "providePayload", "remove", "update", "updateCallback", "Lcom/didi/soda/datasource/page/UpdateUtils$UpdateCallback;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityDataSource.kt */
public final class ActivityDataSource implements PageEventListener<HomeFeedParam>, PayloadProvider<FeedPayload> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int pageCount = 20;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ScopeContext f42944a;

    /* renamed from: b */
    private final PageStore<ComponentEntity, RecyclerModel> f42945b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final PageController<HomeFeedParam, ComponentEntity> f42946c;

    /* renamed from: d */
    private Function5<? super Integer, ? super String, ? super ActivityInfoEntity, ? super SFRpcException, ? super Boolean, Unit> f42947d;

    /* renamed from: e */
    private Function2<? super Integer, ? super ActivityInfoEntity, Unit> f42948e;

    /* renamed from: f */
    private String f42949f;

    /* renamed from: g */
    private final CustomerRpcService f42950g;

    /* renamed from: h */
    private int f42951h;

    /* renamed from: i */
    private String f42952i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f42953j;

    /* renamed from: k */
    private int f42954k;

    /* renamed from: l */
    private String f42955l;

    /* renamed from: m */
    private ActInfoEntity f42956m;

    /* renamed from: n */
    private String f42957n;

    /* renamed from: o */
    private String f42958o;

    /* renamed from: p */
    private int f42959p = 1;

    /* renamed from: q */
    private ActivityInfoEntity f42960q;

    /* renamed from: r */
    private boolean f42961r;

    /* renamed from: s */
    private HomeFeedParam f42962s;

    public ActivityDataSource(ScopeContext scopeContext, IBlockScope iBlockScope, DataSourceListener<ComponentEntity, RecyclerModel> dataSourceListener) {
        ActInfoEntity actInfoEntity;
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(dataSourceListener, "listener");
        this.f42944a = scopeContext;
        this.f42945b = new PageStore<>(new ActivityDataMapFunction(this, iBlockScope), dataSourceListener);
        PageController<HomeFeedParam, ComponentEntity> pageController = new PageController<>();
        this.f42946c = pageController;
        boolean z = true;
        pageController.initialize(0, this, this.f42945b);
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        Intrinsics.checkNotNullExpressionValue(customerRpcService, "get()");
        this.f42950g = customerRpcService;
        String string = this.f42944a.getBundle().getString("scene", "0");
        Intrinsics.checkNotNullExpressionValue(string, "scopeContext.bundle.getS…eParams.TOPIC_SCENE, \"0\")");
        this.f42954k = Integer.parseInt(string);
        String string2 = this.f42944a.getBundle().getString("activityid");
        String str = "";
        this.f42952i = string2 == null ? str : string2;
        String string3 = this.f42944a.getBundle().getString(Const.PageParams.COMPONENT_ID);
        this.f42953j = string3 == null ? str : string3;
        String string4 = this.f42944a.getBundle().getString("recid");
        this.f42949f = string4 == null ? str : string4;
        String string5 = this.f42944a.getBundle().getString(Const.PageParams.TOPIC_TITLE);
        this.f42955l = string5 == null ? str : string5;
        String str2 = null;
        try {
            String string6 = this.f42944a.getBundle().getString(Const.PageParams.ACT_INFO);
            actInfoEntity = string6 == null ? null : (ActInfoEntity) GsonUtil.fromJson(string6, ActInfoEntity.class);
        } catch (Exception unused) {
            actInfoEntity = null;
        }
        this.f42956m = actInfoEntity;
        if (actInfoEntity == null) {
            this.f42956m = new ActInfoEntity();
        } else {
            this.f42944a.attach(BlocksConst.BLOCK_ACT_ID, actInfoEntity == null ? null : actInfoEntity.getActId());
            CharSequence charSequence = this.f42952i;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (z) {
                ActInfoEntity actInfoEntity2 = this.f42956m;
                String actId = actInfoEntity2 == null ? null : actInfoEntity2.getActId();
                this.f42952i = actId == null ? str : actId;
            }
        }
        this.f42944a.attach("scene", Integer.valueOf(this.f42954k));
        HomeFeedParam homeFeedParam = new HomeFeedParam();
        this.f42962s = homeFeedParam;
        ScopeContext scopeContext2 = this.f42944a;
        str2 = homeFeedParam != null ? homeFeedParam.getFilterParam() : str2;
        scopeContext2.attach("filter", str2 != null ? str2 : str);
        HomeFeedParam homeFeedParam2 = this.f42962s;
        if (homeFeedParam2 != null) {
            homeFeedParam2.reset();
        }
    }

    public final Function5<Integer, String, ActivityInfoEntity, SFRpcException, Boolean, Unit> getOnPageResultListener() {
        return this.f42947d;
    }

    public final void setOnPageResultListener(Function5<? super Integer, ? super String, ? super ActivityInfoEntity, ? super SFRpcException, ? super Boolean, Unit> function5) {
        this.f42947d = function5;
    }

    public final Function2<Integer, ActivityInfoEntity, Unit> getOnPagePlayBackListener() {
        return this.f42948e;
    }

    public final void setOnPagePlayBackListener(Function2<? super Integer, ? super ActivityInfoEntity, Unit> function2) {
        this.f42948e = function2;
    }

    public final String getMRecId() {
        return this.f42949f;
    }

    public final void setMRecId(String str) {
        this.f42949f = str;
    }

    public final String getMActivityId() {
        return this.f42952i;
    }

    public final void setMActivityId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f42952i = str;
    }

    public final ActInfoEntity getMActInfo() {
        return this.f42956m;
    }

    public final void setMActInfo(ActInfoEntity actInfoEntity) {
        this.f42956m = actInfoEntity;
    }

    public final String getMTabId() {
        return this.f42957n;
    }

    public final void setMTabId(String str) {
        this.f42957n = str;
    }

    public final String getMTraceId() {
        return this.f42958o;
    }

    public final void setMTraceId(String str) {
        this.f42958o = str;
    }

    public final int getMReqType() {
        return this.f42959p;
    }

    public final void setMReqType(int i) {
        this.f42959p = i;
    }

    public final ActivityInfoEntity getResultEntity() {
        return this.f42960q;
    }

    public final void setResultEntity(ActivityInfoEntity activityInfoEntity) {
        this.f42960q = activityInfoEntity;
    }

    public final boolean getHasMore() {
        return this.f42961r;
    }

    public final HomeFeedParam getHomeFeedParam() {
        return this.f42962s;
    }

    public final void setHomeFeedParam(HomeFeedParam homeFeedParam) {
        this.f42962s = homeFeedParam;
    }

    public final void loadInit() {
        Unit unit;
        HomeFeedParam homeFeedParam = this.f42962s;
        if (homeFeedParam == null) {
            unit = null;
        } else {
            this.f42946c.loadInit(homeFeedParam);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.f42946c.loadInit();
        }
    }

    public final void loadInit(HomeFeedParam homeFeedParam) {
        Unit unit;
        if (homeFeedParam == null) {
            unit = null;
        } else {
            this.f42946c.loadInit(homeFeedParam);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.f42946c.loadInit();
        }
    }

    public final void loadNextPage() {
        PageController<HomeFeedParam, ComponentEntity> pageController = this.f42946c;
        HomeFeedParam homeFeedParam = this.f42962s;
        if (homeFeedParam == null) {
            homeFeedParam = new HomeFeedParam();
        }
        pageController.loadNextPage(homeFeedParam);
    }

    public final void remove(UpdateUtils.DiffCallback<RecyclerModel> diffCallback) {
        this.f42945b.remove(diffCallback);
    }

    public final void update(UpdateUtils.DiffCallback<RecyclerModel> diffCallback, UpdateUtils.UpdateCallback<RecyclerModel> updateCallback) {
        this.f42945b.update(diffCallback, updateCallback);
    }

    public final void playBackDataSource() {
        if (this.f42960q != null) {
            this.f42944a.attach("recId", this.f42949f);
            this.f42944a.attach("traceId", this.f42958o);
            ScopeContext scopeContext = this.f42944a;
            String str = this.f42957n;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            scopeContext.attach(BlocksConst.BLOCK_TAB_ID, str);
            this.f42944a.attach("topic_id", this.f42953j);
            ScopeContext scopeContext2 = this.f42944a;
            HomeFeedParam homeFeedParam = this.f42962s;
            String filterParam = homeFeedParam == null ? null : homeFeedParam.getFilterParam();
            if (filterParam != null) {
                str2 = filterParam;
            }
            scopeContext2.attach("filter", str2);
            this.f42945b.provideStoredData();
            Function2<? super Integer, ? super ActivityInfoEntity, Unit> function2 = this.f42948e;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(this.f42951h), this.f42960q);
            }
        }
    }

    public FeedPayload providePayload() {
        FeedPayload feedPayload = new FeedPayload();
        if (this.f42954k == 0) {
            feedPayload.mPageId = RoutePath.TOPIC_ACTIVITY_PAGE;
        } else {
            feedPayload.mPageId = "showAll";
        }
        feedPayload.mPageIndex = this.f42951h;
        feedPayload.mRecId = this.f42949f;
        feedPayload.mTraceId = this.f42958o;
        return feedPayload;
    }

    public void onPageLoad(int i, HomeFeedParam homeFeedParam) {
        this.f42951h = i;
        if (homeFeedParam == null) {
            homeFeedParam = new HomeFeedParam();
        }
        m30412a(i, false, homeFeedParam);
    }

    public final void checkActivityEffective() {
        int i = this.f42951h;
        HomeFeedParam homeFeedParam = this.f42962s;
        if (homeFeedParam == null) {
            homeFeedParam = new HomeFeedParam();
        }
        m30412a(i, true, homeFeedParam);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30413a(ActivityInfoEntity activityInfoEntity, SFRpcException sFRpcException) {
        if (activityInfoEntity != null) {
            String str = activityInfoEntity.tabId;
            if (str != null) {
                setMTabId(str);
            }
            this.f42961r = activityInfoEntity.mHasMore && LoginUtil.isLogin();
        }
    }

    public final int find(UpdateUtils.DiffCallback<RecyclerModel> diffCallback) {
        return this.f42945b.find(diffCallback);
    }

    public final boolean isNoResult() {
        List<ComponentEntity> list;
        ActivityInfoEntity activityInfoEntity = this.f42960q;
        if (activityInfoEntity == null || (list = activityInfoEntity.mCompList) == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                ComponentEntity componentEntity = (ComponentEntity) it.next();
                if ((componentEntity == null ? null : componentEntity.noResult) != null) {
                    z = true;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m30412a(int i, boolean z, HomeFeedParam homeFeedParam) {
        int i2 = i;
        CRpcCallBackWithTraceId activityDataSource$fetchActivityInfo$callback$1 = new ActivityDataSource$fetchActivityInfo$callback$1(z, this, i);
        int i3 = this.f42954k;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            this.f42950g.getBlocksTopicList(this.f42953j, i, 20, this.f42954k, this.f42949f, this.f42955l, this.f42956m, this.f42957n, this.f42959p, homeFeedParam.getFilterParam(), activityDataSource$fetchActivityInfo$callback$1);
            return;
        }
        this.f42950g.getActivityList(this.f42952i, i, 20, homeFeedParam.getFilterParam(), activityDataSource$fetchActivityInfo$callback$1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m30415a(ComponentEntity componentEntity) {
        JsonObject jsonObject;
        JsonElement jsonElement;
        String str = null;
        if (!TextUtils.equals(componentEntity == null ? null : componentEntity.getType(), "1000")) {
            return false;
        }
        if (!(componentEntity == null || (jsonObject = componentEntity.data) == null || (jsonElement = jsonObject.get(BlocksConst.ACTION_PARAMS_SCENE_ID)) == null)) {
            str = jsonElement.getAsString();
        }
        if (str == null) {
            str = "";
        }
        FeedBackStrategyConfig data = ((FeedBackStrategyStore) SingletonFactory.get(FeedBackStrategyStore.class)).getData(Intrinsics.stringPlus("launchActivityPage_", str));
        if (data == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(data.getLastRemoveTime()));
        if (instance.get(6) - Calendar.getInstance().get(6) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30414a(ArrayList<Template> arrayList) {
        String str;
        Template template;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                for (Template template2 : arrayList) {
                    String tmplId = template2 == null ? null : template2.getTmplId();
                    if (TextUtils.isEmpty(tmplId)) {
                        BlocksOmegaHelpter.INSTANCE.trackTemplateWithoutId(template2.toString());
                    } else {
                        if (template2 == null) {
                            str = null;
                        } else {
                            str = template2.getContent();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            JsonElement parse = new JsonParser().parse(str);
                            String str2 = "1";
                            if (!(parse == null || (asJsonObject = parse.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("version")) == null || (asString = jsonElement.getAsString()) == null)) {
                                str2 = asString;
                            }
                            if (Integer.parseInt(str2) > 1) {
                                try {
                                    template = (Template) new Gson().fromJson(str, Template.class);
                                } catch (Exception unused) {
                                    template = null;
                                }
                                if (template != null) {
                                    template.setTemplateId(tmplId);
                                }
                            } else {
                                Template template3 = new Template();
                                template3.setTmplId(tmplId);
                                template3.setContent(str);
                                template = template3;
                            }
                            arrayList2.add(template);
                        }
                    }
                }
            }
            BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).initTemplate(arrayList2);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/data/ActivityDataSource$Companion;", "", "()V", "pageCount", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ActivityDataSource.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
