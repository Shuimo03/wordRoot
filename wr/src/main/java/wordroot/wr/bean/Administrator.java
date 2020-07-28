package wordroot.wr.bean;

import java.util.Date;

/**
 * @author wuliang
 * @date 2020/7/28
 */

public class Administrator {
        int id;
        private String name;
        private String password;
        private Date gmt_create;
        private Date gmt_modified;
        private String salt;
        private boolean enabled;

        public int getId(){
            return id;
        }
        public void  setId(int id){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getPassword(){
            return password;
        }

        public void setPassword(String password){
            this.password = password;
        }

        public String getSalt(){
            return salt;
        }

        public void setSalt(String salt){
            this.salt = salt;
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
