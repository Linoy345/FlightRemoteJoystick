package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Blog

open class BaseViewModel : ViewModel() {
    protected var properties = MutableLiveData<ArrayList<Blog>>()
    protected var propertyList = arrayListOf<Blog>()

    fun add(blog: Blog){
        propertyList.add(blog)
        properties.value=propertyList
    }

    fun remove(blog: Blog){
        propertyList.remove(blog)
        properties.value=propertyList
    }

}