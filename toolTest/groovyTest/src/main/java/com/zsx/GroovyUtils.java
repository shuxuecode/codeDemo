package com.zsx;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
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
