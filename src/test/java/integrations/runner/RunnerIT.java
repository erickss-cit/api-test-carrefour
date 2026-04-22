package integrations.runner;


import integrations.serverest.login.LoginTest;
import integrations.serverest.usuarios.UsuariosTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        UsuariosTest.class

})
public class RunnerIT {
}
