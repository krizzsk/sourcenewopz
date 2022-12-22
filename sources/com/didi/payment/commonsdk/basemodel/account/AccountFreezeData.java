package com.didi.payment.commonsdk.basemodel.account;

import android.text.TextUtils;
import com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AccountFreezeData implements IAccountFreezeData, Serializable {
    public String desc;
    @SerializedName("dialog")
    public Dialog dialogData;
    public Map<String, Object> extraData;
    public int freezeStatus = 0;
    public boolean isSelected = true;
    @SerializedName("linkUrl")
    public String link;
    public String subTitle;
    public String title;

    public interface BuilderEx extends IAccountFreezeData.IBuilder<AccountFreezeData> {
        BuilderEx btnNeg(String str);

        BuilderEx btnPos(String str);

        <T> BuilderEx putExtra(String str, T t);
    }

    public <T> void putExtraData(String str, T t) {
    }

    public static class Dialog implements Serializable {
        public String btnNeg;
        public String btnPos;
        public String desc;
        @SerializedName("buttonLink")
        public String landingUrl;
        public String title;

        public boolean isValid() {
            return !TextUtils.isEmpty(this.title);
        }
    }

    public void textTrim() {
        if (!TextUtils.isEmpty(this.title)) {
            this.title = this.title.trim();
        }
        if (!TextUtils.isEmpty(this.subTitle)) {
            this.subTitle = this.subTitle.trim();
        }
        if (!TextUtils.isEmpty(this.desc)) {
            this.desc = this.desc.trim();
        }
    }

    public String getTitle(int i) {
        Dialog dialog;
        if (i == 0) {
            return this.title;
        }
        if (i != 1 || (dialog = this.dialogData) == null) {
            return "";
        }
        return dialog.title;
    }

    public String getSubTitle(int i) {
        Dialog dialog;
        if (i == 0) {
            return this.subTitle;
        }
        if (i != 1 || (dialog = this.dialogData) == null) {
            return "";
        }
        return dialog.desc;
    }

    public String getPosBtnText() {
        Dialog dialog = this.dialogData;
        return (dialog == null || TextUtils.isEmpty(dialog.btnPos)) ? "" : this.dialogData.btnPos;
    }

    public String getNegBtnText() {
        Dialog dialog = this.dialogData;
        return (dialog == null || TextUtils.isEmpty(dialog.btnPos)) ? "" : this.dialogData.btnPos;
    }

    public String getLink(int i) {
        if (i != 1) {
            return this.link;
        }
        Dialog dialog = this.dialogData;
        return (dialog == null || TextUtils.isEmpty(dialog.landingUrl)) ? this.link : this.dialogData.landingUrl;
    }

    public boolean isFrozen() {
        return this.freezeStatus != 0;
    }

    public boolean isJumpable(int i) {
        if (i == 0) {
            return !TextUtils.isEmpty(this.link);
        }
        if (i != 1) {
            return false;
        }
        Dialog dialog = this.dialogData;
        return (dialog != null && !TextUtils.isEmpty(dialog.landingUrl)) || !TextUtils.isEmpty(this.link);
    }

    /* renamed from: com.didi.payment.commonsdk.basemodel.account.AccountFreezeData$1 */
    static /* synthetic */ class C105611 {

        /* renamed from: $SwitchMap$com$didi$payment$commonsdk$basemodel$account$IAccountFreezeData$DataType */
        static final /* synthetic */ int[] f30144x93321fd6;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData$DataType[] r0 = com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData.DataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30144x93321fd6 = r0
                com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData$DataType r1 = com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData.DataType.TYPE_BTN_POS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30144x93321fd6     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData$DataType r1 = com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData.DataType.TYPE_BTN_NEG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.commonsdk.basemodel.account.AccountFreezeData.C105611.<clinit>():void");
        }
    }

    public String getText(IAccountFreezeData.DataType dataType) {
        Dialog dialog;
        int i = C105611.f30144x93321fd6[dataType.ordinal()];
        if (i == 1) {
            Dialog dialog2 = this.dialogData;
            if (dialog2 == null || TextUtils.isEmpty(dialog2.btnPos)) {
                return "";
            }
            return this.dialogData.btnPos;
        } else if (i == 2 && (dialog = this.dialogData) != null && !TextUtils.isEmpty(dialog.btnNeg)) {
            return this.dialogData.btnNeg;
        } else {
            return "";
        }
    }

    public Map<String, Object> getExtras() {
        if (this.extraData == null) {
            this.extraData = new HashMap();
        }
        return this.extraData;
    }

    public void putExtras(Map<String, Object> map) {
        if (this.extraData == null) {
            this.extraData = new HashMap();
        }
        this.extraData.putAll(map);
    }

    public void putIntExtra(String str, int i) {
        if (this.extraData == null) {
            this.extraData = new HashMap();
        }
        this.extraData.put(str, Integer.valueOf(i));
    }

    public void putStringExtra(String str, String str2) {
        if (this.extraData == null) {
            this.extraData = new HashMap();
        }
        this.extraData.put(str, str2);
    }

    public static class Builder implements BuilderEx {
        private AccountFreezeData mOrigin;

        private Builder(AccountFreezeData accountFreezeData) {
            this.mOrigin = accountFreezeData == null ? new AccountFreezeData() : accountFreezeData;
        }

        public static Builder from(AccountFreezeData accountFreezeData) {
            if (accountFreezeData != null) {
                return new Builder(accountFreezeData);
            }
            throw new IllegalArgumentException("param origin obj can't be Null!");
        }

        public Builder btnPos(String str) {
            AccountFreezeData accountFreezeData = this.mOrigin;
            if (!(accountFreezeData == null || accountFreezeData.dialogData == null)) {
                this.mOrigin.dialogData.btnPos = str;
            }
            return this;
        }

        public Builder btnNeg(String str) {
            AccountFreezeData accountFreezeData = this.mOrigin;
            if (!(accountFreezeData == null || accountFreezeData.dialogData == null)) {
                this.mOrigin.dialogData.btnNeg = str;
            }
            return this;
        }

        public <T> BuilderEx putExtra(String str, T t) {
            AccountFreezeData accountFreezeData = this.mOrigin;
            if (accountFreezeData != null && accountFreezeData.extraData == null) {
                this.mOrigin.extraData = new HashMap();
            }
            this.mOrigin.extraData.put(str, String.valueOf(t));
            return this;
        }

        public AccountFreezeData build() {
            return this.mOrigin;
        }
    }

    public boolean isBannerValid() {
        return this.freezeStatus != 0 && !TextUtils.isEmpty(this.title);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.dialogData;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isDialogValid() {
        /*
            r1 = this;
            int r0 = r1.freezeStatus
            if (r0 == 0) goto L_0x0010
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData$Dialog r0 = r1.dialogData
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.commonsdk.basemodel.account.AccountFreezeData.isDialogValid():boolean");
    }

    public boolean isBlocked() {
        return this.freezeStatus == 3;
    }
}
