package p065me.dm7.barcodescanner.zbar;

import com.didi.travel.p171v2.store.IStoreCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.dm7.barcodescanner.zbar.BarcodeFormat */
public class BarcodeFormat {
    public static final List<BarcodeFormat> ALL_FORMATS;
    public static final BarcodeFormat CODABAR = new BarcodeFormat(38, "CODABAR");
    public static final BarcodeFormat CODE128 = new BarcodeFormat(128, "CODE128");
    public static final BarcodeFormat CODE39 = new BarcodeFormat(39, "CODE39");
    public static final BarcodeFormat CODE93 = new BarcodeFormat(93, "CODE93");
    public static final BarcodeFormat DATABAR = new BarcodeFormat(34, "DATABAR");
    public static final BarcodeFormat DATABAR_EXP = new BarcodeFormat(35, "DATABAR_EXP");
    public static final BarcodeFormat EAN13 = new BarcodeFormat(13, "EAN13");
    public static final BarcodeFormat EAN8 = new BarcodeFormat(8, "EAN8");
    public static final BarcodeFormat I25 = new BarcodeFormat(25, "I25");
    public static final BarcodeFormat ISBN10 = new BarcodeFormat(10, "ISBN10");
    public static final BarcodeFormat ISBN13 = new BarcodeFormat(14, "ISBN13");
    public static final BarcodeFormat NONE = new BarcodeFormat(0, IStoreCallback.DEFAULT_API_DETAIL_KEY);
    public static final BarcodeFormat PARTIAL = new BarcodeFormat(1, "PARTIAL");
    public static final BarcodeFormat PDF417 = new BarcodeFormat(57, "PDF417");
    public static final BarcodeFormat QRCODE = new BarcodeFormat(64, "QRCODE");
    public static final BarcodeFormat UPCA = new BarcodeFormat(12, "UPCA");
    public static final BarcodeFormat UPCE = new BarcodeFormat(9, "UPCE");

    /* renamed from: a */
    private int f4768a;

    /* renamed from: b */
    private String f4769b;

    static {
        ArrayList arrayList = new ArrayList();
        ALL_FORMATS = arrayList;
        arrayList.add(PARTIAL);
        ALL_FORMATS.add(EAN8);
        ALL_FORMATS.add(UPCE);
        ALL_FORMATS.add(ISBN10);
        ALL_FORMATS.add(UPCA);
        ALL_FORMATS.add(EAN13);
        ALL_FORMATS.add(ISBN13);
        ALL_FORMATS.add(I25);
        ALL_FORMATS.add(DATABAR);
        ALL_FORMATS.add(DATABAR_EXP);
        ALL_FORMATS.add(CODABAR);
        ALL_FORMATS.add(CODE39);
        ALL_FORMATS.add(PDF417);
        ALL_FORMATS.add(QRCODE);
        ALL_FORMATS.add(CODE93);
        ALL_FORMATS.add(CODE128);
    }

    public BarcodeFormat(int i, String str) {
        this.f4768a = i;
        this.f4769b = str;
    }

    public int getId() {
        return this.f4768a;
    }

    public String getName() {
        return this.f4769b;
    }

    public static BarcodeFormat getFormatById(int i) {
        for (BarcodeFormat next : ALL_FORMATS) {
            if (next.getId() == i) {
                return next;
            }
        }
        return NONE;
    }
}
