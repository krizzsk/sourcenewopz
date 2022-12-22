package com.didi.map.setting.common;

import com.didi.map.global.component.driveromega.GlobalDriverOmega;
import java.util.HashMap;
import java.util.Map;

public class MapSettingOmega {
    public static OmgEventAdder add(String str) {
        return new OmgEventAdder(str);
    }

    public static class OmgEventAdder {
        String mEventType;
        Map<String, Object> params = new HashMap(4);

        OmgEventAdder(String str) {
            this.mEventType = str;
        }

        public OmgEventAdder add(String str, Object obj) {
            if (obj != null) {
                this.params.put(str, obj);
            }
            return this;
        }

        public void report() {
            GlobalDriverOmega.trackEvent(this.mEventType, this.params);
        }
    }
}
