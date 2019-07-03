<template>
    <div>
        <headerComponent/>
        <!-- inner-banner -->
        <section class="inner-banner" id="home">
            <div class="inner-layer">
                <div class="container">
                </div>
            </div>
        </section>
        <!-- //inner-banner -->

        <!-- breadcrumb -->
        <div class="breadcrumb-w3pvt">
            <div class="container">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <!-- <li class="breadcrumb-item"><a href="index.html">Home</a></li> -->
                    <li class="breadcrumb-item" aria-current="page">MyPage</li>
                </ol>
            </nav>
            </div>
        </div>
        <!-- //breadcrumb -->
            
        <!-- contact -->
        <section class="contact py-5">
            <div class="container py-lg-5">
                <h2 class="heading mb-sm-5 mb-4"><strong> My </strong>Page</h2>
                <div class="row">
                    <div class="col-lg-12 contact-form mt-md-0 mt-sm-5 mt-4">
                        <h4 class="mb-4 w3f_title">마이페이지</h4>
                         <div name="contactform" id="contactform">
                        <div class="form-group">
                            <label>아이디</label>
                            <input type="text" class="form-control" id="user_id" placeholder="Enter Id" name="user_id" v-model="userid">
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label>
                            <input type="password" class="form-control" id="user_password" placeholder="Enter Password" name="user_password" v-model="userpassword">
                        </div>
                        <div class="form-group">
                            <label>비밀번호 확인</label>
                            <input type="password" class="form-control" id="user_password_con" placeholder="Enter Password" name="user_password_con">
                        </div>
                        <div class="form-group">
                            <label>이름</label>
                            <input type="text" class="form-control" id="user_name" placeholder="Enter Name" name="user_name"
                            v-model="username">
                        </div>
                        <div class="form-group">
                            <label>이메일</label>
                            <input type="email" class="form-control" id="user_email" placeholder="Enter Email" name="user_email"
                            v-model="useremail">
                        </div>
                        <div class="form-group">
                            <label>핸드폰번호</label>
                            <input type="tel" class="form-control" id="user_phone" placeholder="Enter Phone" name="user_phone"
                            v-model="userphone">
                        </div>
                        <div class="form-group">
                            <label>성별</label><br/>
                            <!-- <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                    <label class="btn btn-secondary active"> -->
                                        <input type="radio" name="options" id="option1" autocomplete="off" checked> 남성
                                    <!-- </label> -->
                                    <!-- <label class="btn btn-secondary"> -->
                                        <input type="radio" name="options" id="option2" autocomplete="off"> 여성
                                    <!-- </label>
                            </div> -->
                        </div>
                        <!-- <div class="form-group">
                            <label>선호모임</label>
                            <select class="custom-select">
                                    <option selected>-</option>
                                    <option value="1">테스트</option>
                                </select>
                        </div> -->
                        <!-- <div class="form-group">
                                <label>How can we help?</label>
                                <textarea name="issues" class="form-control" id="iq" placeholder="Enter Your Message Here"></textarea>
                                </div>				 -->
                        <button @click="updateBtn()" class="btn btn-default">Update</button>
                        <button @click="remove()" class="btn btn-default">remove</button>
                    </div>
                    </div>  
                </div>
            </div>
        </section>
        <!-- //contact -->
        <copyright></copyright>
        <movetop></movetop> 
    </div>
</template>

<script>

import headerComponent from "@/components/common/headerComponent"
import copyright from "@/components/common/copyright"
import movetop from "@/components/common/movetop"
import axios from "axios"
export default {
    data(){
        return{
             hostname:'http://localhost:9000/userinfo',
             id:1,
             userid:"",
             userpassword:"",
             username:"",
             useremail:"",
             userphone:""
        }
    },
    created() {

        axios.get(`${this.hostname}/mypage/${this.id}`)
        .then(res=>{
           
            this.id=res.data.id;
            this.userid=res.data.userid;
            this.userpassword=res.data.userpassword;
            this.username=res.data.username;
            this.useremail=res.data.useremail;
            this.userphone=res.data.userphone;
        
        })
        .catch(e=>{
            alert("통신에러")
        })
    },
    components:{
        headerComponent,
        copyright,
        movetop
    },
    methods:{
        updateBtn(){

               var data = {  
                    id:this.id,
                    userid:this.userid,
                    userpassword:this.userpassword,
                    username:this.username,
                    useremail:this.useremail,
                    userphone:this.userphone
                }
                 var headers = {
                    "Content-Type":"application/json",
                    "Authorization":"JWT fefege.."
                }
                axios.put(`${this.hostname}/update`,
                 JSON.stringify(data),
                {headers:headers})
                .then(r=>{
                    alert(r.data)
                }).catch(e=>{
                    alert("통신에러"+e)
                })
        },
        remove(){
                 var data = {
                     userid:this.userid,
                     userpassword:this.userpassword
                }
                axios.delete(`${this.hostname}/delete/${this.id}`)
                .then(r=>{
                    alert(r)
                }).catch(e=>{
                    alert(e)
                })
        }
    }
}
</script>



<style scoped>
.btn.btn-secondary.active{background:#ffc168}
 .btn-secondary{background: #fff;}
</style>
