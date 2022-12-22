package com.didi.unifiedPay.component.presenter;

import android.content.Intent;
import android.os.Bundle;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.view.IView;

public interface IPresenter<V extends IView> {
    void onActivityResult(int i, int i2, Intent intent);

    void onAdd(Bundle bundle);

    void onBackHome(Bundle bundle);

    boolean onBackPressed(BackKeyType backKeyType);

    void onLeaveHome();

    void onPageHide();

    void onPagePause();

    void onPageResume();

    void onPageShow();

    void onPageStart();

    void onPageStop();

    void onRemove();

    void setIView(V v);

    void startActivityForResult(Intent intent, int i);
}
