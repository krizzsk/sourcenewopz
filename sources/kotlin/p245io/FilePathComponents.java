package kotlin.p245io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, mo175978d2 = {"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.io.FilePathComponents */
/* compiled from: FilePathComponents.kt */
public final class FilePathComponents {

    /* renamed from: a */
    private final File f59873a;

    /* renamed from: b */
    private final List<File> f59874b;

    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents filePathComponents, File file, List<File> list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = filePathComponents.f59873a;
        }
        if ((i & 2) != 0) {
            list = filePathComponents.f59874b;
        }
        return filePathComponents.copy(file, list);
    }

    public final File component1() {
        return this.f59873a;
    }

    public final List<File> component2() {
        return this.f59874b;
    }

    public final FilePathComponents copy(File file, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(file, "root");
        Intrinsics.checkNotNullParameter(list, "segments");
        return new FilePathComponents(file, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) obj;
        return Intrinsics.areEqual((Object) this.f59873a, (Object) filePathComponents.f59873a) && Intrinsics.areEqual((Object) this.f59874b, (Object) filePathComponents.f59874b);
    }

    public int hashCode() {
        File file = this.f59873a;
        int i = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.f59874b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FilePathComponents(root=" + this.f59873a + ", segments=" + this.f59874b + ")";
    }

    public FilePathComponents(File file, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(file, "root");
        Intrinsics.checkNotNullParameter(list, "segments");
        this.f59873a = file;
        this.f59874b = list;
    }

    public final File getRoot() {
        return this.f59873a;
    }

    public final List<File> getSegments() {
        return this.f59874b;
    }

    public final String getRootName() {
        String path = this.f59873a.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path;
    }

    public final boolean isRooted() {
        String path = this.f59873a.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path.length() > 0;
    }

    public final int getSize() {
        return this.f59874b.size();
    }

    public final File subPath(int i, int i2) {
        if (i < 0 || i > i2 || i2 > getSize()) {
            throw new IllegalArgumentException();
        }
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        return new File(CollectionsKt.joinToString$default(this.f59874b.subList(i, i2), str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }
}
