package tool.fastjson.model;

import java.util.List;

/**
 * @date 2022/6/17
 */
public class Parent {

    private int id;

    private String name;

    private List<Children> children;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
