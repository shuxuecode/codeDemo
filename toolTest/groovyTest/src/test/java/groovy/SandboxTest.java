package groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.ast.stmt.WhileStatement;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.SecureASTCustomizer;
import org.codehaus.groovy.syntax.Types;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2023/5/22
 */
public class SandboxTest {



    @Test
    void t1(){

        SecureASTCustomizer secureASTCustomizer = new SecureASTCustomizer();
        // 禁止使用闭包
        secureASTCustomizer.setClosuresAllowed(true);

        ArrayList<Integer> tokenBlackList = new ArrayList<>();
        // 添加关键字黑名单 while和goto
        tokenBlackList.add(Types.KEYWORD_WHILE);
        tokenBlackList.add(Types.KEYWORD_GOTO);
        secureASTCustomizer.setTokensBlacklist(tokenBlackList);
        // 设置直接导入检查
        secureASTCustomizer.setIndirectImportCheckEnabled(true);

        ArrayList<String> importBlackList = new ArrayList<>();
        // 添加导入黑名单，用户不能导入 fastjson
        importBlackList.add("com.alibaba.fastjson.JSON");
        secureASTCustomizer.setImportsBlacklist(importBlackList);

        ArrayList<Class<? extends Statement>> disallowedStatements = new ArrayList<>();
        // statement 黑名单，不能使用while循环块
        disallowedStatements.add(WhileStatement.class);
        secureASTCustomizer.setStatementsBlacklist(disallowedStatements);

        // 自定义CompilerConfiguration，设置AST
        CompilerConfiguration compilerConfiguration = new CompilerConfiguration();
        compilerConfiguration.addCompilationCustomizers(secureASTCustomizer);


        GroovyShell groovyShell = new GroovyShell(compilerConfiguration);

        Script script = groovyShell.parse("a+b");

        HashMap<String, Object> param = new HashMap<>();
        param.put("a", 1);
        param.put("b", 2);

        Binding binding = new Binding(param);

        script.setBinding(binding);

        Object res = script.run();

        System.out.println(res);
    }

}
