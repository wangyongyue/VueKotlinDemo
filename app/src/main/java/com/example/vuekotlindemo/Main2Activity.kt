package com.example.vuekotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.vue_kotlin.*
import com.example.vuekotlindemo.Model.ButtonModel
import com.example.vuekotlindemo.Model.RButtonViewHolder
import com.example.vuekotlindemo.Model.REditorViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_item.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        addActivity()

        button.setOnClickListener {

            Router.pop()
        }

        var v = vue
        recyler.layoutManager = LinearLayoutManager(this)
        var ad =  RAdapter()
        ad.v_array(arrayID,v)
        recyler.adapter = ad

        ad.v_index(indexID,v)
        v.v_start()


    }
    override fun onDestroy() {
        super.onDestroy()
        removeActivity()
    }
}




