package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import com.didi.sdk.audiorecorder.IGetDataServerAddressCallback;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferClient;
import com.didi.sdk.audiorecorder.utils.TextUtil;

public class CrossProcessPcm16kConsumer extends IGetDataServerAddressCallback.Stub implements DataTransferClient.DataReceivedListener {

    /* renamed from: a */
    private DataTransferClient f35470a;

    /* renamed from: b */
    private Supporter.Pcm16kConsumer f35471b;

    /* renamed from: c */
    private String f35472c;

    CrossProcessPcm16kConsumer() {
        DataTransferClient dataTransferClient = new DataTransferClient((String) null, 6400);
        this.f35470a = dataTransferClient;
        dataTransferClient.addDataReceivedListener(this);
    }

    public void setInnerConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f35471b = pcm16kConsumer;
        m25108a();
    }

    /* renamed from: a */
    private void m25108a() {
        if (this.f35471b == null || TextUtil.isEmpty(this.f35472c)) {
            m25109a((String) null);
            this.f35470a.disconnect();
            return;
        }
        this.f35470a.connect();
    }

    public void onReceived(byte[] bArr, int i) {
        Supporter.Pcm16kConsumer pcm16kConsumer = this.f35471b;
        if (pcm16kConsumer != null) {
            pcm16kConsumer.onPcm16kFeed(bArr, i);
        }
    }

    public void onGetAddress(String str) {
        m25109a(str);
        m25108a();
    }

    /* renamed from: a */
    private void m25109a(String str) {
        this.f35472c = str;
        this.f35470a.updateServerName(str);
    }
}
