package com.didi.entrega.customer.service;

import android.graphics.Typeface;
import android.widget.TextView;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.service.IToolsService;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.DiDiTypeface;

public class ToolsService implements IToolsService {
    public Typeface getFontTypeFace(IToolsService.FontType fontType) {
        return DIDIFontUtils.Companion.getDidiTypeface(GlobalContext.getContext(), m14881a(fontType).getType());
    }

    public Typeface getFontTypeFaceForRF(int i) {
        return DIDIFontUtils.Companion.getDidiTypeface(GlobalContext.getContext(), m14880a(i).getType());
    }

    /* renamed from: com.didi.entrega.customer.service.ToolsService$1 */
    static /* synthetic */ class C81281 {

        /* renamed from: $SwitchMap$com$didi$entrega$customer$service$IToolsService$FontType */
        static final /* synthetic */ int[] f20236x336c73c;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.entrega.customer.service.IToolsService$FontType[] r0 = com.didi.entrega.customer.service.IToolsService.FontType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20236x336c73c = r0
                com.didi.entrega.customer.service.IToolsService$FontType r1 = com.didi.entrega.customer.service.IToolsService.FontType.BOLD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20236x336c73c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.entrega.customer.service.IToolsService$FontType r1 = com.didi.entrega.customer.service.IToolsService.FontType.MEDIUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20236x336c73c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.entrega.customer.service.IToolsService$FontType r1 = com.didi.entrega.customer.service.IToolsService.FontType.LIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.service.ToolsService.C81281.<clinit>():void");
        }
    }

    /* renamed from: a */
    private DiDiTypeface m14881a(IToolsService.FontType fontType) {
        int i = C81281.f20236x336c73c[fontType.ordinal()];
        if (i == 1) {
            return DiDiTypeface.FONT_BOLD;
        }
        if (i == 2) {
            return DiDiTypeface.FONT_MEDIUM;
        }
        if (i != 3) {
            return DiDiTypeface.FONT_REGULAR;
        }
        return DiDiTypeface.FONT_THIN;
    }

    /* renamed from: a */
    private DiDiTypeface m14880a(int i) {
        if (i == 1) {
            return DiDiTypeface.FONT_MEDIUM;
        }
        if (i == 2) {
            return DiDiTypeface.FONT_BOLD;
        }
        if (i != 3) {
            return DiDiTypeface.FONT_REGULAR;
        }
        return DiDiTypeface.FONT_THIN;
    }

    public void setTypeface(TextView textView, IToolsService.FontType fontType) {
        if (textView != null) {
            DIDIFontUtils.Companion.setTypeface(textView.getContext(), (Object) textView, getFontTypeFace(fontType));
        }
    }

    public void setTypefaceForRF(TextView textView, int i) {
        if (textView != null) {
            DIDIFontUtils.Companion.setTypeface(textView.getContext(), (Object) textView, getFontTypeFaceForRF(i));
        }
    }
}
