package com.microblink.blinkbarcode.fragment.overlay.components.statusmsg;

import android.widget.TextView;

/* compiled from: line */
public interface StatusTextStyler {

    /* compiled from: line */
    public static class Default implements StatusTextStyler {
        public int llIIlIlIIl;

        public Default(int i) {
            this.llIIlIlIIl = i;
        }

        public void applyStyle(TextView textView) {
            textView.setTextAppearance(textView.getContext(), this.llIIlIlIIl);
        }
    }

    void applyStyle(TextView textView);
}
