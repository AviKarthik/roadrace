//Avinash Karthik
//18 November 2024
//RoadRace Project
//CSA Period 1

public class racer {
    //time atribute and sex attribute
    int time;
    String sex;

    //standard constructor
    public racer(int time, String sex){
        this.time = time;
        this.sex = sex;
    }

    //standard getters
    public int getTime(){
        return this.time;
    }

    public String getSex(){
        return this.sex;
    }

    //standard setters
    public void setTime(int time){
        this.time = time;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    //standard toString
    public String toString(){
        return "" + this.time;
    }


}
