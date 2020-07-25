package com.example.sunnyweather.logic



import androidx.lifecycle.liveData
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    //liveData函数可以自动构建并返回一个LiveData对象，然后再它的代码块中提供一个挂起函数的上下文，
    //这样我们就可以在liveData()函数的代码块中调用任意的挂起函数了
    fun searchPlaces(query : String) = liveData(Dispatchers.IO) {
        val result = try {
            //调用SunnyWeatherNetwork.searchPlaces(query)搜索城市数据
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status=="ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e : Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}