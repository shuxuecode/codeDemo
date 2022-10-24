package functioninterface.action;

/**
 * @date 2022/10/24
 */
public interface Action<T> {

    public T action() throws Throwable;
}
