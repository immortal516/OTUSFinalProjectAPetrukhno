package config;

public final class TestConfig {
    private TestConfig() {
    }

    public static String baseUrl() {
        return System.getProperty("baseUrl", "https://wishlist.otus.kartushin.su");
    }

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    /**
     * Remote run flag (Selenium Grid).
     * Example: -Dremote=true -DgridUrl=http://localhost:4444/wd/hub
     */
    public static boolean remote() {
        return Boolean.parseBoolean(System.getProperty("remote", "false"));
    }

    public static String gridUrl() {
        return System.getProperty("gridUrl", "http://localhost:4444/wd/hub");
    }

    public static String loginRequired() {
        String login = System.getProperty("login");
        if (login == null || login.isBlank()) throw new IllegalArgumentException("Pass -Dlogin=...");
        return login;
    }

    public static String passwordRequired() {
        String password = System.getProperty("password");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Pass -Dpassword=...");
        return password;
    }
}