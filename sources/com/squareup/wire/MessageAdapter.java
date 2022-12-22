package com.squareup.wire;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import okio.ByteString;

final class MessageAdapter<M extends Message> {
    private static final String FULL_BLOCK = "█";
    private static final String REDACTED = "██";
    private final Class<Message.Builder<M>> builderType;
    private final TagMap<FieldInfo> fieldInfoMap;
    private final Class<M> messageType;
    private final Map<String, Integer> tagMap = new LinkedHashMap();
    private final Wire wire;

    public static final class FieldInfo {
        /* access modifiers changed from: private */
        public final Field builderField;
        final Message.Datatype datatype;
        EnumAdapter<? extends ProtoEnum> enumAdapter;
        final Class<? extends ProtoEnum> enumType;
        final Message.Label label;
        MessageAdapter<? extends Message> messageAdapter;
        /* access modifiers changed from: private */
        public final Field messageField;
        final Class<? extends Message> messageType;
        final String name;
        final boolean redacted;
        final int tag;

        /* synthetic */ FieldInfo(int i, String str, Message.Datatype datatype2, Message.Label label2, boolean z, Class cls, Field field, Field field2, C205801 r9) {
            this(i, str, datatype2, label2, z, cls, field, field2);
        }

        private FieldInfo(int i, String str, Message.Datatype datatype2, Message.Label label2, boolean z, Class<?> cls, Field field, Field field2) {
            this.tag = i;
            this.name = str;
            this.datatype = datatype2;
            this.label = label2;
            this.redacted = z;
            if (datatype2 == Message.Datatype.ENUM) {
                this.enumType = cls;
                this.messageType = null;
            } else if (datatype2 == Message.Datatype.MESSAGE) {
                this.messageType = cls;
                this.enumType = null;
            } else {
                this.enumType = null;
                this.messageType = null;
            }
            this.messageField = field;
            this.builderField = field2;
        }
    }

