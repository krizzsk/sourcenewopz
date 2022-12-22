package com.microblink.blinkbarcode.entities.recognizers;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.intent.llIIlIlIIl;
import java.util.List;

/* compiled from: line */
public class RecognizerBundle extends llIIlIlIIl<RecognizerBundle> {
    public static final Parcelable.Creator<RecognizerBundle> CREATOR = new Parcelable.Creator<RecognizerBundle>() {
        public RecognizerBundle createFromParcel(Parcel parcel) {
            return new RecognizerBundle(parcel);
        }

        public RecognizerBundle[] newArray(int i) {
            return new RecognizerBundle[i];
        }
    };
    public static final int TIMEOUT_INFINITY = 0;
    private RecognitionDebugMode IlIllIlIIl;
    private FrameQualityEstimationMode IllIIIIllI;
    private boolean IllIIIllII;
    private Recognizer<Recognizer.Result>[] lIlIIIIlIl;
    private int llIIIlllll;

    /* compiled from: line */
    public enum FrameQualityEstimationMode {
        AUTOMATIC,
        ALWAYS_ON,
        ALWAYS_OFF
    }

    /* compiled from: line */
    public enum RecognitionDebugMode {
        RECOGNITION,
        RECOGNITION_TEST,
        DETECTION_TEST
    }

    public static final RecognizerBundle createFromIntent(Intent intent) {
        RecognizerBundle recognizerBundle = new RecognizerBundle(new Recognizer[0]);
        if (!recognizerBundle.existsInIntent(intent)) {
            return null;
        }
        recognizerBundle.loadFromIntent(intent);
        return recognizerBundle;
    }

    public String IlIllIlIIl() {
        return "com.microblink.blinkbarcode.intent.constants.RecognizerBundle.id";
    }

    public boolean equals(Object obj) {
        RecognizerBundle recognizerBundle;
        if (obj != null && (obj instanceof RecognizerBundle) && this == (recognizerBundle = (RecognizerBundle) obj) && this.lIlIIIIlIl == recognizerBundle.lIlIIIIlIl) {
            return true;
        }
        return false;
    }

    public FrameQualityEstimationMode getFrameQualityEstimationMode() {
        return this.IllIIIIllI;
    }

    public int getNumMsBeforeTimeout() {
        return this.llIIIlllll;
    }

    public RecognitionDebugMode getRecognitionDebugMode() {
        return this.IlIllIlIIl;
    }

    public Recognizer<Recognizer.Result>[] getRecognizers() {
        return this.lIlIIIIlIl;
    }

