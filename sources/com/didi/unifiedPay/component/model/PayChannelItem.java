package com.didi.unifiedPay.component.model;

import java.io.Serializable;

public class PayChannelItem extends PayItem implements Serializable {
    public boolean canCancel;
    public int card_status;
    public String deposit_msg;
    public String detail;
    public DownGradeInfo downGradeInfo;
    public int expired;
    public String expired_desc;
    public String flags;
    public String iconUrl;
    public boolean isHide;
    public boolean is_new_channel;
    public String marketing_text;
    public String payName;
    public String payNumber;
    public CharSequence selfInputDetail;
    public String status_desc;
    public String subChannelId;
    public String sub_id;
    public String sub_name;

    public PayChannelItem() {
    }

    public PayChannelItem(int i, String str, String str2) {
        this.channelId = i;
        this.payName = str;
        this.detail = str2;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PayChannelItem) && ((PayChannelItem) obj).channelId == this.channelId) {
            return true;
        }
        return false;
    }
}
