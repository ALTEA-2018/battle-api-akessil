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
}
