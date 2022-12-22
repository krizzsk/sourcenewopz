package com.didi.zxing.scan.callback;

import com.didi.zxing.barcodescanner.BarcodeResult;

public interface IQrCodeOperation {

    public interface IBarcodeCallback {
        void onBarCodeResult(BarcodeResult barcodeResult);
    }

    public interface IScannerLoadingView {
        int getScannerLoadingResId();

        void hideScannerLoading();

        void initScannerLoading();
    }

    public interface ITorchStateChangedListener {
        void onTorchStateChanged(boolean z);
    }
}
