/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import java.util.ArrayList;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import java.util.stream.IntStream;
/**
 *
 * @author nishc
 */
public class Population {
    ArrayList<Schedule> schedules;

    public Population(int size , Data data) {
        schedules=new ArrayList<Schedule>(size);
        IntStream.range(0,size).forEach(x-> schedules.add(new Schedule(data).initialize()));
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
    
    public Population sortByFitness()
    {
        schedules.sort((schedule1,schedule2)->{
        int returnValue=0;
        if(schedule1.getFitness() > schedule2.getFitness() )returnValue=-1;
        else if(schedule1.getFitness()<schedule2.getFitness()) returnValue =1;
        return returnValue;
    });
        return this ;
    }
    
}
