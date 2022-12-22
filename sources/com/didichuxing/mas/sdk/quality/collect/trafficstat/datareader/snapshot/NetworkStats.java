package com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class NetworkStats implements Parcelable {
    public static final Parcelable.Creator<NetworkStats> CREATOR = new Parcelable.Creator<NetworkStats>() {
        public NetworkStats createFromParcel(Parcel parcel) {
            return new NetworkStats(parcel);
        }

        public NetworkStats[] newArray(int i) {
            return new NetworkStats[i];
        }
    };
    public static final int DEFAULT_NETWORK_ALL = -1;
    public static final int DEFAULT_NETWORK_NO = 0;
    public static final int DEFAULT_NETWORK_YES = 1;
    public static final String IFACE_ALL = null;
    public static final int METERED_ALL = -1;
    public static final int METERED_NO = 0;
    public static final int METERED_YES = 1;
    public static final int ROAMING_ALL = -1;
    public static final int ROAMING_NO = 0;
    public static final int ROAMING_YES = 1;
    public static final int SET_ALL = -1;
    public static final int SET_DBG_VPN_IN = 1001;
    public static final int SET_DBG_VPN_OUT = 1002;
    public static final int SET_DEBUG_START = 1000;
    public static final int SET_DEFAULT = 0;
    public static final int SET_FOREGROUND = 1;
    public static final int STATS_PER_IFACE = 0;
    public static final int STATS_PER_UID = 1;
    public static final int TAG_ALL = -1;
    public static final int TAG_NONE = 0;
    public static final int UID_ALL = -1;

    /* renamed from: a */
    private long f48221a;

    /* renamed from: b */
    private int f48222b;

    /* renamed from: c */
    private int f48223c;

    /* renamed from: d */
    private String[] f48224d;

    /* renamed from: e */
    private int[] f48225e;

    /* renamed from: f */
    private int[] f48226f;

    /* renamed from: g */
    private int[] f48227g;

    /* renamed from: h */
    private int[] f48228h;

    /* renamed from: i */
    private int[] f48229i;

    /* renamed from: j */
    private int[] f48230j;

    /* renamed from: k */
    private long[] f48231k;

    /* renamed from: l */
    private long[] f48232l;

    /* renamed from: m */
    private long[] f48233m;

    /* renamed from: n */
    private long[] f48234n;

    /* renamed from: o */
    private long[] f48235o;

    public interface NonMonotonicObserver<C> {
        void foundNonMonotonic(NetworkStats networkStats, int i, NetworkStats networkStats2, int i2, C c);
    }

    public static String defaultNetworkToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "UNKNOWN" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK : DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK : "ALL";
    }

    public static String meteredToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "UNKNOWN" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK : DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK : "ALL";
    }

    public static String roamingToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "UNKNOWN" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK : DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK : "ALL";
    }

    public static boolean setMatches(int i, int i2) {
        if (i == i2) {
            return true;
        }
        return i == -1 && i2 < 1000;
    }

    public static String setToCheckinString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 1001 ? i != 1002 ? "unk" : "vpnout" : "vpnin" : "fg" : "def" : "all";
    }

    public static String setToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 1001 ? i != 1002 ? "UNKNOWN" : "DBG_VPN_OUT" : "DBG_VPN_IN" : "FOREGROUND" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT : "ALL";
    }

    public int describeContents() {
        return 0;
    }

    public static class Entry {
        public int defaultNetwork;
        public String iface;
        public int metered;
        public long operations;
        public int roaming;
        public long rxBytes;
        public long rxPackets;
        public int set;
        public int tag;
        public long txBytes;
        public long txPackets;
        public int uid;

        public Entry() {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, 0, 0, 0, 0, 0);
        }

        public Entry(long j, long j2, long j3, long j4, long j5) {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, j, j2, j3, j4, j5);
        }

        public Entry(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
            this(str, i, i2, i3, 0, 0, 0, j, j2, j3, j4, j5);
        }

        public Entry(String str, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, long j4, long j5) {
            this.iface = str;
            this.uid = i;
            this.set = i2;
            this.tag = i3;
            this.metered = i4;
            this.roaming = i5;
            this.defaultNetwork = i6;
            this.rxBytes = j;
            this.rxPackets = j2;
            this.txBytes = j3;
            this.txPackets = j4;
            this.operations = j5;
        }

        public boolean isNegative() {
            return this.rxBytes < 0 || this.rxPackets < 0 || this.txBytes < 0 || this.txPackets < 0 || this.operations < 0;
        }

        public boolean isEmpty() {
            return this.rxBytes == 0 && this.rxPackets == 0 && this.txBytes == 0 && this.txPackets == 0 && this.operations == 0;
        }

        public void add(Entry entry) {
            this.rxBytes += entry.rxBytes;
            this.rxPackets += entry.rxPackets;
            this.txBytes += entry.txBytes;
            this.txPackets += entry.txPackets;
            this.operations += entry.operations;
        }

        public String toString() {
            return "iface=" + this.iface + " uid=" + this.uid + " set=" + NetworkStats.setToString(this.set) + " tag=" + NetworkStats.tagToString(this.tag) + " metered=" + NetworkStats.meteredToString(this.metered) + " roaming=" + NetworkStats.roamingToString(this.roaming) + " defaultNetwork=" + NetworkStats.defaultNetworkToString(this.defaultNetwork) + " rxBytes=" + this.rxBytes + " rxPackets=" + this.rxPackets + " txBytes=" + this.txBytes + " txPackets=" + this.txPackets + " operations=" + this.operations;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.uid == entry.uid && this.set == entry.set && this.tag == entry.tag && this.metered == entry.metered && this.roaming == entry.roaming && this.defaultNetwork == entry.defaultNetwork && this.rxBytes == entry.rxBytes && this.rxPackets == entry.rxPackets && this.txBytes == entry.txBytes && this.txPackets == entry.txPackets && this.operations == entry.operations && this.iface.equals(entry.iface)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ArrayUtils.hash(Integer.valueOf(this.uid), Integer.valueOf(this.set), Integer.valueOf(this.tag), Integer.valueOf(this.metered), Integer.valueOf(this.roaming), Integer.valueOf(this.defaultNetwork), this.iface);
        }
    }

    public NetworkStats(long j, int i) {
        this.f48221a = j;
        this.f48222b = 0;
        if (i >= 0) {
            this.f48223c = i;
            this.f48224d = new String[i];
            this.f48225e = new int[i];
            this.f48226f = new int[i];
            this.f48227g = new int[i];
            this.f48228h = new int[i];
            this.f48229i = new int[i];
            this.f48230j = new int[i];
            this.f48231k = new long[i];
            this.f48232l = new long[i];
            this.f48233m = new long[i];
            this.f48234n = new long[i];
            this.f48235o = new long[i];
            return;
        }
        this.f48223c = 0;
        this.f48224d = ArrayUtils.STRING;
        this.f48225e = ArrayUtils.INT;
        this.f48226f = ArrayUtils.INT;
        this.f48227g = ArrayUtils.INT;
        this.f48228h = ArrayUtils.INT;
        this.f48229i = ArrayUtils.INT;
        this.f48230j = ArrayUtils.INT;
        this.f48231k = ArrayUtils.LONG;
        this.f48232l = ArrayUtils.LONG;
        this.f48233m = ArrayUtils.LONG;
        this.f48234n = ArrayUtils.LONG;
        this.f48235o = ArrayUtils.LONG;
    }

    public NetworkStats(Parcel parcel) {
        this.f48221a = parcel.readLong();
        this.f48222b = parcel.readInt();
        this.f48223c = parcel.readInt();
        this.f48224d = parcel.createStringArray();
        this.f48225e = parcel.createIntArray();
        this.f48226f = parcel.createIntArray();
        this.f48227g = parcel.createIntArray();
        this.f48228h = parcel.createIntArray();
        this.f48229i = parcel.createIntArray();
        this.f48230j = parcel.createIntArray();
        this.f48231k = parcel.createLongArray();
        this.f48232l = parcel.createLongArray();
        this.f48233m = parcel.createLongArray();
        this.f48234n = parcel.createLongArray();
        this.f48235o = parcel.createLongArray();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f48221a);
        parcel.writeInt(this.f48222b);
        parcel.writeInt(this.f48223c);
        parcel.writeStringArray(this.f48224d);
        parcel.writeIntArray(this.f48225e);
        parcel.writeIntArray(this.f48226f);
        parcel.writeIntArray(this.f48227g);
        parcel.writeIntArray(this.f48228h);
        parcel.writeIntArray(this.f48229i);
        parcel.writeIntArray(this.f48230j);
        parcel.writeLongArray(this.f48231k);
        parcel.writeLongArray(this.f48232l);
        parcel.writeLongArray(this.f48233m);
        parcel.writeLongArray(this.f48234n);
        parcel.writeLongArray(this.f48235o);
    }

    public NetworkStats clone() {
        NetworkStats networkStats = new NetworkStats(this.f48221a, this.f48222b);
        Entry entry = null;
        for (int i = 0; i < this.f48222b; i++) {
            entry = getValues(i, entry);
            networkStats.addValues(entry);
        }
        return networkStats;
    }

    public NetworkStats addIfaceValues(String str, long j, long j2, long j3, long j4) {
        return addValues(str, -1, 0, 0, j, j2, j3, j4, 0);
    }

    public NetworkStats addValues(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
        return addValues(new Entry(str, i, i2, i3, j, j2, j3, j4, j5));
    }

    public NetworkStats addValues(String str, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, long j4, long j5) {
        Entry entry = r0;
        Entry entry2 = new Entry(str, i, i2, i3, i4, i5, i6, j, j2, j3, j4, j5);
        return addValues(entry);
    }

    public NetworkStats addValues(Entry entry) {
        int i = this.f48222b;
        if (i >= this.f48223c) {
            int max = (Math.max(i, 10) * 3) / 2;
            this.f48224d = (String[]) Arrays.copyOf(this.f48224d, max);
            this.f48225e = Arrays.copyOf(this.f48225e, max);
            this.f48226f = Arrays.copyOf(this.f48226f, max);
            this.f48227g = Arrays.copyOf(this.f48227g, max);
            this.f48228h = Arrays.copyOf(this.f48228h, max);
            this.f48229i = Arrays.copyOf(this.f48229i, max);
            this.f48230j = Arrays.copyOf(this.f48230j, max);
            this.f48231k = Arrays.copyOf(this.f48231k, max);
            this.f48232l = Arrays.copyOf(this.f48232l, max);
            this.f48233m = Arrays.copyOf(this.f48233m, max);
            this.f48234n = Arrays.copyOf(this.f48234n, max);
            this.f48235o = Arrays.copyOf(this.f48235o, max);
            this.f48223c = max;
        }
        this.f48224d[this.f48222b] = entry.iface;
        this.f48225e[this.f48222b] = entry.uid;
        this.f48226f[this.f48222b] = entry.set;
        this.f48227g[this.f48222b] = entry.tag;
        this.f48228h[this.f48222b] = entry.metered;
        this.f48229i[this.f48222b] = entry.roaming;
        this.f48230j[this.f48222b] = entry.defaultNetwork;
        this.f48231k[this.f48222b] = entry.rxBytes;
        this.f48232l[this.f48222b] = entry.rxPackets;
        this.f48233m[this.f48222b] = entry.txBytes;
        this.f48234n[this.f48222b] = entry.txPackets;
        this.f48235o[this.f48222b] = entry.operations;
        this.f48222b++;
        return this;
    }

    public Entry getValues(int i, Entry entry) {
        if (entry == null) {
            entry = new Entry();
        }
        entry.iface = this.f48224d[i];
        entry.uid = this.f48225e[i];
        entry.set = this.f48226f[i];
        entry.tag = this.f48227g[i];
        entry.metered = this.f48228h[i];
        entry.roaming = this.f48229i[i];
        entry.defaultNetwork = this.f48230j[i];
        entry.rxBytes = this.f48231k[i];
        entry.rxPackets = this.f48232l[i];
        entry.txBytes = this.f48233m[i];
        entry.txPackets = this.f48234n[i];
        entry.operations = this.f48235o[i];
        return entry;
    }

    public long getElapsedRealtime() {
        return this.f48221a;
    }

    public void setElapsedRealtime(long j) {
        this.f48221a = j;
    }

    public long getElapsedRealtimeAge() {
        return SystemClock.elapsedRealtime() - this.f48221a;
    }

    public int size() {
        return this.f48222b;
    }

    public int internalSize() {
        return this.f48223c;
    }

    @Deprecated
    public NetworkStats combineValues(String str, int i, int i2, long j, long j2, long j3, long j4, long j5) {
        return combineValues(str, i, 0, i2, j, j2, j3, j4, j5);
    }

    public NetworkStats combineValues(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
        return combineValues(new Entry(str, i, i2, i3, j, j2, j3, j4, j5));
    }

    public NetworkStats combineValues(Entry entry) {
        int findIndex = findIndex(entry.iface, entry.uid, entry.set, entry.tag, entry.metered, entry.roaming, entry.defaultNetwork);
        if (findIndex == -1) {
            addValues(entry);
        } else {
            long[] jArr = this.f48231k;
            jArr[findIndex] = jArr[findIndex] + entry.rxBytes;
            long[] jArr2 = this.f48232l;
            jArr2[findIndex] = jArr2[findIndex] + entry.rxPackets;
            long[] jArr3 = this.f48233m;
            jArr3[findIndex] = jArr3[findIndex] + entry.txBytes;
            long[] jArr4 = this.f48234n;
            jArr4[findIndex] = jArr4[findIndex] + entry.txPackets;
            long[] jArr5 = this.f48235o;
            jArr5[findIndex] = jArr5[findIndex] + entry.operations;
        }
        return this;
    }

    public void combineAllValues(NetworkStats networkStats) {
        Entry entry = null;
        for (int i = 0; i < networkStats.f48222b; i++) {
            entry = networkStats.getValues(i, entry);
            combineValues(entry);
        }
    }

    public int findIndex(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < this.f48222b; i7++) {
            if (i == this.f48225e[i7] && i2 == this.f48226f[i7] && i3 == this.f48227g[i7] && i4 == this.f48228h[i7] && i5 == this.f48229i[i7] && i6 == this.f48230j[i7] && ArrayUtils.equals(str, this.f48224d[i7])) {
                return i7;
            }
        }
        return -1;
    }

    public int findIndexHinted(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9 = 0;
        while (true) {
            int i10 = this.f48222b;
            if (i9 >= i10) {
                return -1;
            }
            int i11 = i9 / 2;
            if (i9 % 2 == 0) {
                i8 = (i11 + i7) % i10;
            } else {
                i8 = (((i10 + i7) - i11) - 1) % i10;
            }
            if (i == this.f48225e[i8] && i2 == this.f48226f[i8] && i3 == this.f48227g[i8] && i4 == this.f48228h[i8] && i5 == this.f48229i[i8] && i6 == this.f48230j[i8] && ArrayUtils.equals(str, this.f48224d[i8])) {
                return i8;
            }
            i9++;
        }
    }

    public void spliceOperationsFrom(NetworkStats networkStats) {
        for (int i = 0; i < this.f48222b; i++) {
            int findIndex = networkStats.findIndex(this.f48224d[i], this.f48225e[i], this.f48226f[i], this.f48227g[i], this.f48228h[i], this.f48229i[i], this.f48230j[i]);
            if (findIndex == -1) {
                this.f48235o[i] = 0;
            } else {
                this.f48235o[i] = networkStats.f48235o[findIndex];
            }
        }
    }

    public String[] getUniqueIfaces() {
        HashSet hashSet = new HashSet();
        for (String str : this.f48224d) {
            if (str != IFACE_ALL) {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public int[] getUniqueUids() {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int put : this.f48225e) {
            sparseBooleanArray.put(put, true);
        }
        int size = sparseBooleanArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = sparseBooleanArray.keyAt(i);
        }
        return iArr;
    }

    public int[] getUniqueTags() {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int put : this.f48227g) {
            sparseBooleanArray.put(put, true);
        }
        int size = sparseBooleanArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = sparseBooleanArray.keyAt(i);
        }
        return iArr;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.f48222b; i++) {
            if (this.f48231k[i] > 0 || this.f48232l[i] > 0 || this.f48233m[i] > 0 || this.f48234n[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public long getTotalBytes() {
        Entry total = getTotal((Entry) null);
        return total.rxBytes + total.txBytes;
    }

    public Entry getTotal(Entry entry) {
        return m34377a(entry, (HashSet<String>) null, -1, false);
    }

    public Entry getTotal(Entry entry, int i) {
        return m34377a(entry, (HashSet<String>) null, i, false);
    }

    public Entry getTotal(Entry entry, HashSet<String> hashSet) {
        return m34377a(entry, hashSet, -1, false);
    }

    public Entry getTotalIncludingTags(Entry entry) {
        return m34377a(entry, (HashSet<String>) null, -1, true);
    }

    /* renamed from: a */
    private Entry m34377a(Entry entry, HashSet<String> hashSet, int i, boolean z) {
        if (entry == null) {
            entry = new Entry();
        }
        entry.iface = IFACE_ALL;
        entry.uid = i;
        entry.set = -1;
        entry.tag = 0;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        entry.rxBytes = 0;
        entry.rxPackets = 0;
        entry.txBytes = 0;
        entry.txPackets = 0;
        entry.operations = 0;
        for (int i2 = 0; i2 < this.f48222b; i2++) {
            boolean z2 = true;
            boolean z3 = i == -1 || i == this.f48225e[i2];
            if (hashSet != null && !hashSet.contains(this.f48224d[i2])) {
                z2 = false;
            }
            if (z3 && z2 && (this.f48227g[i2] == 0 || z)) {
                entry.rxBytes += this.f48231k[i2];
                entry.rxPackets += this.f48232l[i2];
                entry.txBytes += this.f48233m[i2];
                entry.txPackets += this.f48234n[i2];
                entry.operations += this.f48235o[i2];
            }
        }
        return entry;
    }

    public long getTotalPackets() {
        long j = 0;
        for (int i = this.f48222b - 1; i >= 0; i--) {
            j += this.f48232l[i] + this.f48234n[i];
        }
        return j;
    }

    public NetworkStats subtract(NetworkStats networkStats) {
        return subtract(this, networkStats, (NonMonotonicObserver) null, (Object) null);
    }

    public static <C> NetworkStats subtract(NetworkStats networkStats, NetworkStats networkStats2, NonMonotonicObserver<C> nonMonotonicObserver, C c) {
        return subtract(networkStats, networkStats2, nonMonotonicObserver, c, (NetworkStats) null);
    }

    public static <C> NetworkStats subtract(NetworkStats networkStats, NetworkStats networkStats2, NonMonotonicObserver<C> nonMonotonicObserver, C c, NetworkStats networkStats3) {
        NetworkStats networkStats4;
        NetworkStats networkStats5;
        int i;
        Entry entry;
        long j;
        NetworkStats networkStats6 = networkStats;
        NetworkStats networkStats7 = networkStats2;
        NetworkStats networkStats8 = networkStats3;
        long j2 = networkStats6.f48221a - networkStats7.f48221a;
        if (j2 < 0) {
            if (nonMonotonicObserver != null) {
                nonMonotonicObserver.foundNonMonotonic(networkStats, -1, networkStats2, -1, c);
            }
            j2 = 0;
        }
        Entry entry2 = new Entry();
        if (networkStats8 == null || networkStats8.f48223c < networkStats6.f48222b) {
            networkStats4 = new NetworkStats(j2, networkStats6.f48222b);
        } else {
            networkStats8.f48222b = 0;
            networkStats8.f48221a = j2;
            networkStats4 = networkStats8;
        }
        int i2 = 0;
        while (i2 < networkStats6.f48222b) {
            entry2.iface = networkStats6.f48224d[i2];
            entry2.uid = networkStats6.f48225e[i2];
            entry2.set = networkStats6.f48226f[i2];
            entry2.tag = networkStats6.f48227g[i2];
            entry2.metered = networkStats6.f48228h[i2];
            entry2.roaming = networkStats6.f48229i[i2];
            entry2.defaultNetwork = networkStats6.f48230j[i2];
            entry2.rxBytes = networkStats6.f48231k[i2];
            entry2.rxPackets = networkStats6.f48232l[i2];
            entry2.txBytes = networkStats6.f48233m[i2];
            entry2.txPackets = networkStats6.f48234n[i2];
            entry2.operations = networkStats6.f48235o[i2];
            NetworkStats networkStats9 = networkStats7;
            int findIndexHinted = networkStats2.findIndexHinted(entry2.iface, entry2.uid, entry2.set, entry2.tag, entry2.metered, entry2.roaming, entry2.defaultNetwork, i2);
            if (findIndexHinted != -1) {
                entry2.rxBytes -= networkStats9.f48231k[findIndexHinted];
                entry2.rxPackets -= networkStats9.f48232l[findIndexHinted];
                entry2.txBytes -= networkStats9.f48233m[findIndexHinted];
                entry2.txPackets -= networkStats9.f48234n[findIndexHinted];
                entry2.operations -= networkStats9.f48235o[findIndexHinted];
            }
            if (entry2.isNegative()) {
                if (nonMonotonicObserver != null) {
                    i = i2;
                    networkStats5 = networkStats4;
                    int i3 = findIndexHinted;
                    entry = entry2;
                    nonMonotonicObserver.foundNonMonotonic(networkStats, i2, networkStats2, i3, c);
                } else {
                    i = i2;
                    networkStats5 = networkStats4;
                    entry = entry2;
                }
                j = 0;
                entry.rxBytes = Math.max(entry.rxBytes, 0);
                entry.rxPackets = Math.max(entry.rxPackets, 0);
                entry.txBytes = Math.max(entry.txBytes, 0);
                entry.txPackets = Math.max(entry.txPackets, 0);
                entry.operations = Math.max(entry.operations, 0);
            } else {
                i = i2;
                networkStats5 = networkStats4;
                entry = entry2;
                j = 0;
            }
            networkStats5.addValues(entry);
            networkStats7 = networkStats2;
            long j3 = j;
            entry2 = entry;
            networkStats4 = networkStats5;
            i2 = i + 1;
        }
        return networkStats4;
    }

    public NetworkStats groupedByIface() {
        NetworkStats networkStats = new NetworkStats(this.f48221a, 10);
        Entry entry = new Entry();
        entry.uid = -1;
        entry.set = -1;
        entry.tag = 0;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        entry.operations = 0;
        for (int i = 0; i < this.f48222b; i++) {
            if (this.f48227g[i] == 0) {
                entry.iface = this.f48224d[i];
                entry.rxBytes = this.f48231k[i];
                entry.rxPackets = this.f48232l[i];
                entry.txBytes = this.f48233m[i];
                entry.txPackets = this.f48234n[i];
                networkStats.combineValues(entry);
            }
        }
        return networkStats;
    }

    public NetworkStats groupedByUid() {
        NetworkStats networkStats = new NetworkStats(this.f48221a, 10);
        Entry entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.set = -1;
        entry.tag = 0;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        for (int i = 0; i < this.f48222b; i++) {
            if (this.f48227g[i] == 0) {
                entry.uid = this.f48225e[i];
                entry.rxBytes = this.f48231k[i];
                entry.rxPackets = this.f48232l[i];
                entry.txBytes = this.f48233m[i];
                entry.txPackets = this.f48234n[i];
                entry.operations = this.f48235o[i];
                networkStats.combineValues(entry);
            }
        }
        return networkStats;
    }

    public NetworkStats withoutUids(int[] iArr) {
        NetworkStats networkStats = new NetworkStats(this.f48221a, 10);
        Entry entry = new Entry();
        for (int i = 0; i < this.f48222b; i++) {
            entry = getValues(i, entry);
            if (!ArrayUtils.contains(iArr, entry.uid)) {
                networkStats.addValues(entry);
            }
        }
        return networkStats;
    }

    public void dump(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("NetworkStats: elapsedRealtime=");
        printWriter.println(this.f48221a);
        for (int i = 0; i < this.f48222b; i++) {
            printWriter.print(str);
            printWriter.print("  [");
            printWriter.print(i);
            printWriter.print(Const.jaRight);
            printWriter.print(" iface=");
            printWriter.print(this.f48224d[i]);
            printWriter.print(" uid=");
            printWriter.print(this.f48225e[i]);
            printWriter.print(" set=");
            printWriter.print(setToString(this.f48226f[i]));
            printWriter.print(" tag=");
            printWriter.print(tagToString(this.f48227g[i]));
            printWriter.print(" metered=");
            printWriter.print(meteredToString(this.f48228h[i]));
            printWriter.print(" roaming=");
            printWriter.print(roamingToString(this.f48229i[i]));
            printWriter.print(" defaultNetwork=");
            printWriter.print(defaultNetworkToString(this.f48230j[i]));
            printWriter.print(" rxBytes=");
            printWriter.print(this.f48231k[i]);
            printWriter.print(" rxPackets=");
            printWriter.print(this.f48232l[i]);
            printWriter.print(" txBytes=");
            printWriter.print(this.f48233m[i]);
            printWriter.print(" txPackets=");
            printWriter.print(this.f48234n[i]);
            printWriter.print(" operations=");
            printWriter.println(this.f48235o[i]);
        }
    }

    public static String tagToString(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static int kernelToTag(String str) {
        int length = str.length();
        if (length > 10) {
            return Long.decode(str.substring(0, length - 8)).intValue();
        }
        return 0;
    }

    public String toString() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        dump("", new PrintWriter(charArrayWriter));
        return charArrayWriter.toString();
    }

    public boolean migrateTun(int i, String str, String str2) {
        Entry entry = new Entry();
        Entry entry2 = new Entry();
        m34380a(i, str, str2, entry, entry2);
        Entry a = m34376a(entry, entry2);
        if (a.isEmpty()) {
            return true;
        }
        Entry b = m34381b(i, str, str2, entry, a);
        m34379a(i, str2, b);
        return b.isEmpty();
    }

    /* renamed from: a */
    private void m34380a(int i, String str, String str2, Entry entry, Entry entry2) {
        Entry entry3 = new Entry();
        int i2 = 0;
        while (i2 < this.f48222b) {
            getValues(i2, entry3);
            if (entry3.uid == -1) {
                throw new IllegalStateException("Cannot adjust VPN accounting on an iface aggregated NetworkStats.");
            } else if (entry3.set == 1001 || entry3.set == 1002) {
                throw new IllegalStateException("Cannot adjust VPN accounting on a NetworkStats containing SET_DBG_VPN_*");
            } else {
                if (entry3.uid == i && entry3.tag == 0 && ArrayUtils.equals(str2, entry3.iface)) {
                    entry2.add(entry3);
                }
                if (entry3.uid != i && entry3.tag == 0 && ArrayUtils.equals(str, entry3.iface)) {
                    entry.add(entry3);
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    private static Entry m34376a(Entry entry, Entry entry2) {
        Entry entry3 = new Entry();
        entry3.rxBytes = Math.min(entry.rxBytes, entry2.rxBytes);
        entry3.rxPackets = Math.min(entry.rxPackets, entry2.rxPackets);
        entry3.txBytes = Math.min(entry.txBytes, entry2.txBytes);
        entry3.txPackets = Math.min(entry.txPackets, entry2.txPackets);
        entry3.operations = Math.min(entry.operations, entry2.operations);
        return entry3;
    }

    /* renamed from: b */
    private Entry m34381b(int i, String str, String str2, Entry entry, Entry entry2) {
        Entry entry3 = new Entry();
        Entry entry4 = new Entry();
        entry4.iface = str2;
        for (int i2 = 0; i2 < this.f48222b; i2++) {
            if (ArrayUtils.equals(this.f48224d[i2], str) && this.f48225e[i2] != i) {
                if (entry.rxBytes > 0) {
                    entry4.rxBytes = (entry2.rxBytes * this.f48231k[i2]) / entry.rxBytes;
                } else {
                    entry4.rxBytes = 0;
                }
                if (entry.rxPackets > 0) {
                    entry4.rxPackets = (entry2.rxPackets * this.f48232l[i2]) / entry.rxPackets;
                } else {
                    entry4.rxPackets = 0;
                }
                if (entry.txBytes > 0) {
                    entry4.txBytes = (entry2.txBytes * this.f48233m[i2]) / entry.txBytes;
                } else {
                    entry4.txBytes = 0;
                }
                if (entry.txPackets > 0) {
                    entry4.txPackets = (entry2.txPackets * this.f48234n[i2]) / entry.txPackets;
                } else {
                    entry4.txPackets = 0;
                }
                if (entry.operations > 0) {
                    entry4.operations = (entry2.operations * this.f48235o[i2]) / entry.operations;
                } else {
                    entry4.operations = 0;
                }
                entry4.uid = this.f48225e[i2];
                entry4.tag = this.f48227g[i2];
                entry4.set = this.f48226f[i2];
                entry4.metered = this.f48228h[i2];
                entry4.roaming = this.f48229i[i2];
                entry4.defaultNetwork = this.f48230j[i2];
                combineValues(entry4);
                if (this.f48227g[i2] == 0) {
                    entry3.add(entry4);
                    entry4.set = 1001;
                    combineValues(entry4);
                }
            }
        }
        return entry3;
    }

    /* renamed from: a */
    private void m34379a(int i, String str, Entry entry) {
        entry.uid = i;
        entry.set = 1002;
        entry.tag = 0;
        entry.iface = str;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        combineValues(entry);
        int findIndex = findIndex(str, i, 0, 0, 0, 0, 0);
        if (findIndex != -1) {
            m34378a(findIndex, this, entry);
        }
        int findIndex2 = findIndex(str, i, 1, 0, 0, 0, 0);
        if (findIndex2 != -1) {
            m34378a(findIndex2, this, entry);
        }
    }

    /* renamed from: a */
    private static void m34378a(int i, NetworkStats networkStats, Entry entry) {
        long min = Math.min(networkStats.f48231k[i], entry.rxBytes);
        long[] jArr = networkStats.f48231k;
        jArr[i] = jArr[i] - min;
        entry.rxBytes -= min;
        long min2 = Math.min(networkStats.f48232l[i], entry.rxPackets);
        long[] jArr2 = networkStats.f48232l;
        jArr2[i] = jArr2[i] - min2;
        entry.rxPackets -= min2;
        long min3 = Math.min(networkStats.f48233m[i], entry.txBytes);
        long[] jArr3 = networkStats.f48233m;
        jArr3[i] = jArr3[i] - min3;
        entry.txBytes -= min3;
        long min4 = Math.min(networkStats.f48234n[i], entry.txPackets);
        long[] jArr4 = networkStats.f48234n;
        jArr4[i] = jArr4[i] - min4;
        entry.txPackets -= min4;
    }
}
