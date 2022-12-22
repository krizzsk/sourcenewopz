package com.didi.sdk.audiorecorder.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.sdk.audiorecorder.AudioRecordContext;

public class AudioRecordContextParcel implements Parcelable {
    public static final Parcelable.Creator<AudioRecordContextParcel> CREATOR = new Parcelable.Creator<AudioRecordContextParcel>() {
        public AudioRecordContextParcel createFromParcel(Parcel parcel) {
            return new AudioRecordContextParcel(parcel);
        }

        public AudioRecordContextParcel[] newArray(int i) {
            return new AudioRecordContextParcel[i];
        }
    };
    public int amrBitRate;
    public int amrConvertSwitch;
    public String audioCacheDir;
    public int audioSegmentDuration;
    public String businessAlias;
    public boolean debugable;
    public boolean isBluetoothRecordEnable;
    public int pcmConvertSwitch;
    public String ttsServerName;
    public String userPhone;

    public int describeContents() {
        return 0;
    }

    private AudioRecordContextParcel(String str) {
        this.businessAlias = str;
    }

    public static AudioRecordContextParcel newInstance(String str, AudioRecordContext audioRecordContext, String str2) {
        AudioRecordContextParcel audioRecordContextParcel = new AudioRecordContextParcel(str);
        audioRecordContextParcel.debugable = audioRecordContext.debugable();
        audioRecordContextParcel.audioCacheDir = audioRecordContext.getAudioCacheDir();
        audioRecordContextParcel.audioSegmentDuration = Math.max(Math.min(900000, audioRecordContext.getAudioSegmentDuration()), 10000);
        audioRecordContextParcel.userPhone = audioRecordContext.getUserPhone();
        audioRecordContextParcel.ttsServerName = str2;
        audioRecordContextParcel.isBluetoothRecordEnable = audioRecordContext.isBluetoothRecordEnable();
        AudioRecordContext.ConvertSwitchConfig convertImplSwitch = audioRecordContext.getConvertImplSwitch();
        if (convertImplSwitch != null) {
            audioRecordContextParcel.pcmConvertSwitch = convertImplSwitch.pcmSwitch;
            audioRecordContextParcel.amrConvertSwitch = convertImplSwitch.amrSwitch;
            audioRecordContextParcel.amrBitRate = convertImplSwitch.amrBitRate;
        }
        return audioRecordContextParcel;
    }

    public String toString() {
        return "AudioRecordContextParcel{businessAlias='" + this.businessAlias + '\'' + ", debugable=" + this.debugable + ", userPhone='" + this.userPhone + '\'' + ", audioCacheDir='" + this.audioCacheDir + '\'' + ", audioSegmentDuration=" + this.audioSegmentDuration + ", ttsServerName='" + this.ttsServerName + '\'' + ", isBluetoothRecordEnable=" + this.isBluetoothRecordEnable + ", pcmConvertSwitch=" + this.pcmConvertSwitch + ", amrConvertSwitch=" + this.amrConvertSwitch + ", amrBitRate=" + this.amrBitRate + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.businessAlias);
        parcel.writeByte(this.debugable ? (byte) 1 : 0);
        parcel.writeString(this.userPhone);
        parcel.writeString(this.audioCacheDir);
        parcel.writeInt(this.audioSegmentDuration);
        parcel.writeString(this.ttsServerName);
        parcel.writeByte(this.isBluetoothRecordEnable ? (byte) 1 : 0);
        parcel.writeInt(this.pcmConvertSwitch);
        parcel.writeInt(this.amrConvertSwitch);
        parcel.writeInt(this.amrBitRate);
    }

    protected AudioRecordContextParcel(Parcel parcel) {
        this.businessAlias = parcel.readString();
        boolean z = true;
        this.debugable = parcel.readByte() != 0;
        this.userPhone = parcel.readString();
        this.audioCacheDir = parcel.readString();
        this.audioSegmentDuration = parcel.readInt();
        this.ttsServerName = parcel.readString();
        this.isBluetoothRecordEnable = parcel.readByte() == 0 ? false : z;
        this.pcmConvertSwitch = parcel.readInt();
        this.amrConvertSwitch = parcel.readInt();
        this.amrBitRate = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && hashCode() == ((AudioRecordContextParcel) obj).hashCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.businessAlias;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + (this.debugable ? 1 : 0)) * 31;
        String str2 = this.userPhone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.audioCacheDir;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.audioSegmentDuration) * 31;
        String str4 = this.ttsServerName;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode3 + i) * 31) + (this.isBluetoothRecordEnable ? 1 : 0);
    }
}
