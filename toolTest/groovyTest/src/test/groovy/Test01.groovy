package groovy

import com.google.common.collect.Lists;

/**
 * 静态变量
 */
class Globals {
    static String str = "abc";
}


def Test01() {

    def list = Lists.newArrayList("1", "2", "3")

    return list;

}
