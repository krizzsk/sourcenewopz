package com.didi.zxing.barcodescanner;

import android.graphics.Rect;

public interface DecodeThreadInter {
    void pause();

    void setCheckPattern(boolean z);

    void setCropRect(Rect rect);

    void setDecoder(Decoder decoder);

    void setProductId(String str);

    void start();

    void stop();
}
