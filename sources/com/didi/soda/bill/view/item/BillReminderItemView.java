package com.didi.soda.bill.view.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.datamodel.ReminderModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillReminderItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "layoutId", "", "(Landroid/content/Context;I)V", "iconView", "Landroid/widget/ImageView;", "titleView", "Landroid/widget/TextView;", "needBinderBackground", "", "needExtraPadding", "setData", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "showOrHide", "isShow", "trackReminderType", "type", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillReminderItemView.kt */
public final class BillReminderItemView extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private TextView f39235a;

    /* renamed from: b */
    private ImageView f39236b;

    public void _$_clearFindViewByIdCache() {
    }

    public boolean needBinderBackground() {
        return false;
    }

    public boolean needExtraPadding() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillReminderItemView(Context context, int i) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, i, this);
        View findViewById = findViewById(R.id.customer_tv_tip_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_tip_content)");
        this.f39235a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_tip_icon)");
        this.f39236b = (ImageView) findViewById2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.didi.soda.bill.model.ComponentDataModel r5 = r5.getData()
            r0 = 0
            if (r5 != 0) goto L_0x000e
            r5 = r0
            goto L_0x0012
        L_0x000e:
            com.didi.soda.bill.model.datamodel.ReminderModel r5 = r5.getReminderModel()
        L_0x0012:
            r1 = 0
            if (r5 != 0) goto L_0x0016
            goto L_0x007c
        L_0x0016:
            int r2 = r5.getContentType()
            r4.m27787a((int) r2)
            java.lang.String r2 = r5.getContent()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            if (r2 == 0) goto L_0x002f
            int r2 = r2.length()
            if (r2 != 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r2 = 0
            goto L_0x0030
        L_0x002f:
            r2 = 1
        L_0x0030:
            if (r2 != 0) goto L_0x0077
            r4.m27789a((boolean) r3)
            android.widget.TextView r2 = r4.f39235a
            if (r2 != 0) goto L_0x0040
            java.lang.String r2 = "titleView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r2 = r0
        L_0x0040:
            java.lang.String r3 = r5.getContent()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.content.Context r2 = r4.getContext()
            java.lang.String r3 = r5.getIcon()
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r2 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImage1x1((android.content.Context) r2, (java.lang.String) r3)
            r3 = 2131231685(0x7f0803c5, float:1.8079458E38)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r2 = r2.placeholder((int) r3)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r2 = r2.error((int) r3)
            android.widget.ImageView r3 = r4.f39236b
            if (r3 != 0) goto L_0x006a
            java.lang.String r3 = "iconView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x006b
        L_0x006a:
            r0 = r3
        L_0x006b:
            r2.into((android.widget.ImageView) r0)
            com.didi.soda.bill.view.item.-$$Lambda$BillReminderItemView$nyCAf2v527EEzHQzMkOjfSOhjkA r0 = new com.didi.soda.bill.view.item.-$$Lambda$BillReminderItemView$nyCAf2v527EEzHQzMkOjfSOhjkA
            r0.<init>()
            r4.setOnClickListener(r0)
            goto L_0x007a
        L_0x0077:
            r4.m27789a((boolean) r1)
        L_0x007a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x007c:
            if (r0 != 0) goto L_0x0081
            r4.m27789a((boolean) r1)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillReminderItemView.setData(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27788a(ReminderModel reminderModel, View view) {
        CharSequence url = reminderModel.getUrl();
        if (!(url == null || url.length() == 0)) {
            DiRouter.request().path("webPage").putString("url", reminderModel.getUrl()).open();
        }
    }

    /* renamed from: a */
    private final void m27789a(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    private final void m27787a(int i) {
        BillOmegaHelper.Companion.trackReminderShow(i);
    }
}
