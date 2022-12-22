package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;

public class MergePathsContent implements C1478a, C1479b {

    /* renamed from: a */
    private final Path f1256a = new Path();

    /* renamed from: b */
    private final Path f1257b = new Path();

    /* renamed from: c */
    private final Path f1258c = new Path();

    /* renamed from: d */
    private final String f1259d;

    /* renamed from: e */
    private final List<C1479b> f1260e = new ArrayList();

    /* renamed from: f */
    private final MergePaths f1261f;

    public MergePathsContent(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1259d = mergePaths.getName();
            this.f1261f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void absorbContent(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r0 = r3.previous()
            if (r0 == r2) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.previous()
            com.airbnb.lottie.animation.content.Content r0 = (com.airbnb.lottie.animation.content.Content) r0
            boolean r1 = r0 instanceof com.airbnb.lottie.animation.content.C1479b
            if (r1 == 0) goto L_0x000d
            java.util.List<com.airbnb.lottie.animation.content.b> r1 = r2.f1260e
            com.airbnb.lottie.animation.content.b r0 = (com.airbnb.lottie.animation.content.C1479b) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000d
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.MergePathsContent.absorbContent(java.util.ListIterator):void");
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.f1260e.size(); i++) {
            this.f1260e.get(i).setContents(list, list2);
        }
    }

    public Path getPath() {
        this.f1258c.reset();
        if (this.f1261f.isHidden()) {
            return this.f1258c;
        }
        int i = C14761.f1262x7df623d1[this.f1261f.getMode().ordinal()];
        if (i == 1) {
            m1276a();
        } else if (i == 2) {
            m1277a(Path.Op.UNION);
        } else if (i == 3) {
            m1277a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            m1277a(Path.Op.INTERSECT);
        } else if (i == 5) {
            m1277a(Path.Op.XOR);
        }
        return this.f1258c;
    }

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1 */
    static /* synthetic */ class C14761 {

        /* renamed from: $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode */
        static final /* synthetic */ int[] f1262x7df623d1;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode[] r0 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1262x7df623d1 = r0
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.MERGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1262x7df623d1     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.ADD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1262x7df623d1     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.SUBTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1262x7df623d1     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.INTERSECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1262x7df623d1     // Catch:{ NoSuchFieldError -> 0x003e }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.MergePathsContent.C14761.<clinit>():void");
        }
    }

    public String getName() {
        return this.f1259d;
    }

    /* renamed from: a */
    private void m1276a() {
        for (int i = 0; i < this.f1260e.size(); i++) {
            this.f1258c.addPath(this.f1260e.get(i).getPath());
        }
    }

    /* renamed from: a */
    private void m1277a(Path.Op op) {
        this.f1257b.reset();
        this.f1256a.reset();
        for (int size = this.f1260e.size() - 1; size >= 1; size--) {
            C1479b bVar = this.f1260e.get(size);
            if (bVar instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) bVar;
                List<C1479b> a = contentGroup.mo15214a();
                for (int size2 = a.size() - 1; size2 >= 0; size2--) {
                    Path path = a.get(size2).getPath();
                    path.transform(contentGroup.mo15215b());
                    this.f1257b.addPath(path);
                }
            } else {
                this.f1257b.addPath(bVar.getPath());
            }
        }
        C1479b bVar2 = this.f1260e.get(0);
        if (bVar2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) bVar2;
            List<C1479b> a2 = contentGroup2.mo15214a();
            for (int i = 0; i < a2.size(); i++) {
                Path path2 = a2.get(i).getPath();
                path2.transform(contentGroup2.mo15215b());
                this.f1256a.addPath(path2);
            }
        } else {
            this.f1256a.set(bVar2.getPath());
        }
        this.f1258c.op(this.f1256a, this.f1257b, op);
    }
}
