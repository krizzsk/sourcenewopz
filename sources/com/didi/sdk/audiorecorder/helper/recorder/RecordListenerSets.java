package com.didi.sdk.audiorecorder.helper.recorder;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.CopyOnWriteArrayList;

public class RecordListenerSets implements AudioRecordActionListener, AudioRecorder.RecordListener {

    /* renamed from: a */
    private CopyOnWriteArrayList<AudioRecorder.RecordListener> f35362a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    private CopyOnWriteArrayList<AudioRecordActionListener> f35363b = new CopyOnWriteArrayList<>();

    public void addRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f35362a.add(recordListener);
    }

    public void removeRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f35362a.remove(recordListener);
    }

    public void onStart() {
        for (int i = 0; i < this.f35362a.size(); i++) {
            this.f35362a.get(i).onStart();
        }
    }

    public void onResume() {
        for (int i = 0; i < this.f35362a.size(); i++) {
            this.f35362a.get(i).onResume();
        }
    }

    public void onPause() {
        for (int i = 0; i < this.f35362a.size(); i++) {
            this.f35362a.get(i).onPause();
        }
    }

    public void onStop() {
        for (int i = 0; i < this.f35362a.size(); i++) {
            this.f35362a.get(i).onStop();
        }
    }

    public void addActionListener(AudioRecordActionListener audioRecordActionListener) {
        this.f35363b.add(audioRecordActionListener);
    }

    public void removeActionListener(AudioRecordActionListener audioRecordActionListener) {
        this.f35363b.remove(audioRecordActionListener);
    }

    public void onTriggerStart() {
        for (int i = 0; i < this.f35363b.size(); i++) {
            this.f35363b.get(i).onTriggerStart();
        }
    }

    public void onTriggerResume() {
        for (int i = 0; i < this.f35363b.size(); i++) {
            this.f35363b.get(i).onTriggerResume();
        }
    }
}
