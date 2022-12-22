package com.didi.entrega.address.list.component.feed;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.address.list.component.feed.core.AddressFeedMessagePresenter;
import com.didi.entrega.address.list.component.feed.core.AddressFeedMessageView;

public class AddressFeedMessageComponent extends MvpComponent<AddressFeedMessageView, AddressFeedMessagePresenter> {
    public AddressFeedMessageComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public AddressFeedMessageView onCreateView() {
        return new AddressFeedMessageView();
    }

    /* access modifiers changed from: protected */
    public AddressFeedMessagePresenter onCreatePresenter() {
        return new AddressFeedMessagePresenter();
    }
}
