package didihttpdns.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public final class HttpDnsPrefs {
    public static final String KEY_TTL = "ttl";
    public static final String KEY_UPDATE_TIME = "update_time";
    public static final String SHARED_PREFS_NAME = "http_dns";

    /* renamed from: c */
    private static HttpDnsPrefs f57038c;

    /* renamed from: a */
    private SharedPreferences f57039a;

    /* renamed from: b */
    private SharedPreferences.Editor f57040b;

    private HttpDnsPrefs(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context.getApplicationContext(), SHARED_PREFS_NAME, 0);
        this.f57039a = sharedPreferences;
        this.f57040b = sharedPreferences.edit();
    }

    public static HttpDnsPrefs getInstance(Context context) {
        if (f57038c == null) {
            synchronized (HttpDnsPrefs.class) {
                if (f57038c == null) {
                    f57038c = new HttpDnsPrefs(context);
                }
            }
        }
        return f57038c;
    }
}
