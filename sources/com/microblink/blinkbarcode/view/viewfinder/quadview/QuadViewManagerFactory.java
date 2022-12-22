package com.microblink.blinkbarcode.view.viewfinder.quadview;

import android.content.Context;
import android.graphics.Color;
import com.microblink.blinkbarcode.secured.IllIIIllII;
import com.microblink.blinkbarcode.secured.lIlIIIIlIl;
import com.microblink.blinkbarcode.secured.llIIIlllll;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;

/* compiled from: line */
public class QuadViewManagerFactory {
    public static QuadViewManager createDocumentDetectionQuadViewManager(RecognizerRunnerView recognizerRunnerView, int i) {
        IllIIIllII illIIIllII = new IllIIIllII(recognizerRunnerView.getContext(), new IllIIIllII(), 0.5d, 0.5d, recognizerRunnerView.getHostScreenOrientation());
        illIIIllII.setMovable(true);
        illIIIllII.setAnimationDuration(200);
        illIIIllII.setDefaultQuadColor(Color.argb(0, Color.red(i), Color.green(i), Color.blue(i)));
        illIIIllII.setDetectedQuadColor(i);
        illIIIllII.llIIlIlIIl(true);
        recognizerRunnerView.addChildView(illIIIllII, false, 0);
        return new QuadViewManager(illIIIllII);
    }

    public static QuadViewManager createQuadViewFromPreset(RecognizerRunnerView recognizerRunnerView, QuadViewPreset quadViewPreset) {
        Context context = recognizerRunnerView.getContext();
        int ordinal = quadViewPreset.ordinal();
        if (ordinal == 0) {
            lIlIIIIlIl liliiiilil = new lIlIIIIlIl(context);
            liliiiilil.llIIlIlIIl(0.05f);
            liliiiilil.llIIlIlIIl(54);
            IllIIIllII illIIIllII = new IllIIIllII(context, liliiiilil, 0.25d, 0.25d, recognizerRunnerView.getHostScreenOrientation());
            illIIIllII.setMovable(true);
            illIIIllII.setAnimationDuration(200);
            recognizerRunnerView.addChildView(illIIIllII, false, 0);
            return new QuadViewManager(illIIIllII);
        } else if (ordinal == 1) {
            lIlIIIIlIl liliiiilil2 = new lIlIIIIlIl(context);
            liliiiilil2.llIIlIlIIl(0.05f);
            liliiiilil2.llIIlIlIIl(54);
            IllIIIllII illIIIllII2 = new IllIIIllII(context, liliiiilil2, 0.25d, 0.25d, recognizerRunnerView.getHostScreenOrientation());
            illIIIllII2.setAnimationDuration(150);
            recognizerRunnerView.addChildView(illIIIllII2, false, 0);
            return new QuadViewManager(illIIIllII2);
        } else if (ordinal == 2) {
            llIIlIlIIl lliililiil = new llIIlIlIIl(0.63060747663d, 0.4d, 0.1d, recognizerRunnerView);
            lliililiil.llIIlIlIIl.setMovable(false);
            lliililiil.llIIlIlIIl.setAnimationDuration(0);
            recognizerRunnerView.addChildView(lliililiil.llIIlIlIIl, false, 0);
            return lliililiil;
        } else if (ordinal == 3) {
            IllIIIllII illIIIllII3 = new IllIIIllII(context, new llIIIlllll(), 0.2d, 0.0d, recognizerRunnerView.getHostScreenOrientation());
            illIIIllII3.setMovable(true);
            illIIIllII3.setAnimationDuration(200);
            recognizerRunnerView.addChildView(illIIIllII3, false, 0);
            return new QuadViewManager(illIIIllII3);
        } else if (ordinal != 4) {
            return null;
        } else {
            IllIIIllII illIIIllII4 = new IllIIIllII(context, new llIIIlllll(), 0.4d, 0.0d, recognizerRunnerView.getHostScreenOrientation());
            illIIIllII4.setMovable(true);
            illIIIllII4.setAnimationDuration(200);
            recognizerRunnerView.addChildView(illIIIllII4, false, 0);
            return new QuadViewManager(illIIIllII4);
        }
    }
}
