package pl.edu.wat.checkcar.checkcarsso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;
import pl.edu.wat.checkcar.checkcarsso.repository.PersonRepositorySso;
import pl.edu.wat.checkcar.checkcarsso.principal.PersonPrincipal;

/**
 * Created by Aleksander on 18.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepositorySso personRepositorySso;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Person person = personRepositorySso.findByUserName(userName);
        if(person == null){
            throw new UsernameNotFoundException(userName);
        }
        return new PersonPrincipal(person);
    }
}
