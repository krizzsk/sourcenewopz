package com.didi.component.comp_new_xpanel.template;

import com.didiglobal.enginecore.template.temp.IXEViewModel;

public class XpTemplateAdCardModel extends IXEViewModel {
    public AdCardNormal normal;

    public class AdCardNormal {
        public AdCardData data;

        public AdCardNormal() {
        }
    }

    public class AdCardData {
        public String adid;
        public String agency;

        public AdCardData() {
        }
    }
}
