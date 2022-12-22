package com.didi.payment.kycservice.key.list.adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.kycservice.key.list.adaper.PixKeyListAdapter;
import com.didi.payment.kycservice.key.list.response.PixKeyListResp;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001d\u001e\u001f B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0014\u0010\u001b\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "onItemClickListener", "Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$IItemClickListener;", "(Landroid/content/Context;Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$IItemClickListener;)V", "getContext", "()Landroid/content/Context;", "dataLst", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "Lkotlin/collections/ArrayList;", "getOnItemClickListener", "()Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$IItemClickListener;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataSet", "IItemClickListener", "_NormalKeyVH", "_PendingKeyVH", "_RegisterKeyVH", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyListAdapter.kt */
public final class PixKeyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private final Context f30705a;

    /* renamed from: b */
    private final IItemClickListener f30706b;

    /* renamed from: c */
    private ArrayList<PixKeyListResp.KeyItem> f30707c = new ArrayList<>();

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$IItemClickListener;", "", "onItemClick", "", "item", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyListAdapter.kt */
    public interface IItemClickListener {
        void onItemClick(PixKeyListResp.KeyItem keyItem);
    }

    public PixKeyListAdapter(Context context, IItemClickListener iItemClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iItemClickListener, "onItemClickListener");
        this.f30705a = context;
        this.f30706b = iItemClickListener;
    }

    public final Context getContext() {
        return this.f30705a;
    }

    public final IItemClickListener getOnItemClickListener() {
        return this.f30706b;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_key_list_normal_key_item_new, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new _NormalKeyVH(this, inflate);
        } else if (i == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_key_list_padding_key_item_new, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "view");
            return new _PendingKeyVH(this, inflate2);
        } else if (i != 2) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_key_list_register_key_item_new, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new _RegisterKeyVH(this, inflate3);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_key_list_padding_key_item_new, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "view");
            return new _PendingKeyVH(this, inflate4);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        PixKeyListResp.KeyItem keyItem = this.f30707c.get(i);
        Intrinsics.checkNotNullExpressionValue(keyItem, "dataLst[position]");
        PixKeyListResp.KeyItem keyItem2 = keyItem;
        if (viewHolder instanceof _NormalKeyVH) {
            ((_NormalKeyVH) viewHolder).bindData(keyItem2);
        } else if (viewHolder instanceof _PendingKeyVH) {
            ((_PendingKeyVH) viewHolder).bindData(keyItem2);
        } else if (viewHolder instanceof _RegisterKeyVH) {
            ((_RegisterKeyVH) viewHolder).bindData(keyItem2);
        }
    }

    public int getItemCount() {
        return this.f30707c.size();
    }

    public int getItemViewType(int i) {
        return this.f30707c.get(i).getStatus();
    }

    public final void setData(ArrayList<PixKeyListResp.KeyItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "dataSet");
        this.f30707c.clear();
        this.f30707c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$_NormalKeyVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter;Landroid/view/View;)V", "itemData", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "ivLeftIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "tvMainTitle", "Landroid/widget/TextView;", "tvTip", "bindData", "", "item", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyListAdapter.kt */
    public final class _NormalKeyVH extends RecyclerView.ViewHolder {
        private PixKeyListResp.KeyItem itemData;
        private final ImageView ivLeftIcon;
        final /* synthetic */ PixKeyListAdapter this$0;
        private final TextView tvMainTitle;
        private final TextView tvTip;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public _NormalKeyVH(PixKeyListAdapter pixKeyListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(pixKeyListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = pixKeyListAdapter;
            this.ivLeftIcon = (ImageView) view.findViewById(R.id.pix_key_item_left_icon);
            this.tvMainTitle = (TextView) view.findViewById(R.id.pix_key_item_title);
            this.tvTip = (TextView) view.findViewById(R.id.pix_key_item_tip);
            view.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ PixKeyListAdapter._NormalKeyVH f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PixKeyListAdapter._NormalKeyVH.m46539_init_$lambda0(PixKeyListAdapter.this, this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m46539_init_$lambda0(PixKeyListAdapter pixKeyListAdapter, _NormalKeyVH _normalkeyvh, View view) {
            Intrinsics.checkNotNullParameter(pixKeyListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(_normalkeyvh, "this$1");
            IItemClickListener onItemClickListener = pixKeyListAdapter.getOnItemClickListener();
            PixKeyListResp.KeyItem keyItem = _normalkeyvh.itemData;
            if (keyItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                keyItem = null;
            }
            onItemClickListener.onItemClick(keyItem);
        }

        public final void bindData(PixKeyListResp.KeyItem keyItem) {
            Intrinsics.checkNotNullParameter(keyItem, "item");
            this.itemData = keyItem;
            GlideUtils.with2load2into(this.itemView.getContext(), keyItem.getImgUrl(), this.ivLeftIcon);
            NViewUtils.INSTANCE.setText(this.tvMainTitle, keyItem.getValue().toString());
            this.tvTip.setVisibility(keyItem.isDefault() ? 0 : 8);
        }
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$_PendingKeyVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter;Landroid/view/View;)V", "itemData", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "ivLeftIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "tvMainTitle", "Landroid/widget/TextView;", "tvSubTitle", "bindData", "", "item", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyListAdapter.kt */
    public final class _PendingKeyVH extends RecyclerView.ViewHolder {
        private PixKeyListResp.KeyItem itemData;
        private final ImageView ivLeftIcon;
        final /* synthetic */ PixKeyListAdapter this$0;
        private final TextView tvMainTitle;
        private final TextView tvSubTitle;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public _PendingKeyVH(PixKeyListAdapter pixKeyListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(pixKeyListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = pixKeyListAdapter;
            this.ivLeftIcon = (ImageView) view.findViewById(R.id.pix_key_item_left_icon);
            this.tvMainTitle = (TextView) view.findViewById(R.id.pix_key_item_title);
            this.tvSubTitle = (TextView) view.findViewById(R.id.pix_key_item_subtitle);
            view.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ PixKeyListAdapter._PendingKeyVH f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PixKeyListAdapter._PendingKeyVH.m46540_init_$lambda0(PixKeyListAdapter.this, this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m46540_init_$lambda0(PixKeyListAdapter pixKeyListAdapter, _PendingKeyVH _pendingkeyvh, View view) {
            Intrinsics.checkNotNullParameter(pixKeyListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(_pendingkeyvh, "this$1");
            IItemClickListener onItemClickListener = pixKeyListAdapter.getOnItemClickListener();
            PixKeyListResp.KeyItem keyItem = _pendingkeyvh.itemData;
            if (keyItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                keyItem = null;
            }
            onItemClickListener.onItemClick(keyItem);
        }

        public final void bindData(PixKeyListResp.KeyItem keyItem) {
            Intrinsics.checkNotNullParameter(keyItem, "item");
            this.itemData = keyItem;
            GlideUtils.with2load2into(this.itemView.getContext(), keyItem.getImgUrl(), this.ivLeftIcon);
            NViewUtils.INSTANCE.setText(this.tvMainTitle, keyItem.getValue().toString());
            NViewUtils.INSTANCE.setText(this.tvSubTitle, keyItem.getDesc());
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter$_RegisterKeyVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter;Landroid/view/View;)V", "itemData", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "bindData", "", "item", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyListAdapter.kt */
    public final class _RegisterKeyVH extends RecyclerView.ViewHolder {
        private PixKeyListResp.KeyItem itemData;
        final /* synthetic */ PixKeyListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public _RegisterKeyVH(PixKeyListAdapter pixKeyListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(pixKeyListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = pixKeyListAdapter;
            view.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ PixKeyListAdapter._RegisterKeyVH f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PixKeyListAdapter._RegisterKeyVH.m46541_init_$lambda0(PixKeyListAdapter.this, this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m46541_init_$lambda0(PixKeyListAdapter pixKeyListAdapter, _RegisterKeyVH _registerkeyvh, View view) {
            Intrinsics.checkNotNullParameter(pixKeyListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(_registerkeyvh, "this$1");
            IItemClickListener onItemClickListener = pixKeyListAdapter.getOnItemClickListener();
            PixKeyListResp.KeyItem keyItem = _registerkeyvh.itemData;
            if (keyItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                keyItem = null;
            }
            onItemClickListener.onItemClick(keyItem);
        }

        public final void bindData(PixKeyListResp.KeyItem keyItem) {
            Intrinsics.checkNotNullParameter(keyItem, "item");
            this.itemData = keyItem;
        }
    }
}
