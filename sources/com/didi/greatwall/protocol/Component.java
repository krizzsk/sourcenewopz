package com.didi.greatwall.protocol;

import android.content.Context;
import android.os.Bundle;

public interface Component {
    void onCreate(Context context, Bundle bundle, ComponentListener componentListener);

    void onDestroy();
}
