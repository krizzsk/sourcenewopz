package com.didiglobal.privacy.disclosure;

import android.content.Context;

public class PrivacyDisclosureDialog extends PrivacyDisclosureBaseDialog {
    /* access modifiers changed from: protected */
    public void uploadInfo(Context context, UploadParam uploadParam) {
        UploadUtils.upload(context, uploadParam);
    }
}
