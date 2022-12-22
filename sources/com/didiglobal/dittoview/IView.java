package com.didiglobal.dittoview;

import com.didiglobal.dittoview.view.DittoBorder;
import com.didiglobal.dittoview.view.DittoCorner;
import com.didiglobal.dittoview.view.DittoShadow;

public interface IView {
    void setBorder(DittoBorder dittoBorder);

    void setCorner(DittoCorner dittoCorner);

    void setShadow(DittoShadow dittoShadow);
}
