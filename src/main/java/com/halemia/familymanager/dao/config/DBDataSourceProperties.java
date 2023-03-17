package com.halemia.familymanager.dao.config;

import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.asymmetric.RSA;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import java.security.KeyFactory;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 21:19
 */
public class DBDataSourceProperties extends DataSourceProperties {

    @Override
    public void setPassword(String password) {
        RSA rsa = new RSA();

        super.setPassword(password);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();
        String privateKey = rsa.getPrivateKeyBase64();
        String publicKey = rsa.getPublicKeyBase64();

        System.out.println(privateKey);
        System.out.println(publicKey);
    }
}
