package com.didi.soda.address.component.feed;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class AddressFeedMessageComponent extends MvpComponent<AddressFeedMessageView, C13370a> {
    public AddressFeedMessageComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public AddressFeedMessageView onCreateView() {
        return new AddressFeedMessageView();
    }

    /* access modifiers changed from: protected */
    public C13370a onCreatePresenter() {
        return new C13370a();
    }
}
