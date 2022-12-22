package com.didichuxing.xpanel.util;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DomUtil {

    /* renamed from: a */
    private static DocumentBuilderFactory f49583a = DocumentBuilderFactory.newInstance();

    public static Element parseXML(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return parseXML(str.getBytes());
    }

    public static Element parseXML(byte[] bArr) {
        try {
            return f49583a.newDocumentBuilder().parse(new ByteArrayInputStream(bArr), "UTF-8").getDocumentElement();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
