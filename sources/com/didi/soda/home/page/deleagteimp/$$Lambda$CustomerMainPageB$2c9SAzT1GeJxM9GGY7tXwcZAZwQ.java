package com.didi.soda.home.page.deleagteimp;

import android.view.View;
import com.didi.soda.customer.app.GlobalContext;

/* renamed from: com.didi.soda.home.page.deleagteimp.-$$Lambda$CustomerMainPageB$2c9SAzT1GeJxM9GGY7tXwcZAZwQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CustomerMainPageB$2c9SAzT1GeJxM9GGY7tXwcZAZwQ implements View.OnClickListener {
    public static final /* synthetic */ $$Lambda$CustomerMainPageB$2c9SAzT1GeJxM9GGY7tXwcZAZwQ INSTANCE = new $$Lambda$CustomerMainPageB$2c9SAzT1GeJxM9GGY7tXwcZAZwQ();

    private /* synthetic */ $$Lambda$CustomerMainPageB$2c9SAzT1GeJxM9GGY7tXwcZAZwQ() {
    }

    public final void onClick(View view) {
        GlobalContext.getBusinessContext().getNavigation().popBackStack();
    }
}
