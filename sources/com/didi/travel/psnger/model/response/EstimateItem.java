package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.CarPayConfigInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarPayGroupInfoModel;
import java.util.List;
import org.json.JSONObject;

@Deprecated
public class EstimateItem extends BaseObject {
    public static final int COUNT_PRICE_TYPE_AIRPORT_QUOTA = 100;
    public static final int COUNT_PRICE_TYPE_FIXED = 2;
    public static final int COUNT_PRICE_TYPE_JP_FIXED_PRICE = 101;
    public static final int COUNT_PRICE_TYPE_NORMAL = 1;
    public static final int COUNT_PRICE_TYPE_UNKNOW = 0;
    public static final int MEMBERSHIP_CONFIRM_BUY = 1;
    public static final int MEMBERSHIP_REFUSE_BUY = 2;
    public static final int MEMBERSHIP_TYPE_NEW_BUY = 1;
    public static final int PRICING_TYPE_FIXED_DEFAULT = 2000;
    public static final int PRICING_TYPE_FIXED_MIN_DIS = 2001;
    public static final int PRICING_TYPE_FIXED_MIN_TIME = 2002;
    public static final int SHOW_MEMBERSHIP_PACKAGE = 1;
    public static final int TYPE_COMBO = 4;
    public int businessId;
    public int carTypeId;
    public int countPriceType = 0;
    public String estimateId;
    public float feeNumber;
    public CarPayConfigInfoModel payCfgInfo;
    public PayEnterpriseInfo payEnterpriseInfo;
    public List<CarPayGroupInfoModel> payGroupList;
    public List<PayWayModel.PayWayItem> payWayList;

    public int hashCode() {
        return 0;
    }

    public boolean isCarPool() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EstimateItem estimateItem = (EstimateItem) obj;
        return true;
    }

    public PayWayModel.PayWayItem getSelectPayWayItem() {
        List<PayWayModel.PayWayItem> list = this.payWayList;
        if (list != null && list.size() > 0) {
            for (PayWayModel.PayWayItem next : this.payWayList) {
                if (next.isSelected() == 1) {
                    return next;
                }
            }
        }
        return null;
    }
}
