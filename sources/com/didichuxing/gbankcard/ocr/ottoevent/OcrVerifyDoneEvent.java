package com.didichuxing.gbankcard.ocr.ottoevent;

public class OcrVerifyDoneEvent {
    public final boolean verifyOk;

    public OcrVerifyDoneEvent(boolean z) {
        this.verifyOk = z;
    }
}
