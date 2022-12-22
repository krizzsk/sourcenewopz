package com.didi.soda.bill.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.bill.model.datamodel.AddressModel;
import com.didi.soda.bill.model.datamodel.BillItemsInfoModel;
import com.didi.soda.bill.model.datamodel.BillLineModel;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.bill.model.datamodel.BottomTipInfoModel;
import com.didi.soda.bill.model.datamodel.CetaInfoModel;
import com.didi.soda.bill.model.datamodel.CouponInfoModel;
import com.didi.soda.bill.model.datamodel.CutleryModel;
import com.didi.soda.bill.model.datamodel.DeliveryModel;
import com.didi.soda.bill.model.datamodel.FollowModel;
import com.didi.soda.bill.model.datamodel.OutOfStockModel;
import com.didi.soda.bill.model.datamodel.PayChannelModel;
import com.didi.soda.bill.model.datamodel.PriceInfoModel;
import com.didi.soda.bill.model.datamodel.RemarkInfoModel;
import com.didi.soda.bill.model.datamodel.ReminderModel;
import com.didi.soda.bill.model.datamodel.TitleInfoModel;
import com.didi.soda.cart.model.CartTyingModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006i"}, mo175978d2 = {"Lcom/didi/soda/bill/model/ComponentDataModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "addressModel", "Lcom/didi/soda/bill/model/datamodel/AddressModel;", "getAddressModel", "()Lcom/didi/soda/bill/model/datamodel/AddressModel;", "setAddressModel", "(Lcom/didi/soda/bill/model/datamodel/AddressModel;)V", "bottomTipInfoModel", "Lcom/didi/soda/bill/model/datamodel/BottomTipInfoModel;", "getBottomTipInfoModel", "()Lcom/didi/soda/bill/model/datamodel/BottomTipInfoModel;", "setBottomTipInfoModel", "(Lcom/didi/soda/bill/model/datamodel/BottomTipInfoModel;)V", "cetaInfoModel", "Lcom/didi/soda/bill/model/datamodel/CetaInfoModel;", "getCetaInfoModel", "()Lcom/didi/soda/bill/model/datamodel/CetaInfoModel;", "setCetaInfoModel", "(Lcom/didi/soda/bill/model/datamodel/CetaInfoModel;)V", "couponInfoModel", "Lcom/didi/soda/bill/model/datamodel/CouponInfoModel;", "getCouponInfoModel", "()Lcom/didi/soda/bill/model/datamodel/CouponInfoModel;", "setCouponInfoModel", "(Lcom/didi/soda/bill/model/datamodel/CouponInfoModel;)V", "cutleryModel", "Lcom/didi/soda/bill/model/datamodel/CutleryModel;", "getCutleryModel", "()Lcom/didi/soda/bill/model/datamodel/CutleryModel;", "setCutleryModel", "(Lcom/didi/soda/bill/model/datamodel/CutleryModel;)V", "deliveryModel", "Lcom/didi/soda/bill/model/datamodel/DeliveryModel;", "getDeliveryModel", "()Lcom/didi/soda/bill/model/datamodel/DeliveryModel;", "setDeliveryModel", "(Lcom/didi/soda/bill/model/datamodel/DeliveryModel;)V", "followModel", "Lcom/didi/soda/bill/model/datamodel/FollowModel;", "getFollowModel", "()Lcom/didi/soda/bill/model/datamodel/FollowModel;", "setFollowModel", "(Lcom/didi/soda/bill/model/datamodel/FollowModel;)V", "itemsInfoModel", "Lcom/didi/soda/bill/model/datamodel/BillItemsInfoModel;", "getItemsInfoModel", "()Lcom/didi/soda/bill/model/datamodel/BillItemsInfoModel;", "setItemsInfoModel", "(Lcom/didi/soda/bill/model/datamodel/BillItemsInfoModel;)V", "lineModel", "Lcom/didi/soda/bill/model/datamodel/BillLineModel;", "getLineModel", "()Lcom/didi/soda/bill/model/datamodel/BillLineModel;", "setLineModel", "(Lcom/didi/soda/bill/model/datamodel/BillLineModel;)V", "outOfStockModel", "Lcom/didi/soda/bill/model/datamodel/OutOfStockModel;", "getOutOfStockModel", "()Lcom/didi/soda/bill/model/datamodel/OutOfStockModel;", "setOutOfStockModel", "(Lcom/didi/soda/bill/model/datamodel/OutOfStockModel;)V", "payChannelModel", "Lcom/didi/soda/bill/model/datamodel/PayChannelModel;", "getPayChannelModel", "()Lcom/didi/soda/bill/model/datamodel/PayChannelModel;", "setPayChannelModel", "(Lcom/didi/soda/bill/model/datamodel/PayChannelModel;)V", "priceInfoModel", "Lcom/didi/soda/bill/model/datamodel/PriceInfoModel;", "getPriceInfoModel", "()Lcom/didi/soda/bill/model/datamodel/PriceInfoModel;", "setPriceInfoModel", "(Lcom/didi/soda/bill/model/datamodel/PriceInfoModel;)V", "remarkModel", "Lcom/didi/soda/bill/model/datamodel/RemarkInfoModel;", "getRemarkModel", "()Lcom/didi/soda/bill/model/datamodel/RemarkInfoModel;", "setRemarkModel", "(Lcom/didi/soda/bill/model/datamodel/RemarkInfoModel;)V", "reminderModel", "Lcom/didi/soda/bill/model/datamodel/ReminderModel;", "getReminderModel", "()Lcom/didi/soda/bill/model/datamodel/ReminderModel;", "setReminderModel", "(Lcom/didi/soda/bill/model/datamodel/ReminderModel;)V", "tipModel", "Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "getTipModel", "()Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "setTipModel", "(Lcom/didi/soda/bill/model/datamodel/BillTipModel;)V", "titleInfoModel", "Lcom/didi/soda/bill/model/datamodel/TitleInfoModel;", "getTitleInfoModel", "()Lcom/didi/soda/bill/model/datamodel/TitleInfoModel;", "setTitleInfoModel", "(Lcom/didi/soda/bill/model/datamodel/TitleInfoModel;)V", "tyingItem", "Lcom/didi/soda/cart/model/CartTyingModel;", "getTyingItem", "()Lcom/didi/soda/cart/model/CartTyingModel;", "setTyingItem", "(Lcom/didi/soda/cart/model/CartTyingModel;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentDataModel.kt */
public final class ComponentDataModel implements RecyclerModel {

