package org.jacoco.agent.p086rt.internal_8ff85ea;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import org.apache.commons.p071io.IOUtils;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.instr.Instrumenter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.IRuntime;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.WildcardMatcher;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.CoverageTransformer */
public class CoverageTransformer implements ClassFileTransformer {
    private static final String AGENT_PREFIX;
    private final ClassFileDumper classFileDumper;
    private final WildcardMatcher exclClassloader;
    private final WildcardMatcher excludes;
    private final boolean inclBootstrapClasses;
    private final boolean inclNoLocationClasses;
    private final WildcardMatcher includes;
    private final Instrumenter instrumenter;
    private final IExceptionLogger logger;

    static {
        String name = CoverageTransformer.class.getName();
        AGENT_PREFIX = toVMName(name.substring(0, name.lastIndexOf(46)));
    }

    public CoverageTransformer(IRuntime iRuntime, AgentOptions agentOptions, IExceptionLogger iExceptionLogger) {
        this.instrumenter = new Instrumenter(iRuntime);
        this.logger = iExceptionLogger;
        this.includes = new WildcardMatcher(toVMName(agentOptions.getIncludes()));
        this.excludes = new WildcardMatcher(toVMName(agentOptions.getExcludes()));
        this.exclClassloader = new WildcardMatcher(agentOptions.getExclClassloader());
        this.classFileDumper = new ClassFileDumper(agentOptions.getClassDumpDir());
        this.inclBootstrapClasses = agentOptions.getInclBootstrapClasses();
        this.inclNoLocationClasses = agentOptions.getInclNoLocationClasses();
    }

    public byte[] transform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) throws IllegalClassFormatException {
        if (cls != null || !filter(classLoader, str, protectionDomain)) {
            return null;
        }
        try {
            this.classFileDumper.dump(str, bArr);
            return this.instrumenter.instrument(bArr, str);
        } catch (Exception e) {
            IllegalClassFormatException illegalClassFormatException = new IllegalClassFormatException(e.getMessage());
            illegalClassFormatException.initCause(e);
            this.logger.logExeption(illegalClassFormatException);
            throw illegalClassFormatException;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean filter(ClassLoader classLoader, String str, ProtectionDomain protectionDomain) {
        if (classLoader == null) {
            if (!this.inclBootstrapClasses) {
                return false;
            }
        } else if ((!this.inclNoLocationClasses && !hasSourceLocation(protectionDomain)) || this.exclClassloader.matches(classLoader.getClass().getName())) {
            return false;
        }
        if (str.startsWith(AGENT_PREFIX) || !this.includes.matches(str) || this.excludes.matches(str)) {
            return false;
        }
        return true;
    }

    private boolean hasSourceLocation(ProtectionDomain protectionDomain) {
        CodeSource codeSource;
        if (protectionDomain == null || (codeSource = protectionDomain.getCodeSource()) == null || codeSource.getLocation() == null) {
            return false;
        }
        return true;
    }

    private static String toVMName(String str) {
        return str.replace('.', IOUtils.DIR_SEPARATOR_UNIX);
    }
}
