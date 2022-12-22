package com.didiglobal.dittoview;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didiglobal.dittoview.util.DittoUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DittoTemplateParser {
    public static final String XCARD_VERSION = "2.0.0";

    /* renamed from: a */
    private static final String f49881a = "\\{\\{(.*?)\\}\\}";

    /* renamed from: b */
    private static Pattern f49882b = Pattern.compile(f49881a);

    /* renamed from: c */
    private final String f49883c = "x-for";

    /* renamed from: d */
    private final String f49884d = "x-if";

    /* renamed from: e */
    private final String f49885e = "x-else-if";

    /* renamed from: f */
    private final String f49886f = "x-else";

    /* renamed from: g */
    private final String f49887g = "x-common";

    /* renamed from: h */
    private LinkedList<DittoCardNode> f49888h = new LinkedList<>();

    public DittoCardNode parse(Element element, Object obj) {
        if (element == null) {
            return null;
        }
        try {
            if (obj instanceof JSONObject) {
                obj = DittoUtil.toMap((JSONObject) obj);
            } else if (!(obj instanceof Map)) {
                obj = null;
            }
            return m35991a(element, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private DittoCardNode m35991a(Element element, Object obj) {
        NodeList nodeList;
        boolean z;
        boolean z2;
        Element element2 = element;
        Object obj2 = obj;
        this.f49888h.clear();
        ArrayList arrayList = new ArrayList();
        DittoCardNode dittoCardNode = new DittoCardNode();
        dittoCardNode.reference = element2;
        dittoCardNode.data = obj2;
        dittoCardNode.attributes = m35994a(element2, obj2, obj2, "x-common");
        this.f49888h.addLast(dittoCardNode);
        Stack stack = new Stack();
        while (!this.f49888h.isEmpty()) {
            stack.clear();
            DittoCardNode removeFirst = this.f49888h.removeFirst();
            Object obj3 = removeFirst.data;
            Element element3 = removeFirst.reference;
            if (element3 != null) {
                NodeList childNodes = element3.getChildNodes();
                int i = 0;
                while (true) {
                    if (i < childNodes.getLength()) {
                        Node item = childNodes.item(i);
                        if (item.getNodeType() != 1) {
                            nodeList = childNodes;
                        } else {
                            Element element4 = (Element) item;
                            NamedNodeMap attributes = element4.getAttributes();
                            Node namedItem = attributes.getNamedItem("x-for");
                            Node namedItem2 = attributes.getNamedItem("x-if");
                            Node namedItem3 = attributes.getNamedItem("x-else-if");
                            nodeList = childNodes;
                            Node namedItem4 = attributes.getNamedItem("x-else");
                            arrayList.clear();
                            if (namedItem != null) {
                                stack.clear();
                                List list = (List) m35993a(m35996a((List<String>) arrayList, namedItem, "x-for")[0], obj3, obj2);
                                for (int i2 = 0; i2 < list.size(); i2++) {
                                    m35995a(element4, list.get(i2), obj, "x-for", removeFirst);
                                }
                            } else if (namedItem2 != null) {
                                stack.clear();
                                Object a = m35993a(m35996a((List<String>) arrayList, namedItem2, "x-if")[0], obj3, obj2);
                                if (a instanceof Boolean) {
                                    z2 = ((Boolean) a).booleanValue();
                                } else {
                                    z2 = a != null && a.toString().length() > 0;
                                }
                                stack.push(Boolean.valueOf(z2));
                                if (z2) {
                                    m35995a(element4, obj3, obj, "x-if", removeFirst);
                                }
                            } else {
                                if (namedItem3 != null) {
                                    if (stack.isEmpty()) {
                                        throw new RuntimeException("else statement appears before if in tag <" + element4.getTagName() + IMTextUtils.STREET_IMAGE_TAG_END);
                                    } else if (!((Boolean) stack.peek()).booleanValue()) {
                                        Object a2 = m35993a(m35996a((List<String>) arrayList, namedItem3, "x-else-if")[0], obj3, obj2);
                                        if (a2 instanceof Boolean) {
                                            z = ((Boolean) a2).booleanValue();
                                        } else {
                                            z = a2 != null && a2.toString().length() > 0;
                                        }
                                        if (z) {
                                            stack.pop();
                                            stack.push(true);
                                            m35995a(element4, obj3, obj, "x-else-if", removeFirst);
                                        }
                                    }
                                } else if (namedItem4 == null) {
                                    stack.clear();
                                    m35995a(element4, obj3, obj, "x-common", removeFirst);
                                } else if (!stack.isEmpty()) {
                                    stack.clear();
                                    if (!((Boolean) stack.peek()).booleanValue()) {
                                        m35995a(element4, obj3, obj, "x-else", removeFirst);
                                    }
                                } else {
                                    throw new RuntimeException("else statement appears before if in tag <" + element4.getTagName() + IMTextUtils.STREET_IMAGE_TAG_END);
                                }
                                i++;
                                childNodes = nodeList;
                            }
                        }
                        i++;
                        childNodes = nodeList;
                    }
                }
            } else {
                throw new RuntimeException("xcard node has no dom node, its reference is null");
            }
        }
        return dittoCardNode;
    }

    /* renamed from: a */
    private String[] m35996a(List<String> list, Node node, String str) {
        String nodeValue = node.getNodeValue();
        Matcher matcher = f49882b.matcher(nodeValue);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        if (("x-for".equals(str) || "x-if".equals(str) || "x-else-if".equals(str) || "x-else".equals(str)) && list.size() > 1) {
            throw new RuntimeException("Logical expression" + nodeValue + "error");
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            strArr[i] = str2.substring(2, str2.length() - 2).trim();
        }
        return strArr;
    }

    /* renamed from: a */
    private void m35995a(Element element, Object obj, Object obj2, String str, DittoCardNode dittoCardNode) {
        DittoCardNode dittoCardNode2 = new DittoCardNode();
        dittoCardNode2.reference = element;
        dittoCardNode2.data = obj;
        dittoCardNode2.attributes = m35994a(element, obj, obj2, str);
        this.f49888h.addLast(dittoCardNode2);
        dittoCardNode.add(dittoCardNode2);
    }

    /* renamed from: a */
    private HashMap<String, Object> m35994a(Element element, Object obj, Object obj2, String str) {
        NamedNodeMap attributes = element.getAttributes();
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node item = attributes.item(i);
            String nodeName = item.getNodeName();
            if ("x-for".equals(nodeName) || "x-if".equals(nodeName) || "x-else-if".equals(nodeName) || "x-else".equals(nodeName)) {
                Object obj3 = obj;
                Object obj4 = obj2;
                String str2 = str;
            } else {
                arrayList.clear();
                String nodeValue = item.getNodeValue();
                String[] a = m35996a((List<String>) arrayList, item, str);
                String str3 = nodeValue;
                int i2 = 0;
                while (i2 < a.length) {
                    String str4 = a[i2];
                    String str5 = (String) arrayList.get(i2);
                    Object a2 = m35993a(str4, obj, obj2);
                    if (a2 != null) {
                        str3 = str3.toString().replace(str5, a2.toString());
                        i2++;
                    } else {
                        throw new RuntimeException("tag <" + element.getTagName() + "> " + nodeValue + ", parseExpression error");
                    }
                }
                Object obj5 = obj;
                Object obj6 = obj2;
                hashMap.put(nodeName, str3);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private Object m35993a(String str, Object obj, Object obj2) {
        if (str.startsWith(".item")) {
            return m35992a(str.substring(5, str.length()), obj);
        }
        return m35992a(str, obj2);
    }

    /* renamed from: a */
    private Object m35992a(String str, Object obj) {
        if (obj == null) {
            return null;
        }
        int indexOf = str.indexOf(".");
        if (indexOf == -1) {
            Object b = m35997b(str, obj);
            return b == null ? str : b;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1, str.length());
        if (substring.length() == 0) {
            return m35992a(substring2, obj);
        }
        return m35992a(substring2, m35997b(substring, obj));
    }

    /* renamed from: b */
    private Object m35997b(String str, Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof List) {
            return ((List) obj).get(Integer.parseInt(str));
        }
        return null;
    }
}
