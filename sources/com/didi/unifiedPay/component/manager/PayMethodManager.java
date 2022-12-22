package com.didi.unifiedPay.component.manager;

import com.adyen.checkout.components.util.PaymentMethodTypes;

public class PayMethodManager {
    public static String getPayMethodFromType(int i) {
        if (i == 161) {
            return "didicredit";
        }
        if (i == 162) {
            return "spgateway";
        }
        if (i == 182) {
            return "paypay";
        }
        if (i != 183) {
            switch (i) {
                case 108:
                    return "experiencecard";
                case 115:
                    return "rechargeablecard";
                case 118:
                    return "advance";
                case 121:
                    return "firm";
                case 123:
                    return "card";
                case 144:
                    return "fastqqpay";
                case 150:
                    return "credit_card";
                case 152:
                    break;
                case 166:
                    return "ddpay";
                case 175:
                    return "oxxopay";
                case 178:
                    return "boletopay";
                case 180:
                    return "change";
                case 190:
                    return "99pay";
                case 2005:
                    return "nexttrip";
                case 9100:
                    return "familypay";
                default:
                    switch (i) {
                        case 126:
                            return "balance";
                        case 127:
                            return "wechat";
                        case 128:
                            return "alipay";
                        default:
                            switch (i) {
                                case 132:
                                    return "qqpay";
                                case 133:
                                case 134:
                                    return "fastwechat";
                                case 135:
                                    return "zsdebitcard";
                                case 136:
                                    return "fastzsdebitcard";
                                default:
                                    switch (i) {
                                        case 170:
                                            return "alipayroam";
                                        case 171:
                                            return "wechatroam";
                                        case 172:
                                            return "alipayhk";
                                        case 173:
                                            return "wechathk";
                                        default:
                                            switch (i) {
                                                case 200:
                                                    return "servipag";
                                                case 201:
                                                    return "baloto";
                                                case 202:
                                                    return "efecty";
                                                case 203:
                                                    return "rapipago";
                                                case 204:
                                                    return "pagofacil";
                                                case 205:
                                                    return "banktransaction";
                                                default:
                                                    switch (i) {
                                                        case 212:
                                                            return PaymentMethodTypes.PIX;
                                                        case 213:
                                                            return "fawry";
                                                        case 214:
                                                            return "fastbaloto";
                                                        case 215:
                                                            return "spei";
                                                        default:
                                                            return "null";
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return "paypal";
    }
}
