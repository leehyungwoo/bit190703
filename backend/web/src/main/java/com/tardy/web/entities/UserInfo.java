package com.tardy.web.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@ToString
@Table(name = "userinfo")
public class UserInfo implements Serializable{  //매퍼역할
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="mid") private String userid;
  @Column(name="mpassword") private String userpassword;
  @Column(name="mname") private String username;
  @Column(name="memail") private String useremail;
  @Column(name="mphone") private String userphone;
  @Column(name="mgender") private String usergender;
   //이름이 같으면 생략가능


  @Override
  public String toString(){
    return "UserInfo :[id:"+id+",mid:" +userid+", mpassword:"+userpassword+", mname:"+username+", memail:"+useremail+", mphone:"+userphone+", mgender:"+usergender+"]"; 
  }

  //resultMap이라 생각
  @Builder
  private UserInfo(
 
      String userid,
      String userpassword,
      String username,
      String useremail,
      String userphone,
      String usergender){

      this.userid = userid;
      this.userpassword = userpassword;
      this.username = username;
      this.useremail = useremail;
      this.userphone = userphone;
      this.usergender = usergender;

  }


}