    public void llIIlIlIIl(llIIlIlIIl lliililiil) {
        RecognizerBundle recognizerBundle = (RecognizerBundle) lliililiil;
        this.IlIllIlIIl = recognizerBundle.IlIllIlIIl;
        this.IllIIIllII = recognizerBundle.IllIIIllII;
        this.llIIIlllll = recognizerBundle.llIIIlllll;
        this.IllIIIIllI = recognizerBundle.IllIIIIllI;
        Recognizer<Recognizer.Result>[] recognizerArr = this.lIlIIIIlIl;
        int i = 0;
        if (recognizerArr.length == 0) {
            this.lIlIIIIlIl = new Recognizer[recognizerBundle.lIlIIIIlIl.length];
            while (true) {
                Recognizer<Recognizer.Result>[] recognizerArr2 = this.lIlIIIIlIl;
                if (i < recognizerArr2.length) {
                    recognizerArr2[i] = recognizerBundle.lIlIIIIlIl[i];
                    i++;
                } else {
                    return;
                }
            }
        } else if (recognizerBundle.lIlIIIIlIl.length == recognizerArr.length) {
            while (true) {
                Recognizer<Recognizer.Result>[] recognizerArr3 = this.lIlIIIIlIl;
                if (i < recognizerArr3.length) {
                    recognizerArr3[i].consumeResultFrom(recognizerBundle.lIlIIIIlIl[i]);
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Incompatible RecognizerBundle loaded.");
        }
    }

    public void saveToIntent(Intent intent) {
        Recognizer<Recognizer.Result>[] recognizerArr = this.lIlIIIIlIl;
        if (recognizerArr == null || recognizerArr.length == 0) {
            throw new IllegalStateException("Unable to save bundle without recognizers!");
        }
        super.saveToIntent(intent);
    }

    public void setAllowMultipleScanResultsOnSingleImage(boolean z) {
        this.IllIIIllII = z;
    }

    public void setFrameQualityEstimationMode(FrameQualityEstimationMode frameQualityEstimationMode) {
        this.IllIIIIllI = frameQualityEstimationMode;
    }

    public void setNumMsBeforeTimeout(int i) {
        this.llIIIlllll = i;
    }

    public void setRecognitionDebugMode(RecognitionDebugMode recognitionDebugMode) {
        this.IlIllIlIIl = recognitionDebugMode;
    }

    public boolean shouldAllowMultipleScanResultsOnSingleImage() {
        return this.IllIIIllII;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Recognizer<Recognizer.Result>[] recognizerArr = this.lIlIIIIlIl;
        if (recognizerArr == null || recognizerArr.length <= 0) {
            throw new IllegalStateException("Unable to parcelize bundle without recognizers!");
        }
        parcel.writeParcelableArray(recognizerArr, 0);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.IlIllIlIIl.ordinal());
        parcel.writeByte(this.IllIIIllII ? (byte) 1 : 0);
        parcel.writeInt(this.llIIIlllll);
        parcel.writeInt(this.IllIIIIllI.ordinal());
    }

    public RecognizerBundle(Recognizer... recognizerArr) {
        this.IlIllIlIIl = RecognitionDebugMode.RECOGNITION;
        this.IllIIIllII = true;
        int i = 0;
        this.llIIIlllll = 0;
        this.IllIIIIllI = FrameQualityEstimationMode.AUTOMATIC;
        this.lIlIIIIlIl = recognizerArr;
        int length = recognizerArr.length;
        while (i < length) {
            if (recognizerArr[i] != null) {
                i++;
            } else {
                throw new IllegalArgumentException("It is not allowed to pass null recognizer to RecognizerBundle.");
            }
        }
    }

    public RecognizerBundle(List<Recognizer> list) {
        this.IlIllIlIIl = RecognitionDebugMode.RECOGNITION;
        this.IllIIIllII = true;
        int i = 0;
        this.llIIIlllll = 0;
        this.IllIIIIllI = FrameQualityEstimationMode.AUTOMATIC;
        Recognizer<Recognizer.Result>[] recognizerArr = (Recognizer[]) list.toArray(new Recognizer[list.size()]);
        this.lIlIIIIlIl = recognizerArr;
        int length = recognizerArr.length;
        while (i < length) {
            if (recognizerArr[i] != null) {
                i++;
            } else {
                throw new IllegalArgumentException("It is not allowed to pass null recognizer to RecognizerBundle.");
            }
        }
    }

    public Parcelable.Creator<RecognizerBundle> llIIlIlIIl() {
        return CREATOR;
    }

    public void llIIlIlIIl(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(RecognizerBundle.class.getClassLoader());
        this.lIlIIIIlIl = new Recognizer[readParcelableArray.length];
        boolean z = false;
        int i = 0;
        while (true) {
            Recognizer<Recognizer.Result>[] recognizerArr = this.lIlIIIIlIl;
            if (i >= recognizerArr.length) {
                break;
            }
            recognizerArr[i] = (Recognizer) readParcelableArray[i];
            i++;
        }
        super.llIIlIlIIl(parcel);
        this.IlIllIlIIl = RecognitionDebugMode.values()[parcel.readInt()];
        if (parcel.readByte() == 1) {
            z = true;
        }
        this.IllIIIllII = z;
        this.llIIIlllll = parcel.readInt();
        this.IllIIIIllI = FrameQualityEstimationMode.values()[parcel.readInt()];
    }

    private RecognizerBundle(Parcel parcel) {
        this.IlIllIlIIl = RecognitionDebugMode.RECOGNITION;
        this.IllIIIllII = true;
        this.llIIIlllll = 0;
        this.IllIIIIllI = FrameQualityEstimationMode.AUTOMATIC;
        llIIlIlIIl(parcel);
    }
}
