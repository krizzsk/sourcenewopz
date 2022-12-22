package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, mo175978d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SplitPairFilter.kt */
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SplitPairFilter(android.content.ComponentName r21, android.content.ComponentName r22, java.lang.String r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "primaryActivityName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "secondaryActivityName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r20.<init>()
            r0.primaryActivityName = r1
            r0.secondaryActivityName = r2
            r2 = r23
            r0.secondaryActivityIntentAction = r2
            java.lang.String r1 = r21.getPackageName()
            java.lang.String r2 = "primaryActivityName.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.ComponentName r2 = r0.primaryActivityName
            java.lang.String r2 = r2.getClassName()
            java.lang.String r3 = "primaryActivityName.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.content.ComponentName r3 = r0.secondaryActivityName
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r4 = "secondaryActivityName.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.content.ComponentName r4 = r0.secondaryActivityName
            java.lang.String r4 = r4.getClassName()
            java.lang.String r5 = "secondaryActivityName.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r5 = r6.length()
            r12 = 1
            r13 = 0
            if (r5 != 0) goto L_0x0055
            r5 = 1
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            if (r5 != 0) goto L_0x0068
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0063
            r5 = 1
            goto L_0x0064
        L_0x0063:
            r5 = 0
        L_0x0064:
            if (r5 != 0) goto L_0x0068
            r5 = 1
            goto L_0x0069
        L_0x0068:
            r5 = 0
        L_0x0069:
            if (r5 == 0) goto L_0x016d
            r14 = r2
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r5 = r14.length()
            if (r5 != 0) goto L_0x0076
            r5 = 1
            goto L_0x0077
        L_0x0076:
            r5 = 0
        L_0x0077:
            if (r5 != 0) goto L_0x0089
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0084
            r5 = 1
            goto L_0x0085
        L_0x0084:
            r5 = 0
        L_0x0085:
            if (r5 != 0) goto L_0x0089
            r5 = 1
            goto L_0x008a
        L_0x0089:
            r5 = 0
        L_0x008a:
            if (r5 == 0) goto L_0x015f
            java.lang.String r5 = "*"
            r7 = r5
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15 = 2
            r11 = 0
            boolean r7 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) r7, (boolean) r13, (int) r15, (java.lang.Object) r11)
            if (r7 == 0) goto L_0x00b1
            r8 = 0
            r9 = 0
            r10 = 6
            r16 = 0
            java.lang.String r7 = "*"
            r13 = r11
            r11 = r16
            int r6 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r6, (java.lang.String) r7, (int) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
            int r1 = r1.length()
            int r1 = r1 - r12
            if (r6 != r1) goto L_0x00af
            goto L_0x00b2
        L_0x00af:
            r1 = 0
            goto L_0x00b3
        L_0x00b1:
            r13 = r11
        L_0x00b2:
            r1 = 1
        L_0x00b3:
            java.lang.String r6 = "Wildcard in package name is only allowed at the end."
            if (r1 == 0) goto L_0x0153
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r1, (boolean) r7, (int) r15, (java.lang.Object) r13)
            if (r1 == 0) goto L_0x00db
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.lang.String r1 = "*"
            r7 = 2
            r15 = r1
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r14, (java.lang.String) r15, (int) r16, (boolean) r17, (int) r18, (java.lang.Object) r19)
            int r2 = r2.length()
            int r2 = r2 - r12
            if (r1 != r2) goto L_0x00d9
            goto L_0x00dc
        L_0x00d9:
            r1 = 0
            goto L_0x00dd
        L_0x00db:
            r7 = 2
        L_0x00dc:
            r1 = 1
        L_0x00dd:
            java.lang.String r2 = "Wildcard in class name is only allowed at the end."
            if (r1 == 0) goto L_0x0147
            r14 = r3
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r1, (boolean) r8, (int) r7, (java.lang.Object) r13)
            if (r1 == 0) goto L_0x0106
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.lang.String r15 = "*"
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r14, (java.lang.String) r15, (int) r16, (boolean) r17, (int) r18, (java.lang.Object) r19)
            int r3 = r3.length()
            int r3 = r3 - r12
            if (r1 != r3) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r1 = 0
            goto L_0x0107
        L_0x0106:
            r1 = 1
        L_0x0107:
            if (r1 == 0) goto L_0x013b
            r14 = r4
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1 = 0
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r5, (boolean) r1, (int) r7, (java.lang.Object) r13)
            if (r3 == 0) goto L_0x012c
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.lang.String r15 = "*"
            int r3 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r14, (java.lang.String) r15, (int) r16, (boolean) r17, (int) r18, (java.lang.Object) r19)
            int r4 = r4.length()
            int r4 = r4 - r12
            if (r3 != r4) goto L_0x012b
            goto L_0x012c
        L_0x012b:
            r12 = 0
        L_0x012c:
            if (r12 == 0) goto L_0x012f
            return
        L_0x012f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x013b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r6.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0147:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0153:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r6.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x015f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Activity class name must not be empty."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x016d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Package name must not be empty"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairFilter.<init>(android.content.ComponentName, android.content.ComponentName, java.lang.String):void");
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (matchesActivityIntentPair(r6, r7) != false) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean matchesActivityPair(android.app.Activity r6, android.app.Activity r7) {
        /*
            r5 = this;
            java.lang.String r0 = "primaryActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "secondaryActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.window.embedding.MatcherUtils r0 = androidx.window.embedding.MatcherUtils.INSTANCE
            android.content.ComponentName r1 = r6.getComponentName()
            android.content.ComponentName r2 = r5.primaryActivityName
            boolean r0 = r0.areComponentsMatching$window_release(r1, r2)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002b
            androidx.window.embedding.MatcherUtils r0 = androidx.window.embedding.MatcherUtils.INSTANCE
            android.content.ComponentName r3 = r7.getComponentName()
            android.content.ComponentName r4 = r5.secondaryActivityName
            boolean r0 = r0.areComponentsMatching$window_release(r3, r4)
            if (r0 == 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            android.content.Intent r3 = r7.getIntent()
            if (r3 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x0045
            android.content.Intent r7 = r7.getIntent()
            java.lang.String r0 = "secondaryActivity.intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            boolean r6 = r5.matchesActivityIntentPair(r6, r7)
            if (r6 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            r0 = r1
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairFilter.matchesActivityPair(android.app.Activity, android.app.Activity):boolean");
    }

    public final boolean matchesActivityIntentPair(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "primaryActivity");
        Intrinsics.checkNotNullParameter(intent, "secondaryActivityIntent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) || !MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        if (str == null || Intrinsics.areEqual((Object) str, (Object) intent.getAction())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return Intrinsics.areEqual((Object) this.primaryActivityName, (Object) splitPairFilter.primaryActivityName) && Intrinsics.areEqual((Object) this.secondaryActivityName, (Object) splitPairFilter.secondaryActivityName) && Intrinsics.areEqual((Object) this.secondaryActivityIntentAction, (Object) splitPairFilter.secondaryActivityIntentAction);
    }

    public int hashCode() {
        int hashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityIntentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}
