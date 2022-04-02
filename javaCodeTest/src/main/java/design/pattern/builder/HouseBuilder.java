package design.pattern.builder;

import design.pattern.builder.model.House;

/**
 * 抽象的建造者 builder
 *
 * @author 
 * @date 2022/4/2
 */
public abstract class HouseBuilder {

    public House house = new House();

    // 建造的流程写好，抽象的方法
    public abstract void buildBasic();

    public abstract void buildWall();

    public abstract void roofed();

    // 建好后返回对象
    public House buildHouse() {
        return house;
    }

}
