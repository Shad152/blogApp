package com.shad.SpringStarter.SpringApp;

import com.shad.SpringStarter.SpringApp.dto.FakePostDTO;
import com.shad.SpringStarter.SpringApp.fakePostRestClient.PostRestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringAppApplicationTests {
	@Autowired
	private PostRestClient postRestClient;
	@Test
	void getFakePostById(){
		FakePostDTO fakePost=postRestClient.getPostById(50L);
		System.out.println(fakePost);
	}
	@Test
	void getAllFakePost(){
		List<FakePostDTO> fakePostDTOList= postRestClient.getAllFakePost();
		System.out.println(fakePostDTOList);
	}

}
