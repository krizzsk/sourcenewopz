package com.didi.global.fintech.cashier.fastpay.viewbinder.order;

import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.core.utils.GlobalBubbleShowHelper;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderContentViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderPresenter;
import com.didi.global.fintech.cashier.fastpay.viewbinder.FastPayBaseVB;
import com.didi.global.fintech.cashier.model.net.request.fastpay.DeductionChannel;
import com.didi.global.fintech.cashier.model.net.response.fastpay.Deduction;
import com.didi.global.fintech.cashier.model.net.response.fastpay.DeductionPayChannel;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ShowInfo;
import com.didi.global.fintech.cashier.p117ui.IFastPayOrderContentViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem;
import com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory;
import com.didi.global.fintech.cashier.p117ui.viewholder.OrderType;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/viewbinder/order/FastPayOrderContentVB;", "Lcom/didi/global/fintech/cashier/fastpay/viewbinder/FastPayBaseVB;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderPresenter;", "Lcom/didi/global/fintech/cashier/ui/IFastPayOrderContentViewHolder;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderContentViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderPresenter;)V", "getOrderItemsByType", "", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/DeductionChannel;", "type", "Lcom/didi/global/fintech/cashier/ui/viewholder/OrderType;", "onAddCardClick", "", "setupView", "data", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderContentVB.kt */
public final class FastPayOrderContentVB extends FastPayBaseVB<FastPayOrderResponse, IFastPayOrderPresenter, IFastPayOrderContentViewHolder> implements IFastPayOrderContentViewBinder<FastPayOrderResponse> {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayOrderContentVB.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OrderType.values().length];
            iArr[OrderType.Deduction.ordinal()] = 1;
            iArr[OrderType.NoDeduction.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayOrderContentVB(IFastPayOrderPresenter iFastPayOrderPresenter) {
        super(iFastPayOrderPresenter);
        Intrinsics.checkNotNullParameter(iFastPayOrderPresenter, "presenter");
    }

    public void onAddCardClick() {
        ((IFastPayOrderPresenter) getPresenter()).onAddCardClick();
    }

    public void setupView(FastPayOrderResponse fastPayOrderResponse) {
        IFastPayOrderContentViewHolder iFastPayOrderContentViewHolder;
        List<DeductionPayChannel> payChannelList;
        List<DeductionPayChannel> payChannelList2;
        List<DeductionPayChannel> payChannelList3;
        FastPayOrderResponse fastPayOrderResponse2 = fastPayOrderResponse;
        Intrinsics.checkNotNullParameter(fastPayOrderResponse2, "data");
        super.setupView(fastPayOrderResponse);
        List arrayList = new ArrayList();
        FastPayOrderContentVB fastPayOrderContentVB = this;
        boolean z = true;
        String str = null;
        if ((fastPayOrderResponse.getAutoDeduction() != null ? this : null) != null) {
            ItemViewFactory.Type type = ItemViewFactory.Type.Title;
            Deduction autoDeduction = fastPayOrderResponse.getAutoDeduction();
            arrayList.add(new FastPayOrderItem(type, autoDeduction == null ? null : autoDeduction.getTitle(), (String) null, (String) null, (Function0) null, (Boolean) null, (OrderType) null, false, (String) null, (String) null, (String) null, (String) null, 4092, (DefaultConstructorMarker) null));
        }
        Deduction autoDeduction2 = fastPayOrderResponse.getAutoDeduction();
        if (!(autoDeduction2 == null || (payChannelList3 = autoDeduction2.getPayChannelList()) == null)) {
            for (DeductionPayChannel DeductionPayChannelToFastPayOrderItem : payChannelList3) {
                FastPayOrderItem DeductionPayChannelToFastPayOrderItem2 = ViewBinderDataParser.Companion.DeductionPayChannelToFastPayOrderItem(DeductionPayChannelToFastPayOrderItem);
                DeductionPayChannelToFastPayOrderItem2.setOrderType(OrderType.Deduction);
                Unit unit = Unit.INSTANCE;
                arrayList.add(DeductionPayChannelToFastPayOrderItem2);
            }
        }
        if ((fastPayOrderResponse.getNoAutoDeduction() != null ? this : null) != null) {
            ItemViewFactory.Type type2 = ItemViewFactory.Type.Title;
            Deduction noAutoDeduction = fastPayOrderResponse.getNoAutoDeduction();
            arrayList.add(new FastPayOrderItem(type2, noAutoDeduction == null ? null : noAutoDeduction.getTitle(), (String) null, (String) null, (Function0) null, (Boolean) null, (OrderType) null, false, (String) null, (String) null, (String) null, (String) null, 4092, (DefaultConstructorMarker) null));
        }
        Deduction noAutoDeduction2 = fastPayOrderResponse.getNoAutoDeduction();
        if (!(noAutoDeduction2 == null || (payChannelList2 = noAutoDeduction2.getPayChannelList()) == null)) {
            for (DeductionPayChannel DeductionPayChannelToFastPayOrderItem3 : payChannelList2) {
                FastPayOrderItem DeductionPayChannelToFastPayOrderItem4 = ViewBinderDataParser.Companion.DeductionPayChannelToFastPayOrderItem(DeductionPayChannelToFastPayOrderItem3);
                DeductionPayChannelToFastPayOrderItem4.setOrderType(OrderType.NoDeduction);
                Unit unit2 = Unit.INSTANCE;
                arrayList.add(DeductionPayChannelToFastPayOrderItem4);
            }
        }
        ItemViewFactory.Type type3 = ItemViewFactory.Type.Info;
        ShowInfo showInfo = fastPayOrderResponse.getShowInfo();
        FastPayOrderItem fastPayOrderItem = new FastPayOrderItem(type3, showInfo == null ? null : showInfo.getNon_auto_deduction_desc(), (String) null, (String) null, (Function0) null, (Boolean) null, (OrderType) null, false, (String) null, (String) null, (String) null, (String) null, 4092, (DefaultConstructorMarker) null);
        Deduction noAutoDeduction3 = fastPayOrderResponse.getNoAutoDeduction();
        if (noAutoDeduction3 == null || (payChannelList = noAutoDeduction3.getPayChannelList()) == null || !payChannelList.isEmpty()) {
            z = false;
        }
        if ((z ? this : null) != null) {
            arrayList.add(fastPayOrderItem);
        }
        IFastPayOrderContentViewHolder iFastPayOrderContentViewHolder2 = (IFastPayOrderContentViewHolder) getViewHolder();
        if (iFastPayOrderContentViewHolder2 != null) {
            iFastPayOrderContentViewHolder2.updateAddClick(new FastPayOrderContentVB$setupView$9(this));
        }
        IFastPayOrderContentViewHolder iFastPayOrderContentViewHolder3 = (IFastPayOrderContentViewHolder) getViewHolder();
        if (iFastPayOrderContentViewHolder3 != null) {
            iFastPayOrderContentViewHolder3.updateOrderItems(arrayList, fastPayOrderItem);
        }
        FastPayOrderContentVB fastPayOrderContentVB2 = GlobalBubbleShowHelper.show(CashierFacade.Companion.getInstance().getApplication(), GlobalBubbleShowHelper.BubbleType.FastPay) ? this : null;
        if (!(fastPayOrderContentVB2 == null || (iFastPayOrderContentViewHolder = (IFastPayOrderContentViewHolder) fastPayOrderContentVB2.getViewHolder()) == null)) {
            ShowInfo showInfo2 = fastPayOrderResponse.getShowInfo();
            iFastPayOrderContentViewHolder.updateBubble(showInfo2 == null ? null : showInfo2.getAdjust_bubble());
        }
        IFastPayOrderContentViewHolder iFastPayOrderContentViewHolder4 = (IFastPayOrderContentViewHolder) getViewHolder();
        if (iFastPayOrderContentViewHolder4 != null) {
            iFastPayOrderContentViewHolder4.updateToastChannel(new FastPayOrderContentVB$setupView$12(this, fastPayOrderResponse2));
        }
        IFastPayOrderContentViewHolder iFastPayOrderContentViewHolder5 = (IFastPayOrderContentViewHolder) getViewHolder();
        if (iFastPayOrderContentViewHolder5 != null) {
            ShowInfo showInfo3 = fastPayOrderResponse.getShowInfo();
            if (showInfo3 != null) {
                str = showInfo3.getAdjust_desc();
            }
            iFastPayOrderContentViewHolder5.updateBottomMsg(str);
        }
    }

    public List<DeductionChannel> getOrderItemsByType(OrderType orderType) {
        int i;
        Integer num;
        List<FastPayOrderItem> subList;
        List<FastPayOrderItem> subList2;
        Intrinsics.checkNotNullParameter(orderType, "type");
        List<DeductionChannel> arrayList = new ArrayList<>();
        IFastPayOrderContentViewHolder iFastPayOrderContentViewHolder = (IFastPayOrderContentViewHolder) getViewHolder();
        FastPayOrderContentVB fastPayOrderContentVB = null;
        List<FastPayOrderItem> orderItems = iFastPayOrderContentViewHolder == null ? null : iFastPayOrderContentViewHolder.getOrderItems();
        if (orderItems != null) {
            Iterator<FastPayOrderItem> it = orderItems.iterator();
            i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (it.next().getOrderType() == OrderType.Deduction) {
                    break;
                }
                i++;
            }
        } else {
            i = 0;
        }
        if (orderItems == null) {
            num = null;
        } else {
            Iterator<FastPayOrderItem> it2 = orderItems.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it2.next().getOrderType() == OrderType.NoDeduction) {
                    break;
                }
                i2++;
            }
            num = Integer.valueOf(i2);
        }
        int size = num == null ? orderItems == null ? 0 : orderItems.size() : num.intValue();
        FastPayOrderContentVB fastPayOrderContentVB2 = this;
        if (size == -1) {
            fastPayOrderContentVB = this;
        }
        if (fastPayOrderContentVB != null) {
            size = orderItems == null ? 0 : orderItems.size();
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[orderType.ordinal()];
        if (i3 != 1) {
            if (!(i3 != 2 || orderItems == null || (subList2 = orderItems.subList(size, orderItems.size())) == null)) {
                Collection arrayList2 = new ArrayList();
                for (Object next : subList2) {
                    if (((FastPayOrderItem) next).getType() == ItemViewFactory.Type.Pay) {
                        arrayList2.add(next);
                    }
                }
                for (FastPayOrderItem fastPayOrderItem : (List) arrayList2) {
                    arrayList.add(new DeductionChannel(fastPayOrderItem.getChannel_id(), fastPayOrderItem.getCard_index(), fastPayOrderItem.getCard_uni_id(), fastPayOrderItem.getWeight()));
                }
            }
        } else if (!(orderItems == null || (subList = orderItems.subList(i, size)) == null)) {
            Collection arrayList3 = new ArrayList();
            for (Object next2 : subList) {
                if (((FastPayOrderItem) next2).getType() == ItemViewFactory.Type.Pay) {
                    arrayList3.add(next2);
                }
            }
            for (FastPayOrderItem fastPayOrderItem2 : (List) arrayList3) {
                arrayList.add(new DeductionChannel(fastPayOrderItem2.getChannel_id(), fastPayOrderItem2.getCard_index(), fastPayOrderItem2.getCard_uni_id(), fastPayOrderItem2.getWeight()));
            }
        }
        return arrayList;
    }
}
