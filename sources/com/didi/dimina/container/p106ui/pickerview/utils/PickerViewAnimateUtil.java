package com.didi.dimina.container.p106ui.pickerview.utils;

import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.pickerview.utils.PickerViewAnimateUtil */
public class PickerViewAnimateUtil {

    /* renamed from: a */
    private static final int f17598a = -1;

    public static int getAnimationResource(int i, boolean z) {
        if (i != 80) {
            return -1;
        }
        return z ? R.anim.dimina_pickerview_slide_in_bottom : R.anim.dimina_pickerview_slide_out_bottom;
    }
}
