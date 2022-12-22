package com.didi.unifiedPay.component.view;

import com.didi.unifiedPay.sdk.model.DeductionInfo;

public class VoucherViewConfig {
    public boolean canClick = true;
    public DeductionItemType deductionType;
    public String desc;
    public DeductionInfo info;
    public String leftDes;
    public String rightDes;
    public boolean showOrangeText = true;
    public boolean showRightIcon = true;
    public String url = "";

    public VoucherViewConfig() {
    }

    public VoucherViewConfig(String str, String str2, boolean z) {
        this.leftDes = str;
        this.rightDes = str2;
        this.showOrangeText = z;
    }

    public void showRightIcon(boolean z) {
        this.showRightIcon = z;
    }

    public void setCanClick(boolean z) {
        this.canClick = z;
    }
}
