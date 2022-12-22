package com.didi.sdk.audiorecorder.service.mainprocess;

import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl;
import com.didi.sdk.audiorecorder.model.AudioRecordContextParcel;
import com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer;

class MainProcessRecordService$1 implements DataTransferServer.AcquireServerNameCallback {
    final /* synthetic */ C12088b this$0;
    final /* synthetic */ String val$businessAlias;
    final /* synthetic */ AudioRecordContext val$recordContext;

    MainProcessRecordService$1(C12088b bVar, AudioRecordContext audioRecordContext, String str) {
        this.this$0 = bVar;
        this.val$recordContext = audioRecordContext;
        this.val$businessAlias = str;
    }

    public void onAcquired(String str) {
        AudioRecorderImpl a = this.this$0.f35446a;
        AudioRecordContext audioRecordContext = this.val$recordContext;
        a.update(audioRecordContext, (AudioRecordContextParcel) null, this.val$businessAlias, audioRecordContext.isBluetoothRecordEnable(), this.val$recordContext.getAudioCacheDir(), str);
    }
}
