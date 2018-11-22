package com.wangwei.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther wangwei
 * @Date 2018/11/13 2:23 PM
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("wangi", "wogj", "3ljls", "osgl", "1ljl");
        for (String s : list) {
            if (Character.isDigit(s.charAt(0)))
                System.out.println(s);
        }

        /**
         * lambda写法
         */
        list.stream()
                .filter(str -> Character.isDigit(str.charAt(0)))
                .forEach(str -> System.out.println(str));

        /**
         * 选出所有不以数字开头的字符串，将其转换成大写形式，并把结果放到新的集合当中
         */
        list.stream()
                .filter(str -> !Character.isDigit(str.charAt(0)))
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

    }
}
