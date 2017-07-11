
/**
 * Title:操作byte数组
 * Description:Java中byte用二进制表示占用8位，而我们知道16进制的每个字符需要用4位二进制位来表示（23 + 22 + 21 + 20 = 15），所以我们就可以把每个byte转换成两个相应的16进制字符，即把byte的高4位和低4位分别转换成相应的16进制字符H和L，并组合起来得到byte转换到16进制字符串的结果new String(H) + new String(L)。即byte用十六进制表示只占2位。
 * 同理，相反的转换也是将两个16进制字符转换成一个byte，原理同上。
 * 根据以上原理，我们就可以将byte[] 数组转换为16进制字符串了，当然也可以将16进制字符串转换为byte[]数组了。
 * Author:
 * Encode:UTF-8
 * Create Date:2017-07-03
 * Modify User:
 * Modify Date:
 * Modify Description:
 */
public class ByteTool {
    /**
     * @param src 16进制字符串 转ASCII
     * @return 字节数组
     * @throws
     * @Title:hexString2String
     * @Description:16进制字符串转字符串
     */
    public static String hexString2String(String src) {
        String temp = "";
        for (int i = 0; i < src.length() / 2; i++) {
            temp = temp + (char) Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return temp;
    }

    /**
     * 将byte数组转换为16进制字符串
     *
     * @param src 待转换的byte数组
     * @return 16进制字符串
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString().toUpperCase();
    }

    /**
     * 将16进制字符串转换为byte数组
     *
     * @param hexString 待转换的16进制字符串
     * @return byte数组
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * 将16进制字符转换为byte
     *
     * @param c 16进制字符
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
