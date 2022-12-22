package com.didi.sdk.global.sign.view;

import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;

public interface IPayMethodListView<T> {
    void dismissProgressDialog();

    int getEnterpriseFlag();

    void showContentView();

    void showEmptyView();

    void showProgressDialog(String str);

    void updateContentView(T t, DidiGlobalPayMethodListData.Entrance entrance, EnterprisePayway enterprisePayway);
}
