public class SolarEclipse {
    private String catalogNumber;
    private String calendarDate;
    private String eclipseTime;
    private long deltaT; // in seconds
    private int lunationNumber;
    private int sarosNumber;
    private String eclipseType; // T for total, A for annular, P for partial
    private double gamma;
    private double eclipseMagnitude;
    private String latitude; // e.g., "6.0N", "32.9S"
    private String longitude; // e.g., "33.3W", "10.8E"
    private int sunAltitude; // in degrees
    private int sunAzimuth; // in degrees
    private int pathWidth; // in kilometers
    private String centralDuration; // e.g., "06m37s"

    // Constructor
    public SolarEclipse(double eclipseMagnitude){
        this.eclipseMagnitude=eclipseMagnitude;
    }
    public SolarEclipse(String[] data) {
        // Assuming the data follows the order of the fields you provided
         catalogNumber = data[0];                   // Catalog Number
         calendarDate = data[1];                    // Calendar Date
         eclipseTime = data[2];                     // Eclipse Time
         deltaT = Long.parseLong(data[3]);            // Delta T (in seconds)
         lunationNumber = Integer.parseInt(data[4]);   // Lunation Number
         sarosNumber = Integer.parseInt(data[5]);      // Saros Number
         eclipseType = data[6];                     // Eclipse Type (T, A, P)
         gamma = Double.parseDouble(data[7]);       // Gamma
         eclipseMagnitude = Double.parseDouble(data[8]); // Eclipse Magnitude
         latitude = data[9];                        // Latitude (e.g., "6.0N")
         longitude = data[10];                      // Longitude (e.g., "33.3W")
         sunAltitude = Integer.parseInt(data[11]);     // Sun Altitude (in degrees)
         sunAzimuth = Integer.parseInt(data[12]);      // Sun Azimuth (in degrees)
         pathWidth = Integer.parseInt(data[13]);       // Path Width (in kilometers)
         centralDuration = data[14];
    }

    // Getters (optional, if needed)
    public String getCatalogNumber() {
        return catalogNumber;
    }

    public String getCalendarDate() {
        return calendarDate;
    }

    public String getEclipseTime() {
        return eclipseTime;
    }

    public long getDeltaT() {
        return deltaT;
    }

    public int getLunationNumber() {
        return lunationNumber;
    }

    public int getSarosNumber() {
        return sarosNumber;
    }

    public String getEclipseType() {
        return eclipseType;
    }

    public double getGamma() {
        return gamma;
    }

    public double getEclipseMagnitude() {
        return eclipseMagnitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public int getSunAltitude() {
        return sunAltitude;
    }

    public int getSunAzimuth() {
        return sunAzimuth;
    }

    public int getPathWidth() {
        return pathWidth;
    }

    public String getCentralDuration() {
        return centralDuration;
    }

    // toString method for better readability
    @Override
    public String toString() {
        return "SolarEclipse{" +
                "Catalog Number='" + catalogNumber + '\'' +
                ", Calendar Date='" + calendarDate + '\'' +
                ", Eclipse Time='" + eclipseTime + '\'' +
                ", Delta T=" + deltaT +
                ", Lunation Number=" + lunationNumber +
                ", Saros Number=" + sarosNumber +
                ", Eclipse Type='" + eclipseType + '\'' +
                ", Gamma=" + gamma +
                ", Eclipse Magnitude=" + eclipseMagnitude +
                ", Latitude='" + latitude + '\'' +
                ", Longitude='" + longitude + '\'' +
                ", Sun Altitude=" + sunAltitude +
                ", Sun Azimuth=" + sunAzimuth +
                ", Path Width=" + pathWidth +
                ", Central Duration='" + centralDuration + '\'' +
                '}';
    }
}

