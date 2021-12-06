package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* we are mocking CompanyValidator upon which CompanyImpl depends,
* Then, While creating an object for CompanyImpl class we passed on the mocked parameter.
* And, then we are matching our arguments combinations by using stub methods (when, thenReturn) using Mockito functions.
* Finally, we are creating a variable in which we are accessing the createCompany method
* with the help of object created, then in the parameters we are passing values
 */
class CompanyImplTest extends org.scalatest.flatspec.AnyFlatSpec {
  val mockedCompanyValidate = mock[CompanyValidator]
  val knoldusCompany: Company = Company("knoldus", "knoluds@gmail.com", "Noida")
  val googleCompany: Company = Company("google", "google@gmail.com", "Noida")

  "Company" should "be created" in{
    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(knoldusCompany)) thenReturn(true)
    val result = companyImpl.createCompany((knoldusCompany))
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in{
    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(googleCompany)) thenReturn(false)
    val result = companyImpl.createCompany((googleCompany))
    assert(result.isEmpty)
  }
}
