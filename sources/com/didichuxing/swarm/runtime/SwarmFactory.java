package com.didichuxing.swarm.runtime;

import java.util.Map;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public final class SwarmFactory implements FrameworkFactory {
    public final Framework newFramework(Map<String, String> map) {
        return new C16506b(map);
    }
}
