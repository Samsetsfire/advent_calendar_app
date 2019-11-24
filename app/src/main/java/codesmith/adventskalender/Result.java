package codesmith.adventskalender;

import java.util.Date;

public class Result {
    /**
     * Class for Saving Server Results
     */
    String user_name;
    String solved_date;
    String trials;


    Result(String user_name, String solved_date, String trials){
        this.user_name=user_name;

        this.solved_date=solved_date;
        this.trials=trials;
    }
}
