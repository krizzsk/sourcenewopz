package com.didi.entrega.info.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.info.model.HistoryModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0017J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, mo175978d2 = {"Lcom/didi/entrega/info/binder/HistoryItemBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/info/model/HistoryModel;", "Lcom/didi/entrega/info/binder/HistoryItemBinder$ViewHolder;", "()V", "ENTREGA_ADDRESS", "", "SODA_ADDRESS", "binderFusionChannel", "getBinderFusionChannel", "()I", "setBinderFusionChannel", "(I)V", "historyClickListener", "Lcom/didi/entrega/info/binder/HistoryItemBinder$HistoryClickListener;", "getHistoryClickListener", "()Lcom/didi/entrega/info/binder/HistoryItemBinder$HistoryClickListener;", "setHistoryClickListener", "(Lcom/didi/entrega/info/binder/HistoryItemBinder$HistoryClickListener;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "HistoryClickListener", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HistoryItemBinder.kt */
public final class HistoryItemBinder extends ItemBinder<HistoryModel, ViewHolder> {

    /* renamed from: a */
    private HistoryClickListener f20764a;

    /* renamed from: b */
    private int f20765b;

    /* renamed from: c */
    private final int f20766c = 1;

    /* renamed from: d */
    private final int f20767d = 2;

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/HistoryItemBinder$HistoryClickListener;", "", "onClickDelete", "", "item", "Lcom/didi/entrega/info/model/HistoryModel;", "onClickItem", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HistoryItemBinder.kt */
    public interface HistoryClickListener {
        void onClickDelete(HistoryModel historyModel);

        void onClickItem(HistoryModel historyModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15180a(View view) {
    }

    public Class<HistoryModel> bindDataType() {
        return HistoryModel.class;
    }

    public final HistoryClickListener getHistoryClickListener() {
        return this.f20764a;
    }

    public final void setHistoryClickListener(HistoryClickListener historyClickListener) {
        this.f20764a = historyClickListener;
    }

    public final int getBinderFusionChannel() {
        return this.f20765b;
    }

    public final void setBinderFusionChannel(int i) {
        this.f20765b = i;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.entrega_info_history_contact_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…tact_item, parent, false)");
        return new ViewHolder(this, inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        r0 = r0.getAddress();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.didi.entrega.info.binder.HistoryItemBinder.ViewHolder r8, com.didi.entrega.info.model.HistoryModel r9) {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            if (r9 != 0) goto L_0x0009
            goto L_0x016f
        L_0x0009:
            android.view.View r8 = r8.itemView
            com.didi.entrega.info.binder.-$$Lambda$HistoryItemBinder$ho1ZjhId607ErxqaVQWz2IJpw40 r0 = new com.didi.entrega.info.binder.-$$Lambda$HistoryItemBinder$ho1ZjhId607ErxqaVQWz2IJpw40
            r0.<init>(r9)
            r8.setOnClickListener(r0)
            r0 = 2131430455(0x7f0b0c37, float:1.8482611E38)
            android.view.View r0 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r0
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r1 = r9.getHistoryEntity()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0028
        L_0x0024:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x003b
        L_0x0028:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getAddress()
            if (r1 != 0) goto L_0x002f
            goto L_0x0024
        L_0x002f:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r1.poi
            if (r1 != 0) goto L_0x0034
            goto L_0x0024
        L_0x0034:
            java.lang.String r1 = r1.displayName
            if (r1 != 0) goto L_0x0039
            goto L_0x0024
        L_0x0039:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x003b:
            r0.setText(r1)
            int r0 = r7.getBinderFusionChannel()
            r1 = 2
            r3 = 1
            r4 = 8
            r5 = 2131430456(0x7f0b0c38, float:1.8482613E38)
            r6 = 0
            if (r0 != r1) goto L_0x009d
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r0 = r9.getHistoryEntity()
            r1 = 0
            if (r0 != 0) goto L_0x0055
        L_0x0053:
            r0 = r1
            goto L_0x005e
        L_0x0055:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r0 = r0.getAddress()
            if (r0 != 0) goto L_0x005c
            goto L_0x0053
        L_0x005c:
            java.lang.String r0 = r0.houseNumber
        L_0x005e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x006b
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r0 = 0
            goto L_0x006c
        L_0x006b:
            r0 = 1
        L_0x006c:
            if (r0 == 0) goto L_0x0078
            android.view.View r0 = r8.findViewById(r5)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r0
            r0.setVisibility(r4)
            goto L_0x00a6
        L_0x0078:
            android.view.View r0 = r8.findViewById(r5)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r0
            r0.setVisibility(r6)
            android.view.View r0 = r8.findViewById(r5)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r0
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r4 = r9.getHistoryEntity()
            if (r4 != 0) goto L_0x008e
            goto L_0x0097
        L_0x008e:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r4 = r4.getAddress()
            if (r4 != 0) goto L_0x0095
            goto L_0x0097
        L_0x0095:
            java.lang.String r1 = r4.houseNumber
        L_0x0097:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x00a6
        L_0x009d:
            android.view.View r0 = r8.findViewById(r5)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r0
            r0.setVisibility(r4)
        L_0x00a6:
            r0 = 2131430457(0x7f0b0c39, float:1.8482616E38)
            android.view.View r0 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r4 = r9.getHistoryEntity()
            if (r4 != 0) goto L_0x00bc
        L_0x00ba:
            r4 = r2
            goto L_0x00c8
        L_0x00bc:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r4 = r4.getAddress()
            if (r4 != 0) goto L_0x00c3
            goto L_0x00ba
        L_0x00c3:
            java.lang.String r4 = r4.firstName
            if (r4 != 0) goto L_0x00c8
            goto L_0x00ba
        L_0x00c8:
            r1.append(r4)
            r4 = 32
            r1.append(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r4 = r9.getHistoryEntity()
            if (r4 != 0) goto L_0x00d8
        L_0x00d6:
            r4 = r2
            goto L_0x00e4
        L_0x00d8:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r4 = r4.getAddress()
            if (r4 != 0) goto L_0x00df
            goto L_0x00d6
        L_0x00df:
            java.lang.String r4 = r4.lastName
            if (r4 != 0) goto L_0x00e4
            goto L_0x00d6
        L_0x00e4:
            r1.append(r4)
            java.lang.String r4 = "  "
            r1.append(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r4 = r9.getHistoryEntity()
            if (r4 != 0) goto L_0x00f4
        L_0x00f2:
            r4 = r2
            goto L_0x0100
        L_0x00f4:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r4 = r4.getAddress()
            if (r4 != 0) goto L_0x00fb
            goto L_0x00f2
        L_0x00fb:
            java.lang.String r4 = r4.callingCode
            if (r4 != 0) goto L_0x0100
            goto L_0x00f2
        L_0x0100:
            r1.append(r4)
            r4 = 45
            r1.append(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r4 = r9.getHistoryEntity()
            if (r4 != 0) goto L_0x010f
            goto L_0x011c
        L_0x010f:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r4 = r4.getAddress()
            if (r4 != 0) goto L_0x0116
            goto L_0x011c
        L_0x0116:
            java.lang.String r4 = r4.phone
            if (r4 != 0) goto L_0x011b
            goto L_0x011c
        L_0x011b:
            r2 = r4
        L_0x011c:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r0 = r9.getHistoryEntity()
            if (r0 != 0) goto L_0x0130
        L_0x012e:
            r3 = 0
            goto L_0x013d
        L_0x0130:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r0 = r0.getAddress()
            if (r0 != 0) goto L_0x0137
            goto L_0x012e
        L_0x0137:
            int r0 = r0.bizLine
            int r1 = r7.f20766c
            if (r0 != r1) goto L_0x012e
        L_0x013d:
            r0 = 2131430454(0x7f0b0c36, float:1.848261E38)
            if (r3 != 0) goto L_0x015a
            android.view.View r1 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.text.IconRichTextView r1 = (com.didi.entrega.customer.widget.text.IconRichTextView) r1
            r1.setVisibility(r6)
            android.view.View r8 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.text.IconRichTextView r8 = (com.didi.entrega.customer.widget.text.IconRichTextView) r8
            com.didi.entrega.info.binder.-$$Lambda$HistoryItemBinder$BTqsyp3ZO9SoWYJdYI-ZbkotUIc r0 = new com.didi.entrega.info.binder.-$$Lambda$HistoryItemBinder$BTqsyp3ZO9SoWYJdYI-ZbkotUIc
            r0.<init>(r9)
            r8.setOnClickListener(r0)
            goto L_0x016f
        L_0x015a:
            android.view.View r9 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.text.IconRichTextView r9 = (com.didi.entrega.customer.widget.text.IconRichTextView) r9
            r1 = 4
            r9.setVisibility(r1)
            android.view.View r8 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.text.IconRichTextView r8 = (com.didi.entrega.customer.widget.text.IconRichTextView) r8
            com.didi.entrega.info.binder.-$$Lambda$HistoryItemBinder$BW96dOr3H7azmPdG-ZAt0PNt4so r9 = com.didi.entrega.info.binder.$$Lambda$HistoryItemBinder$BW96dOr3H7azmPdGZAt0PNt4so.INSTANCE
            r8.setOnClickListener(r9)
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.binder.HistoryItemBinder.bind(com.didi.entrega.info.binder.HistoryItemBinder$ViewHolder, com.didi.entrega.info.model.HistoryModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15181a(HistoryItemBinder historyItemBinder, HistoryModel historyModel, View view) {
        Intrinsics.checkNotNullParameter(historyItemBinder, "this$0");
        Intrinsics.checkNotNullParameter(historyModel, "$model");
        HistoryClickListener historyClickListener = historyItemBinder.getHistoryClickListener();
        if (historyClickListener != null) {
            historyClickListener.onClickItem(historyModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15182b(HistoryItemBinder historyItemBinder, HistoryModel historyModel, View view) {
        Intrinsics.checkNotNullParameter(historyItemBinder, "this$0");
        Intrinsics.checkNotNullParameter(historyModel, "$model");
        HistoryClickListener historyClickListener = historyItemBinder.getHistoryClickListener();
        if (historyClickListener != null) {
            historyClickListener.onClickDelete(historyModel);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/HistoryItemBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/info/model/HistoryModel;", "itemView", "Landroid/view/View;", "(Lcom/didi/entrega/info/binder/HistoryItemBinder;Landroid/view/View;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HistoryItemBinder.kt */
    public final class ViewHolder extends ItemViewHolder<HistoryModel> {
        final /* synthetic */ HistoryItemBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(HistoryItemBinder historyItemBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(historyItemBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = historyItemBinder;
        }
    }
}
