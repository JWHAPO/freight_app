package com.bomi.hapo.freight_app.ui.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.model.Car

/**
 *
 * Created by JWHAPO
 * -19. 5. 7 오후 11:14
 */
data class CarGridAdapter (var cars:List<Car>, var activity:Activity) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view : View = View.inflate(activity, R.layout.car_grid_row,null)
        val car_grid_row_car_iv = view.findViewById<ImageView>(R.id.car_grid_row_car_iv)
        val car_grid_row_name_tv = view.findViewById<TextView>(R.id.car_grid_row_name_tv)


        car_grid_row_name_tv.text = cars[position].description

        return view
    }

    override fun getItem(position: Int): Any {
        return cars[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return cars.size
    }

}