package org.webrtc;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.webrtc.DataChannel;
import org.webrtc.MediaStreamTrack;
import org.webrtc.RtpTransceiver;

public class PeerConnection {
    private final List<MediaStream> localStreams;
    private final long nativePeerConnection;
    private List<RtpReceiver> receivers;
    private List<RtpSender> senders;
    private List<RtpTransceiver> transceivers;

    public enum BundlePolicy {
        BALANCED,
        MAXBUNDLE,
        MAXCOMPAT
    }

    public enum CandidateNetworkPolicy {
        ALL,
        LOW_COST
    }

    public enum ContinualGatheringPolicy {
        GATHER_ONCE,
        GATHER_CONTINUALLY
    }

    public enum IceTransportsType {
        NONE,
        RELAY,
        NOHOST,
        ALL
    }

    public enum KeyType {
        RSA,
        ECDSA
    }

    public interface Observer {

        /* renamed from: org.webrtc.PeerConnection$Observer$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onConnectionChange(Observer observer, PeerConnectionState peerConnectionState) {
            }

            public static void $default$onSelectedCandidatePairChanged(Observer observer, CandidatePairChangeEvent candidatePairChangeEvent) {
            }

            public static void $default$onStandardizedIceConnectionChange(Observer observer, IceConnectionState iceConnectionState) {
            }

            public static void $default$onTrack(Observer observer, RtpTransceiver rtpTransceiver) {
            }
        }

        void onAddStream(MediaStream mediaStream);

        void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr);

        void onConnectionChange(PeerConnectionState peerConnectionState);

        void onDataChannel(DataChannel dataChannel);

        void onIceCandidate(IceCandidate iceCandidate);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);

        void onIceConnectionChange(IceConnectionState iceConnectionState);

        void onIceConnectionReceivingChange(boolean z);

        void onIceGatheringChange(IceGatheringState iceGatheringState);

        void onRemoveStream(MediaStream mediaStream);

        void onRenegotiationNeeded();

        void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent);

        void onSignalingChange(SignalingState signalingState);

        void onStandardizedIceConnectionChange(IceConnectionState iceConnectionState);

        void onTrack(RtpTransceiver rtpTransceiver);
    }

    public enum PortPrunePolicy {
        NO_PRUNE,
        PRUNE_BASED_ON_PRIORITY,
        KEEP_FIRST_READY
    }

    public enum RtcpMuxPolicy {
        NEGOTIATE,
        REQUIRE
    }

    public enum SdpSemantics {
        PLAN_B,
        UNIFIED_PLAN
    }

    public enum TcpCandidatePolicy {
        ENABLED,
        DISABLED
    }

    public enum TlsCertPolicy {
        TLS_CERT_POLICY_SECURE,
        TLS_CERT_POLICY_INSECURE_NO_CHECK
    }

    private native boolean nativeAddIceCandidate(String str, int i, String str2);

    private native boolean nativeAddLocalStream(long j);

    private native RtpSender nativeAddTrack(long j, List<String> list);

    private native RtpTransceiver nativeAddTransceiverOfType(MediaStreamTrack.MediaType mediaType, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit);

    private native RtpTransceiver nativeAddTransceiverWithTrack(long j, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit);

    private native void nativeClose();

    private native PeerConnectionState nativeConnectionState();

    private native void nativeCreateAnswer(SdpObserver sdpObserver, MediaConstraints mediaConstraints);

    private native DataChannel nativeCreateDataChannel(String str, DataChannel.Init init);

    private native void nativeCreateOffer(SdpObserver sdpObserver, MediaConstraints mediaConstraints);

    private static native long nativeCreatePeerConnectionObserver(Observer observer);

    private native RtpSender nativeCreateSender(String str, String str2);

    private static native void nativeFreeOwnedPeerConnection(long j);

    private native RtcCertificatePem nativeGetCertificate();

    private native SessionDescription nativeGetLocalDescription();

    private native long nativeGetNativePeerConnection();

    private native List<RtpReceiver> nativeGetReceivers();

    private native SessionDescription nativeGetRemoteDescription();

    private native List<RtpSender> nativeGetSenders();

    private native List<RtpTransceiver> nativeGetTransceivers();

    private native IceConnectionState nativeIceConnectionState();

    private native IceGatheringState nativeIceGatheringState();

    private native void nativeNewGetStats(RTCStatsCollectorCallback rTCStatsCollectorCallback);

    private native boolean nativeOldGetStats(StatsObserver statsObserver, long j);

    private native boolean nativeRemoveIceCandidates(IceCandidate[] iceCandidateArr);

    private native void nativeRemoveLocalStream(long j);

    private native boolean nativeRemoveTrack(long j);

    private native void nativeSetAudioPlayout(boolean z);

    private native void nativeSetAudioRecording(boolean z);

    private native boolean nativeSetBitrate(Integer num, Integer num2, Integer num3);

    private native boolean nativeSetConfiguration(RTCConfiguration rTCConfiguration);

    private native void nativeSetLocalDescription(SdpObserver sdpObserver, SessionDescription sessionDescription);

    private native void nativeSetRemoteDescription(SdpObserver sdpObserver, SessionDescription sessionDescription);

    private native SignalingState nativeSignalingState();

    private native boolean nativeStartRtcEventLog(int i, int i2);

    private native void nativeStopRtcEventLog();

    public enum IceGatheringState {
        NEW,
        GATHERING,
        COMPLETE;

        static IceGatheringState fromNativeIndex(int i) {
            return values()[i];
        }
    }

    public enum IceConnectionState {
        NEW,
        CHECKING,
        CONNECTED,
        COMPLETED,
        FAILED,
        DISCONNECTED,
        CLOSED;

        static IceConnectionState fromNativeIndex(int i) {
            return values()[i];
        }
    }

    public enum PeerConnectionState {
        NEW,
        CONNECTING,
        CONNECTED,
        DISCONNECTED,
        FAILED,
        CLOSED;

        static PeerConnectionState fromNativeIndex(int i) {
            return values()[i];
        }
    }

    public enum SignalingState {
        STABLE,
        HAVE_LOCAL_OFFER,
        HAVE_LOCAL_PRANSWER,
        HAVE_REMOTE_OFFER,
        HAVE_REMOTE_PRANSWER,
        CLOSED;

        static SignalingState fromNativeIndex(int i) {
            return values()[i];
        }
    }

    public static class IceServer {
        public final String hostname;
        public final String password;
        public final List<String> tlsAlpnProtocols;
        public final TlsCertPolicy tlsCertPolicy;
        public final List<String> tlsEllipticCurves;
        @Deprecated
        public final String uri;
        public final List<String> urls;
        public final String username;

        @Deprecated
        public IceServer(String str) {
            this(str, "", "");
        }

        @Deprecated
        public IceServer(String str, String str2, String str3) {
            this(str, str2, str3, TlsCertPolicy.TLS_CERT_POLICY_SECURE);
        }

        @Deprecated
        public IceServer(String str, String str2, String str3, TlsCertPolicy tlsCertPolicy2) {
            this(str, str2, str3, tlsCertPolicy2, "");
        }

        @Deprecated
        public IceServer(String str, String str2, String str3, TlsCertPolicy tlsCertPolicy2, String str4) {
            this(str, Collections.singletonList(str), str2, str3, tlsCertPolicy2, str4, (List<String>) null, (List<String>) null);
        }

        private IceServer(String str, List<String> list, String str2, String str3, TlsCertPolicy tlsCertPolicy2, String str4, List<String> list2, List<String> list3) {
            if (str == null || list == null || list.isEmpty()) {
                throw new IllegalArgumentException("uri == null || urls == null || urls.isEmpty()");
            }
            for (String str5 : list) {
                if (str5 == null) {
                    throw new IllegalArgumentException("urls element is null: " + list);
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("username == null");
            } else if (str3 == null) {
                throw new IllegalArgumentException("password == null");
            } else if (str4 != null) {
                this.uri = str;
                this.urls = list;
                this.username = str2;
                this.password = str3;
                this.tlsCertPolicy = tlsCertPolicy2;
                this.hostname = str4;
                this.tlsAlpnProtocols = list2;
                this.tlsEllipticCurves = list3;
            } else {
                throw new IllegalArgumentException("hostname == null");
            }
        }

        public String toString() {
            return this.urls + " [" + this.username + ":" + this.password + "] [" + this.tlsCertPolicy + "] [" + this.hostname + "] [" + this.tlsAlpnProtocols + "] [" + this.tlsEllipticCurves + Const.jaRight;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IceServer)) {
                return false;
            }
            IceServer iceServer = (IceServer) obj;
            if (!this.uri.equals(iceServer.uri) || !this.urls.equals(iceServer.urls) || !this.username.equals(iceServer.username) || !this.password.equals(iceServer.password) || !this.tlsCertPolicy.equals(iceServer.tlsCertPolicy) || !this.hostname.equals(iceServer.hostname) || !this.tlsAlpnProtocols.equals(iceServer.tlsAlpnProtocols) || !this.tlsEllipticCurves.equals(iceServer.tlsEllipticCurves)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.uri, this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves});
        }

        public static Builder builder(String str) {
            return new Builder(Collections.singletonList(str));
        }

        public static Builder builder(List<String> list) {
            return new Builder(list);
        }

        public static class Builder {
            private String hostname;
            private String password;
            private List<String> tlsAlpnProtocols;
            private TlsCertPolicy tlsCertPolicy;
            private List<String> tlsEllipticCurves;
            private final List<String> urls;
            private String username;

            private Builder(List<String> list) {
                this.username = "";
                this.password = "";
                this.tlsCertPolicy = TlsCertPolicy.TLS_CERT_POLICY_SECURE;
                this.hostname = "";
                if (list == null || list.isEmpty()) {
                    throw new IllegalArgumentException("urls == null || urls.isEmpty(): " + list);
                }
                this.urls = list;
            }

            public Builder setUsername(String str) {
                this.username = str;
                return this;
            }

            public Builder setPassword(String str) {
                this.password = str;
                return this;
            }

            public Builder setTlsCertPolicy(TlsCertPolicy tlsCertPolicy2) {
                this.tlsCertPolicy = tlsCertPolicy2;
                return this;
            }

            public Builder setHostname(String str) {
                this.hostname = str;
                return this;
            }

            public Builder setTlsAlpnProtocols(List<String> list) {
                this.tlsAlpnProtocols = list;
                return this;
            }

            public Builder setTlsEllipticCurves(List<String> list) {
                this.tlsEllipticCurves = list;
                return this;
            }

            public IceServer createIceServer() {
                return new IceServer(this.urls.get(0), this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves);
            }
        }

        /* access modifiers changed from: package-private */
        public List<String> getUrls() {
            return this.urls;
        }

