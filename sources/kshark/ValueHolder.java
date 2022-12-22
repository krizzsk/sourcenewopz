package kshark;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00062\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, mo175978d2 = {"Lkshark/ValueHolder;", "", "()V", "BooleanHolder", "ByteHolder", "CharHolder", "Companion", "DoubleHolder", "FloatHolder", "IntHolder", "LongHolder", "ReferenceHolder", "ShortHolder", "Lkshark/ValueHolder$ReferenceHolder;", "Lkshark/ValueHolder$BooleanHolder;", "Lkshark/ValueHolder$CharHolder;", "Lkshark/ValueHolder$FloatHolder;", "Lkshark/ValueHolder$DoubleHolder;", "Lkshark/ValueHolder$ByteHolder;", "Lkshark/ValueHolder$ShortHolder;", "Lkshark/ValueHolder$IntHolder;", "Lkshark/ValueHolder$LongHolder;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ValueHolder.kt */
public abstract class ValueHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long NULL_REFERENCE = 0;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, mo175978d2 = {"Lkshark/ValueHolder$ReferenceHolder;", "Lkshark/ValueHolder;", "value", "", "(J)V", "isNull", "", "()Z", "getValue", "()J", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class ReferenceHolder extends ValueHolder {
        private final long value;

        public static /* synthetic */ ReferenceHolder copy$default(ReferenceHolder referenceHolder, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = referenceHolder.value;
            }
            return referenceHolder.copy(j);
        }

        public final long component1() {
            return this.value;
        }

        public final ReferenceHolder copy(long j) {
            return new ReferenceHolder(j);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ReferenceHolder) {
                    if (this.value == ((ReferenceHolder) obj).value) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.value;
            return (int) (j ^ (j >>> 32));
        }

        public String toString() {
            return "ReferenceHolder(value=" + this.value + ")";
        }

        public ReferenceHolder(long j) {
            super((DefaultConstructorMarker) null);
            this.value = j;
        }

        public final long getValue() {
            return this.value;
        }

        public final boolean isNull() {
            return this.value == 0;
        }
    }

    private ValueHolder() {
    }

    public /* synthetic */ ValueHolder(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lkshark/ValueHolder$BooleanHolder;", "Lkshark/ValueHolder;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class BooleanHolder extends ValueHolder {
        private final boolean value;

        public static /* synthetic */ BooleanHolder copy$default(BooleanHolder booleanHolder, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = booleanHolder.value;
            }
            return booleanHolder.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final BooleanHolder copy(boolean z) {
            return new BooleanHolder(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof BooleanHolder) {
                    if (this.value == ((BooleanHolder) obj).value) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "BooleanHolder(value=" + this.value + ")";
        }

        public BooleanHolder(boolean z) {
            super((DefaultConstructorMarker) null);
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lkshark/ValueHolder$CharHolder;", "Lkshark/ValueHolder;", "value", "", "(C)V", "getValue", "()C", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class CharHolder extends ValueHolder {
        private final char value;

        public static /* synthetic */ CharHolder copy$default(CharHolder charHolder, char c, int i, Object obj) {
            if ((i & 1) != 0) {
                c = charHolder.value;
            }
            return charHolder.copy(c);
        }

        public final char component1() {
            return this.value;
        }

        public final CharHolder copy(char c) {
            return new CharHolder(c);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof CharHolder) {
                    if (this.value == ((CharHolder) obj).value) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "CharHolder(value=" + this.value + ")";
        }

        public CharHolder(char c) {
            super((DefaultConstructorMarker) null);
            this.value = c;
        }

        public final char getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lkshark/ValueHolder$FloatHolder;", "Lkshark/ValueHolder;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class FloatHolder extends ValueHolder {
        private final float value;

        public static /* synthetic */ FloatHolder copy$default(FloatHolder floatHolder, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = floatHolder.value;
            }
            return floatHolder.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final FloatHolder copy(float f) {
            return new FloatHolder(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof FloatHolder) && Float.compare(this.value, ((FloatHolder) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "FloatHolder(value=" + this.value + ")";
        }

        public FloatHolder(float f) {
            super((DefaultConstructorMarker) null);
            this.value = f;
        }

        public final float getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lkshark/ValueHolder$DoubleHolder;", "Lkshark/ValueHolder;", "value", "", "(D)V", "getValue", "()D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class DoubleHolder extends ValueHolder {
        private final double value;

        public static /* synthetic */ DoubleHolder copy$default(DoubleHolder doubleHolder, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = doubleHolder.value;
            }
            return doubleHolder.copy(d);
        }

        public final double component1() {
            return this.value;
        }

        public final DoubleHolder copy(double d) {
            return new DoubleHolder(d);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof DoubleHolder) && Double.compare(this.value, ((DoubleHolder) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(this.value);
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }

        public String toString() {
            return "DoubleHolder(value=" + this.value + ")";
        }

        public DoubleHolder(double d) {
            super((DefaultConstructorMarker) null);
            this.value = d;
        }

        public final double getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lkshark/ValueHolder$ByteHolder;", "Lkshark/ValueHolder;", "value", "", "(B)V", "getValue", "()B", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class ByteHolder extends ValueHolder {
        private final byte value;

        public static /* synthetic */ ByteHolder copy$default(ByteHolder byteHolder, byte b, int i, Object obj) {
            if ((i & 1) != 0) {
                b = byteHolder.value;
            }
            return byteHolder.copy(b);
        }

        public final byte component1() {
            return this.value;
        }

        public final ByteHolder copy(byte b) {
            return new ByteHolder(b);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ByteHolder) {
                    if (this.value == ((ByteHolder) obj).value) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "ByteHolder(value=" + this.value + ")";
        }

        public ByteHolder(byte b) {
            super((DefaultConstructorMarker) null);
            this.value = b;
        }

        public final byte getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lkshark/ValueHolder$ShortHolder;", "Lkshark/ValueHolder;", "value", "", "(S)V", "getValue", "()S", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class ShortHolder extends ValueHolder {
        private final short value;

        public static /* synthetic */ ShortHolder copy$default(ShortHolder shortHolder, short s, int i, Object obj) {
            if ((i & 1) != 0) {
                s = shortHolder.value;
            }
            return shortHolder.copy(s);
        }

        public final short component1() {
            return this.value;
        }

        public final ShortHolder copy(short s) {
            return new ShortHolder(s);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ShortHolder) {
                    if (this.value == ((ShortHolder) obj).value) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "ShortHolder(value=" + this.value + ")";
        }

        public ShortHolder(short s) {
            super((DefaultConstructorMarker) null);
            this.value = s;
        }

        public final short getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lkshark/ValueHolder$IntHolder;", "Lkshark/ValueHolder;", "value", "", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class IntHolder extends ValueHolder {
        private final int value;

        public static /* synthetic */ IntHolder copy$default(IntHolder intHolder, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = intHolder.value;
            }
            return intHolder.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final IntHolder copy(int i) {
            return new IntHolder(i);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof IntHolder) {
                    if (this.value == ((IntHolder) obj).value) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "IntHolder(value=" + this.value + ")";
        }

        public IntHolder(int i) {
            super((DefaultConstructorMarker) null);
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lkshark/ValueHolder$LongHolder;", "Lkshark/ValueHolder;", "value", "", "(J)V", "getValue", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class LongHolder extends ValueHolder {
        private final long value;

        public static /* synthetic */ LongHolder copy$default(LongHolder longHolder, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = longHolder.value;
            }
            return longHolder.copy(j);
        }

        public final long component1() {
            return this.value;
        }

        public final LongHolder copy(long j) {
            return new LongHolder(j);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof LongHolder) {
                    if (this.value == ((LongHolder) obj).value) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.value;
            return (int) (j ^ (j >>> 32));
        }

        public String toString() {
            return "LongHolder(value=" + this.value + ")";
        }

        public LongHolder(long j) {
            super((DefaultConstructorMarker) null);
            this.value = j;
        }

        public final long getValue() {
            return this.value;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lkshark/ValueHolder$Companion;", "", "()V", "NULL_REFERENCE", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ValueHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
