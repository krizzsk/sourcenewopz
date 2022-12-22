package com.rider.rlab_im_map_plugin.channel;

import com.didi.rlab.uni_im_map.map.IMMapLogService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Map;

public class IMMapLogServiceImpl implements IMMapLogService {

    /* renamed from: a */
    private final Logger f55848a = LoggerFactory.getLogger("IMMap");

    public void pHandleLogger(String str, Map<String, Object> map) {
        if (str != null && !str.isEmpty() && map != null && map.size() > 0) {
            String str2 = (String) map.get("tag");
            Object obj = map.get("param");
            char c = 65535;
            switch (str.hashCode()) {
                case 3237038:
                    if (str.equals("info")) {
                        c = 0;
                        break;
                    }
                    break;
                case 95458899:
                    if (str.equals("debug")) {
                        c = 1;
                        break;
                    }
                    break;
                case 96784904:
                    if (str.equals("error")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1124446108:
                    if (str.equals("warning")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                Logger logger = this.f55848a;
                logger.info("" + str2 + " | " + obj, new Object[0]);
            } else if (c == 1) {
                Logger logger2 = this.f55848a;
                logger2.debug("" + str2 + " | " + obj, new Object[0]);
            } else if (c == 2) {
                Logger logger3 = this.f55848a;
                logger3.error("" + str2 + " | " + obj, new Object[0]);
            } else if (c == 3) {
                Logger logger4 = this.f55848a;
                logger4.warn("" + str2 + " | " + obj, new Object[0]);
            }
        }
    }
}
