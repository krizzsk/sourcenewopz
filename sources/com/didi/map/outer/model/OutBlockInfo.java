package com.didi.map.outer.model;

public class OutBlockInfo {
    public long blockId;
    public int blockType;
    public Point endPoint;
    public Point startPoint;

    public static class Point {
        public int coorIndex;
        public double offsetRate;
        public LatLng point;
        public double shapeOffset;

        public String toString() {
            return "Point{point=" + this.point + ", coorIndex=" + this.coorIndex + ", offsetRate=" + this.offsetRate + ", shapeOffset=" + this.shapeOffset + '}';
        }
    }

    public String toString() {
        return "OutBlockInfo{blockId=" + this.blockId + ", blockType=" + this.blockType + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + '}';
    }
}
