package com.didi.soda.customer.p165h5;

import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.VerticalChangeHandler;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;

@Route({"verticalWebPage"})
/* renamed from: com.didi.soda.customer.h5.CustomerVerticalWebPage */
public class CustomerVerticalWebPage extends CustomerWebPage {
    public CustomerVerticalWebPage() {
        DiRouter.registerHub("verticalWebPage", this);
    }

    public ControllerChangeHandler getPushHandler() {
        return new VerticalChangeHandler();
    }

    public ControllerChangeHandler getPopHandler() {
        return new VerticalChangeHandler();
    }
}
