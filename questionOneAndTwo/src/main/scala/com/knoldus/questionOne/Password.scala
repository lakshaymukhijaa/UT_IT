package com.knoldus.questionOne

/* Defining a class with a method for checking the password entered passes all the requirements i.e.,
* length of password should be between 8-15, password should contain at least -
* one uppercase, lowercase, digit and special symbol and no blank space should be there
*/
class Password {
  def isPasswordValid(InputPassword:String):
  Boolean=
    InputPassword.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,15}$")

}
