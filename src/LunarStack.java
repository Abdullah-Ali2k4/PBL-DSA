public class LunarStack {
    private static class Node{
        LunarEclipse data;
        Node next;
        Node(LunarEclipse data){
            this.data=data;
            next=null;
        }
        Node(LunarEclipse data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node top;
    private int size;
    public void push(LunarEclipse data){
        size++;
        if (top==null){
            top=new Node(data);
            return;
        }
        top=new Node(data,top);

    }
    public LunarEclipse pop(){
        if (size == 0) throw new IllegalArgumentException("Stack is empty");
        LunarEclipse temp=top.data;
        top=top.next;
        size--;
        return temp;
    }
    public int size(){return size;}
    public LunarEclipse peek(){
        if (size == 0) throw new IllegalArgumentException("Stack is empty");
        return top.data;
    }
    int findLunarEclipse(String year){
        LunarStack lunarEclipse=new LunarStack();
        Node temp=top;
        while (temp.next!=null){
            if(temp.data.getCalendarDate().contains(year) && !temp.data.getCalendarDate().contains("-")){
                lunarEclipse.push(temp.data);
            }
        temp=temp.next;
        }
        return lunarEclipse.size();
    }
    EclipsesData lunarEclipseInDayVsNight(){
        int inDay=0,inNight=0;
        Node temp=top;
        while (temp!=null){
            if(Main.isBetween8amTo6pm(temp.data.getEclipseTime())) inDay++;
            else inNight ++;
            temp=temp.next;
        }

        return new EclipsesData("lunar",inDay,inNight);
    }
    public String toString(){
        Node temp=top;
        String r="";
        while (temp!=null){
            r+=temp.data.toString()+"\n";
            temp=temp.next;
        }
        return r;
    }

}
