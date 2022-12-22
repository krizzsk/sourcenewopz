package com.didi.sdk.sidebar.templet;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.sidebar.PageDecorator;
import com.didi.sdk.sidebar.SubPageAssembler;
import com.didi.sdk.sidebar.ViewAssembler;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class CenterTitleFragment extends BaseSidebarFragment implements IComponent<BaseBusinessContext> {

    /* renamed from: a */
    private BaseBusinessContext f37454a;

    /* renamed from: b */
    private SidebarPage f37455b;

    /* renamed from: c */
    private CommonTitleBar f37456c;

    /* renamed from: d */
    private ViewAssembler f37457d;

    /* access modifiers changed from: protected */
    public ViewAssembler createViewAssembler() {
        if (this.f37457d != null) {
            this.f37457d = new ViewAssembler();
        }
        return this.f37457d;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_sublist_container, (ViewGroup) null);
        Bundle arguments = getArguments();
        String string = arguments.getString("page");
        String string2 = arguments.getString("level");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            this.f37455b = DataContainer.getInstance().getPageData(string2, string);
            this.f37456c = (CommonTitleBar) inflate.findViewById(R.id.title_bar);
            new SubPageAssembler(createViewAssembler()).assemble(this.f37455b, new PageDecorator.PageDecoratorBuilder((ViewGroup) inflate.findViewById(R.id.container)).setTitleView(this.f37456c).build(), this.f37454a);
        }
        return inflate;
    }

    public BaseBusinessContext getBusinessContext() {
        return this.f37454a;
    }

    public void setBusinessContext(BaseBusinessContext baseBusinessContext) {
        this.f37454a = baseBusinessContext;
    }

    public View getFallbackView() {
        return this.f37456c;
    }
}
