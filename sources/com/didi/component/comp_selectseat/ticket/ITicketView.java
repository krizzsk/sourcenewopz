package com.didi.component.comp_selectseat.ticket;

import com.didi.component.core.IGroupView;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;

public interface ITicketView extends IGroupView {
    void setName(String str);

    void setPayment(LEGORichInfo lEGORichInfo);

    void setPrice(LEGORichInfo lEGORichInfo);

    void setRole(String str);

    void setSeatNum(int i);

    void setSeatUnits(String str);

    void setTicketHeadBgColor(String str);

    void setTicketIntro(String str);

    void setTicketNum(String str);

    void setTitleBarText(String str);

    void showPaymentMark(String str);
}
