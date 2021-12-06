package com.knoldus.db

import com.knoldus.models.User
import scala.collection.immutable.HashMap

class UserReadDto {
  val lakshayEmployee: User = User("Lakshay","Mukhija",21,600000,"Software Developer","Knoldus","lakshay.mukhija@knoldus.com")
  val arjunEmployee: User = User("Arjun","Sharma",26,500000,"Software Developer","OLA","arjun.sharma@ola.in")

  val users: HashMap[String,User] = HashMap("Lakshay"-> lakshayEmployee,"Arjun"-> arjunEmployee)

  def getUserByName(name: String): Option[User] = users.get(name)


}
