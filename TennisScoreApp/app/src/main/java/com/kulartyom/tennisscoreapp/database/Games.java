package com.kulartyom.tennisscoreapp.database;


import com.orm.SugarRecord;

/**
 * Created by KulArtyom on 30.05.2016.
 */

public class Games extends SugarRecord {

    private String name_player_one;
    private String name_player_two;
    private String sets_player_one;
    private String sets_player_two;

    @Override
    public String toString() {
        return "Game:" + "\n" +
                name_player_one + ": " + sets_player_one + "\n" +
                name_player_two + ": " + sets_player_two + "\n";

    }


    public Games() {
    }

    public Games(String name_player_one, String name_player_two, String sets_player_one, String sets_player_two) {
        this.name_player_one = name_player_one;
        this.name_player_two = name_player_two;
        this.sets_player_one = sets_player_one;
        this.sets_player_two = sets_player_two;
    }
}
