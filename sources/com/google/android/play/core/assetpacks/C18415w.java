package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.w */
interface C18415w {
    /* renamed from: a */
    Task<AssetPackStates> mo148888a(List<String> list, C18316az azVar, Map<String, Long> map);

    /* renamed from: a */
    Task<AssetPackStates> mo148889a(List<String> list, List<String> list2, Map<String, Long> map);

    /* renamed from: a */
    Task<List<String>> mo148890a(Map<String, Long> map);

    /* renamed from: a */
    void mo148891a();

    /* renamed from: a */
    void mo148892a(int i);

    /* renamed from: a */
    void mo148893a(int i, String str);

    /* renamed from: a */
    void mo148894a(int i, String str, String str2, int i2);

    /* renamed from: a */
    void mo148895a(String str);

    /* renamed from: a */
    void mo148896a(List<String> list);

    /* renamed from: b */
    Task<ParcelFileDescriptor> mo148897b(int i, String str, String str2, int i2);
}
