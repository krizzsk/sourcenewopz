package com.didi.sdk.sidebar;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.component.AbsComponent;
import com.didi.sdk.sidebar.component.ComponentFactory;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.taxis99.R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewAssembler implements Assembler {

    /* renamed from: a */
    private Set<AbsComponent> f37180a = new HashSet();

    public void assemble(SidebarPage sidebarPage, PageDecorator pageDecorator, BaseBusinessContext baseBusinessContext) {
        List<List<SidebarItem>> groupList = sidebarPage.getGroupList();
        if (groupList != null && !groupList.isEmpty() && baseBusinessContext != null) {
            ComponentFactory componentFactory = new ComponentFactory();
            for (int i = 0; i < groupList.size(); i++) {
                List list = groupList.get(i);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i != 0 || i2 != 0) {
                        SidebarItem sidebarItem = (SidebarItem) list.get(i2);
                        AbsComponent createComponent = componentFactory.createComponent(sidebarItem.getComponentType(), baseBusinessContext, sidebarItem, sidebarPage.getSubLevel());
                        if (createComponent != null) {
                            View view = createComponent.getView();
                            if (view != null) {
                                pageDecorator.addView(view);
                            }
                            addComponentToCache(createComponent);
                        }
                    }
                }
                if (i < groupList.size() - 1 || groupList.size() == 1) {
                    View inflate = LayoutInflater.from(baseBusinessContext.getContext()).inflate(R.layout.new_setting_divide_view, (ViewGroup) null);
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

    /* access modifiers changed from: protected */
    public void addComponentToCache(AbsComponent absComponent) {
        this.f37180a.add(absComponent);
    }

    public AbsComponent getComponent(int i) {
        for (AbsComponent next : this.f37180a) {
            if (next.getComponentId() == i) {
                return next;
            }
        }
        return null;
    }

    public void notifyOnResult(int i, int i2, Intent intent) {
        for (AbsComponent onActivityResult : this.f37180a) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void notifyPermissionsResult(int i, String[] strArr, int[] iArr) {
        for (AbsComponent notifyPermissionsResult : this.f37180a) {
            notifyPermissionsResult.notifyPermissionsResult(i, strArr, iArr);
        }
    }

    public void notifyOnDestroy() {
        for (AbsComponent onDestroy : this.f37180a) {
            onDestroy.onDestroy();
        }
    }

    public void notifyOnResume() {
        for (AbsComponent onResume : this.f37180a) {
            onResume.onResume();
        }
    }
}
