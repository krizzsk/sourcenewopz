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
import com.didi.soda.customer.foundation.login.LoginListener;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.home.manager.ActivityValidateCheckHelper;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016JF\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162*\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nH\u0002¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/CheckStatuOpenPageAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "open", "", "pageName", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "map", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "openPageWithActivityValidation")
/* compiled from: CheckStatuOpenPageAction.kt */
public final class CheckStatuOpenPageAction extends BaseAction {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ENABLE_PAGE_RESULT = 1;
    public static final String TAG = "CheckStatuOpenPageAction";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckStatuOpenPageAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public ActionResult doExcute(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        String obj;
        String obj2;
        String obj3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(buildable, "widget");
        if (hashMap != null) {
            Object object = iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT);
            ScopeContext scopeContext = object instanceof ScopeContext ? (ScopeContext) object : null;
            Object obj4 = hashMap.get("url");
            String obj5 = obj4 == null ? null : obj4.toString();
            Object obj6 = hashMap.get(BlocksConst.ACTION_PARAMS_ENABLE_PAGE_RESULT);
            String obj7 = obj6 == null ? null : obj6.toString();
            Object obj8 = hashMap.get("sceneType");
            int parseInt = (obj8 == null || (obj3 = obj8.toString()) == null) ? 0 : Integer.parseInt(obj3);
            Object obj9 = hashMap.get(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE);
            int parseInt2 = (obj9 == null || (obj2 = obj9.toString()) == null) ? 0 : Integer.parseInt(obj2);
            Object obj10 = hashMap.get(BlocksConst.ACTION_PARAMS_ACT_INFO);
            String str = "";
            if (!(obj10 == null || (obj = obj10.toString()) == null)) {
                str = obj;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                objectRef.element = GsonUtil.fromJson(str, ActInfoEntity.class);
            } catch (Exception unused) {
                LogUtil.m29104i(TAG, "actInfoStr parse error: $e|$actInfoStr");
            }
            CharSequence charSequence = obj5;
            if (charSequence == null || charSequence.length() == 0) {
                LogUtil.m29102e(TAG, Intrinsics.stringPlus("pageName = ", obj5));
                return ActionResult.Companion.reject$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
            } else if (!LoginUtil.isLogin()) {
                LoginUtil.updateLoginPopToRootStatus(false);
                LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), parseInt, new LoginListener(parseInt2, objectRef, scopeContext) {
                    public final /* synthetic */ int f$0;
                    public final /* synthetic */ Ref.ObjectRef f$1;
                    public final /* synthetic */ ScopeContext f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public /* synthetic */ void onCancel() {
                        LoginListener.CC.$default$onCancel(this);
                    }

                    public final void onSuccess(String str) {
                        CheckStatuOpenPageAction.m28787a(this.f$0, this.f$1, this.f$2, str);
                    }
                });
            } else if (parseInt2 == 2) {
                ActivityValidateCheckHelper.checkActivityValidate((ActInfoEntity) objectRef.element, scopeContext);
            } else if (Intrinsics.areEqual((Object) "1", (Object) obj7)) {
                Object obj11 = hashMap.get("params");
                m28788a(obj5, scopeContext, obj11 instanceof HashMap ? (HashMap) obj11 : null);
            } else {
                Object obj12 = hashMap.get("params");
                m28788a(obj5, (ScopeContext) null, obj12 instanceof HashMap ? (HashMap) obj12 : null);
            }
        } else {
            LogUtil.m29102e(TAG, "params = null");
        }
        return ActionResult.Companion.resolve$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28787a(int i, Ref.ObjectRef objectRef, ScopeContext scopeContext, String str) {
        Intrinsics.checkNotNullParameter(objectRef, "$mActInfo");
        if (i == 1 || i == 2) {
            ActivityValidateCheckHelper.checkActivityValidate((ActInfoEntity) objectRef.element, scopeContext);
        }
    }

    /* renamed from: a */
    private final void m28788a(String str, ScopeContext scopeContext, HashMap<String, Object> hashMap) {
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
                LogUtil.m29102e(TAG, "跳转失败");
            }
        } else {
            Request.Builder path = DiRouter.request().path(str);
            if (hashMap != null) {
                path.params(CheckStatuOpenPageActionKt.m28789a(hashMap));
            }
            if (scopeContext != null) {
                path.setFromPage(scopeContext);
            }
            path.open();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/CheckStatuOpenPageAction$Companion;", "", "()V", "ENABLE_PAGE_RESULT", "", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CheckStatuOpenPageAction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
