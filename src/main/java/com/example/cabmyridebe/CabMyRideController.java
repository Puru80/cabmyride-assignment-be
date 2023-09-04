package com.example.cabmyridebe;

import com.example.cabmyridebe.db.PostCodes;
import com.example.cabmyridebe.service.PostCodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @GetMapping("/postCodes/{page}")
    public List<PostCodes> getPostCodes(@PathVariable("page") String page) {
        int pageNumber = Integer.parseInt(page);
        return postCodeService.getPostCodes(pageNumber);
    }

}
