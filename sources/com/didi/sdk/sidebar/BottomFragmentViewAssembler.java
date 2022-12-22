package com.didi.sdk.sidebar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.component.AbsComponent;
import com.didi.sdk.sidebar.component.ComponentFactory;
import com.didi.sdk.sidebar.component.NavigationWithArrowComponent;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.taxis99.R;
import java.util.List;

public class BottomFragmentViewAssembler extends ViewAssembler {
    public void assemble(SidebarPage sidebarPage, PageDecorator pageDecorator, BaseBusinessContext baseBusinessContext) {
        List<List<SidebarItem>> groupList = sidebarPage.getGroupList();
        if (groupList != null && !groupList.isEmpty() && baseBusinessContext != null) {
            ComponentFactory componentFactory = new ComponentFactory();
            for (int i = 0; i < groupList.size(); i++) {
                List list = groupList.get(i);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    SidebarItem sidebarItem = (SidebarItem) list.get(i2);
                    AbsComponent createComponent = componentFactory.createComponent(sidebarItem.getComponentType(), baseBusinessContext, sidebarItem, sidebarPage.getSubLevel());
                    if (createComponent != null) {
                        View view = createComponent.getView();
                        if (view != null) {
                            pageDecorator.addView(view);
                        }
                        addComponentToCache(createComponent);
                    }
                    if (i2 == list.size() - 1 && (createComponent instanceof NavigationWithArrowComponent)) {
                        ((NavigationWithArrowComponent) createComponent).hideDivider();
                    }
                }
                if (i < groupList.size() - 1) {
                    View inflate = LayoutInflater.from(baseBusinessContext.getContext()).inflate(R.layout.setting_divider_view, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.divider);
                    if (pageDecorator.getDividerColor() > 0) {
                        findViewById.setBackgroundColor(baseBusinessContext.getContext().getResources().getColor(pageDecorator.getDividerColor()));
                    }
                    if (pageDecorator.getDividerHeight() > 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                        layoutParams.height = pageDecorator.getDividerHeight();
                        findViewById.setLayoutParams(layoutParams);
                    }
                    if (inflate != null) {
                        pageDecorator.addDivider(inflate);
                    }
                }
            }
        }
    }
}
