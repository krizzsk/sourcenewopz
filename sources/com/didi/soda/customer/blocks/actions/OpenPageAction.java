package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import android.net.Uri;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ<\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nH\u0002JF\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nH\u0002JH\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JF\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nH\u0002JF\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nH\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/OpenPageAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "interceptors", "", "Lcom/didi/soda/customer/blocks/actions/ActionInterceptor;", "buildUri", "pageName", "map", "dispatchOpen", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "intercept", "", "open", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "openPage")
/* compiled from: OpenPageAction.kt */
public final class OpenPageAction extends BaseAction {
    public static final int CHANNEL_CUSTOMER_APP = 2;
    public static final int CHANNEL_SU_APP = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ENABLE_PAGE_RESULT = 1;

    /* renamed from: a */
    private final List<ActionInterceptor> f40552a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OpenPageAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
        List<ActionInterceptor> arrayList = new ArrayList<>();
        this.f40552a = arrayList;
        arrayList.add(new BusinessPageActionInterceptor());
    }

    public ActionResult doExcute(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(buildable, "widget");
        if (hashMap != null) {
            Object object = iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT);
            ScopeContext scopeContext = object instanceof ScopeContext ? (ScopeContext) object : null;
            Object obj = hashMap.get("url");
            String obj2 = obj == null ? null : obj.toString();
            CharSequence charSequence = obj2;
            if (!(charSequence == null || charSequence.length() == 0)) {
                Object obj3 = hashMap.get(BlocksConst.ACTION_PARAMS_ENABLE_PAGE_RESULT);
                if (Intrinsics.areEqual((Object) "1", (Object) obj3 == null ? null : obj3.toString())) {
                    Object obj4 = hashMap.get("params");
                    m28794a(obj2, scopeContext, obj4 instanceof HashMap ? (HashMap) obj4 : null);
                } else {
                    Object obj5 = hashMap.get("params");
                    m28794a(obj2, (ScopeContext) null, obj5 instanceof HashMap ? (HashMap) obj5 : null);
                }
            } else {
                LogUtil.m29102e("OpenPageAction", Intrinsics.stringPlus("pageName = ", obj2));
            }
        } else {
            LogUtil.m29102e("OpenPageAction", "params = null");
        }
        return ActionResult.Companion.resolve$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
    }

    /* renamed from: a */
    private final void m28794a(String str, ScopeContext scopeContext, HashMap<String, Object> hashMap) {
        Object obj;
        String str2 = null;
        if (!(hashMap == null || (obj = hashMap.get("from_channel")) == null)) {
            str2 = obj.toString();
        }
        if (!GlobalContext.isEmbed() || !Intrinsics.areEqual((Object) str2, (Object) "1")) {
            m28796c(str, scopeContext, hashMap);
            return;
        }
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).open(m28793a(str, hashMap));
    }

    /* renamed from: a */
    private final String m28793a(String str, HashMap<String, Object> hashMap) {
        Uri.Builder appendPath = Uri.parse("taxis99OneTravel://soda").buildUpon().appendPath(str);
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() != null) {
                    if (entry.getValue() instanceof Map) {
                        appendPath.appendQueryParameter((String) entry.getKey(), GsonUtil.toJson(entry.getValue()));
                    } else if (entry.getValue() instanceof IEntity) {
                        appendPath.appendQueryParameter((String) entry.getKey(), GsonUtil.toJson(entry.getValue()));
                    } else {
                        appendPath.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
                    }
                }
            }
        }
        appendPath.appendQueryParameter("action_type", "support");
        String builder = appendPath.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "builder.toString()");
        return builder;
    }

    /* renamed from: b */
    private final boolean m28795b(String str, ScopeContext scopeContext, HashMap<String, Object> hashMap) {
        boolean z = false;
        for (ActionInterceptor intercept : this.f40552a) {
            if (intercept.intercept(str, scopeContext, hashMap)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: c */
    private final void m28796c(String str, ScopeContext scopeContext, HashMap<String, Object> hashMap) {
        if (!m28795b(str, scopeContext, hashMap)) {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) HWMapConstant.HTTP.SEPARATOR, false, 2, (Object) null)) {
                try {
                    Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                    if (hashMap != null) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            buildUpon.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
                        }
                    }
                    SchemeHelper.dispatchMsg(buildUpon.build().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.m29102e("OpenPageAction", "跳转失败");
                }
            } else {
                Request.Builder path = DiRouter.request().path(str);
                if (hashMap != null) {
                    path.params(OpenPageActionKt.m28797a(hashMap));
                }
                if (scopeContext != null) {
                    path.setFromPage(scopeContext);
                }
                path.open();
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/OpenPageAction$Companion;", "", "()V", "CHANNEL_CUSTOMER_APP", "", "CHANNEL_SU_APP", "ENABLE_PAGE_RESULT", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OpenPageAction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
