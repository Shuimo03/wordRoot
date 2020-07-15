package worldroot.wr.result;

/**
 * @author wuliang
 * @date 2020/7/10
 * update: 2020/7/13
 */
public class Result {

    private int code;
    private  String message;
    private Object result;

   public Result(int code){
        this.code = code;
        this.message = message;
   }
}
