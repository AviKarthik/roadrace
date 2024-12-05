//Avinash Karthik
//18 November 2024
//RoadRace Project
//CSA Period 1

import java.util.*;

public class Main {

    //function to take the given input, split into sex and time, create a racer using the
    //found values, and adding the racer to a list
    public static void takeInput(ArrayList<racer> list){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the racer's time(in seconds) and sex('M' or 'F') in this format: (time sex(M/F))");
        //stores the next int, cuts off at the space
        int time = input.nextInt();
        //starts at the space, stores the gender
        String gender = input.nextLine();
        //removes the extra space at the beginning
        gender = gender.substring(1);
        //creates a racer with the pulled time and sex
        racer r = new racer(time, gender);
        //adds the racer to given input list
        list.add(r);
    }

    public static ArrayList<racer> getRacers(){
        Scanner input = new Scanner(System.in);
        //creates array for racers to go into
        ArrayList<racer> racers = new ArrayList<>();
        //prompts for how many racers will be added
        System.out.println("How many racers will you input?: ");
        int count = input.nextInt();
        //loops for inputted amount of time
        while(count>0){
            //calls take input function to add the input to the racers list
            takeInput(racers);
            //decrement count so the loop doesn't loop forever
            count--;
        }
        //return list of racers
        return racers;
    }

    public static void sort(ArrayList<racer> list, ArrayList<racer> m, ArrayList<racer> f){
       //iterates thru the list and puts males and females in separate arraylists
        for(racer i : list){
            if(i.getSex().equals("F")){
                f.add(i);
            }
            else if(i.getSex().equals("M")){
                m.add(i);
            }
            else{
                System.out.println("no gender on most recent addition: ignored");
            }
        }
    }

    public static int ovr(ArrayList<racer> list){
        //outputs the fastest time in the given list
        //initializes fastest to largest possible value
        int fastest = 2147483647;
        //stores index of the smallest time
        int index = 0;
        //iterates through the list
        for (int i = 0; i < list.size(); i++) {
            //if the current time is faster than the previous fastest
            if(list.get(i).getTime() < fastest){
                //the new fastest becomes current time
                fastest = list.get(i).getTime();
                //stores new fastest index
                index = i;
            }
        }
        //removes fastest time from input list
        list.remove(index);
        //returns fastest time
        return fastest;
    }


    public static void main(String[] args) {
        //stores all the inputted racers in this array
        ArrayList<racer> racers = getRacers();
        //defines arrays for male and females
        ArrayList<racer> m = new ArrayList<>();
        ArrayList<racer> f = new ArrayList<>();
        //finds the fastest overall time, stores it, and removes it from the parent list
        int overall = ovr(racers);
        int temp1 = ovr(racers);
        //splits parent list into male and female
        sort(racers, m, f);
        //finds the fastest male
        int m1 = ovr(m);
        //finds the second fastest male
        int m2 = ovr(m);
        //finds the fastest female
        int f1 = ovr(f);
        int temp2 = ovr(f);
        //print all the times in the desired order
        System.out.println(overall);
        System.out.println(f1);
        System.out.println(m1);
        System.out.println(m2);
    }
}