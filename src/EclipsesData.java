public class EclipsesData {
    private String eclipseType;
    private int dayTimeEclipse;
    private int nightTimeEclipse;
    private String comparison;

    EclipsesData(String eclipseType,int dayTimeEclipse,int nightTimeEclipse){
        this.eclipseType=eclipseType;
        this.dayTimeEclipse=dayTimeEclipse;
        this.nightTimeEclipse=nightTimeEclipse;
        if (dayTimeEclipse>nightTimeEclipse)
            comparison=eclipseType.toUpperCase()+" ECLIPSES occur more in day than in night, in the given data eclipse occurred "+(dayTimeEclipse-nightTimeEclipse)+" times more in day time";
        else
            comparison=eclipseType.toUpperCase()+" ECLIPSES occur more in night than in day, in the given data eclipse occurred "+(nightTimeEclipse-dayTimeEclipse)+" times more in night time";
    }

    public String getComparison() {
        return comparison;
    }
    public String toString(){
        return comparison;
    }
    public int getNightTimeEclipse() {
        return nightTimeEclipse;
    }

    public int getDayTimeEclipse() {
        return dayTimeEclipse;
    }
}
