package com.didi.payment.kycservice.kyc.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.kycservice.kyc.fragment.SignUpRvAdapter;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\"\u0010\u0018\u001a\u00020\u00112\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$_VH;", "()V", "dataLst", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;", "getOnItemClickListener", "()Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;", "setOnItemClickListener", "(Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataSet", "ItemClickListener", "_VH", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpRvAdapter.kt */
public final class SignUpRvAdapter extends RecyclerView.Adapter<_VH> {

    /* renamed from: a */
    private ArrayList<PixChooseTypeListResp.Item> f30841a = new ArrayList<>();

    /* renamed from: b */
    private ItemClickListener f30842b;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;", "", "onItemClick", "", "item", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpRvAdapter.kt */
    public interface ItemClickListener {
        void onItemClick(PixChooseTypeListResp.Item item);
    }

    public final ItemClickListener getOnItemClickListener() {
        return this.f30842b;
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.f30842b = itemClickListener;
    }

    public _VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_sign_up_choose_item_new, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new _VH(inflate, this.f30842b);
    }

    public void onBindViewHolder(_VH _vh, int i) {
        Intrinsics.checkNotNullParameter(_vh, "holder");
        PixChooseTypeListResp.Item item = this.f30841a.get(i);
        Intrinsics.checkNotNullExpressionValue(item, "dataLst[position]");
        _vh.bindData(item);
    }

    public int getItemCount() {
        return this.f30841a.size();
    }

    public final void setData(ArrayList<PixChooseTypeListResp.Item> arrayList) {
        if (arrayList != null) {
            this.f30841a.clear();
            this.f30841a.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bR\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$_VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onItemClickListener", "Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;", "(Landroid/view/View;Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter$ItemClickListener;)V", "imgLeftIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "itemData", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "tvMainTitle", "Landroid/widget/TextView;", "tvSubTitle", "tvTip", "bindData", "", "item", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpRvAdapter.kt */
    public static final class _VH extends RecyclerView.ViewHolder {
        private final ImageView imgLeftIcon;
        private PixChooseTypeListResp.Item itemData;
        private final ItemClickListener onItemClickListener;
        private final TextView tvMainTitle;
        private final TextView tvSubTitle;
        private final TextView tvTip;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public _VH(View view, ItemClickListener itemClickListener) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.onItemClickListener = itemClickListener;
            this.imgLeftIcon = (ImageView) view.findViewById(R.id.pix_sign_up_item_left_icon);
            this.tvMainTitle = (TextView) view.findViewById(R.id.pix_sign_up_item_title);
            this.tvSubTitle = (TextView) view.findViewById(R.id.pix_sign_up_item_subtitle);
            this.tvTip = (TextView) view.findViewById(R.id.pix_sign_up_item_tip);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUpRvAdapter._VH.m46577_init_$lambda0(SignUpRvAdapter._VH.this, view);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m46577_init_$lambda0(_VH _vh, View view) {
            Intrinsics.checkNotNullParameter(_vh, "this$0");
            ItemClickListener itemClickListener = _vh.onItemClickListener;
            if (itemClickListener != null) {
                PixChooseTypeListResp.Item item = _vh.itemData;
                if (item == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemData");
                    item = null;
                }
                itemClickListener.onItemClick(item);
            }
        }

        public final void bindData(PixChooseTypeListResp.Item item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
            CharSequence imgUrl = item.getImgUrl();
            int i = 0;
            if (imgUrl == null || imgUrl.length() == 0) {
                this.imgLeftIcon.setVisibility(8);
            } else {
                this.imgLeftIcon.setVisibility(0);
                GlideUtils.with2load2into(this.itemView.getContext(), item.getImgUrl(), this.imgLeftIcon);
            }
            NViewUtils.INSTANCE.setText(this.tvMainTitle, item.getValue());
            NViewUtils.INSTANCE.setText(this.tvSubTitle, item.getDesc());
            TextView textView = this.tvTip;
            if (!item.isRecommend()) {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }
}
