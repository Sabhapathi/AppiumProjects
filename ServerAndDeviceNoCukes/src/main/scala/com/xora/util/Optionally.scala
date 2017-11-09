package com.xora.util

/**
 * Wrap the code with optionally wherever exceptions has to be ignored
 */
trait Optionally {

  def optionally[T >: AnyRef](fun: => T): T = {
    try {
      fun
    } catch {
      case e: Exception => print("Failed execute code passed to optionally ", e)
      null
    }
  }

}
