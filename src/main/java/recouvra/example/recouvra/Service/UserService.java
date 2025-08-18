package recouvra.example.recouvra.Service;


import recouvra.example.recouvra.Entity.User;
import recouvra.example.recouvra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()
                || userRepository.findByUsername(user.getUsername()).isPresent()) {
            return false; // user already exists
        }

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return true;
    }
}

