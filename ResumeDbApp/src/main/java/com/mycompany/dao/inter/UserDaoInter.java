/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.User;

import java.util.List;

/**
 * @author Asus
 */
public interface UserDaoInter {

	public List<User> getAll(String name, String surname, Integer nationalityId);


	public User findByEmailAndPassword(String email, String password);
	public User findByEmail(String email);

	public boolean updateUser(User u);

	public boolean addUser(User u);

	public User getById(Integer id);

	public boolean removeUser(int id);

}
