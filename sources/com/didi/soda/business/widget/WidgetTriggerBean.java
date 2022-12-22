package com.didi.soda.business.widget;

import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012F\u0010\t\u001aB\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\u0010\u000fR$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RZ\u0010\t\u001aB\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000e0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/business/widget/WidgetTriggerBean;", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetBuildable", "Lcom/didi/soda/blocks/widget/Buildable;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "widget", "", "(Lcom/didi/soda/blocks/scope/IBlockScope;Lcom/didi/soda/blocks/widget/Buildable;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getHandler", "()Lkotlin/jvm/functions/Function3;", "setHandler", "(Lkotlin/jvm/functions/Function3;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "getWidgetBuildable", "()Lcom/didi/soda/blocks/widget/Buildable;", "setWidgetBuildable", "(Lcom/didi/soda/blocks/widget/Buildable;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WidgetTriggerBean.kt */
public final class WidgetTriggerBean {

    /* renamed from: a */
    private IBlockScope f39881a;

    /* renamed from: b */
    private Buildable f39882b;

    /* renamed from: c */
    private List<? extends BaseAction> f39883c;

    /* renamed from: d */
    private Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> f39884d;

    public WidgetTriggerBean(IBlockScope iBlockScope, Buildable buildable, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(buildable, "widgetBuildable");
        Intrinsics.checkNotNullParameter(function3, "handler");
        this.f39881a = iBlockScope;
        this.f39882b = buildable;
        this.f39883c = list;
        this.f39884d = function3;
    }

    public final IBlockScope getScope() {
        return this.f39881a;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f39881a = iBlockScope;
    }

    public final Buildable getWidgetBuildable() {
        return this.f39882b;
    }

    public final void setWidgetBuildable(Buildable buildable) {
        Intrinsics.checkNotNullParameter(buildable, "<set-?>");
        this.f39882b = buildable;
    }

    public final List<BaseAction> getActions() {
        return this.f39883c;
    }

    public final void setActions(List<? extends BaseAction> list) {
        this.f39883c = list;
    }

    public final Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> getHandler() {
        return this.f39884d;
    }

    public final void setHandler(Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.f39884d = function3;
    }
}
