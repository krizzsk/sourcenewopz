package com.didi.component.payentrance.model;

import com.didi.travel.psnger.model.response.CarOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001a\u0010-\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000f\"\u0004\b:\u0010\u0011R\u001a\u0010;\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R\u001a\u0010>\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011R\u001a\u0010A\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R\u001a\u0010D\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000f\"\u0004\bF\u0010\u0011R\u001a\u0010G\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R\u001a\u0010J\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000f\"\u0004\bL\u0010\u0011R\u001a\u0010M\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010'\"\u0004\bO\u0010)¨\u0006Q"}, mo175978d2 = {"Lcom/didi/component/payentrance/model/FareInfoItem;", "", "()V", "<set-?>", "Lcom/didi/travel/psnger/model/response/CarOrder;", "carOrder", "getCarOrder", "()Lcom/didi/travel/psnger/model/response/CarOrder;", "setCarOrder", "(Lcom/didi/travel/psnger/model/response/CarOrder;)V", "carOrder$delegate", "Lkotlin/properties/ReadWriteProperty;", "carPoolSubTitle", "", "getCarPoolSubTitle", "()Ljava/lang/String;", "setCarPoolSubTitle", "(Ljava/lang/String;)V", "carPoolTitle", "getCarPoolTitle", "setCarPoolTitle", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "feeCardSuffix", "getFeeCardSuffix", "setFeeCardSuffix", "feeIcon", "getFeeIcon", "setFeeIcon", "feeLabel", "getFeeLabel", "setFeeLabel", "feeType", "", "getFeeType", "()I", "setFeeType", "(I)V", "feeValue", "getFeeValue", "setFeeValue", "feeValueRGB", "getFeeValueRGB", "setFeeValueRGB", "footerMsg", "getFooterMsg", "setFooterMsg", "isHighlight", "", "()Z", "setHighlight", "(Z)V", "pickupFee", "getPickupFee", "setPickupFee", "priceMsg", "getPriceMsg", "setPriceMsg", "showCouponTip", "getShowCouponTip", "setShowCouponTip", "showPoi", "getShowPoi", "setShowPoi", "showTips", "getShowTips", "setShowTips", "symbol", "getSymbol", "setSymbol", "title", "getTitle", "setTitle", "type", "getType", "setType", "ItemType", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FeeInfoItem.kt */
public final class FareInfoItem {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f14879a = {C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(FareInfoItem.class, "carOrder", "getCarOrder()Lcom/didi/travel/psnger/model/response/CarOrder;", 0))};

    /* renamed from: b */
    private int f14880b;

    /* renamed from: c */
    private String f14881c = "";

    /* renamed from: d */
    private int f14882d = -1;

    /* renamed from: e */
    private String f14883e = "";

    /* renamed from: f */
    private String f14884f = "";

    /* renamed from: g */
    private int f14885g;

    /* renamed from: h */
    private String f14886h = "";

    /* renamed from: i */
    private String f14887i = "";

    /* renamed from: j */
    private String f14888j = "";

    /* renamed from: k */
    private List<FareInfoItem> f14889k = new ArrayList();

    /* renamed from: l */
    private String f14890l = "";

    /* renamed from: m */
    private boolean f14891m;

    /* renamed from: n */
    private String f14892n = "";

    /* renamed from: o */
    private String f14893o = "";

    /* renamed from: p */
    private String f14894p = "";

    /* renamed from: q */
    private String f14895q = "";

    /* renamed from: r */
    private String f14896r = "";

    /* renamed from: s */
    private String f14897s = "";

    /* renamed from: t */
    private String f14898t = "";

    /* renamed from: u */
    private final ReadWriteProperty f14899u = Delegates.INSTANCE.notNull();

    public final int getType() {
        return this.f14880b;
    }

    public final void setType(int i) {
        this.f14880b = i;
    }

    public final String getSymbol() {
        return this.f14881c;
    }

    public final void setSymbol(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14881c = str;
    }

    public final int getShowPoi() {
        return this.f14882d;
    }

    public final void setShowPoi(int i) {
        this.f14882d = i;
    }

    public final String getFeeLabel() {
        return this.f14883e;
    }

    public final void setFeeLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14883e = str;
    }

    public final String getFeeValue() {
        return this.f14884f;
    }

    public final void setFeeValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14884f = str;
    }

    public final int getFeeType() {
        return this.f14885g;
    }

    public final void setFeeType(int i) {
        this.f14885g = i;
    }

    public final String getFeeIcon() {
        return this.f14886h;
    }

    public final void setFeeIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14886h = str;
    }

    public final String getFeeCardSuffix() {
        return this.f14887i;
    }

    public final void setFeeCardSuffix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14887i = str;
    }

    public final String getFeeValueRGB() {
        return this.f14888j;
    }

    public final void setFeeValueRGB(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14888j = str;
    }

    public final List<FareInfoItem> getChildren() {
        return this.f14889k;
    }

    public final void setChildren(List<FareInfoItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f14889k = list;
    }

    public final String getPriceMsg() {
        return this.f14890l;
    }

    public final void setPriceMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14890l = str;
    }

    public final boolean isHighlight() {
        return this.f14891m;
    }

    public final void setHighlight(boolean z) {
        this.f14891m = z;
    }

    public final String getPickupFee() {
        return this.f14892n;
    }

    public final void setPickupFee(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14892n = str;
    }

    public final String getShowTips() {
        return this.f14893o;
    }

    public final void setShowTips(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14893o = str;
    }

    public final String getShowCouponTip() {
        return this.f14894p;
    }

    public final void setShowCouponTip(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14894p = str;
    }

    public final String getFooterMsg() {
        return this.f14895q;
    }

    public final void setFooterMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14895q = str;
    }

    public final String getCarPoolTitle() {
        return this.f14896r;
    }

    public final void setCarPoolTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14896r = str;
    }

    public final String getCarPoolSubTitle() {
        return this.f14897s;
    }

    public final void setCarPoolSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14897s = str;
    }

    public final String getTitle() {
        return this.f14898t;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f14898t = str;
    }

    public final CarOrder getCarOrder() {
        return (CarOrder) this.f14899u.getValue(this, f14879a[0]);
    }

    public final void setCarOrder(CarOrder carOrder) {
        Intrinsics.checkNotNullParameter(carOrder, "<set-?>");
        this.f14899u.setValue(this, f14879a[0], carOrder);
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/component/payentrance/model/FareInfoItem$ItemType;", "", "()V", "Companion", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FeeInfoItem.kt */
    public static final class ItemType {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int TYPE_BASIC_FEE = 3;
        public static final int TYPE_BASIC_FEE_BUTTON = 6;
        public static final int TYPE_BASIC_FEE_CHILD = 4;
        public static final int TYPE_CAR_POOL = 9;
        public static final int TYPE_DECORATION = 2;
        public static final int TYPE_DECORATION_FAQ = 7;
        public static final int TYPE_FOOTER_MSG = 8;
        public static final int TYPE_PAYMENT = 11;
        public static final int TYPE_PRICE_MSG = 1;
        public static final int TYPE_RULES = 12;
        public static final int TYPE_TITLE = 10;
        public static final int TYPE_TITLE_FEE = 0;

        @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/component/payentrance/model/FareInfoItem$ItemType$Companion;", "", "()V", "TYPE_BASIC_FEE", "", "TYPE_BASIC_FEE_BUTTON", "TYPE_BASIC_FEE_CHILD", "TYPE_CAR_POOL", "TYPE_DECORATION", "TYPE_DECORATION_FAQ", "TYPE_FOOTER_MSG", "TYPE_PAYMENT", "TYPE_PRICE_MSG", "TYPE_RULES", "TYPE_TITLE", "TYPE_TITLE_FEE", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: FeeInfoItem.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
