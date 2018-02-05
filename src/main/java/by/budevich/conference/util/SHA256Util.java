package by.budevich.conference.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util {
    private static final String SALT = "Salt12@$@4&#%^$*";

    public static String encrypt(String password){
        return DigestUtils.sha256Hex(password + SALT);
    }
}