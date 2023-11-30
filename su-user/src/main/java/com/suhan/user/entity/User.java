package com.suhan.user.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private String userPassWord;

    private Date createDate;

    private Date lastUpdateDate;

    private List<User> friends;

    private List<User> blocks;

}
