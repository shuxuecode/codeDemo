package design.pattern.builder.test;

import design.pattern.builder.impl.CommonHouse;
import design.pattern.builder.impl.HighBuilding;
import design.pattern.builder.HouseDirector;

/**
 * 测试类
 *
 * @author 
 * @date 2022/4/2
 */
public class BuilderTest {

    public static void main(String[] args) {
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector();

        // 盖高层
        HighBuilding highBuilding = new HighBuilding();

        // 重置建造者
        houseDirector.setHouseBuilder(highBuilding);

        // 完成后返回高层
        houseDirector.constructorHouse();


        /*
        下面是建造普通房子
         */
        CommonHouse commonHouse = new CommonHouse();

        houseDirector.setHouseBuilder(commonHouse);

        houseDirector.constructorHouse();

    }

}
