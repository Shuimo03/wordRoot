package wordroot.wr.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * auctor:wuliang
 * date:2020/7/15
 */

@ApiModel(description = "用户")

public class User {
    int id;
    @ApiModelProperty(value = "用户名",example = "test")
    private String username;
    @ApiModelProperty(value = "邮件",example = "test@qq.com or test@gmail.com")
    private String email;
    @ApiModelProperty(value = "密码",example = "不能少于16位，要大小写混写加数字,Test17787rrwsd")
    private String password;
    private Date gmt_create;
    private Date gmt_modified;
    private String salt;
    private String word;
    private String root;
    private String cn_interpretation;
    private String en_interpretation;
    private  boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getWord(){
        return  word;
    }

    public void setWord(String word){
        this.word = word;
    }


    public String getRoot(){
        return root;
    }

    public void setRoot(String root){
        this.root = root;
    }

    public String getCn_interpretation(){
        return cn_interpretation;
    }

    public void setCn_interpretation(String cn_interpretation) {
        this.cn_interpretation = cn_interpretation;
    }

    public String getEn_interpretation(){
        return en_interpretation;
    }

    public void setEn_interpretation(String en_interpretation) {
        this.en_interpretation = en_interpretation;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) { this.gmt_create = gmt_create; }

    public Date getGmt_modified(){
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

}