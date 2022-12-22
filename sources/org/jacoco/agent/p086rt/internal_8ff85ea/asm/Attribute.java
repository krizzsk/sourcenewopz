package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute */
public class Attribute {
    Attribute next;
    public final String type;
    byte[] value;

    /* access modifiers changed from: protected */
    public Label[] getLabels() {
        return null;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    public boolean isUnknown() {
        return true;
    }

    protected Attribute(String str) {
        this.type = str;
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader classReader, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        Attribute attribute = new Attribute(this.type);
        attribute.value = new byte[i2];
        System.arraycopy(classReader.f6580b, i, attribute.value, 0, i2);
        return attribute;
    }

    /* access modifiers changed from: protected */
    public ByteVector write(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        ByteVector byteVector = new ByteVector();
        byteVector.data = this.value;
        byteVector.length = this.value.length;
        return byteVector;
    }

    /* access modifiers changed from: package-private */
    public final int getCount() {
        int i = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.next) {
            i++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final int getSize(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.next) {
            classWriter.newUTF8(attribute.type);
            i4 += attribute.write(classWriter, bArr, i, i2, i3).length + 6;
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final void put(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3, ByteVector byteVector) {
        for (Attribute attribute = this; attribute != null; attribute = attribute.next) {
            ByteVector write = attribute.write(classWriter, bArr, i, i2, i3);
            byteVector.putShort(classWriter.newUTF8(attribute.type)).putInt(write.length);
            byteVector.putByteArray(write.data, 0, write.length);
        }
    }
}
