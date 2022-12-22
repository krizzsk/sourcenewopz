package com.didi.payment.pix.contacts.p134vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.AbsRpcCallback;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.NWHttpUtil;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.HistoryPixPayeeResp;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.List;

/* renamed from: com.didi.payment.pix.contacts.vm.HistoryContacksVM */
public class HistoryContacksVM extends WBaseViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f31053a = 10;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f31054b = 0;
    public MutableLiveData<PixKeyVerifyResp.PixKeyList> doubleCheckPixAccount = new MutableLiveData<>();
    public PixNetModel netModel = new PixNetModel(getApplication());
    public MutableLiveData<List<HistoryPixPayeeResp.Payee>> payeeListLD = new MutableLiveData<>();
    public MutableLiveData<PixKeyVerifyResp.PixKeyList> verifyPixAccount = new MutableLiveData<>();
    public MutableLiveData<WBaseResp> verifyPixErr = new MutableLiveData<>();

    public HistoryContacksVM(Application application) {
        super(application);
    }

    public void loadTransContacts() {
        if (this.f31054b != -1) {
            isLoading().setValue(true);
            this.netModel.getHistoryPayee(this.f31053a, this.f31054b, new AbsRpcCallback<HistoryPixPayeeResp>(getApplication()) {
                public void onHandleSuccess(HistoryPixPayeeResp historyPixPayeeResp) {
                    HistoryContacksVM.this.isLoading().setValue(false);
                    if (historyPixPayeeResp == null || historyPixPayeeResp.data == null) {
                        HistoryContacksVM.this.isNetError().setValue(true);
                        return;
                    }
                    if (historyPixPayeeResp.data.payeeList.size() < HistoryContacksVM.this.f31053a) {
                        int unused = HistoryContacksVM.this.f31054b = -1;
                    } else {
                        int unused2 = HistoryContacksVM.this.f31054b = historyPixPayeeResp.data.getNextIndex();
                    }
                    HistoryContacksVM.this.payeeListLD.setValue(historyPixPayeeResp.data.payeeList);
                }

                public void onHandleFailure(IOException iOException) {
                    HistoryContacksVM.this.isLoading().setValue(false);
                    HistoryContacksVM.this.isNetError().setValue(true);
                }
            });
        }
    }

    public void doublecheckPixKey(String str) {
        isLoading().setValue(true);
        this.netModel.verifyPixKey(str, true, new RpcService.Callback<PixKeyVerifyResp>() {
            public void onSuccess(PixKeyVerifyResp pixKeyVerifyResp) {
                HistoryContacksVM.this.isLoading().setValue(false);
                if (!NWHttpUtil.Companion.isRespValid(pixKeyVerifyResp)) {
                    HistoryContacksVM.this.verifyPixErr.setValue(pixKeyVerifyResp);
                } else {
                    HistoryContacksVM.this.doubleCheckPixAccount.setValue((PixKeyVerifyResp.PixKeyList) pixKeyVerifyResp.data);
                }
            }

            public void onFailure(IOException iOException) {
                HistoryContacksVM.this.isLoading().setValue(false);
                HistoryContacksVM.this.verifyPixErr.setValue(new WBaseResp().onRequestFail());
            }
        });
    }

    public void checkPixKey(String str, boolean z, final boolean z2) {
        isLoading().setValue(true);
        this.netModel.verifyPixKey(str, z, new RpcService.Callback<PixKeyVerifyResp>() {
            public void onSuccess(PixKeyVerifyResp pixKeyVerifyResp) {
                HistoryContacksVM.this.isLoading().setValue(false);
                if (!NWHttpUtil.Companion.isRespValid(pixKeyVerifyResp)) {
                    HistoryContacksVM.this.verifyPixErr.setValue(pixKeyVerifyResp);
                    return;
                }
                ((PixKeyVerifyResp.PixKeyList) pixKeyVerifyResp.data).setDoubleCheck(Boolean.valueOf(z2));
                HistoryContacksVM.this.verifyPixAccount.setValue((PixKeyVerifyResp.PixKeyList) pixKeyVerifyResp.data);
            }

            public void onFailure(IOException iOException) {
                HistoryContacksVM.this.isLoading().setValue(false);
                HistoryContacksVM.this.verifyPixErr.setValue(new WBaseResp().onRequestFail());
            }
        });
    }

    public void loadData() {
        loadTransContacts();
    }
}
