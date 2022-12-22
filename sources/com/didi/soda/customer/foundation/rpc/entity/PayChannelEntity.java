package com.didi.soda.customer.foundation.rpc.entity;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.pay.model.PayMethodInfoModel;
import java.util.List;

public class PayChannelEntity implements IEntity {
    private static final long serialVersionUID = 1796999574171430067L;
    public String alias;
    public int balance;
    public String cardIndex;
    public String cardName;
    public String cardOrg;
    public String cardPrefix;
    public String cardSuffix;
    public int cardType;
    public int channelId;
    public String channelName;
    public int clientPayType;
    public List<PayChannelEntity> combinedChannelList;
    public String creditLimitPrompt;
    public String payTypeDesc;

    public boolean isPayChannelInvalid() {
        int i = this.channelId;
        if (i == 0) {
            return true;
        }
        if (i != 150) {
            return false;
        }
        if (TextUtils.isEmpty(this.cardIndex) || TextUtils.isEmpty(this.cardSuffix)) {
            return true;
        }
        return false;
    }

    public boolean isSameChannel(PayMethodInfoModel payMethodInfoModel) {
        if (payMethodInfoModel == null || payMethodInfoModel.mChannelId == null || !payMethodInfoModel.mChannelId.equals(String.valueOf(this.channelId))) {
            return false;
        }
        return isSameCombinedList(this.combinedChannelList, payMethodInfoModel.mCombinedChannelList);
    }

    public boolean isSameChannel(PayMethodListInfoEntity.PayMethodInfo payMethodInfo) {
        if (payMethodInfo == null || payMethodInfo.channelId == null || !payMethodInfo.channelId.equals(String.valueOf(this.channelId))) {
            return false;
        }
        return isSameCombinedList(this.combinedChannelList, payMethodInfo.combinedChannelList);
    }

    private boolean isSameCombinedList(List<PayChannelEntity> list, List<PayChannelEntity> list2) {
        if (list == null || list.isEmpty()) {
            if (list2 == null || list2.isEmpty()) {
                return true;
            }
            return false;
        } else if (list2 == null || list2.isEmpty() || list.size() != list2.size()) {
            return false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i) != null || list2.get(i) != null) && (list.get(i) == null || list2.get(i) == null || list.get(i).channelId != list2.get(i).channelId)) {
                    return false;
                }
            }
            return true;
        }
    }
}