        /* access modifiers changed from: package-private */
        public String getUsername() {
            return this.username;
        }

        /* access modifiers changed from: package-private */
        public String getPassword() {
            return this.password;
        }

        /* access modifiers changed from: package-private */
        public TlsCertPolicy getTlsCertPolicy() {
            return this.tlsCertPolicy;
        }

        /* access modifiers changed from: package-private */
        public String getHostname() {
            return this.hostname;
        }

        /* access modifiers changed from: package-private */
        public List<String> getTlsAlpnProtocols() {
            return this.tlsAlpnProtocols;
        }

        /* access modifiers changed from: package-private */
        public List<String> getTlsEllipticCurves() {
            return this.tlsEllipticCurves;
        }
    }

    public enum AdapterType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        CELLULAR(4),
        VPN(8),
        LOOPBACK(16),
        ADAPTER_TYPE_ANY(32);
        
        private static final Map<Integer, AdapterType> BY_BITMASK = null;
        public final Integer bitMask;

        static {
            int i;
            BY_BITMASK = new HashMap();
            for (AdapterType adapterType : values()) {
                BY_BITMASK.put(adapterType.bitMask, adapterType);
            }
        }

        private AdapterType(Integer num) {
            this.bitMask = num;
        }

        static AdapterType fromNativeIndex(int i) {
            return BY_BITMASK.get(Integer.valueOf(i));
        }
    }

    public static class IntervalRange {
        private final int max;
        private final int min;

        public IntervalRange(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        public int getMin() {
            return this.min;
        }

        public int getMax() {
            return this.max;
        }
    }

    public static class RTCConfiguration {
        public boolean activeResetSrtpParams;
        public boolean audioJitterBufferFastAccelerate;
        public int audioJitterBufferMaxPackets;
        public BundlePolicy bundlePolicy = BundlePolicy.BALANCED;
        public CandidateNetworkPolicy candidateNetworkPolicy = CandidateNetworkPolicy.ALL;
        public RtcCertificatePem certificate;
        public Boolean combinedAudioVideoBwe;
        public ContinualGatheringPolicy continualGatheringPolicy;
        public CryptoOptions cryptoOptions;
        public boolean disableIPv6OnWifi;
        public boolean disableIpv6;
        public boolean enableCpuOveruseDetection;
        public boolean enableDscp;
        public Boolean enableDtlsSrtp;
        public boolean enableRtpDataChannel;
        public int iceBackupCandidatePairPingInterval;
        public int iceCandidatePoolSize;
        public Integer iceCheckIntervalStrongConnectivityMs;
        public Integer iceCheckIntervalWeakConnectivityMs;
        public Integer iceCheckMinInterval;
        public int iceConnectionReceivingTimeout;
        public IntervalRange iceRegatherIntervalRange;
        public List<IceServer> iceServers;
        public IceTransportsType iceTransportsType = IceTransportsType.ALL;
        public Integer iceUnwritableMinChecks;
        public Integer iceUnwritableTimeMs;
        public KeyType keyType;
        public int maxIPv6Networks;
        public AdapterType networkPreference;
        public boolean presumeWritableWhenFullyRelayed;
        @Deprecated
        public boolean pruneTurnPorts;
        public RtcpMuxPolicy rtcpMuxPolicy = RtcpMuxPolicy.REQUIRE;
        public Integer screencastMinBitrate;
        public SdpSemantics sdpSemantics;
        public Integer stunCandidateKeepaliveIntervalMs;
        public boolean surfaceIceCandidatesOnIceTransportTypeChanged;
        public boolean suspendBelowMinBitrate;
        public TcpCandidatePolicy tcpCandidatePolicy = TcpCandidatePolicy.ENABLED;
        public TurnCustomizer turnCustomizer;
        public String turnLoggingId;
        public PortPrunePolicy turnPortPrunePolicy;
        public boolean useMediaTransport;
        public boolean useMediaTransportForDataChannels;

        public RTCConfiguration(List<IceServer> list) {
            this.iceServers = list;
            this.audioJitterBufferMaxPackets = 50;
            this.audioJitterBufferFastAccelerate = false;
            this.iceConnectionReceivingTimeout = -1;
            this.iceBackupCandidatePairPingInterval = -1;
            this.keyType = KeyType.ECDSA;
            this.continualGatheringPolicy = ContinualGatheringPolicy.GATHER_ONCE;
            this.iceCandidatePoolSize = 0;
            this.pruneTurnPorts = false;
            this.turnPortPrunePolicy = PortPrunePolicy.NO_PRUNE;
            this.presumeWritableWhenFullyRelayed = false;
            this.surfaceIceCandidatesOnIceTransportTypeChanged = false;
            this.iceCheckIntervalStrongConnectivityMs = null;
            this.iceCheckIntervalWeakConnectivityMs = null;
            this.iceCheckMinInterval = null;
            this.iceUnwritableTimeMs = null;
            this.iceUnwritableMinChecks = null;
            this.stunCandidateKeepaliveIntervalMs = null;
            this.disableIPv6OnWifi = false;
            this.maxIPv6Networks = 5;
            this.iceRegatherIntervalRange = null;
            this.disableIpv6 = false;
            this.enableDscp = false;
            this.enableCpuOveruseDetection = true;
            this.enableRtpDataChannel = false;
            this.suspendBelowMinBitrate = false;
            this.screencastMinBitrate = null;
            this.combinedAudioVideoBwe = null;
            this.enableDtlsSrtp = null;
            this.networkPreference = AdapterType.UNKNOWN;
            this.sdpSemantics = SdpSemantics.PLAN_B;
            this.activeResetSrtpParams = false;
            this.useMediaTransport = false;
            this.useMediaTransportForDataChannels = false;
            this.cryptoOptions = null;
            this.turnLoggingId = null;
        }

        /* access modifiers changed from: package-private */
        public IceTransportsType getIceTransportsType() {
            return this.iceTransportsType;
        }

        /* access modifiers changed from: package-private */
        public List<IceServer> getIceServers() {
            return this.iceServers;
        }

        /* access modifiers changed from: package-private */
        public BundlePolicy getBundlePolicy() {
            return this.bundlePolicy;
        }

        /* access modifiers changed from: package-private */
        public PortPrunePolicy getTurnPortPrunePolicy() {
            return this.turnPortPrunePolicy;
        }

        /* access modifiers changed from: package-private */
        public RtcCertificatePem getCertificate() {
            return this.certificate;
        }

        /* access modifiers changed from: package-private */
        public RtcpMuxPolicy getRtcpMuxPolicy() {
            return this.rtcpMuxPolicy;
        }

        /* access modifiers changed from: package-private */
        public TcpCandidatePolicy getTcpCandidatePolicy() {
            return this.tcpCandidatePolicy;
        }

        /* access modifiers changed from: package-private */
        public CandidateNetworkPolicy getCandidateNetworkPolicy() {
            return this.candidateNetworkPolicy;
        }

        /* access modifiers changed from: package-private */
        public int getAudioJitterBufferMaxPackets() {
            return this.audioJitterBufferMaxPackets;
        }

        /* access modifiers changed from: package-private */
        public boolean getAudioJitterBufferFastAccelerate() {
            return this.audioJitterBufferFastAccelerate;
        }

        /* access modifiers changed from: package-private */
        public int getIceConnectionReceivingTimeout() {
            return this.iceConnectionReceivingTimeout;
        }

        /* access modifiers changed from: package-private */
        public int getIceBackupCandidatePairPingInterval() {
            return this.iceBackupCandidatePairPingInterval;
        }

        /* access modifiers changed from: package-private */
        public KeyType getKeyType() {
            return this.keyType;
        }

        /* access modifiers changed from: package-private */
        public ContinualGatheringPolicy getContinualGatheringPolicy() {
            return this.continualGatheringPolicy;
        }

        /* access modifiers changed from: package-private */
        public int getIceCandidatePoolSize() {
            return this.iceCandidatePoolSize;
        }

        /* access modifiers changed from: package-private */
        public boolean getPruneTurnPorts() {
            return this.pruneTurnPorts;
        }

        /* access modifiers changed from: package-private */
        public boolean getPresumeWritableWhenFullyRelayed() {
            return this.presumeWritableWhenFullyRelayed;
        }

        /* access modifiers changed from: package-private */
        public boolean getSurfaceIceCandidatesOnIceTransportTypeChanged() {
            return this.surfaceIceCandidatesOnIceTransportTypeChanged;
        }

        /* access modifiers changed from: package-private */
        public Integer getIceCheckIntervalStrongConnectivity() {
            return this.iceCheckIntervalStrongConnectivityMs;
        }

        /* access modifiers changed from: package-private */
        public Integer getIceCheckIntervalWeakConnectivity() {
            return this.iceCheckIntervalWeakConnectivityMs;
        }

        /* access modifiers changed from: package-private */
        public Integer getIceCheckMinInterval() {
            return this.iceCheckMinInterval;
        }

        /* access modifiers changed from: package-private */
        public Integer getIceUnwritableTimeout() {
            return this.iceUnwritableTimeMs;
        }

        /* access modifiers changed from: package-private */
        public Integer getIceUnwritableMinChecks() {
            return this.iceUnwritableMinChecks;
        }

        /* access modifiers changed from: package-private */
        public Integer getStunCandidateKeepaliveInterval() {
            return this.stunCandidateKeepaliveIntervalMs;
        }

        /* access modifiers changed from: package-private */
        public boolean getDisableIPv6OnWifi() {
            return this.disableIPv6OnWifi;
        }

        /* access modifiers changed from: package-private */
        public int getMaxIPv6Networks() {
            return this.maxIPv6Networks;
        }

        /* access modifiers changed from: package-private */
        public IntervalRange getIceRegatherIntervalRange() {
            return this.iceRegatherIntervalRange;
        }

        /* access modifiers changed from: package-private */
        public TurnCustomizer getTurnCustomizer() {
            return this.turnCustomizer;
        }

        /* access modifiers changed from: package-private */
        public boolean getDisableIpv6() {
            return this.disableIpv6;
        }

        /* access modifiers changed from: package-private */
        public boolean getEnableDscp() {
            return this.enableDscp;
        }

        /* access modifiers changed from: package-private */
        public boolean getEnableCpuOveruseDetection() {
            return this.enableCpuOveruseDetection;
        }

        /* access modifiers changed from: package-private */
        public boolean getEnableRtpDataChannel() {
            return this.enableRtpDataChannel;
        }

        /* access modifiers changed from: package-private */
        public boolean getSuspendBelowMinBitrate() {
            return this.suspendBelowMinBitrate;
        }

        /* access modifiers changed from: package-private */
        public Integer getScreencastMinBitrate() {
            return this.screencastMinBitrate;
        }

        /* access modifiers changed from: package-private */
        public Boolean getCombinedAudioVideoBwe() {
            return this.combinedAudioVideoBwe;
        }

        /* access modifiers changed from: package-private */
        public Boolean getEnableDtlsSrtp() {
            return this.enableDtlsSrtp;
        }

        /* access modifiers changed from: package-private */
        public AdapterType getNetworkPreference() {
            return this.networkPreference;
        }

        /* access modifiers changed from: package-private */
        public SdpSemantics getSdpSemantics() {
            return this.sdpSemantics;
        }

        /* access modifiers changed from: package-private */
        public boolean getActiveResetSrtpParams() {
            return this.activeResetSrtpParams;
        }

        /* access modifiers changed from: package-private */
        public boolean getUseMediaTransport() {
            return this.useMediaTransport;
        }

        /* access modifiers changed from: package-private */
        public boolean getUseMediaTransportForDataChannels() {
            return this.useMediaTransportForDataChannels;
        }

        /* access modifiers changed from: package-private */
        public CryptoOptions getCryptoOptions() {
            return this.cryptoOptions;
        }

        /* access modifiers changed from: package-private */
        public String getTurnLoggingId() {
            return this.turnLoggingId;
        }
    }

    public PeerConnection(NativePeerConnectionFactory nativePeerConnectionFactory) {
        this(nativePeerConnectionFactory.createNativePeerConnection());
    }

    PeerConnection(long j) {
        this.localStreams = new ArrayList();
        this.senders = new ArrayList();
        this.receivers = new ArrayList();
        this.transceivers = new ArrayList();
        this.nativePeerConnection = j;
    }

    public SessionDescription getLocalDescription() {
        return nativeGetLocalDescription();
    }

    public SessionDescription getRemoteDescription() {
        return nativeGetRemoteDescription();
    }

    public RtcCertificatePem getCertificate() {
        return nativeGetCertificate();
    }

    public DataChannel createDataChannel(String str, DataChannel.Init init) {
        return nativeCreateDataChannel(str, init);
    }

    public void createOffer(SdpObserver sdpObserver, MediaConstraints mediaConstraints) {
        nativeCreateOffer(sdpObserver, mediaConstraints);
    }

    public void createAnswer(SdpObserver sdpObserver, MediaConstraints mediaConstraints) {
        nativeCreateAnswer(sdpObserver, mediaConstraints);
    }

    public void setLocalDescription(SdpObserver sdpObserver, SessionDescription sessionDescription) {
        nativeSetLocalDescription(sdpObserver, sessionDescription);
    }

    public void setRemoteDescription(SdpObserver sdpObserver, SessionDescription sessionDescription) {
        nativeSetRemoteDescription(sdpObserver, sessionDescription);
    }

    public void setAudioPlayout(boolean z) {
        nativeSetAudioPlayout(z);
    }

    public void setAudioRecording(boolean z) {
        nativeSetAudioRecording(z);
    }

    public boolean setConfiguration(RTCConfiguration rTCConfiguration) {
        return nativeSetConfiguration(rTCConfiguration);
    }

    public boolean addIceCandidate(IceCandidate iceCandidate) {
        return nativeAddIceCandidate(iceCandidate.sdpMid, iceCandidate.sdpMLineIndex, iceCandidate.sdp);
    }

    public boolean removeIceCandidates(IceCandidate[] iceCandidateArr) {
        return nativeRemoveIceCandidates(iceCandidateArr);
    }

    public boolean addStream(MediaStream mediaStream) {
        if (!nativeAddLocalStream(mediaStream.getNativeMediaStream())) {
            return false;
        }
        this.localStreams.add(mediaStream);
        return true;
    }

    public void removeStream(MediaStream mediaStream) {
        nativeRemoveLocalStream(mediaStream.getNativeMediaStream());
        this.localStreams.remove(mediaStream);
    }

    public RtpSender createSender(String str, String str2) {
        RtpSender nativeCreateSender = nativeCreateSender(str, str2);
        if (nativeCreateSender != null) {
            this.senders.add(nativeCreateSender);
        }
        return nativeCreateSender;
    }

    public List<RtpSender> getSenders() {
        for (RtpSender dispose : this.senders) {
            dispose.dispose();
        }
        List<RtpSender> nativeGetSenders = nativeGetSenders();
        this.senders = nativeGetSenders;
        return Collections.unmodifiableList(nativeGetSenders);
    }

    public List<RtpReceiver> getReceivers() {
        for (RtpReceiver dispose : this.receivers) {
            dispose.dispose();
        }
        List<RtpReceiver> nativeGetReceivers = nativeGetReceivers();
        this.receivers = nativeGetReceivers;
        return Collections.unmodifiableList(nativeGetReceivers);
    }

    public List<RtpTransceiver> getTransceivers() {
        for (RtpTransceiver dispose : this.transceivers) {
            dispose.dispose();
        }
        List<RtpTransceiver> nativeGetTransceivers = nativeGetTransceivers();
        this.transceivers = nativeGetTransceivers;
        return Collections.unmodifiableList(nativeGetTransceivers);
    }

    public RtpSender addTrack(MediaStreamTrack mediaStreamTrack) {
        return addTrack(mediaStreamTrack, Collections.emptyList());
    }

    public RtpSender addTrack(MediaStreamTrack mediaStreamTrack, List<String> list) {
        if (mediaStreamTrack == null || list == null) {
            throw new NullPointerException("No MediaStreamTrack specified in addTrack.");
        }
        RtpSender nativeAddTrack = nativeAddTrack(mediaStreamTrack.getNativeMediaStreamTrack(), list);
        if (nativeAddTrack != null) {
            this.senders.add(nativeAddTrack);
            return nativeAddTrack;
        }
        throw new IllegalStateException("C++ addTrack failed.");
    }

    public boolean removeTrack(RtpSender rtpSender) {
        if (rtpSender != null) {
            return nativeRemoveTrack(rtpSender.getNativeRtpSender());
        }
        throw new NullPointerException("No RtpSender specified for removeTrack.");
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack mediaStreamTrack) {
        return addTransceiver(mediaStreamTrack, new RtpTransceiver.RtpTransceiverInit());
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack mediaStreamTrack, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit) {
        if (mediaStreamTrack != null) {
            if (rtpTransceiverInit == null) {
                rtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
            }
            RtpTransceiver nativeAddTransceiverWithTrack = nativeAddTransceiverWithTrack(mediaStreamTrack.getNativeMediaStreamTrack(), rtpTransceiverInit);
            if (nativeAddTransceiverWithTrack != null) {
                this.transceivers.add(nativeAddTransceiverWithTrack);
                return nativeAddTransceiverWithTrack;
            }
            throw new IllegalStateException("C++ addTransceiver failed.");
        }
        throw new NullPointerException("No MediaStreamTrack specified for addTransceiver.");
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType mediaType) {
        return addTransceiver(mediaType, new RtpTransceiver.RtpTransceiverInit());
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType mediaType, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit) {
        if (mediaType != null) {
            if (rtpTransceiverInit == null) {
                rtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
            }
            RtpTransceiver nativeAddTransceiverOfType = nativeAddTransceiverOfType(mediaType, rtpTransceiverInit);
            if (nativeAddTransceiverOfType != null) {
                this.transceivers.add(nativeAddTransceiverOfType);
                return nativeAddTransceiverOfType;
            }
            throw new IllegalStateException("C++ addTransceiver failed.");
        }
        throw new NullPointerException("No MediaType specified for addTransceiver.");
    }

    @Deprecated
    public boolean getStats(StatsObserver statsObserver, MediaStreamTrack mediaStreamTrack) {
        return nativeOldGetStats(statsObserver, mediaStreamTrack == null ? 0 : mediaStreamTrack.getNativeMediaStreamTrack());
    }

    public void getStats(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
        nativeNewGetStats(rTCStatsCollectorCallback);
    }

    public boolean setBitrate(Integer num, Integer num2, Integer num3) {
        return nativeSetBitrate(num, num2, num3);
    }

    public boolean startRtcEventLog(int i, int i2) {
        return nativeStartRtcEventLog(i, i2);
    }

    public void stopRtcEventLog() {
        nativeStopRtcEventLog();
    }

    public SignalingState signalingState() {
        return nativeSignalingState();
    }

    public IceConnectionState iceConnectionState() {
        return nativeIceConnectionState();
    }

    public PeerConnectionState connectionState() {
        return nativeConnectionState();
    }

    public IceGatheringState iceGatheringState() {
        return nativeIceGatheringState();
    }

    public void close() {
        nativeClose();
    }

    public void dispose() {
        close();
        for (MediaStream next : this.localStreams) {
            nativeRemoveLocalStream(next.getNativeMediaStream());
            next.dispose();
        }
        this.localStreams.clear();
        for (RtpSender dispose : this.senders) {
            dispose.dispose();
        }
        this.senders.clear();
        for (RtpReceiver dispose2 : this.receivers) {
            dispose2.dispose();
        }
        for (RtpTransceiver dispose3 : this.transceivers) {
            dispose3.dispose();
        }
        this.transceivers.clear();
        this.receivers.clear();
        nativeFreeOwnedPeerConnection(this.nativePeerConnection);
    }

    public long getNativePeerConnection() {
        return nativeGetNativePeerConnection();
    }

    /* access modifiers changed from: package-private */
    public long getNativeOwnedPeerConnection() {
        return this.nativePeerConnection;
    }

    public static long createNativePeerConnectionObserver(Observer observer) {
        return nativeCreatePeerConnectionObserver(observer);
    }
}
