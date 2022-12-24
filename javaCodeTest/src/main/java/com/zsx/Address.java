package com.zsx;

/**
 * 不可变对象
 * @date 2022/12/24
 */
public class Address implements Cloneable {


    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }



}
