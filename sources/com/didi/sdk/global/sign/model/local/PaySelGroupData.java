package com.didi.sdk.global.sign.model.local;

import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaySelGroupData {
    public AccountFreezeData accountFreezeData;
    public int[] channelIds;
    public String iconUrl;
    public List<PaySelItemData> itemList;
    public String name;

    public void setItemList(List<PaySelItemData> list, List<PaySelItemData> list2) {
        int[] iArr = this.channelIds;
        if (iArr != null && iArr.length != 0) {
            this.itemList = new ArrayList();
            for (int i : this.channelIds) {
                PaySelItemData paySelItemData = null;
                Iterator<PaySelItemData> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PaySelItemData next = it.next();
                    if (next.channelId == i) {
                        paySelItemData = next;
                        break;
                    }
                }
                if (paySelItemData != null) {
                    list2.remove(paySelItemData);
                    if (i == 150 && list != null) {
                        this.itemList.addAll(list);
                    }
                    this.itemList.add(paySelItemData);
                }
            }
            m25600a();
        }
    }

    public static PaySelGroupData createOtherGroup(List<PaySelItemData> list) {
        PaySelGroupData paySelGroupData = new PaySelGroupData();
        paySelGroupData.itemList = list;
        paySelGroupData.m25600a();
        return paySelGroupData;
    }

    /* renamed from: a */
    private void m25600a() {
        for (int i = 0; i < this.itemList.size(); i++) {
            this.itemList.get(i).groupData = this;
        }
    }

    public boolean isOtherGroup() {
        return this.channelIds == null;
    }
}
