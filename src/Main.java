import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Loader l = new Loader();
        LunarStack lunarStack= l.loadLunar();
        SolarQueue solarQueue = l.loadSolar();
        SolarEclipse[] se = solarQueue.topThree();
        for (int i = 0; i < 3; i++) {
            System.out.println(se[i]);
        }
//        System.out.println(solarQueue.dayTimeSolarEclipse());
        System.out.println(solarQueue.solarEclipseInDayVsNight());
        System.out.println(lunarStack.lunarEclipseInDayVsNight() );

    }

    public static boolean isBetween8amTo6pm(String Time){
        LocalTime time= LocalTime.parse(Time);
        return time.isBefore(LocalTime.parse("18:00:00")) && time.isAfter(LocalTime.parse("08:00:00"));
    }
}