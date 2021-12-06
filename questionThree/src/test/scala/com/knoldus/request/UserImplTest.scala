package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* we are mocking UserValidator upon which UserImpl depends,
* Then, While creating an object for UserImpl class we passed on the mocked parameter.
* And, then we are matching our arguments combinations by using stub methods (when, thenReturn) using Mockito functions.
* Finally, we are creating a variable in which we are accessing the createUser method
* with the help of object created, then in the parameters we are passing values
 */
class UserImplTest extends org.scalatest.flatspec.AnyFlatSpec{
  val mockedUserValidate = mock[UserValidator]
  val lakshayUser : User = User("Lakshay", "mukhija", 21, 6000000, "Software Developer" ,"Knoldus", "lakshay.mukhija@knoldus.com")
  val rishabhUser : User = User("Rishabh", "jain", 24, 500000000, "Software Developer" ,"jain bhandar", "rishabh.jain@gmail.com")

  "User" should "be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(lakshayUser)) thenReturn(true)
    val result = userImpl.createUser((lakshayUser))
    assert(!result.isEmpty)
  }

  "User" should "be not be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(rishabhUser)) thenReturn(false)
    val result = userImpl.createUser((rishabhUser))
    assert(result.isEmpty)
  }

}
