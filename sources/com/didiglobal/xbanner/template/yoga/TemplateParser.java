package com.didiglobal.xbanner.template.yoga;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
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

public class TemplateParser {
    public static final String XCARD_VERSION = "2.0.0";

    /* renamed from: a */
    private static final String f51519a = "\\{\\{(.*?)\\}\\}";

    /* renamed from: b */
    private static Pattern f51520b = Pattern.compile(f51519a);

    /* renamed from: c */
    private final String f51521c = "x-for";

    /* renamed from: d */
    private final String f51522d = "x-if";

    /* renamed from: e */
    private final String f51523e = "x-else-if";

    /* renamed from: f */
    private final String f51524f = "x-else";

    /* renamed from: g */
    private final String f51525g = "x-common";

    /* renamed from: h */
    private LinkedList<XCardNode> f51526h = new LinkedList<>();

    public XCardNode parse(Element element, Object obj) {
        if (element == null) {
            return null;
        }
        try {
            if (obj instanceof JSONObject) {
                obj = KitHelper.toMap((JSONObject) obj);
            } else if (!(obj instanceof Map)) {
                obj = null;
            }
            return m36876a(element, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private XCardNode m36876a(Element element, Object obj) {
        NodeList nodeList;
        Element element2 = element;
        Object obj2 = obj;
        this.f51526h.clear();
        ArrayList arrayList = new ArrayList();
        XCardNode xCardNode = new XCardNode();
        xCardNode.reference = element2;
        xCardNode.data = obj2;
        xCardNode.attributes = m36879a(element2, obj2, obj2, "x-common");
        this.f51526h.addLast(xCardNode);
        Stack stack = new Stack();
        while (!this.f51526h.isEmpty()) {
            stack.clear();
            XCardNode removeFirst = this.f51526h.removeFirst();
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
                                List list = (List) m36878a(m36881a((List<String>) arrayList, namedItem, "x-for")[0], obj3, obj2);
                                for (int i2 = 0; i2 < list.size(); i2++) {
                                    m36880a(element4, list.get(i2), obj, "x-for", removeFirst);
                                }
                            } else if (namedItem2 != null) {
                                stack.clear();
                                Boolean bool = (Boolean) m36878a(m36881a((List<String>) arrayList, namedItem2, "x-if")[0], obj3, obj2);
                                stack.push(bool);
                                if (bool.booleanValue()) {
                                    m36880a(element4, obj3, obj, "x-if", removeFirst);
                                }
                            } else {
                                if (namedItem3 != null) {
                                    if (stack.isEmpty()) {
                                        throw new RuntimeException("else statement appears before if in tag <" + element4.getTagName() + IMTextUtils.STREET_IMAGE_TAG_END);
                                    } else if (!((Boolean) stack.peek()).booleanValue()) {
                                        if (((Boolean) m36878a(m36881a((List<String>) arrayList, namedItem3, "x-else-if")[0], obj3, obj2)).booleanValue()) {
                                            stack.pop();
                                            stack.push(true);
                                            m36880a(element4, obj3, obj, "x-else-if", removeFirst);
                                        }
                                    }
                                } else if (namedItem4 == null) {
                                    stack.clear();
                                    m36880a(element4, obj3, obj, "x-common", removeFirst);
                                } else if (!stack.isEmpty()) {
                                    stack.clear();
                                    if (!((Boolean) stack.peek()).booleanValue()) {
                                        m36880a(element4, obj3, obj, "x-else", removeFirst);
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
        return xCardNode;
    }

    /* renamed from: a */
    private String[] m36881a(List<String> list, Node node, String str) {
        String nodeValue = node.getNodeValue();
        Matcher matcher = f51520b.matcher(nodeValue);
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
    private void m36880a(Element element, Object obj, Object obj2, String str, XCardNode xCardNode) {
        XCardNode xCardNode2 = new XCardNode();
        xCardNode2.reference = element;
        xCardNode2.data = obj;
        xCardNode2.attributes = m36879a(element, obj, obj2, str);
        this.f51526h.addLast(xCardNode2);
        xCardNode.add(xCardNode2);
    }

    /* renamed from: a */
    private HashMap<String, Object> m36879a(Element element, Object obj, Object obj2, String str) {
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
                String[] a = m36881a((List<String>) arrayList, item, str);
                String str3 = nodeValue;
                int i2 = 0;
                while (i2 < a.length) {
                    String str4 = a[i2];
                    String str5 = (String) arrayList.get(i2);
                    Object a2 = m36878a(str4, obj, obj2);
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
    private Object m36878a(String str, Object obj, Object obj2) {
        if (str.startsWith(".item")) {
            return m36877a(str.substring(5, str.length()), obj);
        }
        return m36877a(str, obj2);
    }

    /* renamed from: a */
    private Object m36877a(String str, Object obj) {
        if (obj == null) {
            return null;
        }
        int indexOf = str.indexOf(".");
        if (indexOf == -1) {
            Object b = m36882b(str, obj);
            return b == null ? str : b;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1, str.length());
        if (substring.length() == 0) {
            return m36877a(substring2, obj);
        }
        return m36877a(substring2, m36882b(substring, obj));
    }

    /* renamed from: b */
    private Object m36882b(String str, Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof List) {
            return ((List) obj).get(Integer.parseInt(str));
        }
        return null;
    }
}
