package design.pattern.builder;

import design.pattern.builder.model.House;

/**
 * 指挥者 director
 * 动态指定 制作流程
 *
 * @author 
 * @date 2022/4/2
 */
public class HouseDirector {

    HouseBuilder houseBuilder = null;

    // 空参构造器
    public HouseDirector() {
    }

    // set 传入 builder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造的流程，交给指挥者
    public House constructorHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
