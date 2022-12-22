package com.didi.soda.blocks.scope;

import android.content.Context;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.widget.Buildable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J¢\u0001\u0010\u001d\u001a\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012B\u0012@\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tj\u0004\u0018\u0001`\u00132\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J$\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0016J§\u0001\u0010 \u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00052\u0001\u0010!\u001a\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012B\u0012@\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\tj\u0002`\u0013H\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000RÆ\u0002\u0010\b\u001a¹\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0001\u0012\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012B\u0012@\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\t0\u0004j\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0001\u0012\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012B\u0012@\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\tj\u0002`\u0013`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/blocks/scope/BlockScopeBase;", "Lcom/didi/soda/blocks/scope/IBlockScope;", "()V", "mAttached", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "mScopeActions", "Lkotlin/Function4;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "scope", "params", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "Lcom/didi/soda/blocks/action/ActionResult;", "Lcom/didi/soda/blocks/scope/ScopeAction;", "attach", "", "key", "value", "containsAction", "", "type", "detach", "detachAll", "getAction", "getObject", "getScopeParams", "registerAction", "action", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BlockScopeBase.kt */
public final class BlockScopeBase implements IBlockScope {
    private HashMap<String, Object> mAttached = new HashMap<>();
    private HashMap<String, Function4<Context, IBlockScope, HashMap<String, Object>, Buildable, ActionResult>> mScopeActions = new HashMap<>();

    public void attach(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(obj, "value");
        this.mAttached.put(str, obj);
    }

    public void detach(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mAttached.remove(str);
    }

    public Object getObject(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this.mAttached.get(str);
    }

    public void detachAll() {
        this.mAttached.clear();
    }

    public HashMap<String, Object> getScopeParams() {
        return this.mAttached;
    }

    public void registerAction(String str, Function4<? super Context, ? super IBlockScope, ? super HashMap<String, Object>, ? super Buildable, ActionResult> function4) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(function4, "action");
        this.mScopeActions.put(str, function4);
    }

    public Function4<Context, IBlockScope, HashMap<String, Object>, Buildable, ActionResult> getAction(String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return this.mScopeActions.get(str);
    }

    public boolean containsAction(String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return this.mScopeActions.containsKey(str);
    }
}
