package burak.jwt.db;

import burak.jwt.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DatabaseInıt implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DatabaseInıt(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User burak = new User("burak",passwordEncoder.encode("p"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("p"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("p"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(burak,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
