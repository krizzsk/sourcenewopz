package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AssetPackStates {
    /* renamed from: a */
    public static AssetPackStates m37429a(long j, Map<String, AssetPackState> map) {
        return new C18326bi(j, map);
    }

    /* renamed from: a */
    public static AssetPackStates m37430a(Bundle bundle, C18343bz bzVar) {
        return m37432a(bundle, bzVar, (List<String>) new ArrayList());
    }

    /* renamed from: a */
    public static AssetPackStates m37431a(Bundle bundle, C18343bz bzVar, C18316az azVar) {
        return m37433a(bundle, bzVar, new ArrayList(), azVar);
    }

    /* renamed from: a */
    public static AssetPackStates m37432a(Bundle bundle, C18343bz bzVar, List<String> list) {
        return m37433a(bundle, bzVar, list, C18318ba.f52794a);
    }

    /* renamed from: a */
    private static AssetPackStates m37433a(Bundle bundle, C18343bz bzVar, List<String> list, C18316az azVar) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.m37426a(bundle, str, bzVar, azVar));
        }
        for (String next : list) {
            hashMap.put(next, AssetPackState.m37427a(next, 4, 0, 0, 0, 0.0d, 1));
        }
        return m37429a(bundle.getLong("total_bytes_to_download"), (Map<String, AssetPackState>) hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}
