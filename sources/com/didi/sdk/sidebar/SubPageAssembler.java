package com.didi.sdk.sidebar;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.view.titlebar.CommonTitleBar;

public class SubPageAssembler implements Assembler {

    /* renamed from: a */
    private Assembler f37179a;

    public SubPageAssembler(Assembler assembler) {
        this.f37179a = assembler;
    }

    public void assemble(SidebarPage sidebarPage, PageDecorator pageDecorator, final BaseBusinessContext baseBusinessContext) {
        if (baseBusinessContext != null) {
            Assembler assembler = this.f37179a;
            if (assembler != null) {
                assembler.assemble(sidebarPage, pageDecorator, baseBusinessContext);
            }
            CommonTitleBar commonTitleBar = pageDecorator.getCommonTitleBar();
            commonTitleBar.setTitle(sidebarPage.getTitle());
            commonTitleBar.setLeftBackListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    baseBusinessContext.getNavigation().popBackStack();
                }
            });
        }
    }
}
