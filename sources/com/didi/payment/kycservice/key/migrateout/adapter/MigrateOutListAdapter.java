package com.didi.payment.kycservice.key.migrateout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.kycservice.key.migrateout.adapter.MigrateOutListAdapter;
import com.didi.payment.kycservice.key.migrateout.response.PixKeyMigrateOutListResp;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter$_PendingKeyVH;", "itemListener", "Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter$IItemClickListener;", "(Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter$IItemClickListener;)V", "dataLst", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$KeyItem;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataSet", "IItemClickListener", "_PendingKeyVH", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MigrateOutListAdapter.kt */
public final class MigrateOutListAdapter extends RecyclerView.Adapter<_PendingKeyVH> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final IItemClickListener f30718a;

    /* renamed from: b */
    private ArrayList<PixKeyMigrateOutListResp.KeyItem> f30719b = new ArrayList<>();

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter$IItemClickListener;", "", "onItemClick", "", "position", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MigrateOutListAdapter.kt */
    public interface IItemClickListener {
        void onItemClick(int i);
    }

    public MigrateOutListAdapter(IItemClickListener iItemClickListener) {
        Intrinsics.checkNotNullParameter(iItemClickListener, "itemListener");
        this.f30718a = iItemClickListener;
    }

    public _PendingKeyVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_key_list_padding_key_item_new, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new _PendingKeyVH(this, inflate);
    }

    public void onBindViewHolder(_PendingKeyVH _pendingkeyvh, int i) {
        Intrinsics.checkNotNullParameter(_pendingkeyvh, "holder");
        PixKeyMigrateOutListResp.KeyItem keyItem = this.f30719b.get(i);
        Intrinsics.checkNotNullExpressionValue(keyItem, "dataLst[position]");
        _pendingkeyvh.bindData(keyItem, i);
    }

    public int getItemCount() {
        return this.f30719b.size();
    }

    public final void setData(ArrayList<PixKeyMigrateOutListResp.KeyItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "dataSet");
        this.f30719b.clear();
        this.f30719b.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter$_PendingKeyVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter;Landroid/view/View;)V", "_position", "", "ivLeftIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "tvMainTitle", "Landroid/widget/TextView;", "tvSubTitle", "bindData", "", "item", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$KeyItem;", "position", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MigrateOutListAdapter.kt */
    public final class _PendingKeyVH extends RecyclerView.ViewHolder {
        private int _position;
        private final ImageView ivLeftIcon;
        final /* synthetic */ MigrateOutListAdapter this$0;
        private final TextView tvMainTitle;
        private final TextView tvSubTitle;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public _PendingKeyVH(MigrateOutListAdapter migrateOutListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(migrateOutListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = migrateOutListAdapter;
            this.ivLeftIcon = (ImageView) view.findViewById(R.id.pix_key_item_left_icon);
            this.tvMainTitle = (TextView) view.findViewById(R.id.pix_key_item_title);
            this.tvSubTitle = (TextView) view.findViewById(R.id.pix_key_item_subtitle);
            view.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ MigrateOutListAdapter._PendingKeyVH f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    MigrateOutListAdapter._PendingKeyVH.m46544_init_$lambda0(MigrateOutListAdapter.this, this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m46544_init_$lambda0(MigrateOutListAdapter migrateOutListAdapter, _PendingKeyVH _pendingkeyvh, View view) {
            Intrinsics.checkNotNullParameter(migrateOutListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(_pendingkeyvh, "this$1");
            migrateOutListAdapter.f30718a.onItemClick(_pendingkeyvh._position);
        }

        public final void bindData(PixKeyMigrateOutListResp.KeyItem keyItem, int i) {
            Intrinsics.checkNotNullParameter(keyItem, "item");
            this._position = i;
            GlideUtils.with2load2into(this.itemView.getContext(), keyItem.getImgUrl(), this.ivLeftIcon);
            NViewUtils.INSTANCE.setText(this.tvMainTitle, keyItem.getValue());
            NViewUtils.INSTANCE.setText(this.tvSubTitle, keyItem.getDesc());
        }
    }
}
