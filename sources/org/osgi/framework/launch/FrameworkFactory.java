package org.osgi.framework.launch;

import java.util.Map;

public interface FrameworkFactory {
    Framework newFramework(Map<String, String> map);
}
