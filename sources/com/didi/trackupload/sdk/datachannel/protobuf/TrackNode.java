package com.didi.trackupload.sdk.datachannel.protobuf;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackNode extends Message {
    public static final List<String> DEFAULT_TAGS = Collections.emptyList();
    @SerializedName("loc")
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final TrackLocationInfo loc;
    @SerializedName("tags")
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> tags;

    public TrackNode(TrackLocationInfo trackLocationInfo, List<String> list) {
        this.loc = trackLocationInfo;
        this.tags = immutableCopyOf(list);
    }

    private TrackNode(Builder builder) {
        this(builder.loc, builder.tags);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackNode)) {
            return false;
        }
        TrackNode trackNode = (TrackNode) obj;
        if (!equals((Object) this.loc, (Object) trackNode.loc) || !equals((List<?>) this.tags, (List<?>) trackNode.tags)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        TrackLocationInfo trackLocationInfo = this.loc;
        int hashCode = (trackLocationInfo != null ? trackLocationInfo.hashCode() : 0) * 37;
        List<String> list = this.tags;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<TrackNode> {
        public TrackLocationInfo loc;
        public List<String> tags;

        public Builder() {
        }

        public Builder(TrackNode trackNode) {
            super(trackNode);
            if (trackNode != null) {
                this.loc = trackNode.loc;
                this.tags = TrackNode.copyOf(trackNode.tags);
            }
        }

        public Builder loc(TrackLocationInfo trackLocationInfo) {
            this.loc = trackLocationInfo;
            return this;
        }

        public Builder tags(List<String> list) {
            this.tags = checkForNulls(list);
            return this;
        }

        public TrackNode build() {
            checkRequiredFields();
            return new TrackNode(this);
        }
    }
}
