package org.webrtc;

import java.util.List;
import java.util.Map;
import org.webrtc.MediaStreamTrack;

public class RtpParameters {
    public final List<Codec> codecs;
    public final List<Encoding> encodings;
    private final List<HeaderExtension> headerExtensions;
    private final Rtcp rtcp;
    public final String transactionId;

    public static class Encoding {
        public boolean active = true;
        public Integer maxBitrateBps;
        public Integer maxFramerate;
        public Integer minBitrateBps;
        public Integer numTemporalLayers;
        public String rid;
        public Double scaleResolutionDownBy;
        public Long ssrc;

        Encoding(String str, boolean z, Double d) {
            this.rid = str;
            this.active = z;
            this.scaleResolutionDownBy = d;
        }

        Encoding(String str, boolean z, Integer num, Integer num2, Integer num3, Integer num4, Double d, Long l) {
            this.rid = str;
            this.active = z;
            this.maxBitrateBps = num;
            this.minBitrateBps = num2;
            this.maxFramerate = num3;
            this.numTemporalLayers = num4;
            this.scaleResolutionDownBy = d;
            this.ssrc = l;
        }

        /* access modifiers changed from: package-private */
        public String getRid() {
            return this.rid;
        }

        /* access modifiers changed from: package-private */
        public boolean getActive() {
            return this.active;
        }

        /* access modifiers changed from: package-private */
        public Integer getMaxBitrateBps() {
            return this.maxBitrateBps;
        }

        /* access modifiers changed from: package-private */
        public Integer getMinBitrateBps() {
            return this.minBitrateBps;
        }

        /* access modifiers changed from: package-private */
        public Integer getMaxFramerate() {
            return this.maxFramerate;
        }

        /* access modifiers changed from: package-private */
        public Integer getNumTemporalLayers() {
            return this.numTemporalLayers;
        }

        /* access modifiers changed from: package-private */
        public Double getScaleResolutionDownBy() {
            return this.scaleResolutionDownBy;
        }

        /* access modifiers changed from: package-private */
        public Long getSsrc() {
            return this.ssrc;
        }
    }

    public static class Codec {
        public Integer clockRate;
        MediaStreamTrack.MediaType kind;
        public String name;
        public Integer numChannels;
        public Map<String, String> parameters;
        public int payloadType;

        Codec(int i, String str, MediaStreamTrack.MediaType mediaType, Integer num, Integer num2, Map<String, String> map) {
            this.payloadType = i;
            this.name = str;
            this.kind = mediaType;
            this.clockRate = num;
            this.numChannels = num2;
            this.parameters = map;
        }

        /* access modifiers changed from: package-private */
        public int getPayloadType() {
            return this.payloadType;
        }

        /* access modifiers changed from: package-private */
        public String getName() {
            return this.name;
        }

        /* access modifiers changed from: package-private */
        public MediaStreamTrack.MediaType getKind() {
            return this.kind;
        }

        /* access modifiers changed from: package-private */
        public Integer getClockRate() {
            return this.clockRate;
        }

        /* access modifiers changed from: package-private */
        public Integer getNumChannels() {
            return this.numChannels;
        }

        /* access modifiers changed from: package-private */
        public Map getParameters() {
            return this.parameters;
        }
    }

    public static class Rtcp {
        private final String cname;
        private final boolean reducedSize;

        Rtcp(String str, boolean z) {
            this.cname = str;
            this.reducedSize = z;
        }

        public String getCname() {
            return this.cname;
        }

        public boolean getReducedSize() {
            return this.reducedSize;
        }
    }

    public static class HeaderExtension {
        private final boolean encrypted;

        /* renamed from: id */
        private final int f6708id;
        private final String uri;

        HeaderExtension(String str, int i, boolean z) {
            this.uri = str;
            this.f6708id = i;
            this.encrypted = z;
        }

        public String getUri() {
            return this.uri;
        }

        public int getId() {
            return this.f6708id;
        }

        public boolean getEncrypted() {
            return this.encrypted;
        }
    }

    RtpParameters(String str, Rtcp rtcp2, List<HeaderExtension> list, List<Encoding> list2, List<Codec> list3) {
        this.transactionId = str;
        this.rtcp = rtcp2;
        this.headerExtensions = list;
        this.encodings = list2;
        this.codecs = list3;
    }

    /* access modifiers changed from: package-private */
    public String getTransactionId() {
        return this.transactionId;
    }

    public Rtcp getRtcp() {
        return this.rtcp;
    }

    public List<HeaderExtension> getHeaderExtensions() {
        return this.headerExtensions;
    }

    /* access modifiers changed from: package-private */
    public List<Encoding> getEncodings() {
        return this.encodings;
    }

    /* access modifiers changed from: package-private */
    public List<Codec> getCodecs() {
        return this.codecs;
    }
}
