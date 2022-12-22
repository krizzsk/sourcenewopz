package p242io.flutter.plugin.common;

import p242io.flutter.Log;
import p242io.flutter.plugin.common.MethodChannel;

/* renamed from: io.flutter.plugin.common.ErrorLogResult */
public class ErrorLogResult implements MethodChannel.Result {

    /* renamed from: a */
    private String f57749a;

    /* renamed from: b */
    private int f57750b;

    public void success(Object obj) {
    }

    public ErrorLogResult(String str) {
        this(str, Log.WARN);
    }

    public ErrorLogResult(String str, int i) {
        this.f57749a = str;
        this.f57750b = i;
    }

    public void error(String str, String str2, Object obj) {
        String str3;
        if (obj != null) {
            str3 = " details: " + obj;
        } else {
            str3 = "";
        }
        if (this.f57750b >= Log.WARN) {
            Log.println(this.f57750b, this.f57749a, str2 + str3);
        }
    }

    public void notImplemented() {
        if (this.f57750b >= Log.WARN) {
            Log.println(this.f57750b, this.f57749a, "method not implemented");
        }
    }
}
