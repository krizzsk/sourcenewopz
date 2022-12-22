package org.jacoco.agent.p086rt.internal_8ff85ea;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import org.jacoco.agent.p086rt.IAgent;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.JaCoCo;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.ExecutionDataWriter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AbstractRuntime;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RuntimeData;
import org.jacoco.agent.p086rt.internal_8ff85ea.output.FileOutput;
import org.jacoco.agent.p086rt.internal_8ff85ea.output.IAgentOutput;
import org.jacoco.agent.p086rt.internal_8ff85ea.output.NoneOutput;
import org.jacoco.agent.p086rt.internal_8ff85ea.output.TcpClientOutput;
import org.jacoco.agent.p086rt.internal_8ff85ea.output.TcpServerOutput;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.Agent */
public class Agent implements IAgent {
    private static Agent singleton;
    private final RuntimeData data = new RuntimeData();
    private Callable<Void> jmxRegistration;
    private final IExceptionLogger logger;
    private final AgentOptions options;
    private IAgentOutput output;

    public static synchronized Agent getInstance(AgentOptions agentOptions) {
        Agent agent;
        synchronized (Agent.class) {
            if (singleton == null) {
                Agent agent2 = new Agent(agentOptions, IExceptionLogger.SYSTEM_ERR);
                agent2.startup();
                Runtime.getRuntime().addShutdownHook(new Thread(agent2) {
                    final /* synthetic */ Agent val$agent;

                    {
                        this.val$agent = r1;
                    }

                    public void run() {
                        this.val$agent.shutdown();
                    }
                });
                singleton = agent2;
            }
            agent = singleton;
        }
        return agent;
    }

    public static synchronized Agent getInstance() throws IllegalStateException {
        Agent agent;
        synchronized (Agent.class) {
            if (singleton != null) {
                agent = singleton;
            } else {
                throw new IllegalStateException("JaCoCo agent not started.");
            }
        }
        return agent;
    }

    Agent(AgentOptions agentOptions, IExceptionLogger iExceptionLogger) {
        this.options = agentOptions;
        this.logger = iExceptionLogger;
    }

    public RuntimeData getData() {
        return this.data;
    }

    public void startup() {
        try {
            String sessionId = this.options.getSessionId();
            if (sessionId == null) {
                sessionId = createSessionId();
            }
            this.data.setSessionId(sessionId);
            IAgentOutput createAgentOutput = createAgentOutput();
            this.output = createAgentOutput;
            createAgentOutput.startup(this.options, this.data);
            if (this.options.getJmx()) {
                this.jmxRegistration = new JmxRegistration(this);
            }
        } catch (Exception e) {
            this.logger.logExeption(e);
        }
    }

    public void shutdown() {
        try {
            if (this.options.getDumpOnExit()) {
                this.output.writeExecutionData(false);
            }
            this.output.shutdown();
            if (this.jmxRegistration != null) {
                this.jmxRegistration.call();
            }
        } catch (Exception e) {
            this.logger.logExeption(e);
        }
    }

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.Agent$2 */
    static /* synthetic */ class C28592 {
        static final /* synthetic */ int[] $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AgentOptions$OutputMode[] r0 = org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions.OutputMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode = r0
                org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AgentOptions$OutputMode r1 = org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions.OutputMode.file     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AgentOptions$OutputMode r1 = org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions.OutputMode.tcpserver     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AgentOptions$OutputMode r1 = org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions.OutputMode.tcpclient     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AgentOptions$OutputMode r1 = org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions.OutputMode.none     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.Agent.C28592.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public IAgentOutput createAgentOutput() {
        AgentOptions.OutputMode output2 = this.options.getOutput();
        int i = C28592.$SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode[output2.ordinal()];
        if (i == 1) {
            return new FileOutput();
        }
        if (i == 2) {
            return new TcpServerOutput(this.logger);
        }
        if (i == 3) {
            return new TcpClientOutput(this.logger);
        }
        if (i == 4) {
            return new NoneOutput();
        }
        throw new AssertionError(output2);
    }

    private String createSessionId() {
        String str;
        try {
            str = InetAddress.getLocalHost().getHostName();
        } catch (Exception unused) {
            str = "unknownhost";
        }
        return str + "-" + AbstractRuntime.createRandomId();
    }

    public String getVersion() {
        return JaCoCo.VERSION;
    }

    public String getSessionId() {
        return this.data.getSessionId();
    }

    public void setSessionId(String str) {
        this.data.setSessionId(str);
    }

    public void reset() {
        this.data.reset();
    }

    public byte[] getExecutionData(boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ExecutionDataWriter executionDataWriter = new ExecutionDataWriter(byteArrayOutputStream);
            this.data.collect(executionDataWriter, executionDataWriter, z);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public void dump(boolean z) throws IOException {
        this.output.writeExecutionData(z);
    }
}
