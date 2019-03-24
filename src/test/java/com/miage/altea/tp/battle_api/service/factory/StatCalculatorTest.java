package com.miage.altea.tp.battle_api.service.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatCalculatorTest {
    private StatCalculator calculator = StatCalculator.getInstance();

    @Test
    public void calculateAttackTest(){
        var attack= calculator.calculateAttack(6,55);
        var expectedAttack = 11;
        assertEquals(expectedAttack, attack );
    }

    @Test
    public void calculateDefenseTest(){
        var defense= calculator.calculateDefense(6,40);
        var expectedDefense = 9;
        assertEquals(expectedDefense, defense );
    }

    @Test
    public void calculateSpeedTest(){
        var speed= calculator.calculateSpeed(6,90);
        var expectedSpeed = 15;
        assertEquals(expectedSpeed, speed );
    }

    @Test
    public void calculateHPTest(){
        var hp= calculator.calculateHP(6,35);
        var expectedHP = 20;
        assertEquals(expectedHP, hp );
    }
}
