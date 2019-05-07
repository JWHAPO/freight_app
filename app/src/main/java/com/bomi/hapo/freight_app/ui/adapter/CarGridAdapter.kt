package com.bomi.hapo.freight_app.ui.adapter

import android.app.Activity
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bomi.hapo.freight_app.R
import com.bomi.hapo.freight_app.databinding.CarGridRowBinding
import com.bomi.hapo.freight_app.model.Car

/**
 *
 * Created by JWHAPO
 * -19. 5. 7 오후 11:14
 */
data class CarGridAdapter (var cars:List<Car>, var activity:Activity) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var binding : CarGridRowBinding

        if(convertView == null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(activity),R.layout.car_grid_row,parent,false)
            binding.root.tag = binding
        }else{
            binding = convertView.tag as CarGridRowBinding
        }

        return binding.root
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