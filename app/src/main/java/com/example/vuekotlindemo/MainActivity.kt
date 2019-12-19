package com.example.vuekotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.vue_kotlin.*
import com.example.vuekotlindemo.Model.*
import kotlinx.android.synthetic.main.activity_main.*
val arrayID = "arrayID"
val indexID = "indexID"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        addActivity()

        Cells().registerAllCell()

        var vue = Main()
        recyler.layoutManager = LinearLayoutManager(this)
        var ad =  RAdapter()
        recyler.adapter = ad

        ad.v_array(arrayID,vue)
        ad.v_index(indexID,vue)
        vue.v_start()




    }

    override fun onDestroy() {
        super.onDestroy()
        removeActivity()
    }
}
class Main:Vue(){

    override fun v_start() {
        super.v_start()

        val list = listOf("text 使用","button 使用","editorText 使用")
        var items = mutableListOf<VueData>()
        for (value in list){
            items.add(UserData(value))
        }
        this.v_array(arrayID,{

            return@v_array items
        })
        this.v_index(indexID,{ it:Int ->

            if (it == 0){
                Router.push(TextModel())

            }else if (it == 1){
                Router.push(ButtonModel())

            }else if (it == 2){
                Router.push(EditorModel())
            }

        })


    }
}


class UserData(var name:String): VueData {

    override val layoutIdentity: Int
        get() = R.layout.layout_item

    override var v_identifier: Int = 0



}
class RUserViewHolder(viewItem: View) : RHolder(viewItem){

    val textView: TextView = viewItem.findViewById(R.id.text)

    override fun setData(item: VueData){

        if (item is UserData){

            var model = item as? UserData
            textView.setText(model?.name)


            textView.setOnClickListener {

                model?.v_identifier = 1

                v_to()

            }

        }

    }

}
