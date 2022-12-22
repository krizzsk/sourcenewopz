package p065me.dm7.barcodescanner.zbar;

/* renamed from: me.dm7.barcodescanner.zbar.Result */
public class Result {

    /* renamed from: a */
    private String f4770a;

    /* renamed from: b */
    private BarcodeFormat f4771b;

    public void setContents(String str) {
        this.f4770a = str;
    }

    public void setBarcodeFormat(BarcodeFormat barcodeFormat) {
        this.f4771b = barcodeFormat;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.f4771b;
    }

    public String getContents() {
        return this.f4770a;
    }
}
