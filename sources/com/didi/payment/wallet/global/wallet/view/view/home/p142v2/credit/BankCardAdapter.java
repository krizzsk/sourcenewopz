package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.credit;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardHolder;", "entries", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Entry;", "listener", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/IBankCardListener;", "(Ljava/util/List;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/IBankCardListener;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getEntries", "()Ljava/util/List;", "setEntries", "(Ljava/util/List;)V", "getListener", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/IBankCardListener;", "setListener", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/IBankCardListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.BankCardAdapter */
/* compiled from: BankCardAdapter.kt */
public final class BankCardAdapter extends RecyclerView.Adapter<BankCardHolder> {

    /* renamed from: a */
    private List<Entry> f32668a;

    /* renamed from: b */
    private IBankCardListener f32669b;

    /* renamed from: c */
    private Context f32670c;

    public BankCardAdapter(List<Entry> list, IBankCardListener iBankCardListener) {
        Intrinsics.checkNotNullParameter(iBankCardListener, "listener");
        this.f32668a = list;
        this.f32669b = iBankCardListener;
    }

    public final List<Entry> getEntries() {
        return this.f32668a;
    }

    public final IBankCardListener getListener() {
        return this.f32669b;
    }

    public final void setEntries(List<Entry> list) {
        this.f32668a = list;
    }

    public final void setListener(IBankCardListener iBankCardListener) {
        Intrinsics.checkNotNullParameter(iBankCardListener, "<set-?>");
        this.f32669b = iBankCardListener;
    }

    public final Context getContext() {
        return this.f32670c;
    }

    public final void setContext(Context context) {
        this.f32670c = context;
    }

    public BankCardHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        this.f32670c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_bank_card_view, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new BankCardHolder(inflate);
    }

    public void onBindViewHolder(BankCardHolder bankCardHolder, int i) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(bankCardHolder, "holder");
        List<Entry> list = this.f32668a;
        String str3 = null;
        Entry entry = list == null ? null : list.get(i);
        if (entry == null) {
            str = null;
        } else {
            str = entry.getCardIndex();
        }
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            Context context = this.f32670c;
            if (context != null) {
                Glide.with(context).load(Integer.valueOf(R.drawable.wallet_paymethod_add)).into(bankCardHolder.getIvIcon());
                bankCardHolder.getTvDesc().setTextColor(ContextCompat.getColor(context, R.color.wallet_color_999999));
            }
            List<Entry> list2 = this.f32668a;
            if ((list2 == null ? 0 : list2.size()) > 1) {
                ViewGroup.LayoutParams layoutParams = bankCardHolder.itemView.getLayoutParams();
                if (layoutParams != null) {
                    ((RecyclerView.LayoutParams) layoutParams).topMargin = UIUtils.dip2px(this.f32670c, 10.0f);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
        } else {
            Context context2 = this.f32670c;
            if (context2 != null) {
                if (entry == null) {
                    str2 = null;
                } else {
                    str2 = entry.getIconUrl();
                }
                GlideUtils.with2load2into(context2, str2, bankCardHolder.getIvIcon());
            }
        }
        bankCardHolder.getTvCard().setText(entry == null ? null : entry.getName());
        bankCardHolder.getTvDesc().setText(entry == null ? null : entry.getDesc());
        bankCardHolder.getTvDesc().setVisibility(!TextUtils.isEmpty(entry == null ? null : entry.getDesc()) ? 0 : 8);
        bankCardHolder.getTvExpired().setText(entry == null ? null : entry.getExpiredDesc());
        TextView tvExpired = bankCardHolder.getTvExpired();
        if (entry != null) {
            str3 = entry.getExpiredDesc();
        }
        if (TextUtils.isEmpty(str3)) {
            i2 = 8;
        }
        tvExpired.setVisibility(i2);
        bankCardHolder.itemView.setOnClickListener(new View.OnClickListener(i, entry) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ Entry f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                BankCardAdapter.m23115a(BankCardAdapter.this, this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23115a(BankCardAdapter bankCardAdapter, int i, Entry entry, View view) {
        Intrinsics.checkNotNullParameter(bankCardAdapter, "this$0");
        bankCardAdapter.getListener().onBankCardClick(i, entry);
    }

    public int getItemCount() {
        List<Entry> list = this.f32668a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
