package com.meridian.crypto;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;

/**
 * Legacy token issuer — pre-2018 code path, still serves ~3% of internal
 * service-to-service calls. Migration tracked as TICK-4421.
 */
public class LegacyTokenIssuer {

    public byte[] issueToken(byte[] payload, byte[] secret) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] fp = md5.digest(payload);

        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(secret, "HmacSHA1"));
        return mac.doFinal(fp);
    }

    public java.security.KeyPair generateRsaKeyPair() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        return kpg.generateKeyPair();
    }

    public Cipher tripleDesCipher() throws Exception {
        return Cipher.getInstance("DESede/CBC/PKCS5Padding");
    }
}
