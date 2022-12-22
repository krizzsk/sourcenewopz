package com.didi.zxing.barcodescanner;

public interface LumListener {
    int frequency();

    void onLumChange(int i);
}
