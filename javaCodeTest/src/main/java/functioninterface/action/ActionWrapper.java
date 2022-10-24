package functioninterface.action;

/**
 * @date 2022/10/24
 */
public class ActionWrapper {

    public static <T> T wrapper(Action<T> action) {
        try {
            T result = action.action();
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
