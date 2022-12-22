package com.didi.sdk.audiorecorder.speechdetect;

import android.content.Context;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.AmrEncoder;
import com.didi.sdk.audiorecorder.helper.recorder.modules.AmrFileWriter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.PcmRecorder;

public class SpeechDetectorWrapper {
    public void clearTtsDataCache() {
    }

    public void connectToTtsServer(String str) {
    }

    public void onPcmFeed(byte[] bArr, int i) {
    }

    public void setDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
    }

    public void setPcm8kConsumer(Supporter.Pcm8kConsumer pcm8kConsumer) {
    }

    public void start() {
    }

    public void stop() {
    }

    public void updateParams(String str) {
    }

    public SpeechDetectorWrapper(Context context) {
    }

    public void buildRelations(PcmRecorder pcmRecorder, AmrEncoder amrEncoder, AmrFileWriter amrFileWriter) {
        pcmRecorder.addPcm8kConsumer(amrEncoder);
        amrEncoder.setAmrConsumer(amrFileWriter);
    }
}
