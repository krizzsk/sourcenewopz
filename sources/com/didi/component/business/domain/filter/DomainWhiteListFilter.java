package com.didi.component.business.domain.filter;

import android.text.TextUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.IDomainFilter;
import java.util.Collection;
import java.util.Set;

@ServiceProvider(alias = "whitelistfilter", value = {IDomainFilter.class})
public class DomainWhiteListFilter implements IDomainFilter {
    public boolean filterDomain(String str) {
        Set<String> whiteListDomain = GlobalApolloUtil.getWhiteListDomain(DIDIApplication.getAppContext());
        if (TextUtils.isEmpty(str) || CollectionUtil.isEmpty((Collection<?>) whiteListDomain)) {
            return false;
        }
        return whiteListDomain.contains(str);
    }
}
