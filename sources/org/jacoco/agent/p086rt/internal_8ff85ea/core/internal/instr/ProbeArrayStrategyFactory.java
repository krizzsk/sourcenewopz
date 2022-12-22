package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassReader;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.data.CRC64;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.ClassProbesAdapter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ProbeArrayStrategyFactory */
public final class ProbeArrayStrategyFactory {
    private ProbeArrayStrategyFactory() {
    }

    public static IProbeArrayStrategy createFor(ClassReader classReader, IExecutionDataAccessorGenerator iExecutionDataAccessorGenerator) {
        String className = classReader.getClassName();
        int version = getVersion(classReader);
        long checksum = CRC64.checksum(classReader.f6580b);
        boolean z = version >= 50;
        if (!isInterface(classReader)) {
            return new ClassFieldProbeArrayStrategy(className, checksum, z, iExecutionDataAccessorGenerator);
        }
        ProbeCounter probeCounter = getProbeCounter(classReader);
        if (probeCounter.getCount() == 0) {
            return new NoneProbeArrayStrategy();
        }
        if (version < 52 || !probeCounter.hasMethods()) {
            return new LocalProbeArrayStrategy(className, checksum, probeCounter.getCount(), iExecutionDataAccessorGenerator);
        }
        return new InterfaceFieldProbeArrayStrategy(className, checksum, probeCounter.getCount(), iExecutionDataAccessorGenerator);
    }

    private static boolean isInterface(ClassReader classReader) {
        return (classReader.getAccess() & 512) != 0;
    }

    private static int getVersion(ClassReader classReader) {
        return classReader.readShort(6);
    }

    private static ProbeCounter getProbeCounter(ClassReader classReader) {
        ProbeCounter probeCounter = new ProbeCounter();
        classReader.accept(new ClassProbesAdapter(probeCounter, false), 0);
        return probeCounter;
    }
}
