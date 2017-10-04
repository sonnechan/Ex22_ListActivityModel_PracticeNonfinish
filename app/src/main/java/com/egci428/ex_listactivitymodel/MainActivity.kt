package com.egci428.ex_listactivitymodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.content.Context
import android.graphics.Color
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.*
//import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.course_item.view.*


class MainActivity : AppCompatActivity() {

    val DETAIL_REQUEST_CODE = 1001
    protected var data: ArrayList<Course>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = DataProvider.getData()

        val courseArrayAdapter = CourseArrayAdapter(this,0, data!!)
        list.setAdapter(courseArrayAdapter)

        list.setOnItemClickListener { adapterView, view, position, _ ->

            val course = data!!.get(position)
            displayDetail(course, position)
        }

    }

    private fun displayDetail(course: Course, impos: Int) {

        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra(data!!.toString(),descriptionText.text.toString())
        intent.putExtra(data!!.toString(),courseNoText.text.toString())
        intent.putExtra(data!!.toString(),creditsText.text.toString())

        startActivity(intent)


    }

    private class CourseArrayAdapter(var context: Context, resource: Int, var objects: ArrayList<Course>) : BaseAdapter() {

        //val view: View
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getItem(position: Int): Any {
           return objects[position]
        }

        override fun getCount(): Int {
            return objects.size
    }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View
            val course = objects[position]
            if(convertView == null){ //first time loading inflator
                val layoutInflator = LayoutInflater.from(parent!!.context)  //parent!! means not null
                view = layoutInflator.inflate(R.layout.course_item,parent,false)
                val viewHolder = ViewHolder(view.titleText, view.imageCourse) //condition
                view.tag = viewHolder
            } else {

                view = convertView

            }

            val viewHolder = view.tag as ViewHolder //define under the function not condition
            viewHolder.titleTextView.text = course.title
            val imgpos = position%3+1
            val res = context.resources.getIdentifier("image1010" + imgpos,"drawable", context.packageName)

            viewHolder.imageCourse.setImageResource(res)

            return view
        }
        private class ViewHolder(val titleTextView: TextView, val imageCourse: ImageView) //keep component inside the row
    }
}
