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
@ApiModel("单词")
public class Word {

    private int id;
    @ApiModelProperty(value = "英文单词",example = "hello")
    private String word;
    @ApiModelProperty(value = "中文意思",example = "你好")
    private String cn_interpretation;
    @ApiModelProperty(value = "英文意思", example = "the call “hello” (used as an expression of greeting):\n" + "She gave me a warm hello.")
    private String en_interpretation;
    @ApiModelProperty(value = "单词创建时间", example = "2020-8-6")
    private Date gmt_create;
    @ApiModelProperty(value = "单词修改时间",example = "2020-8-9")
    private Date gmt_modified;
}
