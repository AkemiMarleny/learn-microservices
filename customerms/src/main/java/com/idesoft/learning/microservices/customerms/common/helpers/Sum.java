package com.idesoft.learning.microservices.customerms.common.helpers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.DigestUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sum {

    public static String fromContent(String content) {
        return DigestUtils.md5DigestAsHex(content.getBytes());
    }
}
