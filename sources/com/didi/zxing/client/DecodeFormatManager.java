package com.didi.zxing.client;

import android.content.Intent;
import com.didi.dqr.BarcodeFormat;
import com.didi.zxing.client.Intents;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class DecodeFormatManager {

    /* renamed from: a */
    static final Set<BarcodeFormat> f45467a = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[]{BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED});

    /* renamed from: b */
    static final Set<BarcodeFormat> f45468b = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);

    /* renamed from: c */
    static final Set<BarcodeFormat> f45469c = EnumSet.of(BarcodeFormat.QR_CODE);

    /* renamed from: d */
    static final Set<BarcodeFormat> f45470d = EnumSet.of(BarcodeFormat.DATA_MATRIX);

    /* renamed from: e */
    static final Set<BarcodeFormat> f45471e = EnumSet.of(BarcodeFormat.AZTEC);

    /* renamed from: f */
    static final Set<BarcodeFormat> f45472f = EnumSet.of(BarcodeFormat.PDF_417);

    /* renamed from: g */
    private static final Pattern f45473g = Pattern.compile(",");

    /* renamed from: h */
    private static final Set<BarcodeFormat> f45474h;

    /* renamed from: i */
    private static final Map<String, Set<BarcodeFormat>> f45475i;

    static {
        EnumSet<BarcodeFormat> copyOf = EnumSet.copyOf(f45467a);
        f45474h = copyOf;
        copyOf.addAll(f45468b);
        HashMap hashMap = new HashMap();
        f45475i = hashMap;
        hashMap.put(Intents.Scan.ONE_D_MODE, f45474h);
        f45475i.put(Intents.Scan.PRODUCT_MODE, f45467a);
        f45475i.put(Intents.Scan.QR_CODE_MODE, f45469c);
        f45475i.put(Intents.Scan.DATA_MATRIX_MODE, f45470d);
        f45475i.put(Intents.Scan.AZTEC_MODE, f45471e);
        f45475i.put(Intents.Scan.PDF417_MODE, f45472f);
    }

    private DecodeFormatManager() {
    }

    public static Set<BarcodeFormat> parseDecodeFormats(Intent intent) {
        String stringExtra = intent.getStringExtra(Intents.Scan.FORMATS);
        return m32612a(stringExtra != null ? Arrays.asList(f45473g.split(stringExtra)) : null, intent.getStringExtra(Intents.Scan.MODE));
    }

    /* renamed from: a */
    private static Set<BarcodeFormat> m32612a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                for (String valueOf : iterable) {
                    noneOf.add(BarcodeFormat.valueOf(valueOf));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f45475i.get(str);
        }
        return null;
    }
}
