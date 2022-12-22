package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

public class NativeDataView extends NativeArrayBufferView {
    public static final String CLASS_NAME = "DataView";
    private static final int Id_constructor = 1;
    private static final int Id_getFloat32 = 8;
    private static final int Id_getFloat64 = 9;
    private static final int Id_getInt16 = 4;
    private static final int Id_getInt32 = 6;
    private static final int Id_getInt8 = 2;
    private static final int Id_getUint16 = 5;
    private static final int Id_getUint32 = 7;
    private static final int Id_getUint8 = 3;
    private static final int Id_setFloat32 = 16;
    private static final int Id_setFloat64 = 17;
    private static final int Id_setInt16 = 12;
    private static final int Id_setInt32 = 14;
    private static final int Id_setInt8 = 10;
    private static final int Id_setUint16 = 13;
    private static final int Id_setUint32 = 15;
    private static final int Id_setUint8 = 11;
    private static final int MAX_PROTOTYPE_ID = 17;
    private static final long serialVersionUID = 1427967607557438968L;

    public String getClassName() {
        return CLASS_NAME;
    }

    public NativeDataView() {
    }

    public NativeDataView(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeDataView().exportAsJSClass(17, scriptable, z);
    }

    private void rangeCheck(int i, int i2) {
        if (i < 0 || i + i2 > this.byteLength) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
    }

    private void checkOffset(Object[] objArr, int i) {
        if (objArr.length <= i) {
            throw ScriptRuntime.constructError("TypeError", "missing required offset parameter");
        } else if (Undefined.instance.equals(objArr[i])) {
            throw ScriptRuntime.constructError("RangeError", "invalid offset");
        }
    }

    private void checkValue(Object[] objArr, int i) {
        if (objArr.length <= i) {
            throw ScriptRuntime.constructError("TypeError", "missing required value parameter");
        } else if (Undefined.instance.equals(objArr[i])) {
            throw ScriptRuntime.constructError("RangeError", "invalid value parameter");
        }
    }

