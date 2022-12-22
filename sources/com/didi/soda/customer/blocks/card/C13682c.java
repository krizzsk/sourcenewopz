package com.didi.soda.customer.blocks.card;

import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012[\u0010\t\u001aW\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\u0010R$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014Ro\u0010\t\u001aW\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/TrackSwBean;", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "", "(Lcom/didi/soda/blocks/scope/IBlockScope;Lcom/didi/soda/blocks/model/WidgetNodeModel;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getHandler", "()Lkotlin/jvm/functions/Function4;", "setHandler", "(Lkotlin/jvm/functions/Function4;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "getWidgetNodeModel", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setWidgetNodeModel", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.blocks.card.c */
/* compiled from: TopicItemWidget.kt */
final class C13682c {

    /* renamed from: a */
    private IBlockScope f40618a;

    /* renamed from: b */
    private WidgetNodeModel f40619b;

    /* renamed from: c */
    private List<? extends BaseAction> f40620c;

    /* renamed from: d */
    private Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> f40621d;

    public C13682c(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(widgetNodeModel, "widgetNodeModel");
        Intrinsics.checkNotNullParameter(function4, "handler");
        this.f40618a = iBlockScope;
        this.f40619b = widgetNodeModel;
        this.f40620c = list;
        this.f40621d = function4;
    }

    /* renamed from: a */
    public final IBlockScope mo102458a() {
        return this.f40618a;
    }

    /* renamed from: a */
    public final void mo102460a(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f40618a = iBlockScope;
    }

    /* renamed from: a */
    public final void mo102459a(WidgetNodeModel widgetNodeModel) {
        Intrinsics.checkNotNullParameter(widgetNodeModel, "<set-?>");
        this.f40619b = widgetNodeModel;
    }

    /* renamed from: b */
    public final WidgetNodeModel mo102463b() {
        return this.f40619b;
    }

    /* renamed from: a */
    public final void mo102461a(List<? extends BaseAction> list) {
        this.f40620c = list;
    }

    /* renamed from: c */
    public final List<BaseAction> mo102464c() {
        return this.f40620c;
    }

    /* renamed from: a */
    public final void mo102462a(Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "<set-?>");
        this.f40621d = function4;
    }

    /* renamed from: d */
    public final Function4<IBlockScope, WidgetNodeModel, Buildable, List<? extends BaseAction>, Unit> mo102465d() {
        return this.f40621d;
    }
}
