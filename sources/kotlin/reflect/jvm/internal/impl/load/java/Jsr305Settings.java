package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.osgi.framework.VersionRange;

/* compiled from: Jsr305Settings.kt */
public final class Jsr305Settings {

    /* renamed from: a */
    private final ReportLevel f60397a;

    /* renamed from: b */
    private final ReportLevel f60398b;

    /* renamed from: c */
    private final Map<FqName, ReportLevel> f60399c;

    /* renamed from: d */
    private final Lazy f60400d;

    /* renamed from: e */
    private final boolean f60401e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Jsr305Settings)) {
            return false;
        }
        Jsr305Settings jsr305Settings = (Jsr305Settings) obj;
        return this.f60397a == jsr305Settings.f60397a && this.f60398b == jsr305Settings.f60398b && Intrinsics.areEqual((Object) this.f60399c, (Object) jsr305Settings.f60399c);
    }

    public int hashCode() {
        int hashCode = this.f60397a.hashCode() * 31;
        ReportLevel reportLevel = this.f60398b;
        return ((hashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.f60399c.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f60397a + ", migrationLevel=" + this.f60398b + ", userDefinedLevelForSpecificAnnotation=" + this.f60399c + VersionRange.RIGHT_OPEN;
    }

    public Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map<FqName, ? extends ReportLevel> map) {
        Intrinsics.checkNotNullParameter(reportLevel, "globalLevel");
        Intrinsics.checkNotNullParameter(map, "userDefinedLevelForSpecificAnnotation");
        this.f60397a = reportLevel;
        this.f60398b = reportLevel2;
        this.f60399c = map;
        this.f60400d = LazyKt.lazy(new Jsr305Settings$description$2(this));
        this.f60401e = this.f60397a == ReportLevel.IGNORE && this.f60398b == ReportLevel.IGNORE && this.f60399c.isEmpty();
    }

    public final ReportLevel getGlobalLevel() {
        return this.f60397a;
    }

    public final ReportLevel getMigrationLevel() {
        return this.f60398b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i & 2) != 0 ? null : reportLevel2, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.f60399c;
    }

    public final boolean isDisabled() {
        return this.f60401e;
    }
}
