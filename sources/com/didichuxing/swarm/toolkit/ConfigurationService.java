package com.didichuxing.swarm.toolkit;

import java.io.IOException;
import java.io.InputStream;

public interface ConfigurationService {
    InputStream getConfiguration(String str) throws IOException;
}
