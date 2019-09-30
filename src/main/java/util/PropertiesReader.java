package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private String DBConnectionType;

    private String dialect;
    private String driver;
    private String url;
    private String username;
    private String password;
    private String showSql;
    private String hbm2ddl;

    private static PropertiesReader propertiesReader;

    public static PropertiesReader getInstance() {
        if (propertiesReader == null){
            propertiesReader = new PropertiesReader();
        }
        return propertiesReader;
    }

    public String getDBConnectionType() {
        return DBConnectionType;
    }

    public void setDBConnectionType(String DBConnectionType) {
        this.DBConnectionType = DBConnectionType;
    }
    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShowSql() {
        return showSql;
    }

    public void setShowSql(String showSql) {
        this.showSql = showSql;
    }

    public String getHbm2ddl() {
        return hbm2ddl;
    }

    public void setHbm2ddl(String hbm2ddl) {
        this.hbm2ddl = hbm2ddl;
    }

    public void read(String type) throws IOException {
        Properties props = new Properties();
        String propFileName = "db.properties";
        FileInputStream in = new FileInputStream("D:\\JavaMentors\\JMSoloProject\\src\\main\\resources\\db");
        //InputStream in = getClass().getClassLoader().getResourceAsStream(propFileName);
        props.load(in);
        in.close();
        switch (type){
            case ("hibernate"):
                setDBConnectionType(props.getProperty("hibernate"));
                break;
            case ("jdbc"):
                setDBConnectionType(props.getProperty("JDBC"));
                break;
        }
        setDialect(props.getProperty("dialect"));
        setDriver(props.getProperty("driver"));
        setUrl(props.getProperty("url"));
        setUsername(props.getProperty("username"));
        setPassword(props.getProperty("password"));
        setShowSql(props.getProperty("show_sql"));
        setHbm2ddl(props.getProperty("hbm2ddl"));
    }


}
