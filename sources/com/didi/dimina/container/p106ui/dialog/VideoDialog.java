package com.didi.dimina.container.p106ui.dialog;

import android.app.Activity;
import com.didi.dimina.container.bridge.sheet.SheetCommonDialog;

/* renamed from: com.didi.dimina.container.ui.dialog.VideoDialog */
public class VideoDialog extends SheetCommonDialog {
    public String getItemOneText() {
        return "拍摄";
    }

    public String getItemTwoText() {
        return "从相册选择";
    }

    public VideoDialog(Activity activity) {
        super(activity);
    }
}
