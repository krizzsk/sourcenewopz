package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.FastPaySettingItem;
import com.didi.global.fintech.cashier.p117ui.viewholder.GlobalCashierBaseViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/FastPaySettingContentItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "tvSubTitle", "Landroid/widget/TextView;", "getTvSubTitle", "()Landroid/widget/TextView;", "setTvSubTitle", "(Landroid/widget/TextView;)V", "tvTitle", "getTvTitle", "setTvTitle", "initView", "", "layout", "", "updateSettingItem", "data", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.FastPaySettingContentItemViewHolder */
/* compiled from: FastPaySettingContentItemViewHolder.kt */
public final class FastPaySettingContentItemViewHolder extends GlobalCashierBaseViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public TextView tvSubTitle;
    public TextView tvTitle;

    public int layout() {
        return R.layout.viewholder_fast_pay_setting_content_item;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPaySettingContentItemViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/FastPaySettingContentItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/FastPaySettingContentItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.FastPaySettingContentItemViewHolder$Companion */
    /* compiled from: FastPaySettingContentItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPaySettingContentItemViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new FastPaySettingContentItemViewHolder(context, viewGroup);
        }
    }

    public final TextView getTvTitle() {
        TextView textView = this.tvTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    public final void setTvTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }

    public final TextView getTvSubTitle() {
        TextView textView = this.tvSubTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
        return null;
    }

    public final void setTvSubTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubTitle = textView;
    }

    public void initView() {
        super.initView();
        setTvTitle((TextView) getView(R.id.tv_item_title));
        setTvSubTitle((TextView) getView(R.id.tv_item_sub_title));
    }

    public final void updateSettingItem(FastPaySettingItem fastPaySettingItem) {
        Intrinsics.checkNotNullParameter(fastPaySettingItem, "data");
        ViewKtxKt.content(getTvTitle(), fastPaySettingItem.getTitle());
        ViewKtxKt.content(getTvSubTitle(), fastPaySettingItem.getSubtitle());
        getMRootView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FastPaySettingContentItemViewHolder.m15835a(FastPaySettingItem.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15835a(FastPaySettingItem fastPaySettingItem, View view) {
        Intrinsics.checkNotNullParameter(fastPaySettingItem, "$data");
        Function0<Unit> clickEvent = fastPaySettingItem.getClickEvent();
        if (clickEvent != null) {
            clickEvent.invoke();
        }
    }
}
