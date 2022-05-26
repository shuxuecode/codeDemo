package com.test.stream;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 * @date 2022/5/24
 */
public class ListToTree {


    @Test
    void t1() {
        TreeNode node1 = new TreeNode(1, "root", 0);
        TreeNode node2 = new TreeNode(2, "2-pid-1", 1);
        TreeNode node3 = new TreeNode(3, "3-pid-1", 1);
        TreeNode node4 = new TreeNode(4, "4-pid-2", 2);
        TreeNode node5 = new TreeNode(5, "5-pid-3", 3);

        List<TreeNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);

        List<TreeNode> tree = tree(list, 0);

        System.out.println(JSON.toJSONString(tree, JSONWriter.Feature.PrettyFormat));


    }

    private static List<TreeNode> tree(List<TreeNode> list, Integer pid) {
        //return list.stream()
        //        // 过滤父节点
        //        .filter(item -> item.getPid().equals(pid))
        //        // 把父节点children递归赋值成为子节点
        //        .map(item -> {
        //            item.setChildren(tree(list, item.getId()));
        //            return item;
        //        }).collect(Collectors.toList());

        // todo
        return list.stream()
                // 过滤父节点
                .filter(item -> item.getPid().equals(pid))
                // 把父节点children递归赋值成为子节点
                .peek(item -> item.setChildren(tree(list, item.getId()))).collect(Collectors.toList());

    }

}

class TreeNode {
    private Integer id;
    private String name;
    private Integer pid;
    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(Integer id, String name, Integer pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
