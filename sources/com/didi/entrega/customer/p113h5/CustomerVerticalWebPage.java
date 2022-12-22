package com.didi.entrega.customer.p113h5;

import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.VerticalChangeHandler;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;

@Route({"verticalWebPage"})
/* renamed from: com.didi.entrega.customer.h5.CustomerVerticalWebPage */
public class CustomerVerticalWebPage extends CustomerWebPage {
    public CustomerVerticalWebPage() {
        DiRouter.registerHub("verticalWebPage", this);
    }

    public ControllerChangeHandler getPushHandler() {
        return new VerticalChangeHandler(false);
    }

    public ControllerChangeHandler getPopHandler() {
        return new VerticalChangeHandler(false);
    }
}
