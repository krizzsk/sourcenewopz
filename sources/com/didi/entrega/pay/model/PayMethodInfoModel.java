package com.didi.entrega.pay.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.storage.AppConfigStorage;
import com.didi.entrega.customer.foundation.storage.model.AppConfig;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didi.entrega.foundation.rpc.entity.PayMethodListInfoEntity;
import com.taxis99.R;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayMethodInfoModel implements Serializable {
    private static final long serialVersionUID = 8312971654216414726L;
    public int mBalance;
    public ArrayList<CardInfoModel> mCardInfoList;
    public String mChannelId;
    public String mChannelName;
    public String mIconUrl;
    public int mIsBalanceEnough;
    public int mIsBindCard;
    public boolean mIsDisplay;
    public boolean mIsSelected;
    public int mIsSigned;
    public String mPayTypeDesc;
    public String mReason;
    public String mSaveString;

    public static List<PayMethodInfoModel> convert(Context context, PayMethodListInfoEntity payMethodListInfoEntity, PayChannel payChannel) {
        ArrayList arrayList = new ArrayList();
        if (!(payMethodListInfoEntity == null || payMethodListInfoEntity.payments == null)) {
            for (int i = 0; i < payMethodListInfoEntity.payments.size(); i++) {
                PayMethodListInfoEntity.PayMethodInfo payMethodInfo = payMethodListInfoEntity.payments.get(i);
                if (!TextUtils.equals(String.valueOf(154), payMethodInfo.channelId) || !(payMethodInfo.extraInfoList == null || payMethodInfo.extraInfoList.size() == 0)) {
                    PayMethodInfoModel payMethodInfoModel = new PayMethodInfoModel();
                    payMethodInfoModel.mIconUrl = payMethodInfo.iconUrl;
                    payMethodInfoModel.mChannelName = payMethodInfo.channelName;
                    payMethodInfoModel.mReason = payMethodInfo.reason;
                    payMethodInfoModel.mChannelId = payMethodInfo.channelId;
                    payMethodInfoModel.mIsDisplay = payMethodInfo.isDisplay == 1;
                    payMethodInfoModel.mIsSigned = payMethodInfo.isSigned;
                    payMethodInfoModel.mBalance = payMethodInfo.balance;
                    payMethodInfoModel.mSaveString = payMethodInfo.tip;
                    payMethodInfoModel.mIsBindCard = payMethodInfo.isBindCard;
                    payMethodInfoModel.mIsBalanceEnough = payMethodInfo.isBalanceEnough;
                    payMethodInfoModel.mPayTypeDesc = payMethodInfo.payTypeDesc;
                    boolean z = payChannel != null && TextUtils.equals(String.valueOf(payChannel.getChannelId()), payMethodInfo.channelId);
                    payMethodInfoModel.mIsSelected = z;
                    ArrayList<CardInfoModel> arrayList2 = new ArrayList<>();
                    if (payMethodInfo.extraInfoList != null) {
                        for (PayMethodListInfoEntity.PayMethodInfo.CardInfo next : payMethodInfo.extraInfoList) {
                            CardInfoModel access$000 = CardInfoModel.createFromEntity(next);
                            access$000.mIsSelected = z && TextUtils.equals(payChannel.getCardIndex(), next.cardIndex);
                            arrayList2.add(access$000);
                        }
                    }
                    if (TextUtils.equals(String.valueOf(150), payMethodInfo.channelId)) {
                        arrayList2.add(CardInfoModel.createBindCardModel(context, payMethodListInfoEntity, payMethodInfo));
                    }
                    payMethodInfoModel.mCardInfoList = arrayList2;
                    arrayList.add(payMethodInfoModel);
                }
            }
        }
        return arrayList;
    }

    public static int findCardNum(List<PayMethodInfoModel> list) {
        if (list == null) {
            return 0;
        }
        for (PayMethodInfoModel next : list) {
            if (TextUtils.equals(next.mChannelId, String.valueOf(150))) {
                ArrayList<CardInfoModel> arrayList = next.mCardInfoList;
                if (arrayList != null) {
                    return arrayList.size() - 1;
                }
                return 0;
            }
        }
        return 0;
    }

    public static boolean isDidiCashEnable(List<PayMethodInfoModel> list) {
        if (list == null) {
            return false;
        }
        for (PayMethodInfoModel next : list) {
            if (TextUtils.equals(next.mChannelId, String.valueOf(120))) {
                return next.mIsDisplay;
            }
        }
        return false;
    }

    public static int find99PayStatus(List<PayMethodInfoModel> list) {
        PayMethodInfoModel payMethodInfoModel;
        Iterator<PayMethodInfoModel> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                payMethodInfoModel = null;
                break;
            }
            payMethodInfoModel = it.next();
            if (TextUtils.equals(payMethodInfoModel.mChannelId, String.valueOf(190))) {
                break;
            }
        }
        if (payMethodInfoModel == null) {
            return 0;
        }
        if (!payMethodInfoModel.mIsDisplay || payMethodInfoModel.mIsSigned != 1) {
            return 3;
        }
        return payMethodInfoModel.mIsBalanceEnough == 1 ? 1 : 2;
    }

    public static Boolean findPayPaySignStatus(List<PayMethodInfoModel> list) {
        for (PayMethodInfoModel next : list) {
            if (TextUtils.equals(next.mChannelId, String.valueOf(182))) {
                int i = next.mIsSigned;
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    public static class CardInfoModel implements Serializable {
        public static final int TYPE_BIND_CARD_ACCESS = 2;
        public static final int TYPE_CARD = 1;
        private static final long serialVersionUID = 3223937307613815470L;
        public String cardIndex;
        public String cardName;
        public String cardOrg;
        public String cardSuffix;
        public String disableReason;
        public int isDisable;
        public int mAddCardIconRes;
        public String mAddCardSubtitle;
        public int mDataType = 1;
        public boolean mIsSelected;
        public String mRecommendString;
        public int needExValidate;
        public String tip;

        /* access modifiers changed from: private */
        public static CardInfoModel createFromEntity(PayMethodListInfoEntity.PayMethodInfo.CardInfo cardInfo) {
            CardInfoModel cardInfoModel = new CardInfoModel();
            cardInfoModel.cardSuffix = cardInfo.cardSuffix;
            cardInfoModel.cardOrg = cardInfo.cardOrg;
            cardInfoModel.cardIndex = cardInfo.cardIndex;
            cardInfoModel.needExValidate = cardInfo.needExValidate;
            cardInfoModel.cardName = cardInfo.cardName;
            cardInfoModel.isDisable = cardInfo.isDisable;
            cardInfoModel.disableReason = cardInfo.disableReason;
            cardInfoModel.tip = cardInfo.tip;
            cardInfoModel.mDataType = 1;
            return cardInfoModel;
        }

        /* access modifiers changed from: private */
        public static CardInfoModel createBindCardModel(Context context, PayMethodListInfoEntity payMethodListInfoEntity, PayMethodListInfoEntity.PayMethodInfo payMethodInfo) {
            CardInfoModel cardInfoModel = new CardInfoModel();
            cardInfoModel.cardSuffix = context.getResources().getString(R.string.FoodC_order_Add_Credit_vzAu);
            String payMethodInfoWarnMsg = PayMethodListInfoEntity.getPayMethodInfoWarnMsg(payMethodListInfoEntity, 150);
            if (TextUtils.isEmpty(payMethodInfoWarnMsg)) {
                payMethodInfoWarnMsg = context.getResources().getString(R.string.FoodC_order_VISA_main_dVwo);
            }
            cardInfoModel.mAddCardSubtitle = payMethodInfoWarnMsg;
            cardInfoModel.mAddCardIconRes = R.drawable.entrega_icon_add_card;
            cardInfoModel.mDataType = 2;
            if (!(payMethodInfo.extraInfoList != null && payMethodInfo.extraInfoList.size() > 0)) {
                AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
                AppConfig data = appConfigStorage.getData();
                long j = data.mPayMethodAdviceShowTime;
                if (j <= 0 || System.currentTimeMillis() - j >= GlobalBubbleShowHelper.ONE_WEEK) {
                    cardInfoModel.mRecommendString = ResourceHelper.getString(R.string.FoodC_order_Recommended_lorx);
                    data.mPayMethodAdviceShowTime = System.currentTimeMillis();
                    appConfigStorage.setData(data);
                }
            }
            return cardInfoModel;
        }
    }
}
