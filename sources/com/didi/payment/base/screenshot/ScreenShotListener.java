package com.didi.payment.base.screenshot;

import kotlin.Triple;

public interface ScreenShotListener {
    void onScreenShot(Triple<Long, Integer, String> triple);
}
