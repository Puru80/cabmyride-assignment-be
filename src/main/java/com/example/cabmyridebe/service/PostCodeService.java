package com.example.cabmyridebe.service;

import com.example.cabmyridebe.db.PostCodes;
import com.example.cabmyridebe.repository.PostCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostCodeService {

    private PostCodeRepository postCodeRepository;

    private static final String POST_CODE_FILE_PATH = "D:\\ukpostcodes\\ukpostcodes.csv";

    public void savePostCode() {
        List<PostCodes> postCodesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(POST_CODE_FILE_PATH))) {
            String line = br.readLine();
            line = br.readLine();

            for(int i=0;i<=314999;i++)
                line = br.readLine();

            int count = 0;

            while (line != null) {
                String[] attributes = line.split(",");
                PostCodes postCodes = createPostCode(attributes);

                if(postCodeRepository.existsByPostCode(postCodes.getPostCode()))
                    continue;

                postCodesList.add(postCodes);
                count++;

                if(count==1000) {
                    postCodeRepository.saveAll(postCodesList);
                    count=0;
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private PostCodes createPostCode(String[] attributes) {
        PostCodes postCodes = new PostCodes();
        postCodes.setPostCode(attributes[1]);
        postCodes.setLatitude(Double.parseDouble(attributes[2]));
        postCodes.setLongitude(Double.parseDouble(attributes[3]));

        postCodes.setSO(attributes[1].contains("SO"));

        return postCodes;
    }

    public List<PostCodes> getPostCodes(int pageNumber) {

        Page<PostCodes> page = postCodeRepository.findAll(PageRequest.of(
            pageNumber,
            2500));

        return (page.getContent());

    }
}
