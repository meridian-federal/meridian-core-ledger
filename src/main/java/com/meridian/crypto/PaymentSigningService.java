package com.meridian.crypto;

import javax.crypto.Cipher;
import java.security.MessageDigest;
import java.security.Signature;

/**
 * Payment signing service.
 *
 * Algorithm names are read from configuration so they can be rotated
 * without a redeploy. This is a known pain point for the PQC migration —
 * static analysis cannot resolve the algorithm name without dataflow.
 */
public class PaymentSigningService {
    private final String signatureAlgorithm;
    private final String fingerprintAlgorithm;
    private final String cipherAlgorithm;

    public PaymentSigningService(PaymentCryptoConfig cfg) {
        this.signatureAlgorithm = cfg.getSignatureAlgorithm();
        this.fingerprintAlgorithm = cfg.getFingerprintAlgorithm();
        this.cipherAlgorithm = cfg.getCipherAlgorithm();
    }

    public byte[] sign(byte[] payload, java.security.PrivateKey key) throws Exception {
        Signature s = Signature.getInstance(signatureAlgorithm);
        s.initSign(key);
        s.update(payload);
        return s.sign();
    }

    public byte[] fingerprint(byte[] payload) throws Exception {
        MessageDigest md = MessageDigest.getInstance(fingerprintAlgorithm);
        return md.digest(payload);
    }

    public Cipher cipher() throws Exception {
        return Cipher.getInstance(cipherAlgorithm);
    }
}
