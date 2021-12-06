package com.knoldus.questionTwo

/* In this class we are extending the Trait and writing the body of the methods */
class ImplOfTrait extends DefinitionOfTrait {

  def isPallindrome(inputNumber: Int): Boolean = {
    var reverseNumber=0
    var temporaryNumber = inputNumber
    while(temporaryNumber!=0)
      {
        var digit = temporaryNumber % 10
        reverseNumber = reverseNumber * 10 + digit
        temporaryNumber= temporaryNumber /10
      }
      if(reverseNumber == inputNumber) {
        true
      }
      else {
        false
      }

  }

  def factorialOfValue(inputNumber: Int): Int = {
    var factorial=1
    var temporaryNumber =1
    while(temporaryNumber <= inputNumber) {
      factorial = factorial * temporaryNumber
      temporaryNumber = temporaryNumber + 1
    }
    return factorial
  }
}
