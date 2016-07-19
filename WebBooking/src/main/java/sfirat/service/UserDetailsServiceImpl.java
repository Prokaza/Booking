package sfirat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sfirat.dao.AuthDAO;
import sfirat.entity.enumeration.State;

import java.util.ArrayList;
import java.util.Collection;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthDAO authDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            System.out.println(username);
            sfirat.entity.User userEntity = authDAO.findUserByLogin("sfirate@mail.ru");
            System.out.println("loadUserByUsername: " + username);

            if (userEntity == null){
                System.out.println(userEntity.getFirstname());

                throw new UsernameNotFoundException("user not found");
            }

            boolean enabled = (userEntity.getState() == State.ACTIVE);
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = (userEntity.getState() != State.BANNED);

            String role = userEntity.getRole().name();

            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(role));

            return new User(userEntity.getEmail(),userEntity.getPassword(),
                    enabled,accountNonExpired,credentialsNonExpired,
                    accountNonLocked,authorities);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}