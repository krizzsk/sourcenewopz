package com.dmap.apollo;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashMap;

public class ApolloDelegate {

    /* renamed from: a */
    private static final IApolloDelegate f51727a = new ApolloDelegateImpl();

    /* renamed from: b */
    private static HashMap<String, IToggle> f51728b = null;

    /* renamed from: c */
    private HashMap<String, Boolean> f51729c = new HashMap<>();

    /* renamed from: d */
    private Logger f51730d;

    public interface Logger {
        void log(String str, String str2);
    }

    public void setPrintLogger(Logger logger) {
        this.f51730d = logger;
    }

    public IToggle getToggleCache(String str) {
        return m37014a(str, false, true);
    }

    public IToggle getToggle(String str) {
        return getToggle(str, false);
    }

    public IToggle getToggle(String str, boolean z) {
        return m37014a(str, z, false);
    }

    /* renamed from: a */
    private IToggle m37014a(String str, boolean z, boolean z2) {
        String str2;
        if (f51728b == null) {
            f51728b = new HashMap<>();
        }
        IToggle iToggle = null;
        if (z2) {
            iToggle = f51728b.get(str);
            str2 = "[cache]";
        } else {
            str2 = "";
        }
        if (iToggle == null) {
            iToggle = f51727a.getToggle(str, z);
            if (z2) {
                f51728b.put(str, iToggle);
            }
            str2 = "[apollo]";
        }
        if (this.f51730d != null && iToggle != null && !TextUtils.isEmpty(str) && this.f51729c.get(str) == null) {
            this.f51729c.put(str, true);
            Logger logger = this.f51730d;
            logger.log(str, str2 + iToggle.toJsonObject().toString());
        }
        return iToggle;
    }
}
