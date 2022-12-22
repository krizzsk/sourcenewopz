package com.didi.soda.customer.service;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.soda.customer.service.IToolsService;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.DiDiTypeface;

public class ToolsService implements IToolsService {
    public void fetchAppInstanceID() {
    }

    public void fetchSideBarByRpc(boolean z) {
    }

    public String getAppInstanceID() {
        return "";
    }

    public UserInfoEntity getUserInfoEntity() {
        return null;
    }

    public void initFirebaseRemote() {
    }

    public void trackFirebaseEvent(Context context, String str, Bundle bundle) {
    }

    public Typeface getFontTypeFace(IToolsService.FontType fontType) {
        return DIDIFontUtils.Companion.getDidiTypeface(GlobalContext.getContext(), m29320a(fontType).getType());
    }

    public Typeface getFontTypeFaceForRF(int i) {
        return DIDIFontUtils.Companion.getDidiTypeface(GlobalContext.getContext(), m29319a(i).getType());
    }

    /* renamed from: com.didi.soda.customer.service.ToolsService$1 */
    static /* synthetic */ class C138021 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$soda$customer$service$IToolsService$FontType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.soda.customer.service.IToolsService$FontType[] r0 = com.didi.soda.customer.service.IToolsService.FontType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$soda$customer$service$IToolsService$FontType = r0
                com.didi.soda.customer.service.IToolsService$FontType r1 = com.didi.soda.customer.service.IToolsService.FontType.BOLD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$soda$customer$service$IToolsService$FontType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.soda.customer.service.IToolsService$FontType r1 = com.didi.soda.customer.service.IToolsService.FontType.MEDIUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$soda$customer$service$IToolsService$FontType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.soda.customer.service.IToolsService$FontType r1 = com.didi.soda.customer.service.IToolsService.FontType.NORMAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$soda$customer$service$IToolsService$FontType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.soda.customer.service.IToolsService$FontType r1 = com.didi.soda.customer.service.IToolsService.FontType.LIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.service.ToolsService.C138021.<clinit>():void");
        }
    }

    /* renamed from: a */
    private DiDiTypeface m29320a(IToolsService.FontType fontType) {
        int i = C138021.$SwitchMap$com$didi$soda$customer$service$IToolsService$FontType[fontType.ordinal()];
        if (i == 1) {
            return DiDiTypeface.FONT_BOLD;
        }
        if (i == 2) {
            return DiDiTypeface.FONT_MEDIUM;
        }
        if (i == 3) {
            return DiDiTypeface.FONT_REGULAR;
        }
        if (i != 4) {
            return DiDiTypeface.FONT_REGULAR;
        }
        return DiDiTypeface.FONT_THIN;
    }

    /* renamed from: a */
    private DiDiTypeface m29319a(int i) {
        if (i == 0) {
            return DiDiTypeface.FONT_REGULAR;
        }
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
