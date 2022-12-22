package com.didi.soda.blocks.action;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.parse.NativeParamParser;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.scope.SampleScopeContext;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.widget.Buildable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ0\u0010\u001b\u001a\u00020\u001c2&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0002J\u0018\u0010\u001e\u001a\u00020\u001c2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0011J\u0018\u0010 \u001a\u00020\u001c2\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0011JH\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010&\u001a\u00020'H&J\u0018\u0010(\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J@\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010&\u001a\u00020'H\u0004J@\u0010*\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010&\u001a\u00020'H\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R:\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006+"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/BaseAction;", "Lcom/didi/soda/blocks/action/IAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mErrorCallbacks", "", "mSuccessCallBacks", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "getWidgetNodeModel", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setWidgetNodeModel", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "appendExcuteResult", "", "result", "attachErrorCallBacks", "errorCallBacks", "attachSuccessCallBacks", "successCallBacks", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "excute", "onReject", "onResolve", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseAction.kt */
public abstract class BaseAction implements IAction {
    private Context context;
    private List<? extends BaseAction> mErrorCallbacks;
    private List<? extends BaseAction> mSuccessCallBacks;
    private HashMap<String, Object> params;
    private WidgetNodeModel widgetNodeModel;

    public abstract ActionResult doExcute(Context context2, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable);

    public BaseAction(WidgetNodeModel widgetNodeModel2, Context context2, HashMap<String, Object> hashMap) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.widgetNodeModel = widgetNodeModel2;
        this.context = context2;
        this.params = hashMap;
    }

    public final WidgetNodeModel getWidgetNodeModel() {
        return this.widgetNodeModel;
    }

    public final void setWidgetNodeModel(WidgetNodeModel widgetNodeModel2) {
        this.widgetNodeModel = widgetNodeModel2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "<set-?>");
        this.context = context2;
    }

    public final HashMap<String, Object> getParams() {
        return this.params;
    }

    public final void setParams(HashMap<String, Object> hashMap) {
        this.params = hashMap;
    }

    public void excute(IBlockScope iBlockScope, Buildable buildable) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(buildable, "widget");
        HashMap<String, Object> hashMap = this.params;
        if (hashMap != null && this.widgetNodeModel != null) {
            if (((ScopeContext) iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT)) == null) {
                if (!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug()) {
                    iBlockScope.attach(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT, new SampleScopeContext());
                } else {
                    throw new IllegalStateException("Calling BlocksEngine renderViewWithData or bindDataOnWidget requires a valid argument block with ScopeContext".toString());
                }
            }
            NativeParamParser.Companion companion = NativeParamParser.Companion;
            WidgetNodeModel widgetNodeModel2 = this.widgetNodeModel;
            if (widgetNodeModel2 == null) {
                Intrinsics.throwNpe();
            }
            companion.parseNativeParams(widgetNodeModel2, iBlockScope, hashMap);
            ActionResult doExcute = doExcute(this.context, iBlockScope, hashMap, buildable);
            if (doExcute.getStatus() == ActionResult.Status.RESOLVE) {
                onResolve(iBlockScope, doExcute.getParams(), buildable);
            } else {
                onReject(iBlockScope, doExcute.getParams(), buildable);
            }
        }
    }

    public final void attachSuccessCallBacks(List<? extends BaseAction> list) {
        this.mSuccessCallBacks = list;
    }

    public final void attachErrorCallBacks(List<? extends BaseAction> list) {
        this.mErrorCallbacks = list;
    }

    private final void appendExcuteResult(HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        if (hashMap != null && (hashMap2 = this.params) != null) {
            hashMap2.putAll(hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public final void onResolve(IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(buildable, "widget");
        List<? extends BaseAction> list = this.mSuccessCallBacks;
        if (list != null) {
            for (BaseAction baseAction : list) {
                if (baseAction != null) {
                    baseAction.appendExcuteResult(hashMap);
                }
                if (baseAction != null) {
                    baseAction.excute(iBlockScope, buildable);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onReject(IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(buildable, "widget");
        List<? extends BaseAction> list = this.mErrorCallbacks;
        if (list != null) {
            for (BaseAction baseAction : list) {
                if (baseAction != null) {
                    baseAction.appendExcuteResult(hashMap);
                }
                if (baseAction != null) {
                    baseAction.excute(iBlockScope, buildable);
                }
            }
        }
    }
}
