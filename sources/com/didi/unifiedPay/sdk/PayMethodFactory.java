package com.didi.unifiedPay.sdk;

import com.didi.unifiedPay.sdk.baloto.BalotoPay;
import com.didi.unifiedPay.sdk.baloto.FastBalotoPay;
import com.didi.unifiedPay.sdk.banktransaction.BankTransactionMethod;
import com.didi.unifiedPay.sdk.boleto.BoletoPay;
import com.didi.unifiedPay.sdk.change.ChangePayMethod;
import com.didi.unifiedPay.sdk.efecty.EfectyPay;
import com.didi.unifiedPay.sdk.fawry.FawryPay;
import com.didi.unifiedPay.sdk.internal.InnerPayMethod;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.model.PayParamObject;
import com.didi.unifiedPay.sdk.nexttrip.NextTripPayMethod;
import com.didi.unifiedPay.sdk.nineninepay.NineNinePay;
import com.didi.unifiedPay.sdk.oxxo.OxxoPay;
import com.didi.unifiedPay.sdk.pagofacil.PagoFacilMethod;
import com.didi.unifiedPay.sdk.paypal.PaypalMethod;
import com.didi.unifiedPay.sdk.paypay.PaypayPayMethod;
import com.didi.unifiedPay.sdk.pix.PixPayMethod;
import com.didi.unifiedPay.sdk.rapipago.RapipagoMethod;
import com.didi.unifiedPay.sdk.servipag.ServiPagPay;
import com.didi.unifiedPay.sdk.spei.SpeiMethod;
import com.didi.unifiedPay.sdk.visa.VisaPayMethod;

public class PayMethodFactory {
    public static PayMethod getMethod(PayParamObject payParamObject) {
        int i;
        if (payParamObject.thirdPayType > 0) {
            i = payParamObject.thirdPayType;
        } else {
            i = payParamObject.platformPayType > 0 ? payParamObject.platformPayType : 0;
        }
        return getMethod(i);
    }

    public static PayMethod getMethod(int i) {
        if (i == 150) {
            return new VisaPayMethod();
        }
        if (i != 152) {
            if (i == 175) {
                return new OxxoPay();
            }
            if (i == 178) {
                return new BoletoPay();
            }
            if (i == 180) {
                return new ChangePayMethod();
            }
            if (i == 190) {
                return new NineNinePay();
            }
            if (i == 2005) {
                return new NextTripPayMethod();
            }
            if (i == 182) {
                return new PaypayPayMethod();
            }
            if (i != 183) {
                switch (i) {
                    case 200:
                        return new ServiPagPay();
                    case 201:
                        return new BalotoPay();
                    case 202:
                        return new EfectyPay();
                    case 203:
                        return new RapipagoMethod();
                    case 204:
                        return new PagoFacilMethod();
                    case 205:
                        return new BankTransactionMethod();
                    default:
                        switch (i) {
                            case 212:
                                return new PixPayMethod();
                            case 213:
                                return new FawryPay();
                            case 214:
                                return new FastBalotoPay();
                            case 215:
                                return new SpeiMethod();
                            default:
                                return new InnerPayMethod();
                        }
                }
            }
        }
        return new PaypalMethod();
    }
}
