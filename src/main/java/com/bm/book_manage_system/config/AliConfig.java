package com.bm.book_manage_system.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AliConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092900620326";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDBLvaCZxxGhvFJN7asrsYEV0tmZTHwa5dmlv2Ux0sOvYe/cCNbvTdcsJI8bEIRlzTd+NzDMCEAtHgNXHchEQ04ihuJRqfUTHoGDVwrVsFPOnDIwVwl8Q7Rj9nDqVieUNt7CfR2nRejXf3uTUpGDTGjCURyUDbO3J+yZ20Ef4x6kYjt1enVFAnQjWjC20K1pN/eS3qS65PJw6jvHM69amzQ9WnLZhFNmDNESK4ZD2NbcoNYw5tDrXZMPL5ZxLYKCnpDowq1QcH24m7MOe2SW53TMlWl5yFB50VSbdsbZpiK3S8JgvHUvYJPGHO4rLf08E+D24g16JQ2Vq2LZxnoIfxXAgMBAAECggEARhoqriuIoTc6u90R1xwdE1oyLFgwhRQl/r5wCts/K3wvlJK24gWJ34Lbrj2CxCtgreQvCE2gzEaxAfg56q/rYkcLswcGxA10glm6xqdWws9sOg2gyMvvGrDezxfW5qxk2QNFyP08pLXo/d7iQwVqq8UjJ3BgUzTQZscNUoKOkbM348/4ArPNxftbMN5ZtwGwGg2nIZiIpFGBkz0t4g6I658UMqu7f8F5XaG3Jx+BLo/Ufjx0AdnRoqAal2FQtrdNmajNj2VUERV6TxaaeTu4WdLsiTaYfdAWUFhQti4myBi8/MMqg/m4GAzHzUbnK/P4r9sUx3SiDrqFm+KtNkOS0QKBgQD4Li9lSYbvItEqrdtP0KyKCg9+NoCq7KFf6BUUPlTJbpwNzfMuATZ8ewxAZDW9UiZ58mxOQqumqONkGZinbibGA9KWhqD2Ubd5OwoCdBuEvQeVqxQ+saNyjqaUMAEAM7Z/jZXAzaQV2hJlrO+w2o3b/0Oc4Ffgo8kbJ9k9vpQgowKBgQDHRSyUfaVBJzBr2ZtGALorYHnj3oUxn00mgjXaUwgsEcQ1isljnbUVVDyHGfxfE44vApDjULr8kGgLLj1SfTtuUCZ93jVJN//t9hrTKIR/71uz5o2LLGLd2PTBlfYAIOdK8xZXSzbU1OdmOkE11UO4/ld/fYH1m8LaKWxOYmzMvQKBgQCz2ZxlNVyAjeWwnR8yfxGaU2IY39xsgWEMxH4KFoWRGAQlCNuyuhRHL1CYlUZQdWkGtISCTlRgSUHIN7hllTCqDPkeNmANQPjJ9NvzHTsX/XiyoLDiIg9FpFTZTNRc1hzp4Kvmdd/0Kf1tC18D9c4Z4KmZ1QY599d0Q3NuCF8GKwKBgD8yAOFWt4HiG8kYSdX5hREcl4tcloEWNDFyOgHzMzRGriMM0LF24mbRQCDYbOD6Iq1l8u0kPSi740ModuoiLSbe5FYmkl+WEuQ0mG0+/EZWco6rH1hzyybwFy8Nj+aaiL+MOBmXENyOaJRTBTs9Vyzj/HvCIeTycOkfGeoB7N9BAoGBAMSnyC8jgEMIO+lL+JDLKasKJNVH9sUGPh5OMd3hBo5dSFxu4UlLEnbq8iU6p8ZADVbUOYotB1cYYh1XX08/ZIjG23VlQbC/GIVVANwzzDpc9R+qTiQzdy/s5xpn9x0yFW9scv8YKx4B1z7C9p7p5Cf6NOCXDiwW/M/5pfpH3TyO";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwS72gmccRobxSTe2rK7GBFdLZmUx8GuXZpb9lMdLDr2Hv3AjW703XLCSPGxCEZc03fjcwzAhALR4DVx3IRENOIobiUan1Ex6Bg1cK1bBTzpwyMFcJfEO0Y/Zw6lYnlDbewn0dp0Xo1397k1KRg0xowlEclA2ztyfsmdtBH+MepGI7dXp1RQJ0I1owttCtaTf3kt6kuuTycOo7xzOvWps0PVpy2YRTZgzREiuGQ9jW3KDWMObQ612TDy+WcS2Cgp6Q6MKtUHB9uJuzDntklud0zJVpechQedFUm3bG2aYit0vCYLx1L2CTxhzuKy39PBPg9uINeiUNlati2cZ6CH8VwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://6hrr33.natappfree.cc/order/recharge/notifyFallback";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://6hrr33.natappfree.cc/order/recharge/synchronousFallback";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关---固定的
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "UTF-8";

    // 支付宝网关
    public static String log_path = "C:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
