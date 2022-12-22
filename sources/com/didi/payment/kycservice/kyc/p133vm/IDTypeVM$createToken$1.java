package com.didi.payment.kycservice.kyc.p133vm;

import android.content.Context;
import android.content.res.Resources;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.spi.DDCustomViewData;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.net.response.JumioCreateResultResp;
import com.taxis99.R;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/IDTypeVM$createToken$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM$createToken$1 */
/* compiled from: IDTypeVM.kt */
public final class IDTypeVM$createToken$1 extends WNetCallback<JumioCreateResultResp> {
    final /* synthetic */ IDTypeVM this$0;

    IDTypeVM$createToken$1(IDTypeVM iDTypeVM) {
        this.this$0 = iDTypeVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
        this.this$0.isNetError().setValue(false);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(JumioCreateResultResp jumioCreateResultResp) {
        GuidesInfoResp.ExitDetail exitDetail;
        String secondBtn;
        String str;
        GuidesInfoResp.ExitDetail exitDetail2;
        String str2;
        GuidesInfoResp.ExitDetail exitDetail3;
        String str3;
        GuidesInfoResp.ExitDetail exitDetail4;
        Intrinsics.checkNotNullParameter(jumioCreateResultResp, "response");
        super.onSuccess(jumioCreateResultResp);
        if (jumioCreateResultResp.errno != 0) {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), jumioCreateResultResp.errmsg);
            return;
        }
        JumioCreateResultResp.Data data = jumioCreateResultResp.getData();
        if (data != null) {
            this.this$0.getJumioCreateData().setValue(data);
            DDCustomViewData dDCustomViewData = DDCustomViewData.INSTANCE;
            JumioCreateResultResp.Data data2 = jumioCreateResultResp.getData();
            List<String> list = null;
            dDCustomViewData.setTipsTitle(data2 == null ? null : data2.getTipsTitle());
            DDCustomViewData dDCustomViewData2 = DDCustomViewData.INSTANCE;
            JumioCreateResultResp.Data data3 = jumioCreateResultResp.getData();
            if (data3 != null) {
                list = data3.getTipsList();
            }
            dDCustomViewData2.setTipsList(list);
            DDCustomViewData.ExitDetail exitDetail5 = DDCustomViewData.INSTANCE.getExitDetail();
            String str4 = "";
            if (exitDetail5 != null) {
                JumioCreateResultResp.Data data4 = jumioCreateResultResp.getData();
                if (data4 == null || (exitDetail4 = data4.getExitDetail()) == null || (str3 = exitDetail4.getTitle()) == null) {
                    str3 = str4;
                }
                exitDetail5.setTitle(str3);
            }
            DDCustomViewData.ExitDetail exitDetail6 = DDCustomViewData.INSTANCE.getExitDetail();
            if (exitDetail6 != null) {
                JumioCreateResultResp.Data data5 = jumioCreateResultResp.getData();
                if (data5 == null || (exitDetail3 = data5.getExitDetail()) == null || (str2 = exitDetail3.getSubTitle()) == null) {
                    str2 = str4;
                }
                exitDetail6.setSubTitle(str2);
            }
            DDCustomViewData.ExitDetail exitDetail7 = DDCustomViewData.INSTANCE.getExitDetail();
            if (exitDetail7 != null) {
                JumioCreateResultResp.Data data6 = jumioCreateResultResp.getData();
                if (data6 == null || (exitDetail2 = data6.getExitDetail()) == null || (str = exitDetail2.getFirstBtn()) == null) {
                    str = str4;
                }
                exitDetail7.setFirstBtn(str);
            }
            DDCustomViewData.ExitDetail exitDetail8 = DDCustomViewData.INSTANCE.getExitDetail();
            if (exitDetail8 != null) {
                JumioCreateResultResp.Data data7 = jumioCreateResultResp.getData();
                if (!(data7 == null || (exitDetail = data7.getExitDetail()) == null || (secondBtn = exitDetail.getSecondBtn()) == null)) {
                    str4 = secondBtn;
                }
                exitDetail8.setSecondBtn(str4);
            }
        }
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isNetError().setValue(true);
        Context application = this.this$0.getApplication();
        Resources resources = this.this$0.getApplication().getResources();
        WalletToastNew.showFailedMsg(application, resources == null ? null : resources.getString(R.string.Others_APP_Network_exception_UfeG));
    }
}
