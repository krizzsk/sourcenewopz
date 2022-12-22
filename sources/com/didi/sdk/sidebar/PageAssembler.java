package com.didi.sdk.sidebar;

import android.content.Context;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.view.GlobalTitleBar;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

public class PageAssembler implements Assembler {

    /* renamed from: a */
    private Assembler f37170a;

    public PageAssembler(Assembler assembler) {
        this.f37170a = assembler;
    }

    public void assemble(final SidebarPage sidebarPage, PageDecorator pageDecorator, final BaseBusinessContext baseBusinessContext) {
        if (baseBusinessContext != null) {
            Assembler assembler = this.f37170a;
            if (assembler != null) {
                assembler.assemble(sidebarPage, pageDecorator, baseBusinessContext);
            }
            Context context = baseBusinessContext.getContext();
            GlobalTitleBar globalTitleBar = pageDecorator.getGlobalTitleBar();
            if (globalTitleBar != null) {
                globalTitleBar.setTitle(sidebarPage.getTitle());
                globalTitleBar.setLeftImage(context.getResources().getDrawable(R.drawable.webview_common_title_bar_btn_close_selector), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        baseBusinessContext.getNavigation().popBackStack();
                        if ("level2".equals(sidebarPage.getSubLevel())) {
                            EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.OPEN_SIDEBAR));
                        }
                    }
                });
            }
            CommonTitleBar commonTitleBar = pageDecorator.getCommonTitleBar();
            if (commonTitleBar != null) {
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
}
