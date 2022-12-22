package com.didi.safetoolkit.business.share;

import android.view.View;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.android.didi.safetoolkit.presenter.IBaseView;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;

public interface SfIContactsView extends IBaseView {
    View findViewByIdImpl(int i);

    void finish();

    String getOrderId();

    int getThreshold();

    void requestPermission(PermissionCallback permissionCallback, String... strArr);

    void showLoading();

    void startAddAreaCodeActivity(int i, SfContactsManageModel sfContactsManageModel);

    void stopLoading();
}