    /* access modifiers changed from: package-private */
    public Message.Builder<M> newBuilder() {
        try {
            return this.builderType.newInstance();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public Collection<FieldInfo> getFields() {
        return this.fieldInfoMap.values();
    }

    /* access modifiers changed from: package-private */
    public FieldInfo getField(String str) {
        Integer num = this.tagMap.get(str);
        if (num == null) {
            return null;
        }
        return this.fieldInfoMap.get(num.intValue());
    }

    /* access modifiers changed from: package-private */
    public Object getFieldValue(M m, FieldInfo fieldInfo) {
        if (fieldInfo.messageField != null) {
            try {
                return fieldInfo.messageField.get(m);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        } else {
            throw new AssertionError("Field is not of type \"Message\"");
        }
    }

    public void setBuilderField(Message.Builder<M> builder, int i, Object obj) {
        try {
            this.fieldInfoMap.get(i).builderField.set(builder, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    MessageAdapter(Wire wire2, Class<M> cls) {
        Field[] fieldArr;
        Class<M> cls2 = cls;
        this.wire = wire2;
        this.messageType = cls2;
        this.builderType = getBuilderType(cls2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if (protoField != null) {
                int tag = protoField.tag();
                String name = field.getName();
                this.tagMap.put(name, Integer.valueOf(tag));
                Class cls3 = null;
                Message.Datatype type = protoField.type();
                if (type == Message.Datatype.ENUM) {
                    cls3 = getEnumType(field);
                } else if (type == Message.Datatype.MESSAGE) {
                    cls3 = getMessageType(field);
                }
                Integer valueOf = Integer.valueOf(tag);
                Message.Label label = protoField.label();
                boolean redacted = protoField.redacted();
                fieldArr = declaredFields;
                FieldInfo fieldInfo = r5;
                FieldInfo fieldInfo2 = new FieldInfo(tag, name, type, label, redacted, cls3, field, getBuilderField(name), (C205801) null);
                linkedHashMap.put(valueOf, fieldInfo);
            } else {
                fieldArr = declaredFields;
            }
            i++;
            declaredFields = fieldArr;
        }
        this.fieldInfoMap = TagMap.m40368of(linkedHashMap);
    }

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        try {
            return Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private Field getBuilderField(String str) {
        try {
            return this.builderType.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + this.builderType.getName() + "." + str);
        }
    }

    private Class<? extends Message> getMessageType(Field field) {
        Class<?> type = field.getType();
        if (Message.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).messageType();
        }
        return null;
    }

    private Class<? extends Enum> getEnumType(Field field) {
        Class<?> type = field.getType();
        if (Enum.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).enumType();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(M m) {
        int i;
        int i2 = 0;
        for (FieldInfo next : getFields()) {
            Object fieldValue = getFieldValue(m, next);
            if (fieldValue != null) {
                int i3 = next.tag;
                Message.Datatype datatype = next.datatype;
                Message.Label label = next.label;
                if (!label.isRepeated()) {
                    i = getSerializedSize(i3, fieldValue, datatype);
                } else if (label.isPacked()) {
                    i = getPackedSize((List) fieldValue, i3, datatype);
                } else {
                    i = getRepeatedSize((List) fieldValue, i3, datatype);
                }
                i2 += i;
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                i2 += getExtensionsSerializedSize(extendableMessage.extensionMap);
            }
        }
        return i2 + m.getUnknownFieldsSerializedSize();
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < extensionMap.size(); i3++) {
            Extension<T, ?> extension = extensionMap.getExtension(i3);
            Object extensionValue = extensionMap.getExtensionValue(i3);
            int tag = extension.getTag();
            Message.Datatype datatype = extension.getDatatype();
            Message.Label label = extension.getLabel();
            if (!label.isRepeated()) {
                i = getSerializedSize(tag, extensionValue, datatype);
            } else if (label.isPacked()) {
                i = getPackedSize((List) extensionValue, tag, datatype);
            } else {
                i = getRepeatedSize((List) extensionValue, tag, datatype);
            }
            i2 += i;
        }
        return i2;
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        for (Object serializedSize : list) {
            i2 += getSerializedSize(i, serializedSize, datatype);
        }
        return i2;
    }

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        for (Object serializedSizeNoTag : list) {
            i2 += getSerializedSizeNoTag(serializedSizeNoTag, datatype);
        }
        return WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i2) + i2;
    }

    /* access modifiers changed from: package-private */
    public void write(M m, WireOutput wireOutput) throws IOException {
        for (FieldInfo next : getFields()) {
            Object fieldValue = getFieldValue(m, next);
            if (fieldValue != null) {
                int i = next.tag;
                Message.Datatype datatype = next.datatype;
                Message.Label label = next.label;
                if (!label.isRepeated()) {
                    writeValue(wireOutput, i, fieldValue, datatype);
                } else if (label.isPacked()) {
                    writePacked(wireOutput, (List) fieldValue, i, datatype);
                } else {
                    writeRepeated(wireOutput, (List) fieldValue, i, datatype);
                }
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                writeExtensions(wireOutput, extendableMessage.extensionMap);
            }
        }
        m.writeUnknownFieldMap(wireOutput);
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) throws IOException {
        for (int i = 0; i < extensionMap.size(); i++) {
            Extension<T, ?> extension = extensionMap.getExtension(i);
            Object extensionValue = extensionMap.getExtensionValue(i);
            int tag = extension.getTag();
            Message.Datatype datatype = extension.getDatatype();
            Message.Label label = extension.getLabel();
            if (!label.isRepeated()) {
                writeValue(wireOutput, tag, extensionValue, datatype);
            } else if (label.isPacked()) {
                writePacked(wireOutput, (List) extensionValue, tag, datatype);
            } else {
                writeRepeated(wireOutput, (List) extensionValue, tag, datatype);
            }
        }
    }

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        for (Object writeValue : list) {
            writeValue(wireOutput, i, writeValue, datatype);
        }
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        int i2 = 0;
        for (Object serializedSizeNoTag : list) {
            i2 += getSerializedSizeNoTag(serializedSizeNoTag, datatype);
        }
        wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
        wireOutput.writeVarint32(i2);
        for (Object writeValueNoTag : list) {
            writeValueNoTag(wireOutput, writeValueNoTag, datatype);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] toByteArray(M m) {
        byte[] bArr = new byte[getSerializedSize(m)];
        try {
            write(m, WireOutput.newInstance(bArr));
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append(Const.joLeft);
        String str = "";
        for (FieldInfo next : getFields()) {
            Object fieldValue = getFieldValue(m, next);
            if (fieldValue != null) {
                sb.append(str);
                sb.append(next.name);
                sb.append("=");
                if (next.redacted) {
                    fieldValue = REDACTED;
                }
                sb.append(fieldValue);
                str = ", ";
            }
        }
        if (m instanceof ExtendableMessage) {
            sb.append(str);
            sb.append("{extensions=");
            sb.append(((ExtendableMessage) m).extensionsToString());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        return WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
    }

    private int getSerializedSizeNoTag(Object obj, Message.Datatype datatype) {
        int utf8Length;
        int varint32Size;
        switch (C205801.$SwitchMap$com$squareup$wire$Message$Datatype[datatype.ordinal()]) {
            case 1:
                return WireOutput.int32Size(((Integer) obj).intValue());
            case 2:
            case 3:
                return WireOutput.varint64Size(((Long) obj).longValue());
            case 4:
                return WireOutput.varint32Size(((Integer) obj).intValue());
            case 5:
                return WireOutput.varint32Size(WireOutput.zigZag32(((Integer) obj).intValue()));
            case 6:
                return WireOutput.varint64Size(WireOutput.zigZag64(((Long) obj).longValue()));
            case 7:
                return 1;
            case 8:
                return getEnumSize((ProtoEnum) obj);
            case 9:
                utf8Length = utf8Length((String) obj);
                varint32Size = WireOutput.varint32Size(utf8Length);
                break;
            case 10:
                utf8Length = ((ByteString) obj).size();
                varint32Size = WireOutput.varint32Size(utf8Length);
                break;
            case 11:
                return getMessageSize((Message) obj);
            case 12:
            case 13:
            case 14:
                return 4;
            case 15:
            case 16:
            case 17:
                return 8;
            default:
                throw new RuntimeException();
        }
        return varint32Size + utf8Length;
    }

    private int utf8Length(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private <E extends ProtoEnum> int getEnumSize(E e) {
        return WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    private <M extends Message> int getMessageSize(M m) {
        int serializedSize = m.getSerializedSize();
        return WireOutput.varint32Size(serializedSize) + serializedSize;
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) throws IOException {
        wireOutput.writeTag(i, datatype.wireType());
        writeValueNoTag(wireOutput, obj, datatype);
    }

    private void writeValueNoTag(WireOutput wireOutput, Object obj, Message.Datatype datatype) throws IOException {
        switch (C205801.$SwitchMap$com$squareup$wire$Message$Datatype[datatype.ordinal()]) {
            case 1:
                wireOutput.writeSignedVarint32(((Integer) obj).intValue());
                return;
            case 2:
            case 3:
                wireOutput.writeVarint64(((Long) obj).longValue());
                return;
            case 4:
                wireOutput.writeVarint32(((Integer) obj).intValue());
                return;
            case 5:
                wireOutput.writeVarint32(WireOutput.zigZag32(((Integer) obj).intValue()));
                return;
            case 6:
                wireOutput.writeVarint64(WireOutput.zigZag64(((Long) obj).longValue()));
                return;
            case 7:
                wireOutput.writeRawByte(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case 8:
                writeEnum((ProtoEnum) obj, wireOutput);
                return;
            case 9:
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                wireOutput.writeVarint32(bytes.length);
                wireOutput.writeRawBytes(bytes);
                return;
            case 10:
                ByteString byteString = (ByteString) obj;
                wireOutput.writeVarint32(byteString.size());
                wireOutput.writeRawBytes(byteString.toByteArray());
                return;
            case 11:
                writeMessage((Message) obj, wireOutput);
                return;
            case 12:
            case 13:
                wireOutput.writeFixed32(((Integer) obj).intValue());
                return;
            case 14:
                wireOutput.writeFixed32(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case 15:
            case 16:
                wireOutput.writeFixed64(((Long) obj).longValue());
                return;
            case 17:
                wireOutput.writeFixed64(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(m.getSerializedSize());
        this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
    }

    private <E extends ProtoEnum> void writeEnum(E e, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    /* access modifiers changed from: package-private */
    public M read(WireInput wireInput) throws IOException {
        Message.Datatype datatype;
        Extension<ExtendableMessage<?>, ?> extension;
        Message.Label label;
        long j;
        WireInput wireInput2 = wireInput;
        try {
            Message.Builder newInstance = this.builderType.newInstance();
            Storage storage = new Storage((C205801) null);
            while (true) {
                int readTag = wireInput.readTag();
                int i = readTag >> 3;
                WireType valueOf = WireType.valueOf(readTag);
                if (i == 0) {
                    for (Integer intValue : storage.getTags()) {
                        int intValue2 = intValue.intValue();
                        if (this.fieldInfoMap.containsKey(intValue2)) {
                            setBuilderField(newInstance, intValue2, storage.get(intValue2));
                        } else {
                            setExtension((ExtendableMessage.ExtendableBuilder) newInstance, getExtension(intValue2), storage.get(intValue2));
                        }
                    }
                    return newInstance.build();
                }
                FieldInfo fieldInfo = this.fieldInfoMap.get(i);
                if (fieldInfo != null) {
                    Message.Datatype datatype2 = fieldInfo.datatype;
                    label = fieldInfo.label;
                    datatype = datatype2;
                    extension = null;
                } else {
                    Extension<ExtendableMessage<?>, ?> extension2 = getExtension(i);
                    if (extension2 == null) {
                        readUnknownField(newInstance, wireInput2, i, valueOf);
                    } else {
                        Message.Datatype datatype3 = extension2.getDatatype();
                        extension = extension2;
                        label = extension2.getLabel();
                        datatype = datatype3;
                    }
                }
                if (!label.isPacked() || valueOf != WireType.LENGTH_DELIMITED) {
                    Object readValue = readValue(wireInput2, i, datatype);
                    if (datatype == Message.Datatype.ENUM && (readValue instanceof Integer)) {
                        newInstance.addVarint(i, (long) ((Integer) readValue).intValue());
                    } else if (label.isRepeated()) {
                        storage.add(i, readValue);
                    } else if (extension != null) {
                        setExtension((ExtendableMessage.ExtendableBuilder) newInstance, extension, readValue);
                    } else {
                        setBuilderField(newInstance, i, readValue);
                    }
                } else {
                    int readVarint32 = wireInput.readVarint32();
                    long position = wireInput.getPosition();
                    int pushLimit = wireInput2.pushLimit(readVarint32);
                    while (true) {
                        j = ((long) readVarint32) + position;
                        if (wireInput.getPosition() >= j) {
                            break;
                        }
                        Object readValue2 = readValue(wireInput2, i, datatype);
                        if (datatype != Message.Datatype.ENUM || !(readValue2 instanceof Integer)) {
                            storage.add(i, readValue2);
                        } else {
                            newInstance.addVarint(i, (long) ((Integer) readValue2).intValue());
                        }
                    }
                    wireInput2.popLimit(pushLimit);
                    if (wireInput.getPosition() != j) {
                        throw new IOException("Packed data had wrong length!");
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object readValue(WireInput wireInput, int i, Message.Datatype datatype) throws IOException {
        switch (C205801.$SwitchMap$com$squareup$wire$Message$Datatype[datatype.ordinal()]) {
            case 1:
            case 4:
                return Integer.valueOf(wireInput.readVarint32());
            case 2:
            case 3:
                return Long.valueOf(wireInput.readVarint64());
            case 5:
                return Integer.valueOf(WireInput.decodeZigZag32(wireInput.readVarint32()));
            case 6:
                return Long.valueOf(WireInput.decodeZigZag64(wireInput.readVarint64()));
            case 7:
                return Boolean.valueOf(wireInput.readVarint32() != 0);
            case 8:
                EnumAdapter<? extends ProtoEnum> enumAdapter = getEnumAdapter(i);
                int readVarint32 = wireInput.readVarint32();
                try {
                    return enumAdapter.fromInt(readVarint32);
                } catch (IllegalArgumentException unused) {
                    return Integer.valueOf(readVarint32);
                }
            case 9:
                return wireInput.readString();
            case 10:
                return wireInput.readBytes();
            case 11:
                return readMessage(wireInput, i);
            case 12:
            case 13:
                return Integer.valueOf(wireInput.readFixed32());
            case 14:
                return Float.valueOf(Float.intBitsToFloat(wireInput.readFixed32()));
            case 15:
            case 16:
                return Long.valueOf(wireInput.readFixed64());
            case 17:
                return Double.valueOf(Double.longBitsToDouble(wireInput.readFixed64()));
            default:
                throw new RuntimeException();
        }
    }

    private Message readMessage(WireInput wireInput, int i) throws IOException {
        int readVarint32 = wireInput.readVarint32();
        if (wireInput.recursionDepth < 64) {
            int pushLimit = wireInput.pushLimit(readVarint32);
            wireInput.recursionDepth++;
            Message read = getMessageAdapter(i).read(wireInput);
            wireInput.checkLastTagWas(0);
            wireInput.recursionDepth--;
            wireInput.popLimit(pushLimit);
            return read;
        }
        throw new IOException("Wire recursion limit exceeded");
    }

    private MessageAdapter<? extends Message> getMessageAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.messageAdapter != null) {
            return fieldInfo.messageAdapter;
        }
        MessageAdapter<? extends Message> messageAdapter = this.wire.messageAdapter(getMessageClass(i));
        if (fieldInfo != null) {
            fieldInfo.messageAdapter = messageAdapter;
        }
        return messageAdapter;
    }

    private EnumAdapter<? extends ProtoEnum> getEnumAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.enumAdapter != null) {
            return fieldInfo.enumAdapter;
        }
        EnumAdapter<? extends ProtoEnum> enumAdapter = this.wire.enumAdapter(getEnumClass(i));
        if (fieldInfo != null) {
            fieldInfo.enumAdapter = enumAdapter;
        }
        return enumAdapter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r2 = getExtension(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Class<com.squareup.wire.Message> getMessageClass(int r2) {
        /*
            r1 = this;
            com.squareup.wire.TagMap<com.squareup.wire.MessageAdapter$FieldInfo> r0 = r1.fieldInfoMap
            java.lang.Object r0 = r0.get(r2)
            com.squareup.wire.MessageAdapter$FieldInfo r0 = (com.squareup.wire.MessageAdapter.FieldInfo) r0
            if (r0 != 0) goto L_0x000c
            r0 = 0
            goto L_0x000e
        L_0x000c:
            java.lang.Class<? extends com.squareup.wire.Message> r0 = r0.messageType
        L_0x000e:
            if (r0 != 0) goto L_0x001a
            com.squareup.wire.Extension r2 = r1.getExtension((int) r2)
            if (r2 == 0) goto L_0x001a
            java.lang.Class r0 = r2.getMessageType()
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.getMessageClass(int):java.lang.Class");
    }

    /* renamed from: com.squareup.wire.MessageAdapter$1 */
    static /* synthetic */ class C205801 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$Message$Datatype;
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$WireType;

        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00bb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00df */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00eb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00f7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0103 */
        static {
            /*
                com.squareup.wire.WireType[] r0 = com.squareup.wire.WireType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$squareup$wire$WireType = r0
                r1 = 1
                com.squareup.wire.WireType r2 = com.squareup.wire.WireType.VARINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.wire.WireType r3 = com.squareup.wire.WireType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.wire.WireType r4 = com.squareup.wire.WireType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.wire.WireType r5 = com.squareup.wire.WireType.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.wire.WireType r6 = com.squareup.wire.WireType.START_GROUP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.wire.WireType r7 = com.squareup.wire.WireType.END_GROUP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.squareup.wire.Message$Datatype[] r6 = com.squareup.wire.Message.Datatype.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$com$squareup$wire$Message$Datatype = r6
                com.squareup.wire.Message$Datatype r7 = com.squareup.wire.Message.Datatype.INT32     // Catch:{ NoSuchFieldError -> 0x005a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.squareup.wire.Message$Datatype r6 = com.squareup.wire.Message.Datatype.INT64     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x006e }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.UINT64     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.UINT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0082 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SINT32     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x008c }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SINT64     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0097 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.BOOL     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00a3 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.ENUM     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00af }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.STRING     // Catch:{ NoSuchFieldError -> 0x00af }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00bb }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.BYTES     // Catch:{ NoSuchFieldError -> 0x00bb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bb }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00c7 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00c7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c7 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c7 }
            L_0x00c7:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00d3 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.FIXED32     // Catch:{ NoSuchFieldError -> 0x00d3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00df }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SFIXED32     // Catch:{ NoSuchFieldError -> 0x00df }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00df }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00df }
            L_0x00df:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00eb }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.FLOAT     // Catch:{ NoSuchFieldError -> 0x00eb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00eb }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00eb }
            L_0x00eb:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00f7 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.FIXED64     // Catch:{ NoSuchFieldError -> 0x00f7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f7 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f7 }
            L_0x00f7:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0103 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0103 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0103 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0103 }
            L_0x0103:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x010f }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.DOUBLE     // Catch:{ NoSuchFieldError -> 0x010f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010f }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010f }
            L_0x010f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.C205801.<clinit>():void");
        }
    }

    private void readUnknownField(Message.Builder builder, WireInput wireInput, int i, WireType wireType) throws IOException {
        switch (C205801.$SwitchMap$com$squareup$wire$WireType[wireType.ordinal()]) {
            case 1:
                builder.ensureUnknownFieldMap().addVarint(i, Long.valueOf(wireInput.readVarint64()));
                return;
            case 2:
                builder.ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(wireInput.readFixed32()));
                return;
            case 3:
                builder.ensureUnknownFieldMap().addFixed64(i, Long.valueOf(wireInput.readFixed64()));
                return;
            case 4:
                builder.ensureUnknownFieldMap().addLengthDelimited(i, wireInput.readBytes(wireInput.readVarint32()));
                return;
            case 5:
                wireInput.skipGroup();
                return;
            case 6:
                return;
            default:
                throw new RuntimeException("Unsupported wire type: " + wireType);
        }
    }

    private static class Storage {
        private Map<Integer, ImmutableList<Object>> map;

        private Storage() {
        }

        /* synthetic */ Storage(C205801 r1) {
            this();
        }

        /* access modifiers changed from: package-private */
        public void add(int i, Object obj) {
            Map<Integer, ImmutableList<Object>> map2 = this.map;
            ImmutableList immutableList = map2 == null ? null : map2.get(Integer.valueOf(i));
            if (immutableList == null) {
                immutableList = new ImmutableList();
                if (this.map == null) {
                    this.map = new LinkedHashMap();
                }
                this.map.put(Integer.valueOf(i), immutableList);
            }
            immutableList.list.add(obj);
        }

        /* access modifiers changed from: package-private */
        public Set<Integer> getTags() {
            Map<Integer, ImmutableList<Object>> map2 = this.map;
            if (map2 == null) {
                return Collections.emptySet();
            }
            return map2.keySet();
        }

        /* access modifiers changed from: package-private */
        public List<Object> get(int i) {
            Map<Integer, ImmutableList<Object>> map2 = this.map;
            if (map2 == null) {
                return null;
            }
            return map2.get(Integer.valueOf(i));
        }
    }

    private Extension<ExtendableMessage<?>, ?> getExtension(int i) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, i);
    }

    /* access modifiers changed from: package-private */
    public Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, str);
    }

    private void setExtension(ExtendableMessage.ExtendableBuilder extendableBuilder, Extension<?, ?> extension, Object obj) {
        extendableBuilder.setExtension(extension, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r2 = getExtension(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Class<? extends com.squareup.wire.ProtoEnum> getEnumClass(int r2) {
        /*
            r1 = this;
            com.squareup.wire.TagMap<com.squareup.wire.MessageAdapter$FieldInfo> r0 = r1.fieldInfoMap
            java.lang.Object r0 = r0.get(r2)
            com.squareup.wire.MessageAdapter$FieldInfo r0 = (com.squareup.wire.MessageAdapter.FieldInfo) r0
            if (r0 != 0) goto L_0x000c
            r0 = 0
            goto L_0x000e
        L_0x000c:
            java.lang.Class<? extends com.squareup.wire.ProtoEnum> r0 = r0.enumType
        L_0x000e:
            if (r0 != 0) goto L_0x001a
            com.squareup.wire.Extension r2 = r1.getExtension((int) r2)
            if (r2 == 0) goto L_0x001a
            java.lang.Class r0 = r2.getEnumType()
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageAdapter.getEnumClass(int):java.lang.Class");
    }

    static class ImmutableList<T> extends AbstractList<T> implements Serializable, Cloneable, RandomAccess {
        /* access modifiers changed from: private */
        public final List<T> list = new ArrayList();

        public Object clone() {
            return this;
        }

        ImmutableList() {
        }

        public int size() {
            return this.list.size();
        }

        public T get(int i) {
            return this.list.get(i);
        }
    }
}
