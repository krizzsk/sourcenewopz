package com.didiglobal.privacy.disclosure;

import android.content.Context;

public class PrivacyDisclosureLocalDialog extends PrivacyDisclosureBaseDialog {
    /* access modifiers changed from: protected */
    public void uploadInfo(Context context, UploadParam uploadParam) {
        DisclosureSpUtils.setKeyUploadInfo(context, uploadParam);
    }
}
