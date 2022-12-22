package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C18619i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.aq */
final class C18307aq extends C18301ak<AssetPackStates> {

    /* renamed from: c */
    private final List<String> f52753c;

    /* renamed from: d */
    private final C18343bz f52754d;

    C18307aq(C18308ar arVar, C18619i<AssetPackStates> iVar, C18343bz bzVar, List<String> list) {
        super(arVar, iVar);
        this.f52754d = bzVar;
        this.f52753c = list;
    }

    /* renamed from: a */
    public final void mo148877a(int i, Bundle bundle) {
        super.mo148877a(i, bundle);
        this.f52743a.mo149342b(AssetPackStates.m37432a(bundle, this.f52754d, this.f52753c));
    }
}
