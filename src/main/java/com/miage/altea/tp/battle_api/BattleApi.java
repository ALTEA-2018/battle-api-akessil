package com.miage.altea.tp.battle_api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BattleApi {
    public static void main(String... args){ SpringApplication.run(BattleApi.class, args); }
}
