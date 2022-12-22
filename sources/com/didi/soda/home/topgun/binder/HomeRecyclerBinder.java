package com.didi.soda.home.topgun.binder;

import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.binderpool.BinderRoot;
import com.didi.soda.customer.blocks.binderpool.RecyclerBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeRecyclerBinder;", "Lcom/didi/soda/customer/blocks/binderpool/RecyclerBinder;", "Lcom/didi/soda/blocks/model/ComponentModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "itemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "(Lcom/didi/soda/blocks/scope/IBlockScope;Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;Lcom/didi/soda/blocks/BinderRootConfig;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "bindDataType", "Ljava/lang/Class;", "createBinderRoot", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "Lcom/didi/soda/blocks/widget/Buildable;", "type", "", "extraCanBindCondition", "", "item", "getBinderRootType", "data", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeRecyclerBinder.kt */
public final class HomeRecyclerBinder extends RecyclerBinder<ComponentModel> {

    /* renamed from: a */
    private IBlockScope f42758a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeRecyclerBinder(IBlockScope iBlockScope, ItemDecorator itemDecorator) {
        this(iBlockScope, itemDecorator, (BinderRootConfig) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
    }

    public Class<ComponentModel> bindDataType() {
        return ComponentModel.class;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeRecyclerBinder(IBlockScope iBlockScope, ItemDecorator itemDecorator, BinderRootConfig<ComponentModel> binderRootConfig) {
        super(itemDecorator, binderRootConfig);
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
        this.f42758a = iBlockScope;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeRecyclerBinder(IBlockScope iBlockScope, ItemDecorator itemDecorator, BinderRootConfig binderRootConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iBlockScope, itemDecorator, (i & 4) != 0 ? null : binderRootConfig);
    }

    public final IBlockScope getScope() {
        return this.f42758a;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f42758a = iBlockScope;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r2 = r2.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getBinderRootType(com.didi.soda.blocks.model.ComponentModel r2) {
        /*
            r1 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.didi.soda.blocks.model.WidgetNodeModel r2 = r2.getWidgetNodeModel()
            java.lang.String r0 = ""
            if (r2 != 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            java.lang.String r2 = r2.getName()
            if (r2 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r2
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.binder.HomeRecyclerBinder.getBinderRootType(com.didi.soda.blocks.model.ComponentModel):java.lang.String");
    }

    public boolean extraCanBindCondition(ComponentModel componentModel) {
        WidgetNodeModel widgetNodeModel;
        String version;
        String str = "1";
        if (!(componentModel == null || (widgetNodeModel = componentModel.getWidgetNodeModel()) == null || (version = widgetNodeModel.getVersion()) == null)) {
            str = version;
        }
        return Integer.parseInt(str) <= 1;
    }

    public BinderRoot<? extends Buildable, ComponentModel> createBinderRoot(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        switch (str.hashCode()) {
            case -1013042438:
                if (str.equals(BlocksConst.WIDGET_NAME_TOPIC)) {
                    return new TopicBinderRoot(this.f42758a, str);
                }
                break;
            case -669784221:
                if (str.equals(BlocksConst.WIDGET_NAME_SHOPCARD_LEFT_IMAGE)) {
                    return new HomeLeftImageBinderRoot(this.f42758a, str, getConfig());
                }
                break;
            case 1286170328:
                if (str.equals(BlocksConst.WIDGET_NAME_COLUMN)) {
                    return new HomeColumnRoot(this.f42758a, str);
                }
                break;
            case 1536353884:
                if (str.equals(BlocksConst.WIDGET_NAME_SHOPCARD_TOP_IMAGE)) {
                    return new HomeTopImageBinderRoot(this.f42758a, str, getConfig());
                }
                break;
            case 1545892610:
                if (str.equals(BlocksConst.WIDGET_NAME_SHOP_AND_ITEMS)) {
                    return new LandingTopicWidgetRoot(this.f42758a, str);
                }
                break;
            case 1760857124:
                if (str.equals(BlocksConst.WIDGET_NAME_ROW_TWIN)) {
                    return new RowTwinWidgetRoot(this.f42758a, str);
                }
                break;
        }
        return new WidgetBinderRoot(this.f42758a, str, getConfig());
    }
}
