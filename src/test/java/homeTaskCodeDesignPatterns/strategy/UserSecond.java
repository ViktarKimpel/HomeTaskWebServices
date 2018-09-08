package homeTaskCodeDesignPatterns.strategy;


import org.openqa.selenium.By;

public class UserSecond implements LogInStrategy {

        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public UserSecond(String email, String password) {
            super();
            this.email = email;
            this.password = password;

        }
        public void doLogIn() {
            WebDriverInstance.getInstance().findElement(By.xpath("//div[@class='gmail-nav__nav-links-wrap']/a[@class ='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
            WebDriverInstance.getInstance().findElement(By.cssSelector("input#identifierId.whsOnd.zHQkBf")).sendKeys(email);
            WebDriverInstance.getInstance().findElement(By.cssSelector("#identifierNext")).click();

            WebDriverInstance.getInstance().findElement(By.xpath("//div[@class='Xb9hP']/input[@type='password']")).sendKeys(password);
            WebDriverInstance.getInstance().findElement(By.cssSelector("#passwordNext")).click();

            WebDriverInstance.getInstance().findElement(By.xpath(
                    "//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']")).click();
            WebDriverInstance.getInstance().findElement(By.xpath("//a[text()='Sign out']")).click();
        }

    }
