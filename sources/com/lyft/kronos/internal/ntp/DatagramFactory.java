package com.lyft.kronos.internal.ntp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/lyft/kronos/internal/ntp/DatagramFactory;", "", "createPacket", "Ljava/net/DatagramPacket;", "buffer", "", "address", "Ljava/net/InetAddress;", "port", "", "createSocket", "Ljava/net/DatagramSocket;", "kronos-java"}, mo175979k = 1, mo175980mv = {1, 4, 0})
/* compiled from: DatagramFactory.kt */
public interface DatagramFactory {
    DatagramPacket createPacket(byte[] bArr);

    DatagramPacket createPacket(byte[] bArr, InetAddress inetAddress, int i);

    DatagramSocket createSocket() throws SocketException;
}
