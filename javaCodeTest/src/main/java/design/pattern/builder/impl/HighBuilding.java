package design.pattern.builder.impl;

import design.pattern.builder.HouseBuilder;

/**
 * 建造一个高层房子
 *
 * @author 
 * @date 2022/4/2
 */
public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("高层房子开始打地基");
    }

    @Override
    public void buildWall() {
        System.out.println("高层房子开始建墙壁");

    }

    @Override
    public void roofed() {
        System.out.println("高层房子开始封顶");

    }
}
