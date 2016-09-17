package com.matthalbersma;

import com.matthalbersma.model.Client;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walter on 9/16/16.
 */
@Repository
public class AuthUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository users;
    private User userdetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        Client client = getUserDetail(username);
        List<GrantedAuthority> clientAuth=new ArrayList<>();
               clientAuth.add(new SimpleGrantedAuthority(client.getRoles()));
        userdetails=new User(


                client.getUsername(),
                client.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                clientAuth
        );


    return userdetails;

    }

    private Client getUserDetail(String username){
        return users.findByUsername(username);
    }

}
