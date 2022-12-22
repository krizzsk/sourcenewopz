package org.jacoco.agent.p086rt.internal_8ff85ea.core.instr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassReader;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassWriter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.ContentTypeDetector;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.Java9Support;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.Pack200Streams;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.ClassProbesAdapter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr.ClassInstrumenter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr.ProbeArrayStrategyFactory;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr.SignatureRemover;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.instr.Instrumenter */
public class Instrumenter {
    private final IExecutionDataAccessorGenerator accessorGenerator;
    private final SignatureRemover signatureRemover = new SignatureRemover();

    public Instrumenter(IExecutionDataAccessorGenerator iExecutionDataAccessorGenerator) {
        this.accessorGenerator = iExecutionDataAccessorGenerator;
    }

    public void setRemoveSignatures(boolean z) {
        this.signatureRemover.setActive(z);
    }

    public byte[] instrument(ClassReader classReader) {
        C28621 r0 = new ClassWriter(classReader, 0) {
            /* access modifiers changed from: protected */
            public String getCommonSuperClass(String str, String str2) {
                throw new IllegalStateException();
            }
        };
        classReader.accept(new ClassProbesAdapter(new ClassInstrumenter(ProbeArrayStrategyFactory.createFor(classReader, this.accessorGenerator), r0), true), 8);
        return r0.toByteArray();
    }

    public byte[] instrument(byte[] bArr, String str) throws IOException {
        try {
            if (!Java9Support.isPatchRequired(bArr)) {
                return instrument(new ClassReader(bArr));
            }
            byte[] instrument = instrument(new ClassReader(Java9Support.downgrade(bArr)));
            Java9Support.upgrade(instrument);
            return instrument;
        } catch (RuntimeException e) {
            throw instrumentError(str, e);
        }
    }

    public byte[] instrument(InputStream inputStream, String str) throws IOException {
        try {
            return instrument(Java9Support.readFully(inputStream), str);
        } catch (RuntimeException e) {
            throw instrumentError(str, e);
        }
    }

    public void instrument(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        try {
            outputStream.write(instrument(Java9Support.readFully(inputStream), str));
        } catch (RuntimeException e) {
            throw instrumentError(str, e);
        }
    }

    private IOException instrumentError(String str, RuntimeException runtimeException) {
        IOException iOException = new IOException(String.format("Error while instrumenting class %s.", new Object[]{str}));
        iOException.initCause(runtimeException);
        return iOException;
    }

    public int instrumentAll(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        ContentTypeDetector contentTypeDetector = new ContentTypeDetector(inputStream);
        int type = contentTypeDetector.getType();
        if (type == -889275714) {
            instrument(contentTypeDetector.getInputStream(), outputStream, str);
            return 1;
        } else if (type == -889270259) {
            return instrumentPack200(contentTypeDetector.getInputStream(), outputStream, str);
        } else {
            if (type == 529203200) {
                return instrumentGzip(contentTypeDetector.getInputStream(), outputStream, str);
            }
            if (type == 1347093252) {
                return instrumentZip(contentTypeDetector.getInputStream(), outputStream, str);
            }
            copy(contentTypeDetector.getInputStream(), outputStream);
            return 0;
        }
    }

    private int instrumentZip(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (!this.signatureRemover.removeEntry(name)) {
                    zipOutputStream.putNextEntry(new ZipEntry(name));
                    if (!this.signatureRemover.filterEntry(name, zipInputStream, zipOutputStream)) {
                        i += instrumentAll(zipInputStream, zipOutputStream, str + "@" + name);
                    }
                    zipOutputStream.closeEntry();
                }
            } else {
                zipOutputStream.finish();
                return i;
            }
        }
    }

    private int instrumentGzip(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        int instrumentAll = instrumentAll(new GZIPInputStream(inputStream), gZIPOutputStream, str);
        gZIPOutputStream.finish();
        return instrumentAll;
    }

    private int instrumentPack200(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int instrumentAll = instrumentAll(Pack200Streams.unpack(inputStream), byteArrayOutputStream, str);
        Pack200Streams.pack(byteArrayOutputStream.toByteArray(), outputStream);
        return instrumentAll;
    }

    private void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
