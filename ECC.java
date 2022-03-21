package ECC;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author WangJS
 * @Date 2022/3/21 2:43 下午
 * @Version 1.0
 */
public class RSADemo {
    public static byte[] encode(int max, int pub, byte[] bs) {
        // 公钥加密
        byte[] encoded = new byte[bs.length];
        int idx = 0;
        for(byte b : bs) {
            int encode = b;
            for(int i = 1; i < pub; i++) {
                encode *= b;
                encode %= max;
            }
            encoded[idx++] = (byte) encode;
        }
        System.out.println(new String(encoded));
        return encoded;
    }
    public static byte[] decode(int max, int priv, byte[] encoded) {
        // 私钥解密
        byte[] decoded = new byte[encoded.length];
        int idx = 0;
        for(byte b : encoded) {
            int dec = b;
            for(int i = 1; i < priv; i++) {
                dec *= b;
                dec %= max;
            }
            decoded[idx++] = (byte) dec;
        }
        System.out.println(new String(decoded));
        return decoded;
    }
    public static void main(String[] args) {
        int pub = 5;
        int priv = 29;
        int max = 91;
        String s = "CLOUD";
        byte[] bs = s.getBytes(StandardCharsets.UTF_8);
        byte[] encoded = encode(max, pub, bs);
        System.out.println(Arrays.toString(encoded));
        byte[] decoded = decode(max, priv, encoded);
        System.out.println(Arrays.toString(decoded));
   }
}
