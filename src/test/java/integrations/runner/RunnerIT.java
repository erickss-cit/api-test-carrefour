package integrations.runner;


import integrations.serverest.login.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class

})
public class RunnerIT {
}
