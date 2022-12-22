package com.didi.sdk.global.enterprise.contract;

import android.content.Context;
import com.didi.sdk.global.enterprise.model.data.EnterpriseItem;
import java.util.List;

@Deprecated
public interface EnterprisePaymentListContract {

    public interface Presenter {
        void requestCompanyList(String str, String str2);

        void requestCostCenterList(String str, String str2);

        void requestProjectList(String str, String str2, String str3);
    }

    public interface View {
        void dismissLoadingDialog();

        Context getContext();

        void refreshList(List<EnterpriseItem> list);

        void showLoadingDialog(String str);

        void showToast(String str);
    }
}
