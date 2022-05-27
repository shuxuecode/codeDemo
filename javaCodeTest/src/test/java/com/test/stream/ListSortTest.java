package com.test.stream;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 * @date 2022/5/27
 */
public class ListSortTest {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    void BeforeEach() {

        list.add(new User(1, "1----", getDate("2022-05-20 12:00:00")));
        list.add(new User(2, "22---", getDate("2022-05-19 11:00:00")));
        list.add(new User(2, "22---", getDate("2022-05-19 12:00:00")));
        list.add(new User(2, "22---", getDate("2022-05-19 15:00:00")));
        list.add(new User(3, "333--", getDate("2022-05-25 12:00:00")));
        list.add(new User(4, "4444-", getDate("2022-05-02 12:00:00")));
        list.add(new User(5, "55555", getDate("2022-05-30 12:00:00")));


    }

    List<User> list = new ArrayList<>();

    @Test
    void t1() {
        //List<User> res = list.stream().sorted(Comparator.comparing(User::getCreateDate)).collect(Collectors.toList());
        //List<User> res = list.stream().sorted(Comparator.comparing(User::getCreateDate).reversed()).collect(Collectors.toList());
        List<User> res = list.stream()
                //
                .sorted(Comparator.comparing(User::getCreateDate, Comparator.reverseOrder()))
                //
                .filter(item -> item.getId().equals(2) && item.getCreateDate().after(getDate("2022-05-19 11:00:00")))
                //
                //.filter(item -> item.getCreateDate().after(getDate("2022-05-19 11:00:00")))
                //
                .collect(Collectors.toList());

        System.out.println(8899);
        for (User user : res) {
            System.out.println(user);
        }
    }

    @Test
    void t2() {
        List<User> res = null;
        res = ttt1(res);
        res = ttt2(res);

    }

    private List<User> ttt1(List<User> res) {
        System.out.println(res);
        if (res == null) {
            res = new ArrayList<>();
            res.add(new User(1, "1----", getDate("2022-05-20 12:00:00")));
        }
        return res;
    }

    private List<User> ttt2(List<User> res) {
        System.out.println(res);
        if (res == null) {
            res = new ArrayList<>();
            res.add(new User(1, "222----", getDate("2022-05-20 12:00:00")));
        }
        return res;
    }

    private static Date getDate(String str) {
        Instant instant = LocalDateTime.parse(str, dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    class User {
        private Integer id;
        private String name;
        private Date createDate;

        public User() {
        }

        public User(Integer id, String name, Date createDate) {
            this.id = id;
            this.name = name;
            this.createDate = createDate;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + ", createDate=" + LocalDateTime.ofInstant(createDate.toInstant(), ZoneId.systemDefault()).format(dateTimeFormatter) + '}';
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

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }
    }
}
