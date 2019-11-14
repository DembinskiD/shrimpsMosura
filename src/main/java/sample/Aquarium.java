package sample;


import java.awt.*;
import java.sql.*;

public class Aquarium {
    /**
     *  Basic information regarding aquarium, like owner, owners' data, name of aquarium, also security like username and password for DB
     *  aquariumName - name of aquarium, will be visible on website
     *  ownerName - name of the aquarium user
     *  lastLoginTime - last time when owner logged into app or webapp, to be fetched from DB
     *  dbUserName - name for DB to login and fetch/put data
     *  dbPassword - similar to dbUserName
     */
    private String aquariumName;
    private String ownerName;
    private Timestamp lastLoginTime;
    private String dbUserName;
    private String dbPassword;
    private Rectangle tempSensorsNode = new Rectangle(); //todo change rectangle for a class with method returning a node that will be added to graphic interface; will be created with paramless constructor


    /**
     * Box sizes, provided in centimeters, amount of water in Liters
     * sizeX - width [cm]
     * sizeY - length [cm]
     * sizeZ - height [cm]
     * isAquariumEmpty - tells if aquarium is empty [true,false]
     * capacity - final amount of water in aquarium [cm^3]
     * presentAmount - amount of water inside aquarium [cm^3, has to be lower than capacity, else ALARM]
     */
    private float sizeX;
    private float sizeY;
    private float sizeZ;
    private boolean isAquariumEmpty;
    private float capacity;
    private float presentAmount;

    /**
     * Sensors:
     * water - water temperature [Celsius]
     * box - temperature of box with electronics [Celsius]
     * lightSwitch - setups state of light in aquarium
     * hasLights - says if aquarium has lights or not
     * airflow - switch for 220v airflow port
     * heater - switch for 220v heater port
     * filter - switch for 220v filter port
     * czwarty - similar to filter
     */
    private float waterTemp;
    private float boxTemp;
    private LightState lightSwitch;
    private boolean hasLights;
    private boolean airflow;
    private boolean heater;
    private boolean filter;
    private boolean czwarty;

    /**
     *
     * @param aquariumName name of aquarium that will be visible on app
     * @param ownerName name of the owner to be visible on app
     * @param dbUserName username to connect to db
     * @param dbPassword similar to dbUserName
     */
    public Aquarium(String aquariumName, String ownerName, String dbUserName, String dbPassword) {
        this.aquariumName = aquariumName;
        this.ownerName = ownerName;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
    }

    /**
     * below constructor is used only for GUI tests and data listing
     */
    public Aquarium() {
        this.aquariumName = "defaultAquariumName";
        this.ownerName = "defaultOwnerName";

    }

    //test connection to DB here, if possible - fetch data from DB
    private void connectToDB() {
        Connection conn = null;

        try {
            String userName = "";
            String password = "";
            String sterownik = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://mosura.pl:3306/mosurapl";
            Class.forName(sterownik); //register driver
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
