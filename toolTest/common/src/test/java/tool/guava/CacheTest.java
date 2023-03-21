package tool.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

/**
 * @date 2023/3/21
 */
public class CacheTest {

    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .build(
                    new CacheLoader<String, String>() {
                        @Override
                        public String load(String key) throws Exception {
                            System.out.println("传入的key=" + key);
                            return "test";
                        }
                    }
            );

    @Test
    void t1() throws ExecutionException {
        String value = cache.get("1");
        System.out.println(value);
    }

}
