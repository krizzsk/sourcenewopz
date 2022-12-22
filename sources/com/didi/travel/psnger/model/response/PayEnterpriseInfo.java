package com.didi.travel.psnger.model.response;

import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.model.response.PayEnterpriseSelectModel;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class PayEnterpriseInfo implements Serializable {
    public static final int DEFAULT_MAX_SIZE_COMMENT = 0;
    public static final int DEFAULT_MIN_SIZE_COMMENT = 0;
    public static final int TYPE_COMMENT = 3;
    public static final int TYPE_COMPANY = 0;
    public static final int TYPE_COST_CENTER = 1;
    public static final int TYPE_PROJECT = 2;
    private String comment = "";
    private PayEnterpriseSelectModel.PayEnterpriseSelectItem companyItem;
    private PayEnterpriseSelectModel.PayEnterpriseSelectItem costCenterItem;
    private int maxSizeComment = 0;
    private String memberId;
    private int minSizeComment = 0;
    private PayEnterpriseSelectModel.PayEnterpriseSelectItem projectItem;
    private Map<Integer, Boolean> requiredMap;

    public PayEnterpriseInfo() {
        HashMap hashMap = new HashMap();
        this.requiredMap = hashMap;
        hashMap.put(0, true);
        this.requiredMap.put(1, false);
        this.requiredMap.put(2, false);
        this.requiredMap.put(3, false);
    }

    public void setDefault(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, int i, int i2) {
        if (!TextUtil.isEmpty(str)) {
            this.companyItem = new PayEnterpriseSelectModel.PayEnterpriseSelectItem(str, str2, 0);
        }
        if (!TextUtil.isEmpty(str3)) {
            this.costCenterItem = new PayEnterpriseSelectModel.PayEnterpriseSelectItem(str3, str4, 1);
        }
        if (!TextUtil.isEmpty(str5)) {
            this.projectItem = new PayEnterpriseSelectModel.PayEnterpriseSelectItem(str5, str6, 2);
        }
        this.requiredMap.put(1, Boolean.valueOf(z));
        this.requiredMap.put(2, Boolean.valueOf(z2));
        this.requiredMap.put(3, Boolean.valueOf(z3));
        this.minSizeComment = i;
        this.maxSizeComment = i2;
    }

    public PayEnterpriseSelectModel.PayEnterpriseSelectItem getCompanyItem() {
        return this.companyItem;
    }

    public void setCompanyItem(PayEnterpriseSelectModel.PayEnterpriseSelectItem payEnterpriseSelectItem) {
        this.companyItem = payEnterpriseSelectItem;
        this.costCenterItem = null;
        this.projectItem = null;
        if (payEnterpriseSelectItem != null) {
            this.requiredMap.put(1, Boolean.valueOf(payEnterpriseSelectItem.isRequiredCostCenter()));
            this.requiredMap.put(2, Boolean.valueOf(payEnterpriseSelectItem.isRequiredProject()));
            this.requiredMap.put(3, Boolean.valueOf(payEnterpriseSelectItem.isRequiredComment()));
            this.minSizeComment = payEnterpriseSelectItem.getMinSizeComment();
            this.maxSizeComment = payEnterpriseSelectItem.getMaxSizeComment();
        }
    }

    public PayEnterpriseSelectModel.PayEnterpriseSelectItem getCostCenterItem() {
        return this.costCenterItem;
    }

    public void setCostCenterItem(PayEnterpriseSelectModel.PayEnterpriseSelectItem payEnterpriseSelectItem) {
        this.costCenterItem = payEnterpriseSelectItem;
        this.projectItem = null;
    }

    public PayEnterpriseSelectModel.PayEnterpriseSelectItem getProjectItem() {
        return this.projectItem;
    }

    public void setProjectItem(PayEnterpriseSelectModel.PayEnterpriseSelectItem payEnterpriseSelectItem) {
        this.projectItem = payEnterpriseSelectItem;
    }

    public void setRequiredState(int i, boolean z) {
        this.requiredMap.put(Integer.valueOf(i), Boolean.valueOf(z));
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public PayEnterpriseSelectModel.PayEnterpriseSelectItem getItemByType(int i) {
        if (i == 0) {
            return getCompanyItem();
        }
        if (i == 1) {
            return getCostCenterItem();
        }
        if (i != 2) {
            return null;
        }
        return getProjectItem();
    }

    public void setItemByType(int i, PayEnterpriseSelectModel.PayEnterpriseSelectItem payEnterpriseSelectItem) {
        if (i == 0) {
            setCompanyItem(payEnterpriseSelectItem);
        } else if (i == 1) {
            setCostCenterItem(payEnterpriseSelectItem);
        } else if (i == 2) {
            setProjectItem(payEnterpriseSelectItem);
        }
    }

    public boolean isRequiredCostCenter() {
        return this.requiredMap.get(1).booleanValue();
    }

    public boolean isRequiredProject() {
        return this.requiredMap.get(2).booleanValue();
    }

    public boolean isRequiredComment() {
        return this.requiredMap.get(3).booleanValue();
    }

    public int getMinSizeComment() {
        return this.minSizeComment;
    }

    public void setMinSizeComment(int i) {
        this.minSizeComment = i;
    }

    public int getMaxSizeComment() {
        return this.maxSizeComment;
    }

    public void setMaxSizeComment(int i) {
        this.maxSizeComment = i;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"remark\":\"");
        sb.append(this.comment);
        sb.append("\",\"member_id\":\"");
        sb.append(this.memberId);
        sb.append("\",\"cost_center_id\":\"");
        if (getCostCenterItem() != null) {
            sb.append(getCostCenterItem().getId());
        }
        sb.append("\",\"company_id\":\"");
        if (getCompanyItem() != null) {
            sb.append(getCompanyItem().getId());
        }
        sb.append("\",\"project_id\":\"");
        if (getProjectItem() != null) {
            sb.append(getProjectItem().getId());
        }
        sb.append("\"}");
        try {
            return URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
