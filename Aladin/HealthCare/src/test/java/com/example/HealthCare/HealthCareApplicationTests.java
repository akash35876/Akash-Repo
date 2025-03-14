package com.example.HealthCare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.HealthCare.Dao.BlogRepositry;
import com.example.HealthCare.model.BlogPost;
import com.example.HealthCare.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
class HealthCareApplicationTests {
	
	@Autowired
	private BlogService serv;
	@Mock
	private BlogRepositry repo;
	
	@Test
	public void getStatus() {
		
		
		
	}

	@Test
	public void getBlogtest() {
		when(repo.findAll()).thenReturn(Stream
	.of(new BlogPost (1, "Akash","LKG", null),new BlogPost(2, "Dhivae","UKG", null)).collect(Collectors.toList()));
		assertEquals(8, serv.getBlog().size());
	}

	@Test
	public void getIdTest(@PathVariable int id) {
		
		int a = 1;
		when(repo.findById(id)).thenReturn(repo.findById(id));
		assertEquals(1, serv.getId(id));
		
	
	}
}
