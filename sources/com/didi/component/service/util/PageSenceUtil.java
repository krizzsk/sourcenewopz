package com.didi.component.service.util;

import com.didi.component.service.AbsOnServicePresenter;
import com.didi.component.service.AbsServicePresenter;
import com.didi.component.service.ConfirmServicePresenter;
import com.didi.component.service.EndServicePresenter;
import com.didi.component.service.HomeServiceNewPresenter;
import com.didi.component.service.WaitRspServicePresenter;

public class PageSenceUtil {

    public enum PageSence {
        PAGE_HOME(1, HomeServiceNewPresenter.class),
        PAGE_CONFIRM(2, ConfirmServicePresenter.class),
        PAGE_WAITRSP(3, WaitRspServicePresenter.class),
        PAGE_ONSERVICE(4, AbsOnServicePresenter.class),
        PAGE_ENDSERVICE(5, EndServicePresenter.class);
        
        /* access modifiers changed from: private */
        public Class<? extends AbsServicePresenter> name;
        private int type;

        private PageSence(int i, Class<? extends AbsServicePresenter> cls) {
            this.type = i;
            this.name = cls;
        }

        public Class getName() {
            return this.name;
        }

        public void setName(Class<? extends AbsServicePresenter> cls) {
            this.name = cls;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public static PageSence getPageSence(Class<? extends AbsServicePresenter> cls) {
        for (PageSence pageSence : PageSence.values()) {
            if (pageSence.name.isAssignableFrom(cls)) {
                return pageSence;
            }
        }
        return null;
    }
}
