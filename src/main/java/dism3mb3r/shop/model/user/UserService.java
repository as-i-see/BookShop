package dism3mb3r.shop.model.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkCredentials(User user) {
        return userRepository.existsByEmailAndPassword(user.getEmail(), user.getPassword());
    }
}
