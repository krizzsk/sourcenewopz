package com.didi.entrega.info.binder;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.entrega.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.entrega.customer.foundation.util.FontUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.info.model.StuffRuleModel;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\u001e\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006!"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufRuleBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/info/model/StuffRuleModel;", "Lcom/didi/entrega/info/binder/StufRuleBinder$ViewHolder;", "()V", "factor", "", "getFactor", "()D", "setFactor", "(D)V", "scopContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getScopContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setScopContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "getLinkText", "", "text", "", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StufRuleBinder.kt */
public final class StufRuleBinder extends ItemBinder<StuffRuleModel, ViewHolder> {

    /* renamed from: a */
    private ScopeContext f20770a;

    /* renamed from: b */
    private double f20771b = 3.23d;

    public Class<StuffRuleModel> bindDataType() {
        return StuffRuleModel.class;
    }

    public final ScopeContext getScopContext() {
        return this.f20770a;
    }

    public final void setScopContext(ScopeContext scopeContext) {
        this.f20770a = scopeContext;
    }

    public final double getFactor() {
        return this.f20771b;
    }

    public final void setFactor(double d) {
        this.f20771b = d;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.entrega_info_stuff_rule_binder, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…le_binder, parent, false)");
        return new ViewHolder(this, inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
        r1 = r1.getTitle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.didi.entrega.info.binder.StufRuleBinder.ViewHolder r8, com.didi.entrega.info.model.StuffRuleModel r9) {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.view.View r8 = r8.itemView
            r0 = 2131435390(0x7f0b1f7e, float:1.849262E38)
            android.view.View r0 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.text.RichTextView r0 = (com.didi.entrega.customer.widget.text.RichTextView) r0
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$ServiceRule r1 = r9.getStuffEntityData()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0021
        L_0x001d:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x002a
        L_0x0021:
            java.lang.String r1 = r1.getTitle()
            if (r1 != 0) goto L_0x0028
            goto L_0x001d
        L_0x0028:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x002a:
            r0.setText(r1)
            r0 = 2131434027(0x7f0b1a2b, float:1.8489856E38)
            android.view.View r8 = r8.findViewById(r0)
            r0 = 2131430483(0x7f0b0c53, float:1.8482668E38)
            android.view.View r1 = r8.findViewById(r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.content.Context r3 = r8.getContext()
            int r3 = com.didi.app.nova.support.util.DisplayUtils.getScreenWidth(r3)
            android.content.Context r4 = r8.getContext()
            r5 = 1109393408(0x42200000, float:40.0)
            int r4 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r4, r5)
            int r3 = r3 - r4
            double r3 = (double) r3
            double r5 = r7.getFactor()
            double r3 = r3 / r5
            int r3 = (int) r3
            r1.height = r3
            com.didi.app.nova.skeleton.ScopeContext r1 = r7.getScopContext()
            if (r1 != 0) goto L_0x0064
            goto L_0x0088
        L_0x0064:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$ServiceRule r3 = r9.getStuffEntityData()
            if (r3 != 0) goto L_0x006c
            r3 = 0
            goto L_0x0070
        L_0x006c:
            java.lang.String r3 = r3.getImageUrl()
        L_0x0070:
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = com.didi.entrega.customer.foundation.util.FlyImageLoader.loadImageUnspecified((com.didi.app.nova.skeleton.ScopeContext) r1, (java.lang.String) r3)
            r3 = 2131232665(0x7f080799, float:1.8081446E38)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = r1.placeholder((int) r3)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = r1.centerCrop()
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.into((android.widget.ImageView) r0)
        L_0x0088:
            r0 = 2131430512(0x7f0b0c70, float:1.8482727E38)
            android.view.View r0 = r8.findViewById(r0)
            com.didi.entrega.customer.widget.text.RichTextView r0 = (com.didi.entrega.customer.widget.text.RichTextView) r0
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$ServiceRule r1 = r9.getStuffEntityData()
            if (r1 != 0) goto L_0x009b
        L_0x0097:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x00a4
        L_0x009b:
            java.lang.String r1 = r1.getContent()
            if (r1 != 0) goto L_0x00a2
            goto L_0x0097
        L_0x00a2:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x00a4:
            r0.setText(r1)
            r0 = 2131430513(0x7f0b0c71, float:1.848273E38)
            android.view.View r1 = r8.findViewById(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$ServiceRule r3 = r9.getStuffEntityData()
            if (r3 != 0) goto L_0x00b7
            goto L_0x00bf
        L_0x00b7:
            java.lang.String r3 = r3.getLinkContent()
            if (r3 != 0) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r2 = r3
        L_0x00bf:
            java.lang.CharSequence r2 = r7.m15185a(r2)
            r1.setText(r2)
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            com.didi.entrega.info.binder.-$$Lambda$StufRuleBinder$VssBQaMdryXPnUs7JInuAtR4bY8 r0 = new com.didi.entrega.info.binder.-$$Lambda$StufRuleBinder$VssBQaMdryXPnUs7JInuAtR4bY8
            r0.<init>()
            r8.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.binder.StufRuleBinder.bind(com.didi.entrega.info.binder.StufRuleBinder$ViewHolder, com.didi.entrega.info.model.StuffRuleModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15186a(StuffRuleModel stuffRuleModel, View view) {
        Intrinsics.checkNotNullParameter(stuffRuleModel, "$item");
        Request.Builder path = DiRouter.request().path("webPage");
        CommonInfoEntity.ServiceRule stuffEntityData = stuffRuleModel.getStuffEntityData();
        path.putString("url", stuffEntityData == null ? null : stuffEntityData.getTextUrl()).open();
    }

    /* renamed from: a */
    private final CharSequence m15185a(String str) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = ResourceHelper.getString(R.string.customer_common_icon_arrow);
        SpannableString spannableString = new SpannableString(charSequence);
        SpannableString spannableString2 = new SpannableString(string);
        spannableString2.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, string.length(), 33);
        spannableString2.setSpan(new CustomerVerticalCenterSpan(14), 0, string.length(), 33);
        spannableStringBuilder.append(spannableString).append(" ").append(spannableString2);
        return spannableStringBuilder;
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufRuleBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/info/model/StuffRuleModel;", "rootView", "Landroid/view/View;", "(Lcom/didi/entrega/info/binder/StufRuleBinder;Landroid/view/View;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StufRuleBinder.kt */
    public final class ViewHolder extends ItemViewHolder<StuffRuleModel> {
        final /* synthetic */ StufRuleBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(StufRuleBinder stufRuleBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(stufRuleBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.this$0 = stufRuleBinder;
        }
    }
}
