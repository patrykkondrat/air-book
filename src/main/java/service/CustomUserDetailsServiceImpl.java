package service;

import model.SecUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repo.UserRepo;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private final UserRepo userRepo;

    public CustomUserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .map(SecUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found" + username));
    }
}
