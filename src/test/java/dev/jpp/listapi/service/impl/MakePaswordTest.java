package dev.jpp.listapi.service.impl;

import java.util.Random;

import org.junit.Test;

public class MakePaswordTest {

	@Test
	public void makePasswordTest() {
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		
		while (builder.length() < 10) {
			builder.append(chars.charAt(random.nextInt(chars.length())));
		}
		
		System.out.println(builder.toString());
	}
	
}
