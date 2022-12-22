package kotlin.reflect.jvm.internal.impl.platform;

import org.osgi.framework.VersionRange;

/* compiled from: TargetPlatform.kt */
public abstract class SimplePlatform {

    /* renamed from: a */
    private final String f60741a;

    /* renamed from: b */
    private final TargetPlatformVersion f60742b;

    public String toString() {
        String targetName = getTargetName();
        if (!(targetName.length() > 0)) {
            return this.f60741a;
        }
        return this.f60741a + " (" + targetName + VersionRange.RIGHT_OPEN;
    }

    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.f60742b;
    }
}
