package com.didi.sdk.sidebar.setup.mutilocale;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.swarm.toolkit.LanguageService;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LocaleSwarmServiceImpl implements LocaleChangeListener, LanguageService {

    /* renamed from: a */
    private static final String f37430a = "multilocale-debug";

    /* renamed from: b */
    private static Logger f37431b = LoggerFactory.getLogger("LocaleSwarmServiceImpl");

    /* renamed from: c */
    private LinkedList<LanguageService.OnLanguageChangedListener> f37432c = new LinkedList<>();

    public LocaleSwarmServiceImpl() {
        MultiLocaleStore.getInstance().addLocaleChangeListener(this);
    }

    public String getLanguage() {
        String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        Logger logger = f37431b;
        logger.infoEvent(f37430a, f37430a, "getLanguage localeCode = " + localeCode);
        return localeCode;
    }

    public void addOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
        if (onLanguageChangedListener == null) {
            f37431b.infoEvent(f37430a, f37430a, "addOnLanguageChangedListener listeners is null");
            return;
        }
        f37431b.infoEvent(f37430a, f37430a, "addOnLanguageChangedListener...");
        this.f37432c.add(onLanguageChangedListener);
    }

    public void removeOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
        if (onLanguageChangedListener == null) {
            f37431b.infoEvent(f37430a, f37430a, "removeOnLanguageChangedListener listeners is null");
            return;
        }
        f37431b.infoEvent(f37430a, f37430a, "removeOnLanguageChangedListener...");
        this.f37432c.remove(onLanguageChangedListener);
    }

    public List<LanguageService.OnLanguageChangedListener> getOnLanguageChangedListeners() {
        return this.f37432c;
    }

    public void onLocaleChange(String str, String str2) {
        f37431b.infoEvent(f37430a, f37430a, "onLocaleChange...");
        LinkedList<LanguageService.OnLanguageChangedListener> linkedList = this.f37432c;
        if (linkedList == null) {
            f37431b.infoEvent(f37430a, f37430a, "onLocaleChange listeners is null");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((LanguageService.OnLanguageChangedListener) it.next()).onLanguageChanged(str, str2);
        }
    }
}
