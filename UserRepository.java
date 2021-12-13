package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.userName = ?1 AND isAdmin='0'")
	public User findByEmail(String email);
	
	
	@Query("SELECT u FROM User u WHERE isAdmin='0'")
	public List<User> findAlLStudents();
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1 and u.password =?2")
	public User findByEmailAndPassword(String email,String Password);
	
}
