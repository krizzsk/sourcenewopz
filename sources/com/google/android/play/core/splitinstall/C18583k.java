package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.android.play.core.splitcompat.C18546p;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.play.core.splitinstall.k */
public final class C18583k {

    /* renamed from: a */
    private static C18585m f53327a;

    private C18583k() {
    }

    /* renamed from: a */
    static C18580h m38154a(XmlPullParser xmlPullParser, C18579g gVar) {
        String a;
        while (xmlPullParser.next() != 1) {
            try {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("splits")) {
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                if (!xmlPullParser.getName().equals("module") || (a = m38156a("name", xmlPullParser)) == null) {
                                    m38157a(xmlPullParser);
                                } else {
                                    while (xmlPullParser.next() != 3) {
                                        if (xmlPullParser.getEventType() == 2) {
                                            if (xmlPullParser.getName().equals("language")) {
                                                while (xmlPullParser.next() != 3) {
                                                    if (xmlPullParser.getEventType() == 2) {
                                                        if (xmlPullParser.getName().equals(ParamKeys.PARAM_COMPLAIN_ENTRY)) {
                                                            String a2 = m38156a("key", xmlPullParser);
                                                            String a3 = m38156a("split", xmlPullParser);
                                                            m38157a(xmlPullParser);
                                                            if (!(a2 == null || a3 == null)) {
                                                                gVar.mo149297a(a, a2, a3);
                                                            }
                                                        } else {
                                                            m38157a(xmlPullParser);
                                                        }
                                                    }
                                                }
                                            } else {
                                                m38157a(xmlPullParser);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        m38157a(xmlPullParser);
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException e) {
                SystemUtils.log(6, "SplitInstall", "Error while parsing splits.xml", e, "com.google.android.play.core.splitinstall.k", -1);
                return null;
            }
        }
        return gVar.mo149296a();
    }

    /* renamed from: a */
    public static synchronized C18585m m38155a(Context context) {
        C18585m mVar;
        synchronized (C18583k.class) {
            if (f53327a == null) {
                C18574b bVar = new C18574b((byte[]) null);
                bVar.mo149289a(new C18609y(C18546p.m38075a(context)));
                f53327a = bVar.mo149288a();
            }
            mVar = f53327a;
        }
        return mVar;
    }

    /* renamed from: a */
    private static String m38156a(String str, XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m38157a(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
