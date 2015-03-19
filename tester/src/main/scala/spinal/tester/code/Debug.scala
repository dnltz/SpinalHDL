/*
 * SpinalHDL
 * Copyright (c) Dolu, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package spinal.tester.code

import spinal.core
import spinal.core._


object Debug {


  class TopLevel extends Component {
    val io = new Bundle {
      val input = in UInt (4 bit)
      val output = out UInt (4 bit)
    }

    var carry = Bool(false)
    for (i <- 0 until 4) {
      when(io.input(i)) {
        carry \= Bool(true)
      }
      io.output(i) := io.input(i) & carry
    }
  }


  def main(args: Array[String]) {
    println("START")
    core.SpinalVhdl(new TopLevel)
    println("DONE")
  }

}
