package com.didi.payment.transfer.accounts.presenter;

import com.didi.payment.transfer.common.model.ConfirmInfo;
import com.didi.payment.transfer.net.TransBaseResp;
import com.google.gson.annotations.SerializedName;

public class TransVerifyAccountResp extends TransBaseResp {
    public int TYPE_99Pay = 2;
    public int TYPE_99Taxi = 1;
    public VerifyResult data;

    public class VerifyResult {
        public NNPayAccount accountInfo;
        public ConfirmInfo confirmNotice;
        public boolean firstTransfer;
        @SerializedName("accountExist")
        public boolean has99TaxiAccount;
        @SerializedName("kyc")
        public boolean hasRegiste99Pay;
        public String telInvalidMsg;
        public boolean telValid;

        public VerifyResult() {
        }

        public int getOmegaAccountVal(int i) {
            if (i == TransVerifyAccountResp.this.TYPE_99Taxi) {
                return this.has99TaxiAccount ? 1 : 0;
            }
            if (i == TransVerifyAccountResp.this.TYPE_99Pay) {
                return this.hasRegiste99Pay ? 1 : 0;
            }
            return -1;
        }
    }

    public void rebuildSelf() {
        VerifyResult verifyResult = this.data;
        if (verifyResult != null && verifyResult.accountInfo != null) {
            this.data.accountInfo.accountExist = this.data.has99TaxiAccount;
            this.data.accountInfo.account99PayExist = this.data.hasRegiste99Pay;
        }
    }
}
