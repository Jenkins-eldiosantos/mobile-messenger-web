package net.eldiosantos.viajabessa.builder;

import net.eldiosantos.viajabessa.model.auth.UserInfo;
import net.eldiosantos.viajabessa.hashtools.HashProvider;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 24/02/2015.
 */
public class UserBuilder {

    @Inject
    private HashProvider provider;

    private final UserInfo user;

    public UserBuilder() {
        user = new UserInfo();
    }

    public UserBuilder setLogin(String login) {
        user.setLogin(login);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(provider.hash(password));
        return this;
    }

    public UserInfo build() {
        return user;
    }
}
