package com.zcq.weShould.entity;

import javax.persistence.*;
import java.io.Serializable;

        @Entity
        @Table(name = "tb_bill")
        public class Bill implements Serializable {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;
            private String userName;
            private String password;

            @OneToOne(targetEntity = User.class)
            @JoinColumn(name = "user_id")
            private User user;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public User getUser() {
                return user;
            }

            public void setUser(User user) {
                this.user = user;
            }
        }
