package wordroot.wr.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wuliang
 * @date 2020/8/6
 */

@Data
@ApiModel(description = "文章")
public class Article {

    private int  id;
    @ApiModelProperty(value = "文章内容", example = "If your life feels like it is lacking the power that you want and the motivation that you need, sometimes all you have to do is shift your point of view.")
    private String en_text;
    @ApiModelProperty(value = "翻译之后内容",example = "如果你觉得心有余力不足，觉得缺乏前进的动力，有时候你只需要改变思维的角度。")
    private String cn_text;
    @ApiModelProperty(value = "文章创建时间", example = "2020-8-6")
    private Date gmt_create;
    @ApiModelProperty(value = "文章修改时间",example = "2020-8-9")
    private Date gmt_modified;
}
