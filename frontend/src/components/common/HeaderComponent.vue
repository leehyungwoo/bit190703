<template>
     <header>
            <div class="container">
                <!-- nav -->
                <nav class="py-3 d-lg-flex">
                    <div id="logo">
                        <h1> <router-link to="/"><span class="fa fa-university"></span> TardyGram</router-link></h1>
                    </div>
                    <label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
                    <input type="checkbox" id="drop" />
                    <ul class="menu ml-auto mt-1">
                        <li class=""><router-link to="/">홈</router-link></li>
                        <li class=""><router-link to="/login">로그인</router-link></li>
                        <li class=""><router-link to="/join">회원가입</router-link></li>
                        <li class="last-grid"><router-link to="/mypage">마이페이지</router-link></li>
                    </ul>
                </nav>
                <!-- //nav -->
            </div>
        </header>
</template>
<script>
export default {
    data(){
        return{
           
        }
    },

    methods:{
        
    }
}
</script>

<style>
 li a:hover{color:#da9d40}
</style>

