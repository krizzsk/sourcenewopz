package didi_map_config_proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class DidiMapConfigProtoMapConfig {

    public interface MapDataFileOrBuilder extends MessageLiteOrBuilder {
        ByteString getFilebody();

        String getMd5();

        ByteString getMd5Bytes();

        String getName();

        ByteString getNameBytes();

        int getVersion();

        boolean hasFilebody();

        boolean hasMd5();

        boolean hasName();

        boolean hasVersion();
    }

    public interface MapDataInfoOrBuilder extends MessageLiteOrBuilder {
        int getMethod();

        String getName();

        ByteString getNameBytes();

        int getVersion();

        boolean hasMethod();

        boolean hasName();

        boolean hasVersion();
    }

    public interface MapDataURLOrBuilder extends MessageLiteOrBuilder {
        String getMd5();

        ByteString getMd5Bytes();

        String getName();

        ByteString getNameBytes();

        String getUrl();

        ByteString getUrlBytes();

        int getVersion();

        boolean hasMd5();

        boolean hasName();

        boolean hasUrl();

        boolean hasVersion();
    }

    public interface MapDataUpdateReqOrBuilder extends MessageLiteOrBuilder {
        String getDevice();

        ByteString getDeviceBytes();

        String getDidiVersion();

        ByteString getDidiVersionBytes();

        String getImei();

        ByteString getImeiBytes();

        long getLastUpdateTimestamp();

        MapDataInfo getLocalDatas(int i);

        int getLocalDatasCount();

        List<MapDataInfo> getLocalDatasList();

        String getPhone();

        ByteString getPhoneBytes();

        String getSdkVersion();

        ByteString getSdkVersionBytes();

        String getToken();

        ByteString getTokenBytes();

        boolean hasDevice();

        boolean hasDidiVersion();

        boolean hasImei();

        boolean hasLastUpdateTimestamp();

        boolean hasPhone();

        boolean hasSdkVersion();

        boolean hasToken();
    }

    public interface MapDataUpdateResOrBuilder extends MessageLiteOrBuilder {
        String getMsg();

        ByteString getMsgBytes();

        int getRet();

        MapDataFile getUpdateFiles(int i);

        int getUpdateFilesCount();

        List<MapDataFile> getUpdateFilesList();

        MapDataURL getUpdateUrls(int i);

        int getUpdateUrlsCount();

        List<MapDataURL> getUpdateUrlsList();

        boolean hasMsg();

        boolean hasRet();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private DidiMapConfigProtoMapConfig() {
    }

    public static final class MapDataURL extends GeneratedMessageLite<MapDataURL, Builder> implements MapDataURLOrBuilder {
        /* access modifiers changed from: private */
        public static final MapDataURL DEFAULT_INSTANCE;
        public static final int MD5_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<MapDataURL> PARSER = null;
        public static final int URL_FIELD_NUMBER = 3;
        public static final int VERSION_FIELD_NUMBER = 2;
        private int bitField0_;
        private String md5_ = "";
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private String url_ = "";
        private int version_;

        private MapDataURL() {
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getName() {
            return this.name_;
        }

        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* access modifiers changed from: private */
        public void setName(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.name_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.name_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getVersion() {
            return this.version_;
        }

        /* access modifiers changed from: private */
        public void setVersion(int i) {
            this.bitField0_ |= 2;
            this.version_ = i;
        }

        /* access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -3;
            this.version_ = 0;
        }

        public boolean hasUrl() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getUrl() {
            return this.url_;
        }

        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        /* access modifiers changed from: private */
        public void setUrl(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.url_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearUrl() {
            this.bitField0_ &= -5;
            this.url_ = getDefaultInstance().getUrl();
        }

        /* access modifiers changed from: private */
        public void setUrlBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 4;
                this.url_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasMd5() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getMd5() {
            return this.md5_;
        }

        public ByteString getMd5Bytes() {
            return ByteString.copyFromUtf8(this.md5_);
        }

        /* access modifiers changed from: private */
        public void setMd5(String str) {
            if (str != null) {
                this.bitField0_ |= 8;
                this.md5_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearMd5() {
            this.bitField0_ &= -9;
            this.md5_ = getDefaultInstance().getMd5();
        }

        /* access modifiers changed from: private */
        public void setMd5Bytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 8;
                this.md5_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.version_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getUrl());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getMd5());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(2, this.version_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeStringSize(3, getUrl());
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeStringSize(4, getMd5());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static MapDataURL parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MapDataURL parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MapDataURL parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MapDataURL parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MapDataURL parseFrom(InputStream inputStream) throws IOException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataURL parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataURL parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MapDataURL) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataURL parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataURL) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataURL parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MapDataURL parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataURL) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapDataURL mapDataURL) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(mapDataURL);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MapDataURL, Builder> implements MapDataURLOrBuilder {
            /* synthetic */ Builder(C207281 r1) {
                this();
            }

            private Builder() {
                super(MapDataURL.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((MapDataURL) this.instance).hasName();
            }

            public String getName() {
                return ((MapDataURL) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((MapDataURL) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((MapDataURL) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((MapDataURL) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataURL) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasVersion() {
                return ((MapDataURL) this.instance).hasVersion();
            }

            public int getVersion() {
                return ((MapDataURL) this.instance).getVersion();
            }

            public Builder setVersion(int i) {
                copyOnWrite();
                ((MapDataURL) this.instance).setVersion(i);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((MapDataURL) this.instance).clearVersion();
                return this;
            }

            public boolean hasUrl() {
                return ((MapDataURL) this.instance).hasUrl();
            }

            public String getUrl() {
                return ((MapDataURL) this.instance).getUrl();
            }

            public ByteString getUrlBytes() {
                return ((MapDataURL) this.instance).getUrlBytes();
            }

            public Builder setUrl(String str) {
                copyOnWrite();
                ((MapDataURL) this.instance).setUrl(str);
                return this;
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((MapDataURL) this.instance).clearUrl();
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataURL) this.instance).setUrlBytes(byteString);
                return this;
            }

            public boolean hasMd5() {
                return ((MapDataURL) this.instance).hasMd5();
            }

            public String getMd5() {
                return ((MapDataURL) this.instance).getMd5();
            }

            public ByteString getMd5Bytes() {
                return ((MapDataURL) this.instance).getMd5Bytes();
            }

            public Builder setMd5(String str) {
                copyOnWrite();
                ((MapDataURL) this.instance).setMd5(str);
                return this;
            }

            public Builder clearMd5() {
                copyOnWrite();
                ((MapDataURL) this.instance).clearMd5();
                return this;
            }

            public Builder setMd5Bytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataURL) this.instance).setMd5Bytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (C207281.f56307xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MapDataURL();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasName()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasVersion()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasUrl()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasMd5()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                case 3:
                    return null;
                case 4:
                    return new Builder((C207281) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MapDataURL mapDataURL = (MapDataURL) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, mapDataURL.hasName(), mapDataURL.name_);
                    this.version_ = visitor.visitInt(hasVersion(), this.version_, mapDataURL.hasVersion(), mapDataURL.version_);
                    this.url_ = visitor.visitString(hasUrl(), this.url_, mapDataURL.hasUrl(), mapDataURL.url_);
                    this.md5_ = visitor.visitString(hasMd5(), this.md5_, mapDataURL.hasMd5(), mapDataURL.md5_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= mapDataURL.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.version_ = codedInputStream.readInt32();
                                } else if (readTag == 26) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.url_ = readString2;
                                } else if (readTag == 34) {
                                    String readString3 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.md5_ = readString3;
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (MapDataURL.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            MapDataURL mapDataURL = new MapDataURL();
            DEFAULT_INSTANCE = mapDataURL;
            mapDataURL.makeImmutable();
        }

        public static MapDataURL getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapDataURL> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: didi_map_config_proto.DidiMapConfigProtoMapConfig$1 */
    static /* synthetic */ class C207281 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f56307xa1df5c61;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f56307xa1df5c61 = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f56307xa1df5c61     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f56307xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f56307xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f56307xa1df5c61     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f56307xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f56307xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f56307xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: didi_map_config_proto.DidiMapConfigProtoMapConfig.C207281.<clinit>():void");
        }
    }

    public static final class MapDataFile extends GeneratedMessageLite<MapDataFile, Builder> implements MapDataFileOrBuilder {
        /* access modifiers changed from: private */
        public static final MapDataFile DEFAULT_INSTANCE;
        public static final int FILEBODY_FIELD_NUMBER = 3;
        public static final int MD5_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<MapDataFile> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 2;
        private int bitField0_;
        private ByteString filebody_ = ByteString.EMPTY;
        private String md5_ = "";
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private int version_;

        private MapDataFile() {
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getName() {
            return this.name_;
        }

        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* access modifiers changed from: private */
        public void setName(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.name_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.name_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getVersion() {
            return this.version_;
        }

        /* access modifiers changed from: private */
        public void setVersion(int i) {
            this.bitField0_ |= 2;
            this.version_ = i;
        }

        /* access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -3;
            this.version_ = 0;
        }

        public boolean hasFilebody() {
            return (this.bitField0_ & 4) == 4;
        }

        public ByteString getFilebody() {
            return this.filebody_;
        }

        /* access modifiers changed from: private */
        public void setFilebody(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 4;
                this.filebody_ = byteString;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearFilebody() {
            this.bitField0_ &= -5;
            this.filebody_ = getDefaultInstance().getFilebody();
        }

        public boolean hasMd5() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getMd5() {
            return this.md5_;
        }

        public ByteString getMd5Bytes() {
            return ByteString.copyFromUtf8(this.md5_);
        }

        /* access modifiers changed from: private */
        public void setMd5(String str) {
            if (str != null) {
                this.bitField0_ |= 8;
                this.md5_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearMd5() {
            this.bitField0_ &= -9;
            this.md5_ = getDefaultInstance().getMd5();
        }

        /* access modifiers changed from: private */
        public void setMd5Bytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 8;
                this.md5_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.version_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, this.filebody_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getMd5());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(2, this.version_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(3, this.filebody_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeStringSize(4, getMd5());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static MapDataFile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MapDataFile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MapDataFile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MapDataFile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MapDataFile parseFrom(InputStream inputStream) throws IOException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataFile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataFile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MapDataFile) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataFile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataFile) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataFile parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MapDataFile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapDataFile mapDataFile) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(mapDataFile);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MapDataFile, Builder> implements MapDataFileOrBuilder {
            /* synthetic */ Builder(C207281 r1) {
                this();
            }

            private Builder() {
                super(MapDataFile.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((MapDataFile) this.instance).hasName();
            }

            public String getName() {
                return ((MapDataFile) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((MapDataFile) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((MapDataFile) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((MapDataFile) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataFile) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasVersion() {
                return ((MapDataFile) this.instance).hasVersion();
            }

            public int getVersion() {
                return ((MapDataFile) this.instance).getVersion();
            }

            public Builder setVersion(int i) {
                copyOnWrite();
                ((MapDataFile) this.instance).setVersion(i);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((MapDataFile) this.instance).clearVersion();
                return this;
            }

            public boolean hasFilebody() {
                return ((MapDataFile) this.instance).hasFilebody();
            }

            public ByteString getFilebody() {
                return ((MapDataFile) this.instance).getFilebody();
            }

            public Builder setFilebody(ByteString byteString) {
                copyOnWrite();
                ((MapDataFile) this.instance).setFilebody(byteString);
                return this;
            }

            public Builder clearFilebody() {
                copyOnWrite();
                ((MapDataFile) this.instance).clearFilebody();
                return this;
            }

            public boolean hasMd5() {
                return ((MapDataFile) this.instance).hasMd5();
            }

            public String getMd5() {
                return ((MapDataFile) this.instance).getMd5();
            }

            public ByteString getMd5Bytes() {
                return ((MapDataFile) this.instance).getMd5Bytes();
            }

            public Builder setMd5(String str) {
                copyOnWrite();
                ((MapDataFile) this.instance).setMd5(str);
                return this;
            }

            public Builder clearMd5() {
                copyOnWrite();
                ((MapDataFile) this.instance).clearMd5();
                return this;
            }

            public Builder setMd5Bytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataFile) this.instance).setMd5Bytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (C207281.f56307xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MapDataFile();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasName()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasVersion()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasFilebody()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasMd5()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                case 3:
                    return null;
                case 4:
                    return new Builder((C207281) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MapDataFile mapDataFile = (MapDataFile) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, mapDataFile.hasName(), mapDataFile.name_);
                    this.version_ = visitor.visitInt(hasVersion(), this.version_, mapDataFile.hasVersion(), mapDataFile.version_);
                    this.filebody_ = visitor.visitByteString(hasFilebody(), this.filebody_, mapDataFile.hasFilebody(), mapDataFile.filebody_);
                    this.md5_ = visitor.visitString(hasMd5(), this.md5_, mapDataFile.hasMd5(), mapDataFile.md5_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= mapDataFile.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.version_ = codedInputStream.readInt32();
                                } else if (readTag == 26) {
                                    this.bitField0_ |= 4;
                                    this.filebody_ = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.md5_ = readString2;
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (MapDataFile.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            MapDataFile mapDataFile = new MapDataFile();
            DEFAULT_INSTANCE = mapDataFile;
            mapDataFile.makeImmutable();
        }

        public static MapDataFile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapDataFile> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MapDataInfo extends GeneratedMessageLite<MapDataInfo, Builder> implements MapDataInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final MapDataInfo DEFAULT_INSTANCE;
        public static final int METHOD_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<MapDataInfo> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 2;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private int method_;
        private String name_ = "";
        private int version_;

        private MapDataInfo() {
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getName() {
            return this.name_;
        }

        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* access modifiers changed from: private */
        public void setName(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.name_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.name_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getVersion() {
            return this.version_;
        }

        /* access modifiers changed from: private */
        public void setVersion(int i) {
            this.bitField0_ |= 2;
            this.version_ = i;
        }

        /* access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -3;
            this.version_ = 0;
        }

        public boolean hasMethod() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getMethod() {
            return this.method_;
        }

        /* access modifiers changed from: private */
        public void setMethod(int i) {
            this.bitField0_ |= 4;
            this.method_ = i;
        }

        /* access modifiers changed from: private */
        public void clearMethod() {
            this.bitField0_ &= -5;
            this.method_ = 0;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.version_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.method_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(2, this.version_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeInt32Size(3, this.method_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static MapDataInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MapDataInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MapDataInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MapDataInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MapDataInfo parseFrom(InputStream inputStream) throws IOException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MapDataInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MapDataInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapDataInfo mapDataInfo) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(mapDataInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MapDataInfo, Builder> implements MapDataInfoOrBuilder {
            /* synthetic */ Builder(C207281 r1) {
                this();
            }

            private Builder() {
                super(MapDataInfo.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((MapDataInfo) this.instance).hasName();
            }

            public String getName() {
                return ((MapDataInfo) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((MapDataInfo) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((MapDataInfo) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((MapDataInfo) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataInfo) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasVersion() {
                return ((MapDataInfo) this.instance).hasVersion();
            }

            public int getVersion() {
                return ((MapDataInfo) this.instance).getVersion();
            }

            public Builder setVersion(int i) {
                copyOnWrite();
                ((MapDataInfo) this.instance).setVersion(i);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((MapDataInfo) this.instance).clearVersion();
                return this;
            }

            public boolean hasMethod() {
                return ((MapDataInfo) this.instance).hasMethod();
            }

            public int getMethod() {
                return ((MapDataInfo) this.instance).getMethod();
            }

            public Builder setMethod(int i) {
                copyOnWrite();
                ((MapDataInfo) this.instance).setMethod(i);
                return this;
            }

            public Builder clearMethod() {
                copyOnWrite();
                ((MapDataInfo) this.instance).clearMethod();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (C207281.f56307xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MapDataInfo();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasName()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasVersion()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasMethod()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                case 3:
                    return null;
                case 4:
                    return new Builder((C207281) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MapDataInfo mapDataInfo = (MapDataInfo) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, mapDataInfo.hasName(), mapDataInfo.name_);
                    this.version_ = visitor.visitInt(hasVersion(), this.version_, mapDataInfo.hasVersion(), mapDataInfo.version_);
                    this.method_ = visitor.visitInt(hasMethod(), this.method_, mapDataInfo.hasMethod(), mapDataInfo.method_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= mapDataInfo.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.version_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 4;
                                    this.method_ = codedInputStream.readInt32();
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (MapDataInfo.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            MapDataInfo mapDataInfo = new MapDataInfo();
            DEFAULT_INSTANCE = mapDataInfo;
            mapDataInfo.makeImmutable();
        }

        public static MapDataInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapDataInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MapDataUpdateReq extends GeneratedMessageLite<MapDataUpdateReq, Builder> implements MapDataUpdateReqOrBuilder {
        /* access modifiers changed from: private */
        public static final MapDataUpdateReq DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 6;
        public static final int DIDIVERSION_FIELD_NUMBER = 4;
        public static final int IMEI_FIELD_NUMBER = 2;
        public static final int LASTUPDATETIMESTAMP_FIELD_NUMBER = 5;
        public static final int LOCALDATAS_FIELD_NUMBER = 3;
        private static volatile Parser<MapDataUpdateReq> PARSER = null;
        public static final int PHONE_FIELD_NUMBER = 7;
        public static final int SDKVERSION_FIELD_NUMBER = 1;
        public static final int TOKEN_FIELD_NUMBER = 8;
        private int bitField0_;
        private String device_ = "";
        private String didiVersion_ = "";
        private String imei_ = "";
        private long lastUpdateTimestamp_;
        private Internal.ProtobufList<MapDataInfo> localDatas_ = emptyProtobufList();
        private byte memoizedIsInitialized = -1;
        private String phone_ = "";
        private String sdkVersion_ = "";
        private String token_ = "";

        private MapDataUpdateReq() {
        }

        public boolean hasSdkVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getSdkVersion() {
            return this.sdkVersion_;
        }

        public ByteString getSdkVersionBytes() {
            return ByteString.copyFromUtf8(this.sdkVersion_);
        }

        /* access modifiers changed from: private */
        public void setSdkVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.sdkVersion_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearSdkVersion() {
            this.bitField0_ &= -2;
            this.sdkVersion_ = getDefaultInstance().getSdkVersion();
        }

        /* access modifiers changed from: private */
        public void setSdkVersionBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.sdkVersion_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasImei() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getImei() {
            return this.imei_;
        }

        public ByteString getImeiBytes() {
            return ByteString.copyFromUtf8(this.imei_);
        }

        /* access modifiers changed from: private */
        public void setImei(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.imei_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearImei() {
            this.bitField0_ &= -3;
            this.imei_ = getDefaultInstance().getImei();
        }

        /* access modifiers changed from: private */
        public void setImeiBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.imei_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public List<MapDataInfo> getLocalDatasList() {
            return this.localDatas_;
        }

        public List<? extends MapDataInfoOrBuilder> getLocalDatasOrBuilderList() {
            return this.localDatas_;
        }

        public int getLocalDatasCount() {
            return this.localDatas_.size();
        }

        public MapDataInfo getLocalDatas(int i) {
            return (MapDataInfo) this.localDatas_.get(i);
        }

        public MapDataInfoOrBuilder getLocalDatasOrBuilder(int i) {
            return (MapDataInfoOrBuilder) this.localDatas_.get(i);
        }

        private void ensureLocalDatasIsMutable() {
            if (!this.localDatas_.isModifiable()) {
                this.localDatas_ = GeneratedMessageLite.mutableCopy(this.localDatas_);
            }
        }

        /* access modifiers changed from: private */
        public void setLocalDatas(int i, MapDataInfo mapDataInfo) {
            if (mapDataInfo != null) {
                ensureLocalDatasIsMutable();
                this.localDatas_.set(i, mapDataInfo);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setLocalDatas(int i, MapDataInfo.Builder builder) {
            ensureLocalDatasIsMutable();
            this.localDatas_.set(i, (MapDataInfo) builder.build());
        }

        /* access modifiers changed from: private */
        public void addLocalDatas(MapDataInfo mapDataInfo) {
            if (mapDataInfo != null) {
                ensureLocalDatasIsMutable();
                this.localDatas_.add(mapDataInfo);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addLocalDatas(int i, MapDataInfo mapDataInfo) {
            if (mapDataInfo != null) {
                ensureLocalDatasIsMutable();
                this.localDatas_.add(i, mapDataInfo);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addLocalDatas(MapDataInfo.Builder builder) {
            ensureLocalDatasIsMutable();
            this.localDatas_.add((MapDataInfo) builder.build());
        }

        /* access modifiers changed from: private */
        public void addLocalDatas(int i, MapDataInfo.Builder builder) {
            ensureLocalDatasIsMutable();
            this.localDatas_.add(i, (MapDataInfo) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllLocalDatas(Iterable<? extends MapDataInfo> iterable) {
            ensureLocalDatasIsMutable();
            AbstractMessageLite.addAll(iterable, this.localDatas_);
        }

        /* access modifiers changed from: private */
        public void clearLocalDatas() {
            this.localDatas_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeLocalDatas(int i) {
            ensureLocalDatasIsMutable();
            this.localDatas_.remove(i);
        }

        public boolean hasDidiVersion() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getDidiVersion() {
            return this.didiVersion_;
        }

        public ByteString getDidiVersionBytes() {
            return ByteString.copyFromUtf8(this.didiVersion_);
        }

        /* access modifiers changed from: private */
        public void setDidiVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.didiVersion_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearDidiVersion() {
            this.bitField0_ &= -5;
            this.didiVersion_ = getDefaultInstance().getDidiVersion();
        }

        /* access modifiers changed from: private */
        public void setDidiVersionBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 4;
                this.didiVersion_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasLastUpdateTimestamp() {
            return (this.bitField0_ & 8) == 8;
        }

        public long getLastUpdateTimestamp() {
            return this.lastUpdateTimestamp_;
        }

        /* access modifiers changed from: private */
        public void setLastUpdateTimestamp(long j) {
            this.bitField0_ |= 8;
            this.lastUpdateTimestamp_ = j;
        }

        /* access modifiers changed from: private */
        public void clearLastUpdateTimestamp() {
            this.bitField0_ &= -9;
            this.lastUpdateTimestamp_ = 0;
        }

        public boolean hasDevice() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getDevice() {
            return this.device_;
        }

        public ByteString getDeviceBytes() {
            return ByteString.copyFromUtf8(this.device_);
        }

        /* access modifiers changed from: private */
        public void setDevice(String str) {
            if (str != null) {
                this.bitField0_ |= 16;
                this.device_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearDevice() {
            this.bitField0_ &= -17;
            this.device_ = getDefaultInstance().getDevice();
        }

        /* access modifiers changed from: private */
        public void setDeviceBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 16;
                this.device_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasPhone() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getPhone() {
            return this.phone_;
        }

        public ByteString getPhoneBytes() {
            return ByteString.copyFromUtf8(this.phone_);
        }

        /* access modifiers changed from: private */
        public void setPhone(String str) {
            if (str != null) {
                this.bitField0_ |= 32;
                this.phone_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearPhone() {
            this.bitField0_ &= -33;
            this.phone_ = getDefaultInstance().getPhone();
        }

        /* access modifiers changed from: private */
        public void setPhoneBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 32;
                this.phone_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public boolean hasToken() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getToken() {
            return this.token_;
        }

        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        /* access modifiers changed from: private */
        public void setToken(String str) {
            if (str != null) {
                this.bitField0_ |= 64;
                this.token_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearToken() {
            this.bitField0_ &= -65;
            this.token_ = getDefaultInstance().getToken();
        }

        /* access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 64;
                this.token_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getSdkVersion());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getImei());
            }
            for (int i = 0; i < this.localDatas_.size(); i++) {
                codedOutputStream.writeMessage(3, (MessageLite) this.localDatas_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(4, getDidiVersion());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(5, this.lastUpdateTimestamp_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(6, getDevice());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeString(7, getPhone());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeString(8, getToken());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getSdkVersion()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getImei());
            }
            for (int i2 = 0; i2 < this.localDatas_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, (MessageLite) this.localDatas_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                computeStringSize += CodedOutputStream.computeStringSize(4, getDidiVersion());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeStringSize += CodedOutputStream.computeInt64Size(5, this.lastUpdateTimestamp_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeStringSize += CodedOutputStream.computeStringSize(6, getDevice());
            }
            if ((this.bitField0_ & 32) == 32) {
                computeStringSize += CodedOutputStream.computeStringSize(7, getPhone());
            }
            if ((this.bitField0_ & 64) == 64) {
                computeStringSize += CodedOutputStream.computeStringSize(8, getToken());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static MapDataUpdateReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MapDataUpdateReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MapDataUpdateReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MapDataUpdateReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MapDataUpdateReq parseFrom(InputStream inputStream) throws IOException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataUpdateReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataUpdateReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MapDataUpdateReq) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataUpdateReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataUpdateReq) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataUpdateReq parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MapDataUpdateReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataUpdateReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapDataUpdateReq mapDataUpdateReq) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(mapDataUpdateReq);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MapDataUpdateReq, Builder> implements MapDataUpdateReqOrBuilder {
            /* synthetic */ Builder(C207281 r1) {
                this();
            }

            private Builder() {
                super(MapDataUpdateReq.DEFAULT_INSTANCE);
            }

            public boolean hasSdkVersion() {
                return ((MapDataUpdateReq) this.instance).hasSdkVersion();
            }

            public String getSdkVersion() {
                return ((MapDataUpdateReq) this.instance).getSdkVersion();
            }

            public ByteString getSdkVersionBytes() {
                return ((MapDataUpdateReq) this.instance).getSdkVersionBytes();
            }

            public Builder setSdkVersion(String str) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setSdkVersion(str);
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearSdkVersion();
                return this;
            }

            public Builder setSdkVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setSdkVersionBytes(byteString);
                return this;
            }

            public boolean hasImei() {
                return ((MapDataUpdateReq) this.instance).hasImei();
            }

            public String getImei() {
                return ((MapDataUpdateReq) this.instance).getImei();
            }

            public ByteString getImeiBytes() {
                return ((MapDataUpdateReq) this.instance).getImeiBytes();
            }

            public Builder setImei(String str) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setImei(str);
                return this;
            }

            public Builder clearImei() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearImei();
                return this;
            }

            public Builder setImeiBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setImeiBytes(byteString);
                return this;
            }

            public List<MapDataInfo> getLocalDatasList() {
                return Collections.unmodifiableList(((MapDataUpdateReq) this.instance).getLocalDatasList());
            }

            public int getLocalDatasCount() {
                return ((MapDataUpdateReq) this.instance).getLocalDatasCount();
            }

            public MapDataInfo getLocalDatas(int i) {
                return ((MapDataUpdateReq) this.instance).getLocalDatas(i);
            }

            public Builder setLocalDatas(int i, MapDataInfo mapDataInfo) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setLocalDatas(i, mapDataInfo);
                return this;
            }

            public Builder setLocalDatas(int i, MapDataInfo.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setLocalDatas(i, builder);
                return this;
            }

            public Builder addLocalDatas(MapDataInfo mapDataInfo) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).addLocalDatas(mapDataInfo);
                return this;
            }

            public Builder addLocalDatas(int i, MapDataInfo mapDataInfo) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).addLocalDatas(i, mapDataInfo);
                return this;
            }

            public Builder addLocalDatas(MapDataInfo.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).addLocalDatas(builder);
                return this;
            }

            public Builder addLocalDatas(int i, MapDataInfo.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).addLocalDatas(i, builder);
                return this;
            }

            public Builder addAllLocalDatas(Iterable<? extends MapDataInfo> iterable) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).addAllLocalDatas(iterable);
                return this;
            }

            public Builder clearLocalDatas() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearLocalDatas();
                return this;
            }

            public Builder removeLocalDatas(int i) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).removeLocalDatas(i);
                return this;
            }

            public boolean hasDidiVersion() {
                return ((MapDataUpdateReq) this.instance).hasDidiVersion();
            }

            public String getDidiVersion() {
                return ((MapDataUpdateReq) this.instance).getDidiVersion();
            }

            public ByteString getDidiVersionBytes() {
                return ((MapDataUpdateReq) this.instance).getDidiVersionBytes();
            }

            public Builder setDidiVersion(String str) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setDidiVersion(str);
                return this;
            }

            public Builder clearDidiVersion() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearDidiVersion();
                return this;
            }

            public Builder setDidiVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setDidiVersionBytes(byteString);
                return this;
            }

            public boolean hasLastUpdateTimestamp() {
                return ((MapDataUpdateReq) this.instance).hasLastUpdateTimestamp();
            }

            public long getLastUpdateTimestamp() {
                return ((MapDataUpdateReq) this.instance).getLastUpdateTimestamp();
            }

            public Builder setLastUpdateTimestamp(long j) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setLastUpdateTimestamp(j);
                return this;
            }

            public Builder clearLastUpdateTimestamp() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearLastUpdateTimestamp();
                return this;
            }

            public boolean hasDevice() {
                return ((MapDataUpdateReq) this.instance).hasDevice();
            }

            public String getDevice() {
                return ((MapDataUpdateReq) this.instance).getDevice();
            }

            public ByteString getDeviceBytes() {
                return ((MapDataUpdateReq) this.instance).getDeviceBytes();
            }

            public Builder setDevice(String str) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setDevice(str);
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearDevice();
                return this;
            }

            public Builder setDeviceBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setDeviceBytes(byteString);
                return this;
            }

            public boolean hasPhone() {
                return ((MapDataUpdateReq) this.instance).hasPhone();
            }

            public String getPhone() {
                return ((MapDataUpdateReq) this.instance).getPhone();
            }

            public ByteString getPhoneBytes() {
                return ((MapDataUpdateReq) this.instance).getPhoneBytes();
            }

            public Builder setPhone(String str) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setPhone(str);
                return this;
            }

            public Builder clearPhone() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearPhone();
                return this;
            }

            public Builder setPhoneBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setPhoneBytes(byteString);
                return this;
            }

            public boolean hasToken() {
                return ((MapDataUpdateReq) this.instance).hasToken();
            }

            public String getToken() {
                return ((MapDataUpdateReq) this.instance).getToken();
            }

            public ByteString getTokenBytes() {
                return ((MapDataUpdateReq) this.instance).getTokenBytes();
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setToken(str);
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).clearToken();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataUpdateReq) this.instance).setTokenBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (C207281.f56307xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MapDataUpdateReq();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasSdkVersion()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasImei()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else {
                        for (int i = 0; i < getLocalDatasCount(); i++) {
                            if (!getLocalDatas(i).isInitialized()) {
                                if (booleanValue) {
                                    this.memoizedIsInitialized = 0;
                                }
                                return null;
                            }
                        }
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                case 3:
                    this.localDatas_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((C207281) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MapDataUpdateReq mapDataUpdateReq = (MapDataUpdateReq) obj2;
                    this.sdkVersion_ = visitor.visitString(hasSdkVersion(), this.sdkVersion_, mapDataUpdateReq.hasSdkVersion(), mapDataUpdateReq.sdkVersion_);
                    this.imei_ = visitor.visitString(hasImei(), this.imei_, mapDataUpdateReq.hasImei(), mapDataUpdateReq.imei_);
                    this.localDatas_ = visitor.visitList(this.localDatas_, mapDataUpdateReq.localDatas_);
                    this.didiVersion_ = visitor.visitString(hasDidiVersion(), this.didiVersion_, mapDataUpdateReq.hasDidiVersion(), mapDataUpdateReq.didiVersion_);
                    this.lastUpdateTimestamp_ = visitor.visitLong(hasLastUpdateTimestamp(), this.lastUpdateTimestamp_, mapDataUpdateReq.hasLastUpdateTimestamp(), mapDataUpdateReq.lastUpdateTimestamp_);
                    this.device_ = visitor.visitString(hasDevice(), this.device_, mapDataUpdateReq.hasDevice(), mapDataUpdateReq.device_);
                    this.phone_ = visitor.visitString(hasPhone(), this.phone_, mapDataUpdateReq.hasPhone(), mapDataUpdateReq.phone_);
                    this.token_ = visitor.visitString(hasToken(), this.token_, mapDataUpdateReq.hasToken(), mapDataUpdateReq.token_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= mapDataUpdateReq.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.sdkVersion_ = readString;
                                } else if (readTag == 18) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.imei_ = readString2;
                                } else if (readTag == 26) {
                                    if (!this.localDatas_.isModifiable()) {
                                        this.localDatas_ = GeneratedMessageLite.mutableCopy(this.localDatas_);
                                    }
                                    this.localDatas_.add((MapDataInfo) codedInputStream.readMessage(MapDataInfo.parser(), extensionRegistryLite));
                                } else if (readTag == 34) {
                                    String readString3 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.didiVersion_ = readString3;
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 8;
                                    this.lastUpdateTimestamp_ = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    String readString4 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.device_ = readString4;
                                } else if (readTag == 58) {
                                    String readString5 = codedInputStream.readString();
                                    this.bitField0_ |= 32;
                                    this.phone_ = readString5;
                                } else if (readTag == 66) {
                                    String readString6 = codedInputStream.readString();
                                    this.bitField0_ |= 64;
                                    this.token_ = readString6;
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (MapDataUpdateReq.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            MapDataUpdateReq mapDataUpdateReq = new MapDataUpdateReq();
            DEFAULT_INSTANCE = mapDataUpdateReq;
            mapDataUpdateReq.makeImmutable();
        }

        public static MapDataUpdateReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapDataUpdateReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MapDataUpdateRes extends GeneratedMessageLite<MapDataUpdateRes, Builder> implements MapDataUpdateResOrBuilder {
        /* access modifiers changed from: private */
        public static final MapDataUpdateRes DEFAULT_INSTANCE;
        public static final int MSG_FIELD_NUMBER = 2;
        private static volatile Parser<MapDataUpdateRes> PARSER = null;
        public static final int RET_FIELD_NUMBER = 1;
        public static final int UPDATEFILES_FIELD_NUMBER = 4;
        public static final int UPDATEURLS_FIELD_NUMBER = 3;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String msg_ = "";
        private int ret_;
        private Internal.ProtobufList<MapDataFile> updateFiles_ = emptyProtobufList();
        private Internal.ProtobufList<MapDataURL> updateUrls_ = emptyProtobufList();

        private MapDataUpdateRes() {
        }

        public boolean hasRet() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getRet() {
            return this.ret_;
        }

        /* access modifiers changed from: private */
        public void setRet(int i) {
            this.bitField0_ |= 1;
            this.ret_ = i;
        }

        /* access modifiers changed from: private */
        public void clearRet() {
            this.bitField0_ &= -2;
            this.ret_ = 0;
        }

        public boolean hasMsg() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getMsg() {
            return this.msg_;
        }

        public ByteString getMsgBytes() {
            return ByteString.copyFromUtf8(this.msg_);
        }

        /* access modifiers changed from: private */
        public void setMsg(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.msg_ = str;
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void clearMsg() {
            this.bitField0_ &= -3;
            this.msg_ = getDefaultInstance().getMsg();
        }

        /* access modifiers changed from: private */
        public void setMsgBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.msg_ = byteString.toStringUtf8();
                return;
            }
            throw null;
        }

        public List<MapDataURL> getUpdateUrlsList() {
            return this.updateUrls_;
        }

        public List<? extends MapDataURLOrBuilder> getUpdateUrlsOrBuilderList() {
            return this.updateUrls_;
        }

        public int getUpdateUrlsCount() {
            return this.updateUrls_.size();
        }

        public MapDataURL getUpdateUrls(int i) {
            return (MapDataURL) this.updateUrls_.get(i);
        }

        public MapDataURLOrBuilder getUpdateUrlsOrBuilder(int i) {
            return (MapDataURLOrBuilder) this.updateUrls_.get(i);
        }

        private void ensureUpdateUrlsIsMutable() {
            if (!this.updateUrls_.isModifiable()) {
                this.updateUrls_ = GeneratedMessageLite.mutableCopy(this.updateUrls_);
            }
        }

        /* access modifiers changed from: private */
        public void setUpdateUrls(int i, MapDataURL mapDataURL) {
            if (mapDataURL != null) {
                ensureUpdateUrlsIsMutable();
                this.updateUrls_.set(i, mapDataURL);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUpdateUrls(int i, MapDataURL.Builder builder) {
            ensureUpdateUrlsIsMutable();
            this.updateUrls_.set(i, (MapDataURL) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUpdateUrls(MapDataURL mapDataURL) {
            if (mapDataURL != null) {
                ensureUpdateUrlsIsMutable();
                this.updateUrls_.add(mapDataURL);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUpdateUrls(int i, MapDataURL mapDataURL) {
            if (mapDataURL != null) {
                ensureUpdateUrlsIsMutable();
                this.updateUrls_.add(i, mapDataURL);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUpdateUrls(MapDataURL.Builder builder) {
            ensureUpdateUrlsIsMutable();
            this.updateUrls_.add((MapDataURL) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUpdateUrls(int i, MapDataURL.Builder builder) {
            ensureUpdateUrlsIsMutable();
            this.updateUrls_.add(i, (MapDataURL) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUpdateUrls(Iterable<? extends MapDataURL> iterable) {
            ensureUpdateUrlsIsMutable();
            AbstractMessageLite.addAll(iterable, this.updateUrls_);
        }

        /* access modifiers changed from: private */
        public void clearUpdateUrls() {
            this.updateUrls_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUpdateUrls(int i) {
            ensureUpdateUrlsIsMutable();
            this.updateUrls_.remove(i);
        }

        public List<MapDataFile> getUpdateFilesList() {
            return this.updateFiles_;
        }

        public List<? extends MapDataFileOrBuilder> getUpdateFilesOrBuilderList() {
            return this.updateFiles_;
        }

        public int getUpdateFilesCount() {
            return this.updateFiles_.size();
        }

        public MapDataFile getUpdateFiles(int i) {
            return (MapDataFile) this.updateFiles_.get(i);
        }

        public MapDataFileOrBuilder getUpdateFilesOrBuilder(int i) {
            return (MapDataFileOrBuilder) this.updateFiles_.get(i);
        }

        private void ensureUpdateFilesIsMutable() {
            if (!this.updateFiles_.isModifiable()) {
                this.updateFiles_ = GeneratedMessageLite.mutableCopy(this.updateFiles_);
            }
        }

        /* access modifiers changed from: private */
        public void setUpdateFiles(int i, MapDataFile mapDataFile) {
            if (mapDataFile != null) {
                ensureUpdateFilesIsMutable();
                this.updateFiles_.set(i, mapDataFile);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void setUpdateFiles(int i, MapDataFile.Builder builder) {
            ensureUpdateFilesIsMutable();
            this.updateFiles_.set(i, (MapDataFile) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUpdateFiles(MapDataFile mapDataFile) {
            if (mapDataFile != null) {
                ensureUpdateFilesIsMutable();
                this.updateFiles_.add(mapDataFile);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUpdateFiles(int i, MapDataFile mapDataFile) {
            if (mapDataFile != null) {
                ensureUpdateFilesIsMutable();
                this.updateFiles_.add(i, mapDataFile);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public void addUpdateFiles(MapDataFile.Builder builder) {
            ensureUpdateFilesIsMutable();
            this.updateFiles_.add((MapDataFile) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUpdateFiles(int i, MapDataFile.Builder builder) {
            ensureUpdateFilesIsMutable();
            this.updateFiles_.add(i, (MapDataFile) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUpdateFiles(Iterable<? extends MapDataFile> iterable) {
            ensureUpdateFilesIsMutable();
            AbstractMessageLite.addAll(iterable, this.updateFiles_);
        }

        /* access modifiers changed from: private */
        public void clearUpdateFiles() {
            this.updateFiles_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUpdateFiles(int i) {
            ensureUpdateFilesIsMutable();
            this.updateFiles_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.ret_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getMsg());
            }
            for (int i = 0; i < this.updateUrls_.size(); i++) {
                codedOutputStream.writeMessage(3, (MessageLite) this.updateUrls_.get(i));
            }
            for (int i2 = 0; i2 < this.updateFiles_.size(); i2++) {
                codedOutputStream.writeMessage(4, (MessageLite) this.updateFiles_.get(i2));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.ret_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeStringSize(2, getMsg());
            }
            for (int i2 = 0; i2 < this.updateUrls_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.updateUrls_.get(i2));
            }
            for (int i3 = 0; i3 < this.updateFiles_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.updateFiles_.get(i3));
            }
            int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static MapDataUpdateRes parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MapDataUpdateRes parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MapDataUpdateRes parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MapDataUpdateRes parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MapDataUpdateRes parseFrom(InputStream inputStream) throws IOException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataUpdateRes parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataUpdateRes parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MapDataUpdateRes) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MapDataUpdateRes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataUpdateRes) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MapDataUpdateRes parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MapDataUpdateRes parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MapDataUpdateRes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapDataUpdateRes mapDataUpdateRes) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(mapDataUpdateRes);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MapDataUpdateRes, Builder> implements MapDataUpdateResOrBuilder {
            /* synthetic */ Builder(C207281 r1) {
                this();
            }

            private Builder() {
                super(MapDataUpdateRes.DEFAULT_INSTANCE);
            }

            public boolean hasRet() {
                return ((MapDataUpdateRes) this.instance).hasRet();
            }

            public int getRet() {
                return ((MapDataUpdateRes) this.instance).getRet();
            }

            public Builder setRet(int i) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).setRet(i);
                return this;
            }

            public Builder clearRet() {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).clearRet();
                return this;
            }

            public boolean hasMsg() {
                return ((MapDataUpdateRes) this.instance).hasMsg();
            }

            public String getMsg() {
                return ((MapDataUpdateRes) this.instance).getMsg();
            }

            public ByteString getMsgBytes() {
                return ((MapDataUpdateRes) this.instance).getMsgBytes();
            }

            public Builder setMsg(String str) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).setMsg(str);
                return this;
            }

            public Builder clearMsg() {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).clearMsg();
                return this;
            }

            public Builder setMsgBytes(ByteString byteString) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).setMsgBytes(byteString);
                return this;
            }

            public List<MapDataURL> getUpdateUrlsList() {
                return Collections.unmodifiableList(((MapDataUpdateRes) this.instance).getUpdateUrlsList());
            }

            public int getUpdateUrlsCount() {
                return ((MapDataUpdateRes) this.instance).getUpdateUrlsCount();
            }

            public MapDataURL getUpdateUrls(int i) {
                return ((MapDataUpdateRes) this.instance).getUpdateUrls(i);
            }

            public Builder setUpdateUrls(int i, MapDataURL mapDataURL) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).setUpdateUrls(i, mapDataURL);
                return this;
            }

            public Builder setUpdateUrls(int i, MapDataURL.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).setUpdateUrls(i, builder);
                return this;
            }

            public Builder addUpdateUrls(MapDataURL mapDataURL) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateUrls(mapDataURL);
                return this;
            }

            public Builder addUpdateUrls(int i, MapDataURL mapDataURL) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateUrls(i, mapDataURL);
                return this;
            }

            public Builder addUpdateUrls(MapDataURL.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateUrls(builder);
                return this;
            }

            public Builder addUpdateUrls(int i, MapDataURL.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateUrls(i, builder);
                return this;
            }

            public Builder addAllUpdateUrls(Iterable<? extends MapDataURL> iterable) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addAllUpdateUrls(iterable);
                return this;
            }

            public Builder clearUpdateUrls() {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).clearUpdateUrls();
                return this;
            }

            public Builder removeUpdateUrls(int i) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).removeUpdateUrls(i);
                return this;
            }

            public List<MapDataFile> getUpdateFilesList() {
                return Collections.unmodifiableList(((MapDataUpdateRes) this.instance).getUpdateFilesList());
            }

            public int getUpdateFilesCount() {
                return ((MapDataUpdateRes) this.instance).getUpdateFilesCount();
            }

            public MapDataFile getUpdateFiles(int i) {
                return ((MapDataUpdateRes) this.instance).getUpdateFiles(i);
            }

            public Builder setUpdateFiles(int i, MapDataFile mapDataFile) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).setUpdateFiles(i, mapDataFile);
                return this;
            }

            public Builder setUpdateFiles(int i, MapDataFile.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).setUpdateFiles(i, builder);
                return this;
            }

            public Builder addUpdateFiles(MapDataFile mapDataFile) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateFiles(mapDataFile);
                return this;
            }

            public Builder addUpdateFiles(int i, MapDataFile mapDataFile) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateFiles(i, mapDataFile);
                return this;
            }

            public Builder addUpdateFiles(MapDataFile.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateFiles(builder);
                return this;
            }

            public Builder addUpdateFiles(int i, MapDataFile.Builder builder) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addUpdateFiles(i, builder);
                return this;
            }

            public Builder addAllUpdateFiles(Iterable<? extends MapDataFile> iterable) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).addAllUpdateFiles(iterable);
                return this;
            }

            public Builder clearUpdateFiles() {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).clearUpdateFiles();
                return this;
            }

            public Builder removeUpdateFiles(int i) {
                copyOnWrite();
                ((MapDataUpdateRes) this.instance).removeUpdateFiles(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (C207281.f56307xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new MapDataUpdateRes();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasRet()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else if (!hasMsg()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    } else {
                        for (int i = 0; i < getUpdateUrlsCount(); i++) {
                            if (!getUpdateUrls(i).isInitialized()) {
                                if (booleanValue) {
                                    this.memoizedIsInitialized = 0;
                                }
                                return null;
                            }
                        }
                        for (int i2 = 0; i2 < getUpdateFilesCount(); i2++) {
                            if (!getUpdateFiles(i2).isInitialized()) {
                                if (booleanValue) {
                                    this.memoizedIsInitialized = 0;
                                }
                                return null;
                            }
                        }
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                case 3:
                    this.updateUrls_.makeImmutable();
                    this.updateFiles_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((C207281) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MapDataUpdateRes mapDataUpdateRes = (MapDataUpdateRes) obj2;
                    this.ret_ = visitor.visitInt(hasRet(), this.ret_, mapDataUpdateRes.hasRet(), mapDataUpdateRes.ret_);
                    this.msg_ = visitor.visitString(hasMsg(), this.msg_, mapDataUpdateRes.hasMsg(), mapDataUpdateRes.msg_);
                    this.updateUrls_ = visitor.visitList(this.updateUrls_, mapDataUpdateRes.updateUrls_);
                    this.updateFiles_ = visitor.visitList(this.updateFiles_, mapDataUpdateRes.updateFiles_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= mapDataUpdateRes.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.ret_ = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.msg_ = readString;
                                } else if (readTag == 26) {
                                    if (!this.updateUrls_.isModifiable()) {
                                        this.updateUrls_ = GeneratedMessageLite.mutableCopy(this.updateUrls_);
                                    }
                                    this.updateUrls_.add((MapDataURL) codedInputStream.readMessage(MapDataURL.parser(), extensionRegistryLite));
                                } else if (readTag == 34) {
                                    if (!this.updateFiles_.isModifiable()) {
                                        this.updateFiles_ = GeneratedMessageLite.mutableCopy(this.updateFiles_);
                                    }
                                    this.updateFiles_.add((MapDataFile) codedInputStream.readMessage(MapDataFile.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (MapDataUpdateRes.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            MapDataUpdateRes mapDataUpdateRes = new MapDataUpdateRes();
            DEFAULT_INSTANCE = mapDataUpdateRes;
            mapDataUpdateRes.makeImmutable();
        }

        public static MapDataUpdateRes getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapDataUpdateRes> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
