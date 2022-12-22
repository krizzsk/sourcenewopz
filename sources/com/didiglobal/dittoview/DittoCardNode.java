package com.didiglobal.dittoview;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;

public class DittoCardNode {
    public HashMap<String, Object> attributes;
    public List<DittoCardNode> children;
    public Object data;
    public Element reference;

    public void add(DittoCardNode dittoCardNode) {
        if (this.children == null) {
            this.children = new LinkedList();
        }
        this.children.add(dittoCardNode);
    }

    public String getXml() {
        StringBuilder sb = new StringBuilder();
        m35970a(this, sb);
        return sb.toString();
    }

    /* renamed from: a */
    private void m35970a(DittoCardNode dittoCardNode, StringBuilder sb) {
        sb.append(IMTextUtils.STREET_IMAGE_TAG_START);
        sb.append(dittoCardNode.reference.getTagName());
        HashMap<String, Object> hashMap = dittoCardNode.attributes;
        int i = 0;
        if (hashMap == null) {
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
            List<DittoCardNode> list = dittoCardNode.children;
            if (list != null) {
                while (i < list.size()) {
                    m35970a(list.get(i), sb);
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
            List<DittoCardNode> list2 = dittoCardNode.children;
            if (list2 != null) {
                while (i < list2.size()) {
                    m35970a(list2.get(i), sb);
                    i++;
                }
            }
        }
        sb.append("</");
        sb.append(dittoCardNode.reference.getTagName());
        sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
    }
}
