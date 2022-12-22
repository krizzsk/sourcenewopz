package com.didi.map.global.component.collide.common;

import java.util.ArrayList;
import java.util.List;

public class DMarkerMgr {

    /* renamed from: a */
    private List<DMarker> f24812a = new ArrayList();

    public synchronized List<DMarker> getAllMarkers() {
        return this.f24812a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addMarker(com.didi.map.global.component.collide.common.DMarker r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0016
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r1.f24812a     // Catch:{ all -> 0x0013 }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x000c
            goto L_0x0016
        L_0x000c:
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r1.f24812a     // Catch:{ all -> 0x0013 }
            r0.add(r2)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            return
        L_0x0013:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0016:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.collide.common.DMarkerMgr.addMarker(com.didi.map.global.component.collide.common.DMarker):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeMarker(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r3.f24812a     // Catch:{ all -> 0x0028 }
            boolean r0 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r0)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r3)
            return
        L_0x000b:
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r3.f24812a     // Catch:{ all -> 0x0028 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0028 }
        L_0x0011:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0028 }
            com.didi.map.global.component.collide.common.DMarker r1 = (com.didi.map.global.component.collide.common.DMarker) r1     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = r1.f24811id     // Catch:{ all -> 0x0028 }
            if (r2 != r4) goto L_0x0011
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r4 = r3.f24812a     // Catch:{ all -> 0x0028 }
            r4.remove(r1)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r3)
            return
        L_0x0028:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.collide.common.DMarkerMgr.removeMarker(java.lang.String):void");
    }

    public void destroy() {
        this.f24812a.clear();
        this.f24812a = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.didi.map.global.component.collide.common.DMarker getMarker(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r4.f24812a     // Catch:{ all -> 0x002d }
            boolean r0 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r0)     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x002b
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0011
            goto L_0x002b
        L_0x0011:
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r4.f24812a     // Catch:{ all -> 0x002d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002d }
        L_0x0017:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x002d }
            com.didi.map.global.component.collide.common.DMarker r2 = (com.didi.map.global.component.collide.common.DMarker) r2     // Catch:{ all -> 0x002d }
            java.lang.String r3 = r2.f24811id     // Catch:{ all -> 0x002d }
            if (r3 != r5) goto L_0x0017
            monitor-exit(r4)
            return r2
        L_0x0029:
            monitor-exit(r4)
            return r1
        L_0x002b:
            monitor-exit(r4)
            return r1
        L_0x002d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.collide.common.DMarkerMgr.getMarker(java.lang.String):com.didi.map.global.component.collide.common.DMarker");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateMarker(com.didi.map.global.component.collide.common.DMarker r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r4.f24812a     // Catch:{ all -> 0x0040 }
            boolean r0 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r0)     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x003e
            if (r5 == 0) goto L_0x003e
            java.lang.String r0 = r5.f24811id     // Catch:{ all -> 0x0040 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0014
            goto L_0x003e
        L_0x0014:
            java.util.List<com.didi.map.global.component.collide.common.DMarker> r0 = r4.f24812a     // Catch:{ all -> 0x0040 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0040 }
        L_0x001a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0040 }
            com.didi.map.global.component.collide.common.DMarker r1 = (com.didi.map.global.component.collide.common.DMarker) r1     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = r5.f24811id     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = r1.f24811id     // Catch:{ all -> 0x0040 }
            if (r2 != r3) goto L_0x001a
            com.didi.common.map.model.Marker r0 = r5.mLabelMarker     // Catch:{ all -> 0x0040 }
            r1.mLabelMarker = r0     // Catch:{ all -> 0x0040 }
            com.didi.common.map.model.Marker r0 = r5.mRootMarker     // Catch:{ all -> 0x0040 }
            r1.mRootMarker = r0     // Catch:{ all -> 0x0040 }
            com.didi.common.map.model.Padding r0 = r5.mRootMarkerPadding     // Catch:{ all -> 0x0040 }
            r1.mRootMarkerPadding = r0     // Catch:{ all -> 0x0040 }
            com.didi.common.map.model.Padding r5 = r5.mLabelMarkerPadding     // Catch:{ all -> 0x0040 }
            r1.mLabelMarkerPadding = r5     // Catch:{ all -> 0x0040 }
        L_0x003c:
            monitor-exit(r4)
            return
        L_0x003e:
            monitor-exit(r4)
            return
        L_0x0040:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.collide.common.DMarkerMgr.updateMarker(com.didi.map.global.component.collide.common.DMarker):void");
    }
}
