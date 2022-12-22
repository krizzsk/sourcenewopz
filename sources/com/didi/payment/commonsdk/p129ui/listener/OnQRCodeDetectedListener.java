package com.didi.payment.commonsdk.p129ui.listener;

import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;

/* renamed from: com.didi.payment.commonsdk.ui.listener.OnQRCodeDetectedListener */
public interface OnQRCodeDetectedListener {
    void onQRCodeDetected(PixQrCodeQueryResp.QRCodeData qRCodeData);
}
