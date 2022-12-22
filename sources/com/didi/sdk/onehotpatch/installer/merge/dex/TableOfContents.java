package com.didi.sdk.onehotpatch.installer.merge.dex;

import com.didi.sdk.onehotpatch.installer.merge.dex.Dex;
import java.io.IOException;
import java.util.Arrays;

public final class TableOfContents {
    public final Section annotationSetRefLists = new Section(4098);
    public final Section annotationSets = new Section(4099);
    public final Section annotations = new Section(8196);
    public final Section annotationsDirectories;
    public final Section callSiteIds = new Section(7);
    public int checksum;
    public final Section classDatas = new Section(8192);
    public final Section classDefs = new Section(6);
    public final Section codes = new Section(8193);
    public int dataOff;
    public int dataSize;
    public final Section debugInfos = new Section(8195);
    public final Section encodedArrays = new Section(8197);
    public final Section fieldIds = new Section(4);
    public int fileSize;
    public final Section header = new Section(0);
    public int linkOff;
    public int linkSize;
    public final Section mapList = new Section(4096);
    public final Section methodHandles = new Section(8);
    public final Section methodIds = new Section(5);
    public final Section protoIds = new Section(3);
    public final Section[] sections;
    public byte[] signature;
    public final Section stringDatas = new Section(8194);
    public final Section stringIds = new Section(1);
    public final Section typeIds = new Section(2);
    public final Section typeLists = new Section(4097);

    public TableOfContents() {
        Section section = new Section(8198);
        this.annotationsDirectories = section;
        this.sections = new Section[]{this.header, this.stringIds, this.typeIds, this.protoIds, this.fieldIds, this.methodIds, this.classDefs, this.mapList, this.callSiteIds, this.methodHandles, this.typeLists, this.annotationSetRefLists, this.annotationSets, this.classDatas, this.codes, this.stringDatas, this.debugInfos, this.annotations, this.encodedArrays, section};
        this.signature = new byte[20];
    }

    public void readFrom(Dex dex) throws IOException {
        readHeader(dex.open(0));
        readMap(dex.open(this.mapList.off));
        computeSizesFromOffsets();
    }

    private void readHeader(Dex.Section section) throws IOException {
        section.readByteArray(8);
        this.checksum = section.readInt();
        this.signature = section.readByteArray(20);
        this.fileSize = section.readInt();
        int readInt = section.readInt();
        if (readInt == 112) {
            section.readInt();
            this.linkSize = section.readInt();
            this.linkOff = section.readInt();
            this.mapList.off = section.readInt();
            if (this.mapList.off != 0) {
                this.stringIds.size = section.readInt();
                this.stringIds.off = section.readInt();
                this.typeIds.size = section.readInt();
                this.typeIds.off = section.readInt();
                this.protoIds.size = section.readInt();
                this.protoIds.off = section.readInt();
                this.fieldIds.size = section.readInt();
                this.fieldIds.off = section.readInt();
                this.methodIds.size = section.readInt();
                this.methodIds.off = section.readInt();
                this.classDefs.size = section.readInt();
                this.classDefs.off = section.readInt();
                this.dataSize = section.readInt();
                this.dataOff = section.readInt();
                return;
            }
            throw new DexException("Cannot merge dex files that do not contain a map");
        }
        throw new DexException("Unexpected header: 0x" + Integer.toHexString(readInt));
    }

    private void readMap(Dex.Section section) throws IOException {
        int readInt = section.readInt();
        Section section2 = null;
        int i = 0;
        while (i < readInt) {
            short readShort = section.readShort();
            section.readShort();
            Section section3 = getSection(readShort);
            int readInt2 = section.readInt();
            int readInt3 = section.readInt();
            if ((section3.size == 0 || section3.size == readInt2) && (section3.off == -1 || section3.off == readInt3)) {
                section3.size = readInt2;
                section3.off = readInt3;
                if (section2 == null || section2.off <= section3.off) {
                    i++;
                    section2 = section3;
                } else {
                    throw new DexException("Map is unsorted at " + section2 + ", " + section3);
                }
            } else {
                throw new DexException("Unexpected map value for 0x" + Integer.toHexString(readShort));
            }
        }
        Arrays.sort(this.sections);
    }

    public void computeSizesFromOffsets() {
        int i = this.dataOff + this.dataSize;
        for (int length = this.sections.length - 1; length >= 0; length--) {
            Section section = this.sections[length];
            if (section.off != -1) {
                if (section.off <= i) {
                    section.byteCount = i - section.off;
                    i = section.off;
                } else {
                    throw new DexException("Map is unsorted at " + section);
                }
            }
        }
    }

    private Section getSection(short s) {
        for (Section section : this.sections) {
            if (section.type == s) {
                return section;
            }
        }
        throw new IllegalArgumentException("No such map item: " + s);
    }

    public static class Section implements Comparable<Section> {
        public int byteCount = 0;
        public int off = -1;
        public int size = 0;
        public final short type;

        public Section(int i) {
            this.type = (short) i;
        }

        public boolean exists() {
            return this.size > 0;
        }

        public int compareTo(Section section) {
            int i = this.off;
            int i2 = section.off;
            if (i != i2) {
                return i < i2 ? -1 : 1;
            }
            return 0;
        }

        public String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.type), Integer.valueOf(this.off), Integer.valueOf(this.size)});
        }
    }
}
