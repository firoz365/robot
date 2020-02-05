package com.farnborough.robot;

import java.util.Arrays;

public enum Action {
    PLACE,
    MOVE,
    LEFT,
    RIGHT,
    REPORT ;

    public static Action getByName(String name){
        return Arrays.stream(Action.values()).filter(e-> e.name().equals( name))
                .findFirst()
                .orElseThrow(()-> new RuntimeException(String.format("No action found for action %s" , name)));
    }
}
