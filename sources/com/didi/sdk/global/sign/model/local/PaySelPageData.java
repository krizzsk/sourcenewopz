package com.didi.sdk.global.sign.model.local;

import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import java.util.List;

public class PaySelPageData {
    public AccountFreezeData accountFreezeData;
    public DidiGlobalPayMethodListData.PayMethodConfigInfo configInfo;
    public List<PaySelGroupData> groupList;
    public String pageTitle;
    public List<PaySelItemData> payMethodList;
    public String payMethodTitle;
    public List<PaySelItemData> promotionList;
    public String promotionTitle;
    public String ruleUrl;
}
