package com.lou.weixin.sdk.bean.sign;

@SuppressWarnings("serial")
public class AesException extends Exception {

    public final static int OK = 0;
    public final static int VALIDATE_SIGNATURE_ERROR = -40001;
    final static int PARSE_XML_ERROR = -40002;
    final static int COMPUTE_SIGNATURE_ERROR = -40003;
    public final static int ILLEGAL_AES_KEY = -40004;
    final static int VALIDATE_APPID_ERROR = -40005;
    final static int ENCRYPT_AES_ERROR = -40006;
    final static int DECRYPT_AES_ERROR = -40007;
    final static int ILLEGAL_BUFFER = -40008;

    private int code;

    private static String getMessage(int code) {
        switch (code) {
            case VALIDATE_SIGNATURE_ERROR:
                return "签名验证错误";
            case PARSE_XML_ERROR:
                return "xml解析失败";
            case COMPUTE_SIGNATURE_ERROR:
                return "sha加密生成签名失败";
            case ILLEGAL_AES_KEY:
                return "SymmetricKey非法";
            case VALIDATE_APPID_ERROR:
                return "appid校验失败";
            case ENCRYPT_AES_ERROR:
                return "aes加密失败";
            case DECRYPT_AES_ERROR:
                return "aes解密失败";
            case ILLEGAL_BUFFER:
                return "解密后得到的buffer非法";
            default:
                return null;
        }
    }

    public int getCode() {
        return code;
    }

    AesException(int code) {
        super(getMessage(code));
        this.code = code;
    }

}
