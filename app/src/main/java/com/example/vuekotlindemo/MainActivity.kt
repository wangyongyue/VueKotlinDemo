package com.example.vuekotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.vue_kotlin.*
import com.example.vuekotlindemo.Model.ButtonModel
import com.example.vuekotlindemo.Model.EditorModel
import com.example.vuekotlindemo.Model.TextModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addActivity()

        var arrayVue = Vue()

        var holders = mapOf<Int,String>(
            R.layout.layout_item to RUserViewHolder::class.java.toString()
        )


        recyler.layoutManager = LinearLayoutManager(this)
        var ad =  RAdapter(holders)
        ad.v_list(arrayVue)
        recyler.adapter = ad

        arrayVue.v_list(true,{

            val list = listOf("text 使用","button 使用","editorText 使用")
            var items = mutableListOf<VueData>()
            for (value in list){
                items.add(UserData(value))
            }
            return@v_list items
        })

        ad.v_didSelect {

            if (it == 0){
                Router.push(TextModel.getActivity(),TextModel.toString())

            }else if (it == 1){
                Router.push(ButtonModel.getActivity(),ButtonModel.toString())

            }else if (it == 2){
                Router.push(EditorModel.getActivity(),EditorModel.toString())

            }

        }




    }

    override fun onDestroy() {
        super.onDestroy()
        removeActivity()
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

                v_selectOb.v_on?.invoke()

            }

        }

    }

}
