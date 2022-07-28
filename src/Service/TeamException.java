package Service;

/**
 * @author gengzeyu
 * @version 1.0
 * @description: 自定义异常类
 * @date 2022.07.26 23:50:56
 */

public class TeamException extends RuntimeException {
    public static final long serialVersionUID=-464664644446L;

    public TeamException() {
        super();
    }
    public TeamException(String message) {
        super(message);
    }
}
