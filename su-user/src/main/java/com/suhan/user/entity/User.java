package com.suhan.user.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private String userPassWord;

    private Long createDate;

    private Long lastUpdateDate;

    private List<User> friends;

    private List<User> blocks;

}
