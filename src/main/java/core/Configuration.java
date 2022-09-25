package core;

public class Configuration {

    public static final String CHROMEDRIVER = ConfProperties.getProperty("chromedriver");
    public static final String DRIVER = ConfProperties.getProperty("driver");
    public static final String USER_DIR = ConfProperties.getProperty("user_dir");

    public static final String DEMO_QA_LOGIN_PAGE = ConfProperties.getProperty("DEMO_QA_LOGIN_PAGE");
    public static final String DEMO_QA_LOGIN_PAGE1 = ConfProperties.getProperty("DEMO_QA_LOGIN_PAGE1");

    public static final String CLEAN_URI_HOST = ConfProperties.getProperty("CLEAN_URI_HOST");
    public static final String CLEAN_URI_PATH = ConfProperties.getProperty("CLEAN_URI_PATH");
    public static final String CLEAN_TEST_DATA_WITHOUT_SINGS_AND_SPACES = ConfProperties.getProperty("CLEAN_TEST_DATA_WITHOUT_SINGS_AND_SPACES");
    public static final String CLEAN_TEST_DATA_WITH_SINGS = ConfProperties.getProperty("CLEAN_TEST_DATA_WITH_SINGS");
    public static final String CLEAN_TEST_DATA_TOO_LONG = ConfProperties.getProperty("CLEAN_TEST_DATA_TOO_LONG");

    public static final String GENERATOR_URI_HOST = ConfProperties.getProperty("GENERATOR_URI_HOST");
    public static final String GENERATOR_URI_PATH = ConfProperties.getProperty("GENERATOR_URI_PATH");



}
