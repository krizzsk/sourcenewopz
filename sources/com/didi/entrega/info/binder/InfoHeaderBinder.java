package com.didi.entrega.info.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.info.model.InfoHeaderModel;
import com.didi.entrega.info.widget.EntregaCustomerInfoProgressView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\u0003R\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/InfoHeaderBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/info/model/InfoHeaderModel;", "Lcom/didi/entrega/info/binder/InfoHeaderBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoHeaderBinder.kt */
public final class InfoHeaderBinder extends ItemBinder<InfoHeaderModel, ViewHolder> {
    public Class<InfoHeaderModel> bindDataType() {
        return InfoHeaderModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.entrega_info_header_binder, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…er_binder, parent, false)");
        return new ViewHolder(this, inflate);
    }

    public void bind(ViewHolder viewHolder, InfoHeaderModel infoHeaderModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (infoHeaderModel != null) {
            View view = viewHolder.itemView;
            ((EntregaCustomerInfoProgressView) view.findViewById(R.id.entrega_header)).setCurrentStep(infoHeaderModel.getCurrentStep());
            EntregaCustomerInfoProgressView entregaCustomerInfoProgressView = (EntregaCustomerInfoProgressView) view.findViewById(R.id.entrega_header);
            String title = infoHeaderModel.getTitle();
            if (title == null) {
                title = "";
            }
            entregaCustomerInfoProgressView.setTitleTxt(title);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/InfoHeaderBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/info/model/InfoHeaderModel;", "itemView", "Landroid/view/View;", "(Lcom/didi/entrega/info/binder/InfoHeaderBinder;Landroid/view/View;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InfoHeaderBinder.kt */
    public final class ViewHolder extends ItemViewHolder<InfoHeaderModel> {
        final /* synthetic */ InfoHeaderBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(InfoHeaderBinder infoHeaderBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(infoHeaderBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = infoHeaderBinder;
        }
    }
}
