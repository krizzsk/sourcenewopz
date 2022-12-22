package com.didi.app.nova.skeleton.title;

public interface TitleBar {
    void setHidden(boolean z);

    void setLeft(Attr... attrArr);

    void setRight(Attr... attrArr);

    void setStyle(TitleBarAttr titleBarAttr);

    void setTitle(TitleAttr titleAttr);
}
