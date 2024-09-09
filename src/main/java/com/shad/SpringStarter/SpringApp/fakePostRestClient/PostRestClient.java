package com.shad.SpringStarter.SpringApp.fakePostRestClient;

import com.shad.SpringStarter.SpringApp.dto.FakePostDTO;

import java.util.List;

public interface PostRestClient {
    List<FakePostDTO> getAllFakePost();
    FakePostDTO getPostById(Long postId);
}
