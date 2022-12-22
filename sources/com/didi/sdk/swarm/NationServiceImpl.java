package com.didi.sdk.swarm;

import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.swarm.launcher.toolkit.NationService;
import java.util.HashMap;

public class NationServiceImpl implements NationService {
    public HashMap getParams() {
        return null;
    }

    public String getLocalCountry() {
        return NationTypeUtil.getNationComponentData().getLocCountry();
    }
}
