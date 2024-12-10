package com.likebocai.oauth;

import com.likebocai.common.utils.AESUtils;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Base64;

/**
 * @program: likebocai-java
 * @description: 测试类
 * @author: LikeBocai
 * @create: 2024/12/10 14:54
 **/
@SpringBootTest
public class OauthTest {

    @Test
    public void test() throws Exception {
//        String text = "你好，现在是北京时间15:39分，欢迎收听你的月亮我的心，我是曾~小~贤~";
        String text = "你好，现在是北京时间";
        String epochMilli = String.valueOf(Instant.now().toEpochMilli());
        System.out.println("获取到时间戳了: " + epochMilli);
        // 获取 AES加密的key
        SecretKeySpec key = AESUtils.getSecretKeySpec128(epochMilli);
        // 获取 AES加密的iv
        IvParameterSpec iv = AESUtils.getIvParameterSpec128(epochMilli);
        // 加密 decrypted
        String decrypted = AESUtils.encrypt128(text, key, iv);
        System.out.println("密文: " + decrypted);
        // 解密
        String plainText = AESUtils.decrypt128(decrypted, key, iv);
        System.out.println("原文: " + plainText);
    }

}
