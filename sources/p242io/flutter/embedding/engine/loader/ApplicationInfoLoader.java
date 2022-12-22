package p242io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: io.flutter.embedding.engine.loader.ApplicationInfoLoader */
public final class ApplicationInfoLoader {
    public static final String NETWORK_POLICY_METADATA_KEY = "io.flutter.network-policy";
    public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME = (FlutterLoader.class.getName() + '.' + "aot-shared-library-name");
    public static final String PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY = "io.flutter.automatically-register-plugins";
    public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY = (FlutterLoader.class.getName() + '.' + "flutter-assets-dir");
    public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = (FlutterLoader.class.getName() + '.' + "isolate-snapshot-data");
    public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY = (FlutterLoader.class.getName() + '.' + "vm-snapshot-data");

    /* renamed from: a */
    private static ApplicationInfo m41446a(Context context) {
        try {
            return SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static String m41448a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str, (String) null);
    }

    /* renamed from: a */
    private static boolean m41451a(Bundle bundle, String str, boolean z) {
        return bundle == null ? z : bundle.getBoolean(str, z);
    }

    /* renamed from: a */
    private static String m41447a(ApplicationInfo applicationInfo, Context context) {
        int i;
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt(NETWORK_POLICY_METADATA_KEY, 0)) <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            xml.next();
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2 && xml.getName().equals("domain-config")) {
                    m41450a(xml, jSONArray, false);
                }
            }
            return jSONArray.toString();
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m41450a(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) throws IOException, XmlPullParserException {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue((String) null, "cleartextTrafficPermitted", z);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    m41452b(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    m41450a(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    m41449a(xmlResourceParser);
                }
            } else if (next == 3) {
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m41449a(XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        String name = xmlResourceParser.getName();
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType != 3 || xmlResourceParser.getName() != name) {
                eventType = xmlResourceParser.next();
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private static void m41452b(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) throws IOException, XmlPullParserException {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue((String) null, "includeSubdomains", false);
        xmlResourceParser.next();
        if (xmlResourceParser.getEventType() == 4) {
            String trim = xmlResourceParser.getText().trim();
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(trim);
            jSONArray2.put(attributeBooleanValue);
            jSONArray2.put(z);
            jSONArray.put(jSONArray2);
            xmlResourceParser.next();
            if (xmlResourceParser.getEventType() != 3) {
                throw new IllegalStateException("Expected end of domain tag");
            }
            return;
        }
        throw new IllegalStateException("Expected text");
    }

    public static FlutterApplicationInfo load(Context context) {
        ApplicationInfo a = m41446a(context);
        return new FlutterApplicationInfo(m41448a(a.metaData, PUBLIC_AOT_SHARED_LIBRARY_NAME), m41448a(a.metaData, PUBLIC_VM_SNAPSHOT_DATA_KEY), m41448a(a.metaData, PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY), m41448a(a.metaData, PUBLIC_FLUTTER_ASSETS_DIR_KEY), m41447a(a, context), a.nativeLibraryDir, m41451a(a.metaData, PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY, true));
    }
}
