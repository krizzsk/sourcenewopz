package com.didi.component.openride.newscan;

import com.didi.travel.psnger.model.response.PinCodeInfoResult;

public interface IQRScannerView {
    void dismissRequestLoadingDialog();

    void finishWithResultOk();

    void scanResume();

    void showNotRequireQRCodeToast();

    void showPop(PinCodeInfoResult pinCodeInfoResult);

    void showRequestFailedToast(PinCodeInfoResult pinCodeInfoResult);

    void showRequestLoadingDialog();
}
