package com.zoy.graduation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZoyGraduationWebApplicationTests {

	@Test
	public void javaTest() {
		int i = (int) (10 + Math.random() * 10000);
		System.out.println(i);
		Random random = new Random(10000);
		System.out.println(random.nextInt());
	}

}
