package com.didiglobal.enginecore.template.temp.mdel;

import com.didiglobal.enginecore.template.temp.XERichTextContent;
import java.io.Serializable;
import java.util.List;

public class XEModelContent implements Serializable {
    public int bold;
    public String color;
    public List<XERichTextContent> info;
    public int size;
    public String text;
}
