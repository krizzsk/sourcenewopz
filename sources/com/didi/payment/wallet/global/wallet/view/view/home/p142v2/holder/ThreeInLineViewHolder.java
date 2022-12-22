package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/ThreeInLineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/IHomeViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Entry;", "itemView", "Landroid/view/View;", "listener", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "(Landroid/view/View;Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "ivFunc", "Landroid/widget/ImageView;", "getListener", "()Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "setListener", "(Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "llCard", "Landroid/widget/LinearLayout;", "tvStatus", "Landroid/widget/TextView;", "tvTitle", "getViewType", "", "onBindViewHolder", "", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.ThreeInLineViewHolder */
/* compiled from: ThreeInLineViewHolder.kt */
public final class ThreeInLineViewHolder extends RecyclerView.ViewHolder implements IHomeViewHolder<Entry> {

    /* renamed from: a */
    private WalletHomeContract.V2Listener f32691a;

    /* renamed from: b */
    private final LinearLayout f32692b;

    /* renamed from: c */
    private final ImageView f32693c;

    /* renamed from: d */
    private final TextView f32694d;

    /* renamed from: e */
    private final TextView f32695e;

    public int getViewType() {
        return 2;
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeInLineViewHolder(View view, WalletHomeContract.V2Listener v2Listener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.f32691a = v2Listener;
        View findViewById = view.findViewById(R.id.ll_card);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.ll_card)");
        this.f32692b = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_func);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_func)");
        this.f32693c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_title)");
        this.f32694d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_status);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_status)");
        this.f32695e = (TextView) findViewById4;
    }

    public final WalletHomeContract.V2Listener getListener() {
        return this.f32691a;
    }

    public final void setListener(WalletHomeContract.V2Listener v2Listener) {
        this.f32691a = v2Listener;
    }

    public void onBindViewHolder(WalletHomeHolderData<Entry> walletHomeHolderData) {
        Intrinsics.checkNotNullParameter(walletHomeHolderData, "info");
        Entry contentObj = walletHomeHolderData.getContentObj();
        if (contentObj != null) {
            this.f32694d.setText(contentObj.getName());
            TextView textView = this.f32695e;
            PayRichInfo promotionText = contentObj.getPromotionText();
            String str = null;
            textView.setVisibility(!TextUtils.isEmpty(promotionText == null ? null : promotionText.text) ? 0 : 8);
            TextView textView2 = this.f32695e;
            PayRichInfo promotionText2 = contentObj.getPromotionText();
            if (promotionText2 != null) {
                str = promotionText2.text;
            }
            textView2.setText(str);
            PayRichInfo promotionText3 = contentObj.getPromotionText();
            if (promotionText3 != null) {
                promotionText3.bindTextView(this.f32695e);
            }
            String iconUrl = contentObj.getIconUrl();
            if (iconUrl != null) {
                GlideUtils.with2load2into(this.itemView.getContext(), iconUrl, this.f32693c);
            }
            this.f32692b.setOnClickListener(new View.OnClickListener(contentObj) {
                public final /* synthetic */ Entry f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ThreeInLineViewHolder.m23124a(ThreeInLineViewHolder.this, this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23124a(ThreeInLineViewHolder threeInLineViewHolder, Entry entry, View view) {
        Intrinsics.checkNotNullParameter(threeInLineViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(entry, "$this_apply");
        WalletHomeContract.V2Listener listener = threeInLineViewHolder.getListener();
        if (listener != null) {
            listener.onConsumeItemClicked(entry);
        }
        WalletHomeTrackerManager.Companion.trackPaySKUClick(entry.getName());
    }
}