    private static NativeDataView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeDataView) {
            return (NativeDataView) scriptable;
        }
        throw incompatibleCallError(idFunctionObject);
    }

    private NativeDataView js_constructor(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        if (i2 < 0) {
            throw ScriptRuntime.constructError("RangeError", "length out of range");
        } else if (i >= 0 && i + i2 <= nativeArrayBuffer.getLength()) {
            return new NativeDataView(nativeArrayBuffer, i, i2);
        } else {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
    }

    private Object js_getInt(int i, boolean z, Object[] objArr) {
        boolean z2 = false;
        checkOffset(objArr, 0);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1])) {
            z2 = true;
        }
        if (i == 1) {
            byte[] bArr = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt8(bArr, int32) : ByteIo.readUint8(bArr, int32);
        } else if (i == 2) {
            byte[] bArr2 = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt16(bArr2, int32, z2) : ByteIo.readUint16(bArr2, int32, z2);
        } else if (i == 4) {
            byte[] bArr3 = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt32(bArr3, int32, z2) : ByteIo.readUint32(bArr3, int32, z2);
        } else {
            throw new AssertionError();
        }
    }

    private Object js_getFloat(int i, Object[] objArr) {
        boolean z = false;
        checkOffset(objArr, 0);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1])) {
            z = true;
        }
        if (i == 4) {
            return ByteIo.readFloat32(this.arrayBuffer.buffer, int32, z);
        }
        if (i == 8) {
            return ByteIo.readFloat64(this.arrayBuffer.buffer, int32, z);
        }
        throw new AssertionError();
    }

    private void js_setInt(int i, boolean z, Object[] objArr) {
        boolean z2 = false;
        checkOffset(objArr, 0);
        checkValue(objArr, 1);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2])) {
            z2 = true;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    throw new AssertionError();
                } else if (z) {
                    ByteIo.writeInt32(this.arrayBuffer.buffer, int32, Conversions.toInt32(objArr[1]), z2);
                } else {
                    ByteIo.writeUint32(this.arrayBuffer.buffer, int32, Conversions.toUint32(objArr[1]), z2);
                }
            } else if (z) {
                ByteIo.writeInt16(this.arrayBuffer.buffer, int32, Conversions.toInt16(objArr[1]), z2);
            } else {
                ByteIo.writeUint16(this.arrayBuffer.buffer, int32, Conversions.toUint16(objArr[1]), z2);
            }
        } else if (z) {
            ByteIo.writeInt8(this.arrayBuffer.buffer, int32, Conversions.toInt8(objArr[1]));
        } else {
            ByteIo.writeUint8(this.arrayBuffer.buffer, int32, Conversions.toUint8(objArr[1]));
        }
    }

    private void js_setFloat(int i, Object[] objArr) {
        boolean z = false;
        checkOffset(objArr, 0);
        checkValue(objArr, 1);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2])) {
            z = true;
        }
        double number = ScriptRuntime.toNumber(objArr[1]);
        if (i == 4) {
            ByteIo.writeFloat32(this.arrayBuffer.buffer, int32, number, z);
        } else if (i == 8) {
            ByteIo.writeFloat64(this.arrayBuffer.buffer, int32, number, z);
        } else {
            throw new AssertionError();
        }
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        int i = 0;
        switch (methodId) {
            case 1:
                if (!isArg(objArr, 0) || !(objArr[0] instanceof NativeArrayBuffer)) {
                    throw ScriptRuntime.constructError("TypeError", "Missing parameters");
                }
                NativeArrayBuffer nativeArrayBuffer = objArr[0];
                if (isArg(objArr, 1)) {
                    i = ScriptRuntime.toInt32(objArr[1]);
                }
                return js_constructor(nativeArrayBuffer, i, isArg(objArr, 2) ? ScriptRuntime.toInt32(objArr[2]) : nativeArrayBuffer.getLength() - i);
            case 2:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, true, objArr);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, false, objArr);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, true, objArr);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, false, objArr);
            case 6:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, true, objArr);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, false, objArr);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_getFloat(4, objArr);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getFloat(8, objArr);
            case 10:
                realThis(scriptable2, idFunctionObject).js_setInt(1, true, objArr);
                return Undefined.instance;
            case 11:
                realThis(scriptable2, idFunctionObject).js_setInt(1, false, objArr);
                return Undefined.instance;
            case 12:
                realThis(scriptable2, idFunctionObject).js_setInt(2, true, objArr);
                return Undefined.instance;
            case 13:
                realThis(scriptable2, idFunctionObject).js_setInt(2, false, objArr);
                return Undefined.instance;
            case 14:
                realThis(scriptable2, idFunctionObject).js_setInt(4, true, objArr);
                return Undefined.instance;
            case 15:
                realThis(scriptable2, idFunctionObject).js_setInt(4, false, objArr);
                return Undefined.instance;
            case 16:
                realThis(scriptable2, idFunctionObject).js_setFloat(4, objArr);
                return Undefined.instance;
            case 17:
                realThis(scriptable2, idFunctionObject).js_setFloat(8, objArr);
                return Undefined.instance;
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    /* access modifiers changed from: protected */
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 2;
        switch (i) {
            case 1:
                str2 = "constructor";
                break;
            case 2:
                str2 = "getInt8";
                break;
            case 3:
                str2 = "getUint8";
                break;
            case 4:
                str2 = "getInt16";
                break;
            case 5:
                str2 = "getUint16";
                break;
            case 6:
                str2 = "getInt32";
                break;
            case 7:
                str2 = "getUint32";
                break;
            case 8:
                str2 = "getFloat32";
                break;
            case 9:
                str2 = "getFloat64";
                break;
            case 10:
                str = "setInt8";
                break;
            case 11:
                str = "setUint8";
                break;
            case 12:
                str = "setInt16";
                break;
            case 13:
                str = "setUint16";
                break;
            case 14:
                str = "setInt32";
                break;
            case 15:
                str = "setUint32";
                break;
            case 16:
                str = "setFloat32";
                break;
            case 17:
                str = "setFloat64";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        str = str2;
        i2 = 1;
        initPrototypeMethod(getClassName(), i, str, i2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = 6
            r2 = 9
            r3 = 8
            r4 = 50
            r5 = 115(0x73, float:1.61E-43)
            r6 = 103(0x67, float:1.44E-43)
            r7 = 0
            switch(r0) {
                case 7: goto L_0x00bc;
                case 8: goto L_0x007a;
                case 9: goto L_0x004c;
                case 10: goto L_0x001a;
                case 11: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x00cd
        L_0x0015:
            r1 = 1
            java.lang.String r0 = "constructor"
            goto L_0x00cf
        L_0x001a:
            char r0 = r9.charAt(r7)
            r1 = 52
            if (r0 != r6) goto L_0x0036
            char r0 = r9.charAt(r2)
            if (r0 != r4) goto L_0x002e
            java.lang.String r0 = "getFloat32"
            r1 = 8
            goto L_0x00cf
        L_0x002e:
            if (r0 != r1) goto L_0x00cd
            java.lang.String r0 = "getFloat64"
            r1 = 9
            goto L_0x00cf
        L_0x0036:
            if (r0 != r5) goto L_0x00cd
            char r0 = r9.charAt(r2)
            if (r0 != r4) goto L_0x0044
            r1 = 16
            java.lang.String r0 = "setFloat32"
            goto L_0x00cf
        L_0x0044:
            if (r0 != r1) goto L_0x00cd
            r1 = 17
            java.lang.String r0 = "setFloat64"
            goto L_0x00cf
        L_0x004c:
            char r0 = r9.charAt(r7)
            r1 = 54
            if (r0 != r6) goto L_0x0066
            char r0 = r9.charAt(r3)
            if (r0 != r4) goto L_0x005f
            r1 = 7
            java.lang.String r0 = "getUint32"
            goto L_0x00cf
        L_0x005f:
            if (r0 != r1) goto L_0x00cd
            r1 = 5
            java.lang.String r0 = "getUint16"
            goto L_0x00cf
        L_0x0066:
            if (r0 != r5) goto L_0x00cd
            char r0 = r9.charAt(r3)
            if (r0 != r4) goto L_0x0073
            r1 = 15
            java.lang.String r0 = "setUint32"
            goto L_0x00cf
        L_0x0073:
            if (r0 != r1) goto L_0x00cd
            r1 = 13
            java.lang.String r0 = "setUint16"
            goto L_0x00cf
        L_0x007a:
            char r0 = r9.charAt(r1)
            r2 = 49
            if (r0 != r2) goto L_0x0093
            char r0 = r9.charAt(r7)
            if (r0 != r6) goto L_0x008c
            r1 = 4
            java.lang.String r0 = "getInt16"
            goto L_0x00cf
        L_0x008c:
            if (r0 != r5) goto L_0x00cd
            r1 = 12
            java.lang.String r0 = "setInt16"
            goto L_0x00cf
        L_0x0093:
            r2 = 51
            if (r0 != r2) goto L_0x00a7
            char r0 = r9.charAt(r7)
            if (r0 != r6) goto L_0x00a0
            java.lang.String r0 = "getInt32"
            goto L_0x00cf
        L_0x00a0:
            if (r0 != r5) goto L_0x00cd
            r1 = 14
            java.lang.String r0 = "setInt32"
            goto L_0x00cf
        L_0x00a7:
            r1 = 116(0x74, float:1.63E-43)
            if (r0 != r1) goto L_0x00cd
            char r0 = r9.charAt(r7)
            if (r0 != r6) goto L_0x00b5
            r1 = 3
            java.lang.String r0 = "getUint8"
            goto L_0x00cf
        L_0x00b5:
            if (r0 != r5) goto L_0x00cd
            r1 = 11
            java.lang.String r0 = "setUint8"
            goto L_0x00cf
        L_0x00bc:
            char r0 = r9.charAt(r7)
            if (r0 != r6) goto L_0x00c6
            r1 = 2
            java.lang.String r0 = "getInt8"
            goto L_0x00cf
        L_0x00c6:
            if (r0 != r5) goto L_0x00cd
            r1 = 10
            java.lang.String r0 = "setInt8"
            goto L_0x00cf
        L_0x00cd:
            r0 = 0
            r1 = 0
        L_0x00cf:
            if (r0 == 0) goto L_0x00da
            if (r0 == r9) goto L_0x00da
            boolean r9 = r0.equals(r9)
            if (r9 != 0) goto L_0x00da
            goto L_0x00db
        L_0x00da:
            r7 = r1
        L_0x00db:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.typedarrays.NativeDataView.findPrototypeId(java.lang.String):int");
    }
}
