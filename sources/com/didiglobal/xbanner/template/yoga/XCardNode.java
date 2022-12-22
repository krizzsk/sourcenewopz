package com.didiglobal.xbanner.template.yoga;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;

public class XCardNode {
    public HashMap<String, Object> attributes;
    public List<XCardNode> children;
    public Object data;
    public Element reference;

    public void add(XCardNode xCardNode) {
        if (this.children == null) {
            this.children = new LinkedList();
        }
        this.children.add(xCardNode);
    }

    public String getXml() {
        StringBuilder sb = new StringBuilder();
        m36883a(this, sb);
        return sb.toString();
    }

    /* renamed from: a */
    private void m36883a(XCardNode xCardNode, StringBuilder sb) {
        sb.append(IMTextUtils.STREET_IMAGE_TAG_START);
        sb.append(xCardNode.reference.getTagName());
        HashMap<String, Object> hashMap = xCardNode.attributes;
        int i = 0;
        if (hashMap == null) {
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
            List<XCardNode> list = xCardNode.children;
            if (list != null) {
                while (i < list.size()) {
                    m36883a(list.get(i), sb);
                    i++;
                }
            }
        } else {
            for (Map.Entry next : hashMap.entrySet()) {
                sb.append(" ");
                sb.append((String) next.getKey());
                sb.append("=\"");
                sb.append(next.getValue().toString());
                sb.append(Const.jsQuote);
            }
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
            List<XCardNode> list2 = xCardNode.children;
            if (list2 != null) {
                while (i < list2.size()) {
                    m36883a(list2.get(i), sb);
                    i++;
                }
            }
        }
        sb.append("</");
        sb.append(xCardNode.reference.getTagName());
        sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
    }
}
