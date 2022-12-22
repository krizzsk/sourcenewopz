package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.io.InputStream;

public final class Value extends GeneratedMessageV3 implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE = new Value();
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final Parser<Value> PARSER = new AbstractParser<Value>() {
        public Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Value(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public int kindCase_;
    /* access modifiers changed from: private */
    public Object kind_;
    private byte memoizedIsInitialized;

    private Value(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.google.protobuf.Struct$Builder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.google.protobuf.ListValue$Builder} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Value(com.google.protobuf.CodedInputStream r6, com.google.protobuf.ExtensionRegistryLite r7) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
        L_0x0004:
            if (r0 != 0) goto L_0x00cd
            int r1 = r6.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r2 = 1
            if (r1 == 0) goto L_0x00b3
            r3 = 8
            if (r1 == r3) goto L_0x00a5
            r3 = 17
            if (r1 == r3) goto L_0x0096
            r3 = 26
            if (r1 == r3) goto L_0x008b
            r3 = 32
            if (r1 == r3) goto L_0x007c
            r3 = 42
            r4 = 0
            if (r1 == r3) goto L_0x0055
            r3 = 50
            if (r1 == r3) goto L_0x002e
            boolean r1 = r6.skipField(r1)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            if (r1 != 0) goto L_0x0004
            goto L_0x00b3
        L_0x002e:
            int r1 = r5.kindCase_     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r2 = 6
            if (r1 != r2) goto L_0x003b
            java.lang.Object r1 = r5.kind_     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.ListValue r1 = (com.google.protobuf.ListValue) r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.ListValue$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
        L_0x003b:
            com.google.protobuf.Parser r1 = com.google.protobuf.ListValue.parser()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            if (r4 == 0) goto L_0x0052
            com.google.protobuf.ListValue r1 = (com.google.protobuf.ListValue) r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r4.mergeFrom((com.google.protobuf.ListValue) r1)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.ListValue r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
        L_0x0052:
            r5.kindCase_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            goto L_0x0004
        L_0x0055:
            int r1 = r5.kindCase_     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r2 = 5
            if (r1 != r2) goto L_0x0062
            java.lang.Object r1 = r5.kind_     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.Struct r1 = (com.google.protobuf.Struct) r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.Struct$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
        L_0x0062:
            com.google.protobuf.Parser r1 = com.google.protobuf.Struct.parser()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            if (r4 == 0) goto L_0x0079
            com.google.protobuf.Struct r1 = (com.google.protobuf.Struct) r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r4.mergeFrom((com.google.protobuf.Struct) r1)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            com.google.protobuf.Struct r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
        L_0x0079:
            r5.kindCase_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            goto L_0x0004
        L_0x007c:
            r1 = 4
            r5.kindCase_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            boolean r1 = r6.readBool()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            goto L_0x0004
        L_0x008b:
            java.lang.String r1 = r6.readStringRequireUtf8()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r2 = 3
            r5.kindCase_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            goto L_0x0004
        L_0x0096:
            r1 = 2
            r5.kindCase_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            double r1 = r6.readDouble()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            goto L_0x0004
        L_0x00a5:
            int r1 = r6.readEnum()     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kindCase_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            r5.kind_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00c3, IOException -> 0x00b8 }
            goto L_0x0004
        L_0x00b3:
            r0 = 1
            goto L_0x0004
        L_0x00b6:
            r6 = move-exception
            goto L_0x00c9
        L_0x00b8:
            r6 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r7 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00b6 }
            r7.<init>((java.io.IOException) r6)     // Catch:{ all -> 0x00b6 }
            com.google.protobuf.InvalidProtocolBufferException r6 = r7.setUnfinishedMessage(r5)     // Catch:{ all -> 0x00b6 }
            throw r6     // Catch:{ all -> 0x00b6 }
        L_0x00c3:
            r6 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r6 = r6.setUnfinishedMessage(r5)     // Catch:{ all -> 0x00b6 }
            throw r6     // Catch:{ all -> 0x00b6 }
        L_0x00c9:
            r5.makeExtensionsImmutable()
            throw r6
        L_0x00cd:
            r5.makeExtensionsImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Value.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    /* access modifiers changed from: protected */
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
    }

    public enum KindCase implements Internal.EnumLite {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);
        
        private final int value;

        private KindCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static KindCase valueOf(int i) {
            return forNumber(i);
        }

        public static KindCase forNumber(int i) {
            switch (i) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.kind_).intValue();
        }
        return 0;
    }

    public NullValue getNullValue() {
        if (this.kindCase_ != 1) {
            return NullValue.NULL_VALUE;
        }
        NullValue valueOf = NullValue.valueOf(((Integer) this.kind_).intValue());
        return valueOf == null ? NullValue.UNRECOGNIZED : valueOf;
    }

    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    public String getStringValue() {
        String str = this.kindCase_ == 3 ? this.kind_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.kindCase_ == 3) {
            this.kind_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getStringValueBytes() {
        String str = this.kindCase_ == 3 ? this.kind_ : "";
        if (!(str instanceof String)) {
            return (ByteString) str;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
        if (this.kindCase_ == 3) {
            this.kind_ = copyFromUtf8;
        }
        return copyFromUtf8;
    }

    public boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    public Struct getStructValue() {
        if (this.kindCase_ == 5) {
            return (Struct) this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ == 5) {
            return (Struct) this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    public ListValue getListValue() {
        if (this.kindCase_ == 6) {
            return (ListValue) this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ == 6) {
            return (ListValue) this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.kindCase_ == 1) {
            codedOutputStream.writeEnum(1, ((Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            codedOutputStream.writeDouble(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            codedOutputStream.writeBool(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            codedOutputStream.writeMessage(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            codedOutputStream.writeMessage(6, (ListValue) this.kind_);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.kindCase_ == 1) {
            i2 = 0 + CodedOutputStream.computeEnumSize(1, ((Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            i2 += CodedOutputStream.computeDoubleSize(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            i2 += GeneratedMessageV3.computeStringSize(3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            i2 += CodedOutputStream.computeBoolSize(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            i2 += CodedOutputStream.computeMessageSize(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            i2 += CodedOutputStream.computeMessageSize(6, (ListValue) this.kind_);
        }
        this.memoizedSize = i2;
        return i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (getListValue().equals(r8.getListValue()) != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (getStructValue().equals(r8.getStructValue()) != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (getBoolValue() == r8.getBoolValue()) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (getStringValue().equals(r8.getStringValue()) != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        if (java.lang.Double.doubleToLongBits(getNumberValue()) == java.lang.Double.doubleToLongBits(r8.getNumberValue())) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        if (getNullValueValue() == r8.getNullValueValue()) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008f, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.protobuf.Value
            if (r1 != 0) goto L_0x000d
            boolean r8 = super.equals(r8)
            return r8
        L_0x000d:
            com.google.protobuf.Value r8 = (com.google.protobuf.Value) r8
            com.google.protobuf.Value$KindCase r1 = r7.getKindCase()
            com.google.protobuf.Value$KindCase r2 = r8.getKindCase()
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0020
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            if (r1 != 0) goto L_0x0024
            return r2
        L_0x0024:
            int r3 = r7.kindCase_
            switch(r3) {
                case 1: goto L_0x0082;
                case 2: goto L_0x006b;
                case 3: goto L_0x005a;
                case 4: goto L_0x004d;
                case 5: goto L_0x003c;
                case 6: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0091
        L_0x002b:
            if (r1 == 0) goto L_0x008f
            com.google.protobuf.ListValue r1 = r7.getListValue()
            com.google.protobuf.ListValue r8 = r8.getListValue()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x008f
            goto L_0x0090
        L_0x003c:
            if (r1 == 0) goto L_0x008f
            com.google.protobuf.Struct r1 = r7.getStructValue()
            com.google.protobuf.Struct r8 = r8.getStructValue()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x008f
            goto L_0x0090
        L_0x004d:
            if (r1 == 0) goto L_0x008f
            boolean r1 = r7.getBoolValue()
            boolean r8 = r8.getBoolValue()
            if (r1 != r8) goto L_0x008f
            goto L_0x0090
        L_0x005a:
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = r7.getStringValue()
            java.lang.String r8 = r8.getStringValue()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x008f
            goto L_0x0090
        L_0x006b:
            if (r1 == 0) goto L_0x008f
            double r3 = r7.getNumberValue()
            long r3 = java.lang.Double.doubleToLongBits(r3)
            double r5 = r8.getNumberValue()
            long r5 = java.lang.Double.doubleToLongBits(r5)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x008f
            goto L_0x0090
        L_0x0082:
            if (r1 == 0) goto L_0x008f
            int r1 = r7.getNullValueValue()
            int r8 = r8.getNullValueValue()
            if (r1 != r8) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r0 = 0
        L_0x0090:
            r1 = r0
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Value.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i;
        int i2;
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptorForType().hashCode();
        switch (this.kindCase_) {
            case 1:
                i2 = ((hashCode * 37) + 1) * 53;
                i = getNullValueValue();
                break;
            case 2:
                i2 = ((hashCode * 37) + 2) * 53;
                i = Internal.hashLong(Double.doubleToLongBits(getNumberValue()));
                break;
            case 3:
                i2 = ((hashCode * 37) + 3) * 53;
                i = getStringValue().hashCode();
                break;
            case 4:
                i2 = ((hashCode * 37) + 4) * 53;
                i = Internal.hashBoolean(getBoolValue());
                break;
            case 5:
                i2 = ((hashCode * 37) + 5) * 53;
                i = getStructValue().hashCode();
                break;
            case 6:
                i2 = ((hashCode * 37) + 6) * 53;
                i = getListValue().hashCode();
                break;
            default:
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
        }
        hashCode = i2 + i;
        int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode22;
        return hashCode22;
    }

    public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Value parseFrom(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Value value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(value);
    }

    public Builder toBuilder() {
        if (this == DEFAULT_INSTANCE) {
            return new Builder();
        }
        return new Builder().mergeFrom(this);
    }

    /* access modifiers changed from: protected */
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ValueOrBuilder {
        private int kindCase_;
        private Object kind_;
        private SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> listValueBuilder_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> structValueBuilder_;

        public final boolean isInitialized() {
            return true;
        }

        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return this;
        }

        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return this;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        /* access modifiers changed from: protected */
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
        }

        private Builder() {
            this.kindCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.kindCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clear() {
            super.clear();
            this.kindCase_ = 0;
            this.kind_ = null;
            return this;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        public Value getDefaultInstanceForType() {
            return Value.getDefaultInstance();
        }

        public Value build() {
            Value buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException(buildPartial);
        }

        public Value buildPartial() {
            Value value = new Value((GeneratedMessageV3.Builder) this);
            if (this.kindCase_ == 1) {
                Object unused = value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 2) {
                Object unused2 = value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 3) {
                Object unused3 = value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 4) {
                Object unused4 = value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 5) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Object unused5 = value.kind_ = this.kind_;
                } else {
                    Object unused6 = value.kind_ = singleFieldBuilderV3.build();
                }
            }
            if (this.kindCase_ == 6) {
                SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilderV32 = this.listValueBuilder_;
                if (singleFieldBuilderV32 == null) {
                    Object unused7 = value.kind_ = this.kind_;
                } else {
                    Object unused8 = value.kind_ = singleFieldBuilderV32.build();
                }
            }
            int unused9 = value.kindCase_ = this.kindCase_;
            onBuilt();
            return value;
        }

        public Builder clone() {
            return (Builder) super.clone();
        }

        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder mergeFrom(Message message) {
            if (message instanceof Value) {
                return mergeFrom((Value) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Value value) {
            if (value == Value.getDefaultInstance()) {
                return this;
            }
            switch (C196972.$SwitchMap$com$google$protobuf$Value$KindCase[value.getKindCase().ordinal()]) {
                case 1:
                    setNullValueValue(value.getNullValueValue());
                    break;
                case 2:
                    setNumberValue(value.getNumberValue());
                    break;
                case 3:
                    this.kindCase_ = 3;
                    this.kind_ = value.kind_;
                    onChanged();
                    break;
                case 4:
                    setBoolValue(value.getBoolValue());
                    break;
                case 5:
                    mergeStructValue(value.getStructValue());
                    break;
                case 6:
                    mergeListValue(value.getListValue());
                    break;
            }
            onChanged();
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.protobuf.Value.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Value.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                com.google.protobuf.Value r3 = (com.google.protobuf.Value) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                if (r3 == 0) goto L_0x0010
                r2.mergeFrom((com.google.protobuf.Value) r3)
            L_0x0010:
                return r2
            L_0x0011:
                r3 = move-exception
                goto L_0x0021
            L_0x0013:
                r3 = move-exception
                com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                com.google.protobuf.Value r4 = (com.google.protobuf.Value) r4     // Catch:{ all -> 0x0011 }
                java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                throw r3     // Catch:{ all -> 0x001f }
            L_0x001f:
                r3 = move-exception
                r0 = r4
            L_0x0021:
                if (r0 == 0) goto L_0x0026
                r2.mergeFrom((com.google.protobuf.Value) r0)
            L_0x0026:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Value.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Value$Builder");
        }

        public KindCase getKindCase() {
            return KindCase.forNumber(this.kindCase_);
        }

        public Builder clearKind() {
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
            return this;
        }

        public int getNullValueValue() {
            if (this.kindCase_ == 1) {
                return ((Integer) this.kind_).intValue();
            }
            return 0;
        }

        public Builder setNullValueValue(int i) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(i);
            onChanged();
            return this;
        }

        public NullValue getNullValue() {
            if (this.kindCase_ != 1) {
                return NullValue.NULL_VALUE;
            }
            NullValue valueOf = NullValue.valueOf(((Integer) this.kind_).intValue());
            return valueOf == null ? NullValue.UNRECOGNIZED : valueOf;
        }

        public Builder setNullValue(NullValue nullValue) {
            if (nullValue != null) {
                this.kindCase_ = 1;
                this.kind_ = Integer.valueOf(nullValue.getNumber());
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder clearNullValue() {
            if (this.kindCase_ == 1) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public double getNumberValue() {
            if (this.kindCase_ == 2) {
                return ((Double) this.kind_).doubleValue();
            }
            return 0.0d;
        }

        public Builder setNumberValue(double d) {
            this.kindCase_ = 2;
            this.kind_ = Double.valueOf(d);
            onChanged();
            return this;
        }

        public Builder clearNumberValue() {
            if (this.kindCase_ == 2) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public String getStringValue() {
            String str = this.kindCase_ == 3 ? this.kind_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.kindCase_ == 3) {
                this.kind_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getStringValueBytes() {
            String str = this.kindCase_ == 3 ? this.kind_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.kindCase_ == 3) {
                this.kind_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        public Builder setStringValue(String str) {
            if (str != null) {
                this.kindCase_ = 3;
                this.kind_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder clearStringValue() {
            if (this.kindCase_ == 3) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public Builder setStringValueBytes(ByteString byteString) {
            if (byteString != null) {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.kindCase_ = 3;
                this.kind_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public boolean getBoolValue() {
            if (this.kindCase_ == 4) {
                return ((Boolean) this.kind_).booleanValue();
            }
            return false;
        }

        public Builder setBoolValue(boolean z) {
            this.kindCase_ = 4;
            this.kind_ = Boolean.valueOf(z);
            onChanged();
            return this;
        }

        public Builder clearBoolValue() {
            if (this.kindCase_ == 4) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public Struct getStructValue() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 5) {
                    return (Struct) this.kind_;
                }
                return Struct.getDefaultInstance();
            } else if (this.kindCase_ == 5) {
                return singleFieldBuilderV3.getMessage();
            } else {
                return Struct.getDefaultInstance();
            }
        }

        public Builder setStructValue(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(struct);
            } else if (struct != null) {
                this.kind_ = struct;
                onChanged();
            } else {
                throw null;
            }
            this.kindCase_ = 5;
            return this;
        }

        public Builder setStructValue(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.kind_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.kindCase_ = 5;
            return this;
        }

        public Builder mergeStructValue(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ != 5 || this.kind_ == Struct.getDefaultInstance()) {
                    this.kind_ = struct;
                } else {
                    this.kind_ = Struct.newBuilder((Struct) this.kind_).mergeFrom(struct).buildPartial();
                }
                onChanged();
            } else {
                if (this.kindCase_ == 5) {
                    singleFieldBuilderV3.mergeFrom(struct);
                }
                this.structValueBuilder_.setMessage(struct);
            }
            this.kindCase_ = 5;
            return this;
        }

        public Builder clearStructValue() {
            if (this.structValueBuilder_ != null) {
                if (this.kindCase_ == 5) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                }
                this.structValueBuilder_.clear();
            } else if (this.kindCase_ == 5) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public Struct.Builder getStructValueBuilder() {
            return getStructValueFieldBuilder().getBuilder();
        }

        public StructOrBuilder getStructValueOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3;
            if (this.kindCase_ == 5 && (singleFieldBuilderV3 = this.structValueBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (this.kindCase_ == 5) {
                return (Struct) this.kind_;
            }
            return Struct.getDefaultInstance();
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getStructValueFieldBuilder() {
            if (this.structValueBuilder_ == null) {
                if (this.kindCase_ != 5) {
                    this.kind_ = Struct.getDefaultInstance();
                }
                this.structValueBuilder_ = new SingleFieldBuilderV3<>((Struct) this.kind_, getParentForChildren(), isClean());
                this.kind_ = null;
            }
            this.kindCase_ = 5;
            onChanged();
            return this.structValueBuilder_;
        }

        public ListValue getListValue() {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 6) {
                    return (ListValue) this.kind_;
                }
                return ListValue.getDefaultInstance();
            } else if (this.kindCase_ == 6) {
                return singleFieldBuilderV3.getMessage();
            } else {
                return ListValue.getDefaultInstance();
            }
        }

        public Builder setListValue(ListValue listValue) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(listValue);
            } else if (listValue != null) {
                this.kind_ = listValue;
                onChanged();
            } else {
                throw null;
            }
            this.kindCase_ = 6;
            return this;
        }

        public Builder setListValue(ListValue.Builder builder) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.kind_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.kindCase_ = 6;
            return this;
        }

        public Builder mergeListValue(ListValue listValue) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ != 6 || this.kind_ == ListValue.getDefaultInstance()) {
                    this.kind_ = listValue;
                } else {
                    this.kind_ = ListValue.newBuilder((ListValue) this.kind_).mergeFrom(listValue).buildPartial();
                }
                onChanged();
            } else {
                if (this.kindCase_ == 6) {
                    singleFieldBuilderV3.mergeFrom(listValue);
                }
                this.listValueBuilder_.setMessage(listValue);
            }
            this.kindCase_ = 6;
            return this;
        }

        public Builder clearListValue() {
            if (this.listValueBuilder_ != null) {
                if (this.kindCase_ == 6) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                }
                this.listValueBuilder_.clear();
            } else if (this.kindCase_ == 6) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public ListValue.Builder getListValueBuilder() {
            return getListValueFieldBuilder().getBuilder();
        }

        public ListValueOrBuilder getListValueOrBuilder() {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> singleFieldBuilderV3;
            if (this.kindCase_ == 6 && (singleFieldBuilderV3 = this.listValueBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (this.kindCase_ == 6) {
                return (ListValue) this.kind_;
            }
            return ListValue.getDefaultInstance();
        }

        private SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> getListValueFieldBuilder() {
            if (this.listValueBuilder_ == null) {
                if (this.kindCase_ != 6) {
                    this.kind_ = ListValue.getDefaultInstance();
                }
                this.listValueBuilder_ = new SingleFieldBuilderV3<>((ListValue) this.kind_, getParentForChildren(), isClean());
                this.kind_ = null;
            }
            this.kindCase_ = 6;
            onChanged();
            return this.listValueBuilder_;
        }
    }

    /* renamed from: com.google.protobuf.Value$2 */
    static /* synthetic */ class C196972 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Value$KindCase;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.Value$KindCase[] r0 = com.google.protobuf.Value.KindCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$Value$KindCase = r0
                com.google.protobuf.Value$KindCase r1 = com.google.protobuf.Value.KindCase.NULL_VALUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$Value$KindCase     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.Value$KindCase r1 = com.google.protobuf.Value.KindCase.NUMBER_VALUE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$Value$KindCase     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.Value$KindCase r1 = com.google.protobuf.Value.KindCase.STRING_VALUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$Value$KindCase     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.Value$KindCase r1 = com.google.protobuf.Value.KindCase.BOOL_VALUE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$Value$KindCase     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.Value$KindCase r1 = com.google.protobuf.Value.KindCase.STRUCT_VALUE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$Value$KindCase     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.Value$KindCase r1 = com.google.protobuf.Value.KindCase.LIST_VALUE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$Value$KindCase     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.Value$KindCase r1 = com.google.protobuf.Value.KindCase.KIND_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Value.C196972.<clinit>():void");
        }
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Value> parser() {
        return PARSER;
    }

    public Parser<Value> getParserForType() {
        return PARSER;
    }

    public Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
