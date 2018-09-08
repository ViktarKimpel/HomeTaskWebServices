package homeTaskCodeDesignPatterns.strategy;


public class LogInContext {


        private LogInStrategy logInStrategy;

    public LogInStrategy getLogInStrategy() {
        return logInStrategy;
    }

    public void setLogInStrategy(LogInStrategy logInStrategy) {
        this.logInStrategy = logInStrategy;
    }

    public LogInContext() {}

    public LogInContext(LogInStrategy logInStrategy) {
        this.logInStrategy = logInStrategy;
    }

    public void login() {
        this.logInStrategy.doLogIn();
    }
}
