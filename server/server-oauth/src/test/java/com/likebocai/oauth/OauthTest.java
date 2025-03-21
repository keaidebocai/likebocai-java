package com.likebocai.oauth;

import com.likebocai.common.utils.AESUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;

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
        // 1741245931284
        System.out.println("获取到时间戳了: " + epochMilli);
        // 获取 AES加密的key
        SecretKeySpec key = AESUtils.getSecretKeySpec128(epochMilli);
        // 获取 AES加密的iv
        IvParameterSpec iv = AESUtils.getIvParameterSpec128(epochMilli);
        // 加密 decrypted
        String decrypted = AESUtils.encrypt128(text, key, iv);
        // n7bevC0+v5q1XFR21XfgRg==
        System.out.println("密文: " + decrypted);
        // 解密
        String plainText = AESUtils.decrypt128(decrypted, key, iv);
        System.out.println("原文: " + plainText);
    }

}
