package com.zsx;

/**
 * @date 2022/12/24
 */
public class AddressPerent {

    private Address address;


    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        //return address;
        // 保证Address成员变量不会被外部修改
        return address.clone();
    }
}
