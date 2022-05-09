package serenityswag.authentication;


import lombok.Getter;
import lombok.Setter;

/*
standard_user
locked_out_user
problem_user
performance_glitch_user
*/
@Getter
public enum User {

  STANDARD_USER("standard_user", "secret_sauce", "a standard user"),
  LOCK_OUT_USER("standard_user", "secret_sauce", "a user with locked accound"),
  PROBLEM_USER("problem_user", "secret_sauce", "a problem user"),
  PERFORMANCE_GLITCH_USER("standard_user", "secret_sauce", "a performance glitch user");

  private final String username;
  private final String password;
  private final String description;

  User(String username, String password, String description) {
    this.username = username;
    this.password = password;
    this.description = description;
  }

}
