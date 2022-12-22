package global.didi.pay.web;

import android.content.Context;
import java.io.Serializable;

public class UniPayWebModel implements Serializable {
    public static final int TYPE_COMMON = 0;
    public static final int TYPE_COUPON = 1;
    public int contentType = 0;
    public Context context;
    public int intentFlag;
    public int requestCode;
    public String sid;
    public String url;
}
