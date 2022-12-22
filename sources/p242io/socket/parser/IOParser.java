package p242io.socket.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p242io.socket.hasbinary.HasBinary;
import p242io.socket.parser.Binary;
import p242io.socket.parser.Parser;

/* renamed from: io.socket.parser.IOParser */
public final class IOParser implements Parser {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f59553a = Logger.getLogger(IOParser.class.getName());

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Packet<String> m42068c() {
        return new Packet<>(4, "parser error");
    }

    private IOParser() {
    }

    /* renamed from: io.socket.parser.IOParser$Encoder */
    public static final class Encoder implements Parser.Encoder {
        public void encode(Packet packet, Parser.Encoder.Callback callback) {
            if ((packet.type == 2 || packet.type == 3) && HasBinary.hasBinary(packet.data)) {
                packet.type = packet.type == 2 ? 5 : 6;
            }
            if (IOParser.f59553a.isLoggable(Level.FINE)) {
                IOParser.f59553a.fine(String.format("encoding packet %s", new Object[]{packet}));
            }
            if (5 == packet.type || 6 == packet.type) {
                encodeAsBinary(packet, callback);
            } else {
                callback.call(new String[]{encodeAsString(packet)});
            }
        }

        private String encodeAsString(Packet packet) {
            StringBuilder sb = new StringBuilder("" + packet.type);
            if (5 == packet.type || 6 == packet.type) {
                sb.append(packet.attachments);
                sb.append("-");
            }
            if (!(packet.nsp == null || packet.nsp.length() == 0 || "/".equals(packet.nsp))) {
                sb.append(packet.nsp);
                sb.append(",");
            }
            if (packet.f59554id >= 0) {
                sb.append(packet.f59554id);
            }
            if (packet.data != null) {
                sb.append(packet.data);
            }
            if (IOParser.f59553a.isLoggable(Level.FINE)) {
                IOParser.f59553a.fine(String.format("encoded %s as %s", new Object[]{packet, sb}));
            }
            return sb.toString();
        }

        private void encodeAsBinary(Packet packet, Parser.Encoder.Callback callback) {
            Binary.DeconstructedPacket deconstructPacket = Binary.deconstructPacket(packet);
            String encodeAsString = encodeAsString(deconstructPacket.packet);
            ArrayList arrayList = new ArrayList(Arrays.asList(deconstructPacket.buffers));
            arrayList.add(0, encodeAsString);
            callback.call(arrayList.toArray());
        }
    }

    /* renamed from: io.socket.parser.IOParser$Decoder */
    public static final class Decoder implements Parser.Decoder {
        private Parser.Decoder.Callback onDecodedCallback;
        BinaryReconstructor reconstructor = null;

        public void add(String str) {
            Parser.Decoder.Callback callback;
            Packet decodeString = decodeString(str);
            if (5 == decodeString.type || 6 == decodeString.type) {
                BinaryReconstructor binaryReconstructor = new BinaryReconstructor(decodeString);
                this.reconstructor = binaryReconstructor;
                if (binaryReconstructor.reconPack.attachments == 0 && (callback = this.onDecodedCallback) != null) {
                    callback.call(decodeString);
                    return;
                }
                return;
            }
            Parser.Decoder.Callback callback2 = this.onDecodedCallback;
            if (callback2 != null) {
                callback2.call(decodeString);
            }
        }

        public void add(byte[] bArr) {
            BinaryReconstructor binaryReconstructor = this.reconstructor;
            if (binaryReconstructor != null) {
                Packet takeBinaryData = binaryReconstructor.takeBinaryData(bArr);
                if (takeBinaryData != null) {
                    this.reconstructor = null;
                    Parser.Decoder.Callback callback = this.onDecodedCallback;
                    if (callback != null) {
                        callback.call(takeBinaryData);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("got binary data when not reconstructing a packet");
        }

        private static Packet decodeString(String str) {
            int i;
            int length = str.length();
            Packet packet = new Packet(Character.getNumericValue(str.charAt(0)));
            if (packet.type < 0 || packet.type > Parser.types.length - 1) {
                return IOParser.m42068c();
            }
            if (5 != packet.type && 6 != packet.type) {
                i = 0;
            } else if (!str.contains("-") || length <= 1) {
                return IOParser.m42068c();
            } else {
                StringBuilder sb = new StringBuilder();
                i = 0;
                while (true) {
                    i++;
                    if (str.charAt(i) == '-') {
                        break;
                    }
                    sb.append(str.charAt(i));
                }
                packet.attachments = Integer.parseInt(sb.toString());
            }
            int i2 = i + 1;
            if (length <= i2 || '/' != str.charAt(i2)) {
                packet.nsp = "/";
            } else {
                StringBuilder sb2 = new StringBuilder();
                do {
                    i++;
                    char charAt = str.charAt(i);
                    if (',' == charAt) {
                        break;
                    }
                    sb2.append(charAt);
                } while (i + 1 != length);
                packet.nsp = sb2.toString();
            }
            int i3 = i + 1;
            if (length > i3 && Character.getNumericValue(Character.valueOf(str.charAt(i3)).charValue()) > -1) {
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    i++;
                    char charAt2 = str.charAt(i);
                    if (Character.getNumericValue(charAt2) < 0) {
                        i--;
                        break;
                    }
                    sb3.append(charAt2);
                    

                    /* renamed from: io.socket.parser.IOParser$BinaryReconstructor */
                    static class BinaryReconstructor {
                        List<byte[]> buffers = new ArrayList();
                        public Packet reconPack;

                        BinaryReconstructor(Packet packet) {
                            this.reconPack = packet;
                        }

                        public Packet takeBinaryData(byte[] bArr) {
                            this.buffers.add(bArr);
                            if (this.buffers.size() != this.reconPack.attachments) {
                                return null;
                            }
                            Packet packet = this.reconPack;
                            List<byte[]> list = this.buffers;
                            Packet reconstructPacket = Binary.reconstructPacket(packet, (byte[][]) list.toArray(new byte[list.size()][]));
                            finishReconstruction();
                            return reconstructPacket;
                        }

                        public void finishReconstruction() {
                            this.reconPack = null;
                            this.buffers = new ArrayList();
                        }
                    }
                }
