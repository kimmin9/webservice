package com.springboot.kmg.kmg.web;

import com.springboot.kmg.kmg.dto.mail.EmailDto;
import com.springboot.kmg.kmg.dto.posts.PostsSaveRequestDto;
import com.springboot.kmg.kmg.service.EmailService;
import com.springboot.kmg.kmg.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private EmailService emailService;

    @GetMapping("/hello")
    public String hello(){
        return "Helloworld1";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @PostMapping("/email")
    public int email(@RequestBody EmailDto dto){

        try {
            emailService.emailSend(dto);
            return 1;
        }catch (MailException mailException){
            return 0;
        }
    }
}
