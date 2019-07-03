package com.tardy.web.controller;

import java.util.HashMap;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.tardy.web.domain.UserInfoDTO;
import com.tardy.web.entities.UserInfo;
import com.tardy.web.repositories.UserInfoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MeetingController
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 9000)
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired UserInfoRepository repo;
    @Autowired UserInfoDTO dto;
    @Autowired ModelMapper modelMapper;


   @Bean
   public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper ();
        return modelMapper;
    }


    @PostMapping("/join")
    public void join(@RequestBody UserInfoDTO param) {
       System.out.println("조인");
       System.out.println(param);
       UserInfo entity = new UserInfo();
       entity.setUserid(param.getUserid());
       entity.setUserpassword(param.getUserpassword());
       entity.setUsername(param.getUsername());
       entity.setUseremail(param.getUseremail());
       entity.setUserphone(param.getUserphone());
       entity.setUsergender(param.getUsergender());
       System.out.println("엔티티 : "+entity);
       repo.save(entity);
    }

    @PostMapping("/login")
    public void login(@RequestBody UserInfoDTO param) {
       System.out.println(param);
       UserInfo test =repo.findByUseridAndUserpassword(param.getUserid(), param.getUserpassword());
       System.out.println(test);
    }

    @GetMapping("/mypage/{id}")
    public UserInfoDTO mypage(@PathVariable long id){
      System.out.println("마이페이지");
      System.out.println(id);  //1
      UserInfo entity = repo.findById(id).orElseThrow(EntityNotFoundException :: new);
      System.out.println(">>>"+entity.toString());
      UserInfoDTO target = modelMapper.map(entity, UserInfoDTO.class);
      System.out.println(target);

      return target;
   }

    @PutMapping("/update")
    public void put(@RequestBody UserInfoDTO param) {
       System.out.println("업데이트");
       System.out.println(param);
       System.out.println("프론트에서 온 id값 : " + param.getId());
   
       
      }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
      System.out.println("유저아이디 : " + id);
      repo.deleteById(id);
   }


}