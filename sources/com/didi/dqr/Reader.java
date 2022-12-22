package com.didi.dqr;

public interface Reader {
    Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException;

    Result decode(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
