/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface EmploymentHistoryDaoInter {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

    public boolean updateEmploymentHistory(EmploymentHistory u);

    public boolean addEmploymentHistory(EmploymentHistory u);

    public boolean removeEmploymentHistory(int id);
}
