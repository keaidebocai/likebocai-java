package com.likebocai.common.utils;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @program: likebocai-java
 * @description: AES算法的相关操作
 * @author: LikeBocai
 * @create: 2024/12/10 15:29
 **/

public class AESUtils {

    /**
     * @author: LikeBocai
     * @description: 加密方法 key和iv都是128位
     * @param: [plainText, key, iv]
     * @return: java.lang.String
    **/
    public static String encrypt128(String plainText, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  // 使用CBC模式和PKCS5填充
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);  // 初始化为加密模式
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);  // 转换为Base64编码字符串
    }

    /**
     * @author: LikeBocai
     * @description: 解密方法 key和iv都是128位
     * @param: [cipherText, key, iv]
     * @return: java.lang.String
    **/
    public static String decrypt128(String cipherText, SecretKey key, IvParameterSpec iv) throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  // 使用CBC模式和PKCS5填充
        cipher.init(Cipher.DECRYPT_MODE, key, iv);  // 初始化为解密模式
        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);  // Base64解码
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted);  // 返回解密后的字符串
    }

    /**
     * @author: LikeBocai
     * @description: 输出16字节的加密串
     * @param: [input]
     * @return: byte[]
    **/
    public static byte[] md5EncryptR128(byte[] input) throws NoSuchAlgorithmException {
        // 创建 MessageDigest 实例，并指定 MD5 算法
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 对输入字符串进行加密
        byte[] hashBytes = md.digest(input);
        // 截取前16个字符
        return Arrays.copyOf(hashBytes, 16);
    }

    /**
     * @author: LikeBocai
     * @description: 根据加密关键信息获取AES的key值
     * @param: [plainText]
     * @return: javax.crypto.spec.SecretKeySpec
    **/
    public static SecretKeySpec getSecretKeySpec128(String keyString) throws NoSuchAlgorithmException {
        byte[] keyByte = md5EncryptR128(keyString.getBytes());
        // 通过字节数组生成 AES 密钥
        return new SecretKeySpec(keyByte, "AES");
    }
    /**
     * @author: LikeBocai
     * @description: 根据加密关键信息获取AES的iv值
     * @param: [ivString]
     * @return: javax.crypto.spec.IvParameterSpec
    **/
    public static IvParameterSpec getIvParameterSpec128(String ivString) throws Exception {
        byte[] ivByte = md5EncryptR128(md5EncryptR128(ivString.getBytes()));
        return new IvParameterSpec(ivByte);
    }
}
