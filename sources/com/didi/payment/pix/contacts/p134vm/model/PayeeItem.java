package com.didi.payment.pix.contacts.p134vm.model;

import com.didi.payment.pix.net.response.HistoryPixPayeeResp;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.Collection;

/* renamed from: com.didi.payment.pix.contacts.vm.model.PayeeItem */
public class PayeeItem {
    public static final int DISPLAY_STYLE_EXPAND = 1;
    public static final int DISPLAY_STYLE_FOLDER = 0;
    public final int DATA_TYPE_PAYEE = 1;
    public final int DATA_TYPE_PAYEE_GROUP = 0;
    public String cardId;
    public int childCount = 0;
    public String cpf;
    public int displayStyle = 0;
    public String icon;
    public boolean isChild = false;
    public String key;
    public String name;
    public String orgCode;
    public String pspId;
    public String pspName;
    public String showKeyByType;
    public int type;
    public int visibility = 0;

    public boolean isFoldClose() {
        return this.displayStyle == 0;
    }

    /* renamed from: a */
    private void m21843a(HistoryPixPayeeResp.Payee payee) {
        this.cpf = payee.getCpf();
        this.name = payee.getName();
        this.icon = payee.getIcon();
        this.showKeyByType = payee.showCpf;
    }

    /* renamed from: a */
    private void m21842a(HistoryPixPayeeResp.KeyInfo keyInfo) {
        this.type = keyInfo.getType().intValue();
        this.key = keyInfo.getKey();
        this.orgCode = keyInfo.getOrgCode();
        this.pspId = keyInfo.getPspId();
        this.pspName = keyInfo.getPspName();
        this.cardId = keyInfo.getCardId();
        this.showKeyByType = (keyInfo.getType().intValue() == 2 || keyInfo.getType().intValue() == 5) ? keyInfo.showCardId : keyInfo.getShowKey();
    }

    public boolean isCanExpand() {
        return this.childCount > 1;
    }

    public static PayeeItem[] convert(HistoryPixPayeeResp.Payee payee) {
        int size = (payee == null || CollectionUtil.isEmpty((Collection<?>) payee.getKeyList())) ? 0 : payee.getKeyList().size();
        if (size <= 0) {
            return new PayeeItem[0];
        }
        int i = size == 1 ? size : size + 1;
        PayeeItem[] payeeItemArr = new PayeeItem[i];
        if (i == 1) {
            PayeeItem payeeItem = new PayeeItem();
            payeeItem.m21843a(payee);
            payeeItem.m21842a(payee.getKeyList().get(0));
            payeeItem.childCount = i;
            payeeItemArr[0] = payeeItem;
        } else {
            PayeeItem payeeItem2 = new PayeeItem();
            payeeItem2.m21843a(payee);
            payeeItem2.childCount = size;
            payeeItemArr[0] = payeeItem2;
            int i2 = 1;
            for (HistoryPixPayeeResp.KeyInfo a : payee.getKeyList()) {
                PayeeItem payeeItem3 = new PayeeItem();
                payeeItem3.m21843a(payee);
                payeeItem3.m21842a(a);
                payeeItem3.isChild = true;
                payeeItem3.icon = null;
                payeeItem3.visibility = 8;
                payeeItemArr[i2] = payeeItem3;
                i2++;
            }
        }
        return payeeItemArr;
    }
}
