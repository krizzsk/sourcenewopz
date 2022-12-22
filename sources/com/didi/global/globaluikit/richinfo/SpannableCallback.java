package com.didi.global.globaluikit.richinfo;

import android.text.SpannableString;

public interface SpannableCallback {
    boolean beforeSpannableCreated(LEGORichInfo lEGORichInfo);

    void onSpannableCreated(SpannableString spannableString);
}
