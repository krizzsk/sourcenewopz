package com.didi.soda.blocks.style;

import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012[\u0010\t\u001aW\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\u0010R$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014Ro\u0010\t\u001aW\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/TrackSwBean;", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "", "(Lcom/didi/soda/blocks/scope/IBlockScope;Lcom/didi/soda/blocks/model/WidgetNodeModel;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getHandler", "()Lkotlin/jvm/functions/Function4;", "setHandler", "(Lkotlin/jvm/functions/Function4;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "getWidgetNodeModel", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setWidgetNodeModel", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseBinder.kt */
final class TrackSwBean {
    private List<? extends BaseAction> actions;
    private Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> handler;
    private IBlockScope scope;
    private WidgetNodeModel widgetNodeModel;

    public TrackSwBean(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel2, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(widgetNodeModel2, "widgetNodeModel");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        this.scope = iBlockScope;
        this.widgetNodeModel = widgetNodeModel2;
        this.actions = list;
        this.handler = function4;
    }

    public final IBlockScope getScope() {
        return this.scope;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "<set-?>");
        this.scope = iBlockScope;
    }

    public final WidgetNodeModel getWidgetNodeModel() {
        return this.widgetNodeModel;
    }

    public final void setWidgetNodeModel(WidgetNodeModel widgetNodeModel2) {
        Intrinsics.checkParameterIsNotNull(widgetNodeModel2, "<set-?>");
        this.widgetNodeModel = widgetNodeModel2;
    }

    public final List<BaseAction> getActions() {
        return this.actions;
    }

    public final void setActions(List<? extends BaseAction> list) {
        this.actions = list;
    }

    public final Function4<IBlockScope, WidgetNodeModel, Buildable, List<? extends BaseAction>, Unit> getHandler() {
        return this.handler;
    }

    public final void setHandler(Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "<set-?>");
        this.handler = function4;
    }
}
