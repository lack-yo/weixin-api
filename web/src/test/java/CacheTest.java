import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.CacheService;

/**
 * @author loufeng
 * @date 2017/7/9 下午5:01.
 */
public class CacheTest extends BaseTest {
    @Autowired
    private CacheService cacheService;
    @Test
    public void testSet(){
        String key = "test1";
        cacheService.setString(key, "this is the value");
        System.out.println("@@@@@@@@@@@@@@@@" + cacheService.getString(key));

    }
}
