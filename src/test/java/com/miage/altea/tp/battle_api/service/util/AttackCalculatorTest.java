package com.miage.altea.tp.battle_api.service.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackCalculatorTest {
    private AttackCalculator calculator = AttackCalculator.getInstance();

    @Test
    public void calculateDamageTest(){
        var damage= calculator.calculateDamages(6,15, 10);
        var expectedDamage = 7;
        assertEquals(expectedDamage, damage );
    }
}
