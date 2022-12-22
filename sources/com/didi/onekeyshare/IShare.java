package com.didi.onekeyshare;

import android.app.Activity;
import com.didi.onekeyshare.view.ShareDialog;

public interface IShare {
    ShareDialog createShareView(Activity activity);
}
