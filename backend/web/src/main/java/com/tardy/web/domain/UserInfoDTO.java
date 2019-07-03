package com.tardy.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * MeetingDTO
 */
@Data
@Component
@Lazy
public class UserInfoDTO {
    private String id,
                   userid,
                   userpassword,
                   username,
                   useremail,
                   userphone,
                   usergender; 
}