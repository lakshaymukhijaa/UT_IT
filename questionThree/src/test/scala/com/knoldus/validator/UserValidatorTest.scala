package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* we are mocking CompanyReadDto and EmailValidator upon which UserValidator depends,
* Then, While creating an object for UserValidator class we passed on the mocked parameter.
* And, then we are matching our arguments combinations by using stub methods (when, thenReturn) using Mockito functions.
* Finally, we are creating a variable in which we are accessing the userIsValid method
* with the help of object created, then in the parameters we are passing tanishkaEmployee
 */
class UserValidatorTest extends org.scalatest.flatspec.AnyFlatSpec {

  val lakshayEmployee : User = User("Lakshay", "Mukhija", 21, 600000, "Software Developer" ,"Knoldus", "lakshay.mukhija@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmail = mock[EmailValidator]


  "User" should "be a valid User because Company exist in DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(lakshayEmployee.companyName)) thenReturn (Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(lakshayEmployee.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(lakshayEmployee)
    assert(result)

  }

  "User" should "be a invalid because email is not valid" in{

    when(mockedCompanyReadDto.getCompanyByName(lakshayEmployee.companyName)) thenReturn (Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(lakshayEmployee.emailId)) thenReturn(false)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(lakshayEmployee)
    assert(!result)

  }

  "User" should "be a invalid because company does not exist in the DB " in{

    when(mockedCompanyReadDto.getCompanyByName(lakshayEmployee.companyName)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(lakshayEmployee.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(lakshayEmployee)
    assert(!result)

  }

  "User" should "be a invalid because company does not exist in the DB and email invalid" in{

    when(mockedCompanyReadDto.getCompanyByName(lakshayEmployee.companyName)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(lakshayEmployee.emailId)) thenReturn(false)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(lakshayEmployee)
    assert(!result)

  }

}
