package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001dH\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/PayItem;", "Lcom/didi/global/fintech/cashier/ui/viewholder/BaseItemView;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "drag", "Landroid/widget/ImageView;", "getDrag", "()Landroid/widget/ImageView;", "setDrag", "(Landroid/widget/ImageView;)V", "icon", "getIcon", "setIcon", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "type", "Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "getType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "bind", "", "data", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "addCardClick", "Lkotlin/Function0;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.PayItem */
/* compiled from: FastPayOrderContentViewHolder.kt */
public final class PayItem extends BaseItemView {

    /* renamed from: a */
    private TextView f21821a;

    /* renamed from: b */
    private ImageView f21822b;

    /* renamed from: c */
    private ImageView f21823c;

    /* renamed from: d */
    private final ItemViewFactory.Type f21824d = ItemViewFactory.Type.Pay;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PayItem(android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2131626453(0x7f0e09d5, float:1.8880143E38)
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …_pay_item, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            android.view.View r4 = r3.itemView
            r0 = 2131435145(0x7f0b1e89, float:1.8492124E38)
            android.view.View r4 = r4.findViewById(r0)
            java.lang.String r0 = "itemView.findViewById(R.id.tv_item_content)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.f21821a = r4
            android.view.View r4 = r3.itemView
            r0 = 2131431887(0x7f0b11cf, float:1.8485516E38)
            android.view.View r4 = r4.findViewById(r0)
            java.lang.String r0 = "itemView.findViewById(R.id.iv_pay_card)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.f21822b = r4
            android.view.View r4 = r3.itemView
            r0 = 2131431804(0x7f0b117c, float:1.8485348E38)
            android.view.View r4 = r4.findViewById(r0)
            java.lang.String r0 = "itemView.findViewById(R.id.iv_drag)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.f21823c = r4
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r4 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.Pay
            r3.f21824d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.PayItem.<init>(android.view.ViewGroup):void");
    }

    public final TextView getTitle() {
        return this.f21821a;
    }

    public final void setTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f21821a = textView;
    }

    public final ImageView getIcon() {
        return this.f21822b;
    }

    public final void setIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.f21822b = imageView;
    }

    public final ImageView getDrag() {
        return this.f21823c;
    }

    public final void setDrag(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.f21823c = imageView;
    }

    /* access modifiers changed from: protected */
    public ItemViewFactory.Type getType() {
        return this.f21824d;
    }

    public void bind(FastPayOrderItem fastPayOrderItem, Function0<Unit> function0) {
        super.bind(fastPayOrderItem, function0);
        String str = null;
        ViewKtxKt.load(this.f21822b, fastPayOrderItem == null ? null : fastPayOrderItem.getIcon());
        this.f21823c.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PayItem.m15833a(PayItem.this, view, motionEvent);
            }
        });
        TextView textView = this.f21821a;
        if (fastPayOrderItem != null) {
            str = fastPayOrderItem.getContent();
        }
        ViewKtxKt.content(textView, str);
        float f = 1.0f;
        this.f21821a.setAlpha(getAvailable() ? 1.0f : 0.5f);
        ImageView imageView = this.f21822b;
        if (!getAvailable()) {
            f = 0.5f;
        }
        imageView.setAlpha(f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m15833a(PayItem payItem, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(payItem, "this$0");
        int action = motionEvent.getAction();
        if (action != 0 && action != 5) {
            return false;
        }
        payItem.setDragable(true);
        return false;
    }
}
