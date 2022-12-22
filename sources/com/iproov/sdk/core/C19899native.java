package com.iproov.sdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.iproov.sdk.logging.IPLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

/* renamed from: com.iproov.sdk.core.native */
/* compiled from: RootedDetector.kt */
public final class C19899native {

    /* renamed from: a */
    private final PackageManager f54325a;

    /* renamed from: b */
    private final List<String> f54326b = CollectionsKt.listOf(C19802catch.m38948ah(), C19802catch.m38949ai(), C19802catch.m38950aj(), C19802catch.m38951ak(), C19802catch.m38952al(), C19802catch.m38953am(), C19802catch.m38954an(), C19802catch.m38955ao(), C19802catch.m38956ap(), C19802catch.m38957aq(), C19802catch.m38958ar(), C19802catch.m38959as(), C19802catch.m38960at(), C19802catch.m38961au());

    /* renamed from: c */
    private final List<Pair<String, String>> f54327c = CollectionsKt.listOf(new Pair(C19802catch.m38919aE(), "1"), new Pair(C19802catch.m38920aF(), "0"));

    /* renamed from: d */
    private final List<String> f54328d = CollectionsKt.listOf(C19802catch.m39059u(), C19802catch.m39060v(), C19802catch.m39061w(), C19802catch.m39062x(), C19802catch.m39063y(), C19802catch.m39064z(), C19802catch.m38887A(), C19802catch.m38888B(), C19802catch.m38889C(), C19802catch.m38890D(), C19802catch.m38891E(), C19802catch.m38892F(), C19802catch.m38893G(), C19802catch.m38894H(), C19802catch.m38895I(), C19802catch.m38896J(), C19802catch.m38897K(), C19802catch.m38898L(), C19802catch.m38899M(), C19802catch.m38900N(), C19802catch.m38901O(), C19802catch.m38902P(), C19802catch.m38903Q(), C19802catch.m38904R(), C19802catch.m38905S(), C19802catch.m38906T(), C19802catch.m38907U(), C19802catch.m38908V(), C19802catch.m38909W(), C19802catch.m38910X(), C19802catch.m38911Y(), C19802catch.m38912Z(), C19802catch.m38941aa(), C19802catch.m38942ab(), C19802catch.m38943ac(), C19802catch.m38944ad(), C19802catch.m38945ae(), C19802catch.m38946af(), C19802catch.m38947ag());

    /* renamed from: e */
    private final List<String> f54329e = CollectionsKt.listOf(C19802catch.m38962av(), C19802catch.m38963aw(), C19802catch.m38964ax(), C19802catch.m38965ay(), C19802catch.m38966az(), C19802catch.m38915aA(), C19802catch.m38916aB());

    /* renamed from: f */
    private final int f54330f;

    /* renamed from: g */
    private final boolean f54331g;

    /* renamed from: h */
    private final int f54332h;

    public C19899native(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f54325a = context.getPackageManager();
        boolean z = false;
        int i = 4;
        int i2 = Build.VERSION.SDK_INT;
        this.f54330f = i2;
        z = i2 < 23 ? true : z;
        this.f54331g = z;
        this.f54332h = !z ? 6 : i;
    }

