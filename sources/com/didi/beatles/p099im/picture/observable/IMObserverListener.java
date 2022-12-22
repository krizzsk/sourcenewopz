package com.didi.beatles.p099im.picture.observable;

import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.entity.IMLocalMediaFolder;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.observable.IMObserverListener */
public interface IMObserverListener {
    void observerUpFoldersData(List<IMLocalMediaFolder> list);

    void observerUpSelectsData(List<IMLocalMedia> list);
}
