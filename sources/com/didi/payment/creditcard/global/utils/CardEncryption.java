package com.didi.payment.creditcard.global.utils;

import adyen.com.adyencse.pojo.Card;
import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.creditcard.global.model.GlobalBankCardInfo;
import com.didi.payment.creditcard.global.model.GlobalEncryptKeyInfo;
import com.didi.payment.creditcard.global.model.GlobalRiskInfo;
import com.didi.payment.creditcard.global.model.SignCardParam;
import java.util.Date;

public class CardEncryption {

    /* renamed from: a */
    private static CardEncryption f30431a;

    /* renamed from: b */
    private GlobalEncryptKeyInfo f30432b;

    /* renamed from: c */
    private String f30433c;

    /* renamed from: d */
    private String f30434d = this.f30432b.getRSAPublicKey();

    private CardEncryption() {
        GlobalEncryptKeyInfo globalEncryptKeyInfo = new GlobalEncryptKeyInfo();
        this.f30432b = globalEncryptKeyInfo;
        this.f30433c = globalEncryptKeyInfo.getAESKey();
    }

    public static CardEncryption getInstance() {
        if (f30431a == null) {
            f30431a = new CardEncryption();
        }
        return f30431a;
    }

    public String getEncryptedAesKey() {
        return this.f30432b.encryptWithRSA(this.f30433c, this.f30434d);
    }

    public String getAydenEncryptedCardInfoString(String str, String str2, String str3, String str4) {
        String a = m21403a(str3);
        String b = m21404b(str3);
        Card card = new Card();
        card.setCvc(str4);
        card.setExpiryMonth(b);
        card.setExpiryYear(a);
        card.setGenerationTime(new Date());
        card.setNumber(str2);
        card.setCardHolderName("didi");
        try {
            return card.serialize(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getOtherEncryptedCardInfoString(String str, String str2, String str3) {
        String a = m21403a(str2);
        String b = m21404b(str2);
        GlobalBankCardInfo globalBankCardInfo = new GlobalBankCardInfo();
        globalBankCardInfo.setCvc(str3);
        globalBankCardInfo.setExpiryMonth(b);
        globalBankCardInfo.setExpiryYear(a);
        globalBankCardInfo.setNumber(str);
        return globalBankCardInfo.encryptWithAES(this.f30433c);
    }

    public String getEncryptedRiskInfoString(Context context, String str, String str2, String str3, int i, boolean z, String str4, long j, String str5, SignCardParam signCardParam, String str6) {
        GlobalRiskInfo globalRiskInfo = new GlobalRiskInfo();
        globalRiskInfo.setBankCardNo(str);
        globalRiskInfo.setCardNoPrefixSuffix(str);
        globalRiskInfo.setBankAccountName("didi");
        String a = m21403a(str2);
        String b = m21404b(str2);
        globalRiskInfo.setValidDate(a + b);
        globalRiskInfo.setCvv2(str3);
        globalRiskInfo.setStayTime("" + j);
        globalRiskInfo.setBaseRiskParam(context);
        globalRiskInfo.setBankCardType("" + i);
        globalRiskInfo.setIsOcr(z);
        globalRiskInfo.setOcrContent(str4);
        globalRiskInfo.setOriginNumber(str5);
        if (signCardParam != null) {
            if (signCardParam.bindType > 0) {
                globalRiskInfo.setBindType("" + signCardParam.bindType);
            } else {
                globalRiskInfo.setBindType("5");
            }
            if (!TextUtils.isEmpty(signCardParam.orderId)) {
                globalRiskInfo.setOrderId(signCardParam.orderId);
            }
            if (!TextUtils.isEmpty(signCardParam.productLine)) {
                globalRiskInfo.setProductLine(signCardParam.productLine);
            }
            if (signCardParam.isSignAfterOrder) {
                globalRiskInfo.setSignAfterOrder(signCardParam.isSignAfterOrder);
            }
            globalRiskInfo.setResourceid(signCardParam.resourceId);
        }
        globalRiskInfo.setIsExistPaste(str6);
        return globalRiskInfo.encryptWithAES(this.f30433c);
    }

    /* renamed from: a */
    private String m21403a(String str) {
        String c = m21405c(str);
        if (c.length() != 4) {
            return "";
        }
        return "20" + c.substring(2, 4);
    }

    /* renamed from: b */
    private String m21404b(String str) {
        String c = m21405c(str);
        return c.length() == 4 ? c.substring(0, 2) : "";
    }

    /* renamed from: c */
    private String m21405c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return GlobalCreditCardFormatter.removeSymbols(str);
    }
}
