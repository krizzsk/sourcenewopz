package com.didi.soda.blocks.scope;

import android.content.Context;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.widget.Buildable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J¢\u0001\u0010\f\u001a\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012B\u0012@\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rj\u0004\u0018\u0001`\u00192\u0006\u0010\t\u001a\u00020\u0005H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0014H&J§\u0001\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0001\u0010\u001d\u001a\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012B\u0012@\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019H&¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/blocks/scope/IBlockScope;", "", "attach", "", "key", "", "value", "containsAction", "", "type", "detach", "detachAll", "getAction", "Lkotlin/Function4;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "scope", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "Lcom/didi/soda/blocks/action/ActionResult;", "Lcom/didi/soda/blocks/scope/ScopeAction;", "getObject", "getScopeParams", "registerAction", "action", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: IBlockScope.kt */
public interface IBlockScope {
    void attach(String str, Object obj);

    boolean containsAction(String str);

    void detach(String str);

    void detachAll();

    Function4<Context, IBlockScope, HashMap<String, Object>, Buildable, ActionResult> getAction(String str);

    Object getObject(String str);

    HashMap<String, Object> getScopeParams();

    void registerAction(String str, Function4<? super Context, ? super IBlockScope, ? super HashMap<String, Object>, ? super Buildable, ActionResult> function4);
}
