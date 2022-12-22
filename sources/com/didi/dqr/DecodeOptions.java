package com.didi.dqr;

import android.graphics.Rect;
import java.util.Collection;
import java.util.Map;

public class DecodeOptions {
    public IAutoZoomListener autoZoomListener;
    public Map<DecodeHintType, ?> baseHints;
    public BinarizerEnum binarizer = BinarizerEnum.CommixtureWithOpenCV;
    public String characterSet;
    public Collection<BarcodeFormat> decodeFormats;
    public boolean needBitmap = false;
    public Rect prevRect;

    public interface IAutoZoomListener {
        boolean autoZoom(Rect rect, float f);
    }
}
