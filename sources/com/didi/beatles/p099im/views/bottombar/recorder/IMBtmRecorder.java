package com.didi.beatles.p099im.views.bottombar.recorder;

import android.widget.TextView;
import com.didi.beatles.p099im.views.bottombar.IMBaseBottomBar;

/* renamed from: com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorder */
public interface IMBtmRecorder {
    void bindListener(TextView textView, IMBaseBottomBar iMBaseBottomBar);

    boolean interceptBackPressed();
}
