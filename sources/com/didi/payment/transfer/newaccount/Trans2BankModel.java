package com.didi.payment.transfer.newaccount;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trans2BankModel implements IConfirmTransferInfo {
    public String toAccountType;
    public String toAccountTypeValue;
    public String toAgentCode;
    public String toBankCard;
    public String toBankCode;
    public String toBankName;
    public String toCPF;
    public String toName;
    public String toTel;
    protected Map<String, Object> values = new HashMap();

    public List<IConfirmTransferInfo.ValueType> getChildTypeValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(IConfirmTransferInfo.ValueType.NAME);
        arrayList.add(IConfirmTransferInfo.ValueType.CPF);
        arrayList.add(IConfirmTransferInfo.ValueType.BANK_NAME);
        arrayList.add(IConfirmTransferInfo.ValueType.ACCOUNT_TYPE);
        arrayList.add(IConfirmTransferInfo.ValueType.AGENT_CODE);
        arrayList.add(IConfirmTransferInfo.ValueType.BANK_CARD);
        return arrayList;
    }

    /* renamed from: com.didi.payment.transfer.newaccount.Trans2BankModel$1 */
    static /* synthetic */ class C109591 {

        /* renamed from: $SwitchMap$com$didi$payment$transfer$fillamount$IConfirmTransferInfo$ValueType */
        static final /* synthetic */ int[] f31406x9e3d9ebc;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType[] r0 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31406x9e3d9ebc = r0
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.CPF     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_NAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_CODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_CARD     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.AGENT_CODE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.ACCOUNT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.To_TEL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f31406x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.ACCOUNT_TYPE_VALUE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.newaccount.Trans2BankModel.C109591.<clinit>():void");
        }
    }

    public String getTypekey(Context context, IConfirmTransferInfo.ValueType valueType) {
        switch (C109591.f31406x9e3d9ebc[valueType.ordinal()]) {
            case 1:
                return context.getString(R.string.GRider_PAX_Name_NVSg);
            case 2:
                return context.getString(R.string.GRider_PAX_CPF_fMMn);
            case 3:
                return context.getString(R.string.GRider_PAX_Name_of_mjpR);
            case 4:
                return context.getString(R.string.GRider_PAX_Name_of_mjpR);
            case 5:
                return context.getString(R.string.GRider_PAX_Bank_accounts_JfbH);
            case 6:
                return context.getString(R.string.GRider_PAX_Agency_code_IfjA);
            case 7:
                return context.getString(R.string.Fintech_Payment_type_Account_Type_yTPI);
            default:
                return "";
        }
    }

    public String getValueByType(IConfirmTransferInfo.ValueType valueType) {
        switch (C109591.f31406x9e3d9ebc[valueType.ordinal()]) {
            case 1:
                return !TextUtils.isEmpty(this.toName) ? this.toName : this.toTel;
            case 2:
                return this.toCPF;
            case 3:
                return this.toBankName;
            case 4:
                return this.toBankCode;
            case 5:
                return this.toBankCard;
            case 6:
                return this.toAgentCode;
            case 7:
                return this.toAccountType;
            case 8:
                return this.toTel;
            case 9:
                return this.toAccountTypeValue;
            default:
                if (this.values.containsKey(valueType.getKey())) {
                    return String.valueOf(this.values.get(valueType.getKey()));
                }
                return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        if (r0 != 8) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void setTypeValue(com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType r9, T r10) {
        /*
            r8 = this;
            int[] r0 = com.didi.payment.transfer.newaccount.Trans2BankModel.C109591.f31406x9e3d9ebc
            int r1 = r9.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x0010
            r2 = 8
            if (r0 == r2) goto L_0x0016
            goto L_0x001c
        L_0x0010:
            java.lang.String r0 = java.lang.String.valueOf(r10)
            r8.toName = r0
        L_0x0016:
            java.lang.String r0 = java.lang.String.valueOf(r10)
            r8.toTel = r0
        L_0x001c:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            java.lang.String r3 = r9.getKey()
            r0[r2] = r3
            java.lang.String r2 = java.lang.String.valueOf(r10)
            r0[r1] = r2
            java.lang.String r1 = "a k: %s with v: %s"
            java.lang.String r4 = java.lang.String.format(r1, r0)
            r2 = 3
            r5 = 0
            r7 = 106(0x6a, float:1.49E-43)
            java.lang.String r3 = "trans_tag"
            java.lang.String r6 = "com.didi.payment.transfer.newaccount.Trans2BankModel"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.values
            java.lang.String r9 = r9.getKey()
            r0.put(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.newaccount.Trans2BankModel.setTypeValue(com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType, java.lang.Object):void");
    }
}
