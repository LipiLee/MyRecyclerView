package com.lipisoft.myrecyclerview

object Manager {
    val update = 0
    val list : MutableList<Packet> = mutableListOf()

    fun add(packet: Packet) {
        list.add(packet)
    }
}