    /* renamed from: a */
    private PriceInfoModel f39025a;

    /* renamed from: b */
    private CouponInfoModel f39026b;

    /* renamed from: c */
    private AddressModel f39027c;

    /* renamed from: d */
    private ReminderModel f39028d;

    /* renamed from: e */
    private DeliveryModel f39029e;

    /* renamed from: f */
    private PayChannelModel f39030f;

    /* renamed from: g */
    private FollowModel f39031g;

    /* renamed from: h */
    private BillItemsInfoModel f39032h;

    /* renamed from: i */
    private BillTipModel f39033i;

    /* renamed from: j */
    private RemarkInfoModel f39034j;

    /* renamed from: k */
    private OutOfStockModel f39035k;

    /* renamed from: l */
    private BottomTipInfoModel f39036l;

    /* renamed from: m */
    private CetaInfoModel f39037m;

    /* renamed from: n */
    private CutleryModel f39038n;

    /* renamed from: o */
    private BillLineModel f39039o;

    /* renamed from: p */
    private TitleInfoModel f39040p;

    /* renamed from: q */
    private CartTyingModel f39041q;

    public final PriceInfoModel getPriceInfoModel() {
        return this.f39025a;
    }

    public final void setPriceInfoModel(PriceInfoModel priceInfoModel) {
        this.f39025a = priceInfoModel;
    }

    public final CouponInfoModel getCouponInfoModel() {
        return this.f39026b;
    }

    public final void setCouponInfoModel(CouponInfoModel couponInfoModel) {
        this.f39026b = couponInfoModel;
    }

    public final AddressModel getAddressModel() {
        return this.f39027c;
    }

    public final void setAddressModel(AddressModel addressModel) {
        this.f39027c = addressModel;
    }

    public final ReminderModel getReminderModel() {
        return this.f39028d;
    }

    public final void setReminderModel(ReminderModel reminderModel) {
        this.f39028d = reminderModel;
    }

    public final DeliveryModel getDeliveryModel() {
        return this.f39029e;
    }

    public final void setDeliveryModel(DeliveryModel deliveryModel) {
        this.f39029e = deliveryModel;
    }

    public final PayChannelModel getPayChannelModel() {
        return this.f39030f;
    }

    public final void setPayChannelModel(PayChannelModel payChannelModel) {
        this.f39030f = payChannelModel;
    }

    public final FollowModel getFollowModel() {
        return this.f39031g;
    }

    public final void setFollowModel(FollowModel followModel) {
        this.f39031g = followModel;
    }

    public final BillItemsInfoModel getItemsInfoModel() {
        return this.f39032h;
    }

    public final void setItemsInfoModel(BillItemsInfoModel billItemsInfoModel) {
        this.f39032h = billItemsInfoModel;
    }

    public final BillTipModel getTipModel() {
        return this.f39033i;
    }

    public final void setTipModel(BillTipModel billTipModel) {
        this.f39033i = billTipModel;
    }

    public final RemarkInfoModel getRemarkModel() {
        return this.f39034j;
    }

    public final void setRemarkModel(RemarkInfoModel remarkInfoModel) {
        this.f39034j = remarkInfoModel;
    }

    public final OutOfStockModel getOutOfStockModel() {
        return this.f39035k;
    }

    public final void setOutOfStockModel(OutOfStockModel outOfStockModel) {
        this.f39035k = outOfStockModel;
    }

    public final BottomTipInfoModel getBottomTipInfoModel() {
        return this.f39036l;
    }

    public final void setBottomTipInfoModel(BottomTipInfoModel bottomTipInfoModel) {
        this.f39036l = bottomTipInfoModel;
    }

    public final CetaInfoModel getCetaInfoModel() {
        return this.f39037m;
    }

    public final void setCetaInfoModel(CetaInfoModel cetaInfoModel) {
        this.f39037m = cetaInfoModel;
    }

    public final CutleryModel getCutleryModel() {
        return this.f39038n;
    }

    public final void setCutleryModel(CutleryModel cutleryModel) {
        this.f39038n = cutleryModel;
    }

    public final BillLineModel getLineModel() {
        return this.f39039o;
    }

    public final void setLineModel(BillLineModel billLineModel) {
        this.f39039o = billLineModel;
    }

    public final TitleInfoModel getTitleInfoModel() {
        return this.f39040p;
    }

    public final void setTitleInfoModel(TitleInfoModel titleInfoModel) {
        this.f39040p = titleInfoModel;
    }

    public final CartTyingModel getTyingItem() {
        return this.f39041q;
    }

    public final void setTyingItem(CartTyingModel cartTyingModel) {
        this.f39041q = cartTyingModel;
    }
}
