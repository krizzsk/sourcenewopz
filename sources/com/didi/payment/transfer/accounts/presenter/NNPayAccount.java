package com.didi.payment.transfer.accounts.presenter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NNPayAccount implements Parcelable, IConfirmTransferInfo {
    public static final Parcelable.Creator<NNPayAccount> CREATOR = new Parcelable.Creator<NNPayAccount>() {
        public NNPayAccount createFromParcel(Parcel parcel) {
            return new NNPayAccount(parcel);
        }

        public NNPayAccount[] newArray(int i) {
            return new NNPayAccount[i];
        }
    };
    public boolean account99PayExist;
    public boolean accountExist;
    public int accountType;
    public String accountTypeLabel;
    public int amount;
    private String encodeToTel;

    /* renamed from: id */
    public String f31299id;
    public boolean localConstruct;
    public int status;
    public String toCardCode;
    public String toCardId;
    public String toCardIdSuffix;
    public String toCountryCode;
    public String toCpf;
    private String toIconSrc;
    private String toIconUrl;
    private String toName;
    public String toOrgCode;
    private String toPhone;
    private String toShowPhone;
    private String toTel;
    protected Map<String, Object> values;

    public int describeContents() {
        return 0;
    }

    public NNPayAccount() {
        this.toCountryCode = "+55";
        this.toIconSrc = "";
        this.toIconUrl = "";
        this.localConstruct = false;
        this.values = new HashMap();
    }

    protected NNPayAccount(Parcel parcel) {
        this.toCountryCode = "+55";
        this.toIconSrc = "";
        this.toIconUrl = "";
        boolean z = false;
        this.localConstruct = false;
        this.values = new HashMap();
        this.f31299id = parcel.readString();
        this.toTel = parcel.readString();
        this.toPhone = parcel.readString();
        this.encodeToTel = parcel.readString();
        this.toShowPhone = parcel.readString();
        this.toCountryCode = parcel.readString();
        this.toName = parcel.readString();
        this.toIconSrc = parcel.readString();
        this.toIconUrl = parcel.readString();
        this.toCardCode = parcel.readString();
        this.toCardId = parcel.readString();
        this.toCardIdSuffix = parcel.readString();
        this.toOrgCode = parcel.readString();
        this.toCpf = parcel.readString();
        this.amount = parcel.readInt();
        this.status = parcel.readInt();
        this.accountExist = parcel.readByte() != 0;
        this.account99PayExist = parcel.readByte() != 0;
        this.localConstruct = parcel.readByte() != 0 ? true : z;
        this.accountType = parcel.readInt();
        this.accountTypeLabel = parcel.readString();
        this.values = parcel.readHashMap(getClass().getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f31299id);
        parcel.writeString(this.toTel);
        parcel.writeString(this.toPhone);
        parcel.writeString(this.encodeToTel);
        parcel.writeString(this.toShowPhone);
        parcel.writeString(this.toCountryCode);
        parcel.writeString(this.toName);
        parcel.writeString(this.toIconSrc);
        parcel.writeString(this.toIconUrl);
        parcel.writeString(this.toCardCode);
        parcel.writeString(this.toCardId);
        parcel.writeString(this.toCardIdSuffix);
        parcel.writeString(this.toOrgCode);
        parcel.writeString(this.toCpf);
        parcel.writeInt(this.amount);
        parcel.writeInt(this.status);
        parcel.writeByte(this.accountExist ? (byte) 1 : 0);
        parcel.writeByte(this.account99PayExist ? (byte) 1 : 0);
        parcel.writeByte(this.localConstruct ? (byte) 1 : 0);
        parcel.writeInt(this.accountType);
        parcel.writeString(this.accountTypeLabel);
        parcel.writeMap(this.values);
    }

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

    /* renamed from: com.didi.payment.transfer.accounts.presenter.NNPayAccount$2 */
    static /* synthetic */ class C108872 {

        /* renamed from: $SwitchMap$com$didi$payment$transfer$fillamount$IConfirmTransferInfo$ValueType */
        static final /* synthetic */ int[] f31300x9e3d9ebc;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType[] r0 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31300x9e3d9ebc = r0
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.CPF     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_NAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_CODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_CARD     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.AGENT_CODE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.ACCOUNT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.To_TEL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.To_CountryCode     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.To_IconURL     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.HEAD_ICON     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Account_Exist     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Account99_Exist     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.To_Show_Phone     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f31300x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.ACCOUNT_TYPE_VALUE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.accounts.presenter.NNPayAccount.C108872.<clinit>():void");
        }
    }

    public String getTypekey(Context context, IConfirmTransferInfo.ValueType valueType) {
        switch (C108872.f31300x9e3d9ebc[valueType.ordinal()]) {
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
        switch (C108872.f31300x9e3d9ebc[valueType.ordinal()]) {
            case 1:
                if (!TextUtils.isEmpty(this.toName)) {
                    return this.toName;
                }
                return !TextUtil.isEmpty(this.toTel) ? this.toTel : this.toPhone;
            case 2:
                return this.toCpf;
            case 4:
                return this.toCardCode;
            case 5:
                return this.toCardId;
            case 6:
                return this.toOrgCode;
            case 7:
                return this.accountTypeLabel;
            case 8:
                if (!TextUtils.isEmpty(this.encodeToTel)) {
                    return this.encodeToTel;
                }
                return !TextUtil.isEmpty(this.toTel) ? this.toTel : this.toPhone;
            case 9:
                return this.toCountryCode;
            case 10:
            case 11:
                return !TextUtil.isEmpty(this.toIconSrc) ? this.toIconSrc : this.toIconUrl;
            case 12:
                return String.valueOf(this.accountExist);
            case 13:
                return String.valueOf(this.account99PayExist);
            case 14:
                if (!TextUtils.isEmpty(this.toShowPhone)) {
                    return this.toShowPhone;
                }
                return !TextUtil.isEmpty(this.toTel) ? this.toTel : this.toPhone;
            case 15:
                return String.valueOf(this.accountType);
            default:
                if (this.values.containsKey(valueType.getKey())) {
                    return String.valueOf(this.values.get(valueType.getKey()));
                }
                return "";
        }
    }

    public <T> void setTypeValue(IConfirmTransferInfo.ValueType valueType, T t) {
        int i = C108872.f31300x9e3d9ebc[valueType.ordinal()];
        if (i == 8) {
            this.toTel = String.valueOf(t);
        } else if (i != 12) {
            if (i != 13) {
                SystemUtils.log(3, "trans_tag", String.format("a k: %s with v: %s", new Object[]{valueType.getKey(), String.valueOf(t)}), (Throwable) null, "com.didi.payment.transfer.accounts.presenter.NNPayAccount", 218);
                this.values.put(valueType.getKey(), t);
                return;
            }
            this.account99PayExist = Boolean.parseBoolean(String.valueOf(t));
            return;
        }
        this.accountExist = Boolean.parseBoolean(String.valueOf(t));
    }
}
