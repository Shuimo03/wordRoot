package wordroot.wr.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("词根")
public class WordRoot {
    private int id;
    @ApiModelProperty(value = "词根", example = "-ing/-ed/-radi-,-ray-,-rad-,-radio- = ray,beam 光线,辐射")
    private String root;
    @ApiModelProperty(value = "单词创建时间", example = "2020-8-6")
    private Date gmt_create;
    @ApiModelProperty(value = "单词修改时间",example = "2020-8-9")
    private Date gmt_modified;
}
