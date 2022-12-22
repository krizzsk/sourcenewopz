package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.didi.sdk.apm.SystemUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class DefaultsXmlParser {
    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";

    public static Map<String, String> getDefaultsFromXml(Context context, int i) {
        HashMap hashMap = new HashMap();
        try {
            Resources resources = context.getResources();
            if (resources == null) {
                SystemUtils.log(6, FirebaseRemoteConfig.TAG, "Could not find the resources of the current context while trying to set defaults from an XML.", (Throwable) null, "com.google.firebase.remoteconfig.internal.DefaultsXmlParser", 82);
                return hashMap;
            }
            XmlResourceParser xml = resources.getXml(i);
            String str = null;
            String str2 = null;
            String str3 = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    str = xml.getName();
                } else if (eventType == 3) {
                    if (xml.getName().equals("entry")) {
                        if (str2 == null || str3 == null) {
                            SystemUtils.log(5, FirebaseRemoteConfig.TAG, "An entry in the defaults XML has an invalid key and/or value tag.", (Throwable) null, "com.google.firebase.remoteconfig.internal.DefaultsXmlParser", 104);
                        } else {
                            hashMap.put(str2, str3);
                        }
                        str2 = null;
                        str3 = null;
                    }
                    str = null;
                } else if (eventType == 4 && str != null) {
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != 106079) {
                        if (hashCode == 111972721) {
                            if (str.equals("value")) {
                                c = 1;
                            }
                        }
                    } else if (str.equals("key")) {
                        c = 0;
                    }
                    if (c == 0) {
                        str2 = xml.getText();
                    } else if (c != 1) {
                        SystemUtils.log(5, FirebaseRemoteConfig.TAG, "Encountered an unexpected tag while parsing the defaults XML.", (Throwable) null, "com.google.firebase.remoteconfig.internal.DefaultsXmlParser", 120);
                    } else {
                        str3 = xml.getText();
                    }
                }
            }
            return hashMap;
        } catch (IOException | XmlPullParserException e) {
            SystemUtils.log(6, FirebaseRemoteConfig.TAG, "Encountered an error while parsing the defaults XML file.", e, "com.google.firebase.remoteconfig.internal.DefaultsXmlParser", 128);
        }
    }
}
