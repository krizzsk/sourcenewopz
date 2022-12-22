package com.bigkoo.pickerview.utils;

import com.taxis99.R;

public class PickerViewAnimateUtil {

    /* renamed from: a */
    private static final int f2089a = -1;

    public static int getAnimationResource(int i, boolean z) {
        if (i != 80) {
            return -1;
        }
        return z ? R.anim.pickerview_slide_in_bottom : R.anim.pickerview_slide_out_bottom;
    }
}
