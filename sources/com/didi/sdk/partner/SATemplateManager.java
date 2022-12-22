package com.didi.sdk.partner;

import com.didi.sdk.partner.supportcard.TemplateInfo;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SATemplateManager {

    /* renamed from: a */
    private List<TemplateInfo> f36876a;

    private SATemplateManager() {
        this.f36876a = new ArrayList();
        Iterator<S> it = ServiceLoader.load(ITemplateViewProvider.class).iterator();
        while (it.hasNext()) {
            this.f36876a.add(((ITemplateViewProvider) it.next()).getSupportCardTemplateInfo());
        }
    }

    private static class SingletonInstance {
        /* access modifiers changed from: private */
        public static final SATemplateManager INSTANCE = new SATemplateManager();

        private SingletonInstance() {
        }
    }

    public static SATemplateManager getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public List<TemplateInfo> getSupportCardTemplateInfo() {
        return this.f36876a;
    }

    public boolean hasRegisteredTemplates() {
        return this.f36876a.size() > 0;
    }
}