    /* renamed from: a */
    private final boolean m39230a() {
        List<String> list = this.f54326b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Intrinsics.checkNotNullExpressionValue(str, "path");
            String aC = C19802catch.m38917aC();
            Intrinsics.checkNotNullExpressionValue(aC, "getSu()");
            arrayList.add(Boolean.valueOf(C19901public.m39245do(str, aC)));
        }
        return C19901public.m39246do(arrayList);
    }

    /* renamed from: b */
    private final boolean m39233b() {
        List<String> list = this.f54326b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Intrinsics.checkNotNullExpressionValue(str, "path");
            String aG = C19802catch.m38921aG();
            Intrinsics.checkNotNullExpressionValue(aG, "getMagisk()");
            arrayList.add(Boolean.valueOf(C19901public.m39245do(str, aG)));
        }
        return C19901public.m39246do(arrayList);
    }

    /* renamed from: c */
    private final boolean m39234c() {
        String aH = C19802catch.m38922aH();
        Intrinsics.checkNotNullExpressionValue(aH, "getWhich()");
        String aC = C19802catch.m38917aC();
        Intrinsics.checkNotNullExpressionValue(aC, "getSu()");
        boolean z = false;
        String[] strArr = C19901public.m39247do(aH, new String[]{aC});
        if (strArr == null) {
            return false;
        }
        if (strArr.length == 0) {
            z = true;
        }
        return !z;
    }

    /* renamed from: d */
    private final boolean m39235d() {
        String str = Build.TAGS;
        if (str == null) {
            return false;
        }
        String aD = C19802catch.m38918aD();
        Intrinsics.checkNotNullExpressionValue(aD, "getTestKeys()");
        return StringsKt.contains$default((CharSequence) str, (CharSequence) aD, false, 2, (Object) null);
    }

    /* renamed from: e */
    private final boolean m39236e() {
        boolean z;
        String aI = C19802catch.m38923aI();
        Intrinsics.checkNotNullExpressionValue(aI, "getGetprop()");
        String[] strArr = C19901public.m39248do(aI, (String[]) null, 1, (Object) null);
        if (strArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            List<Pair<String, String>> list = this.f54327c;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Pair pair : list) {
                Object first = pair.getFirst();
                Intrinsics.checkNotNullExpressionValue(first, "pair.first");
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) first, false, 2, (Object) null)) {
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) VersionRange.LEFT_CLOSED + ((String) pair.getSecond()) + VersionRange.RIGHT_CLOSED, false, 2, (Object) null)) {
                        z = true;
                        arrayList2.add(Boolean.valueOf(z));
                    }
                }
                z = false;
                arrayList2.add(Boolean.valueOf(z));
            }
            arrayList.add(Boolean.valueOf(C19901public.m39246do(arrayList2)));
        }
        return C19901public.m39246do(arrayList);
    }

    /* renamed from: f */
    private final boolean m39237f() {
        String aJ = C19802catch.m38924aJ();
        Intrinsics.checkNotNullExpressionValue(aJ, "getMount()");
        String[] strArr = C19901public.m39248do(aJ, (String[]) null, 1, (Object) null);
        if (strArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            arrayList.add(StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null));
        }
        ArrayList<List> arrayList2 = new ArrayList<>();
        for (Object next : arrayList) {
            if (((List) next).size() >= this.f54332h) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (List list : arrayList2) {
            List<String> list2 = this.f54329e;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str2 : list2) {
                Intrinsics.checkNotNullExpressionValue(str2, "path");
                arrayList4.add(Boolean.valueOf(m39232a(str2, list)));
            }
            arrayList3.add(Boolean.valueOf(C19901public.m39246do(arrayList4)));
        }
        return C19901public.m39246do(arrayList3);
    }

    /* renamed from: g */
    private final boolean m39238g() {
        List<String> list = this.f54328d;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            arrayList.add(Boolean.valueOf(m39231a(str)));
        }
        return C19901public.m39246do(arrayList);
    }

    /* renamed from: h */
    private final boolean m39239h() {
        if (!NativeLibraryLoader.f54084a) {
            return true;
        }
        List<String> list = this.f54326b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String stringPlus : list) {
            arrayList.add(Intrinsics.stringPlus(stringPlus, C19802catch.m38917aC()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            try {
                if (new NativeLibraryLoader().suNativeCheck((String[]) array) > 0) {
                    return true;
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                IPLog.m39305w("NativeLib", "Not loaded");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    /* renamed from: this  reason: not valid java name */
    public final boolean m47536this() {
        return m39230a() || m39234c() || m39235d() || m39236e() || m39237f() || m39233b() || m39238g() || m39239h();
    }

    /* renamed from: a */
    private final boolean m39232a(String str, List<String> list) {
        List<String> list2 = list;
        String str2 = this.f54331g ? list2.get(1) : list2.get(2);
        String str3 = list2.get(this.f54331g ? 3 : 5);
        if (!StringsKt.equals(str2, str, true)) {
            return false;
        }
        if (!this.f54331g) {
            str3 = StringsKt.replace$default(StringsKt.replace$default(str3, "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null);
        }
        List<String> split$default = StringsKt.split$default((CharSequence) str3, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String equals : split$default) {
            arrayList.add(Boolean.valueOf(StringsKt.equals(equals, C19802catch.m38925aK(), true)));
        }
        return C19901public.m39246do(arrayList);
    }

    /* renamed from: a */
    private final boolean m39231a(String str) {
        try {
            SystemUtils.getPackageInfo(this.f54325a, str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
