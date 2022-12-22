package com.didi.sdk.global;

import android.text.TextUtils;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.common.com.EnterpriseInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DidiGlobalPayMethodListData implements Serializable {

    public static class CardInfo implements Serializable {
        public String cardDesc;
        public List<String> cardDiscountTags;
        public String cardIndex;
        public String cardNo;
        public String cardNoInSelectPage;
        public int cardStatus;
        public int expired;
        public String expiredDesc;
        public String iconUrl;
        public boolean isSelected;
        public String logData;
        public String mostFavorableTxt;
        public String totalDiscount;
    }

    public enum Entrance implements Serializable {
        FROM_GUIDE,
        FROM_SIDEBAR,
        FROM_PAY_ESTIMATION,
        FROM_UNIFIED_PAY,
        FROM_BIKE,
        FROM_SPLIT_FARE,
        FROM_H5
    }

    public static class Extra {
        public static final String PAY_METHOD_LIST_PARAM = "pay_method_list_param";
        public static final String PAY_METHOD_LIST_RESULT = "pay_method_list_result";
    }

    public static class PayMethodGroupInfo implements Serializable {
        public AccountFreezeData accountFreezeData;
        public int[] channelIds;
        public String iconUrl;
        public String name;
    }

    public static class PayMethodInfo implements Serializable {
        public Set<Integer> allowedCombineTags = new HashSet();
        public String balance;
        public List<String> cardDiscountTags;
        public List<CardInfo> cardList;
        public int channelId;
        public String channelTip;
        public int combineTag;
        public String discount;
        public String guideH5Url;
        public String iconUrl;
        public String info;
        public boolean isEnabled;
        public boolean isHit99payCombination;
        public boolean isPriorityUse;
        public boolean isPromotion;
        public boolean isSelected;
        public boolean isSigned;
        public boolean isSufficient;
        public String logData;
        public String mostFavorableTxt;
        public String subTitle;
        public String tips;
        public String title;
        public String titleInSelectPage;
        public String toAddCardInfo;
    }

    public static class PayMethodListResult implements Serializable {
        public int combinedTags = 0;
        public int enterpriseFlag = 1;
        public boolean hasRefreshed = false;
        public List<SelectedPayMethod> selectedPayMethods = new ArrayList();
    }

    public static class SelectedPayMethod implements Serializable {
        public String cardIndex;
        public String cardNo;
        public int channelId;
        public int combineTag;
        public boolean hasCoupon = false;
        public String iconUrl;
    }

    public static class PayMethodListParam implements Serializable {
        public DidiGlobalAddCardData.AddCardParam addCardParam;
        public PayMethodConfigInfo configInfo;
        public EnterpriseInfo enterpriseInfo;
        public Entrance from;
        public List<PayMethodGroupInfo> groupList;
        public List<PayMethodInfo> list;
        public String nextAction;
        public String resourceId;
        public String skipAction;

        public PayMethodListParam(Entrance entrance) {
            this.from = entrance;
            if (this.addCardParam == null) {
                this.addCardParam = new DidiGlobalAddCardData.AddCardParam();
                int i = C122421.f36009x8a3a0836[entrance.ordinal()];
                if (i == 1) {
                    this.addCardParam.bindType = 8;
                } else if (i == 2) {
                    this.addCardParam.bindType = 1;
                } else if (i == 3) {
                    this.addCardParam.bindType = 4;
                } else if (i == 4) {
                    this.addCardParam.bindType = 5;
                } else if (i != 5) {
                    this.addCardParam.bindType = 8;
                } else {
                    this.addCardParam.bindType = 13;
                }
            }
        }
    }

    /* renamed from: com.didi.sdk.global.DidiGlobalPayMethodListData$1 */
    static /* synthetic */ class C122421 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$DidiGlobalPayMethodListData$Entrance */
        static final /* synthetic */ int[] f36009x8a3a0836;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance[] r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f36009x8a3a0836 = r0
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f36009x8a3a0836     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f36009x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_UNIFIED_PAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f36009x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_GUIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f36009x8a3a0836     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_BIKE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.DidiGlobalPayMethodListData.C122421.<clinit>():void");
        }
    }

    public static class PayMethodConfigInfo implements Serializable {
        public String extOmegaAttrs;
        public PopupItem switchOut99PayPopup;
        public PopupItem switchOutCombinationPayPopup;

        public static class PopupItem implements Serializable {
            public String cancelBtn;
            public String confirmBtn;
            public String subTitle;
            public String title;

            public boolean isValid() {
                return !TextUtils.isEmpty(this.title) && !TextUtils.isEmpty(this.subTitle) && !TextUtils.isEmpty(this.cancelBtn) && !TextUtils.isEmpty(this.confirmBtn);
            }
        }
    }
}
