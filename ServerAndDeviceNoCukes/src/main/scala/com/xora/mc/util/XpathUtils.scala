package com.xora.mc.util

object XpathUtils
{
  def hasCssClass(className: String): String =
  {
    "contains(concat(' ', normalize-space(@class), ' '), ' " + className + " ')"
  }
}


