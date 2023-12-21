package ru.mironov.tokengenerator.repository;

import org.springframework.stereotype.Component;
import ru.mironov.tokengenerator.model.ApplicationName;
import ru.mironov.tokengenerator.repository.model.TokenModel;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Component
public class TokenRepository {

    public Optional<TokenModel> getToken(ApplicationName applicationName, String login, String password) {
        return Optional.of(new TokenModel(encrypt(applicationName.toString() + ":" + login + ":" + password)));
    }


    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec("encryptionIntVec".getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec("aesEncryptionKey".getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
