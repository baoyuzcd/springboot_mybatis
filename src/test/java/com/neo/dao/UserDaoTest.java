package com.neo.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired
	private UserDao UserDao;

	@Test
	public void testInsert() throws Exception {
		User user = new User();
		user.setId("111");
		user.setUserName("aa2");
		user.setPassWord("1234561");
		user.setUserSex("男");
		user.setNickName("hh2");

		UserDao.insert(user);
	}

	@Test
	public void testGetAll() throws Exception {
		List<User> users = UserDao.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}

	@Test
	public void testGetOne() throws Exception {
		User user = UserDao.getOne("5ecfd60a2f8111e9911aee799375927a");
		if(user==null){
			System.out.println("is null");
		}else{
			System.out.println(user.toString());
		}
	}

	@Test
	public void testdel(){
		UserDao.delete("5ecfd60a2f8111e9911aee799375927a");
	}

	
	
	@Test
	public void testUpdate() throws Exception {
		User user = UserDao.getOne("5ecfd60a2f8111e9911aee799375927a");
		System.out.println(user.toString());
		user.setNickName("kobe");
		UserDao.update(user);
		Assert.assertTrue(("kobe".equals(UserDao.getOne("5ecfd60a2f8111e9911aee799375927a").getNickName())));
	}

}