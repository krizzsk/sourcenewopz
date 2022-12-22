package com.didi.security.wireless.adapter;

import android.content.Context;
import com.didichuxing.security.challenge.DiChallenge;

public class DiChallengerInitializer {
    public static void initChallenger(Context context) {
        try {
            DiChallenge.init(context);
        } catch (Throwable unused) {
        }
    }
}
