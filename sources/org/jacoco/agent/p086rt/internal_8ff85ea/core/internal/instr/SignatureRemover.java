package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.SignatureRemover */
public class SignatureRemover {
    private static final String DIGEST_SUFFIX = "-Digest";
    private static final String MANIFEST_MF = "META-INF/MANIFEST.MF";
    private static final Pattern SIGNATURE_FILES = Pattern.compile("META-INF/[^/]*\\.SF|META-INF/[^/]*\\.DSA|META-INF/[^/]*\\.RSA|META-INF/SIG-[^/]*");
    private boolean active = true;

    public void setActive(boolean z) {
        this.active = z;
    }

    public boolean removeEntry(String str) {
        return this.active && SIGNATURE_FILES.matcher(str).matches();
    }

    public boolean filterEntry(String str, InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!this.active || !MANIFEST_MF.equals(str)) {
            return false;
        }
        Manifest manifest = new Manifest(inputStream);
        filterManifestEntry(manifest.getEntries().values());
        manifest.write(outputStream);
        return true;
    }

    private void filterManifestEntry(Collection<Attributes> collection) {
        Iterator<Attributes> it = collection.iterator();
        while (it.hasNext()) {
            Attributes next = it.next();
            filterManifestEntryAttributes(next);
            if (next.isEmpty()) {
                it.remove();
            }
        }
    }

    private void filterManifestEntryAttributes(Attributes attributes) {
        Iterator<Object> it = attributes.keySet().iterator();
        while (it.hasNext()) {
            if (String.valueOf(it.next()).endsWith(DIGEST_SUFFIX)) {
                it.remove();
            }
        }
    }
}
