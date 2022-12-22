package org.jacoco.agent.p086rt.internal_8ff85ea;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.ConfigLoader */
final class ConfigLoader {
    private static final Pattern SUBST_PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");
    private static final String SYS_PREFIX = "jacoco-agent.";

    static Properties load(String str, Properties properties) {
        Properties properties2 = new Properties();
        loadResource(str, properties2);
        loadSystemProperties(properties, properties2);
        substSystemProperties(properties2, properties);
        return properties2;
    }

    private static void loadResource(String str, Properties properties) {
        InputStream resourceAsStream = Offline.class.getResourceAsStream(str);
        if (resourceAsStream != null) {
            try {
                properties.load(resourceAsStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void loadSystemProperties(Properties properties, Properties properties2) {
        for (Map.Entry entry : properties.entrySet()) {
            String obj = entry.getKey().toString();
            if (obj.startsWith(SYS_PREFIX)) {
                properties2.put(obj.substring(13), entry.getValue());
            }
        }
    }

    private static void substSystemProperties(Properties properties, Properties properties2) {
        for (Map.Entry entry : properties.entrySet()) {
            String str = (String) entry.getValue();
            StringBuilder sb = new StringBuilder();
            Matcher matcher = SUBST_PATTERN.matcher(str);
            int i = 0;
            while (matcher.find()) {
                sb.append(str.substring(i, matcher.start()));
                String property = properties2.getProperty(matcher.group(1));
                if (property == null) {
                    property = matcher.group(0);
                }
                sb.append(property);
                i = matcher.end();
            }
            sb.append(str.substring(i));
            entry.setValue(sb.toString());
        }
    }

    private ConfigLoader() {
    }
}
