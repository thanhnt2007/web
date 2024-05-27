package thanhnt.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import thanhnt.web.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String userName);

}
