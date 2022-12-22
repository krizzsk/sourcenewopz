package com.didi.entrega.bill.model;

import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 B2\u00020\u0001:\u0001BB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001c\u0010&\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR7\u0010)\u001a\u001f\u0012\u0013\u0012\u00110+¢\u0006\f\b,\u0012\b\b&\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001a\u00109\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001a\u0010<\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001b\"\u0004\b>\u0010\u001dR\u001c\u0010?\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\b¨\u0006C"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/ComponentModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "currency", "getCurrency", "setCurrency", "data", "Lcom/didi/entrega/bill/model/ComponentDataModel;", "getData", "()Lcom/didi/entrega/bill/model/ComponentDataModel;", "setData", "(Lcom/didi/entrega/bill/model/ComponentDataModel;)V", "defaultContent", "getDefaultContent", "setDefaultContent", "defaultContentHighlight", "", "getDefaultContentHighlight", "()I", "setDefaultContentHighlight", "(I)V", "hint", "getHint", "setHint", "isCanRedirect", "setCanRedirect", "leftHint", "getLeftHint", "setLeftHint", "name", "getName", "setName", "onCardClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "view", "", "getOnCardClick", "()Lkotlin/jvm/functions/Function1;", "setOnCardClick", "(Lkotlin/jvm/functions/Function1;)V", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "sectionIndex", "getSectionIndex", "setSectionIndex", "tipFeeBasePrice", "getTipFeeBasePrice", "setTipFeeBasePrice", "type", "getType", "setType", "underContentDesc", "getUnderContentDesc", "setUnderContentDesc", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentModel.kt */
public final class ComponentModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f19538a;

    /* renamed from: b */
    private int f19539b;

    /* renamed from: c */
    private String f19540c;

    /* renamed from: d */
    private String f19541d;

    /* renamed from: e */
    private String f19542e;

    /* renamed from: f */
    private String f19543f;

    /* renamed from: g */
    private String f19544g;

    /* renamed from: h */
    private int f19545h;

    /* renamed from: i */
    private int f19546i;

    /* renamed from: j */
    private String f19547j;

    /* renamed from: k */
    private ComponentDataModel f19548k;

    /* renamed from: l */
    private int f19549l;

    /* renamed from: m */
    private int f19550m;

    /* renamed from: n */
    private String f19551n;

    /* renamed from: o */
    private Function1<? super View, Unit> f19552o;

    /* renamed from: p */
    private String f19553p;

    public final String getCartId() {
        return this.f19538a;
    }

    public final void setCartId(String str) {
        this.f19538a = str;
    }

    public final int getType() {
        return this.f19539b;
    }

    public final void setType(int i) {
        this.f19539b = i;
    }

    public final String getName() {
        return this.f19540c;
    }

    public final void setName(String str) {
        this.f19540c = str;
    }

    public final String getContent() {
        return this.f19541d;
    }

    public final void setContent(String str) {
        this.f19541d = str;
    }

    public final String getHint() {
        return this.f19542e;
    }

    public final void setHint(String str) {
        this.f19542e = str;
    }

    public final String getLeftHint() {
        return this.f19543f;
    }

    public final void setLeftHint(String str) {
        this.f19543f = str;
    }

    public final String getDefaultContent() {
        return this.f19544g;
    }

    public final void setDefaultContent(String str) {
        this.f19544g = str;
    }

    public final int getDefaultContentHighlight() {
        return this.f19545h;
    }

    public final void setDefaultContentHighlight(int i) {
        this.f19545h = i;
    }

    public final int isCanRedirect() {
        return this.f19546i;
    }

    public final void setCanRedirect(int i) {
        this.f19546i = i;
    }

    public final String getRedirectUrl() {
        return this.f19547j;
    }

    public final void setRedirectUrl(String str) {
        this.f19547j = str;
    }

    public final ComponentDataModel getData() {
        return this.f19548k;
    }

    public final void setData(ComponentDataModel componentDataModel) {
        this.f19548k = componentDataModel;
    }

    public final int getSectionIndex() {
        return this.f19549l;
    }

    public final void setSectionIndex(int i) {
        this.f19549l = i;
    }

    public final int getTipFeeBasePrice() {
        return this.f19550m;
    }

    public final void setTipFeeBasePrice(int i) {
        this.f19550m = i;
    }

    public final String getCurrency() {
        return this.f19551n;
    }

    public final void setCurrency(String str) {
        this.f19551n = str;
    }

    public final Function1<View, Unit> getOnCardClick() {
        return this.f19552o;
    }

    public final void setOnCardClick(Function1<? super View, Unit> function1) {
        this.f19552o = function1;
    }

    public final String getUnderContentDesc() {
        return this.f19553p;
    }

    public final void setUnderContentDesc(String str) {
        this.f19553p = str;
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/ComponentModel$Companion;", "", "()V", "convert", "Lcom/didi/entrega/bill/model/ComponentModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "componentEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillComponentEntity;", "index", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComponentModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0075, code lost:
            r4 = r4.getPriceInfoModel();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.didi.entrega.bill.model.ComponentModel convert(com.didi.app.nova.skeleton.ScopeContext r4, com.didi.entrega.customer.foundation.rpc.entity.BillEntity r5, com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity r6, int r7) {
            /*
                r3 = this;
                java.lang.String r0 = "entity"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "componentEntity"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                com.didi.entrega.bill.model.ComponentModel r0 = new com.didi.entrega.bill.model.ComponentModel
                r0.<init>()
                java.lang.String r1 = r5.getCartId()
                r0.setCartId(r1)
                int r1 = r6.getType()
                r0.setType(r1)
                java.lang.String r1 = r6.getName()
                r0.setName(r1)
                java.lang.String r1 = r6.getHint()
                r0.setHint(r1)
                java.lang.String r1 = r6.getLeftHint()
                r0.setLeftHint(r1)
                java.lang.String r1 = r6.getDefaultContent()
                r0.setDefaultContent(r1)
                int r1 = r6.getDefaultContentHighlight()
                r0.setDefaultContentHighlight(r1)
                int r1 = r6.isCanRedirect()
                r0.setCanRedirect(r1)
                java.lang.String r1 = r6.getRedirectUrl()
                r0.setRedirectUrl(r1)
                com.didi.entrega.bill.model.ComponentDataModel$Companion r1 = com.didi.entrega.bill.model.ComponentDataModel.Companion
                com.didi.entrega.customer.foundation.rpc.entity.BillExtraData r2 = r6.getData()
                com.didi.entrega.bill.model.ComponentDataModel r4 = r1.convert(r4, r2)
                r0.setData(r4)
                r0.setSectionIndex(r7)
                int r4 = r5.getTipFeeBasePrice()
                r0.setTipFeeBasePrice(r4)
                java.lang.String r4 = r5.getCurrency()
                r0.setCurrency(r4)
                com.didi.entrega.bill.model.ComponentDataModel r4 = r0.getData()
                r5 = 0
                if (r4 != 0) goto L_0x0075
            L_0x0073:
                r4 = r5
                goto L_0x0080
            L_0x0075:
                com.didi.entrega.bill.model.PriceInfoModel r4 = r4.getPriceInfoModel()
                if (r4 != 0) goto L_0x007c
                goto L_0x0073
            L_0x007c:
                java.lang.String r4 = r4.getPayPriceDisplay()
            L_0x0080:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r7 = 0
                r1 = 1
                if (r4 == 0) goto L_0x008f
                int r4 = r4.length()
                if (r4 != 0) goto L_0x008d
                goto L_0x008f
            L_0x008d:
                r4 = 0
                goto L_0x0090
            L_0x008f:
                r4 = 1
            L_0x0090:
                if (r4 != 0) goto L_0x00be
                com.didi.entrega.bill.model.ComponentDataModel r4 = r0.getData()
                if (r4 != 0) goto L_0x009a
            L_0x0098:
                r4 = r5
                goto L_0x00a5
            L_0x009a:
                com.didi.entrega.bill.model.PriceInfoModel r4 = r4.getPriceInfoModel()
                if (r4 != 0) goto L_0x00a1
                goto L_0x0098
            L_0x00a1:
                java.lang.String r4 = r4.getPayPriceDisplay()
            L_0x00a5:
                r0.setContent(r4)
                com.didi.entrega.bill.model.ComponentDataModel r4 = r0.getData()
                if (r4 != 0) goto L_0x00af
                goto L_0x00ba
            L_0x00af:
                com.didi.entrega.bill.model.PriceInfoModel r4 = r4.getPriceInfoModel()
                if (r4 != 0) goto L_0x00b6
                goto L_0x00ba
            L_0x00b6:
                java.lang.String r5 = r4.getUnderContentText()
            L_0x00ba:
                r0.setUnderContentDesc(r5)
                goto L_0x00f5
            L_0x00be:
                java.lang.String r4 = r6.getContent()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x00cf
                int r4 = r4.length()
                if (r4 != 0) goto L_0x00cd
                goto L_0x00cf
            L_0x00cd:
                r4 = 0
                goto L_0x00d0
            L_0x00cf:
                r4 = 1
            L_0x00d0:
                if (r4 != 0) goto L_0x00da
                java.lang.String r4 = r6.getContent()
                r0.setContent(r4)
                goto L_0x00f5
            L_0x00da:
                java.lang.String r4 = r0.getDefaultContent()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x00eb
                int r4 = r4.length()
                if (r4 != 0) goto L_0x00e9
                goto L_0x00eb
            L_0x00e9:
                r4 = 0
                goto L_0x00ec
            L_0x00eb:
                r4 = 1
            L_0x00ec:
                if (r4 != 0) goto L_0x00f5
                java.lang.String r4 = r0.getDefaultContent()
                r0.setUnderContentDesc(r4)
            L_0x00f5:
                java.lang.String r4 = r0.getHint()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x0103
                int r4 = r4.length()
                if (r4 != 0) goto L_0x0104
            L_0x0103:
                r7 = 1
            L_0x0104:
                if (r7 != 0) goto L_0x010d
                java.lang.String r4 = r0.getHint()
                r0.setUnderContentDesc(r4)
            L_0x010d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.bill.model.ComponentModel.Companion.convert(com.didi.app.nova.skeleton.ScopeContext, com.didi.entrega.customer.foundation.rpc.entity.BillEntity, com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity, int):com.didi.entrega.bill.model.ComponentModel");
        }
    }
}
