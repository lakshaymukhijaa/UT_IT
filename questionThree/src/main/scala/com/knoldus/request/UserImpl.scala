package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator

class UserImpl(userValidator: UserValidator) {
  /* In the below method we are checking if the
   user's company should not exit in the DB or not
   and email is valid
   then create the user with the email
   else No
   */
  def createUser(user: User): Option[String] = {
    if (userValidator.userIsValid(user)) Option(user.emailId)
    else None
  }

}
