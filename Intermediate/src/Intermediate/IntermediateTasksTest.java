package Intermediate;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IntermediateTasksTest{
    @org.junit.Test
    public void uniqueSumTest(){
        int total = IntermediateTasks.uniqueSum(1,3,2);
        assertEquals(6,total);
    }

    @org.junit.Test
    public void tooHotTest(){
        assertTrue(IntermediateTasks.tooHot(95,true));
    }

    @org.junit.Test
    public void searchForNameThatExits(){
        assertTrue(IntermediateTasks.searchName("Atila").getName().equalsIgnoreCase("Atila"));
    }

    @org.junit.Test
    public void searchForNameThatDoesntExits(){
        assertTrue(IntermediateTasks.searchName("Timmey") == null);
    }

    @org.junit.Test
    public void initialisePeopleTest(){
        ArrayList<Person> people = IntermediateTasks.intialisePeople();
        assertTrue(people.size() == 3);
    }

    @org.junit.Test
    public void blackjackTest(){
        int result = IntermediateTasks.blackjack(22,21);
        assertEquals(21,result);
    }

}