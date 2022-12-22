package com.didi.soda.pay.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.taxis99.R;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayMethodInfoModel implements Serializable {
    private static final long serialVersionUID = 8312971654216414726L;
    public int mBalance;
    public String mBalanceMsg;
    public ArrayList<CardInfoModel> mCardInfoList;
    public String mChannelId;
    public String mChannelName;
    public List<PayChannelEntity> mCombinedChannelList;
    public String mIconUrl;
    public int mIsBalanceEnough;
    public int mIsBindCard;
    public boolean mIsDisplay;
    public boolean mIsSelected;
    public int mIsSigned;
    public String mPayTypeDesc;
    public String mReason;
    public String mSaveString;

    public static List<PayMethodInfoModel> convert(Context context, PayMethodListInfoEntity payMethodListInfoEntity, PayChannelEntity payChannelEntity) {
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
                    payMethodInfoModel.mBalanceMsg = payMethodInfo.balanceMsg;
                    payMethodInfoModel.mCombinedChannelList = payMethodInfo.combinedChannelList;
                    boolean z = payChannelEntity != null && payChannelEntity.isSameChannel(payMethodInfo);
                    payMethodInfoModel.mIsSelected = z;
                    ArrayList<CardInfoModel> arrayList2 = new ArrayList<>();
                    if (payMethodInfo.extraInfoList != null) {
                        for (PayMethodListInfoEntity.PayMethodInfo.CardInfo next : payMethodInfo.extraInfoList) {
                            CardInfoModel access$000 = CardInfoModel.createFromEntity(next);
                            access$000.mIsSelected = z && TextUtils.equals(payChannelEntity.cardIndex, next.cardIndex);
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
        public String alias;
        public String cardIndex;
        public String cardName;
        public String cardOrg;
        public String cardPrefix;
        public String cardStatus;
        public String cardSuffix;
        public int cardType;
        public String disableReason;
        public int isDisable;
        public String isLatestPayed;
        public int mAddCardIconRes;
        public String mAddCardSubtitle;
        public int mDataType = 1;
        public boolean mIsSelected;
        public String mRecommendString;
        public int needExValidate;
        public String statusDesc;
        public String tip;

        /* access modifiers changed from: private */
        public static CardInfoModel createFromEntity(PayMethodListInfoEntity.PayMethodInfo.CardInfo cardInfo) {
            CardInfoModel cardInfoModel = new CardInfoModel();
            cardInfoModel.cardPrefix = cardInfo.cardPrefix;
            cardInfoModel.cardSuffix = cardInfo.cardSuffix;
            cardInfoModel.alias = cardInfo.alias;
            cardInfoModel.cardOrg = cardInfo.cardOrg;
            cardInfoModel.cardIndex = cardInfo.cardIndex;
            cardInfoModel.isLatestPayed = cardInfo.isLatestPayed;
            cardInfoModel.statusDesc = cardInfo.statusDesc;
            cardInfoModel.cardStatus = cardInfo.cardStatus;
            cardInfoModel.needExValidate = cardInfo.needExValidate;
            cardInfoModel.cardName = cardInfo.cardName;
            cardInfoModel.cardType = cardInfo.cardType;
            cardInfoModel.isDisable = cardInfo.isDisable;
            cardInfoModel.disableReason = cardInfo.disableReason;
            cardInfoModel.tip = cardInfo.tip;
            cardInfoModel.mDataType = 1;
            return cardInfoModel;
        }

        /* access modifiers changed from: private */
        public static CardInfoModel createBindCardModel(Context context, PayMethodListInfoEntity payMethodListInfoEntity, PayMethodListInfoEntity.PayMethodInfo payMethodInfo) {
            CardInfoModel cardInfoModel = new CardInfoModel();
            cardInfoModel.cardSuffix = context.getResources().getString(R.string.customer_name_pay_method_add_title);
            String payMethodInfoWarnMsg = PayMethodListInfoEntity.getPayMethodInfoWarnMsg(payMethodListInfoEntity, 150);
            if (TextUtils.isEmpty(payMethodInfoWarnMsg)) {
                payMethodInfoWarnMsg = context.getResources().getString(R.string.customer_name_pay_method_add_subtitle);
            }
            cardInfoModel.mAddCardSubtitle = payMethodInfoWarnMsg;
            cardInfoModel.mAddCardIconRes = R.drawable.customer_icon_add_card;
            cardInfoModel.mDataType = 2;
            if (!(payMethodInfo.extraInfoList != null && payMethodInfo.extraInfoList.size() > 0)) {
                AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
                AppConfig data = appConfigStorage.getData();
                long j = data.mPayMethodAdviceShowTime;
                if (j <= 0 || System.currentTimeMillis() - j >= GlobalBubbleShowHelper.ONE_WEEK) {
                    cardInfoModel.mRecommendString = ResourceHelper.getString(R.string.customer_pay_method_advie);
                    data.mPayMethodAdviceShowTime = System.currentTimeMillis();
                    appConfigStorage.setData(data);
                }
            }
            return cardInfoModel;
        }
    }
}
