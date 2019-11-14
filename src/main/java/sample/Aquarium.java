package sample;


import java.sql.*;

public class Aquarium {
    /**
     *  Basic information regarding aquarium, like owner, owners' data, name of aquarium, also security like username and password for DB
     *  aquariumName - name of aquarium, will be visible on website
     *  ownerName - name of the aquarium user
     *  lastLoginTime - last time when owner logged into app or webapp
     *  dbUserName - name for DB to login and fetch/put data
     *  dbPassword - similar to dbUserName
     */
    private String aquariumName;
    private String ownerName;
    private Timestamp lastLoginTime;
    private String dbUserName;
    private String dbPassword;


    /**
     * Box sizes, provided in centimeters, amount of water in Liters
     * sizeX - width [cm]
     * sizeY - length [cm]
     * sizeZ - height [cm]
     * isEmpty - tells if aquarium is empty [true,false]
     * capacity - final amount of water in aquarium, [cm^3]
     * presentAmount - amount of water inside aquarium [cm^3, has to be lower than capacity, else ALARM]
     */
    private float sizeX;
    private float sizeY;
    private float sizeZ;
    private boolean isEmpty;
    private float capacity;
    private float presentAmount;

    /**
     * Sensors:
     * water - water temperature
     * box - temperature of box with electronics
     * lightSwitch - turns off/on light inside aquarium
     * hasLights -
     */
    private float waterTemp;
    private float boxTemp;
    private boolean lightSwitch;



    //test connection to DB here, if possible - fetch data from DB
    private void connectToDB() {
        Connection conn = null;

        try {
            String userName = "dawid";
            String password = "dupa123";
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
