package com.didi.entrega.customer.p113h5;

import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.didi.soda.web.page.PhotoTransferPage;

@Route({"WebPage/Transfer_Page"})
/* renamed from: com.didi.entrega.customer.h5.CustomerPhotoTransferPage */
public class CustomerPhotoTransferPage extends PhotoTransferPage {
    public CustomerPhotoTransferPage() {
        DiRouter.registerHub("WebPage/Transfer_Page", this);
    }
}
