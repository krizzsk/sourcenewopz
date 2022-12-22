package com.didi.sdk.sidebar;

import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarPage;

public interface Assembler {
    void assemble(SidebarPage sidebarPage, PageDecorator pageDecorator, BaseBusinessContext baseBusinessContext);
}
