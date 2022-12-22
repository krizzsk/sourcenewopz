package com.didi.global.fintech.cashier.core.datapraser;

import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.PolicyInfo;
import com.didi.global.fintech.cashier.model.net.response.PriceAmount;
import com.didi.global.fintech.cashier.model.net.response.PriceInfo;
import com.didi.global.fintech.cashier.model.net.response.ResultPayments;
import com.didi.global.fintech.cashier.model.net.response.ReturnButton;
import com.didi.global.fintech.cashier.model.net.response.fastpay.DeductionPayChannel;
import com.didi.global.fintech.cashier.p117ui.viewholder.AcceptContent;
import com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem;
import com.didi.global.fintech.cashier.p117ui.viewholder.FeeHelpInfo;
import com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory;
import com.didi.global.fintech.cashier.p117ui.viewholder.MerchantButtonData;
import com.didi.global.fintech.cashier.p117ui.viewholder.OrderType;
import com.didi.global.fintech.cashier.p117ui.viewholder.PaymentMethod;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.PaymentLabel;
import com.didi.soda.blocks.constant.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/datapraser/ViewBinderDataParser;", "", "()V", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewBinderDataParser.kt */
public final class ViewBinderDataParser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final FastPayOrderItem DeductionPayChannelToFastPayOrderItem(DeductionPayChannel deductionPayChannel) {
        return Companion.DeductionPayChannelToFastPayOrderItem(deductionPayChannel);
    }

    @JvmStatic
    public static final AcceptContent PolicyAcceptContentToAcceptContent(PolicyInfo.PolicyAcceptContent policyAcceptContent) {
        return Companion.PolicyAcceptContentToAcceptContent(policyAcceptContent);
    }

    @JvmStatic
    public static final <T, R> R parseData(T t, Function1<? super T, ? extends R> function1) {
        return Companion.parseData(t, function1);
    }

    @JvmStatic
    public static final <T, R> List<R> parseDataList(List<? extends T> list, Function1<? super T, ? extends R> function1) {
        return Companion.parseDataList(list, function1);
    }

    @JvmStatic
    public static final ChannelItemViewHolderData paymentTransToCardBinderData(Payment payment) {
        return Companion.paymentTransToCardBinderData(payment);
    }

    @JvmStatic
    public static final FeeHelpInfo transferHelpInfoToFeeHelpInfo(PriceInfo.AdditionalInfo.HelpInfo helpInfo) {
        return Companion.transferHelpInfoToFeeHelpInfo(helpInfo);
    }

    @JvmStatic
    public static final PaymentMethod transferResultPaymentMethod(ResultPayments resultPayments) {
        return Companion.transferResultPaymentMethod(resultPayments);
    }

    @JvmStatic
    public static final MerchantButtonData transferReturnButtonData(ReturnButton returnButton) {
        return Companion.transferReturnButtonData(returnButton);
    }

    @Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\u0007J5\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\u0005\u001a\u0002H\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0007¢\u0006\u0002\u0010\u000fJ@\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0011\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001dH\u0007¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/datapraser/ViewBinderDataParser$Companion;", "", "()V", "DeductionPayChannelToFastPayOrderItem", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "src", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/DeductionPayChannel;", "PolicyAcceptContentToAcceptContent", "Lcom/didi/global/fintech/cashier/ui/viewholder/AcceptContent;", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo$PolicyAcceptContent;", "parseData", "R", "T", "transformer", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "parseDataList", "", "paymentTransToCardBinderData", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "transferHelpInfoToFeeHelpInfo", "Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;", "transferResultPaymentMethod", "Lcom/didi/global/fintech/cashier/ui/viewholder/PaymentMethod;", "Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments;", "transferReturnButtonData", "Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", "Lcom/didi/global/fintech/cashier/model/net/response/ReturnButton;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ViewBinderDataParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T, R> List<R> parseDataList(List<? extends T> list, Function1<? super T, ? extends R> function1) {
            Intrinsics.checkNotNullParameter(function1, "transformer");
            List<R> arrayList = new ArrayList<>();
            if (list != null) {
                for (Object parseData : list) {
                    arrayList.add(ViewBinderDataParser.Companion.parseData(parseData, function1));
                }
            }
            return arrayList;
        }

        @JvmStatic
        public final <T, R> R parseData(T t, Function1<? super T, ? extends R> function1) {
            Intrinsics.checkNotNullParameter(function1, "transformer");
            return function1.invoke(t);
        }

        @JvmStatic
        public final AcceptContent PolicyAcceptContentToAcceptContent(PolicyInfo.PolicyAcceptContent policyAcceptContent) {
            Intrinsics.checkNotNullParameter(policyAcceptContent, Const.BlockParamConst.SRC);
            AcceptContent acceptContent = new AcceptContent((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            acceptContent.setLink(policyAcceptContent.getLink());
            acceptContent.setMessage(policyAcceptContent.getMessage());
            return acceptContent;
        }

        @JvmStatic
        public final FastPayOrderItem DeductionPayChannelToFastPayOrderItem(DeductionPayChannel deductionPayChannel) {
            Intrinsics.checkNotNullParameter(deductionPayChannel, Const.BlockParamConst.SRC);
            FastPayOrderItem fastPayOrderItem = new FastPayOrderItem((ItemViewFactory.Type) null, (String) null, (String) null, (String) null, (Function0) null, (Boolean) null, (OrderType) null, false, (String) null, (String) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
            String type = deductionPayChannel.getType();
            if (Intrinsics.areEqual((Object) type, (Object) "channel")) {
                fastPayOrderItem.setType(ItemViewFactory.Type.Pay);
            } else if (Intrinsics.areEqual((Object) type, (Object) "bind_card")) {
                fastPayOrderItem.setType(ItemViewFactory.Type.AddCard);
            }
            fastPayOrderItem.setContent(deductionPayChannel.getDisplay());
            fastPayOrderItem.setSubContent(deductionPayChannel.getSubheadDisplay());
            fastPayOrderItem.setAvailable(Boolean.valueOf(deductionPayChannel.getAvailable()));
            fastPayOrderItem.setIcon(deductionPayChannel.getIconUrl());
            fastPayOrderItem.setCard_index(deductionPayChannel.getCard_index());
            fastPayOrderItem.setCard_uni_id(deductionPayChannel.getCard_uni_id());
            fastPayOrderItem.setChannel_id(deductionPayChannel.getChannel_id());
            fastPayOrderItem.setWeight(deductionPayChannel.getWeight());
            return fastPayOrderItem;
        }

        @JvmStatic
        public final ChannelItemViewHolderData paymentTransToCardBinderData(Payment payment) {
            GlobalCashierBaseItemViewHolder.ViewType viewType;
            ChannelItemViewHolderData.Operation operation;
            List list;
            List list2;
            List list3;
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(payment, Const.BlockParamConst.SRC);
            ChannelItemViewHolderData channelItemViewHolderData = new ChannelItemViewHolderData();
            channelItemViewHolderData.setContent(payment.getDisplay());
            channelItemViewHolderData.setSubContent(payment.getSubheadDisplay());
            channelItemViewHolderData.setIcon(payment.getIcon());
            Payment.ExtraInfo extraInfo = payment.getExtraInfo();
            channelItemViewHolderData.setCardIndex(extraInfo == null ? null : extraInfo.getCardIndex());
            channelItemViewHolderData.setSelected(payment.getSelected());
            channelItemViewHolderData.setDisabled(payment.getDisabled());
            channelItemViewHolderData.setSigned(payment.isSigned());
            channelItemViewHolderData.setType(payment.getType());
            channelItemViewHolderData.setChannelId(payment.getChannelId());
            channelItemViewHolderData.setUniqueId(Integer.valueOf(payment.uniqueId()));
            List<Payment.PaymentTags> tags = payment.getTags();
            if (tags != null) {
                for (Payment.PaymentTags paymentTags : tags) {
                    List<PaymentLabel> tags2 = channelItemViewHolderData.getTags();
                    PaymentLabel paymentLabel = new PaymentLabel((String) null, (String) null, 3, (DefaultConstructorMarker) null);
                    paymentLabel.setType(paymentTags.getType());
                    paymentLabel.setMessage(paymentTags.getMessage());
                    Unit unit = Unit.INSTANCE;
                    tags2.add(paymentLabel);
                }
                Unit unit2 = Unit.INSTANCE;
            }
            String type = payment.getType();
            boolean z3 = false;
            if (Intrinsics.areEqual((Object) type, (Object) "bind_card")) {
                viewType = GlobalCashierBaseItemViewHolder.ViewType.AddCard;
            } else if (Intrinsics.areEqual((Object) type, (Object) "channel")) {
                Integer channelId = payment.getChannelId();
                if ((channelId != null && channelId.intValue() == 190) || (channelId != null && channelId.intValue() == 120)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    viewType = GlobalCashierBaseItemViewHolder.ViewType.Balance;
                } else if (channelId != null && channelId.intValue() == 150) {
                    viewType = GlobalCashierBaseItemViewHolder.ViewType.Card;
                } else {
                    viewType = GlobalCashierBaseItemViewHolder.ViewType.Third;
                }
            } else {
                viewType = GlobalCashierBaseItemViewHolder.ViewType.Default;
            }
            channelItemViewHolderData.setViewType(viewType);
            String type2 = payment.getType();
            if (Intrinsics.areEqual((Object) type2, (Object) "channel")) {
                Integer channelId2 = payment.getChannelId();
                if ((channelId2 != null && channelId2.intValue() == 190) || (channelId2 != null && channelId2.intValue() == 120)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Payment.BalanceInfo balanceInfo = payment.getBalanceInfo();
                    if (balanceInfo == null ? false : Intrinsics.areEqual((Object) balanceInfo.isEnough(), (Object) true)) {
                        operation = ChannelItemViewHolderData.Operation.OPERATION_CHECK;
                    } else {
                        Payment.BalanceInfo balanceInfo2 = payment.getBalanceInfo();
                        if (balanceInfo2 == null ? false : Intrinsics.areEqual((Object) balanceInfo2.getNeedTopUp(), (Object) true)) {
                            operation = ChannelItemViewHolderData.Operation.OPERATION_TOP_UP;
                        } else {
                            List<Integer> combineChannels = payment.getCombineChannels();
                            if (combineChannels != null && (!combineChannels.isEmpty())) {
                                z3 = true;
                            }
                            if (z3) {
                                operation = ChannelItemViewHolderData.Operation.OPERATION_SWITCH;
                            } else {
                                operation = ChannelItemViewHolderData.Operation.OPERATION_CHECK;
                            }
                        }
                    }
                } else if (channelId2 != null && channelId2.intValue() == 150) {
                    operation = ChannelItemViewHolderData.Operation.OPERATION_CHECK;
                } else {
                    operation = ChannelItemViewHolderData.Operation.OPERATION_CHECK;
                }
            } else if (Intrinsics.areEqual((Object) type2, (Object) "bind_card")) {
                operation = ChannelItemViewHolderData.Operation.OPERATION_ARROW;
            } else {
                operation = ChannelItemViewHolderData.Operation.OPERATION_CHECK;
            }
            channelItemViewHolderData.setOperatorType(operation);
            Payment.InstallmentVo installment = payment.getInstallment();
            if (installment != null) {
                InstallmentVo installmentVo = new InstallmentVo((Boolean) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, 127, (DefaultConstructorMarker) null);
                installmentVo.setSupport(installment.getSupport());
                installmentVo.setTitle(installment.getTitle());
                PriceAmount installmentAmount = installment.getInstallmentAmount();
                installmentVo.setInstallmentAmount(installmentAmount == null ? null : installmentAmount.getDisplay());
                installmentVo.setFaqUrl(installment.getFaqUrl());
                List<Payment.InstallmentVo.AdditionalInfo> additionalInfo = installment.getAdditionalInfo();
                if (additionalInfo == null) {
                    list = null;
                } else {
                    Iterable<Payment.InstallmentVo.AdditionalInfo> iterable = additionalInfo;
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (Payment.InstallmentVo.AdditionalInfo message : iterable) {
                        InstallmentVo.AdditionalInfo additionalInfo2 = new InstallmentVo.AdditionalInfo((String) null, 1, (DefaultConstructorMarker) null);
                        additionalInfo2.setMessage(message.getMessage());
                        Unit unit3 = Unit.INSTANCE;
                        arrayList.add(additionalInfo2);
                    }
                    list = (List) arrayList;
                }
                installmentVo.setAdditionalInfo(list);
                List<Payment.InstallmentVo.PlansVo> suggestPlans = installment.getSuggestPlans();
                if (suggestPlans == null) {
                    list2 = null;
                } else {
                    Iterable<Payment.InstallmentVo.PlansVo> iterable2 = suggestPlans;
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                    for (Payment.InstallmentVo.PlansVo plansVo : iterable2) {
                        InstallmentVo.PlansVo plansVo2 = r8;
                        InstallmentVo.PlansVo plansVo3 = new InstallmentVo.PlansVo((Integer) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
                        plansVo2.setNumber(plansVo.getNumber());
                        plansVo2.setDisplay(plansVo.getDisplay());
                        plansVo2.setSelected(plansVo.getSelected());
                        PriceAmount eachAmount = plansVo.getEachAmount();
                        plansVo2.setEachAmount(eachAmount == null ? null : eachAmount.getDisplay());
                        PriceAmount totalAmount = plansVo.getTotalAmount();
                        plansVo2.setTotalAmount(totalAmount == null ? null : totalAmount.getDisplay());
                        PriceAmount accessoryAmount = plansVo.getAccessoryAmount();
                        plansVo2.setAccessoryAmount(accessoryAmount == null ? null : accessoryAmount.getDisplay());
                        plansVo2.setTag(plansVo.getTag());
                        Unit unit4 = Unit.INSTANCE;
                        arrayList2.add(plansVo2);
                    }
                    list2 = (List) arrayList2;
                }
                installmentVo.setSuggestPlans(list2);
                List<Payment.InstallmentVo.PlansVo> plans = installment.getPlans();
                if (plans == null) {
                    list3 = null;
                } else {
                    Iterable<Payment.InstallmentVo.PlansVo> iterable3 = plans;
                    Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                    for (Payment.InstallmentVo.PlansVo plansVo4 : iterable3) {
                        InstallmentVo.PlansVo plansVo5 = new InstallmentVo.PlansVo((Integer) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
                        plansVo5.setNumber(plansVo4.getNumber());
                        plansVo5.setDisplay(plansVo4.getDisplay());
                        plansVo5.setSelected(plansVo4.getSelected());
                        PriceAmount eachAmount2 = plansVo4.getEachAmount();
                        plansVo5.setEachAmount(eachAmount2 == null ? null : eachAmount2.getDisplay());
                        PriceAmount totalAmount2 = plansVo4.getTotalAmount();
                        plansVo5.setTotalAmount(totalAmount2 == null ? null : totalAmount2.getDisplay());
                        PriceAmount accessoryAmount2 = plansVo4.getAccessoryAmount();
                        plansVo5.setAccessoryAmount(accessoryAmount2 == null ? null : accessoryAmount2.getDisplay());
                        plansVo5.setTag(plansVo4.getTag());
                        Unit unit5 = Unit.INSTANCE;
                        arrayList3.add(plansVo5);
                    }
                    list3 = (List) arrayList3;
                }
                installmentVo.setPlans(list3);
                Unit unit6 = Unit.INSTANCE;
                channelItemViewHolderData.setInstallment(installmentVo);
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            }
            return channelItemViewHolderData;
        }

        @JvmStatic
        public final FeeHelpInfo transferHelpInfoToFeeHelpInfo(PriceInfo.AdditionalInfo.HelpInfo helpInfo) {
            Intrinsics.checkNotNullParameter(helpInfo, Const.BlockParamConst.SRC);
            FeeHelpInfo feeHelpInfo = new FeeHelpInfo((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            feeHelpInfo.setTitle(helpInfo.getTitle());
            feeHelpInfo.setMessage(helpInfo.getMessage());
            return feeHelpInfo;
        }

        @JvmStatic
        public final PaymentMethod transferResultPaymentMethod(ResultPayments resultPayments) {
            Intrinsics.checkNotNullParameter(resultPayments, Const.BlockParamConst.SRC);
            String str = null;
            PaymentMethod paymentMethod = new PaymentMethod((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
            paymentMethod.setIcon(resultPayments.getIcon());
            paymentMethod.setDisplayName(resultPayments.getDisplayName());
            PriceAmount price = resultPayments.getPrice();
            paymentMethod.setPrice(price == null ? null : price.getDisplay());
            ResultPayments.InstallmentVo installment = resultPayments.getInstallment();
            if (installment != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(installment.getNumber());
                sb.append(" x ");
                PriceAmount eachAmount = installment.getEachAmount();
                if (eachAmount != null) {
                    str = eachAmount.getDisplay();
                }
                sb.append(str);
                paymentMethod.setInstallmentAmount(sb.toString());
                paymentMethod.setInstallmentName(installment.getNameDisplay());
            }
            return paymentMethod;
        }

        @JvmStatic
        public final MerchantButtonData transferReturnButtonData(ReturnButton returnButton) {
            Intrinsics.checkNotNullParameter(returnButton, Const.BlockParamConst.SRC);
            MerchantButtonData merchantButtonData = new MerchantButtonData((Boolean) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
            merchantButtonData.setShow(returnButton.getShow());
            merchantButtonData.setMessage(returnButton.getMessage());
            merchantButtonData.setType(returnButton.getType());
            merchantButtonData.setReturn_url(returnButton.getReturn_url());
            return merchantButtonData;
        }
    }
}
