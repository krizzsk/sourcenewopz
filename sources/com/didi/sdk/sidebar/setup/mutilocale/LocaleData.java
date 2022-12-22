package com.didi.sdk.sidebar.setup.mutilocale;

import java.io.Serializable;
import java.util.List;

public class LocaleData implements Serializable {
    public List<PrefixMapModel> defaultLocaleList;
    public List<LocaleModel> supportLocaleList;

    public static class PrefixMapModel {
        public String defaultTag;
        public String prefix;
    }
}
