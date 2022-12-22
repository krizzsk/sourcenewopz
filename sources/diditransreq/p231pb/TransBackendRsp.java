package diditransreq.p231pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

/* renamed from: diditransreq.pb.TransBackendRsp */
public final class TransBackendRsp extends Message {
    public static final ByteString DEFAULT_COMPRESSED_PACK = ByteString.EMPTY;
    public static final Integer DEFAULT_COMPRESSION_FORMAT = 1;
    public static final String DEFAULT_MSG = "";
    public static final Long DEFAULT_SC = 0L;
    public static final Long DEFAULT_SEQID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.BYTES)
    public final ByteString compressed_pack;
    @ProtoField(label = Message.Label.OPTIONAL, tag = 5, type = Message.Datatype.UINT32)
    public final Integer compression_format;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)

    /* renamed from: sc */
    public final Long f57192sc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long seqid;

    public TransBackendRsp(Long l, Long l2, String str, ByteString byteString, Integer num) {
        this.seqid = l;
        this.f57192sc = l2;
        this.msg = str;
        this.compressed_pack = byteString;
        this.compression_format = num;
    }

    private TransBackendRsp(Builder builder) {
        this(builder.seqid, builder.f57193sc, builder.msg, builder.compressed_pack, builder.compression_format);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransBackendRsp)) {
            return false;
        }
        TransBackendRsp transBackendRsp = (TransBackendRsp) obj;
        if (!equals((Object) this.seqid, (Object) transBackendRsp.seqid) || !equals((Object) this.f57192sc, (Object) transBackendRsp.f57192sc) || !equals((Object) this.msg, (Object) transBackendRsp.msg) || !equals((Object) this.compressed_pack, (Object) transBackendRsp.compressed_pack) || !equals((Object) this.compression_format, (Object) transBackendRsp.compression_format)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.seqid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.f57192sc;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.msg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        ByteString byteString = this.compressed_pack;
        int hashCode4 = (hashCode3 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Integer num = this.compression_format;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: diditransreq.pb.TransBackendRsp$Builder */
    public static final class Builder extends Message.Builder<TransBackendRsp> {
        public ByteString compressed_pack;
        public Integer compression_format;
        public String msg;

        /* renamed from: sc */
        public Long f57193sc;
        public Long seqid;

        public Builder() {
        }

        public Builder(TransBackendRsp transBackendRsp) {
            super(transBackendRsp);
            if (transBackendRsp != null) {
                this.seqid = transBackendRsp.seqid;
                this.f57193sc = transBackendRsp.f57192sc;
                this.msg = transBackendRsp.msg;
                this.compressed_pack = transBackendRsp.compressed_pack;
                this.compression_format = transBackendRsp.compression_format;
            }
        }

        public Builder seqid(Long l) {
            this.seqid = l;
            return this;
        }

        /* renamed from: sc */
        public Builder mo170610sc(Long l) {
            this.f57193sc = l;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder compressed_pack(ByteString byteString) {
            this.compressed_pack = byteString;
            return this;
        }

        public Builder compression_format(Integer num) {
            this.compression_format = num;
            return this;
        }

        public TransBackendRsp build() {
            checkRequiredFields();
            return new TransBackendRsp(this);
        }
    }
}
