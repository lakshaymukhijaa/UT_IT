package com.knoldus.questionTwoTest

import com.knoldus.questionTwo.ImplOfTrait
import org.scalatest.flatspec.AnyFlatSpec

class ImplOfTraitTest extends AnyFlatSpec {

  "number" should "be valid if number is 0" in {
    val palindrome = new ImplOfTrait()
    assert(palindrome.isPallindrome(0))
  }

  "number" should "be valid if number is palindrome number" in {
    val palindrome = new ImplOfTrait()
    assert(palindrome.isPallindrome(111))
  }

  "number" should "invalid if it is negative" in {
    val palindrome= new ImplOfTrait()
    assert(!palindrome.isPallindrome(-213))
  }

  "number" should "invalid if number is non palindrome" in {
    val palindrome = new ImplOfTrait()
    assert(!palindrome.isPallindrome(122))
  }

  "number" should "be valid " in {
    val factorial = new ImplOfTrait()
    assert(factorial.factorialOfValue(4)==24)
  }

  "number" should "be invalid" in {
    val factorial = new ImplOfTrait()
    assert(!(factorial.factorialOfValue(5)==123))
  }

  "number" should "be valid if number is zero" in {
    val factorial = new ImplOfTrait()
    assert(factorial.factorialOfValue(0)==1)
  }
}


