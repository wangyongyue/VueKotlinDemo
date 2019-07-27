package com.example.vuekotlindemo.Model

import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.vue_kotlin.*
import com.example.vuekotlindemo.*
import com.example.vuekotlindemo.R

class EditorModel:  Vue() {

    override fun v_viewController(): Class<Any>? {
        return Main2Activity::class.java as Class<Any>
    }

    override fun v_start() {
        super.v_start()

        var items = mutableListOf<VueData>()
        for (i in 1..12){
            items.add(EditorData("今天晴朗$i"))
        }
        this.v_array(arrayID,{

            return@v_array items
        })
        this.v_index(indexID,{ it:Int ->


        })


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