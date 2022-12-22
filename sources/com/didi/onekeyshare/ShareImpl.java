package com.didi.onekeyshare;

import android.app.Activity;
import com.didi.onekeyshare.view.ShareDialog;

public class ShareImpl implements IShare {
    public ShareDialog createShareView(Activity activity) {
        return new ShareDialog(activity);
    }
}
