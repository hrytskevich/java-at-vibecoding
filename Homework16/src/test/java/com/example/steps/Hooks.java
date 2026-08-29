package com.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void printScenarioName(Scenario scenario) {
        System.out.println("НАЗВАНИЕ СЦЕНАРИЯ: " + scenario.getName());
    }

    @After
    public void printScenarioStatus(Scenario scenario) {
        System.out.println(scenario.isFailed()?"СЦЕНАРИЙ УПАЛ":"СЦЕНАРИЙ ПРОШЁЛ");
    }
}
