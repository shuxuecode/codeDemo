package design.pattern.builder.impl;

import design.pattern.builder.HouseBuilder;

/**
 * 普通的房子
 *
 * @author 
 * @date 2022/4/2
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWall() {
        System.out.println("普通房子墙壁");

    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");

    }
}
