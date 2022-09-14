package kodlamaio.kamp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.kamp.core.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByEmail(String email);
}
