package codesmith.adventskalender;

public class OverallResult {
    /**
     * Class for Saving Server Results
     */
    String user_name;
    String solved_days;
    String trials;


    OverallResult(String user_name, String solved_days, String trials){
        this.user_name=user_name;
        this.solved_days=solved_days;
        this.trials=trials;
    }
}
