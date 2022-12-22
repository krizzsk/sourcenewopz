package global.didi.pay.newview.pix;

public interface IPixView {
    public static final String PAGE_STATUS_INIT = "init";
    public static final String PAGE_STATUS_PAID = "paid";
    public static final String TYPE_PIX_NORMAL = "pix_page";
    public static final String TYPE_PIX_PREPAY = "pix_prepay_page";

    public interface PixViewListener {
        void onPixCancel(boolean z);

        void onPixChange(boolean z);

        void onPixConfirm(boolean z);

        void onPixPaid(boolean z);
    }

    String getPixCode();

    String getPixType();

    void updatePixCode(String str);

    void updatePixViewStatus(String str);
}
