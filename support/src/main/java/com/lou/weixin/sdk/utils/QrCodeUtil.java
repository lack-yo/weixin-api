package com.lou.weixin.sdk.utils;

import com.google.common.collect.Maps;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/**
 * @author loufeng
 * @date 2017/6/27 上午9:20.
 * 解析二维码工具类
 */
@SuppressWarnings("unused")
public class QrCodeUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(QrCodeUtil.class);

    private static final Map<EncodeHintType, Object> ENCODE_HINTS;

    static {
        ENCODE_HINTS = Maps.newHashMapWithExpectedSize(1);
        ENCODE_HINTS.put(EncodeHintType.CHARACTER_SET, "utf-8");
        ENCODE_HINTS.put(EncodeHintType.MARGIN, 0);
    }

    /**
     * 读取二维码文件，返回包含的text内容
     *
     * @param file 二维码文件
     * @return 返回包含的text内容
     */
    public static String read(File file) {
        String url = "";
        try {
            BufferedImage image = ImageIO.read(file);
            url = getQrcodeUrl(image);
        } catch (Exception e) {
            LOGGER.error("qrCode读取失败", e);
        }
        return url;
    }

    /**
     * 读取二维码文件，返回包含的text内容
     *
     * @param is 二维码文件
     * @return 返回包含的text内容
     */
    public static String read(InputStream is) {
        String url = "";
        try {
            BufferedImage image = ImageIO.read(is);
            url = getQrcodeUrl(image);
        } catch (Exception e) {
            LOGGER.error("qrCode读取失败", e);
        }
        return url;
    }

    /**
     * 根据 content 生成二维码
     * @param content 内容
     * @param width 宽度
     * @param height 高度
     * @return 二维码
     */
    public static BufferedImage write(String content, int width, int height) {
        try {
            BitMatrix matrix = new QRCodeWriter()
                .encode(content, BarcodeFormat.QR_CODE, width, height, ENCODE_HINTS);
            return createImage(matrix, width, height);
        } catch (WriterException e) {
            LOGGER.error("QrCodeUtil_write: content={}; 生成二维码失败", content, e);
        }
        return null;
    }

    private static BufferedImage createImage(BitMatrix bitMatrix, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        return image;
    }

    private static String getQrcodeUrl(BufferedImage image) throws NotFoundException, ChecksumException, FormatException {
        QRCodeReader reader = new QRCodeReader();
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = reader.decode(bitmap);
        //二维码地址
        return result.getText();
    }
}
