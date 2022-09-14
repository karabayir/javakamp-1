package kodlamaio.kamp.service;

import org.springframework.stereotype.Service;

import kodlamaio.kamp.core.model.User;
import kodlamaio.kamp.core.repository.UserRepository;
import kodlamaio.kamp.core.result.DataResult;
import kodlamaio.kamp.core.result.Result;
import kodlamaio.kamp.core.result.SuccessDataResult;
import kodlamaio.kamp.core.result.SuccessResult;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Result  addUser(User user){
		userRepository.save(user);
		return new SuccessResult(user + " kaydedildi");
	}
	
	public DataResult<User> findByEmail(String email){
		return new SuccessDataResult<User>(userRepository.findByEmail(email),"user getirildi");
	}
	

}
