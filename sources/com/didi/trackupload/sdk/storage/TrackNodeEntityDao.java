package com.didi.trackupload.sdk.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.didi.sdk.push.ServerParam;
import com.didi.security.uuid.share.ShareDBHelper;
import com.didi.soda.blocks.constant.Const;
import com.didi.trackupload.sdk.datachannel.protobuf.CoordinateType;
import com.didi.trackupload.sdk.datachannel.protobuf.LocationType;
import com.didi.trackupload.sdk.storage.TrackNodeEntity;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class TrackNodeEntityDao extends AbstractDao<TrackNodeEntity, Long> {
    public static final String TABLENAME = "tbl_track_nodes";
    private final TrackNodeEntity.LocationTypeConverter srcConverter = new TrackNodeEntity.LocationTypeConverter();
    private final TrackNodeEntity.StringListConverter tagsConverter = new TrackNodeEntity.StringListConverter();
    private final TrackNodeEntity.CoordinateTypeConverter typeConverter = new TrackNodeEntity.CoordinateTypeConverter();

    public static class Properties {
        public static final Property Accelerated_speed_x = new Property(9, Float.class, "accelerated_speed_x", false, "accelerated_speed_x");
        public static final Property Accelerated_speed_y = new Property(10, Float.class, "accelerated_speed_y", false, "accelerated_speed_y");
        public static final Property Accelerated_speed_z = new Property(11, Float.class, "accelerated_speed_z", false, "accelerated_speed_z");
        public static final Property Accuracy = new Property(5, Double.class, ServerParam.PARAM_ACCURACY, false, ServerParam.PARAM_ACCURACY);
        public static final Property Altitude = new Property(8, Float.class, "altitude", false, "altitude");
        public static final Property Direction = new Property(6, Double.class, Const.YogaConst.YOGA_DIRECTION, false, Const.YogaConst.YOGA_DIRECTION);

        /* renamed from: Id */
        public static final Property f44004Id = new Property(0, Long.class, "id", true, ShareDBHelper.ID_NAME);
        public static final Property Included_angle_pitch = new Property(14, Float.class, "included_angle_pitch", false, "included_angle_pitch");
        public static final Property Included_angle_roll = new Property(13, Float.class, "included_angle_roll", false, "included_angle_roll");
        public static final Property Included_angle_yaw = new Property(12, Float.class, "included_angle_yaw", false, "included_angle_yaw");
        public static final Property Lat = new Property(1, Double.class, "lat", false, "lat");
        public static final Property Lng = new Property(2, Double.class, "lng", false, "lng");
        public static final Property Map_extra_point_data = new Property(19, byte[].class, "map_extra_point_data", false, "map_extra_point_data");
        public static final Property Speed = new Property(7, Double.class, "speed", false, "speed");
        public static final Property Src = new Property(4, Integer.class, Const.BlockParamConst.SRC, false, Const.BlockParamConst.SRC);
        public static final Property Tags = new Property(18, String.class, "tags", false, "tags");
        public static final Property Time = new Property(15, Integer.class, "time", false, "time");
        public static final Property Time64 = new Property(16, Long.class, "time64", false, "time64");
        public static final Property Time_local = new Property(17, Integer.class, "time_local", false, "time_local");
        public static final Property Type = new Property(3, Integer.class, "type", false, "type");
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }

    public TrackNodeEntityDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public TrackNodeEntityDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"tbl_track_nodes\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"lat\" REAL,\"lng\" REAL,\"type\" INTEGER,\"src\" INTEGER,\"accuracy\" REAL,\"direction\" REAL,\"speed\" REAL,\"altitude\" REAL,\"accelerated_speed_x\" REAL,\"accelerated_speed_y\" REAL,\"accelerated_speed_z\" REAL,\"included_angle_yaw\" REAL,\"included_angle_roll\" REAL,\"included_angle_pitch\" REAL,\"time\" INTEGER,\"time64\" INTEGER,\"time_local\" INTEGER,\"tags\" TEXT,\"map_extra_point_data\" BLOB);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"tbl_track_nodes\"");
        database.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(DatabaseStatement databaseStatement, TrackNodeEntity trackNodeEntity) {
        databaseStatement.clearBindings();
        Long id = trackNodeEntity.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        Double lat = trackNodeEntity.getLat();
        if (lat != null) {
            databaseStatement.bindDouble(2, lat.doubleValue());
        }
        Double lng = trackNodeEntity.getLng();
        if (lng != null) {
            databaseStatement.bindDouble(3, lng.doubleValue());
        }
        CoordinateType type = trackNodeEntity.getType();
        if (type != null) {
            databaseStatement.bindLong(4, (long) this.typeConverter.convertToDatabaseValue(type).intValue());
        }
        LocationType src = trackNodeEntity.getSrc();
        if (src != null) {
            databaseStatement.bindLong(5, (long) this.srcConverter.convertToDatabaseValue(src).intValue());
        }
        Double accuracy = trackNodeEntity.getAccuracy();
        if (accuracy != null) {
            databaseStatement.bindDouble(6, accuracy.doubleValue());
        }
        Double direction = trackNodeEntity.getDirection();
        if (direction != null) {
            databaseStatement.bindDouble(7, direction.doubleValue());
        }
        Double speed = trackNodeEntity.getSpeed();
        if (speed != null) {
            databaseStatement.bindDouble(8, speed.doubleValue());
        }
        Float altitude = trackNodeEntity.getAltitude();
        if (altitude != null) {
            databaseStatement.bindDouble(9, (double) altitude.floatValue());
        }
        Float accelerated_speed_x = trackNodeEntity.getAccelerated_speed_x();
        if (accelerated_speed_x != null) {
            databaseStatement.bindDouble(10, (double) accelerated_speed_x.floatValue());
        }
        Float accelerated_speed_y = trackNodeEntity.getAccelerated_speed_y();
        if (accelerated_speed_y != null) {
            databaseStatement.bindDouble(11, (double) accelerated_speed_y.floatValue());
        }
        Float accelerated_speed_z = trackNodeEntity.getAccelerated_speed_z();
        if (accelerated_speed_z != null) {
            databaseStatement.bindDouble(12, (double) accelerated_speed_z.floatValue());
        }
        Float included_angle_yaw = trackNodeEntity.getIncluded_angle_yaw();
        if (included_angle_yaw != null) {
            databaseStatement.bindDouble(13, (double) included_angle_yaw.floatValue());
        }
        Float included_angle_roll = trackNodeEntity.getIncluded_angle_roll();
        if (included_angle_roll != null) {
            databaseStatement.bindDouble(14, (double) included_angle_roll.floatValue());
        }
        Float included_angle_pitch = trackNodeEntity.getIncluded_angle_pitch();
        if (included_angle_pitch != null) {
            databaseStatement.bindDouble(15, (double) included_angle_pitch.floatValue());
        }
        Integer time = trackNodeEntity.getTime();
        if (time != null) {
            databaseStatement.bindLong(16, (long) time.intValue());
        }
        Long time64 = trackNodeEntity.getTime64();
        if (time64 != null) {
            databaseStatement.bindLong(17, time64.longValue());
        }
        Integer time_local = trackNodeEntity.getTime_local();
        if (time_local != null) {
            databaseStatement.bindLong(18, (long) time_local.intValue());
        }
        List<String> tags = trackNodeEntity.getTags();
        if (tags != null) {
            databaseStatement.bindString(19, this.tagsConverter.convertToDatabaseValue(tags));
        }
        byte[] map_extra_point_data = trackNodeEntity.getMap_extra_point_data();
        if (map_extra_point_data != null) {
            databaseStatement.bindBlob(20, map_extra_point_data);
        }
    }

    /* access modifiers changed from: protected */
    public final void bindValues(SQLiteStatement sQLiteStatement, TrackNodeEntity trackNodeEntity) {
        sQLiteStatement.clearBindings();
        Long id = trackNodeEntity.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        Double lat = trackNodeEntity.getLat();
        if (lat != null) {
            sQLiteStatement.bindDouble(2, lat.doubleValue());
        }
        Double lng = trackNodeEntity.getLng();
        if (lng != null) {
            sQLiteStatement.bindDouble(3, lng.doubleValue());
        }
        CoordinateType type = trackNodeEntity.getType();
        if (type != null) {
            sQLiteStatement.bindLong(4, (long) this.typeConverter.convertToDatabaseValue(type).intValue());
        }
        LocationType src = trackNodeEntity.getSrc();
        if (src != null) {
            sQLiteStatement.bindLong(5, (long) this.srcConverter.convertToDatabaseValue(src).intValue());
        }
        Double accuracy = trackNodeEntity.getAccuracy();
        if (accuracy != null) {
            sQLiteStatement.bindDouble(6, accuracy.doubleValue());
        }
        Double direction = trackNodeEntity.getDirection();
        if (direction != null) {
            sQLiteStatement.bindDouble(7, direction.doubleValue());
        }
        Double speed = trackNodeEntity.getSpeed();
        if (speed != null) {
            sQLiteStatement.bindDouble(8, speed.doubleValue());
        }
        Float altitude = trackNodeEntity.getAltitude();
        if (altitude != null) {
            sQLiteStatement.bindDouble(9, (double) altitude.floatValue());
        }
        Float accelerated_speed_x = trackNodeEntity.getAccelerated_speed_x();
        if (accelerated_speed_x != null) {
            sQLiteStatement.bindDouble(10, (double) accelerated_speed_x.floatValue());
        }
        Float accelerated_speed_y = trackNodeEntity.getAccelerated_speed_y();
        if (accelerated_speed_y != null) {
            sQLiteStatement.bindDouble(11, (double) accelerated_speed_y.floatValue());
        }
        Float accelerated_speed_z = trackNodeEntity.getAccelerated_speed_z();
        if (accelerated_speed_z != null) {
            sQLiteStatement.bindDouble(12, (double) accelerated_speed_z.floatValue());
        }
        Float included_angle_yaw = trackNodeEntity.getIncluded_angle_yaw();
        if (included_angle_yaw != null) {
            sQLiteStatement.bindDouble(13, (double) included_angle_yaw.floatValue());
        }
        Float included_angle_roll = trackNodeEntity.getIncluded_angle_roll();
        if (included_angle_roll != null) {
            sQLiteStatement.bindDouble(14, (double) included_angle_roll.floatValue());
        }
        Float included_angle_pitch = trackNodeEntity.getIncluded_angle_pitch();
        if (included_angle_pitch != null) {
            sQLiteStatement.bindDouble(15, (double) included_angle_pitch.floatValue());
        }
        Integer time = trackNodeEntity.getTime();
        if (time != null) {
            sQLiteStatement.bindLong(16, (long) time.intValue());
        }
        Long time64 = trackNodeEntity.getTime64();
        if (time64 != null) {
            sQLiteStatement.bindLong(17, time64.longValue());
        }
        Integer time_local = trackNodeEntity.getTime_local();
        if (time_local != null) {
            sQLiteStatement.bindLong(18, (long) time_local.intValue());
        }
        List<String> tags = trackNodeEntity.getTags();
        if (tags != null) {
            sQLiteStatement.bindString(19, this.tagsConverter.convertToDatabaseValue(tags));
        }
        byte[] map_extra_point_data = trackNodeEntity.getMap_extra_point_data();
        if (map_extra_point_data != null) {
            sQLiteStatement.bindBlob(20, map_extra_point_data);
        }
    }

    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    public TrackNodeEntity readEntity(Cursor cursor, int i) {
        List<String> list;
        Float f;
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        Long valueOf = cursor2.isNull(i2) ? null : Long.valueOf(cursor2.getLong(i2));
        int i3 = i + 1;
        Double valueOf2 = cursor2.isNull(i3) ? null : Double.valueOf(cursor2.getDouble(i3));
        int i4 = i + 2;
        Double valueOf3 = cursor2.isNull(i4) ? null : Double.valueOf(cursor2.getDouble(i4));
        int i5 = i + 3;
        CoordinateType convertToEntityProperty = cursor2.isNull(i5) ? null : this.typeConverter.convertToEntityProperty(Integer.valueOf(cursor2.getInt(i5)));
        int i6 = i + 4;
        LocationType convertToEntityProperty2 = cursor2.isNull(i6) ? null : this.srcConverter.convertToEntityProperty(Integer.valueOf(cursor2.getInt(i6)));
        int i7 = i + 5;
        Double valueOf4 = cursor2.isNull(i7) ? null : Double.valueOf(cursor2.getDouble(i7));
        int i8 = i + 6;
        Double valueOf5 = cursor2.isNull(i8) ? null : Double.valueOf(cursor2.getDouble(i8));
        int i9 = i + 7;
        Double valueOf6 = cursor2.isNull(i9) ? null : Double.valueOf(cursor2.getDouble(i9));
        int i10 = i + 8;
        Float valueOf7 = cursor2.isNull(i10) ? null : Float.valueOf(cursor2.getFloat(i10));
        int i11 = i + 9;
        Float valueOf8 = cursor2.isNull(i11) ? null : Float.valueOf(cursor2.getFloat(i11));
        int i12 = i + 10;
        Float valueOf9 = cursor2.isNull(i12) ? null : Float.valueOf(cursor2.getFloat(i12));
        int i13 = i + 11;
        Float valueOf10 = cursor2.isNull(i13) ? null : Float.valueOf(cursor2.getFloat(i13));
        int i14 = i + 12;
        Float valueOf11 = cursor2.isNull(i14) ? null : Float.valueOf(cursor2.getFloat(i14));
        int i15 = i + 13;
        Float valueOf12 = cursor2.isNull(i15) ? null : Float.valueOf(cursor2.getFloat(i15));
        int i16 = i + 14;
        Float valueOf13 = cursor2.isNull(i16) ? null : Float.valueOf(cursor2.getFloat(i16));
        int i17 = i + 15;
        Integer valueOf14 = cursor2.isNull(i17) ? null : Integer.valueOf(cursor2.getInt(i17));
        int i18 = i + 16;
        Long valueOf15 = cursor2.isNull(i18) ? null : Long.valueOf(cursor2.getLong(i18));
        int i19 = i + 17;
        Integer valueOf16 = cursor2.isNull(i19) ? null : Integer.valueOf(cursor2.getInt(i19));
        int i20 = i + 18;
        if (cursor2.isNull(i20)) {
            f = valueOf11;
            list = null;
        } else {
            f = valueOf11;
            list = this.tagsConverter.convertToEntityProperty(cursor2.getString(i20));
        }
        int i21 = i + 19;
        return new TrackNodeEntity(valueOf, valueOf2, valueOf3, convertToEntityProperty, convertToEntityProperty2, valueOf4, valueOf5, valueOf6, valueOf7, valueOf8, valueOf9, valueOf10, f, valueOf12, valueOf13, valueOf14, valueOf15, valueOf16, list, cursor2.isNull(i21) ? null : cursor2.getBlob(i21));
    }

    public void readEntity(Cursor cursor, TrackNodeEntity trackNodeEntity, int i) {
        int i2 = i + 0;
        byte[] bArr = null;
        trackNodeEntity.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        trackNodeEntity.setLat(cursor.isNull(i3) ? null : Double.valueOf(cursor.getDouble(i3)));
        int i4 = i + 2;
        trackNodeEntity.setLng(cursor.isNull(i4) ? null : Double.valueOf(cursor.getDouble(i4)));
        int i5 = i + 3;
        trackNodeEntity.setType(cursor.isNull(i5) ? null : this.typeConverter.convertToEntityProperty(Integer.valueOf(cursor.getInt(i5))));
        int i6 = i + 4;
        trackNodeEntity.setSrc(cursor.isNull(i6) ? null : this.srcConverter.convertToEntityProperty(Integer.valueOf(cursor.getInt(i6))));
        int i7 = i + 5;
        trackNodeEntity.setAccuracy(cursor.isNull(i7) ? null : Double.valueOf(cursor.getDouble(i7)));
        int i8 = i + 6;
        trackNodeEntity.setDirection(cursor.isNull(i8) ? null : Double.valueOf(cursor.getDouble(i8)));
        int i9 = i + 7;
        trackNodeEntity.setSpeed(cursor.isNull(i9) ? null : Double.valueOf(cursor.getDouble(i9)));
        int i10 = i + 8;
        trackNodeEntity.setAltitude(cursor.isNull(i10) ? null : Float.valueOf(cursor.getFloat(i10)));
        int i11 = i + 9;
        trackNodeEntity.setAccelerated_speed_x(cursor.isNull(i11) ? null : Float.valueOf(cursor.getFloat(i11)));
        int i12 = i + 10;
        trackNodeEntity.setAccelerated_speed_y(cursor.isNull(i12) ? null : Float.valueOf(cursor.getFloat(i12)));
        int i13 = i + 11;
        trackNodeEntity.setAccelerated_speed_z(cursor.isNull(i13) ? null : Float.valueOf(cursor.getFloat(i13)));
        int i14 = i + 12;
        trackNodeEntity.setIncluded_angle_yaw(cursor.isNull(i14) ? null : Float.valueOf(cursor.getFloat(i14)));
        int i15 = i + 13;
        trackNodeEntity.setIncluded_angle_roll(cursor.isNull(i15) ? null : Float.valueOf(cursor.getFloat(i15)));
        int i16 = i + 14;
        trackNodeEntity.setIncluded_angle_pitch(cursor.isNull(i16) ? null : Float.valueOf(cursor.getFloat(i16)));
        int i17 = i + 15;
        trackNodeEntity.setTime(cursor.isNull(i17) ? null : Integer.valueOf(cursor.getInt(i17)));
        int i18 = i + 16;
        trackNodeEntity.setTime64(cursor.isNull(i18) ? null : Long.valueOf(cursor.getLong(i18)));
        int i19 = i + 17;
        trackNodeEntity.setTime_local(cursor.isNull(i19) ? null : Integer.valueOf(cursor.getInt(i19)));
        int i20 = i + 18;
        trackNodeEntity.setTags(cursor.isNull(i20) ? null : this.tagsConverter.convertToEntityProperty(cursor.getString(i20)));
        int i21 = i + 19;
        if (!cursor.isNull(i21)) {
            bArr = cursor.getBlob(i21);
        }
        trackNodeEntity.setMap_extra_point_data(bArr);
    }

    /* access modifiers changed from: protected */
    public final Long updateKeyAfterInsert(TrackNodeEntity trackNodeEntity, long j) {
        trackNodeEntity.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public Long getKey(TrackNodeEntity trackNodeEntity) {
        if (trackNodeEntity != null) {
            return trackNodeEntity.getId();
        }
        return null;
    }

    public boolean hasKey(TrackNodeEntity trackNodeEntity) {
        return trackNodeEntity.getId() != null;
    }
}
