package com.example.vuekotlindemo.Model

import com.example.vue_kotlin.Vue
import com.example.vuekotlindemo.R
import com.example.vuekotlindemo.RUserViewHolder

class Cells {

    public fun registerAllCell(){

        Vue.register(R.layout.layout_item, RUserViewHolder::class.java.toString())
        Vue.register(R.layout.layout_button, RButtonViewHolder::class.java.toString())
        Vue.register(R.layout.layout_editor, REditorViewHolder::class.java.toString())
    }
}