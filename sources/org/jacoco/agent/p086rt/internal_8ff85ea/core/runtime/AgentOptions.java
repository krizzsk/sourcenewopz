package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AgentOptions */
public final class AgentOptions {
    public static final String ADDRESS = "address";
    public static final String APPEND = "append";
    public static final String CLASSDUMPDIR = "classdumpdir";
    public static final String DEFAULT_ADDRESS = null;
    public static final String DEFAULT_DESTFILE = "jacoco.exec";
    public static final int DEFAULT_PORT = 6300;
    public static final String DESTFILE = "destfile";
    public static final String DUMPONEXIT = "dumponexit";
    public static final String EXCLCLASSLOADER = "exclclassloader";
    public static final String EXCLUDES = "excludes";
    public static final String INCLBOOTSTRAPCLASSES = "inclbootstrapclasses";
    public static final String INCLNOLOCATIONCLASSES = "inclnolocationclasses";
    public static final String INCLUDES = "includes";
    public static final String JMX = "jmx";
    private static final Pattern OPTION_SPLIT = Pattern.compile(",(?=[a-zA-Z0-9_\\-]+=)");
    public static final String OUTPUT = "output";
    public static final String PORT = "port";
    public static final String SESSIONID = "sessionid";
    private static final Collection<String> VALID_OPTIONS = Arrays.asList(new String[]{DESTFILE, APPEND, INCLUDES, EXCLUDES, EXCLCLASSLOADER, INCLBOOTSTRAPCLASSES, INCLNOLOCATIONCLASSES, "sessionid", DUMPONEXIT, "output", "address", PORT, CLASSDUMPDIR, JMX});
    private final Map<String, String> options;

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AgentOptions$OutputMode */
    public enum OutputMode {
        file,
        tcpserver,
        tcpclient,
        none
    }

    public AgentOptions() {
        this.options = new HashMap();
    }

    public AgentOptions(String str) {
        this();
        if (str != null && str.length() > 0) {
            String[] split = OPTION_SPLIT.split(str);
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str2 = split[i];
                int indexOf = str2.indexOf(61);
                if (indexOf != -1) {
                    String substring = str2.substring(0, indexOf);
                    if (VALID_OPTIONS.contains(substring)) {
                        setOption(substring, str2.substring(indexOf + 1));
                        i++;
                    } else {
                        throw new IllegalArgumentException(String.format("Unknown agent option \"%s\".", new Object[]{substring}));
                    }
                } else {
                    throw new IllegalArgumentException(String.format("Invalid agent option syntax \"%s\".", new Object[]{str}));
                }
            }
            validateAll();
        }
    }

    public AgentOptions(Properties properties) {
        this();
        for (String next : VALID_OPTIONS) {
            String property = properties.getProperty(next);
            if (property != null) {
                setOption(next, property);
            }
        }
    }

    private void validateAll() {
        validatePort(getPort());
        getOutput();
    }

    private void validatePort(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("port must be positive");
        }
    }

    public String getDestfile() {
        return getOption(DESTFILE, DEFAULT_DESTFILE);
    }

    public void setDestfile(String str) {
        setOption(DESTFILE, str);
    }

    public boolean getAppend() {
        return getOption(APPEND, true);
    }

    public void setAppend(boolean z) {
        setOption(APPEND, z);
    }

    public String getIncludes() {
        return getOption(INCLUDES, "*");
    }

    public void setIncludes(String str) {
        setOption(INCLUDES, str);
    }

    public String getExcludes() {
        return getOption(EXCLUDES, "");
    }

    public void setExcludes(String str) {
        setOption(EXCLUDES, str);
    }

    public String getExclClassloader() {
        return getOption(EXCLCLASSLOADER, "sun.reflect.DelegatingClassLoader");
    }

    public void setExclClassloader(String str) {
        setOption(EXCLCLASSLOADER, str);
    }

    public boolean getInclBootstrapClasses() {
        return getOption(INCLBOOTSTRAPCLASSES, false);
    }

    public void setInclBootstrapClasses(boolean z) {
        setOption(INCLBOOTSTRAPCLASSES, z);
    }

    public boolean getInclNoLocationClasses() {
        return getOption(INCLNOLOCATIONCLASSES, false);
    }

    public void setInclNoLocationClasses(boolean z) {
        setOption(INCLNOLOCATIONCLASSES, z);
    }

    public String getSessionId() {
        return getOption("sessionid", (String) null);
    }

    public void setSessionId(String str) {
        setOption("sessionid", str);
    }

    public boolean getDumpOnExit() {
        return getOption(DUMPONEXIT, true);
    }

    public void setDumpOnExit(boolean z) {
        setOption(DUMPONEXIT, z);
    }

    public int getPort() {
        return getOption(PORT, 6300);
    }

    public void setPort(int i) {
        validatePort(i);
        setOption(PORT, i);
    }

    public String getAddress() {
        return getOption("address", DEFAULT_ADDRESS);
    }

    public void setAddress(String str) {
        setOption("address", str);
    }

    public OutputMode getOutput() {
        String str = this.options.get("output");
        return str == null ? OutputMode.file : OutputMode.valueOf(str);
    }

    public void setOutput(String str) {
        setOutput(OutputMode.valueOf(str));
    }

    public void setOutput(OutputMode outputMode) {
        setOption("output", outputMode.name());
    }

    public String getClassDumpDir() {
        return getOption(CLASSDUMPDIR, (String) null);
    }

    public void setClassDumpDir(String str) {
        setOption(CLASSDUMPDIR, str);
    }

    public boolean getJmx() {
        return getOption(JMX, false);
    }

    public void setJmx(boolean z) {
        setOption(JMX, z);
    }

    private void setOption(String str, int i) {
        setOption(str, Integer.toString(i));
    }

    private void setOption(String str, boolean z) {
        setOption(str, Boolean.toString(z));
    }

    private void setOption(String str, String str2) {
        this.options.put(str, str2);
    }

    private String getOption(String str, String str2) {
        String str3 = this.options.get(str);
        return str3 == null ? str2 : str3;
    }

    private boolean getOption(String str, boolean z) {
        String str2 = this.options.get(str);
        return str2 == null ? z : Boolean.parseBoolean(str2);
    }

    private int getOption(String str, int i) {
        String str2 = this.options.get(str);
        return str2 == null ? i : Integer.parseInt(str2);
    }

    public String getVMArgument(File file) {
        return String.format("-javaagent:%s=%s", new Object[]{file, this});
    }

    public String getQuotedVMArgument(File file) {
        return CommandLineSupport.quote(getVMArgument(file));
    }

    public String prependVMArguments(String str, File file) {
        List<String> split = CommandLineSupport.split(str);
        String format = String.format("-javaagent:%s", new Object[]{file});
        Iterator<String> it = split.iterator();
        while (it.hasNext()) {
            if (it.next().startsWith(format)) {
                it.remove();
            }
        }
        split.add(0, getVMArgument(file));
        return CommandLineSupport.quote(split);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : VALID_OPTIONS) {
            String str = this.options.get(next);
            if (str != null) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(next);
                sb.append('=');
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
