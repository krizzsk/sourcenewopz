package com.didi.dimina.container.p106ui.dialog;

import android.app.Activity;
import com.didi.dimina.container.bridge.sheet.SheetCommonDialog;

/* renamed from: com.didi.dimina.container.ui.dialog.ContactDialog */
public class ContactDialog extends SheetCommonDialog {
    public String getItemOneText() {
        return "创建新联系人";
    }

    public String getItemTwoText() {
        return "添加到现有联系人";
    }

    public ContactDialog(Activity activity) {
        super(activity);
    }
}
