package com.sanda.chrome.freelancehunt.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by cdc89 on 01.11.2016.
 */
public class SecurityApi {
    private String id = "4081713798140373 ";
    private String login = "cdc895642";//usage the same as id
    private String secretKeyString = "d08775a03e89b825b672ce1cd5bbfb8804403838";

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String sign(String initbase64String) {
        Mac sha256_HMAC = null;
        String hash = null;
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKeyString.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            hash = Base64.encodeBase64String(sha256_HMAC.doFinal(initbase64String.getBytes()));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return hash;
    }
}
