package com.didi.trackupload.sdk.datachannel.protobuf;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class BizNode extends Message {
    public static final ClientType DEFAULT_CLIENT_TYPE = ClientType.DRIVER;
    public static final ByteString DEFAULT_EXTRA_DATA = ByteString.EMPTY;
    public static final String DEFAULT_TAG = "";
    @SerializedName("client_type")
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.ENUM)
    public final ClientType client_type;
    @SerializedName("extra_data")
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final transient ByteString extra_data;
    @SerializedName("tag")
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String tag;

    public BizNode(String str, ClientType clientType, ByteString byteString) {
        this.tag = str;
        this.client_type = clientType;
        this.extra_data = byteString;
    }

    private BizNode(Builder builder) {
        this(builder.tag, builder.client_type, builder.extra_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BizNode)) {
            return false;
        }
        BizNode bizNode = (BizNode) obj;
        if (!equals((Object) this.tag, (Object) bizNode.tag) || !equals((Object) this.client_type, (Object) bizNode.client_type) || !equals((Object) this.extra_data, (Object) bizNode.extra_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.tag;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        ClientType clientType = this.client_type;
        int hashCode2 = (hashCode + (clientType != null ? clientType.hashCode() : 0)) * 37;
        ByteString byteString = this.extra_data;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BizNode> {
        public ClientType client_type;
        public ByteString extra_data;
        public String tag;

        public Builder() {
        }

        public Builder(BizNode bizNode) {
            super(bizNode);
            if (bizNode != null) {
                this.tag = bizNode.tag;
                this.client_type = bizNode.client_type;
                this.extra_data = bizNode.extra_data;
            }
        }

        public Builder tag(String str) {
            this.tag = str;
            return this;
        }

        public Builder client_type(ClientType clientType) {
            this.client_type = clientType;
            return this;
        }

        public Builder extra_data(ByteString byteString) {
            this.extra_data = byteString;
            return this;
        }

        public BizNode build() {
            checkRequiredFields();
            return new BizNode(this);
        }
    }
}
