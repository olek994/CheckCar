package pl.edu.wat.checkcar.checkcarsso.principal;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;

import java.util.Collection;

/**
 * Created by Aleksander on 18.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Data
public class PersonPrincipal implements UserDetails {

    private String name;
    private String userName;
    private String password;

    public PersonPrincipal(Person person) {
        this.name = person.getName();
        this.userName = person.getUserName();
        this.password = person.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
