import com.alibaba.fastjson.JSON;
import com.zsx.springtest.dto.DemoDTO;
import com.zsx.springtest.vo.DemoVO;
import org.junit.jupiter.api.Test;

import org.springframework.beans.BeanUtils;

/**
 * @date 2022/12/27
 */
public class SpringBeanUtilsTest {

    @Test
    void t1() {
        DemoVO demoVO = new DemoVO();
        demoVO.setId(1);
        demoVO.setName("test");
        //demoVO.setAge(18); // 这种有值的，可以正常转换
        demoVO.setAge(null);
        /*
        上面这种包装类型转基本类型就会报异常：
org.springframework.beans.FatalBeanException: Could not copy property 'age' from source to target; nested exception is java.lang.IllegalArgumentException
        这个就是使用BeanUtils.copyProperties的坑
         */

        DemoDTO demoDTO = new DemoDTO();

        BeanUtils.copyProperties(demoVO, demoDTO);

        System.out.println(JSON.toJSONString(demoDTO));

    }

}
