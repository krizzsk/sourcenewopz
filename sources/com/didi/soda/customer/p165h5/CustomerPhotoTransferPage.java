package com.didi.soda.customer.p165h5;

import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.didi.soda.web.page.PhotoTransferPage;

@Route({"WebPage/Transfer_Page"})
/* renamed from: com.didi.soda.customer.h5.CustomerPhotoTransferPage */
public class CustomerPhotoTransferPage extends PhotoTransferPage {
    public CustomerPhotoTransferPage() {
        DiRouter.registerHub("WebPage/Transfer_Page", this);
    }
}
