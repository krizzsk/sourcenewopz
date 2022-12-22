package com.didi.kefu;

import android.content.Context;
import android.os.Bundle;
import com.didi.speech.android.CFun;
import com.didi.speech.asr.AsrLogger;
import com.didi.speech.asr.IPlay;
import com.didi.speech.asr.MediaFilePlay;
import com.didi.speech.asr.vadJni;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class SpeechCorpus {
    private static final String FILE_PREFIX = "asr_speech_";
    public static final String KEY_FILE_LENGTH = "file_length";
    public static final String KEY_FILE_SID = "file_sid";
    private static final String TAG = "Corpus";
    private static final vadJni jni = new vadJni();
    private static final IPlay player = new MediaFilePlay(false);
    private final String corpusDir;
    private String fileSid;
    private final Bundle mParam;
    private final String transferFilePath;

    public SpeechCorpus(Context context) {
        this(context, (Bundle) null);
    }

    public SpeechCorpus(Context context, Bundle bundle) {
        this.mParam = bundle;
        this.corpusDir = context.getCacheDir().getAbsolutePath() + "/asr-speech-corpus/";
        File file = new File(this.corpusDir);
        if (!file.exists()) {
            file.mkdir();
        }
        this.transferFilePath = this.corpusDir + "tmp.pcm";
        File file2 = new File(this.transferFilePath);
        if (file2.exists()) {
            file2.delete();
        }
    }

    public String getTransFilePath() {
        return this.transferFilePath;
    }

    public float getTransFileLength() {
        int intValue = ((Integer) this.mParam.get("audio.sample")).intValue();
        File file = new File(this.transferFilePath);
        if (file.exists()) {
            return (float) (((double) file.length()) / (((double) intValue) * 2.0d));
        }
        return 0.0f;
    }

    public String getFileSid() {
        return this.fileSid;
    }

    public boolean save(String str) {
        int i;
        this.fileSid = str;
        if (getTransFileLength() <= 0.0f) {
            return false;
        }
        int intValue = ((Integer) this.mParam.get("audio.sample")).intValue();
        jni.mp3Free();
        jni.mp3Initial(intValue);
        try {
            deleteInvalid(new File(this.corpusDir));
            File file = new File(this.transferFilePath);
            File file2 = new File(this.corpusDir + FILE_PREFIX + str + ".mp3");
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            byte[] bArr = new byte[4096];
            byte[] bArr2 = new byte[8192];
            do {
                int read = fileInputStream.read(bArr);
                short[] sArr = null;
                if (read >= 2) {
                    byte[] bArr3 = new byte[read];
                    System.arraycopy(bArr, 0, bArr3, 0, read);
                    sArr = CFun.byteToShortArray(bArr3);
                    i = sArr.length;
                } else {
                    i = 0;
                }
                int mp3Write = jni.mp3Write(sArr, i, bArr2, 8192);
                AsrLogger.d(TAG, "data in byte: " + read + ", mp3 in byte: " + mp3Write);
                fileOutputStream.write(bArr2, 0, mp3Write);
            } while (i > 0);
            fileOutputStream.close();
            fileInputStream.close();
            jni.mp3Free();
            AsrLogger.d(TAG, "inFile :" + file.getAbsolutePath() + ", length = " + file.length());
            AsrLogger.d(TAG, "outFile :" + file2.getAbsolutePath() + ", length = " + file2.length());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void play(String str) {
        try {
            if (!player.isStop()) {
                player.stop();
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        player.play(this.corpusDir + FILE_PREFIX + str + ".mp3");
    }

    public void stop() {
        player.stop();
    }

    public boolean isStop() {
        return player.isStop();
    }

    private void deleteInvalid(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].getName().startsWith(FILE_PREFIX)) {
                    arrayList.add(listFiles[i]);
                }
            }
            Collections.sort(arrayList, new Comparator<File>() {
                public int compare(File file, File file2) {
                    if (file.equals(file2)) {
                        return 0;
                    }
                    return file.lastModified() < file2.lastModified() ? -1 : 1;
                }
            });
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file2 = (File) it.next();
                if ((System.currentTimeMillis() / 1000) - (file2.lastModified() / 1000) <= 604800) {
                    break;
                }
                file2.delete();
                it.remove();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                File file3 = (File) it2.next();
                if (arrayList.size() > 100) {
                    file3.delete();
                    it2.remove();
                } else {
                    return;
                }
            }
        }
    }
}
