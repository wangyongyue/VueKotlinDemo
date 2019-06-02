package com.example.vuekotlindemo.Model

import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.vue_kotlin.*
import com.example.vuekotlindemo.Main2Activity
import com.example.vuekotlindemo.Main2Interface
import com.example.vuekotlindemo.R
import com.example.vuekotlindemo.UserData

class EditorModel: Main2Interface {

    override val arrayVue: Vue = Vue()
    override val indexVue: Vue = Vue()

    companion object{

        fun getActivity(): Class<Any>{

            return Main2Activity::class.java as Class<Any>
        }

    }

    override fun startListen() {

        arrayVue.v_list(false,{


            var items = mutableListOf<VueData>()
            for (i in 1..12){
                items.add(EditorData("今天晴朗$i"))
            }

            return@v_list items
        })
        indexVue.v_index {


        }
    }


}
class EditorData(var name:String): VueData {

    override val layoutIdentity: Int
        get() = R.layout.layout_editor

    override var v_identifier: Int = 0



}
class REditorViewHolder(viewItem: View) : RHolder(viewItem){

    val editor: EditText = viewItem.findViewById(R.id.editor)
    val textView: TextView = viewItem.findViewById(R.id.text)

    override fun setData(item: VueData){

        if (item is EditorData){

            var model = item as? EditorData
            textView.setText(model?.name)
            editor.v_change {

                textView.setText(it)

            }




        }

    }

}