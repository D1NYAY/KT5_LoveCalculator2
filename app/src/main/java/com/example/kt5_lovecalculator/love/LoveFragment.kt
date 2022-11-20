package com.example.kt5_lovecalculator.love

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kt5_lovecalculator.App
import com.example.kt5_lovecalculator.board.LoveModel
import com.example.kt5_lovecalculator.databinding.FragmentLoveBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveFragment : Fragment() {

    private lateinit var binding: FragmentLoveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoveBinding.inflate(inflater)
        return binding.root
        initClickers()
    }

    private fun initClickers(){
        with(binding){
            btnCalculate.setOnClickListener {
                App.api.calculateLove(firstEt.text.toString(),secondEt.text.toString()).enqueue(object : Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if(response.isSuccessful){
                            Log.e("ololo", "onResponse: ${response.body()?.percentage}", )
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}", )
                    }

                })
            }
        }
    }

}