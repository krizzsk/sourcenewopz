package com.microblink.blinkbarcode.secured;

import android.content.Context;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.secured.IllIIlllIl;
import com.microblink.blinkbarcode.secured.lllllIIIlI;
import java.util.ArrayList;

/* compiled from: line */
final class IIIIIIllIl implements IlllllIIll {
    private final lIIllIIIll IlIllIlIIl = new lIIllIIIll();
    private final lIIlIIllII llIIlIlIIl;

    public IIIIIIllIl(Context context) {
        this.llIIlIlIIl = new lIIlIIllII(context);
    }

    public void llIIlIlIIl() {
        this.llIIlIlIIl.llIIlIlIIl();
    }

    public void llIIlIlIIl(RecognizerBundle recognizerBundle, llIlllIIIl llillliiil) {
        lllllIIIlI.llIIlIlIIl lliililiil;
        lIIllIIIll liilliiill = this.IlIllIlIIl;
        Recognizer[] recognizers = recognizerBundle.getRecognizers();
        ArrayList arrayList = new ArrayList();
        for (Recognizer recognizer : recognizers) {
            IllIIlllIl illIIlllIl = new IllIIlllIl(recognizer.getName(), (IllIIlllIl.llIIlIlIIl) null);
            boolean isExcludedFromPing = recognizer.isExcludedFromPing();
            Recognizer.Result.State resultState = ((Recognizer.Result) recognizer.getResult()).getResultState();
            int ordinal = resultState.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        lliililiil = lllllIIIlI.llIIlIlIIl.Valid;
                    } else if (ordinal != 3) {
                        throw new IllegalStateException("Unexpected value: " + resultState);
                    }
                }
                lliililiil = lllllIIIlI.llIIlIlIIl.Uncertain;
            } else {
                lliililiil = lllllIIIlI.llIIlIlIIl.Empty;
            }
            arrayList.add(new lllllIIIlI(illIIlllIl, isExcludedFromPing, lliililiil));
        }
        this.llIIlIlIIl.llIIlIlIIl(liilliiill.llIIlIlIIl(arrayList, llillliiil));
    }
}
