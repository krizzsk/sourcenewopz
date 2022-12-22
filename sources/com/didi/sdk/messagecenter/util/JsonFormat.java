package com.didi.sdk.messagecenter.util;

import android.util.Log;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import okio.ByteString;

public class JsonFormat {
    /* renamed from: b */
    private static void m26057b(Message message, JsonGenerator jsonGenerator) {
        try {
            m26052a(message, jsonGenerator);
        } catch (IncompatibleClassChangeError e) {
            Log.d("JsonFormat", "print error", e);
        }
    }

    public static String toJson(Message message) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, Charset.defaultCharset());
            m26057b(message, new JsonGenerator(outputStreamWriter));
            outputStreamWriter.flush();
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static void m26052a(Message message, JsonGenerator jsonGenerator) {
        JsonGenerator jsonGenerator2 = jsonGenerator;
        Class<?> cls = message.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if (protoField != null) {
                int tag = protoField.tag();
                String name = field.getName();
                Class cls2 = null;
                Message.Datatype type = protoField.type();
                if (type == Message.Datatype.ENUM) {
                    cls2 = m26055b(field);
                } else if (type == Message.Datatype.MESSAGE) {
                    cls2 = m26046a(field);
                }
                linkedHashMap.put(Integer.valueOf(tag), new FieldInfo(tag, name, type, protoField.label(), protoField.redacted(), cls2, field, (C125191) null));
            }
        }
        TagMap of = TagMap.m26062of(linkedHashMap);
        try {
            jsonGenerator2.print(Const.joLeft);
            m26053a(message, (TagMap<FieldInfo>) of, jsonGenerator2);
            jsonGenerator2.print("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m26053a(Message message, TagMap<FieldInfo> tagMap, JsonGenerator jsonGenerator) throws IOException {
        boolean z = true;
        for (FieldInfo next : tagMap.values()) {
            Object a = m26047a(message, next);
            if (a != null) {
                if (!z) {
                    jsonGenerator.print(",");
                }
                m26051a(next, a, jsonGenerator);
                z = false;
            }
        }
    }

    /* renamed from: a */
    private static void m26051a(FieldInfo fieldInfo, Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.print(Const.jsQuote);
        jsonGenerator.print(fieldInfo.name);
        jsonGenerator.print(Const.jsQuote);
        if (fieldInfo.datatype == Message.Datatype.MESSAGE) {
            jsonGenerator.print(": ");
            jsonGenerator.indent();
        } else {
            jsonGenerator.print(": ");
        }
        if (fieldInfo.label == Message.Label.REPEATED) {
            jsonGenerator.print(Const.jaLeft);
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                m26056b(fieldInfo, it.next(), jsonGenerator);
                if (it.hasNext()) {
                    jsonGenerator.print(",");
                }
            }
            jsonGenerator.print(Const.jaRight);
            return;
        }
        m26056b(fieldInfo, obj, jsonGenerator);
        if (fieldInfo.datatype == Message.Datatype.MESSAGE) {
            jsonGenerator.outdent();
        }
    }

    /* renamed from: com.didi.sdk.messagecenter.util.JsonFormat$1 */
    static /* synthetic */ class C125191 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$Message$Datatype;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.squareup.wire.Message$Datatype[] r0 = com.squareup.wire.Message.Datatype.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$squareup$wire$Message$Datatype = r0
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.INT32     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.INT64     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SINT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x006c }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.BOOL     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.UINT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.FIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x009c }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.FIXED64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.STRING     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.ENUM     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.squareup.wire.Message$Datatype r1 = com.squareup.wire.Message.Datatype.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.messagecenter.util.JsonFormat.C125191.<clinit>():void");
        }
    }

    /* renamed from: b */
    private static void m26056b(FieldInfo fieldInfo, Object obj, JsonGenerator jsonGenerator) throws IOException {
        switch (C125191.$SwitchMap$com$squareup$wire$Message$Datatype[fieldInfo.datatype.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                jsonGenerator.print(obj.toString());
                return;
            case 10:
            case 11:
                jsonGenerator.print(TextUtils.unsignedToString(((Integer) obj).intValue()));
                return;
            case 12:
            case 13:
                jsonGenerator.print(TextUtils.unsignedToString(((Long) obj).longValue()));
                return;
            case 14:
                jsonGenerator.print(Const.jsQuote);
                jsonGenerator.print(m26049a((String) obj));
                jsonGenerator.print(Const.jsQuote);
                return;
            case 15:
                jsonGenerator.print(Const.jsQuote);
                jsonGenerator.print(m26050a((ByteString) obj));
                jsonGenerator.print(Const.jsQuote);
                return;
            case 16:
                jsonGenerator.print(((ProtoEnum) obj).getValue() + "");
                return;
            case 17:
                m26057b((Message) obj, jsonGenerator);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private static String m26049a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == 12) {
                sb.append("\\f");
            } else if (first == 13) {
                sb.append("\\r");
            } else if (first == '\"') {
                sb.append("\\\"");
            } else if (first == '/') {
                sb.append("\\/");
            } else if (first != '\\') {
                switch (first) {
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    default:
                        if (first < 0 || first > 31) {
                            if (!Character.isHighSurrogate(first)) {
                                sb.append(first);
                                break;
                            } else {
                                m26054a(sb, first);
                                char next = stringCharacterIterator.next();
                                if (next != 65535) {
                                    m26054a(sb, next);
                                    break;
                                } else {
                                    throw new IllegalArgumentException("invalid unicode string: unexpected high surrogate pair value without corresponding low value.");
                                }
                            }
                        } else {
                            m26054a(sb, first);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    static void m26054a(StringBuilder sb, char c) {
        sb.append(c < 16 ? "\\u000" : c < 256 ? "\\u00" : c < 4096 ? "\\u0" : "\\u");
        sb.append(Integer.toHexString(c));
    }

    /* renamed from: a */
    private static String m26050a(ByteString byteString) {
        StringBuilder sb = new StringBuilder(byteString.size());
        for (int i = 0; i < byteString.size(); i++) {
            byte b = byteString.getByte(i);
            if (b == 34) {
                sb.append("\\\"");
            } else if (b == 39) {
                sb.append("\\'");
            } else if (b != 92) {
                switch (b) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (b < 32) {
                            sb.append(m26048a((char) b));
                            break;
                        } else {
                            sb.append((char) b);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m26048a(char c) {
        if (c < 16) {
            return "\\u000" + Integer.toHexString(c);
        } else if (c < 256) {
            return "\\u00" + Integer.toHexString(c);
        } else if (c < 4096) {
            return "\\u0" + Integer.toHexString(c);
        } else {
            return "\\u" + Integer.toHexString(c);
        }
    }

    /* renamed from: a */
    private static Object m26047a(Message message, FieldInfo fieldInfo) {
        if (fieldInfo.messageField != null) {
            try {
                return fieldInfo.messageField.get(message);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        } else {
            throw new AssertionError("Field is not of type \"Message\"");
        }
    }

    /* renamed from: a */
    private static Class<? extends Message> m26046a(Field field) {
        Class<?> type = field.getType();
        if (Message.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).messageType();
        }
        return null;
    }

    /* renamed from: b */
    private static Class<? extends Enum> m26055b(Field field) {
        Class<?> type = field.getType();
        if (Enum.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).enumType();
        }
        return null;
    }

    private static final class FieldInfo {
        final Message.Datatype datatype;
        final Class<? extends ProtoEnum> enumType;
        final Message.Label label;
        /* access modifiers changed from: private */
        public final Field messageField;
        final Class<? extends Message> messageType;
        final String name;
        final boolean redacted;
        final int tag;

        /* synthetic */ FieldInfo(int i, String str, Message.Datatype datatype2, Message.Label label2, boolean z, Class cls, Field field, C125191 r8) {
            this(i, str, datatype2, label2, z, cls, field);
        }

        private FieldInfo(int i, String str, Message.Datatype datatype2, Message.Label label2, boolean z, Class<?> cls, Field field) {
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
        }
    }

    private static class JsonGenerator {
        boolean atStartOfLine = true;
        StringBuilder indent = new StringBuilder();
        Appendable output;

        public JsonGenerator(Appendable appendable) {
            this.output = appendable;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length != 0) {
                this.indent.delete(length - 2, length);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void print(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (charSequence.charAt(i2) == 10) {
                    write(charSequence.subSequence(i, length), (i2 - i) + 1);
                    i = i2 + 1;
                    this.atStartOfLine = true;
                }
            }
            write(charSequence.subSequence(i, length), length - i);
        }

        private void write(CharSequence charSequence, int i) throws IOException {
            if (i != 0) {
                if (this.atStartOfLine) {
                    this.atStartOfLine = false;
                    this.output.append(this.indent);
                }
                this.output.append(charSequence);
            }
        }
    }
}
