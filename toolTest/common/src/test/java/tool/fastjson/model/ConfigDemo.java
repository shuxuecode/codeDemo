package tool.fastjson.model;

import java.util.List;

/**
 * @date 2022/6/30
 */
public class ConfigDemo {

    private Integer id;
    private String code;

    private ConfigTest configTest;
    public static class ConfigTest {
        private List<String> list;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }


    public ConfigTest ge2tMyConfigTest() {
        Integer.valueOf("a");
        return null;
    }

    // get set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ConfigTest getConfigTest() {
        return configTest;
    }

    public void setConfigTest(ConfigTest configTest) {
        this.configTest = configTest;
    }
}
