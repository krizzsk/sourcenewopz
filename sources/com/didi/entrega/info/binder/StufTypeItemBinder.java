package com.didi.entrega.info.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.info.model.StuffTypeItemModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\u001e\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufTypeItemBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/info/model/StuffTypeItemModel;", "Lcom/didi/entrega/info/binder/StufTypeItemBinder$ViewHolder;", "()V", "listener", "Lcom/didi/entrega/info/binder/StufTypeItemBinder$OnInfoTypeItemClickListener;", "getListener", "()Lcom/didi/entrega/info/binder/StufTypeItemBinder$OnInfoTypeItemClickListener;", "setListener", "(Lcom/didi/entrega/info/binder/StufTypeItemBinder$OnInfoTypeItemClickListener;)V", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "getColumnCount", "", "OnInfoTypeItemClickListener", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StufTypeItemBinder.kt */
public final class StufTypeItemBinder extends ItemBinder<StuffTypeItemModel, ViewHolder> {

    /* renamed from: a */
    private ScopeContext f20776a;

    /* renamed from: b */
    private OnInfoTypeItemClickListener f20777b;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufTypeItemBinder$OnInfoTypeItemClickListener;", "", "onInfoTypeItemClick", "", "item", "Lcom/didi/entrega/info/model/StuffTypeItemModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StufTypeItemBinder.kt */
    public interface OnInfoTypeItemClickListener {
        void onInfoTypeItemClick(StuffTypeItemModel stuffTypeItemModel);
    }

    public Class<StuffTypeItemModel> bindDataType() {
        return StuffTypeItemModel.class;
    }

    public int getColumnCount() {
        return 3;
    }

    public final ScopeContext getScopeContext() {
        return this.f20776a;
    }

    public final void setScopeContext(ScopeContext scopeContext) {
        this.f20776a = scopeContext;
    }

    public final OnInfoTypeItemClickListener getListener() {
        return this.f20777b;
    }

    public final void setListener(OnInfoTypeItemClickListener onInfoTypeItemClickListener) {
        this.f20777b = onInfoTypeItemClickListener;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.entrega_info_stuff_type_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…type_item, parent, false)");
        return new ViewHolder(this, inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006b, code lost:
        r6 = (r6 = r9.getStuffEntityData()).getCateName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.didi.entrega.info.binder.StufTypeItemBinder.ViewHolder r8, com.didi.entrega.info.model.StuffTypeItemModel r9) {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.view.View r8 = r8.itemView
            com.didi.app.nova.skeleton.ScopeContext r0 = r7.getScopeContext()
            r1 = 2131431962(0x7f0b121a, float:1.8485668E38)
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x0013
            goto L_0x0054
        L_0x0013:
            if (r9 != 0) goto L_0x0017
        L_0x0015:
            r4 = r3
            goto L_0x0022
        L_0x0017:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r4 = r9.getStuffEntityData()
            if (r4 != 0) goto L_0x001e
            goto L_0x0015
        L_0x001e:
            java.lang.String r4 = r4.getCateImg()
        L_0x0022:
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = com.didi.entrega.customer.foundation.util.FlyImageLoader.loadImage1x1((com.didi.app.nova.skeleton.ScopeContext) r0, (java.lang.String) r4)
            com.bumptech.glide.load.engine.DiskCacheStrategy r4 = com.bumptech.glide.load.engine.DiskCacheStrategy.RESOURCE
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.diskCacheStrategy(r4)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.skipMemoryCache(r2)
            android.content.Context r4 = r8.getContext()
            r5 = 2131232665(0x7f080799, float:1.8081446E38)
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r4, r5)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.placeholder((android.graphics.drawable.Drawable) r4)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.error((int) r5)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.dontAnimate()
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.centerCrop()
            android.view.View r4 = r8.findViewById(r1)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r0.into((android.widget.ImageView) r4)
        L_0x0054:
            r0 = 2131435432(0x7f0b1fa8, float:1.8492706E38)
            android.view.View r4 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r4 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r4
            java.lang.String r5 = ""
            if (r9 != 0) goto L_0x0064
        L_0x0061:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            goto L_0x0075
        L_0x0064:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r6 = r9.getStuffEntityData()
            if (r6 != 0) goto L_0x006b
            goto L_0x0061
        L_0x006b:
            java.lang.String r6 = r6.getCateName()
            if (r6 != 0) goto L_0x0072
            goto L_0x0061
        L_0x0072:
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
        L_0x0075:
            r4.setText(r5)
            com.didi.entrega.info.binder.-$$Lambda$StufTypeItemBinder$u3jk8SrYdF0G4aUnSWE0SsFDt0k r4 = new com.didi.entrega.info.binder.-$$Lambda$StufTypeItemBinder$u3jk8SrYdF0G4aUnSWE0SsFDt0k
            r4.<init>(r9)
            r8.setOnClickListener(r4)
            if (r9 != 0) goto L_0x0083
            goto L_0x0097
        L_0x0083:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r9 = r9.getStuffEntityData()
            if (r9 != 0) goto L_0x008a
            goto L_0x0097
        L_0x008a:
            java.lang.Boolean r9 = r9.getSelected()
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r2)
        L_0x0097:
            if (r2 == 0) goto L_0x00c5
            android.content.Context r9 = r8.getContext()
            r2 = 2131232671(0x7f08079f, float:1.8081458E38)
            android.graphics.drawable.Drawable r9 = androidx.core.content.ContextCompat.getDrawable(r9, r2)
            r8.setBackground(r9)
            android.view.View r9 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r9 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r9
            r0 = 2131101452(0x7f06070c, float:1.7815314E38)
            int r2 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r0)
            r9.setTextColor(r2)
            android.view.View r8 = r8.findViewById(r1)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            int r9 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r0)
            r8.setColorFilter(r9)
            goto L_0x00ec
        L_0x00c5:
            android.content.Context r9 = r8.getContext()
            r2 = 2131232672(0x7f0807a0, float:1.808146E38)
            android.graphics.drawable.Drawable r9 = androidx.core.content.ContextCompat.getDrawable(r9, r2)
            r8.setBackground(r9)
            android.view.View r9 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r9 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r9
            r0 = 2131101492(0x7f060734, float:1.7815395E38)
            int r0 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r0)
            r9.setTextColor(r0)
            android.view.View r8 = r8.findViewById(r1)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setColorFilter(r3)
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.binder.StufTypeItemBinder.bind(com.didi.entrega.info.binder.StufTypeItemBinder$ViewHolder, com.didi.entrega.info.model.StuffTypeItemModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15187a(StufTypeItemBinder stufTypeItemBinder, StuffTypeItemModel stuffTypeItemModel, View view) {
        Intrinsics.checkNotNullParameter(stufTypeItemBinder, "this$0");
        OnInfoTypeItemClickListener listener = stufTypeItemBinder.getListener();
        if (listener != null) {
            listener.onInfoTypeItemClick(stuffTypeItemModel);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufTypeItemBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/info/model/StuffTypeItemModel;", "rootView", "Landroid/view/View;", "(Lcom/didi/entrega/info/binder/StufTypeItemBinder;Landroid/view/View;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StufTypeItemBinder.kt */
    public final class ViewHolder extends ItemViewHolder<StuffTypeItemModel> {
        final /* synthetic */ StufTypeItemBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(StufTypeItemBinder stufTypeItemBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(stufTypeItemBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.this$0 = stufTypeItemBinder;
        }
    }
}
