package com.zsx;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * groovy每执行一次脚本都会new一个InnerLoader去加载这个对象，而对于问题2，我们可以推测：InnerLoader和脚本对象都无法在fullGC的时候被回收，因此运行一段时间后将PERM占满，一直触发fullGC。
 * 优化方案：把每次脚本生成的对象缓存起来，用md5算法生成脚本的md5作为key，缓存groovyClass 对象。
 *
 * @date 2023/2/24
 */
public class GroovyUtils {

    private static GroovyShell groovyShell = new GroovyShell();

    private static Map<String, Script> scriptCache = new ConcurrentHashMap<>();

    public static <T> T invoke(String scriptText, String function, Object... objects) {
        Script script;

        String cacheKey = DigestUtils.md5DigestAsHex(scriptText.getBytes(StandardCharsets.UTF_8));

        if (scriptCache.containsKey(cacheKey)) {
            script = scriptCache.get(cacheKey);
        } else {
            script = groovyShell.parse(scriptText);
            scriptCache.put(cacheKey, script);
        }

        return (T) InvokerHelper.invokeMethod(script, function, objects);
    }

}
