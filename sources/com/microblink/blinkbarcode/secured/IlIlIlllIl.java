package com.microblink.blinkbarcode.secured;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: line */
class IlIlIlllIl {
    private final Map<IllIIlllIl, lIIllIIlIl> llIIlIlIIl;

    public IlIlIlllIl(List<llIIllllIl> list) {
        this.llIIlIlIIl = Collections.unmodifiableMap(llIIlIlIIl(list));
    }

    public boolean IlIllIlIIl() {
        if (this.llIIlIlIIl.isEmpty()) {
            return true;
        }
        for (lIIllIIlIl llIIIlllll : this.llIIlIlIIl.values()) {
            if (!llIIIlllll.llIIIlllll()) {
                return false;
            }
        }
        return true;
    }

    public Map<IllIIlllIl, lIIllIIlIl> llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    private static Map<IllIIlllIl, lIIllIIlIl> llIIlIlIIl(List<llIIllllIl> list) {
        HashMap hashMap = new HashMap();
        for (llIIllllIl next : list) {
            if (hashMap.containsKey(next.IlIllIlIIl())) {
                lIIllIIlIl liilliilil = (lIIllIIlIl) hashMap.get(next.IlIllIlIIl());
                lIIllIIlIl llIIlIlIIl2 = next.llIIlIlIIl();
                hashMap.put(next.IlIllIlIIl(), new lIIllIIlIl(liilliilil.llIIlIlIIl() + llIIlIlIIl2.llIIlIlIIl(), liilliilil.IllIIIllII() + llIIlIlIIl2.IllIIIllII(), liilliilil.IlIllIlIIl() + llIIlIlIIl2.IlIllIlIIl()));
            } else {
                hashMap.put(next.IlIllIlIIl(), next.llIIlIlIIl());
            }
        }
        return hashMap;
    }

    public static IlIlIlllIl IlIllIlIIl(List<IlIlIlllIl> list) {
        ArrayList arrayList = new ArrayList();
        for (IlIlIlllIl ilIlIlllIl : list) {
            for (Map.Entry next : ilIlIlllIl.llIIlIlIIl.entrySet()) {
                arrayList.add(new llIIllllIl((IllIIlllIl) next.getKey(), (lIIllIIlIl) next.getValue()));
            }
        }
        return new IlIlIlllIl(arrayList);
    }
}
