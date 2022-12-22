package com.didi.sdk.config;

import android.content.Context;
import android.util.Xml;
import com.didi.sdk.nation.NationTypeUtil;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class GlobalConfigCenter {

    /* renamed from: a */
    private static GlobalConfigCenter f35697a = new GlobalConfigCenter();

    /* renamed from: b */
    private static final Config[] f35698b = {new Config("about", "email")};

    /* renamed from: c */
    private static final Config[] f35699c = new Config[0];

    /* renamed from: d */
    private String f35700d;

    /* renamed from: e */
    private PushParameter f35701e;

    /* renamed from: f */
    private String f35702f;

    /* renamed from: g */
    private Context f35703g;

    public static class PushParameter {

        /* renamed from: ip */
        public String f35704ip;
        public int port;
    }

    public static GlobalConfigCenter getConfigCenter() {
        return f35697a;
    }

    public void loadConfig(Context context, String str) {
        this.f35702f = str;
        this.f35703g = context.getApplicationContext();
        if (f35699c.length > 0) {
            m25285b(context, str + "_config.xml");
        }
    }

    /* renamed from: a */
    private void m25283a(Context context, String str) {
        if (f35698b.length > 0) {
            m25285b(context, str + "_config_lazy.xml");
        }
    }

    /* renamed from: b */
    private void m25285b(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(open, "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    if (newPullParser.getName().equals("about")) {
                        this.f35700d = m25282a("email", newPullParser);
                    }
                }
            }
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private String m25282a(String str, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        String str2 = "";
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                str2 = xmlPullParser.getAttributeValue(i);
            }
        }
        return str2;
    }

    public PushParameter getPushParameter() {
        if (this.f35701e == null) {
            PushParameter pushParameter = new PushParameter();
            this.f35701e = pushParameter;
            pushParameter.port = NationTypeUtil.getNationComponentData().getPushConfig().getPort();
            this.f35701e.f35704ip = NationTypeUtil.getNationComponentData().getPushConfig().getIp();
        }
        return this.f35701e;
    }

    public String getAboutEmail() {
        m25284a(this.f35700d);
        return this.f35700d;
    }

    /* renamed from: a */
    private void m25284a(Object obj) {
        if (obj == null) {
            m25283a(this.f35703g, this.f35702f);
        }
    }

    static class Config {
        String attrs;
        String tag;

        public Config(String str, String str2) {
            this.tag = str;
            this.attrs = str2;
        }
    }
}
