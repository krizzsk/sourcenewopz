package com.didi.sdk.watcher;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionDog {

    /* renamed from: b */
    private static ActionDog f38355b = new ActionDog();

    /* renamed from: a */
    private Logger f38356a = LoggerFactory.getLogger("NLogger");

    /* renamed from: c */
    private Map<String, List<ActionListener>> f38357c = new HashMap();

    public static ActionDog getInstance() {
        return f38355b;
    }

    public synchronized void registerActionListener(String str, ActionListener actionListener) {
        Logger logger = this.f38356a;
        logger.debug("registerActionListener,action = " + str + ",listener = " + actionListener, new Object[0]);
        List list = this.f38357c.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(actionListener);
        this.f38357c.put(str, list);
    }

    public synchronized void unRegisterActionListener(String str, ActionListener actionListener) {
        Logger logger = this.f38356a;
        logger.debug("unRegisterActionListener,action = " + str + ",listener = " + actionListener, new Object[0]);
        List list = this.f38357c.get(str);
        if (list != null) {
            list.remove(actionListener);
        }
    }

    public synchronized void notifyAction(String str, Map<String, String> map) {
        Logger logger = this.f38356a;
        logger.debug("notifyAction,action = " + str + ",tags = " + map, new Object[0]);
        List list = this.f38357c.get(str);
        if (list != null) {
            for (ActionListener actionListener : new ArrayList(list)) {
                Logger logger2 = this.f38356a;
                logger2.debug("notifyAction,action = " + str + ",target = " + actionListener + ",tags = " + map, new Object[0]);
                actionListener.onAction(str, map);
            }
        }
    }
}
