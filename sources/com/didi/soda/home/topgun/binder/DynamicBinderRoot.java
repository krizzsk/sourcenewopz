package com.didi.soda.home.topgun.binder;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.blocks.binderpool.BinderRoot;
import com.didi.soda.customer.blocks.card.FallbackWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/DynamicBinderRoot;", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "Lcom/didi/soda/blocks/widget/Buildable;", "Lcom/didi/soda/blocks/model/ComponentModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "type", "", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "(Lcom/didi/soda/blocks/scope/IBlockScope;Ljava/lang/String;Lcom/didi/soda/blocks/BinderRootConfig;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "bind", "", "view", "data", "position", "", "createView", "context", "Landroid/content/Context;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DynamicRecyclerBinder.kt */
public final class DynamicBinderRoot extends BinderRoot<Buildable, ComponentModel> {

    /* renamed from: a */
    private IBlockScope f42749a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicBinderRoot(IBlockScope iBlockScope, String str, BinderRootConfig<ComponentModel> binderRootConfig) {
        super(str, binderRootConfig);
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(str, "type");
        this.f42749a = iBlockScope;
    }

    public final IBlockScope getScope() {
        return this.f42749a;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f42749a = iBlockScope;
    }

    public Buildable createView(Context context, ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(componentModel, "data");
        Buildable renderViewWithData = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).renderViewWithData(context, this.f42749a, componentModel.getWidgetNodeModel(), getConfig());
        return renderViewWithData == null ? new FallbackWidget(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null) : renderViewWithData;
    }

    public void bind(Buildable buildable, ComponentModel componentModel, int i) {
        Intrinsics.checkNotNullParameter(buildable, "view");
        Intrinsics.checkNotNullParameter(componentModel, "data");
        super.bind(buildable, componentModel, i);
        BlocksEngine.bindDataOnWidget$default(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null), this.f42749a, buildable, componentModel.getWidgetNodeModel(), (BinderRootConfig) null, 8, (Object) null);
    }
}
