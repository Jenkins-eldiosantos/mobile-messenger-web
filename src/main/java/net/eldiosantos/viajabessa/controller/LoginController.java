package net.eldiosantos.viajabessa.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import net.eldiosantos.viajabessa.auth.UserAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * Created by eldio.junior on 12/02/2015.
 */
@Path("/login")
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private UserAuthenticator authenticator;

    @Inject
    private Result result;

    @Path("/")
    public void form() {

    }

    @Path("/login")
    public void login(final String login, final String pass) {
        result.on(NoResultException.class)
                .forwardTo(this).form();

        authenticator.validate(login, pass);

        result.redirectTo(IndexController.class).index();
    }

    public void logout() {
        authenticator.invalidate();
        result.redirectTo(IndexController.class).index();
    }
}
