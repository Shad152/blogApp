package com.shad.SpringStarter.SpringApp.fakePostRestClient;

import com.shad.SpringStarter.SpringApp.dto.FakePostDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
@Service
public class PostRestClientImpl implements PostRestClient{
    private final RestClient restClient;

    public PostRestClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<FakePostDTO> getAllFakePost() {
        List<FakePostDTO> fakePostList= restClient.get().uri("posts").retrieve().body(new ParameterizedTypeReference<List<FakePostDTO>>(){});
        return fakePostList;
    }

    @Override
    public FakePostDTO getPostById(Long postId) {
        FakePostDTO fakePost= restClient.get().uri("posts/{postId}",postId).retrieve().body(new ParameterizedTypeReference<FakePostDTO>(){
        });
        return fakePost;
    }
}
