package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    SimpleTask simpleTask = new SimpleTask(123, "Сдать домашнее задание");

    String topic = "Благоустройство";
    String project = "Замена брусчатки";
    String start = "Пятница, вторая половина дня (предположительно 15:00)";
    Meeting meeting = new Meeting(123, topic, project, start);

    String[] tasks = {"Проснуться", "Умыться", "Позавтракать"};
    Epic epic = new Epic(123, tasks);


    //---------------------------SIMPLE TASK tests----------------------------------------------
    @Test
    public void shouldFindInSimpleTaskOneWordPositive() {
        String query = "задание";
        Boolean expected = true;
        Assertions.assertEquals(expected, simpleTask.matches(query));
    }

    @Test
    public void shouldFindInSimpleTaskOneWordNegative() {
        String query = "завтра";
        Boolean expected = false;
        Assertions.assertEquals(expected, simpleTask.matches(query));
    }

    @Test
    public void shouldFindInSimpleTaskOneCharPositive() {
        String query = "д";
        Boolean expected = true;
        Assertions.assertEquals(expected, simpleTask.matches(query));
    }

    @Test
    public void shouldFindInSimpleTaskOneCharNegative() {
        String query = "О";
        Boolean expected = false;
        Assertions.assertEquals(expected, simpleTask.matches(query));
    }

    @Test
    public void shouldNotFindInSimpleTaskIfEmpty() {
        String query = "";
        Boolean expected = false;
        Assertions.assertEquals(expected, simpleTask.matches(query));
    }

    //---------------------------EPIC tests----------------------------------------------
    @Test
    public void shouldFindInEpicOneWordPositive() {
        String query = "завтра";
        Boolean expected = true;
        Assertions.assertEquals(expected, epic.matches(query));
    }

    @Test
    public void shouldFindInEpicOneWordNegative() {
        String query = "сегодня";
        Boolean expected = false;
        Assertions.assertEquals(expected, epic.matches(query));
    }

    @Test
    public void shouldFindInEpicOneCharPositive() {
        String query = "У";
        Boolean expected = true;
        Assertions.assertEquals(expected, epic.matches(query));
    }

    @Test
    public void shouldFindInEpicOneCharNegative() {
        String query = "Ё";
        Boolean expected = false;
        Assertions.assertEquals(expected, epic.matches(query));
    }

    @Test
    public void shouldNotFindInEpicIfEmpty() {
        String query = "";
        Boolean expected = false;
        Assertions.assertEquals(expected, epic.matches(query));
    }

    //---------------------------MEETING tests----------------------------------------------
    @Test
    public void shouldFindInMeetingOneWordPositive() {
        String query = "15:00";
        Boolean expected = true;
        Assertions.assertEquals(expected, meeting.matches(query));
    }

    @Test
    public void shouldFindInMeetingOneWordNegative() {
        String query = "сегодня";
        Boolean expected = false;
        Assertions.assertEquals(expected, meeting.matches(query));
    }

    @Test
    public void shouldFindInMeetingOneCharPositive() {
        String query = "0";
        Boolean expected = true;
        Assertions.assertEquals(expected, meeting.matches(query));
    }

    @Test
    public void shouldFindInMeetingOneCharNegative() {
        String query = "Ё";
        Boolean expected = false;
        Assertions.assertEquals(expected, simpleTask.matches(query));
    }

    @Test
    public void shouldNotFindInMeetingIfEmpty() {
        String query = "";
        Boolean expected = false;
        Assertions.assertEquals(expected, simpleTask.matches(query));
    }
}
