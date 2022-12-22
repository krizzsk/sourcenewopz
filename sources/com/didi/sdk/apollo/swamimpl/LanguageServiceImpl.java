package com.didi.sdk.apollo.swamimpl;

import com.didi.sdk.data.DataLoadUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.swarm.toolkit.LanguageService;
import java.util.List;

@ServiceProvider({LanguageService.class})
public class LanguageServiceImpl implements LanguageService {

    /* renamed from: a */
    final LanguageService f35075a = ((LanguageService) DataLoadUtil.loadGenerator(LanguageService.class));

    public void addOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
    }

    public List<LanguageService.OnLanguageChangedListener> getOnLanguageChangedListeners() {
        return null;
    }

    public void removeOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
    }

    public String getLanguage() {
        return this.f35075a.getLanguage();
    }
}
