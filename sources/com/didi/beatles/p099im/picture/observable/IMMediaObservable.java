package com.didi.beatles.p099im.picture.observable;

import com.didi.beatles.p099im.picture.entity.IMLocalMedia;
import com.didi.beatles.p099im.picture.entity.IMLocalMediaFolder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.observable.IMMediaObservable */
public class IMMediaObservable implements IMSubjectListener {

    /* renamed from: e */
    private static volatile IMMediaObservable f9445e;

    /* renamed from: a */
    private List<IMObserverListener> f9446a = new ArrayList();

    /* renamed from: b */
    private List<IMLocalMediaFolder> f9447b = new ArrayList();

    /* renamed from: c */
    private List<IMLocalMedia> f9448c = new ArrayList();

    /* renamed from: d */
    private List<IMLocalMedia> f9449d = new ArrayList();

    private IMMediaObservable() {
    }

    public static IMMediaObservable getInstance() {
        if (f9445e == null) {
            synchronized (IMMediaObservable.class) {
                if (f9445e == null) {
                    f9445e = new IMMediaObservable();
                }
            }
        }
        return f9445e;
    }

    public void saveLocalFolders(List<IMLocalMediaFolder> list) {
        if (list != null) {
            this.f9447b = list;
        }
    }

    public void saveLocalMedia(List<IMLocalMedia> list) {
        this.f9448c = list;
    }

    public List<IMLocalMedia> readLocalMedias() {
        if (this.f9448c == null) {
            this.f9448c = new ArrayList();
        }
        return this.f9448c;
    }

    public List<IMLocalMediaFolder> readLocalFolders() {
        if (this.f9447b == null) {
            this.f9447b = new ArrayList();
        }
        return this.f9447b;
    }

    public List<IMLocalMedia> readSelectLocalMedias() {
        return this.f9449d;
    }

    public void clearLocalFolders() {
        List<IMLocalMediaFolder> list = this.f9447b;
        if (list != null) {
            list.clear();
        }
    }

    public void clearLocalMedia() {
        List<IMLocalMedia> list = this.f9448c;
        if (list != null) {
            list.clear();
        }
    }

    public void clearSelectedLocalMedia() {
        List<IMLocalMedia> list = this.f9449d;
        if (list != null) {
            list.clear();
        }
    }

    public void add(IMObserverListener iMObserverListener) {
        this.f9446a.add(iMObserverListener);
    }

    public void remove(IMObserverListener iMObserverListener) {
        if (this.f9446a.contains(iMObserverListener)) {
            this.f9446a.remove(iMObserverListener);
        }
    }
}
