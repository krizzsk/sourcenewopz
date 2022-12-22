package com.didi.component.business.commonlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.core.IViewContainer;
import com.taxis99.R;

public class AbsCommonListView implements ICommonListView, IViewContainer {

    /* renamed from: a */
    private AbsCommonListPresenter f11185a;
    protected ICommonListInterface mCommonList;
    protected View mContainer;

    public int getRootLayout() {
        return R.layout.global_common_list_layout;
    }

    public AbsCommonListView(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(getRootLayout(), viewGroup, false);
        this.mContainer = inflate;
        this.mCommonList = (ICommonListInterface) inflate.findViewById(R.id.common_list_card_container);
    }

    public ICommonListInterface getCommonListInterface() {
        return this.mCommonList;
    }

    public View getView() {
        return this.mContainer;
    }

    public void setPresenter(AbsCommonListPresenter absCommonListPresenter) {
        this.f11185a = absCommonListPresenter;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f11185a.setComponentCreator(iComponentCreator);
    }
}
