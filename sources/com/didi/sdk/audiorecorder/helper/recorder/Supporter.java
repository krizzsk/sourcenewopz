package com.didi.sdk.audiorecorder.helper.recorder;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.io.File;

public interface Supporter {

    public interface AmrConsumer {
        void onAmrFeed(byte[] bArr, int i);
    }

    public interface AmrProvider {
        void setAmrConsumer(AmrConsumer amrConsumer);
    }

    public interface ErrorObservable {
        void setOnErrorListener(AudioRecorder.OnErrorListener onErrorListener);
    }

    public interface FileConsumer extends SimpleFileConsumer {
        File getCacheDir();

        File getDefaultDir();

        boolean isDefaultDir(File file);

        void onFileFeed(File file);
    }

    public interface FileProvider {
        void setFileConsumer(FileConsumer fileConsumer);

        void sliceFile();
    }

    public interface OnOffSwitcher {
        boolean isStarted();

        void start();

        void stop();
    }

    public interface Pcm16kConsumer {
        void onPcm16kFeed(byte[] bArr, int i);

        void setPcm16kProvider(Pcm16kProvider pcm16kProvider);
    }

    public interface Pcm16kProvider {
        void addPcm16kConsumer(Pcm16kConsumer pcm16kConsumer);

        void removePcm16kConsumer(Pcm16kConsumer pcm16kConsumer);
    }

    public interface Pcm8kConsumer {
        void onPcm8kFeed(byte[] bArr, int i);
    }

    public interface Pcm8kProvider {
        void addPcm8kConsumer(Pcm8kConsumer pcm8kConsumer);

        void removePcm8kConsumer(Pcm8kConsumer pcm8kConsumer);
    }

    public interface SimpleFileConsumer {
        void onTmpFileCreated(File file);
    }
}
