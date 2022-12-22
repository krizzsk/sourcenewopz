package com.microblink.blinkbarcode.view.recognition;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: line */
class IlIllIlIIl implements DialogInterface.OnClickListener {
    public final /* synthetic */ RecognizerRunnerView llIIlIlIIl;

    public IlIllIlIIl(RecognizerRunnerView recognizerRunnerView) {
        this.llIIlIlIIl = recognizerRunnerView;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.llIIlIlIIl.lIlIllIIlI.set(false);
        RecognizerRunnerView.IlIllIlIIl(this.llIIlIlIIl, true);
    }
}
