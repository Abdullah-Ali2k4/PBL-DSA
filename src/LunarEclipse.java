public class LunarEclipse {
    private String catalogNumber;
    private String calendarDate;
    private String eclipseTime;
    private double deltaT;
    private int lunationNumber;
    private int sarosNumber;
    private String eclipseType;
    private String quincenaSolarEclipse;
    private double gamma;
    private double penumbralMagnitude;
    private double umbralMagnitude;
    private String latitude;
    private String longitude;
    private double penumbralEclipseDuration;
    private double partialEclipseDuration;
    private double totalEclipseDuration;

    public LunarEclipse(String[] data) {
         catalogNumber = data[0];
         calendarDate = data[1];
         eclipseTime = data[2];
         deltaT = Double.parseDouble(data[3]);
         lunationNumber = Integer.parseInt(data[4]);
         sarosNumber = Integer.parseInt(data[5]);
         eclipseType = data[6];
         quincenaSolarEclipse = data[7];
         gamma = Double.parseDouble(data[8]);
         penumbralMagnitude = Double.parseDouble(data[9]);
         umbralMagnitude = Double.parseDouble(data[10]);
         latitude = data[11];
         longitude = data[12];
         penumbralEclipseDuration = Double.parseDouble(data[13]);
         partialEclipseDuration = Double.parseDouble(data[14]);
         totalEclipseDuration = Double.parseDouble(data[15]);
    }

    // Getters and Setters
    public String getCalendarDate() {
        return calendarDate;
    }

    public String getEclipseTime() {
        return eclipseTime;
    }




    @Override
    public String toString() {
        return "LunarEclipse{" +
                "catalogNumber='" + catalogNumber + '\'' +
                ", calendarDate='" + calendarDate + '\'' +
                ", eclipseTime='" + eclipseTime + '\'' +
                ", deltaT=" + deltaT +
                ", lunationNumber=" + lunationNumber +
                ", sarosNumber=" + sarosNumber +
                ", eclipseType='" + eclipseType + '\'' +
                ", quincenaSolarEclipse='" + quincenaSolarEclipse + '\'' +
                ", gamma=" + gamma +
                ", penumbralMagnitude=" + penumbralMagnitude +
                ", umbralMagnitude=" + umbralMagnitude +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", penumbralEclipseDuration=" + penumbralEclipseDuration +
                ", partialEclipseDuration=" + partialEclipseDuration +
                ", totalEclipseDuration=" + totalEclipseDuration +
                '}';
    }
}
