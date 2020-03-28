package com.test.util;

public class StringUtil {
    public static final String UNDERLINE = "_";

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String toCamelCase(String name){
        if(name==null){
            return null;
        }

        if(name.contains(UNDERLINE)){
            name = name.toLowerCase();

            StringBuilder sb = new StringBuilder(name.length());
            boolean upperCase = false;
            for(int i=0;i<name.length();i++){
                char c = name.charAt(i);

                if(c=='_'){
                    upperCase = true;
                }else if(upperCase){
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                }else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }else {
            return name;
        }
    }

    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    public static String removePrefix(String str, String prefix) {
        if(isEmpty(str) || isEmpty(prefix)){
            return str;
        }

        if (str.startsWith(prefix)) {
            return str.substring(prefix.length());
        }
        return str;
    }

    public static Integer strToInt(String str,Integer defaultNum) {
        Integer num = defaultNum;
        try {
            num = Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return num;
    }
}
