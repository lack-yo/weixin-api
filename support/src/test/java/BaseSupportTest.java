import com.lou.weixin.constants.WxUrl;
import com.lou.weixin.model.WxToken;
import com.lou.weixin.util.HttpUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * @author loufeng
 * @date 2017/7/11 下午4:03.
 */
public class BaseSupportTest {

    @Test
    public void testToken() throws IOException {
        String appid = "wx1a31061c4aea3b52";
        String secret = "8d7ad75e0bc309f6fe947e6cfa1b20aa";
        String url = WxUrl.ACCESS_URL.replace("APPID", appid).replace("APPSECRET",secret);
        WxToken token = HttpUtil.get(url,WxToken.class);
        System.out.println(token);
    }
}
