package com.navigationview.base.bean;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/31
 * @Time 14:40
 */
public class LoginBean {
    /**
     * msg : 登录成功
     * status : 0
     * result : {"id":"8aafb87a5fd7f6c1016053ad80640004","username":"15619187872","realname":"兰超","avatar":"3642a408c9c04f8883bcac97fbfbd367.png","nickname":"兰超","sex":0,"etsuserid":null,"jwflag":null,"token":"5cd0f401fb914c7a915e4a78772fa088","defaultHome":{"id":"8aafb87a608d006b0160973c2b420009","name":"盛云测试1区1栋1单元1层2房","floor":1,"position":"四川","community":"盛云测试","city":"四川","thumb_url":"null","apartment_token":"d4ec781547bcdf0286394da5f8c56d40","createtime":1514365791000,"homeid":"90"}}
     */

    private String msg;
    private String status;
    private ResultBean result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 8aafb87a5fd7f6c1016053ad80640004
         * username : 15619187872
         * realname : 兰超
         * avatar : 3642a408c9c04f8883bcac97fbfbd367.png
         * nickname : 兰超
         * sex : 0
         * etsuserid : null
         * jwflag : null
         * token : 5cd0f401fb914c7a915e4a78772fa088
         * defaultHome : {"id":"8aafb87a608d006b0160973c2b420009","name":"盛云测试1区1栋1单元1层2房","floor":1,"position":"四川","community":"盛云测试","city":"四川","thumb_url":"null","apartment_token":"d4ec781547bcdf0286394da5f8c56d40","createtime":1514365791000,"homeid":"90"}
         */

        private String id;
        private String username;
        private String realname;
        private String avatar;
        private String nickname;
        private int sex;
        private Object etsuserid;
        private Object jwflag;
        private String token;
        private DefaultHomeBean defaultHome;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public Object getEtsuserid() {
            return etsuserid;
        }

        public void setEtsuserid(Object etsuserid) {
            this.etsuserid = etsuserid;
        }

        public Object getJwflag() {
            return jwflag;
        }

        public void setJwflag(Object jwflag) {
            this.jwflag = jwflag;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public DefaultHomeBean getDefaultHome() {
            return defaultHome;
        }

        public void setDefaultHome(DefaultHomeBean defaultHome) {
            this.defaultHome = defaultHome;
        }

        public static class DefaultHomeBean {
            /**
             * id : 8aafb87a608d006b0160973c2b420009
             * name : 盛云测试1区1栋1单元1层2房
             * floor : 1
             * position : 四川
             * community : 盛云测试
             * city : 四川
             * thumb_url : null
             * apartment_token : d4ec781547bcdf0286394da5f8c56d40
             * createtime : 1514365791000
             * homeid : 90
             */

            private String id;
            private String name;
            private int floor;
            private String position;
            private String community;
            private String city;
            private String thumb_url;
            private String apartment_token;
            private long createtime;
            private String homeid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getFloor() {
                return floor;
            }

            public void setFloor(int floor) {
                this.floor = floor;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getCommunity() {
                return community;
            }

            public void setCommunity(String community) {
                this.community = community;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getThumb_url() {
                return thumb_url;
            }

            public void setThumb_url(String thumb_url) {
                this.thumb_url = thumb_url;
            }

            public String getApartment_token() {
                return apartment_token;
            }

            public void setApartment_token(String apartment_token) {
                this.apartment_token = apartment_token;
            }

            public long getCreatetime() {
                return createtime;
            }

            public void setCreatetime(long createtime) {
                this.createtime = createtime;
            }

            public String getHomeid() {
                return homeid;
            }

            public void setHomeid(String homeid) {
                this.homeid = homeid;
            }
        }
    }
}
