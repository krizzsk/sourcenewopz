package com.didi.entrega.customer.service;

import android.graphics.Typeface;
import android.widget.TextView;

public interface IToolsService extends IService {

    public enum FontType {
        NORMAL,
        MEDIUM,
        BOLD,
        LIGHT
    }

    Typeface getFontTypeFace(FontType fontType);

    Typeface getFontTypeFaceForRF(int i);

    void setTypeface(TextView textView, FontType fontType);

    void setTypefaceForRF(TextView textView, int i);
}
