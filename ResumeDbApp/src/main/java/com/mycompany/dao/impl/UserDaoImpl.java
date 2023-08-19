package com.mycompany.dao.impl;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Asus
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

	private User getUser(ResultSet rs) throws Exception {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String phone = rs.getString("phone");
		String email = rs.getString("email");
		String address = rs.getString("address");
		int nationalityId = rs.getInt("nationality_id");
		int birthPlaceId = rs.getInt("birthplace_id");
		String nationalityStr = rs.getString("nationality");
		String birthPlaceStr = rs.getString("birthplace");
		Date birthDate = rs.getDate("birthdate");
		String profileDescription = rs.getString("profile_description");
		String password = rs.getString("password");

		//        Country nationality = Country.builder().id(nationalityId).name(null).nationality(nationalityStr).build();
		Country nationality = new Country(nationalityId, null, nationalityStr);
		//        Country birthPlace = Country.builder().id(birthPlaceId).name(birthPlaceStr).nationality(null).build();
		Country birthPlace = new Country(nationalityId, birthPlaceStr, null);
		User user = new User(id, name, surname, email, phone, password);
//        User user = User.builder().id(id).name(name).surname(surname).phone(phone)
		//                .email(email).address(address).birthDate(birthDate).profileDescription(profileDescription)
		//                .nationality(nationality).birthPlace(birthPlace).build();
		return user;
	}

	private User getUserSimple(ResultSet rs) throws Exception {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String phone = rs.getString("phone");
		String email = rs.getString("email");
		String address = rs.getString("address");
		int nationalityId = rs.getInt("nationality_id");
		int birthPlaceId = rs.getInt("birthplace_id");
		Date birthDate = rs.getDate("birthdate");
		String password = rs.getString("password");
		String profileDescription = rs.getString("profile_description");

		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setPhone(phone);
		user.setEmail(email);
		user.setProfileDescription(profileDescription);
		user.setAddress(address);
		user.setBirthDate(birthDate);
		user.setNationality(new Country(nationalityId));
		user.setBirthPlace(new Country(birthPlaceId));
		user.setPassword(password);
		return user;

//        User user = User.builder().id(id).name(name).surname(surname).phone(phone)
//                .email(email).address(address).birthDate(birthDate).profileDescription(profileDescription)
//                .nationality(null).birthPlace(null).build();
	}

	@Override
	public User getById(Integer id) {
//        User result = null;
//        try (Connection c = connect()) {
//            Statement stmt = c.createStatement();
//            stmt.execute("SELECT"
//                    + "	u.*, "
//                    + "	 n.nationality, "
//                    + "	 c.birthplace   "
//                    + " FROM "
//                    + "	`user` u "
//                    + "	LEFT JOIN country n ON u.nationality_id = n.id "
//                    + "	LEFT JOIN country c ON u.birthplace_id = c.id where u.id=" + id);
//            ResultSet rs = stmt.getResultSet();
//            while (rs.next()) {
//                result = getUser(rs);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
		EntityManager em = em();

		em.getTransaction().begin();
		User u = em.find(User.class, id);
		em.getTransaction().commit();

		em.close();

		return u;
	}

	@Override
	public boolean removeUser(int id) {
		EntityManager em = em();

		User u = em.find(User.class, id);

		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();

		em.close();
		return true;
	}

	@Override
	public List<User> getAll(String name, String surname, Integer nationalityId) {
		EntityManager em = em();
		String jpql = "select u from User u where 1=1 ";
//            String sql = "SELECT"
//                    + "	u.*, "
//                    + "	 n.nationality, "
//                    + "	 c.birthplace "
//                    + " FROM "
//                    + "	`user` u "
//                    + "	LEFT JOIN country n ON u.nationality_id = n.id "
//                    + "	LEFT JOIN country c ON u.birthplace_id = c.id where 1=1 ";

		if (name != null && !name.trim().isEmpty()) {
			jpql += " and u.name=:name ";
		}
		if (surname != null && !surname.trim().isEmpty()) {
			jpql += " and u.surname=:name ";
		}
		if (nationalityId != null) {
			jpql += " and u.nationality.id=:nid ";
		}
		Query query = em.createQuery(jpql, User.class);
		if (name != null && !name.trim().isEmpty()) {
			query.setParameter("name", name);
		}
		if (surname != null && !surname.trim().isEmpty()) {
			query.setParameter("surname", surname);

		}
		if (nationalityId != null) {
			query.setParameter("nid", nationalityId);
		}

		return query.getResultList();
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		EntityManager em = em();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> q1 = cb.createQuery(User.class);
		Root<User> postRoot = q1.from(User.class);
		q1.where(cb.equal(postRoot.get("email"), email),
				cb.equal(postRoot.get("password"), password));

		Query query = em.createQuery(q1);
//        query.setParameter(1, email);
//        query.setParameter(2, password);

		List<User> list = query.getResultList();
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
//            EntityManager em=em();
//            em.getTransaction().begin();
//            em.find(User.class, email);
//            em.find(User.class,password);
//            em.getTransaction().commit();
//            		em.close();
//        EntityManager em = em();
//        Query q = em.createQuery("select u from User u where e= :u.email,u.password= :p");
//        q.setParameter("e", email);
//        q.setParameter("p", password);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//        User result = null;
//        try (Connection c = connect()) {
//            PreparedStatement stmt = c.prepareStatement("select * from user where email=? and password=?");
//            stmt.setString(1, email);
//            stmt.setString(2, password);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
////                result = getUserSimple(rs);
//            }
//        } catch (Exception ex) {
//        }
//        return result;
	}

//NamedQuery
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
//   Native SQL
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createNativeQuery("select * from user where email= ?", User.class);
//        query.setParameter(1, email);
//
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }

	//EntityManager
//	public User findByEmail(String email) {
//		User u = null;
//		u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));

	//		EntityManager em = em();
//
//		em.getTransaction().begin();
//		User u = em.find(User.class, email);
//		u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
//		em.getTransaction().commit();
//
//		em.close();
//		return u;
//	}
	//CriteriaBuilder
//    @Override
//    public User findByEmail(String email) {
////        User u = null;
////        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
//
//        EntityManager em = em();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        Root<User> postRoot = q1.from(User.class);
//        q1.where(cb.equal(postRoot.get("email"), email));
//
//        Query query = em.createQuery(q1);
////        query.setParameter(1, email);
////        query.setParameter(2, password);
//
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
//JPQL
	@Override
	public User findByEmail(String email) {
		EntityManager em = em();
		Query q = em.createQuery("select u from User u where u.email= :e");
		q.setParameter("e", email);
		List<User> list = q.getResultList();
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean updateUser(User u) {
		u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
		EntityManager em = em();

		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();

		em.close();

		return true;
	}

	private static BCrypt.Hasher crypt = BCrypt.withDefaults();

	@Override
	public boolean addUser(User u) {
		u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
		EntityManager em = em();

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		em.close();

		return true;
	}

	public static void main(String[] args) {
//		User u = new User(0, "test", "test", "test", "test@gmail.com", null, null, null, null);
//		u.setPassword("12345");
//		new UserDaoImpl().addUser(u);
		System.out.println(crypt.hashToString(4, "12345".toCharArray()));
	}
}
