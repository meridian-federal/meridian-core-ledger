package com.meridian.crypto;

public class PaymentCryptoConfig {
    private final String signatureAlgorithm = "SHA256withRSA";
    private final String fingerprintAlgorithm = "SHA-256";
    private final String cipherAlgorithm = "RSA/ECB/PKCS1Padding";

    public String getSignatureAlgorithm() { return signatureAlgorithm; }
    public String getFingerprintAlgorithm() { return fingerprintAlgorithm; }
    public String getCipherAlgorithm() { return cipherAlgorithm; }
}
