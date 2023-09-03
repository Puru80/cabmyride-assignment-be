package com.example.cabmyridebe;

import com.example.cabmyridebe.db.PostCodes;
import com.example.cabmyridebe.service.PostCodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/")
@AllArgsConstructor
public class CabMyRideController {

    private PostCodeService postCodeService;

    @PostMapping("/savePostCode")
    public String savePostCode() {
        postCodeService.savePostCode();
        return "Post Code Saved";
    }

    @GetMapping("/postCodes")
    public List<PostCodes> getPostCodes() {
        return postCodeService.getPostCodes();
    }

}
