package com.didi.soda.bill.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b/\u0018\u0000 _2\u00020\u0001:\u0001_B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001a\u00107\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u001a\u00109\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R\u001c\u0010;\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R\u001c\u0010>\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0017R\u001c\u0010A\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017R\u001c\u0010D\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0015\"\u0004\bF\u0010\u0017R\u001a\u0010G\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR\u001c\u0010J\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010\u0017R\u001e\u0010M\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010S\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\bR\u001a\u0010V\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0006\"\u0004\bX\u0010\bR\u001a\u0010Y\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0006\"\u0004\b[\u0010\bR\u001a\u0010\\\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0006\"\u0004\b^\u0010\b¨\u0006`"}, mo175978d2 = {"Lcom/didi/soda/bill/model/ComponentModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "addressRecStrategy", "", "getAddressRecStrategy", "()I", "setAddressRecStrategy", "(I)V", "afterFavPrice", "getAfterFavPrice", "setAfterFavPrice", "bottomExtraPadding", "getBottomExtraPadding", "setBottomExtraPadding", "cardBgType", "getCardBgType", "setCardBgType", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "currency", "getCurrency", "setCurrency", "data", "Lcom/didi/soda/bill/model/ComponentDataModel;", "getData", "()Lcom/didi/soda/bill/model/ComponentDataModel;", "setData", "(Lcom/didi/soda/bill/model/ComponentDataModel;)V", "defaultContent", "getDefaultContent", "setDefaultContent", "defaultContentHighlight", "getDefaultContentHighlight", "setDefaultContentHighlight", "hint", "getHint", "setHint", "hintType", "getHintType", "setHintType", "isBusinessOpen", "", "()Z", "setBusinessOpen", "(Z)V", "isCanRedirect", "setCanRedirect", "isCheckNameEmpty", "setCheckNameEmpty", "isUseAddressRec", "setUseAddressRec", "leftHint", "getLeftHint", "setLeftHint", "leftIcon", "getLeftIcon", "setLeftIcon", "name", "getName", "setName", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "sectionIndex", "getSectionIndex", "setSectionIndex", "shopId", "getShopId", "setShopId", "shopStatus", "getShopStatus", "()Ljava/lang/Integer;", "setShopStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "source", "getSource", "setSource", "sourcePage", "getSourcePage", "setSourcePage", "topExtraPadding", "getTopExtraPadding", "setTopExtraPadding", "type", "getType", "setType", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentModel.kt */
public final class ComponentModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGE_BILL = 2;
    public static final int PAGE_GLOBAL_CART = 1;

    /* renamed from: A */
    private int f39042A = 3;

    /* renamed from: a */
    private int f39043a = -1;

    /* renamed from: b */
    private String f39044b;

    /* renamed from: c */
    private Integer f39045c;

    /* renamed from: d */
    private String f39046d;

    /* renamed from: e */
    private int f39047e;

    /* renamed from: f */
    private String f39048f;

    /* renamed from: g */
    private String f39049g;

    /* renamed from: h */
    private String f39050h;

    /* renamed from: i */
    private String f39051i;

    /* renamed from: j */
    private String f39052j;

    /* renamed from: k */
    private int f39053k;

    /* renamed from: l */
    private int f39054l;

    /* renamed from: m */
    private String f39055m;

    /* renamed from: n */
    private ComponentDataModel f39056n;

    /* renamed from: o */
    private int f39057o;

    /* renamed from: p */
    private String f39058p;

    /* renamed from: q */
    private int f39059q;

    /* renamed from: r */
    private boolean f39060r;

    /* renamed from: s */
    private int f39061s;

    /* renamed from: t */
    private int f39062t;

    /* renamed from: u */
    private boolean f39063u;

    /* renamed from: v */
    private boolean f39064v;

    /* renamed from: w */
    private int f39065w;

    /* renamed from: x */
    private String f39066x;

    /* renamed from: y */
    private int f39067y;

    /* renamed from: z */
    private int f39068z;

    public final int getSectionIndex() {
        return this.f39043a;
    }

    public final void setSectionIndex(int i) {
        this.f39043a = i;
    }

    public final String getShopId() {
        return this.f39044b;
    }

    public final void setShopId(String str) {
        this.f39044b = str;
    }

    public final Integer getShopStatus() {
        return this.f39045c;
    }

    public final void setShopStatus(Integer num) {
        this.f39045c = num;
    }

    public final String getCartId() {
        return this.f39046d;
    }

    public final void setCartId(String str) {
        this.f39046d = str;
    }

    public final int getType() {
        return this.f39047e;
    }

    public final void setType(int i) {
        this.f39047e = i;
    }

    public final String getName() {
        return this.f39048f;
    }

    public final void setName(String str) {
        this.f39048f = str;
    }

    public final String getContent() {
        return this.f39049g;
    }

    public final void setContent(String str) {
        this.f39049g = str;
    }

    public final String getHint() {
        return this.f39050h;
    }

    public final void setHint(String str) {
        this.f39050h = str;
    }

    public final String getLeftHint() {
        return this.f39051i;
    }

    public final void setLeftHint(String str) {
        this.f39051i = str;
    }

    public final String getDefaultContent() {
        return this.f39052j;
    }

    public final void setDefaultContent(String str) {
        this.f39052j = str;
    }

    public final int getDefaultContentHighlight() {
        return this.f39053k;
    }

    public final void setDefaultContentHighlight(int i) {
        this.f39053k = i;
    }

    public final int isCanRedirect() {
        return this.f39054l;
    }

    public final void setCanRedirect(int i) {
        this.f39054l = i;
    }

    public final String getRedirectUrl() {
        return this.f39055m;
    }

    public final void setRedirectUrl(String str) {
        this.f39055m = str;
    }

    public final ComponentDataModel getData() {
        return this.f39056n;
    }

    public final void setData(ComponentDataModel componentDataModel) {
        this.f39056n = componentDataModel;
    }

    public final int getAfterFavPrice() {
        return this.f39057o;
    }

    public final void setAfterFavPrice(int i) {
        this.f39057o = i;
    }

    public final String getCurrency() {
        return this.f39058p;
    }

    public final void setCurrency(String str) {
        this.f39058p = str;
    }

    public final int getSourcePage() {
        return this.f39059q;
    }

    public final void setSourcePage(int i) {
        this.f39059q = i;
    }

    public final boolean isBusinessOpen() {
        return this.f39060r;
    }

    public final void setBusinessOpen(boolean z) {
        this.f39060r = z;
    }

    public final int getSource() {
        return this.f39061s;
    }

    public final void setSource(int i) {
        this.f39061s = i;
    }

    public final int getAddressRecStrategy() {
        return this.f39062t;
    }

    public final void setAddressRecStrategy(int i) {
        this.f39062t = i;
    }

    public final boolean isCheckNameEmpty() {
        return this.f39063u;
    }

    public final void setCheckNameEmpty(boolean z) {
        this.f39063u = z;
    }

    public final boolean isUseAddressRec() {
        return this.f39064v;
    }

    public final void setUseAddressRec(boolean z) {
        this.f39064v = z;
    }

    public final int getHintType() {
        return this.f39065w;
    }

    public final void setHintType(int i) {
        this.f39065w = i;
    }

    public final String getLeftIcon() {
        return this.f39066x;
    }

    public final void setLeftIcon(String str) {
        this.f39066x = str;
    }

    public final int getTopExtraPadding() {
        return this.f39067y;
    }

    public final void setTopExtraPadding(int i) {
        this.f39067y = i;
    }

    public final int getBottomExtraPadding() {
        return this.f39068z;
    }

    public final void setBottomExtraPadding(int i) {
        this.f39068z = i;
    }

    public final int getCardBgType() {
        return this.f39042A;
    }

    public final void setCardBgType(int i) {
        this.f39042A = i;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J&\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/bill/model/ComponentModel$Companion;", "", "()V", "PAGE_BILL", "", "PAGE_GLOBAL_CART", "convert", "Lcom/didi/soda/bill/model/ComponentModel;", "component", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentEntity;", "index", "source", "convertV2", "billInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComponentModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ComponentModel convert(BillComponentEntity billComponentEntity, int i, int i2) {
            Intrinsics.checkNotNullParameter(billComponentEntity, "component");
            ComponentModel componentModel = new ComponentModel();
            componentModel.setSectionIndex(i);
            componentModel.setType(billComponentEntity.getType());
            componentModel.setName(billComponentEntity.getName());
            componentModel.setContent(billComponentEntity.getContent());
            componentModel.setDefaultContent(billComponentEntity.getDefaultContent());
            componentModel.setDefaultContentHighlight(billComponentEntity.getDefaultContentHighlight());
            componentModel.setHint(billComponentEntity.getHint());
            componentModel.setLeftHint(billComponentEntity.getLeftHint());
            componentModel.setCanRedirect(billComponentEntity.isCanRedirect());
            componentModel.setRedirectUrl(billComponentEntity.getRedirectUrl());
            componentModel.setData(BillDataFactory.Companion.getFactory().createComponentDataModel(billComponentEntity.getData()));
            componentModel.setSource(i2);
            componentModel.setHintType(billComponentEntity.getHintType());
            componentModel.setLeftIcon(billComponentEntity.getLeftIcon());
            return componentModel;
        }

        public final ComponentModel convertV2(BillComponentEntity billComponentEntity, BillInfoEntity billInfoEntity, int i, int i2) {
            Intrinsics.checkNotNullParameter(billComponentEntity, "component");
            Intrinsics.checkNotNullParameter(billInfoEntity, "billInfoEntity");
            ComponentModel componentModel = new ComponentModel();
            componentModel.setSectionIndex(i + 1);
            componentModel.setType(billComponentEntity.getType());
            componentModel.setName(billComponentEntity.getName());
            componentModel.setContent(billComponentEntity.getContent());
            componentModel.setDefaultContent(billComponentEntity.getDefaultContent());
            componentModel.setDefaultContentHighlight(billComponentEntity.getDefaultContentHighlight());
            componentModel.setHint(billComponentEntity.getHint());
            componentModel.setLeftHint(billComponentEntity.getLeftHint());
            componentModel.setCanRedirect(billComponentEntity.isCanRedirect());
            componentModel.setRedirectUrl(billComponentEntity.getRedirectUrl());
            componentModel.setData(BillDataFactoryV2.Companion.getFactory().createComponentDataModel(billComponentEntity.getData(), billInfoEntity));
            componentModel.setSource(i2);
            componentModel.setHintType(billComponentEntity.getHintType());
            componentModel.setLeftIcon(billComponentEntity.getLeftIcon());
            return componentModel;
        }
    }
}
