/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;

/**
 * @author Asus
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        CountryDaoInter countryDao = Context.instanceCountryDao();
//        System.out.println(countryDao.getAll());
//        System.out.println("------------------------------------------------------------------------------------------");
//
//        EmploymentHistoryDaoInter EmpHisDao = Context.instanceEmploymentHistoryDao();
//        System.out.println(EmpHisDao.getAllEmploymentHistoryByUserId(9));
//        System.out.println("------------------------------------------------------------------------------------------");
//
//        SkillDaoInter skillDao = Context.instanceSkillDao();
//        System.out.println(skillDao.getAll());
//        System.out.println("------------------------------------------------------------------------------------------");

        UserDaoInter userDao = Context.instanceUserDao();

//        User user = userDao.getById(29);
//        System.out.println(userDao.getById(29));
        User u = userDao.findByEmail("leomessi@gmail.com");
        System.out.println("user=  "+u);
        System.out.println(u.getName());
        System.out.println(u.getPassword());
//        System.out.println(u.getName());

//        System.out.println(user.getEmail());
//        System.out.println(user.getNationality().getName());
        System.out.println("------------------------------------------------------------------------------------------");

//        UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
//        System.out.println(userSkillDao.getAllSkillByUserId(9));
//        System.out.println("------------------------------------------------------------------------------------------");
    }
}
