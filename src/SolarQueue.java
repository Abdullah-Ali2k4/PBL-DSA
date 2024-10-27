import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SolarQueue {
    private static class Node{
        private SolarEclipse data;
        private Node prev;
        private Node next;
        public Node(SolarEclipse data){
            this.data=data;
            this.next =this;
            this.prev=this;
        }
        public Node(SolarEclipse data,Node next, Node prev){
            this.data=data;
            this.next =next;
            this.prev=prev;
        }
    }
    Node head=new Node(null);
    int size;
    public void enqueue(SolarEclipse solarEclipse){
        size++;
        head.prev.next = new Node(solarEclipse,head,head.prev.next);
        head.prev = head.prev.next;
    }
    public int size(){return size;}
    public SolarEclipse dequeue(){
        if(size==0) throw new IllegalArgumentException("Queue is empty");
        SolarEclipse temp=head.next.data;
        head.next=head.next.next;
        head.next.prev=head;
        size--;
        return temp;
    }
    public SolarEclipse first(){return head.next.data;}

    public SolarEclipse[] topThree(){
        SolarEclipse[] top3 = new SolarEclipse[3];
        Node temp =head.next;
        for (int i = 0; i < 3; i++) top3[i]=new SolarEclipse(Integer.MIN_VALUE);
        while (temp!=head){
            for (int i = 0; i < 3; i++) {
                if (temp.data.getEclipseMagnitude()>top3[i].getEclipseMagnitude()){
                    for ( int j = i ; j<2 ; j++) {
                        top3[j+1]=top3[j];
                    }
                    top3[i]=temp.data;
                    break;
                }
            }
            temp=temp.next;
        }
        return top3;
    }
    int dayTimeSolarEclipse(){
        int count=0;
        Node temp=head.next;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy MMMM d");

        LocalDate upper = LocalDate.parse("2000 January 1", dateFormat);
        LocalDate lower = LocalDate.parse("1994 December 31", dateFormat);

        while (temp!=head){
            try {
                LocalDate date = LocalDate.parse(temp.data.getCalendarDate(), dateFormat);
                if (date.isBefore(upper) && date.isAfter(lower) && Main.isBetween8amTo6pm(temp.data.getEclipseTime()))
                        count++;

            } catch (DateTimeParseException ignored) {
            }
            temp=temp.next;
        }
        return count;
    }

    EclipsesData solarEclipseInDayVsNight(){
        int dayTime=0;
        int nightTime=0;
        Node temp= head.next;
        while (temp!=head) {
            if (Main.isBetween8amTo6pm(temp.data.getEclipseTime()))
               dayTime++;
            else
                nightTime++;
            temp = temp.next;
        }
        return new EclipsesData("Solar",dayTime,nightTime);
    }
    int findSolarEclipse(String year) {
        int count=0;
        Node temp = head.next;
        while (temp.next != head) {
            if (temp.data.getCalendarDate().contains(year) && !temp.data.getCalendarDate().contains("-")) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

}

